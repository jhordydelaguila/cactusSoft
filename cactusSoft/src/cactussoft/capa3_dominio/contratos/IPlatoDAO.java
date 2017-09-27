package cactussoft.capa3_dominio.contratos;

import cactussoft.capa3_dominio.entidades.Carta;
import cactussoft.capa3_dominio.entidades.Plato;
import java.sql.SQLException;
import java.util.List;

public interface IPlatoDAO {

    public int ingresar(Plato plato) throws SQLException;

    public int modificar(Plato plato) throws SQLException;

    public int eliminar(Plato plato) throws SQLException;

    public Plato buscar(int platoid) throws SQLException;

    public List<Plato> buscar(String nombre) throws SQLException;

    public int modificarPrecio(Carta carta) throws SQLException;

    public int total() throws SQLException;

    public List<Plato> buscarPlatosNoCarta(String nombre) throws SQLException;

}
