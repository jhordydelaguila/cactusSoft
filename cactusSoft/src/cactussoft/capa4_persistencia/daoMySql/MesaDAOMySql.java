package cactussoft.capa4_persistencia.daoMySql;

import cactussoft.capa3_dominio.contratos.IMesaDAO;
import cactussoft.capa3_dominio.entidades.Mesa;
import cactussoft.capa3_dominio.entidades.MesaPedido;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MesaDAOMySql implements IMesaDAO {

    GestorJDBC gestorJDBC;

    public MesaDAOMySql(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int modificar(Mesa mesa) throws SQLException {
        String sentenciaSQL = "UPDATE mesa SET disponibilidad = ? WHERE mesaid = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, mesa.getDisponibilidad());
        sentencia.setInt(2, mesa.getMesaid());
        return sentencia.executeUpdate();
    }

    @Override
    public Mesa buscar(int mesaid) throws SQLException {
        Mesa mesa = null;
        ResultSet resultado;
        String sentenciaSQL = "SELECT * FROM mesa WHERE mesaid = " + mesaid;
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            mesa = new Mesa();
            mesa.setMesaid(resultado.getInt("mesaid"));
            mesa.setNumero(resultado.getString("numero"));
            mesa.setDisponibilidad(resultado.getString("disponibilidad"));
            mesa.setEstado(resultado.getString("estado"));
        }
        resultado.close();
        return mesa;
    }

    @Override
    public Mesa buscar(String numero) throws SQLException {
        Mesa mesa = null;
        String sentenciaSQL = ""
                + " SELECT mesaid, numero, disponibilidad, estado "
                + " FROM mesa "
                + " WHERE numero = '" + numero + "'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            mesa = new Mesa();
            mesa.setMesaid(resultado.getInt("mesaid"));
            mesa.setNumero(resultado.getString("numero"));
            mesa.setDisponibilidad(resultado.getString("disponibilidad"));
            mesa.setEstado(resultado.getString("estado"));
        }
        resultado.close();
        return mesa;
    }

    @Override
    public List<Mesa> buscarMesasLibres() throws SQLException {
        List<Mesa> mesas = new ArrayList<>();
        Mesa mesa;
        String sentenciaSQl = ""
                + " SELECT mesaid,numero,disponibilidad,estado "
                + " FROM mesa WHERE disponibilidad = 'LIBRE'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQl);
        while (resultado.next()) {
            mesa = new Mesa();
            mesa.setMesaid(resultado.getInt("mesaid"));
            mesa.setNumero(resultado.getString("numero"));
            mesa.setDisponibilidad(resultado.getString("disponibilidad"));
            mesa.setEstado(resultado.getString("estado"));
            mesas.add(mesa);
        }
        resultado.close();
        return mesas;
    }

    @Override
    public List<MesaPedido> buscarMesasOcupadas() throws SQLException {
        List<MesaPedido> mesaspedido = new ArrayList<>();
        Mesa mesa;
        String sentenciaSQl = ""
                + " SELECT * "
                + " FROM mesa m"
                + " inner join mesapedido mp on mp.mesaid = m.mesaid"
                + " inner join pedido p on p.pedidoid = mp.pedidoid"
                + " where m.disponibilidad = 'OCUPADO' and p.estado = 'COMSUMIENDO'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQl);
        while (resultado.next()) {
            mesa = new Mesa();
            MesaPedido mesaPedido = new MesaPedido();
            mesa.setMesaid(resultado.getInt("mesaid"));
            mesa.setNumero(resultado.getString("numero"));
            mesa.setDisponibilidad(resultado.getString("disponibilidad"));
            mesa.setEstado(resultado.getString("estado"));
            mesaPedido.setMesa(mesa);
            mesaPedido.setPedidoid(resultado.getInt("p.pedidoid"));
            mesaPedido.setUnirMesa(resultado.getInt("mp.unirmesa"));
            mesaspedido.add(mesaPedido);
        }
        resultado.close();
        return mesaspedido;
    }

}
