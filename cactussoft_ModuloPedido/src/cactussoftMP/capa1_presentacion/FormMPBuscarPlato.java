package cactussoftMP.capa1_presentacion;

import cactussoft.capa1_presentacion.util.ConfiguradorDeTabla;
import cactussoft.capa1_presentacion.util.Formateador;
import cactussoft.capa1_presentacion.util.Mensaje;
import cactussoft.capa2_aplicacion.GestionarCartaServicio;
import cactussoft.capa2_aplicacion.GestionarPlatoServicio;
import cactussoft.capa3_dominio.entidades.Plato;
import java.util.List;
import javax.swing.JDialog;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Fila;

public class FormMPBuscarPlato extends javax.swing.JDialog {

    public static Plato obtenerPlato = null;
    private String nombreDeCategoria = "";

    public FormMPBuscarPlato(JDialog owner, String nombreDeCategoria) {
        super(owner, true);
        initComponents();
        Formateador.centrarVentanaDialog(this);
        tablaPlatos.setModel(ConfiguradorDeTabla.crearTablaPlatoSinCategoria());

        this.nombreDeCategoria = nombreDeCategoria;
        buscarPlato();
    }

    private void buscarPlato() {
        Fila fila;
        String nombre = txtNombre.getText().trim();
        GestionarCartaServicio gestionarCartaServicio = new GestionarCartaServicio();
        try {
            List<Plato> platos = gestionarCartaServicio.buscarPlatoEnCategoria(this.nombreDeCategoria, nombre);
            ModeloTabla modeloTabla = (ModeloTabla) tablaPlatos.getModel();
            modeloTabla.eliminarTotalFilas();
            for (Plato plato : platos) {
                fila = new Fila();
                fila.agregarValorCelda(plato.getPlatoid());
                fila.agregarValorCelda(plato.getNombre());
                if (plato.esFestivo()) {
                    fila.agregarValorCelda(plato.getPrecioCarta());
                } else {
                    fila.agregarValorCelda(plato.getPrecio());
                }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPlatos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        botRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Plato - Restaurante Cactus");

        tablaPlatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tablaPlatos.setFocusable(false);
        tablaPlatos.setRowHeight(27);
        tablaPlatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPlatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPlatos);

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

        botRegresar.setBackground(new java.awt.Color(153, 255, 204));
        botRegresar.setText("Volver");
        botRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botRegresar)
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaPlatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPlatosMouseClicked
        int id = obtenerId();
        if (evt.getClickCount() == 2) {
            try {
                GestionarPlatoServicio gestionarPlatoServicio = new GestionarPlatoServicio();
                Plato plato = gestionarPlatoServicio.buscarPlato(id);
                if (plato != null) {
                    obtenerPlato = plato;
                    this.dispose();
                }
            } catch (Exception e) {
                Mensaje.mostrarAdvertencia(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_tablaPlatosMouseClicked

    private void botRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botRegresarActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        buscarPlato();
    }//GEN-LAST:event_txtNombreKeyPressed

    private int obtenerId() {
        int numeroFila = tablaPlatos.getSelectedRow();
        if (numeroFila == -1) {
            Mensaje.mostrarFilaNoSeleccionada(this);
            return 0;
        }
        ModeloTabla modeloTabla = (ModeloTabla) tablaPlatos.getModel();
        Fila fila = modeloTabla.obtenerFila(numeroFila);
        return (Integer) fila.obtenerCelda(0).getValor();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPlatos;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
