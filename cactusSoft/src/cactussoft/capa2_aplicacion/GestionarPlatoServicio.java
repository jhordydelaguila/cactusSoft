package cactussoft.capa2_aplicacion;

import cactussoft.capa3_dominio.contratos.FabricaAbstractaDAO;
import cactussoft.capa3_dominio.contratos.ICategoriaDAO;
import cactussoft.capa3_dominio.contratos.IPlatoDAO;
import cactussoft.capa3_dominio.entidades.Categoria;
import cactussoft.capa3_dominio.entidades.Plato;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.util.List;

public class GestionarPlatoServicio {

    private final GestorJDBC gestorJDBC;
    private final ICategoriaDAO categoriaDAO;
    private final IPlatoDAO platoDAO;

    public GestionarPlatoServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        categoriaDAO = fabricaAbstractaDAO.crearCategoriaDAO(gestorJDBC);
        platoDAO = fabricaAbstractaDAO.crearPlatoDAO(gestorJDBC);
    }

    public int crearPlato(Plato plato) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = platoDAO.ingresar(plato);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public int modificarPlato(Plato plato) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = platoDAO.modificar(plato);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public int eliminarPlato(Plato plato) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = platoDAO.eliminar(plato);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public Plato buscarPlato(int platoid) throws Exception {
        gestorJDBC.abrirConexion();
        Plato plato = platoDAO.buscar(platoid);
        gestorJDBC.cerrarConexion();
        return plato;
    }

    public List<Plato> buscarPlatos(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        List<Plato> platos = platoDAO.buscar(nombre);
        gestorJDBC.cerrarConexion();
        return platos;
    }

    public int totalPlatos() throws Exception {
        gestorJDBC.abrirConexion();
        int totaldeplatos = platoDAO.total();
        gestorJDBC.cerrarConexion();
        return totaldeplatos;
    }

    public List<Plato> buscarPlatosNoCarta(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        List<Plato> platos = platoDAO.buscarPlatosNoCarta(nombre);
        gestorJDBC.cerrarConexion();
        return platos;
    }

}
