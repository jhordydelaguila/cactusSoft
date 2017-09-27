package cactussoft.capa2_aplicacion;

import cactussoft.capa3_dominio.contratos.FabricaAbstractaDAO;
import cactussoft.capa3_dominio.contratos.IProveedorDAO;
import cactussoft.capa3_dominio.entidades.Proveedor;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.util.List;

public class GestionarProveedorServicio {

    private final GestorJDBC gestorJDBC;
    private final IProveedorDAO proveedorDAO;

    public GestionarProveedorServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        proveedorDAO = fabricaAbstractaDAO.crearProveedorDAO(gestorJDBC);
    }

    public int crearProveedor(Proveedor proveedor) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = proveedorDAO.ingresar(proveedor);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public List<Proveedor> mostrarTodo() throws Exception {
        gestorJDBC.abrirConexion();
        List<Proveedor> proveedors = proveedorDAO.mostrar();
        gestorJDBC.cerrarConexion();
        return proveedors;
    }

    public int modificarProveedor(Proveedor proveedor) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = proveedorDAO.modificar(proveedor);
        gestorJDBC.cerrarConexion();
        return registros_afectados;

    }

    public int eliminarProveedor(Proveedor proveedor) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = proveedorDAO.eliminar(proveedor);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public Proveedor buscarProveedor(int proveedorid) throws Exception {
        gestorJDBC.abrirConexion();
        Proveedor proveedor = proveedorDAO.buscar(proveedorid);
        gestorJDBC.cerrarConexion();
        return proveedor;
    }

    public Proveedor buscarProveedor(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        Proveedor proveedor = proveedorDAO.buscar(nombre);
        gestorJDBC.cerrarConexion();
        return proveedor;
    }

}
