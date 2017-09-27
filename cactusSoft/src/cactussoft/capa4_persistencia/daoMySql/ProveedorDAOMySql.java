package cactussoft.capa4_persistencia.daoMySql;

import cactussoft.capa3_dominio.contratos.IProveedorDAO;
import cactussoft.capa3_dominio.entidades.Proveedor;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAOMySql implements IProveedorDAO {

    GestorJDBC gestorJDBC;

    public ProveedorDAOMySql(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int ingresar(Proveedor proveedor) throws SQLException {

        String sentenciaSQL = "insert into proveedor(nombre,telefono,zona,estado) "
                + "values(?,?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, proveedor.getNombre());
        sentencia.setString(2, proveedor.getTelefono());
        sentencia.setString(3, proveedor.getZona());
        sentencia.setString(4, proveedor.getEstado());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Proveedor proveedor) throws SQLException {

        String sentenciaSQL = "UPDATE proveedor SET nombre = ?, zona = ?, telefono = ? "
                + " WHERE proveedorid = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, proveedor.getNombre());
        sentencia.setString(2, proveedor.getZona());
        sentencia.setString(3, proveedor.getTelefono());
        sentencia.setInt(4, proveedor.getProveedorid());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(Proveedor proveedor) throws SQLException {
        String sentenciaSQL = "UPDATE proveedor SET estado = ? WHERE proveedorid = " + proveedor.getProveedorid();
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, proveedor.getEstado());
        return sentencia.executeUpdate();
    }

    @Override
    public Proveedor buscar(int proveedorid) throws SQLException {
        Proveedor proveedor = null;
        String sentenciaSQL = "SELECT proveedorid,telefono, nombre, zona, estado FROM proveedor WHERE proveedorid = " + proveedorid;
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            proveedor = new Proveedor();
            proveedor.setProveedorid(resultado.getInt("proveedorid"));
            proveedor.setNombre(resultado.getString("nombre"));
            proveedor.setTelefono(resultado.getString("telefono"));
            proveedor.setZona(resultado.getString("zona"));
            proveedor.setEstado(resultado.getString("estado"));
        }
        resultado.close();
        return proveedor;
    }

    @Override
    public Proveedor buscar(String nombre) throws SQLException {
        Proveedor proveedor = null;
        String sentenciaSQL = "SELECT proveedorid,telefono, nombre, zona, estado "
                + " FROM proveedor WHERE nombre = '" + nombre + "'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            proveedor = new Proveedor();
            proveedor.setProveedorid(resultado.getInt("proveedorid"));
            proveedor.setNombre(resultado.getString("nombre"));
            proveedor.setTelefono(resultado.getString("telefono"));
            proveedor.setZona(resultado.getString("zona"));
            proveedor.setEstado(resultado.getString("estado"));
        }
        resultado.close();
        return proveedor;
    }

    @Override
    public List<Proveedor> mostrar() throws SQLException {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        Proveedor proveedor;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "select proveedorid, nombre,telefono, zona from proveedor where estado <> 'E'";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);

        while (resultado.next()) {
            proveedor = new Proveedor();
            proveedor.setProveedorid(resultado.getInt("proveedorid"));
            proveedor.setTelefono(resultado.getString("telefono"));
            proveedor.setNombre(resultado.getString("nombre"));
            proveedor.setZona(resultado.getString("zona"));
            proveedores.add(proveedor);
        }
        resultado.close();
        return proveedores;

    }

}
