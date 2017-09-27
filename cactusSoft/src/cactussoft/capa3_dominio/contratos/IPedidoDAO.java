package cactussoft.capa3_dominio.contratos;

import cactussoft.capa3_dominio.entidades.Pedido;
import java.sql.SQLException;

public interface IPedidoDAO {

    public int registrar(Pedido pedido) throws SQLException;

    public int registrarUnirMesa(Pedido pedido) throws SQLException;

    public int modificar(Pedido Pedido) throws SQLException;

    public Pedido buscarPorMesa(String numeroDeMesa) throws SQLException;
    
    public int modificarEstado(Pedido pedido) throws SQLException;

}
