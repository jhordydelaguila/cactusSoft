package cactussoft.capa2_aplicacion;

import cactussoft.capa3_dominio.contratos.FabricaAbstractaDAO;
import cactussoft.capa3_dominio.contratos.IUsuarioDAO;
import cactussoft.capa3_dominio.entidades.Empleado;
import cactussoft.capa3_dominio.entidades.Usuario;
import cactussoft.capa4_persistencia.GestorJDBC;

public class GestionarUsuarioServicio {

    private final GestorJDBC gestorJDBC;
    private final IUsuarioDAO usuarioDAO;

    public GestionarUsuarioServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        usuarioDAO = fabricaAbstractaDAO.crearUsuarioDAO(gestorJDBC);
    }

    public Usuario iniciarSistema(String user, String password) throws Exception {
        gestorJDBC.abrirConexion();
        Usuario usuario = usuarioDAO.iniciar(user, password);
        gestorJDBC.cerrarConexion();
        return usuario;
    }

    public Empleado iniciarSistemaCajero(String user, String password) throws Exception {
        gestorJDBC.abrirConexion();
        Empleado cajero = usuarioDAO.iniciarCajero(user, password);
        gestorJDBC.cerrarConexion();
        return cajero;
    }

    public Usuario buscarUsuario(String user) throws Exception {
        gestorJDBC.abrirConexion();
        Usuario usuario = usuarioDAO.buscar(user);
        gestorJDBC.cerrarConexion();
        return usuario;
    }

    public int modificarUsuario(Usuario usuario) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = usuarioDAO.modificar(usuario);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }
}
