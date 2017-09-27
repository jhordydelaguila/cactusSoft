package cactussoft.capa3_dominio.contratos;

import cactussoft.capa3_dominio.entidades.Empleado;
import java.sql.SQLException;
import java.util.List;

public interface ICajeroDAO {

    public int ingresar(Empleado cajero) throws SQLException;

    public int modificar(Empleado cajero) throws SQLException;

    public int eliminar(Empleado cajero) throws SQLException;

    public Empleado buscar(int cajeroid) throws SQLException;

    public List<Empleado> mostrar(String nombre) throws SQLException;

    public int total() throws SQLException;

}
