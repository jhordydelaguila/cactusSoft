package cactussoft.capa2_aplicacion;

import cactussoft.capa3_dominio.contratos.FabricaAbstractaDAO;
import cactussoft.capa3_dominio.contratos.ICategoriaDAO;
import cactussoft.capa3_dominio.entidades.Categoria;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.util.List;

public class GestionarCategoriaServicio {

    private GestorJDBC gestorJDBC;
    private ICategoriaDAO categoriaDAO;

    public GestionarCategoriaServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        categoriaDAO = fabricaAbstractaDAO.crearCategoriaDAO(gestorJDBC);
    }

    public List<Categoria> mostrarCategorias(String tipo) throws Exception {
        gestorJDBC.abrirConexion();
        List<Categoria> categorias = categoriaDAO.mostrar(tipo);
        gestorJDBC.cerrarConexion();
        return categorias;
    }

    public Categoria buscarCategoria(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        Categoria categoria = categoriaDAO.buscar(nombre);
        gestorJDBC.cerrarConexion();
        return categoria;
    }

}
