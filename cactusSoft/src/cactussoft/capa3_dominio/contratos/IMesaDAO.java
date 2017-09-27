package cactussoft.capa3_dominio.contratos;

import cactussoft.capa3_dominio.entidades.Mesa;
import cactussoft.capa3_dominio.entidades.MesaPedido;
import java.sql.SQLException;
import java.util.List;

public interface IMesaDAO {

    public int modificar(Mesa mesa) throws SQLException;

    public Mesa buscar(int mesaid) throws SQLException;

    public Mesa buscar(String numero) throws SQLException;

    public List<Mesa> buscarMesasLibres() throws SQLException;

    public List<MesaPedido> buscarMesasOcupadas() throws SQLException;
}
