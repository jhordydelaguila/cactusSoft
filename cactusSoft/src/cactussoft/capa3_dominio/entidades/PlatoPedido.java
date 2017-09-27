package cactussoft.capa3_dominio.entidades;

public class PlatoPedido {

    private Plato plato;
    private int cantidad;
    private double precio;
    private String observacion;

    public PlatoPedido() {
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double calcularSubTotal() {
        return precio * cantidad;
    }

    public boolean validarCantidad() {
        return (cantidad > 1);
    }

    public boolean tieneObservacion() {
        return (!observacion.isEmpty());
    }

}
