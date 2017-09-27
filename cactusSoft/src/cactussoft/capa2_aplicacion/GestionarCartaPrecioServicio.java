package cactussoft.capa2_aplicacion;

import cactussoft.capa3_dominio.contratos.FabricaAbstractaDAO;
import cactussoft.capa3_dominio.contratos.ICartaPrecioDAO;
import cactussoft.capa3_dominio.entidades.Precio;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.util.List;

public class GestionarCartaPrecioServicio {

    private GestorJDBC gestorJDBC;
    private ICartaPrecioDAO cartaPrecioDAO;

    public GestionarCartaPrecioServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        cartaPrecioDAO = fabricaAbstractaDAO.crearCartaPrecioDAO(gestorJDBC);
    }

    public int crearPrecio(Precio precio) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = cartaPrecioDAO.registrar(precio);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public Precio buscarPrecioRegular() throws Exception {
        gestorJDBC.abrirConexion();
        Precio festivo = cartaPrecioDAO.buscarPrecioRegular();
        gestorJDBC.cerrarConexion();
        return festivo;
    }

    public List<Precio> mostrarPrecios() throws Exception {
        gestorJDBC.abrirConexion();
        List<Precio> festivos = cartaPrecioDAO.mostrar();
        gestorJDBC.cerrarConexion();
        return festivos;
    }

}
