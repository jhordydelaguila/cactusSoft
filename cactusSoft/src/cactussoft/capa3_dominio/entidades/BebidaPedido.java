package cactussoft.capa3_dominio.entidades;

public class BebidaPedido {

    private Bebida bebida;
    private int cantidad;
    private double precio;

    public BebidaPedido() {
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
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
        return (precio * cantidad);
    }

    public int restarStock() {
        if ("" == "") {
            return (bebida.getStock() - cantidad);
        }
        return (bebida.getStockactual() - cantidad);
    }

    public int restarStock(String esNuevo) {
        if (!esNuevo.isEmpty()) {
            return ((bebida.getStockactual() + 1) - cantidad);
        }
        return (bebida.getStockactual() - cantidad);
    }

    public int aumentarStock(int nuevacantidad) {
        return (bebida.getStockactual() + (cantidad - nuevacantidad));
    }

    public int aumentarStockActual() {
        return bebida.getStockactual() + 1;
    }

    public boolean validarCantidad() {
        return (cantidad > 1);
    }

//    public int calcularSotckActual() {
//        return bebida.getStock() - cantidad;
//    }
//    public int restarStockActual(int cantidadnueva) {
//        return bebida.getStockactual() - cantidadnueva;
//    }
//
//    public int sumarStockActual(int cantidadnueva) {
//        return bebida.getStockactual() + (cantidad - cantidadnueva);
//    }
}
