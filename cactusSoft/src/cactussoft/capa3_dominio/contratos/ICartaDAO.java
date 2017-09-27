package cactussoft.capa3_dominio.contratos;

import cactussoft.capa3_dominio.entidades.Carta;
import cactussoft.capa3_dominio.entidades.Categoria;
import cactussoft.capa3_dominio.entidades.Plato;
import java.sql.SQLException;
import java.util.List;

public interface ICartaDAO {

    public int registrarPlato(Carta carta) throws SQLException;

    public int modificar(Carta carta) throws SQLException;

    public int modificarPrecio(Carta carta) throws SQLException;

    public Carta mostrar() throws SQLException;

    public List<Plato> buscar(String nombre) throws SQLException;

    public List<Categoria> buscarCategorias() throws SQLException;

    public List<Plato> buscarPlatoEnCategoria(String nombreDeCategoria, String nombrePlato) throws SQLException;

}
