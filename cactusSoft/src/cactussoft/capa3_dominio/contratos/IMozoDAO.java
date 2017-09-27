package cactussoft.capa3_dominio.contratos;

import cactussoft.capa3_dominio.entidades.Empleado;
import cactussoft.capa3_dominio.entidades.Mozo;
import java.sql.SQLException;
import java.util.List;

public interface IMozoDAO {

    public int ingresar(Empleado mozo) throws SQLException;

    public int modificar(Empleado mozo) throws SQLException;

    public int eliminar(Empleado mozo) throws SQLException;

    public Empleado buscar(int mozoid) throws SQLException;

    public List<Empleado> mostrar(String nombre) throws SQLException;

    public int total() throws SQLException;

    public Mozo buscar(String codigo) throws SQLException;

}
