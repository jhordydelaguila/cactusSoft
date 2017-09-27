package cactussoft.capa2_aplicacion;

import cactussoft.capa3_dominio.contratos.FabricaAbstractaDAO;
import cactussoft.capa3_dominio.contratos.ICartaDAO;
import cactussoft.capa3_dominio.entidades.Carta;
import cactussoft.capa3_dominio.entidades.Categoria;
import cactussoft.capa3_dominio.entidades.Plato;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.util.List;

public class GestionarCartaServicio {

    private final GestorJDBC gestorJDBC;
    private final ICartaDAO cartaDAO;

    public GestionarCartaServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        cartaDAO = fabricaAbstractaDAO.crearCartaDAO(gestorJDBC);
    }

    public int registrarPlato(Carta carta) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            int registros_afectados = cartaDAO.registrarPlato(carta);
            gestorJDBC.terminarTransaccion();
            return registros_afectados;
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
    }

    public int modificarCarta(Carta carta) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = cartaDAO.modificar(carta);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public int modificarPrecio(Carta carta) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            // aumenta el precio a los platos de la carta.
            if (carta.getPrecio().getMonto() != 0.0) {
                carta.accionPrecio(carta.getPrecio());
            } else {
                carta.restaurarPrecio(carta.getPrecio());
            }
            // restaurar el precio a los platos de la carta.
            gestorJDBC.iniciarTransaccion();
            int registros_afectados = cartaDAO.modificarPrecio(carta);
            gestorJDBC.terminarTransaccion();
            return registros_afectados;
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
    }

    public Carta mostrarCarta() throws Exception {
        gestorJDBC.abrirConexion();
        Carta carta = cartaDAO.mostrar();
        gestorJDBC.cerrarConexion();
        return carta;
    }

    public List<Plato> buscarCarta(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        List<Plato> platos = cartaDAO.buscar(nombre);
        gestorJDBC.cerrarConexion();
        return platos;
    }

    public List<Plato> buscarPlatoEnCategoria(String nombreDeCategoria, String nombreDePlato) throws Exception {
        gestorJDBC.abrirConexion();
        List<Plato> platos = cartaDAO.buscarPlatoEnCategoria(nombreDeCategoria, nombreDePlato);
        gestorJDBC.cerrarConexion();
        return platos;
    }

    public List<Categoria> buscarCategoriasEnCarta() throws Exception {
        gestorJDBC.abrirConexion();
        List<Categoria> categorias = cartaDAO.buscarCategorias();
        gestorJDBC.cerrarConexion();
        return categorias;
    }

}
