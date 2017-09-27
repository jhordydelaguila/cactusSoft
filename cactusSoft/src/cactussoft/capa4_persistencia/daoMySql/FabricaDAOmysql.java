package cactussoft.capa4_persistencia.daoMySql;

import cactussoft.capa3_dominio.contratos.FabricaAbstractaDAO;
import cactussoft.capa3_dominio.contratos.IBebidaDAO;
import cactussoft.capa3_dominio.contratos.ICajeroDAO;
import cactussoft.capa3_dominio.contratos.ICartaDAO;
import cactussoft.capa3_dominio.contratos.ICartaPrecioDAO;
import cactussoft.capa3_dominio.contratos.ICategoriaDAO;
import cactussoft.capa3_dominio.contratos.IMesaDAO;
import cactussoft.capa3_dominio.contratos.IMozoDAO;
import cactussoft.capa3_dominio.contratos.IPedidoDAO;
import cactussoft.capa3_dominio.contratos.IPlatoDAO;
import cactussoft.capa3_dominio.contratos.IProveedorDAO;
import cactussoft.capa3_dominio.contratos.IUsuarioDAO;
import cactussoft.capa3_dominio.contratos.IVentaDAO;
import cactussoft.capa4_persistencia.GestorJDBC;

public class FabricaDAOmysql extends FabricaAbstractaDAO {

    @Override
    public GestorJDBC crearGestorJDBC() {
        return new GestorJDBCMySql();
    }

    @Override
    public IProveedorDAO crearProveedorDAO(GestorJDBC gestorJDBC) {
        return new ProveedorDAOMySql(gestorJDBC);
    }

    @Override
    public IMozoDAO crearMozoDAO(GestorJDBC gestorJDBC) {
        return new MozoDAOMySql(gestorJDBC);
    }

    @Override
    public ICajeroDAO crearCajeroDAO(GestorJDBC gestorJDBC) {
        return new CajeroDAOMySql(gestorJDBC);
    }

//    @Override
//    public IAdministradorDAO crearAdministradorDAO(GestorJDBC gestorJDBC) {
//        return new AdministradorDAOMySql(gestorJDBC);
//    }
    @Override
    public IMesaDAO crearMesaDAO(GestorJDBC gestorJDBC) {
        return new MesaDAOMySql(gestorJDBC);
    }

    @Override
    public IUsuarioDAO crearUsuarioDAO(GestorJDBC gestorJDBC) {
        return new UsuarioDAOMySql(gestorJDBC);
    }

    @Override
    public ICategoriaDAO crearCategoriaDAO(GestorJDBC gestorJDBC) {
        return new CategoriaDAOMySql(gestorJDBC);
    }

    @Override
    public IPlatoDAO crearPlatoDAO(GestorJDBC gestorJDBC) {
        return new PlatoDAOMySql(gestorJDBC);
    }

    @Override
    public ICartaDAO crearCartaDAO(GestorJDBC gestorJDBC) {
        return new CartaDAOMySql(gestorJDBC);
    }

    @Override
    public ICartaPrecioDAO crearCartaPrecioDAO(GestorJDBC gestorJDBC) {
        return new CartaPrecioDAOMySql(gestorJDBC);
    }

    @Override
    public IPedidoDAO crearPedidoDAO(GestorJDBC gestorJDBC) {
        return new PedidoDAOMySql(gestorJDBC);
    }

    @Override
    public IBebidaDAO crearBebidaDAO(GestorJDBC gestorJDBC) {
        return new BebidaDAOMySql(gestorJDBC);
    }

    @Override
    public IVentaDAO crearVenta(GestorJDBC gestorJDBC) {
        return new VentaDAOMySql(gestorJDBC);
    }

}
