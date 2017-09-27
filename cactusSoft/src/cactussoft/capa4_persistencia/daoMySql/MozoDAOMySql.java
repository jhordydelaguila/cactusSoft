package cactussoft.capa4_persistencia.daoMySql;

import cactussoft.capa3_dominio.contratos.IMozoDAO;
import cactussoft.capa3_dominio.entidades.Empleado;
import cactussoft.capa3_dominio.entidades.Mozo;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MozoDAOMySql implements IMozoDAO {

    GestorJDBC gestorJDBC;

    public MozoDAOMySql(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int ingresar(Empleado mozo) throws SQLException {
        String sentenciaSQL = "INSERT INTO mozo(codigo,nombre,apellido,dni,telefono,"
                + "direccion,fechaNacimiento,estado,fechaCreado,fechaActualizado)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);

        sentencia.setString(1, mozo.getCodigo());
        sentencia.setString(2, mozo.getNombre());
        sentencia.setString(3, mozo.getApellido());
        sentencia.setString(4, mozo.getDni());
        sentencia.setString(5, mozo.getTelefono());
        sentencia.setString(6, mozo.getDireccion());
        sentencia.setDate(7, mozo.getFechaNacimiento());
        sentencia.setString(8, mozo.getEstado());
        sentencia.setString(9, mozo.getFechaCreado());
        sentencia.setString(10, mozo.getFechaActualizado());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Empleado mozo) throws SQLException {
        String sentenciaSQL = "UPDATE mozo SET "
                + "codigo = ?,nombre = ?, apellido = ?, dni = ?, telefono = ?, "
                + "direccion = ?,fechaNacimiento = ?, fechaActualizado = ? "
                + "WHERE mozoid = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, mozo.getCodigo());
        sentencia.setString(2, mozo.getNombre());
        sentencia.setString(3, mozo.getApellido());
        sentencia.setString(4, mozo.getDni());
        sentencia.setString(5, mozo.getTelefono());
        sentencia.setString(6, mozo.getDireccion());
        sentencia.setDate(7, mozo.getFechaNacimiento());
        sentencia.setString(8, mozo.getFechaActualizado());
        sentencia.setInt(9, mozo.getEmpleadoid());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(Empleado mozo) throws SQLException {
        String sentenciaSQL = "UPDATE mozo SET estado = ? WHERE mozoid = " + mozo.getEmpleadoid();
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, mozo.getEstado());
        return sentencia.executeUpdate();
    }

    @Override
    public Empleado buscar(int mozoid) throws SQLException {
        Empleado mozo = new Mozo();
        ResultSet resultado;

        String sentenciaSQL = "select * from mozo where mozoid = " + mozoid;
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);

        if (resultado.next()) {
            mozo = new Mozo();
            mozo.setEmpleadoid(resultado.getInt("mozoid"));
            mozo.setCodigo(resultado.getString("codigo"));
            mozo.setNombre(resultado.getString("nombre"));
            mozo.setApellido(resultado.getString("apellido"));
            mozo.setDni(resultado.getString("dni"));
            mozo.setTelefono(resultado.getString("telefono"));
            mozo.setDireccion(resultado.getString("direccion"));
            mozo.setFechaNacimiento(resultado.getDate("fechaNacimiento"));
            mozo.setFechaCreado(resultado.getString("fechaCreado"));
            mozo.setFechaActualizado(resultado.getString("fechaActualizado"));
        }
        resultado.close();
        return mozo;
    }

    @Override
    public List<Empleado> mostrar(String nombre) throws SQLException {
        List<Empleado> mozos = new ArrayList<>();
        Empleado mozo;
        ResultSet resultado;
        String sentenciaSQL = "SELECT * FROM mozo "
                + " WHERE nombre LIKE '%" + nombre + "%' and estado = 'A'";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);

        while (resultado.next()) {
            mozo = new Mozo();
            mozo.setEmpleadoid(resultado.getInt("mozoid"));
            mozo.setCodigo(resultado.getString("codigo"));
            mozo.setNombre(resultado.getString("nombre"));
            mozo.setApellido(resultado.getString("apellido"));
            mozo.setDni(resultado.getString("dni"));
            mozo.setTelefono(resultado.getString("telefono"));
            mozo.setDireccion(resultado.getString("direccion"));
            mozo.setFechaNacimiento(resultado.getDate("fechaNacimiento"));
            mozo.setFechaCreado(resultado.getString("fechaCreado"));
            mozo.setFechaActualizado(resultado.getString("fechaActualizado"));
            mozo.setEstado(resultado.getString("estado"));
            mozos.add(mozo);
        }
        resultado.close();
        return mozos;
    }

    @Override
    public int total() throws SQLException {
        String sentenciaSQL = "SELECT COUNT(*) AS total FROM mozo WHERE estado <> 'E'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        int total = 0;
        while (resultado.next()) {
            total = resultado.getInt("total");
        }
        resultado.close();
        return total;
    }

    @Override
    public Mozo buscar(String codigo) throws SQLException {
        Mozo mozo = null;
        ResultSet resultado;
        String sentenciaSQL = "SELECT * FROM mozo WHERE codigo = '" + codigo + "'";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            mozo = new Mozo();
            mozo.setEmpleadoid(resultado.getInt("mozoid"));
            mozo.setCodigo(resultado.getString("codigo"));
            mozo.setNombre(resultado.getString("nombre"));
            mozo.setApellido(resultado.getString("apellido"));
            mozo.setDni(resultado.getString("dni"));
            mozo.setTelefono(resultado.getString("telefono"));
            mozo.setDireccion(resultado.getString("direccion"));
            mozo.setFechaNacimiento(resultado.getDate("fechaNacimiento"));
        }
        resultado.close();
        return mozo;
    }

}
