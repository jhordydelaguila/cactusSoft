package cactussoft.capa3_dominio.entidades;

import java.sql.Date;

public abstract class Empleado {

    protected int empleadoid;
    protected String codigo;
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected String telefono;
    protected String direccion;
    protected Date fechaNacimiento;
    protected String estado;
    protected String fechaCreado;
    protected String fechaActualizado;
    protected Usuario usuario;

    public static final String ACTIVO = "A";
    public static final String INACTIVO = "E";

    public Empleado() {
    }

    public Empleado(String codigo, String nombre, String apellido, String dni,
            String telefono, String direccion, Date fechaNacimiento, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    public abstract boolean validarEstado();

    public abstract String generarCodigo(int totalEmpleado);

    public abstract String generarUsuario();

    public abstract String generarFechaActual();

    public int getEmpleadoid() {
        return empleadoid;
    }

    public void setEmpleadoid(int empleadoid) {
        this.empleadoid = empleadoid;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFechaNacimiento(java.util.Date fechaNacimiento) {
        this.fechaNacimiento = Date.valueOf(String.format("%1$tY-%1$tm-%1$te", fechaNacimiento));
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
