package cactussoft.capa3_dominio.entidades;

import java.util.ArrayList;
import java.util.List;

public class Plato {

    private int platoid;
    private String nombre;
    private double precio;
    private double precioCarta;
    private String descripcion;
    private String descripcionpedido;
    private String estado;
    private Categoria categoria;
    private List<Plato> platos;
    
    public Plato() {
        platos = new ArrayList<>();
    }

    public int getPlatoid() {
        return platoid;
    }

    public void setPlatoid(int platoid) {
        this.platoid = platoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioCarta() {
        return precioCarta;
    }

    public void setPrecioCarta(double precioCarta) {
        this.precioCarta = precioCarta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionpedido() {
        return descripcionpedido;
    }

    public void setDescripcionpedido(String descripcionpedido) {
        this.descripcionpedido = descripcionpedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void agregarPlato(Plato plato){
        platos.add(plato);
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public void volverDescripcionPedidoVacio() {
        this.descripcionpedido = "";
    }

    public void aumentarPrecio(double montoAutmentar) {
        precioCarta = precio + montoAutmentar;
    }
    
    public void disminuirPrecio(double montoDisminuir) {
        precioCarta = precio - montoDisminuir;
    }
    
    public void restaurarPrecio(double restaurar) {
        precioCarta = restaurar;
    }
    
    public void dismunirPrecioFinDeSemana(double montoDisminuir) {
        if (precio > montoDisminuir)
            precioCarta = precio - montoDisminuir;  
    }

    public boolean esFestivo(){ 
        return (precioCarta != 0.0);
    }
    
}
