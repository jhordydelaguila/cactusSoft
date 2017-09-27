package cactussoft.capa3_dominio.contratos;

import cactussoft.capa3_dominio.entidades.Precio;
import java.sql.SQLException;
import java.util.List;

public interface ICartaPrecioDAO {

    public int registrar(Precio festivo) throws SQLException;

    public Precio buscarPrecioRegular() throws SQLException;

    public List<Precio> mostrar() throws SQLException;

}
