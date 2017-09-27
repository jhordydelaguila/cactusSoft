package cactussoft.capa3_dominio.entidades;

public class MesaPedido {

    private Mesa mesa;
    private int pedidoid;
    private int unirMesa;

    public MesaPedido() {
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public int getPedidoid() {
        return pedidoid;
    }

    public void setPedidoid(int pedidoid) {
        this.pedidoid = pedidoid;
    }

    public int getUnirMesa() {
        return unirMesa;
    }

    public void setUnirMesa(int unirMesa) {
        this.unirMesa = unirMesa;
    }  

}
