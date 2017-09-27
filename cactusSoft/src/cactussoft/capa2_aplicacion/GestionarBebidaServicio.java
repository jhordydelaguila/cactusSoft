package cactussoft.capa2_aplicacion;

import cactussoft.capa3_dominio.contratos.FabricaAbstractaDAO;
import cactussoft.capa3_dominio.contratos.IBebidaDAO;
import cactussoft.capa3_dominio.entidades.Bebida;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.util.List;

public class GestionarBebidaServicio {

    private final GestorJDBC gestorJDBC;
    private final IBebidaDAO bebidaDAO;

    public GestionarBebidaServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        bebidaDAO = fabricaAbstractaDAO.crearBebidaDAO(gestorJDBC);
    }

    public int crearBebida(Bebida bebida) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = bebidaDAO.ingresar(bebida);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public int modificarBebida(Bebida bebida) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = bebidaDAO.modificar(bebida);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public int eliminarBebida(Bebida bebida) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = bebidaDAO.eliminar(bebida);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public Bebida buscarBebida(int bebidaid) throws Exception {
        gestorJDBC.abrirConexion();
        Bebida bebida = bebidaDAO.buscar(bebidaid);
        gestorJDBC.cerrarConexion();
        return bebida;
    }

    public List<Bebida> mostrarBebidas(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        List<Bebida> bebidas = bebidaDAO.mostrar(nombre);
        gestorJDBC.cerrarConexion();
        return bebidas;
    }

    public List<Bebida> buscarBebidasEnCategoria(String nombreCategoria, String nombreBebida) throws Exception {
        gestorJDBC.abrirConexion();
        List<Bebida> bebidas = bebidaDAO.buscarBebidasEnCategoria(nombreCategoria, nombreBebida);
        gestorJDBC.cerrarConexion();
        return bebidas;
    }

}
