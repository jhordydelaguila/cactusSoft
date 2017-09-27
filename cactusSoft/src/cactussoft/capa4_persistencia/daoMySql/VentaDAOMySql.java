package cactussoft.capa4_persistencia.daoMySql;

import cactussoft.capa3_dominio.contratos.IVentaDAO;
import cactussoft.capa3_dominio.entidades.MesaPedido;
import cactussoft.capa3_dominio.entidades.Venta;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentaDAOMySql implements IVentaDAO {

    GestorJDBC gestorJDBC;

    public VentaDAOMySql(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int ingresar(Venta venta) throws SQLException {
        String sentenciaSQL = "INSERT INTO venta (fecha, tipopago, cajeroid, pedidoid) "
                + " VALUES(?,?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setDate(1, venta.getFecha());
        sentencia.setString(2, venta.getTipoPago());
        sentencia.setInt(3, venta.getCajero().getEmpleadoid());
        sentencia.setInt(4, venta.getPedido().getPedidoid());
        int registros_afectados = sentencia.executeUpdate();
        if (registros_afectados == 1) {
            MesaDAOMySql mesaDAOMySql = new MesaDAOMySql(gestorJDBC);
            for (MesaPedido mesaPedido : venta.getPedido().getMesas()) {
                mesaDAOMySql.modificar(mesaPedido.getMesa());
            }
            PedidoDAOMySql pedidoDAOMySql = new PedidoDAOMySql(gestorJDBC);
            pedidoDAOMySql.modificarEstado(venta.getPedido());
        }
        return registros_afectados;
    }

    @Override
    public Venta reotrnarUltimaVenta() throws SQLException {
        Venta venta = null;
        ResultSet resultado;
        String sentenciaSQL = "SELECT MAX(ventaid) as ultimo FROM venta";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            venta = new Venta();
            venta.setVentaid(resultado.getInt("ultimo"));
        }
        resultado.close();
        return venta;
    }

}
