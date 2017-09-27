package cactussoft.capa3_dominio.entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Mesa {

    private int mesaid;
    private String numero;
    private String disponibilidad;
    private String estado;
    private List<Mesa> mesas;

    public static final String DISPONIBILIDAD_LIBRE = "LIBRE";
    public static final String DISPONIBILIDAD_OCUPADO = "OCUPADO";
    public static final String NOMBRE = "mesa";
    public static final String ESTADO_ACTIVO = "A";
    public static final String ESTADO_INACTIVO = "E";

    public Mesa() {
        mesas = new ArrayList<>();
    }

    public int getMesaid() {
        return mesaid;
    }

    public void setMesaid(int mesaid) {
        this.mesaid = mesaid;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String nombre, String numero) {
        this.numero = nombre + numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public boolean agregarMesa(Mesa mesa, int cantidadCapturada) {
        if (cantidadCapturada > totalDeMesas()) {
            return mesas.add(mesa);
        }
        return false;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public boolean estaLibre() {
        return (disponibilidad.equals(DISPONIBILIDAD_LIBRE));
    }

    public boolean estaOcupado() {
        return (disponibilidad.equals(DISPONIBILIDAD_OCUPADO));
    }

    public int totalDeMesas() {
        return mesas.size();
    }

    public boolean datosIgualesMesa(int mesaid) {
        for (Mesa mesa : mesas) {
            if (mesa.getMesaid() == mesaid) {
                return true;
            }
        }
        return false;
    }

    public void eliminarMesa(int mesaid) {
        mesas.remove(mesaid);
    }

    public Mesa obtenerUlimaMesa() {
        Mesa mesa;
        for (int i = 0; i <= totalDeMesas(); i++) {
            mesa = mesas.get(i);
            if ((i + 1) == totalDeMesas()) {
                return mesa;
            }
        }
        return null;
    }

    public void ordenarMesas() {
        Collections.sort(mesas, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Mesa mesa1 = (Mesa) o1;
                Mesa mesa2 = (Mesa) o2;
                return mesa1.getNumero().compareTo(mesa2.getNumero());
            }
        });
    }

    public boolean estanLibresTodasLasMesas() {
        int totalmesas = mesas.size();
        int confirmatotalmesas = 0;
        for (Mesa mesa : mesas) {
            if (mesa.estaLibre()) {
                confirmatotalmesas++;
            }
        }
        return (totalmesas == confirmatotalmesas);
    }

//    public void validarCantidadUnirMesa() {
//
//    }
//
//        public boolean sonIguales(int unirmesa) {
//        return (this.unirmesa == unirmesa);
//    }
}
