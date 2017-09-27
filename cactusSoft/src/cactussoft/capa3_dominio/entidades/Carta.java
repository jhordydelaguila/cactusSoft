package cactussoft.capa3_dominio.entidades;

import cactussoft.capa1_presentacion.util.Mensaje;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Carta {

    private int cartaid;
    private String nombre;
    private Date fecha;
    private String estado;
    private Precio precio;
    private List<Plato> platos;

    public static final String ESTADO_ACTIVO = "A";
    public static final String ESTADO_INACTIVO = "I";
    public static final String ESTADO_ELIMINADO = "E";

    public Carta() {
        platos = new ArrayList<>();
        fecha = Date.valueOf(String.format("%1$tY-%1$tm-%1$te", new java.util.Date()));
    }

    public int getCartaid() {
        return cartaid;
    }

    public void setCartaid(int cartaid) {
        this.cartaid = cartaid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }

    public void agregarPlato(Plato plato) {
        platos.add(plato);
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public void accionPrecio(Precio precio) {
        if (precio.getAccion().equals("Aumentar")) {
            for (Plato plato : platos) {
                plato.aumentarPrecio(precio.getMonto());
            }
        } else if (precio.getAccion().equals("Disminuir")) {
            for (Plato plato : platos) {
                plato.disminuirPrecio(precio.getMonto());
            }
        }
    }

    public void restaurarPrecio(Precio precio) {
        for (Plato plato : platos) {
            plato.restaurarPrecio(precio.getMonto());
        }
    }

    public String mensajePrecio(Precio precio) {
        String mensaje = "";
        if (precio.getNombre().equals(Precio.FESTIVO_PRECIO_REGULAR)) {
            mensaje = "La carta tiene el precio regular.";
        } else if (precio.getAccion().equals("Aumentar")) {
            mensaje = "La carta aumento s/." + precio.getMonto() + " .";
        } else if (precio.getAccion().equals("Disminuir")) {
            mensaje = "La carta diminuyó s/." + precio.getMonto() + " .";
        }
        return mensaje;
    }

    public boolean esActiva() {
        return (estado.equals(Mensaje.ESTADO_ACTIVO));
    }

    public int totalPlatos() {
        return platos.size();
    }

    public boolean datosIguales(int platoid) {
        for (Plato plato : platos) {
            if (plato.getPlatoid() == platoid) {
                return true;
            }
        }
        return false;
    }

    public void eliminarCarta(int numeroFila) {
        platos.remove(numeroFila);
    }

    public void eliminarCartas(List<Plato> platos) {
        this.platos.removeAll(platos);
    }

    public boolean esActivo() {
        return (ESTADO_ACTIVO.equals(estado));
    }

    public boolean esInactivo() {
        return (ESTADO_INACTIVO.equals(estado));
    }
}
