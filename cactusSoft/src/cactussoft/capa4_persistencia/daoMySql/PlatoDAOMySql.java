package cactussoft.capa4_persistencia.daoMySql;

import cactussoft.capa3_dominio.contratos.IPlatoDAO;
import cactussoft.capa3_dominio.entidades.Carta;
import cactussoft.capa3_dominio.entidades.Categoria;
import cactussoft.capa3_dominio.entidades.Plato;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlatoDAOMySql implements IPlatoDAO {

    GestorJDBC gestorJDBC;

    public PlatoDAOMySql(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int ingresar(Plato plato) throws SQLException {
        String sentenciaSQL = "INSERT INTO plato (nombre, precio,descripcion,estado, categoriaid) "
                + "values (?,?,?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, plato.getNombre());
        sentencia.setDouble(2, plato.getPrecio());
        sentencia.setString(3, plato.getDescripcion());
        sentencia.setString(4, plato.getEstado());
        sentencia.setInt(5, plato.getCategoria().getCategoriaid());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Plato plato) throws SQLException {
        String sentenciaSQL = "UPDATE plato "
                + " SET nombre = ?, precio = ?, descripcion = ?, categoriaid = ?"
                + " WHERE platoid = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, plato.getNombre());
        sentencia.setDouble(2, plato.getPrecio());
        sentencia.setString(3, plato.getDescripcion());
        sentencia.setInt(4, plato.getCategoria().getCategoriaid());
        sentencia.setInt(5, plato.getPlatoid());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(Plato plato) throws SQLException {
        String sentenciaSQL = "UPDATE plato SET estado = ? WHERE platoid = " + plato.getPlatoid();
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, plato.getEstado());
        return sentencia.executeUpdate();
    }

    @Override
    public Plato buscar(int platoid) throws SQLException {
        Plato plato = null;
        String sentenciaSQL = ""
                + " SELECT  p.platoid, p.nombre, p.precio, p.preciofestivo ,p.descripcion, p.estado, "
                + " c.categoriaid, c.nombre as nombreCategoria "
                + " FROM plato p"
                + " INNER JOIN categoria c ON c.categoriaid = p.categoriaid "
                + " WHERE p.platoid = " + platoid;
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            plato = new Plato();
            plato.setPlatoid(resultado.getInt("platoid"));
            plato.setNombre(resultado.getString("nombre"));
            plato.setPrecio(resultado.getDouble("precio"));
            plato.setPrecioCarta(resultado.getDouble("preciofestivo"));
            plato.setDescripcion(resultado.getString("descripcion"));
            plato.setEstado(resultado.getString("estado"));
            Categoria categoria = new Categoria();
            categoria.setCategoriaid(resultado.getInt("categoriaid"));
            categoria.setNombre(resultado.getString("nombreCategoria"));
            plato.setCategoria(categoria);
        }
        resultado.close();
        return plato;
    }

    @Override
    public List<Plato> buscar(String nombre) throws SQLException {
        List<Plato> platos = new ArrayList<>();
        Plato plato;
        Categoria categoria;
        ResultSet resultado;
        String sentenciaSQL = "SELECT p.platoid, p.nombre, p.precio, p.preciofestivo, "
                + " p.descripcion, p.estado, "
                + " c.categoriaid, c.nombre nombreCategoria "
                + " FROM plato p "
                + " INNER JOIN categoria c ON c.categoriaid = p.categoriaid "
                + " WHERE p.estado <> 'E' AND p.nombre like '%" + nombre + "%'";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            plato = new Plato();
            plato.setPlatoid(resultado.getInt("platoid"));
            plato.setNombre(resultado.getString("nombre"));
            plato.setPrecio(resultado.getDouble("precio"));
            plato.setPrecioCarta(resultado.getDouble("preciofestivo"));
            plato.setDescripcion(resultado.getString("descripcion"));
            plato.setEstado(resultado.getString("estado"));
            categoria = new Categoria();
            categoria.setCategoriaid(resultado.getInt("c.categoriaid"));
            categoria.setNombre(resultado.getString("nombreCategoria"));
            plato.setCategoria(categoria);
            platos.add(plato);
        }
        resultado.close();
        return platos;
    }

    @Override
    public int modificarPrecio(Carta carta) throws SQLException {
        try {
            String sentenciaSQL = "UPDATE plato SET preciofestivo = ? WHERE platoid = ?";
            PreparedStatement sentencia;
            for (Plato plato : carta.getPlatos()) {
                sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
                sentencia.setDouble(1, plato.getPrecioCarta());
                sentencia.setInt(2, plato.getPlatoid());
                sentencia.executeUpdate();
            }
            return 1;
        } catch (Exception e) {
            throw new SQLException("No se pudo modificar el precio de los platos.\n" + "Intentelo de nuevo.");
        }
    }

    @Override
    public int total() throws SQLException {
        String sentenciaSQL = "SELECT COUNT(*) AS total FROM plato WHERE estado <> 'E'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        int total = 0;
        while (resultado.next()) {
            total = resultado.getInt("total");
        }
        resultado.close();
        return total;
    }

    @Override
    public List<Plato> buscarPlatosNoCarta(String nombre) throws SQLException {
        List<Plato> platos = new ArrayList<>();
        Plato plato = null;
        Categoria categoria = null;
        String sentenciaSQL = ""
                + " SELECT p.platoid, p.nombre, p.precio,p.preciofestivo,"
                + " cat.categoriaid, cat.nombre "
                + " FROM plato p "
                + " INNER JOIN categoria cat ON cat.categoriaid = p.categoriaid"
                + " WHERE p.platoid != ALL (SELECT cp.platoid FROM cartaplato cp) "
                + " AND p.estado = 'A' "
                + " AND p.nombre LIKE '%" + nombre + "%'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            plato = new Plato();
            plato.setPlatoid(resultado.getInt("platoid"));
            plato.setNombre(resultado.getString("nombre"));
            plato.setPrecio(resultado.getDouble("precio"));
            plato.setPrecioCarta(resultado.getDouble("preciofestivo"));
            categoria = new Categoria();
            categoria.setCategoriaid(resultado.getInt("categoriaid"));
            categoria.setNombre(resultado.getString("cat.nombre"));
            plato.setCategoria(categoria);
            platos.add(plato);
        }
        return platos;
    }
}
