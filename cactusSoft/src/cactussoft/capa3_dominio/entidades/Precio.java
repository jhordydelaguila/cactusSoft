package cactussoft.capa3_dominio.entidades;

public class Precio {

    private int precioid;
    private String nombre;
    private String accion;
    private double monto;
    private String estado;

    public static final String FESTIVO_PRECIO_REGULAR = "precio regular";

    public Precio() {
    }

    public int getFestivoid() {
        return precioid;
    }

    public void setFestivoid(int festivoid) {
        this.precioid = festivoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecioid() {
        return precioid;
    }

    public void setPrecioid(int precioid) {
        this.precioid = precioid;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
