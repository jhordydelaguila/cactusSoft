package cactussoft.capa4_persistencia.daoMySql;

import cactussoft.capa3_dominio.contratos.ICartaDAO;
import cactussoft.capa3_dominio.entidades.Carta;
import cactussoft.capa3_dominio.entidades.Categoria;
import cactussoft.capa3_dominio.entidades.Precio;
import cactussoft.capa3_dominio.entidades.Plato;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartaDAOMySql implements ICartaDAO {

    GestorJDBC gestorJDBC;

    public CartaDAOMySql(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int registrarPlato(Carta carta) throws SQLException {
        try {
            // funcion para eliminar el detalle de cartaplato
            String sentenciaSQL_eliminar = "DELETE FROM cartaplato WHERE cartaid = " + carta.getCartaid();
            PreparedStatement sentencia_elimina = gestorJDBC.prepararSentencia(sentenciaSQL_eliminar);
            sentencia_elimina.executeUpdate();

            // una vez eliminado se vuelve agregar los items del detalle de la carta.
            String sentenciaSQL_cartaplato = "INSERT INTO cartaplato (cartaid,platoid) VALUES(?,?) ";
            PreparedStatement sentencia_cartaplato;
            for (Plato plato : carta.getPlatos()) {
                sentencia_cartaplato = gestorJDBC.prepararSentencia(sentenciaSQL_cartaplato);
                sentencia_cartaplato.setInt(1, carta.getCartaid());
                sentencia_cartaplato.setInt(2, plato.getPlatoid());
                sentencia_cartaplato.executeUpdate();
            }
        } catch (Exception e) {
            throw new SQLException("No se puedo registrar los platos.");
        }
        return 1;
    }

    @Override
    public int modificar(Carta carta) throws SQLException {
        String sentenciaSQL = ""
                + " UPDATE carta  SET "
                + " nombre = ?"
                + " WHERE cartaid = ? && estado = 'A'";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, carta.getNombre());
        sentencia.setInt(2, carta.getCartaid());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificarPrecio(Carta carta) throws SQLException {
        String sentenciaSQL = ""
                + " UPDATE carta  SET "
                + " precioid = ? "
                + " WHERE cartaid = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, carta.getPrecio().getPrecioid());
        sentencia.setInt(2, carta.getCartaid());
        int registros_afectados = sentencia.executeUpdate();
        if (registros_afectados == 1) {
            PlatoDAOMySql platoDAOMySql = new PlatoDAOMySql(gestorJDBC);
            registros_afectados = platoDAOMySql.modificarPrecio(carta);
        }
        return registros_afectados;
    }

    @Override
    public Carta mostrar() throws SQLException {
        Carta carta = null;
        Plato plato = null;
        Precio precio = null;
        Categoria categoria = null;
        String sentenciaSQL_carta = ""
                + " SELECT c.cartaid, c.nombre,"
                + " f.precioid, f.nombre, f.accion, f.monto, f.estado"
                + " FROM carta c "
                + " INNER JOIN precio f ON f.precioid = c.precioid ";

        String sentenciaSQL_cartaplato = ""
                + " SELECT p.platoid, p.nombre, p.precio, p.preciofestivo, "
                + " cat.categoriaid, cat.nombre "
                + " FROM plato p "
                + " INNER JOIN categoria cat ON cat.categoriaid = p.categoriaid "
                + " INNER JOIN cartaplato cp ON cp.platoid = p.platoid "
                + " WHERE cp.cartaid = ";

        ResultSet resultadoCarta = gestorJDBC.ejecutarConsulta(sentenciaSQL_carta);
        if (resultadoCarta.next()) {
            carta = new Carta();
            carta.setCartaid(resultadoCarta.getInt("cartaid"));
            carta.setNombre(resultadoCarta.getString("nombre"));
            precio = new Precio();
            precio.setFestivoid(resultadoCarta.getInt("f.precioid"));
            precio.setNombre(resultadoCarta.getString("f.nombre"));
            precio.setAccion(resultadoCarta.getString("f.accion"));
            precio.setMonto(resultadoCarta.getDouble("f.monto"));
            precio.setEstado(resultadoCarta.getString("f.estado"));
            carta.setPrecio(precio);
            sentenciaSQL_cartaplato = sentenciaSQL_cartaplato + carta.getCartaid();
            ResultSet resultadoCartaPlato = gestorJDBC.ejecutarConsulta(sentenciaSQL_cartaplato);
            while (resultadoCartaPlato.next()) {
                plato = new Plato();
                plato.setPlatoid(resultadoCartaPlato.getInt("platoid"));
                plato.setNombre(resultadoCartaPlato.getString("nombre"));
                plato.setPrecio(resultadoCartaPlato.getDouble("precio"));
                plato.setPrecioCarta(resultadoCartaPlato.getDouble("preciofestivo"));
                categoria = new Categoria();
                categoria.setCategoriaid(resultadoCartaPlato.getInt("categoriaid"));
                categoria.setNombre(resultadoCartaPlato.getString("cat.nombre"));
                plato.setCategoria(categoria);
                carta.agregarPlato(plato);
            }
            resultadoCartaPlato.close();
        }
        resultadoCarta.close();
        return carta;
    }

    @Override
    public List<Plato> buscar(String nombre) throws SQLException {
        Carta carta = null;
        Plato plato = null;
        Precio precio = null;
        Categoria categoria = null;
        String sentenciaSQL_carta = ""
                + " SELECT c.cartaid, c.nombre,"
                + " f.precioid, f.nombre, f.accion, f.monto, f.estado "
                + " FROM carta c "
                + " INNER JOIN precio f ON f.precioid = c.precioid ";

        String sentenciaSQL_cartaplato = ""
                + " SELECT p.platoid, p.nombre, p.precio, p.preciofestivo, "
                + " cat.categoriaid, cat.nombre "
                + " FROM plato p "
                + " INNER JOIN categoria cat ON cat.categoriaid = p.categoriaid "
                + " INNER JOIN cartaplato cp ON cp.platoid = p.platoid "
                + " WHERE p.nombre LIKE '%" + nombre + "%' AND cp.cartaid = ";

        ResultSet resultadoCarta = gestorJDBC.ejecutarConsulta(sentenciaSQL_carta);
        if (resultadoCarta.next()) {
            carta = new Carta();
            carta.setCartaid(resultadoCarta.getInt("cartaid"));
            carta.setNombre(resultadoCarta.getString("nombre"));
            precio = new Precio();
            precio.setFestivoid(resultadoCarta.getInt("f.precioid"));
            precio.setNombre(resultadoCarta.getString("f.nombre"));
            precio.setAccion(resultadoCarta.getString("f.accion"));
            precio.setMonto(resultadoCarta.getDouble("f.monto"));
            precio.setEstado(resultadoCarta.getString("f.estado"));
            carta.setPrecio(precio);
            sentenciaSQL_cartaplato = sentenciaSQL_cartaplato + carta.getCartaid();
            ResultSet resultadoCartaPlato = gestorJDBC.ejecutarConsulta(sentenciaSQL_cartaplato);
            while (resultadoCartaPlato.next()) {
                plato = new Plato();
                plato.setPlatoid(resultadoCartaPlato.getInt("platoid"));
                plato.setNombre(resultadoCartaPlato.getString("nombre"));
                plato.setPrecio(resultadoCartaPlato.getDouble("precio"));
                plato.setPrecioCarta(resultadoCartaPlato.getDouble("preciofestivo"));
                categoria = new Categoria();
                categoria.setCategoriaid(resultadoCartaPlato.getInt("categoriaid"));
                categoria.setNombre(resultadoCartaPlato.getString("cat.nombre"));
                plato.setCategoria(categoria);
                carta.agregarPlato(plato);
            }
            resultadoCartaPlato.close();
        }
        resultadoCarta.close();
        return carta.getPlatos();
    }

    @Override
    public List<Categoria> buscarCategorias() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        Categoria categoria;
        String sentenciaCartaSQl = ""
                + " SELECT DISTINCT cat.categoriaid, cat.nombre "
                + " FROM carta c "
                + " INNER JOIN cartaplato cp ON cp.cartaid = c.cartaid "
                + " INNER JOIN plato p ON p.platoid = cp.platoid "
                + " INNER JOIN categoria cat ON cat.categoriaid = p.categoriaid ";

        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaCartaSQl);
        while (resultado.next()) {
            categoria = new Categoria();
            categoria.setCategoriaid(resultado.getInt("categoriaid"));
            categoria.setNombre(resultado.getString("nombre"));
            categorias.add(categoria);
        }
        return categorias;
    }

    @Override
    public List<Plato> buscarPlatoEnCategoria(String nombreDeCategoria, String nombreDePlato) throws SQLException {
        Carta carta = new Carta();
        Plato plato;
        String sentenciaSQL = ""
                + " SELECT "
                + " p.platoid, p.nombre, p.precio, p.preciofestivo "
                + " FROM carta c "
                + " INNER JOIN cartaplato cp on cp.cartaid = c.cartaid "
                + " INNER JOIN plato p on cp.platoid = p.platoid "
                + " INNER JOIN categoria cat ON p.categoriaid = cat.categoriaid "
                + " WHERE cat.nombre = '" + nombreDeCategoria + "' "
                + " AND p.nombre LIKE '%" + nombreDePlato + "%'";

        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            plato = new Plato();
            plato.setPlatoid(resultado.getInt("platoid"));
            plato.setNombre(resultado.getString("nombre"));
            plato.setPrecio(resultado.getDouble("precio"));
            plato.setPrecioCarta(resultado.getDouble("preciofestivo"));
            carta.agregarPlato(plato);
        }
        return carta.getPlatos();
    }

}
