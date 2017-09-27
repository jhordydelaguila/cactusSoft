package cactussoft.capa3_dominio.contratos;

import cactussoft.capa3_dominio.entidades.Venta;
import java.sql.SQLException;

public interface IVentaDAO {

    public int ingresar(Venta venta) throws SQLException;

    public Venta reotrnarUltimaVenta() throws SQLException;

}
