package cactussoft.capa2_aplicacion;

import cactussoft.capa3_dominio.contratos.FabricaAbstractaDAO;
import cactussoft.capa3_dominio.contratos.IPedidoDAO;
import cactussoft.capa3_dominio.entidades.Mesa;
import cactussoft.capa3_dominio.entidades.MesaPedido;
import cactussoft.capa3_dominio.entidades.Pedido;
import cactussoft.capa4_persistencia.GestorJDBC;

public class GestionarPedidoServicio {

    private final GestorJDBC gestorJDBC;
    private final IPedidoDAO pedidoDAO;

    public GestionarPedidoServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        pedidoDAO = fabricaAbstractaDAO.crearPedidoDAO(gestorJDBC);
    }

    public int crearPedido(Pedido pedido) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            for (MesaPedido mesaPedido : pedido.getMesas()) {
                Mesa mesa = mesaPedido.getMesa();
                mesa.setDisponibilidad(Mesa.DISPONIBILIDAD_OCUPADO);
            }
            int registros_afectados = pedidoDAO.registrar(pedido);
            gestorJDBC.terminarTransaccion();
            return registros_afectados;
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
    }

    public int crearPedidoUnirMesa(Pedido pedido) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            for (MesaPedido mesaPedido : pedido.getMesas()) {
                Mesa mesa = mesaPedido.getMesa();
                mesa.setDisponibilidad(Mesa.DISPONIBILIDAD_OCUPADO);
            }
            int registros_afectados = pedidoDAO.registrarUnirMesa(pedido);
            gestorJDBC.terminarTransaccion();
            return registros_afectados;
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
    }

    public int modificarPedido(Pedido pedido) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            int registros_afectados = pedidoDAO.modificar(pedido);
            gestorJDBC.terminarTransaccion();
            return registros_afectados;
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
    }

    public Pedido buscarPedidoPorMesa(String numeroDeMesa) throws Exception {
        gestorJDBC.abrirConexion();
        Pedido pedido = pedidoDAO.buscarPorMesa(numeroDeMesa);
        gestorJDBC.cerrarConexion();
        return pedido;
    }

}
