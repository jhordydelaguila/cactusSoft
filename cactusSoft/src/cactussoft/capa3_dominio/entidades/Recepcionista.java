package cactussoft.capa3_dominio.entidades;

import java.sql.Date;

public class Recepcionista extends Empleado {

    private int recepcionistaid;

    public Recepcionista() {
        super();
    }

    public void darPrioridad() {
    }

    public void preparando() {
    }

    public void preparado() {
    }

    @Override
    public boolean validarEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getRecepcionistaid() {
        return recepcionistaid;
    }

    public void setRecepcionistaid(int recepcionistaid) {
        this.recepcionistaid = recepcionistaid;
    }


    @Override
    public String generarFechaActual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generarCodigo(int totalEmpleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
