package cactussoft.capa1_presentacion;

import cactussoft.capa1_presentacion.util.ConfiguradorDeTabla;
import cactussoft.capa1_presentacion.util.Formateador;
import cactussoft.capa2_aplicacion.GestionarBebidaServicio;
import cactussoft.capa2_aplicacion.GestionarCategoriaServicio;
import cactussoft.capa3_dominio.entidades.Bebida;
import cactussoft.capa3_dominio.entidades.Categoria;
import java.util.List;
import javax.swing.JOptionPane;

public class FormMAReporteBebida extends javax.swing.JDialog {

    public FormMAReporteBebida(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        Formateador.centrarVentanaDialog(this);
        tablaBebida.setModel(ConfiguradorDeTabla.crearTablaReporteBebida());

        agregarBebidaAlComboBox();
    }

    private void agregarBebidaAlComboBox() {
//        GestionarCategoriaServicio gestionarCategoriaServicio = new GestionarCategoriaServicio();
//        try {
//            List<Categoria> categorias = gestionarCategoriaServicio.mostrarCategoriasSinRefresco(Categoria.TIPO_BEBIDA);
//            comboCategoria.removeAllItems();
//            for (Categoria categoria : categorias) {
//                comboCategoria.addItem(categoria.getNombre());
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e.getMessage());
//        }
    }

    public void buscarBebida(String nombreCategoria) {
//        Fila filaTabla;
//        GestionarBebidaServicio gestionarBebidaServicio = new GestionarBebidaServicio();
//        try {
//            List<Bebida> bebidas = gestionarBebidaServicio.buscarBebidaPorCategoria(nombreCategoria);
//            ModeloTabla modeloTabla = (ModeloTabla) tablaBebida.getModel();
//            modeloTabla.eliminarTotalFilas();
//            for (Bebida bebida : bebidas) {
//                filaTabla = new Fila();
//                filaTabla.agregarValorCelda(bebida.getBebidaid());
//                filaTabla.agregarValorCelda(bebida.getNombre());
//                filaTabla.agregarValorCelda(bebida.getPrecio());
//                filaTabla.agregarValorCelda(bebida.getStock());
////                filaTabla.agregarValorCelda(bebida.calcularGanancia());
//                filaTabla.agregarValorCelda(bebida.getStockactual());
////                filaTabla.agregarValorCelda(bebida.calcularGananciaActual());
//                filaTabla.agregarValorCelda("");
//                modeloTabla.agregarFila(filaTabla);
//            }
//            modeloTabla.refrescarDatos();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
    }

    public void agregarTextoGananciaTotal() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        botBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBebida = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textoGananciaTotal = new javax.swing.JTextField();
        botImprimir = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REPORTE DE BEBIDAS - CACTUS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar bebida"));
        jPanel1.setEnabled(false);

        jLabel3.setText("Escoger Bebida:");

        botBuscar.setText("Buscar");
        botBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botBuscarActionPerformed(evt);
            }
        });

        tablaBebida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane1.setViewportView(tablaBebida);

        jLabel1.setText("Ganancia Total = ");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Guía de variables"));

        jLabel4.setText("* Ganancia = Precio * Stock");

        jLabel5.setText("* Sto.Actual = Stock actual");

        jLabel6.setText("* Ganancia total = La suma de las ganancias.");

        jLabel7.setText("* Ganancia actual = La suma de lo stocks actuales");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(19, 19, 19))
        );

        botImprimir.setText("Imprimir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(botImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoGananciaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoGananciaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botImprimir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botBuscarActionPerformed
        String nombreCategoria = (String) comboCategoria.getSelectedItem();
        buscarBebida(nombreCategoria);
        agregarTextoGananciaTotal();
    }//GEN-LAST:event_botBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botBuscar;
    private javax.swing.JButton botImprimir;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaBebida;
    private javax.swing.JTextField textoGananciaTotal;
    // End of variables declaration//GEN-END:variables
}
