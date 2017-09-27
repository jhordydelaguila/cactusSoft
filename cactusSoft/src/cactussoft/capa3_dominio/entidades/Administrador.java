package cactussoft.capa3_dominio.entidades;

import java.sql.Date;

public class Administrador extends Empleado {

    private int administradorid;
    private Usuario usuario;

    public Administrador() {
        super();
        usuario = new Usuario();
    }

    public void asignar() {
    }

    public void operarRestaurante() {
    }

    @Override
    public boolean validarEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getAdministradorid() {
        return administradorid;
    }

    public void setAdministradorid(int administradorid) {
        this.administradorid = administradorid;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String generarCodigo(int totalEmpleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generarFechaActual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
