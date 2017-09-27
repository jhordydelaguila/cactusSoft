package cactussoft.capa3_dominio.contratos;

import cactussoft.capa3_dominio.entidades.Empleado;
import cactussoft.capa3_dominio.entidades.Usuario;
import java.sql.SQLException;

public interface IUsuarioDAO {

    public int registrar(Usuario usuario) throws SQLException;

    public int modificar(Usuario usuario) throws SQLException;

    public int eliminar(Usuario usuario) throws SQLException;

    public int ultimoId() throws SQLException;

    public Usuario buscar(int usuarioid) throws SQLException;

    public Usuario buscar(String user) throws SQLException;

    public Usuario iniciar(String usuario, String password) throws SQLException;

    public Empleado iniciarCajero(String usuario, String password) throws SQLException;
}
