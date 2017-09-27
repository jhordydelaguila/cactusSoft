package cactussoft.capa3_dominio.entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Cajero extends Empleado {

    public Cajero() {
        super();
    }

    public Cajero(Usuario usuario) {
        super();
        this.usuario = usuario;
    }

    @Override
    public boolean validarEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generarCodigo(int totalEmpleado) {
        String letraInicial = "c";
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
        String letraNombre = nombre.substring(0, 1);
        String letraApellido = apellido.substring(0, apellido.length());
        codigo = letraNombre + letraApellido;
        return codigo;
    }

}
