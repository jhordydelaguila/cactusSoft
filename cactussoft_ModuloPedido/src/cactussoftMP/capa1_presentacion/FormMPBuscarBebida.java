package cactussoftMP.capa1_presentacion;

import cactussoft.capa1_presentacion.util.ConfiguradorDeTabla;
import cactussoft.capa1_presentacion.util.Formateador;
import cactussoft.capa1_presentacion.util.Mensaje;
import cactussoft.capa2_aplicacion.GestionarBebidaServicio;
import cactussoft.capa3_dominio.entidades.Bebida;
import java.util.List;
import javax.swing.JDialog;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Fila;

public class FormMPBuscarBebida extends javax.swing.JDialog {

    public static Bebida obtenerBebida = null;
    private String nombreDeCategoria = "";

    public FormMPBuscarBebida(JDialog owner, String nombreCategoria) {
        super(owner, true);
        initComponents();
        Formateador.centrarVentanaDialog(this);
        tablaBebida.setModel(ConfiguradorDeTabla.crearTablaBebidaSinCategoria());

        this.nombreDeCategoria = nombreCategoria;
        buscarBebida();
    }

    private void buscarBebida() {
        Fila fila;
        String nombre = txtNombre.getText().trim();
        GestionarBebidaServicio gestionarBebidaServicio = new GestionarBebidaServicio();

        try {
            List<Bebida> bebidas = gestionarBebidaServicio.buscarBebidasEnCategoria(this.nombreDeCategoria, nombre);
            ModeloTabla modeloTabla = (ModeloTabla) tablaBebida.getModel();
            modeloTabla.eliminarTotalFilas();
            for (Bebida bebida : bebidas) {
                fila = new Fila();
                fila.agregarValorCelda(bebida.getBebidaid());
                fila.agregarValorCelda(bebida.getNombre());
                fila.agregarValorCelda(bebida.getPrecio());
                fila.agregarValorCelda(bebida.getStock());
                fila.agregarValorCelda(bebida.getStockactual());
                modeloTabla.agregarFila(fila);
            }
            modeloTabla.refrescarDatos();
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botRegresar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaBebida = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BUSCAR BEBIDA - RESTAURANTE CACTUS");

        botRegresar.setBackground(new java.awt.Color(153, 255, 204));
        botRegresar.setText("SALIR");
        botRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botRegresarActionPerformed(evt);
            }
        });

        tablaBebida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaBebida.setFocusable(false);
        tablaBebida.setRowHeight(31);
        tablaBebida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBebidaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaBebida);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombre)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botRegresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botRegresarActionPerformed

    private void tablaBebidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBebidaMouseClicked
        int bebidaid = obtenerId();
        if (evt.getClickCount() == 2) {
            try {
                GestionarBebidaServicio gestionarBebidaServicio = new GestionarBebidaServicio();
                Bebida bebida = gestionarBebidaServicio.buscarBebida(bebidaid);
                if (bebida != null) {
                    obtenerBebida = bebida;
                    this.dispose();
                }
            } catch (Exception e) {
                Mensaje.mostrarAdvertencia(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_tablaBebidaMouseClicked

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        buscarBebida();
    }//GEN-LAST:event_txtNombreKeyPressed

    private int obtenerId() {
        int numeroFila = tablaBebida.getSelectedRow();
        if (numeroFila == -1) {
            Mensaje.mostrarFilaNoSeleccionada(this);
            return 0;
        }
        ModeloTabla modeloTabla = (ModeloTabla) tablaBebida.getModel();
        Fila fila = modeloTabla.obtenerFila(numeroFila);
        return (Integer) fila.obtenerCelda(0).getValor();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaBebida;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
