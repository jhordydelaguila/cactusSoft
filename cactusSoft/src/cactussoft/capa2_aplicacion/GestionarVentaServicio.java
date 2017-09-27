package cactussoft.capa2_aplicacion;

import cactussoft.capa3_dominio.contratos.FabricaAbstractaDAO;
import cactussoft.capa3_dominio.contratos.IVentaDAO;
import cactussoft.capa3_dominio.entidades.Mesa;
import cactussoft.capa3_dominio.entidades.MesaPedido;
import cactussoft.capa3_dominio.entidades.Pedido;
import cactussoft.capa3_dominio.entidades.Venta;
import cactussoft.capa4_persistencia.GestorJDBC;

public class GestionarVentaServicio {

    private final GestorJDBC gestorJDBC;
    private final IVentaDAO ventaDAO;

    public GestionarVentaServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        ventaDAO = fabricaAbstractaDAO.crearVenta(gestorJDBC);
    }

    public int crearVenta(Venta venta) throws Exception {
        Pedido pedido = venta.getPedido();
        gestorJDBC.abrirConexion();

        try {
            gestorJDBC.iniciarTransaccion();
            for (MesaPedido mesaPedido : pedido.getMesas()) {
                Mesa mesa = mesaPedido.getMesa();
                mesa.setDisponibilidad(Mesa.DISPONIBILIDAD_LIBRE);
            }
            pedido.setEstado(Pedido.ESTADO_PAGADO);
            int registros_afectados = ventaDAO.ingresar(venta);
            gestorJDBC.terminarTransaccion();
            return registros_afectados;
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
    }

    public Venta retornarUltimaVenta() throws Exception {
        gestorJDBC.abrirConexion();
        Venta venta = ventaDAO.reotrnarUltimaVenta();
        gestorJDBC.cerrarConexion();
        return venta;
    }

}
