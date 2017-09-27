package cactussoft.capa3_dominio.entidades;

public class Usuario {

    private int usuarioid;
    private String user;
    private String password;
    private String email;
    private String estado;

    public Usuario() {
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean validaPasswordIguales(String repeatedPassword) {
        return (password.equals(repeatedPassword));
    }

}
