package cactussoft.capa3_dominio.entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class Mozo extends Empleado {

    public Mozo() {
        super();
    }

    public Mozo(String codigo, String nombre, String apellido, String dni, String telefono,
            String direccion, Date fechaNacimiento, String estado) {
        super(codigo, nombre, apellido, dni, telefono, direccion, fechaNacimiento, estado);
    }

    @Override
    public boolean validarEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generarCodigo(int totalEmpleado) {
        String letraInicial = "m";
        String palabras[] = nombre.split(" ");
        String primerNombre = "";
        for (String n : palabras) {
            primerNombre = n;
            break;
        }
        int numero = totalEmpleado;
        return letraInicial + primerNombre + numero;
    }

    @Override
    public String generarFechaActual() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(new java.util.Date());
    }

    @Override
    public String generarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
