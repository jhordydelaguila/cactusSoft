package cactussoft.capa3_dominio.entidades;

public class Guarnicion {
    
    private int guarnicionid;
    private String nombre;
    private double precio;

    public Guarnicion() {
    }

    public int getGuarnicionid() {
        return guarnicionid;
    }

    public void setGuarnicionid(int guarnicionid) {
        this.guarnicionid = guarnicionid;
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
    
}
