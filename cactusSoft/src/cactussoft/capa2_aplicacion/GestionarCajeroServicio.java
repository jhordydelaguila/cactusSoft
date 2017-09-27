package cactussoft.capa2_aplicacion;

import cactussoft.capa3_dominio.contratos.FabricaAbstractaDAO;
import cactussoft.capa3_dominio.contratos.ICajeroDAO;
import cactussoft.capa3_dominio.entidades.Empleado;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.util.List;

public class GestionarCajeroServicio {

    private final GestorJDBC gestorJDBC;
    private final ICajeroDAO cajeroDAO;

    public GestionarCajeroServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        cajeroDAO = fabricaAbstractaDAO.crearCajeroDAO(gestorJDBC);
    }

    public int crearCajero(Empleado cajero) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectado = cajeroDAO.ingresar(cajero);
        gestorJDBC.cerrarConexion();
        return registros_afectado;
    }

    public List<Empleado> mostrarCajeros(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        List<Empleado> cajeros = cajeroDAO.mostrar(nombre);
        gestorJDBC.cerrarConexion();
        return cajeros;
    }

    public Empleado buscarCajero(int cajeroid) throws Exception {
        gestorJDBC.abrirConexion();
        Empleado cajero = cajeroDAO.buscar(cajeroid);
        gestorJDBC.cerrarConexion();
        return cajero;
    }

    public int modificarCajero(Empleado cajero) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = cajeroDAO.modificar(cajero);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public int eliminarCajero(Empleado cajero) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = cajeroDAO.eliminar(cajero);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public int totalCajeros() throws Exception {
        gestorJDBC.abrirConexion();
        int total = cajeroDAO.total();
        gestorJDBC.cerrarConexion();
        return total;
    }

}
