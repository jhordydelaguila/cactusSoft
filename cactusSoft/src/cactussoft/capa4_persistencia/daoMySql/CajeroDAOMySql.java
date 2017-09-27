package cactussoft.capa4_persistencia.daoMySql;

import cactussoft.capa3_dominio.contratos.ICajeroDAO;
import cactussoft.capa3_dominio.entidades.Cajero;
import cactussoft.capa3_dominio.entidades.Empleado;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CajeroDAOMySql implements ICajeroDAO {

    GestorJDBC gestorJDBC;

    public CajeroDAOMySql(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int ingresar(Empleado cajero) throws SQLException {
        int usuarioid = 0;
        UsuarioDAOMySql usuarioDAOMySql = new UsuarioDAOMySql(gestorJDBC);
        int exito = usuarioDAOMySql.registrar(cajero.getUsuario());
        if (1 == exito) {
            usuarioid = usuarioDAOMySql.ultimoId();
        }

        String sentenciaSQL = "INSERT INTO cajero(nombre,apellido,dni,telefono,direccion,"
                + "fechaNacimiento,estado,fechaCreado,fechaActualizado,usuarioid) "
                + " VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, cajero.getNombre());
        sentencia.setString(2, cajero.getApellido());
        sentencia.setString(3, cajero.getDni());
        sentencia.setString(4, cajero.getTelefono());
        sentencia.setString(5, cajero.getDireccion());
        sentencia.setDate(6, cajero.getFechaNacimiento());
        sentencia.setString(7, cajero.getEstado());
        sentencia.setString(8, cajero.getFechaCreado());
        sentencia.setString(9, cajero.getFechaActualizado());
        sentencia.setInt(10, usuarioid);
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Empleado cajero) throws SQLException {
        String sentenciaSQL = "UPDATE cajero SET "
                + "nombre = ?, apellido = ?, dni = ?, telefono = ?, "
                + "direccion = ?,fechaNacimiento = ?, fechaActualizado = ? "
                + "WHERE cajeroid = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, cajero.getNombre());
        sentencia.setString(2, cajero.getApellido());
        sentencia.setString(3, cajero.getDni());
        sentencia.setString(4, cajero.getTelefono());
        sentencia.setString(5, cajero.getDireccion());
        sentencia.setDate(6, cajero.getFechaNacimiento());
        sentencia.setString(7, cajero.getFechaActualizado());
        sentencia.setInt(8, cajero.getEmpleadoid());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(Empleado cajero) throws SQLException {
        String sentenciaSQL = "UPDATE cajero SET estado = ? WHERE cajeroid = " + cajero.getEmpleadoid();
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, cajero.getEstado());
        return sentencia.executeUpdate();
    }

    @Override
    public Empleado buscar(int cajeroid) throws SQLException {
        Empleado cajero = new Cajero();
        ResultSet resultado;
        String sentenciaSQL = "SELECT * FROM cajero WHERE cajeroid = " + cajeroid;
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            cajero = new Cajero();
            cajero.setEmpleadoid(resultado.getInt("cajeroid"));
            cajero.setNombre(resultado.getString("nombre"));
            cajero.setApellido(resultado.getString("apellido"));
            cajero.setDni(resultado.getString("dni"));
            cajero.setTelefono(resultado.getString("telefono"));
            cajero.setDireccion(resultado.getString("direccion"));
            cajero.setFechaNacimiento(resultado.getDate("fechaNacimiento"));
            cajero.setEstado(resultado.getString("estado"));
            cajero.setFechaCreado(resultado.getString("fechaCreado"));
            cajero.setFechaActualizado(resultado.getString("fechaActualizado"));
        }
        resultado.close();
        return cajero;
    }

    @Override
    public List<Empleado> mostrar(String nombre) throws SQLException {
        List<Empleado> cajeros = new ArrayList<>();
        Empleado cajero = new Cajero();
        ResultSet resultado;
        String sentenciaSQL = "SELECT * FROM cajero WHERE estado = 'A' and nombre like '%" + nombre + "%' ";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            cajero = new Cajero();
            cajero.setEmpleadoid(resultado.getInt("cajeroid"));
            cajero.setNombre(resultado.getString("nombre"));
            cajero.setApellido(resultado.getString("apellido"));
            cajero.setDni(resultado.getString("dni"));
            cajero.setTelefono(resultado.getString("telefono"));
            cajero.setDireccion(resultado.getString("direccion"));
            cajero.setFechaNacimiento(resultado.getDate("fechaNacimiento"));
            cajero.setEstado(resultado.getString("estado"));
            cajero.setFechaCreado(resultado.getString("fechaCreado"));
            cajero.setFechaActualizado(resultado.getString("fechaActualizado"));
            cajeros.add(cajero);
        }
        resultado.close();
        return cajeros;
    }

    @Override
    public int total() throws SQLException {
        String sentenciaSQL = "SELECT COUNT(*) AS total FROM cajero WHERE estado <> 'E'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        int total = 0;
        while (resultado.next()) {
            total = resultado.getInt("total");
        }
        resultado.close();
        return total;
    }

}
