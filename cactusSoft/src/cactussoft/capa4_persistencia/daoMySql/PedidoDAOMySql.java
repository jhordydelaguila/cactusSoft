package cactussoft.capa4_persistencia.daoMySql;

import cactussoft.capa3_dominio.contratos.IPedidoDAO;
import cactussoft.capa3_dominio.entidades.Bebida;
import cactussoft.capa3_dominio.entidades.BebidaPedido;
import cactussoft.capa3_dominio.entidades.Categoria;
import cactussoft.capa3_dominio.entidades.Mesa;
import cactussoft.capa3_dominio.entidades.MesaPedido;
import cactussoft.capa3_dominio.entidades.Mozo;
import cactussoft.capa3_dominio.entidades.Pedido;
import cactussoft.capa3_dominio.entidades.Plato;
import cactussoft.capa3_dominio.entidades.PlatoPedido;
import cactussoft.capa3_dominio.entidades.Proveedor;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDAOMySql implements IPedidoDAO {

    GestorJDBC gestorJDBC;

    public PedidoDAOMySql(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int registrar(Pedido pedido) throws SQLException {
        try {
            int registros_afectados;
            String sentenciaSQL_pedido = ""
                    + " INSERT INTO pedido(fecha,horaenvio,estado,mozoid) "
                    + " VALUES(?,?,?,?)";
            PreparedStatement sentenciaPedido = gestorJDBC.prepararSentencia(sentenciaSQL_pedido);
            sentenciaPedido.setDate(1, pedido.getFecha());
            sentenciaPedido.setTime(2, pedido.getHoraenvio());
            sentenciaPedido.setString(3, pedido.getEstado());
            sentenciaPedido.setInt(4, pedido.getMozo().getEmpleadoid());
            registros_afectados = sentenciaPedido.executeUpdate();
            if (registros_afectados == 1) {
                MesaDAOMySql mesaDAOMySql = new MesaDAOMySql(gestorJDBC);
                for (MesaPedido mesaPedido : pedido.getMesas()) {
                    mesaDAOMySql.modificar(mesaPedido.getMesa());
                }
            }

            String sentenciaSQL_ultimoregistro = " SELECT max(pedidoid) AS id FROM pedido ";
            ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL_ultimoregistro);
            int pedidoid = 0;
            while (resultado.next()) {
                pedidoid = resultado.getInt("id");
            }
            resultado.close();

            String sentenciaSQL_mesapedido = ""
                    + " INSERT INTO mesapedido(pedidoid,mesaid,unirmesa) "
                    + " VALUES(?,?,?)";
            PreparedStatement sentencia_mesapedido;
            for (MesaPedido mesaPedido : pedido.getMesas()) {
                sentencia_mesapedido = gestorJDBC.prepararSentencia(sentenciaSQL_mesapedido);
                sentencia_mesapedido.setInt(1, pedidoid);
                sentencia_mesapedido.setInt(2, mesaPedido.getMesa().getMesaid());
                sentencia_mesapedido.setInt(3, mesaPedido.getUnirMesa());
                sentencia_mesapedido.executeUpdate();
            }

            String sentenciaSQL_platopedido = " "
                    + " INSERT INTO platopedido(pedidoid,platoid,precio,cantidad,observacion) "
                    + " VALUES(?,?,?,?,?) ";
            PreparedStatement sentencia_platopedido;
            for (PlatoPedido platopedido : pedido.getPlatos()) {
                sentencia_platopedido = gestorJDBC.prepararSentencia(sentenciaSQL_platopedido);
                sentencia_platopedido.setInt(1, pedidoid);
                sentencia_platopedido.setInt(2, platopedido.getPlato().getPlatoid());
                sentencia_platopedido.setDouble(3, platopedido.getPrecio());
                sentencia_platopedido.setInt(4, platopedido.getCantidad());
                sentencia_platopedido.setString(5, platopedido.getObservacion());
                sentencia_platopedido.executeUpdate();
            }

            String sentenciaSQL_bebidapedido = " "
                    + " INSERT INTO bebidapedido(pedidoid,bebidaid,precio,cantidad) "
                    + " VALUES(?,?,?,?) ";
            PreparedStatement sentencia_bebidapedido;
            for (BebidaPedido bebidaPedido : pedido.getBebidas()) {
                sentencia_bebidapedido = gestorJDBC.prepararSentencia(sentenciaSQL_bebidapedido);
                sentencia_bebidapedido.setInt(1, pedidoid);
                sentencia_bebidapedido.setInt(2, bebidaPedido.getBebida().getBebidaid());
                sentencia_bebidapedido.setDouble(3, bebidaPedido.getPrecio());
                sentencia_bebidapedido.setInt(4, bebidaPedido.getCantidad());
                registros_afectados = sentencia_bebidapedido.executeUpdate();
                if (registros_afectados == 1) {
                    BebidaDAOMySql bebidaDAOMySql = new BebidaDAOMySql(gestorJDBC);
                    bebidaDAOMySql.modificar(bebidaPedido.getBebida());
                }
            }

            return registros_afectados;
        } catch (Exception e) {
            throw new SQLException("No se pudo registrar el pedido.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }
    }

    @Override
    public int registrarUnirMesa(Pedido pedido) throws SQLException {
        try {
            int registros_afectados;
            String sentenciaSQL_pedido = " "
                    + " INSERT INTO pedido(fecha,horaenvio,estado,mozoid) "
                    + " VALUES(?,?,?,?)";
            PreparedStatement sentencia_pedido = gestorJDBC.prepararSentencia(sentenciaSQL_pedido);
            sentencia_pedido.setDate(1, pedido.getFecha());
            sentencia_pedido.setTime(2, pedido.getHoraenvio());
            sentencia_pedido.setString(3, pedido.getEstado());
            sentencia_pedido.setInt(4, pedido.getMozo().getEmpleadoid());
            registros_afectados = sentencia_pedido.executeUpdate();

            String sentenciaSQL_ultimoregistro = " SELECT max(pedidoid) AS id FROM pedido ";
            ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL_ultimoregistro);
            int pedidoid = 0;
            while (resultado.next()) {
                pedidoid = resultado.getInt("id");
            }
            resultado.close();

            // registramos el ultimo id, a la mesa con el atributo unirmesa, para 
            // asociar el registro del pedido
            if (registros_afectados == 1) {
                MesaDAOMySql mesaDAOMySql = new MesaDAOMySql(gestorJDBC);
                for (MesaPedido mesaPedido : pedido.getMesas()) {
                    mesaPedido.setUnirMesa(pedidoid);
                    mesaDAOMySql.modificar(mesaPedido.getMesa());
                }
            }
            // termina proceso de registrar el ultimo id, para la mesa con el atributo
            // unirmesa. 

            String sentenciaSQL_mesapedido = ""
                    + " INSERT INTO mesapedido(pedidoid,mesaid,unirmesa) "
                    + " VALUES(?,?,?)";
            for (MesaPedido mesaPedido : pedido.getMesas()) {
                PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL_mesapedido);
                sentencia.setInt(1, pedidoid);
                sentencia.setInt(2, mesaPedido.getMesa().getMesaid());
                sentencia.setInt(3, mesaPedido.getUnirMesa());
                sentencia.executeUpdate();
            }

            String sentenciaSQL_platopedido = " "
                    + " INSERT INTO platopedido(pedidoid,platoid,precio,cantidad,observacion) "
                    + " VALUES(?,?,?,?,?) ";
            PreparedStatement sentencia_platopedido;
            for (PlatoPedido platopedido : pedido.getPlatos()) {
                sentencia_platopedido = gestorJDBC.prepararSentencia(sentenciaSQL_platopedido);
                sentencia_platopedido.setInt(1, pedidoid);
                sentencia_platopedido.setInt(2, platopedido.getPlato().getPlatoid());
                sentencia_platopedido.setDouble(3, platopedido.getPrecio());
                sentencia_platopedido.setInt(4, platopedido.getCantidad());
                sentencia_platopedido.setString(5, platopedido.getObservacion());
                sentencia_platopedido.executeUpdate();
            }

            String sentenciaSQL_bebidapedido = " "
                    + " INSERT INTO bebidapedido(pedidoid,bebidaid,precio,cantidad) "
                    + " VALUES(?,?,?,?) ";
            PreparedStatement sentencia_bebidapedido;
            for (BebidaPedido bebidaPedido : pedido.getBebidas()) {
                sentencia_bebidapedido = gestorJDBC.prepararSentencia(sentenciaSQL_bebidapedido);
                sentencia_bebidapedido.setInt(1, pedidoid);
                sentencia_bebidapedido.setInt(2, bebidaPedido.getBebida().getBebidaid());
                sentencia_bebidapedido.setDouble(3, bebidaPedido.getPrecio());
                sentencia_bebidapedido.setInt(4, bebidaPedido.getCantidad());
                registros_afectados = sentencia_bebidapedido.executeUpdate();
                if (registros_afectados == 1) {
                    BebidaDAOMySql bebidaDAOMySql = new BebidaDAOMySql(gestorJDBC);
                    bebidaDAOMySql.modificar(bebidaPedido.getBebida());
                }
            }

            return registros_afectados;
        } catch (Exception e) {
            throw new SQLException("No se pudo registrar el pedido.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }
    }

    @Override
    public int modificar(Pedido pedido) throws SQLException {
        try {
            if (pedido.tieneRegistrosPlatoPedido()) {
                String sentenciaSQL_eliminaplato = " "
                        + " DELETE FROM platopedido WHERE pedidoid = " + pedido.getPedidoid();
                PreparedStatement sentencia_eliminaplato = gestorJDBC.prepararSentencia(sentenciaSQL_eliminaplato);
                sentencia_eliminaplato.executeUpdate();

                String sentenciaSQL_platopedido = ""
                        + "INSERT INTO platopedido(pedidoid,platoid,precio,cantidad,observacion) VALUES(?,?,?,?,?) ";
                PreparedStatement sentencia_platopedido;
                for (PlatoPedido platoPedido : pedido.getPlatos()) {
                    sentencia_platopedido = gestorJDBC.prepararSentencia(sentenciaSQL_platopedido);
                    sentencia_platopedido.setInt(1, pedido.getPedidoid());
                    sentencia_platopedido.setInt(2, platoPedido.getPlato().getPlatoid());
                    sentencia_platopedido.setDouble(3, platoPedido.getPrecio());
                    sentencia_platopedido.setInt(4, platoPedido.getCantidad());
                    sentencia_platopedido.setString(5, platoPedido.getObservacion());
                    sentencia_platopedido.executeUpdate();
                }
            }

            if (pedido.tieneRegistrosBebidaPedido()) {
                String sentenciaSQL_eliminabebida = ""
                        + " DELETE FROM bebidapedido WHERE pedidoid = " + pedido.getPedidoid();
                PreparedStatement sentencia_eliminabebida = gestorJDBC.prepararSentencia(sentenciaSQL_eliminabebida);
                sentencia_eliminabebida.executeUpdate();

                String sentenciaSQL_bebidapedido = " "
                        + " INSERT INTO bebidapedido(pedidoid,bebidaid,precio,cantidad) VALUES(?,?,?,?) ";
                PreparedStatement sentencia_bebidapedido;
                for (BebidaPedido bebidaPedido : pedido.getBebidas()) {
                    sentencia_bebidapedido = gestorJDBC.prepararSentencia(sentenciaSQL_bebidapedido);
                    sentencia_bebidapedido.setInt(1, pedido.getPedidoid());
                    sentencia_bebidapedido.setInt(2, bebidaPedido.getBebida().getBebidaid());
                    sentencia_bebidapedido.setDouble(3, bebidaPedido.getPrecio());
                    sentencia_bebidapedido.setInt(4, bebidaPedido.getCantidad());
                    int registros_afectados = sentencia_bebidapedido.executeUpdate();
                    if (registros_afectados == 1) {
                        BebidaDAOMySql bebidaDAOMySql = new BebidaDAOMySql(gestorJDBC);
                        bebidaDAOMySql.modificar(bebidaPedido.getBebida());
                    }
                }
            }

            return 1;

        } catch (SQLException e) {
            throw new SQLException("No se pudo registrar el pedido.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }
    }

    @Override
    public Pedido buscarPorMesa(String numeroDeMesa) throws SQLException {
        Pedido pedido = null;
        String sentenciaSQL_pedido = ""
                + " SELECT p.pedidoid, p.fecha, p.horaenvio, p.estado, "
                + " mo.mozoid, mo.nombre, mo.apellido, "
                + " me.mesaid, me.numero, me.disponibilidad, me.estado "
                + " FROM pedido p "
                + " INNER JOIN mozo mo ON p.mozoid = mo.mozoid "
                + " inner join mesapedido mp on mp.pedidoid = p.pedidoid "
                + " INNER JOIN mesa me ON me.mesaid = mp.mesaid "
                + " WHERE me.numero = '" + numeroDeMesa + "' AND p.estado = 'CONSUMIENDO'";

        String sentenciaSQL_mesapedido = ""
                + " SELECT mp.unirmesa,"
                + " m.mesaid, m.numero, m.disponibilidad, m.estado"
                + " FROM mesa m "
                + " inner join mesapedido mp on mp.mesaid = m.mesaid "
                + " WHERE m.numero = '" + numeroDeMesa + "' and mp.pedidoid = ";

        String sentenciaSQL_platopedido = " "
                + " SELECT pp.cantidad, pp.observacion, "
                + " p.platoid, p.nombre, p.precio, p.preciofestivo, p.estado, "
                + " c.categoriaid "
                + " FROM platopedido pp  "
                + " INNER JOIN plato p on p.platoid = pp.platoid "
                + " INNER JOIN categoria c on c.categoriaid = p.categoriaid "
                + " WHERE pp.pedidoid = ";

        String sentenciaSQL_bebidapedido = ""
                + " SELECT bp.cantidad, bp.precio, "
                + " b.bebidaid,b.nombre,b.precio,b.stock,b.stockactual,b.stockminimo,"
                + " b.descripcion, b.fechaActualizado,"
                + " c.categoriaid categoriId, "
                + " pro.proveedorid"
                + " FROM bebidapedido bp  "
                + " INNER JOIN bebida b ON b.bebidaid = bp.bebidaid "
                + " INNER JOIN categoria c ON c.categoriaid = b.categoriaid "
                + " INNER JOIN proveedor pro ON pro.proveedorid = b.proveedorid "
                + " WHERE bp.pedidoid = ";

        ResultSet resultado_pedido = gestorJDBC.ejecutarConsulta(sentenciaSQL_pedido);
        if (resultado_pedido.next()) {
            pedido = new Pedido();
            pedido.setPedidoid(resultado_pedido.getInt("pedidoid"));
            pedido.setFecha(resultado_pedido.getDate("fecha"));
            pedido.setHoraenvio(resultado_pedido.getTime("horaenvio"));
            pedido.setEstado(resultado_pedido.getString("estado"));
            Mozo mozo = new Mozo();
            mozo.setEmpleadoid(resultado_pedido.getInt("mozoid"));
            mozo.setNombre(resultado_pedido.getString("nombre"));
            mozo.setApellido(resultado_pedido.getString("apellido"));
            pedido.setMozo(mozo);
            sentenciaSQL_mesapedido = sentenciaSQL_mesapedido + pedido.getPedidoid();
            ResultSet resultado_mesapedido = gestorJDBC.ejecutarConsulta(sentenciaSQL_mesapedido);
            Mesa mesa = null;
            MesaPedido mesaPedido = null;
            while (resultado_mesapedido.next()) {
                mesa = new Mesa();
                mesa.setMesaid(resultado_mesapedido.getInt("mesaid"));
                mesa.setNumero(resultado_mesapedido.getString("numero"));
                mesa.setDisponibilidad(resultado_mesapedido.getString("disponibilidad"));
                mesa.setEstado(resultado_mesapedido.getString("estado"));
                mesaPedido = new MesaPedido();
                mesaPedido.setMesa(mesa);
                mesaPedido.setUnirMesa(resultado_mesapedido.getInt("mp.unirmesa"));
                pedido.agregarMesaPedido(mesa, mesaPedido.getUnirMesa());
            }
            resultado_mesapedido.close();

            sentenciaSQL_platopedido = sentenciaSQL_platopedido + pedido.getPedidoid();
            ResultSet resultado_platopedido = gestorJDBC.ejecutarConsulta(sentenciaSQL_platopedido);
            Plato plato = null;
            Categoria categoriaPlato = null;
            PlatoPedido platoPedido = null;
            while (resultado_platopedido.next()) {
                plato = new Plato();
                plato.setPlatoid(resultado_platopedido.getInt("platoid"));
                plato.setNombre(resultado_platopedido.getString("nombre"));
                plato.setPrecio(resultado_platopedido.getDouble("precio"));
                plato.setPrecioCarta(resultado_platopedido.getDouble("preciofestivo"));
                plato.setEstado(resultado_platopedido.getString("estado"));
                categoriaPlato = new Categoria();
                categoriaPlato.setCategoriaid(resultado_platopedido.getInt("categoriaid"));
                plato.setCategoria(categoriaPlato);
                platoPedido = new PlatoPedido();
                platoPedido.setCantidad(resultado_platopedido.getInt("pp.cantidad"));
                platoPedido.setObservacion(resultado_platopedido.getString("pp.observacion"));
                platoPedido.setPlato(plato);
                pedido.agregarPlatoPedido(plato, platoPedido.getCantidad(), platoPedido.getObservacion());
            }
            resultado_platopedido.close();

            sentenciaSQL_bebidapedido = sentenciaSQL_bebidapedido + pedido.getPedidoid();
            ResultSet resultado_bebidapedido = gestorJDBC.ejecutarConsulta(sentenciaSQL_bebidapedido);
            Bebida bebida = null;
            Proveedor proveedor = null;
            Categoria categoriaBebida = null;
            BebidaPedido bebidaPedido = null;
            while (resultado_bebidapedido.next()) {
                bebida = new Bebida();
                bebida.setBebidaid(resultado_bebidapedido.getInt("bebidaid"));
                bebida.setNombre(resultado_bebidapedido.getString("nombre"));
                bebida.setPrecio(resultado_bebidapedido.getDouble("precio"));
                bebida.setStock(resultado_bebidapedido.getInt("stock"));
                bebida.setStockactual(resultado_bebidapedido.getInt("stockactual"));
                bebida.setStockminimo(resultado_bebidapedido.getInt("stockminimo"));
                bebida.setDescripcion(resultado_bebidapedido.getString("descripcion"));
                bebida.setFechaActualizado(resultado_bebidapedido.getString("fechaActualizado"));
                categoriaBebida = new Categoria();
                categoriaBebida.setCategoriaid(resultado_bebidapedido.getInt("categoriId"));
                bebida.setCategoria(categoriaBebida);
                proveedor = new Proveedor();
                proveedor.setProveedorid(resultado_bebidapedido.getInt("proveedorid"));
                bebida.setProveedor(proveedor);
                bebidaPedido = new BebidaPedido();
                bebidaPedido.setBebida(bebida);
                bebidaPedido.setCantidad(resultado_bebidapedido.getInt("bp.cantidad"));
                bebidaPedido.setPrecio(resultado_bebidapedido.getDouble("bp.precio"));
                pedido.agregarBebidaPedido(bebidaPedido);
            }
            resultado_bebidapedido.close();
        }
        resultado_pedido.close();
        return pedido;
    }

    @Override
    public int modificarEstado(Pedido pedido) throws SQLException {
        String sentenciaSQL = "UPDATE pedido SET estado = ? WHERE pedidoid = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, pedido.getEstado());
        sentencia.setInt(2, pedido.getPedidoid());
        return sentencia.executeUpdate();
    }
}
