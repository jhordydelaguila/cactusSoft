package cactussoft.capa1_presentacion.util;

import javax.swing.JTable;
import javax.swing.table.TableColumn;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;

public class ConfiguradorDeTabla {

    public static void seleccionarFilaTabla(JTable tabla, int fila) {
        if (tabla == null) {
            return;
        }

        if (tabla.getRowCount() > 0) {
            if (fila < 0) {
                fila = 0;
            }
            tabla.requestFocusInWindow();
            tabla.setRowSelectionInterval(fila, fila);
        }
    }

    /**
     * Método que configura el ancho de las columnas de una tabla
     *
     * @param tabla
     * @param num_columna
     * @param ancho
     * @param maximo
     * @param mininmo
     */
    public static void configurarAnchoColumna(JTable tabla, int num_columna, int ancho, int maximo, int mininmo) {
        if (tabla == null) {
            return;
        }

        if (num_columna >= 0 && ancho > 0 && maximo > 0 && mininmo > 0) {
            TableColumn columna = tabla.getColumnModel().getColumn(num_columna);
            columna.setPreferredWidth(ancho);
            columna.setMaxWidth(maximo);
            columna.setMinWidth(mininmo);
        }
    }

    /**
     * permite ocultar una columna de la tabla
     *
     * @param tabla
     * @param columna
     */
    public static void ocultarColumna(JTable tabla, int columna) {
        TableColumn columnaTabla;

        if (tabla == null) {
            return;
        }

        if (columna >= 0 && columna < tabla.getColumnCount()) {
            columnaTabla = tabla.getColumnModel().getColumn(columna);
            tabla.removeColumn(columnaTabla);
        }
    }

    /**
     * Método que oculta o quita columnas de una tabla
     *
     * @param tabla
     * @param columnas
     */
    public static void ocultarColumnas(JTable tabla, int columnas[]) {
        TableColumn columna;

        if (tabla == null) {
            return;
        }

        if (columnas != null && columnas.length > 0) {
            for (int i = columnas.length - 1; i >= 0; i--) {
                columna = tabla.getColumnModel().getColumn(columnas[i]);
                tabla.removeColumn(columna);
            }
        }
    }

    public static ModeloTabla crearTablaVenta() {
        mastersoft.tabladatos.Tabla tabla = new mastersoft.tabladatos.Tabla();
        tabla.agregarColumna(new Columna("#", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("NOMBRE", "java.lang.String"));
        tabla.agregarColumna(new Columna("PRECIO", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("CANTIDAD", "java.lang.Double"));
        tabla.agregarColumna(new Columna("SUBTOTAL", "java.lang.Double"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        return modeloTabla;
    }

    public static ModeloTabla crearTablaPedido() {
        mastersoft.tabladatos.Tabla tabla = new mastersoft.tabladatos.Tabla();
        tabla.agregarColumna(new Columna("#", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("NOMBRE", "java.lang.String"));
        tabla.agregarColumna(new Columna("CANTIDAD", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("PRECIO", "java.lang.Double"));
        tabla.agregarColumna(new Columna("SUBTOTAL", "java.lang.Double"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        return modeloTabla;
    }

    public static ModeloTabla crearTablaPlatoSinCategoria() {
        mastersoft.tabladatos.Tabla tabla = new mastersoft.tabladatos.Tabla();
        tabla.agregarColumna(new Columna("#", "java.lang.String"));
        tabla.agregarColumna(new Columna("NOMBRE", "java.lang.String"));
        tabla.agregarColumna(new Columna("PRECIO", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        return modeloTabla;
    }

    public static ModeloTabla crearTablaBebidaSinCategoria() {
        mastersoft.tabladatos.Tabla tabla = new mastersoft.tabladatos.Tabla();
        tabla.agregarColumna(new Columna("#", "java.lang.String"));
        tabla.agregarColumna(new Columna("NOMBRE", "java.lang.String"));
        tabla.agregarColumna(new Columna("PRECIO", "java.lang.String"));
        tabla.agregarColumna(new Columna("STOCK", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("STOCK ACTUAL", "java.lang.Integer"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        return modeloTabla;
    }

    public static ModeloTabla crearTablaCarta() {
        mastersoft.tabladatos.Tabla tabla = new mastersoft.tabladatos.Tabla();
        tabla.agregarColumna(new Columna("#", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("NOMBRE", "java.lang.String"));
        tabla.agregarColumna(new Columna("PRECIO", "java.lang.Double"));
        tabla.agregarColumna(new Columna("PRECIO FESTIVO", "java.lang.Double"));
        tabla.agregarColumna(new Columna("CATEGORIA", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        return modeloTabla;
    }

    public static ModeloTabla crearTablaPlato() {
        mastersoft.tabladatos.Tabla tabla = new mastersoft.tabladatos.Tabla();
        tabla.agregarColumna(new Columna("#", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("NOMBRE", "java.lang.String"));
        tabla.agregarColumna(new Columna("PRECIO", "java.lang.Double"));
        tabla.agregarColumna(new Columna("CATEGORIA", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        return modeloTabla;
    }

    public static ModeloTabla crearTablaEmpleado() {
        mastersoft.tabladatos.Tabla tabla = new mastersoft.tabladatos.Tabla();
        tabla.agregarColumna(new Columna("#", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Codigo", "java.lang.String"));
        tabla.agregarColumna(new Columna("Nombre", "java.lang.String"));
        tabla.agregarColumna(new Columna("Dni", "java.lang.String"));
        tabla.agregarColumna(new Columna("Telefono", "java.lang.String"));
        tabla.agregarColumna(new Columna("Direccion", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        return modeloTabla;
    }

    public static ModeloTabla crearTablaProveedor() {
        mastersoft.tabladatos.Tabla tabla = new mastersoft.tabladatos.Tabla();
        tabla.agregarColumna(new Columna("#", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Nombre", "java.lang.String"));
        tabla.agregarColumna(new Columna("Telefono", "java.lang.String"));
        tabla.agregarColumna(new Columna("Zona", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        return modeloTabla;
    }

    public static ModeloTabla crearTablaBebida() {
        mastersoft.tabladatos.Tabla tabla = new mastersoft.tabladatos.Tabla();
        tabla.agregarColumna(new Columna("#", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Nombre", "java.lang.String"));
        tabla.agregarColumna(new Columna("Precio", "java.lang.Double"));
        tabla.agregarColumna(new Columna("Stock", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Categoria", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        return modeloTabla;
    }

    public static ModeloTabla crearTablaReporteBebida() {
        mastersoft.tabladatos.Tabla tabla = new mastersoft.tabladatos.Tabla();
        tabla.agregarColumna(new Columna("#", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Nombre", "java.lang.String"));
        tabla.agregarColumna(new Columna("Precio", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Stock", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Ganancia", "java.lang.Double"));
        tabla.agregarColumna(new Columna("Sto.Actual", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Gan.Actual", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Fecha", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        return modeloTabla;
    }

    public static ModeloTabla crearTablaUnirMesa() {
        mastersoft.tabladatos.Tabla tabla = new mastersoft.tabladatos.Tabla();
        tabla.agregarColumna(new Columna("#", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Numero", "java.lang.String"));
        tabla.agregarColumna(new Columna("Disponibilidad", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        return modeloTabla;
    }
}
