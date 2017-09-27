package cactussoft.capa3_dominio.entidades;

import java.sql.Date;

public class Venta {

    private int ventaid;
    private Date fecha;
    private String tipoPago;
    private Pedido pedido;
    private Empleado cajero;

    public Venta() {
        cajero = new Cajero();
        fecha = Date.valueOf(String.format("%1$tY-%1$tm-%1$te", new java.util.Date()));
    }

    public int getVentaid() {
        return ventaid;
    }

    public void setVentaid(int ventaid) {
        this.ventaid = ventaid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Empleado getCajero() {
        return cajero;
    }

    public void setCajero(Empleado cajero) {
        this.cajero = cajero;
    }

}
