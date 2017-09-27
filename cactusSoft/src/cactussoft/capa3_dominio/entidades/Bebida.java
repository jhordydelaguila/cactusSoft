package cactussoft.capa3_dominio.entidades;

public class Bebida {

    private int bebidaid;
    private String nombre;
    private double precio;
    private int stock;
    private int stockactual;
    private int stockminimo;
    private String descripcion;
    private String estado;
    private String fechaCreado;
    private String fechaActualizado;
    private Proveedor proveedor;
    private Categoria categoria;

    public Bebida() {
    }

    public int getBebidaid() {
        return bebidaid;
    }

    public void setBebidaid(int bebidaid) {
        this.bebidaid = bebidaid;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockactual() {
        return stockactual;
    }

    public void setStockactual(int stockactual) {
        this.stockactual = stockactual;
    }

    public int getStockminimo() {
        return stockminimo;
    }

    public void setStockminimo(int stockminimo) {
        this.stockminimo = stockminimo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean validarStock() throws Exception {
        if ((stockminimo >= stockactual)) {
            throw new Exception("No se puedo agregar bebida, se encuentra en stock minimo \n"
                    + " consultar con el administrador para actualizar el stock.");
        }
        return true;
    }

    public void actualizarStock(int nuevoStock) throws Exception {
        stockactual = nuevoStock;
    }

    public String getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(String fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public String getFechaActualizado() {
        return fechaActualizado;
    }

    public void setFechaActualizado(String fechaActualizado) {
        this.fechaActualizado = fechaActualizado;
    }

}
