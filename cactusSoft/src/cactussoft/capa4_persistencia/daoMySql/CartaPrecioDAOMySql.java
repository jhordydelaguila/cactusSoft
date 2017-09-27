package cactussoft.capa4_persistencia.daoMySql;

import cactussoft.capa4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cactussoft.capa3_dominio.contratos.ICartaPrecioDAO;
import cactussoft.capa3_dominio.entidades.Precio;

public class CartaPrecioDAOMySql implements ICartaPrecioDAO {

    GestorJDBC gestorJDBC;

    public CartaPrecioDAOMySql(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int registrar(Precio festivo) throws SQLException {
        String sentenciaSQL = "INSERT INTO precio(nombre,accion,monto,estado) VALUES(?,?,?,?) ";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, festivo.getNombre());
        sentencia.setString(2, festivo.getAccion());
        sentencia.setDouble(3, festivo.getMonto());
        sentencia.setString(4, festivo.getEstado());
        return sentencia.executeUpdate();
    }

    @Override
    public Precio buscarPrecioRegular() throws SQLException {
        Precio precio = null;
        String sentenciaSQl = ""
                + " SELECT precioid, nombre, accion, monto, estado "
                + " FROM precio "
                + " WHERE estado = 'P'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQl);
        if (resultado.next()) {
            precio = new Precio();
            precio.setFestivoid(resultado.getInt("precioid"));
            precio.setNombre(resultado.getString("nombre"));
            precio.setAccion(resultado.getString("accion"));
            precio.setMonto(resultado.getDouble("monto"));
            precio.setEstado(resultado.getString("estado"));
        }
        return precio;
    }

    @Override
    public List<Precio> mostrar() throws SQLException {
        List<Precio> precios = new ArrayList<>();
        Precio precio;

        String sentenciaSQL = "SELECT precioid, nombre, accion, monto, estado "
                + " FROM precio "
                + " WHERE estado = 'A'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            precio = new Precio();
            precio.setFestivoid(resultado.getInt("precioid"));
            precio.setNombre(resultado.getString("nombre"));
            precio.setAccion(resultado.getString("accion"));
            precio.setMonto(resultado.getDouble("monto"));
            precio.setEstado(resultado.getString("estado"));
            precios.add(precio);
        }
        resultado.close();
        return precios;
    }

}
