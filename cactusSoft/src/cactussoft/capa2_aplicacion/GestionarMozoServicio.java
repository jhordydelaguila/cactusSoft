package cactussoft.capa2_aplicacion;

import cactussoft.capa3_dominio.contratos.FabricaAbstractaDAO;
import cactussoft.capa3_dominio.contratos.IMozoDAO;
import cactussoft.capa3_dominio.entidades.Empleado;
import cactussoft.capa3_dominio.entidades.Mozo;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.util.List;

public class GestionarMozoServicio {

    private final GestorJDBC gestorJDBC;
    private final IMozoDAO mozoDAO;

    public GestionarMozoServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        mozoDAO = fabricaAbstractaDAO.crearMozoDAO(gestorJDBC);
    }

    public int crearMozo(Empleado mozo) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = mozoDAO.ingresar(mozo);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public List<Empleado> mostrarMozos(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        List<Empleado> mozos = mozoDAO.mostrar(nombre);
        gestorJDBC.cerrarConexion();
        return mozos;
    }

    public int modificarProveedor(Empleado mozo) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = mozoDAO.modificar(mozo);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public int eliminarMozo(Empleado mozo) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = mozoDAO.eliminar(mozo);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public Empleado buscarMozo(int mozoid) throws Exception {
        gestorJDBC.abrirConexion();
        Empleado mozo = mozoDAO.buscar(mozoid);
        gestorJDBC.cerrarConexion();
        return mozo;
    }

    public int totalMozos() throws Exception {
        gestorJDBC.abrirConexion();
        int total = mozoDAO.total();
        gestorJDBC.cerrarConexion();
        return total;
    }

    public Mozo buscarMozo(String codigo) throws Exception {
        gestorJDBC.abrirConexion();
        Mozo mozo = mozoDAO.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return mozo;
    }
}
