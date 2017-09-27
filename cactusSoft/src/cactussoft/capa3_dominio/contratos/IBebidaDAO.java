package cactussoft.capa3_dominio.contratos;

import cactussoft.capa3_dominio.entidades.Bebida;
import java.sql.SQLException;
import java.util.List;

public interface IBebidaDAO {

    public int ingresar(Bebida bebida) throws SQLException;

    public int modificar(Bebida bebida) throws SQLException;

    public int eliminar(Bebida bebida) throws SQLException;

    public Bebida buscar(int bebidaid) throws SQLException;

    public Bebida buscar(String nombre) throws SQLException;

    public List<Bebida> mostrar(String nombre) throws SQLException;

    public List<Bebida> buscarBebidasEnCategoria(String nombreCategoria, String nombreBebida) throws SQLException;

}
