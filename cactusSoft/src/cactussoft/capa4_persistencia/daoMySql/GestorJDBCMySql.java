package cactussoft.capa4_persistencia.daoMySql;

import cactussoft.capa4_persistencia.GestorJDBC;
import java.sql.DriverManager;

public class GestorJDBCMySql extends GestorJDBC {

    @Override
    public void abrirConexion() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/cactussoftbd";
        String mysql_user = "root";
        String mysql_password = "root";
        conexion = DriverManager.getConnection(url, mysql_user, mysql_password);
    }

}
