package cactussoft.capa3_dominio.entidades;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pedido {

    private int pedidoid;
    private Date fecha;
    private LocalTime horaenvio;
    private String estado;
    private Mozo mozo;
    private List<PlatoPedido> platos = null;
    private List<BebidaPedido> bebidas = null;
    private List<MesaPedido> mesas = null;

    public static final String ESTADO_COMSUMIENDO = "CONSUMIENDO";
    public static final String ESTADO_PAGADO = "PAGADO";
    public static final String ESTADO_CANCELAR = "CANCELADO";

    public Pedido() {
        platos = new ArrayList<>();
        bebidas = new ArrayList<>();
        mesas = new ArrayList<>();
        fecha = Date.valueOf(String.format("%1$tY-%1$tm-%1$te", new java.util.Date()));
        horaenvio = LocalTime.now();
    }

    public int getPedidoid() {
        return pedidoid;
    }

    public void setPedidoid(int pedidoid) {
        this.pedidoid = pedidoid;
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

    public Mozo getMozo() {
        return mozo;
    }

    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }

    public Time getHoraenvio() {
        return Time.valueOf(horaenvio);
    }

    public void setHoraenvio(LocalTime horaenvio) {
        this.horaenvio = horaenvio;
    }

    public void setHoraenvio(Time horaenvio) {
        this.horaenvio = horaenvio.toLocalTime();
    }

    public List<PlatoPedido> getPlatos() {
        return platos;
    }

    public List<BebidaPedido> getBebidas() {
        return bebidas;
    }

    public List<MesaPedido> getMesas() {
        return mesas;
    }

    public void agregarMesaPedido(Mesa mesa, int unirmesa) {
        MesaPedido mesaPedido = new MesaPedido();
        mesaPedido.setMesa(mesa);
        mesaPedido.setUnirMesa(unirmesa);
        mesas.add(mesaPedido);
    }

    public boolean agregarMesaUnida(Mesa mesa, int cantidad_unirmesa) {
        MesaPedido mesaPedido = new MesaPedido();
        mesaPedido.setMesa(mesa);
        return (cantidad_unirmesa > mesas.size()) ? mesas.add(mesaPedido) : false;
    }

    public void agregarPlatoPedido(Plato plato, int cantidad, String observacion) {
        PlatoPedido platoPedido = new PlatoPedido();
        platoPedido.setPlato(plato);
        platoPedido.setCantidad(cantidad);
        platoPedido.setObservacion(observacion);
        if (plato.esFestivo()) {
            platoPedido.setPrecio(plato.getPrecioCarta());
        } else {
            platoPedido.setPrecio(plato.getPrecio());
        }
        platos.add(platoPedido);
    }

    public void agregarBebidaPedido(BebidaPedido bebidaPedido) {
        bebidas.add(bebidaPedido);
    }

    public void agregarBebidaPedido(Bebida bebida, int cantidad) {
        BebidaPedido bebidaPedido = new BebidaPedido();
        bebidaPedido.setBebida(bebida);
        bebidaPedido.setCantidad(cantidad);
        bebidaPedido.setPrecio(bebida.getPrecio());
        bebidas.add(bebidaPedido);
    }

    private void agregarGuarnicion() {

    }

    public void ordenarMesas() {
        Collections.sort(mesas, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                MesaPedido mesa1 = (MesaPedido) o1;
                MesaPedido mesa2 = (MesaPedido) o2;
                return mesa1.getMesa().getNumero().compareTo(mesa2.getMesa().getNumero());
            }
        });
    }

    public MesaPedido obtenerUltimaMesa() {
        MesaPedido mesa;
        for (int i = 0; i <= totalDeMesas(); i++) {
            mesa = mesas.get(i);
            if ((i + 1) == totalDeMesas()) {
                return mesa;
            }
        }
        return null;
    }

    public void eliminarMesa(int mesaid) {
        mesas.remove(mesaid);
    }

    public int totalDeMesas() {
        return mesas.size();
    }

    public boolean tieneRegistros() {
        return ((platos.size() > 0 && platos != null) || (bebidas.size() > 0 && bebidas != null));
    }

    public boolean tieneRegistrosBebidaPedido() {
        return (bebidas.size() > 0 && bebidas != null);
    }

    public boolean tieneRegistrosPlatoPedido() {
        return (platos.size() > 0 && platos != null);
    }

    public void calcularStockActual(Bebida bebida) throws Exception {
        for (BebidaPedido bebidaPedido : bebidas) {
            if (bebidaPedido.getBebida().getBebidaid() == bebida.getBebidaid()) {
                bebida.actualizarStock(bebidaPedido.restarStock());
                break;
            }
        }
    }

    public double calcularMontoTotal() {
        double montoTotalPlato = 0.0;
        double montoTotalBebida = 0.0;
        for (PlatoPedido platoPedido : platos) {
            montoTotalPlato += platoPedido.calcularSubTotal();
        }
        for (BebidaPedido bebidaPedido : bebidas) {
            montoTotalBebida += bebidaPedido.calcularSubTotal();
        }
        return (montoTotalPlato + montoTotalBebida);
    }

    public boolean datosIgualesPlato(int platoid) {
        for (PlatoPedido platoPedido : platos) {
            if (platoPedido.getPlato().getPlatoid() == platoid) {
                return true;
            }
        }
        return false;
    }

    public boolean datosIgualesBebida(int bebidaid) {
        for (BebidaPedido bebidaPedido : bebidas) {
            if (bebidaPedido.getBebida().getBebidaid() == bebidaid) {
                return true;
            }
        }
        return false;
    }

    public boolean datosIgualesMesa(int mesaid) {
        for (MesaPedido mesaPedido : mesas) {
            if (mesaPedido.getMesa().getMesaid() == mesaid) {
                return true;
            }
        }
        return false;
    }

    public void reemplazaPlatoPedido(String nombre, int cantidadnueva) {
        PlatoPedido platoPedido;
        for (int i = 0; i < platos.size(); i++) {
            platoPedido = platos.get(i);
            if (platoPedido.getPlato().getNombre().equals(nombre)) {
                platoPedido.setCantidad(cantidadnueva);
            }
        }
    }

    public void reemplazaBebidaPedido(String nombre, int cantidadnueva) {
        BebidaPedido bebidaPedido;
        for (int i = 0; i < bebidas.size(); i++) {
            bebidaPedido = bebidas.get(i);
            if (bebidaPedido.getBebida().getNombre().equals(nombre)) {
                bebidaPedido.setCantidad(cantidadnueva);
            }
        }
    }

    public void eliminarPlatoPedido(String nombre) {
        PlatoPedido platoPedido;
        for (int i = 0; i < platos.size(); i++) {
            platoPedido = platos.get(i);
            if (platoPedido.getPlato().getNombre().equals(nombre)) {
                platos.remove(i);
                break;
            }
        }
    }

    public void eliminarBebidaPedido(String nombre) {
        BebidaPedido bebidaPedido;
        for (int i = 0; i < bebidas.size(); i++) {
            bebidaPedido = bebidas.get(i);
            if (bebidaPedido.getBebida().getNombre().equals(nombre)) {
                bebidas.remove(i);
                break;
            }
        }
    }

    public int totalDeBebidas() {
        return bebidas.size();
    }

    public void aumentarCantidadPlato(String nombre, int cantidad) {
        cantidad++;
        reemplazaPlatoPedido(nombre, cantidad);
    }

    public void disminuirCantidadPlato(String nombre, int cantidad) {
        cantidad--;
        for (PlatoPedido platoPedido : platos) {
            if (platoPedido.getPlato().getNombre().equals(nombre)) {
                if (platoPedido.validarCantidad()) {
                    reemplazaPlatoPedido(nombre, cantidad);
                }
            }
        }
    }

    public void aumentarCantidadBebida(String nombre, int cantidad) throws Exception {
        for (BebidaPedido bebidaPedido : bebidas) {
            if (bebidaPedido.getBebida().getNombre().equals(nombre)) {
                if (bebidaPedido.getBebida().validarStock()) {
                    reemplazaBebidaPedido(nombre, cantidad);
                }
            }
        }
    }

    public void disminuirCantidadBebida(String nombre, int nuevacantidad) throws Exception {
        nuevacantidad--;
        for (BebidaPedido bebidaPedido : bebidas) {
            if (bebidaPedido.getBebida().getNombre().equals(nombre)) {
                if (nuevacantidad < bebidaPedido.getCantidad()) {
                    if (bebidaPedido.validarCantidad()) {
                        reemplazaBebidaPedido(nombre, nuevacantidad);
                    }
                }
            }
        }
    }

    public void agregarObservacion(String nombre, String observacion) {
        for (PlatoPedido platoPedido : platos) {
            if (platoPedido.getPlato().getNombre().equals(nombre)) {
                platoPedido.setObservacion(observacion);
            }
        }
    }

    public boolean esPlato(String nombre) {
        for (PlatoPedido platoPedido : platos) {
            if (platoPedido.getPlato().getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

}
