package cactussoft.capa4_persistencia.daoMySql;

import cactussoft.capa3_dominio.contratos.IUsuarioDAO;
import cactussoft.capa3_dominio.entidades.Cajero;
import cactussoft.capa3_dominio.entidades.Empleado;
import cactussoft.capa3_dominio.entidades.Usuario;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOMySql implements IUsuarioDAO {

    GestorJDBC gestorJDBC;

    public UsuarioDAOMySql(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int registrar(Usuario usuario) throws SQLException {
        String sentenciaSQL = "INSERT INTO usuario(usuario,password,email,estado) VALUES(?,?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, usuario.getUser());
        sentencia.setString(2, usuario.getPassword());
        sentencia.setString(3, usuario.getEmail());
        sentencia.setString(4, usuario.getEstado());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Usuario usuario) throws SQLException {
        String sentenciaSQL = "UPDATE  usuario SET "
                + "usuario = ?,password = ?, email = ? "
                + "WHERE usuario = '" + usuario.getUser() + "' AND password = '" + usuario.getPassword() + "'";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, usuario.getUser());
        sentencia.setString(2, usuario.getPassword());
        sentencia.setString(3, usuario.getEmail());
        //sentencia.setString(4, usuario.getEstado());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(Usuario usuario) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ultimoId() throws SQLException {
        ResultSet resultado;
        int usuarioid = 0;
        String sentenciaSQL = "SELECT MAX(usuarioid) as id FROM usuario";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            usuarioid = resultado.getInt("id");
        }
        resultado.close();
        return usuarioid;
    }

    @Override
    public Usuario buscar(int usuarioid) throws SQLException {
        Usuario usuario = null;
        ResultSet resultado;
        String sentenciaSQL = "SELECT * FROM usuario WHERE usuarioid = " + usuarioid;
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            usuario = new Usuario();
            usuario.setUsuarioid(resultado.getInt("usuarioid"));
            usuario.setUser(resultado.getString("usuario"));
            usuario.setPassword(resultado.getString("password"));
            usuario.setEmail(resultado.getString("email"));
        }
        resultado.close();
        return usuario;
    }

    @Override
    public Usuario buscar(String user) throws SQLException {
        String oldpassword = user;
        Usuario usuario = null;
        ResultSet resultado;
        String sentenciaSQL = "SELECT * FROM usuario "
                + "WHERE usuario = '" + user + "' OR (password = '" + oldpassword + "' AND usuario = '" + user + "')";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            usuario = new Usuario();
            usuario.setUsuarioid(resultado.getInt("usuarioid"));
            usuario.setUser(resultado.getString("usuario"));
            usuario.setPassword(resultado.getString("password"));
            usuario.setEmail(resultado.getString("email"));
        }
        resultado.close();
        return usuario;
    }

    @Override
    public Usuario iniciar(String user, String password) throws SQLException {
        Usuario usuario = null;
        ResultSet resultado;
        String sentenciaSQL = "SELECT * FROM usuario "
                + "WHERE usuario = '" + user + "' and password = '" + password + "'";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            usuario = new Usuario();
            usuario.setUsuarioid(resultado.getInt("usuarioid"));
            usuario.setUser(resultado.getString("usuario"));
            usuario.setPassword(resultado.getString("password"));
            usuario.setEmail(resultado.getString("email"));
        }
        resultado.close();
        return usuario;
    }

    @Override
    public Empleado iniciarCajero(String user, String password) throws SQLException {
        Empleado cajero = null;
        Usuario usuario = null;
        ResultSet resultado;
        String sentenciaSQL = "SELECT u.usuarioid, u.usuario, u.email, u.estado,"
                + " c.cajeroid "
                + " FROM usuario u inner join cajero c on c.usuarioid = u.usuarioid "
                + " WHERE u.usuario = '" + user + "' and u.password = '" + password + "'";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            usuario = new Usuario();
            usuario.setUsuarioid(resultado.getInt("usuarioid"));
            usuario.setUser(resultado.getString("usuario"));
            //usuario.setPassword(resultado.getString("password"));
            usuario.setEmail(resultado.getString("email"));
            usuario.setEmail(resultado.getString("estado"));
            cajero = new Cajero();
            cajero.setEmpleadoid(resultado.getInt("cajeroid"));
            cajero.setUsuario(usuario);
        }
        resultado.close();
        return cajero;
    }

}
