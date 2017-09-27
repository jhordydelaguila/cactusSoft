package cactussoft.capa4_persistencia.daoMySql;

import cactussoft.capa3_dominio.contratos.ICategoriaDAO;
import cactussoft.capa3_dominio.entidades.Categoria;
import cactussoft.capa4_persistencia.GestorJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOMySql implements ICategoriaDAO {

    GestorJDBC gestorJDBC;

    public CategoriaDAOMySql(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public Categoria buscar(String nombre) throws SQLException {
        Categoria categoria = null;
        ResultSet resultado;
        String sentenciaSQL = "SELECT * FROM categoria WHERE nombre = '" + nombre + "'";
        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            categoria = new Categoria();
            categoria.setCategoriaid(resultado.getInt("categoriaid"));
            categoria.setNombre(resultado.getString("nombre"));
            categoria.setEstado(resultado.getString("estado"));
        }
        resultado.close();
        return categoria;
    }

    @Override
    public List<Categoria> mostrar(String tipo) throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        Categoria categoria;
        String sentenciaSQL = "SELECT categoriaid, nombre, tipo, estado "
                + " FROM categoria WHERE estado <> 'E' AND tipo = '" + tipo + "'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            categoria = new Categoria();
            categoria.setCategoriaid(resultado.getInt("categoriaid"));
            categoria.setNombre(resultado.getString("nombre"));
            categoria.setTipo(resultado.getString("tipo"));
            categoria.setEstado(resultado.getString("estado"));
            categorias.add(categoria);
        }
        resultado.close();
        return categorias;
    }
}
