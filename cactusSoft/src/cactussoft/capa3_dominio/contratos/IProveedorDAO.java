package cactussoft.capa3_dominio.contratos;

import cactussoft.capa3_dominio.entidades.Proveedor;
import java.sql.SQLException;
import java.util.List;

public interface IProveedorDAO {

    public int ingresar(Proveedor proveedor) throws SQLException;

    public int modificar(Proveedor proveedor) throws SQLException;

    public int eliminar(Proveedor proveedor) throws SQLException;

    public Proveedor buscar(int provedoorid) throws SQLException;

    public Proveedor buscar(String nombre) throws SQLException;

    public List<Proveedor> mostrar() throws SQLException;

}
