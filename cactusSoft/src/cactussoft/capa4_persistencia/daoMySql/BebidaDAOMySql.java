package cactussoft.capa4_persistencia.daoMySql;

import cactussoft.capa3_dominio.contratos.IBebidaDAO;
import cactussoft.capa3_dominio.entidades.Bebida;
import cactussoft.capa3_dominio.entidades.Categoria;
import cactussoft.capa3_dominio.entidades.Proveedor;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BebidaDAOMySql implements IBebidaDAO {

    GestorJDBC gestorJDBC;

    public BebidaDAOMySql(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int ingresar(Bebida bebida) throws SQLException {
        String sentenciaSQL = "INSERT INTO bebida (nombre, precio, stock, stockactual,stockminimo, "
                + "descripcion,estado,fechaCreado, fechaActualizado, proveedorid, categoriaid) "
                + "values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, bebida.getNombre());
        sentencia.setDouble(2, bebida.getPrecio());
        sentencia.setInt(3, bebida.getStock());
        sentencia.setInt(4, bebida.getStockactual());
        sentencia.setInt(5, bebida.getStockminimo());
        sentencia.setString(6, bebida.getDescripcion());
        sentencia.setString(7, bebida.getEstado());
        sentencia.setString(8, bebida.getFechaCreado());
        sentencia.setString(9, bebida.getFechaActualizado());
        sentencia.setInt(10, bebida.getProveedor().getProveedorid());
        sentencia.setInt(11, bebida.getCategoria().getCategoriaid());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Bebida bebida) throws SQLException {
        String sentenciaSQL = " UPDATE bebida SET "
                + " nombre = ?, precio = ?, stock = ?, stockactual = ?, stockminimo = ?, "
                + " descripcion = ?, fechaActualizado = ?, categoriaid = ?, proveedorid = ? "
                + " WHERE bebidaid = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, bebida.getNombre());
        sentencia.setDouble(2, bebida.getPrecio());
        sentencia.setInt(3, bebida.getStock());
        sentencia.setInt(4, bebida.getStockactual());
        sentencia.setInt(5, bebida.getStockminimo());
        sentencia.setString(6, bebida.getDescripcion());
        sentencia.setString(7, bebida.getFechaActualizado());
        sentencia.setInt(8, bebida.getCategoria().getCategoriaid());
        sentencia.setInt(9, bebida.getProveedor().getProveedorid());
        sentencia.setInt(10, bebida.getBebidaid());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(Bebida bebida) throws SQLException {
        String sentenciaSQL = "UPDATE bebida SET estado = ? WHERE bebidaid = " + bebida.getBebidaid();
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, bebida.getEstado());
        return sentencia.executeUpdate();
    }

    @Override
    public Bebida buscar(int bebidaid) throws SQLException {
        Bebida bebida = null;
        String sentenciaSQL = ""
                + " SELECT b.bebidaid, b.nombre, b.precio, b.stock, b.stockactual, "
                + " b.stockminimo, b.estado,b.descripcion, b.fechaActualizado, "
                + " c.categoriaid, c.nombre nombreCategoria, "
                + " p.proveedorid, p.nombre nombreProveedor "
                + " FROM bebida b "
                + " INNER JOIN categoria c ON c.categoriaid = b.categoriaid "
                + " INNER JOIN proveedor p ON p.proveedorid = b.proveedorid "
                + " WHERE b.estado <> 'E' AND p.estado <> 'E' AND b.bebidaid = " + bebidaid;

        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            bebida = new Bebida();
            bebida.setBebidaid(resultado.getInt("bebidaid"));
            bebida.setNombre(resultado.getString("nombre"));
            bebida.setPrecio(resultado.getDouble("precio"));
            bebida.setStock(resultado.getInt("stock"));
            bebida.setStockactual(resultado.getInt("stockactual"));
            bebida.setStockminimo(resultado.getInt("stockminimo"));
            bebida.setEstado(resultado.getString("estado"));
            bebida.setDescripcion(resultado.getString("descripcion"));
            bebida.setFechaActualizado(resultado.getString("fechaActualizado"));
            Proveedor proveedor = new Proveedor();
            proveedor.setProveedorid(resultado.getInt("proveedorid"));
            proveedor.setNombre(resultado.getString("nombreProveedor"));
            bebida.setProveedor(proveedor);
            Categoria categoria = new Categoria();
            categoria.setCategoriaid(resultado.getInt("categoriaid"));
            categoria.setNombre(resultado.getString("nombreCategoria"));
            bebida.setCategoria(categoria);
        }
        resultado.close();
        return bebida;
    }

    @Override
    public Bebida buscar(String nombre) throws SQLException {
        Bebida bebida = null;
        String sentenciaSQL = "SELECT b.bebidaid,b.nombre,b.precio,b.stock,b.stockminimo,b.descripcion,b.estado, "
                + " c.categoriaid, c.nombre nombreCategoria, "
                + " p.proveedorid, p.nombre nombreProveedor "
                + " FROM bebida b "
                + " INNER JOIN categoria c ON c.categoriaid = b.categoriaid "
                + " INNER JOIN proveedor p on p.proveedorid = b.proveedorid "
                + " WHERE b.estado <> 'E' AND b.nombre = '" + nombre + "'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            bebida = new Bebida();
            bebida.setBebidaid(resultado.getInt("bebidaid"));
            bebida.setNombre(resultado.getString("nombre"));
            bebida.setPrecio(resultado.getDouble("precio"));
            bebida.setStock(resultado.getInt("stock"));
            bebida.setStockminimo(resultado.getInt("stockminimo"));
            bebida.setDescripcion(resultado.getString("descripcion"));
            bebida.setEstado(resultado.getString("estado"));
            Proveedor proveedor = new Proveedor();
            proveedor.setProveedorid(resultado.getInt("proveedorid"));
            proveedor.setNombre(resultado.getString("nombreProveedor"));
            bebida.setProveedor(proveedor);
            Categoria categoria = new Categoria();
            categoria.setCategoriaid(resultado.getInt("categoriaid"));
            categoria.setNombre(resultado.getString("nombreCategoria"));
            bebida.setCategoria(categoria);
        }
        resultado.close();
        return bebida;
    }

    @Override
    public List<Bebida> mostrar(String nombre) throws SQLException {
        ArrayList<Bebida> bebidas = new ArrayList<>();
        Bebida bebida;
        String sentenciaSQL = "SELECT b.bebidaid, b.nombre, b.precio, b.stock, "
                + " b.stockminimo,b.descripcion, b.estado, b.fechaCreado, b.fechaActualizado,"
                + " c.categoriaid, c.nombre nombreCategoria, "
                + " p.proveedorid, p.nombre nombreProveedor "
                + " FROM bebida b "
                + " INNER JOIN categoria c ON c.categoriaid = b.categoriaid "
                + " INNER JOIN proveedor p on p.proveedorid = b.proveedorid "
                + " WHERE b.estado <> 'E' AND b.nombre like '%" + nombre + "%'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            bebida = new Bebida();
            bebida.setBebidaid(resultado.getInt("bebidaid"));
            bebida.setNombre(resultado.getString("nombre"));
            bebida.setPrecio(resultado.getDouble("precio"));
            bebida.setStock(resultado.getInt("stock"));
            bebida.setStockminimo(resultado.getInt("stockminimo"));
            bebida.setDescripcion(resultado.getString("descripcion"));
            bebida.setEstado(resultado.getString("estado"));
            bebida.setFechaCreado(resultado.getString("fechaCreado"));
            bebida.setFechaActualizado(resultado.getString("fechaActualizado"));
            Proveedor proveedor = new Proveedor();
            proveedor.setProveedorid(resultado.getInt("proveedorid"));
            proveedor.setNombre(resultado.getString("nombreProveedor"));
            bebida.setProveedor(proveedor);
            Categoria categoria = new Categoria();
            categoria.setCategoriaid(resultado.getInt("categoriaid"));
            categoria.setNombre(resultado.getString("nombreCategoria"));
            bebida.setCategoria(categoria);
            bebidas.add(bebida);
        }
        resultado.close();
        return bebidas;
    }

    @Override
    public List<Bebida> buscarBebidasEnCategoria(String nombreCategoria, String nombreBebida) throws SQLException {
        List<Bebida> bebidas = new ArrayList<>();
        Bebida bebida;
        String sentenciaSQL = ""
                + " SELECT b.bebidaid, b.nombre, b.precio, b.stock, b.stockactual, b.stockminimo,"
                + " b.descripcion, b.fechaActualizado "
                + " FROM bebida b "
                + " INNER JOIN categoria c on c.categoriaid = b.categoriaid "
                + " WHERE b.estado <> 'E' AND c.nombre = '" + nombreCategoria + "' "
                + " AND b.nombre LIKE '%" + nombreBebida + "%'";

        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            bebida = new Bebida();
            bebida.setBebidaid(resultado.getInt("bebidaid"));
            bebida.setNombre(resultado.getString("nombre"));
            bebida.setPrecio(resultado.getDouble("precio"));
            bebida.setStock(resultado.getInt("stock"));
            bebida.setStockactual(resultado.getInt("stockactual"));
            bebida.setStockminimo(resultado.getInt("stockminimo"));
            bebida.setDescripcion(resultado.getString("descripcion"));
            bebida.setFechaActualizado(resultado.getString("fechaActualizado"));
            bebidas.add(bebida);
        }
        return bebidas;
    }

}
