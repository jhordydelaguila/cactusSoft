package cactussoft.capa3_dominio.contratos;

import cactussoft.capa4_persistencia.GestorJDBC;
import cactussoft.capa5_infraestructura.parametros.LectorDeParametros;

public abstract class FabricaAbstractaDAO {

    public static FabricaAbstractaDAO getInstancia() {
        String nombreClaseFabricaDAO;
        FabricaAbstractaDAO FabricaDAO;
        try {
            LectorDeParametros lectorDeParametros = new LectorDeParametros();
            nombreClaseFabricaDAO = lectorDeParametros.getValorParametro("claseFabricaDAO");
            FabricaDAO = (FabricaAbstractaDAO) Class.forName(nombreClaseFabricaDAO).newInstance();
            return FabricaDAO;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    public abstract GestorJDBC crearGestorJDBC();

    public abstract IProveedorDAO crearProveedorDAO(GestorJDBC gestorJDBC);

    public abstract IMozoDAO crearMozoDAO(GestorJDBC gestorJDBC);

    public abstract ICajeroDAO crearCajeroDAO(GestorJDBC gestorJDBC);
//
//    public abstract IAdministradorDAO crearAdministradorDAO(GestorJDBC gestorJDBC);

    public abstract IMesaDAO crearMesaDAO(GestorJDBC gestorJDBC);

    public abstract ICategoriaDAO crearCategoriaDAO(GestorJDBC gestorJDBC);

    public abstract IPlatoDAO crearPlatoDAO(GestorJDBC gestorJDBC);

    public abstract ICartaDAO crearCartaDAO(GestorJDBC gestorJDBC);

    public abstract ICartaPrecioDAO crearCartaPrecioDAO(GestorJDBC gestorJDBC);

    public abstract IPedidoDAO crearPedidoDAO(GestorJDBC gestorJDBC);

    public abstract IBebidaDAO crearBebidaDAO(GestorJDBC gestorJDBC);

    public abstract IUsuarioDAO crearUsuarioDAO(GestorJDBC gestorJDBC);

    public abstract IVentaDAO crearVenta(GestorJDBC gestorJDBC);

}
