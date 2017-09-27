package cactussoft.capa3_dominio.contratos;

import cactussoft.capa3_dominio.entidades.Categoria;
import java.sql.SQLException;
import java.util.List;

public interface ICategoriaDAO {

    public Categoria buscar(String nombre) throws SQLException;

    public List<Categoria> mostrar(String tipo) throws SQLException;

}
