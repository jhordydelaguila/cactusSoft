package cactussoft.capa2_aplicacion;

import cactussoft.capa3_dominio.contratos.FabricaAbstractaDAO;
import cactussoft.capa3_dominio.contratos.IMesaDAO;
import cactussoft.capa3_dominio.entidades.Mesa;
import cactussoft.capa3_dominio.entidades.MesaPedido;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.util.List;

public class GestionarMesaServicio {

    private final GestorJDBC gestorJDBC;
    private final IMesaDAO mesaDAO;

    public GestionarMesaServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        mesaDAO = fabricaAbstractaDAO.crearMesaDAO(gestorJDBC);
    }

    public Mesa buscarMesa(int mesaid) throws Exception {
        gestorJDBC.abrirConexion();
        Mesa mesa = mesaDAO.buscar(mesaid);
        gestorJDBC.cerrarConexion();
        return mesa;
    }

    public Mesa buscarMesa(String numero) throws Exception {
        gestorJDBC.abrirConexion();
        Mesa mesa = mesaDAO.buscar(numero);
        gestorJDBC.cerrarConexion();
        return mesa;
    }

    public List<Mesa> buscarMesasLibres() throws Exception {
        gestorJDBC.abrirConexion();
        List<Mesa> mesas = mesaDAO.buscarMesasLibres();
        gestorJDBC.cerrarConexion();
        return mesas;
    }

    public List<MesaPedido> mostrarMesasOcupado() throws Exception {
        gestorJDBC.abrirConexion();
        List<MesaPedido> mesas = mesaDAO.buscarMesasOcupadas();
        gestorJDBC.cerrarConexion();
        return mesas;
    }
}
