package cactussoft.capa3_dominio.entidades;

import java.util.List;

public class Categoria {

    private int categoriaid;
    private String nombre;
    private String tipo;
    private String estado;

    public final static String TIPO_BEBIDA = "BEBIDA";
    public final static String TIPO_PLATO = "PLATO";
    public final static String CATEGORIA_ARROZ = "Arroz";
    public final static String CATEGORIA_CAPRICHOS_MARINOS = "Caprichos Marinos";
    public final static String CATEGORIA_CEBICHES = "Cebiches";
    public final static String CATEGORIA_CHICHARON = "Chicharron";
    public final static String CATEGORIA_CHUPES ="Chupes";
    public final static String CATEGORIA_CRIOLLOS ="Criollos";
    public final static String CATEGORIA_ESPECIALES ="Especiales";
    public final static String CATEGORIA_PARIHUELAS ="Parihuelas";
    public final static String CATEGORIA_PICANTES ="Picantes";
    public final static String CATEGORIA_SOPAS ="Sopas";
    public final static String CATEGORIA_SUDADOS ="Sudados";
    public final static String CATEGORIA_TORTILLAS ="Tortillas";
    //categorias tipo bebida
    public final static String CATEGORIA_AGUA = "Agua";
    public final static String CATEGORIA_CERVEZA = "Cerveza";
    public final static String CATEGORIA_GASEOSA = "Gaseosa";
    public final static String CATEGORIA_REFRESCO = "Refresco";
            
    public Categoria() {
    }

    public int getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(int categoriaid) {
        this.categoriaid = categoriaid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean encuentraCategoria(List<Categoria> categorias, String nombre) {
        boolean encontroLaCategoria = false;
        for (Categoria categoria : categorias) {
            if (categoria.getNombre().equals(nombre))
                encontroLaCategoria = true;
        }
        return encontroLaCategoria;
    }
    
}
