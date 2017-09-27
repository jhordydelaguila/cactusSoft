package cactussoftMP.capa1_presentacion;

import cactussoft.capa1_presentacion.util.ConfiguradorDeTabla;
import cactussoft.capa1_presentacion.util.Formateador;
import cactussoft.capa1_presentacion.util.Mensaje;
import cactussoft.capa2_aplicacion.GestionarMesaServicio;
import cactussoft.capa3_dominio.entidades.Mesa;
import cactussoft.capa3_dominio.entidades.MesaPedido;
import cactussoft.capa3_dominio.entidades.Pedido;
import java.util.List;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Fila;

public class FormMPUnirMesa extends javax.swing.JDialog {

    private int cantidad_unirmesa = 0;
    private Pedido pedido;
    private Mesa mesa = new Mesa();

    public FormMPUnirMesa(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        Formateador.centrarVentanaDialog(this);
        tablaMesa1.setModel(ConfiguradorDeTabla.crearTablaUnirMesa());
        tablaMesa2.setModel(ConfiguradorDeTabla.crearTablaUnirMesa());

        pedido = new Pedido();
        textoVisible(false);
        buscarMesasLibres();
    }

    private void textoVisible(boolean visible) {
        labelMensaje.setVisible(visible);
        tablaMesa1.setEnabled(visible);
        labelTotalMesas.setText(String.valueOf(pedido.totalDeMesas()));
        textoCantidad.setValue(2);
    }

    private void buscarMesasLibres() {
        Fila fila;
        GestionarMesaServicio gestionarMesaServicio = new GestionarMesaServicio();
        try {
            List<Mesa> mesas = gestionarMesaServicio.buscarMesasLibres();
            ModeloTabla modeloTabla = (ModeloTabla) tablaMesa1.getModel();
            modeloTabla.eliminarTotalFilas();
            for (Mesa mesa : mesas) {
                fila = new Fila();
                fila.agregarValorCelda(mesa.getMesaid());
                fila.agregarValorCelda(mesa.getNumero());
                fila.agregarValorCelda(mesa.getDisponibilidad());
                modeloTabla.agregarFila(fila);
            }
            modeloTabla.refrescarDatos();
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
    }

    private void mostrarMesas() {
        Fila fila;
        ModeloTabla modeloTabla = (ModeloTabla) tablaMesa2.getModel();
        modeloTabla.eliminarTotalFilas();
        for (MesaPedido mesa : pedido.getMesas()) {
            fila = new Fila();
            fila.agregarValorCelda(mesa.getMesa().getMesaid());
            fila.agregarValorCelda(mesa.getMesa().getNumero());
            fila.agregarValorCelda(mesa.getMesa().getDisponibilidad());
            modeloTabla.agregarFila(fila);
        }
        labelTotalMesas.setText(String.valueOf(pedido.totalDeMesas()));
        activarBotonGuardar();
    }

    private void activarBotonGuardar() {
        if (pedido != null && (pedido.totalDeMesas() == cantidad_unirmesa)) {
            botGuardar.setEnabled(true);
        } else {
            botGuardar.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoCantidad = new javax.swing.JSpinner();
        botAceptar = new javax.swing.JButton();
        labelMensaje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMesa1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        botEliminar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaMesa2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        botGuardar = new javax.swing.JButton();
        botCancelar = new javax.swing.JButton();
        labelTotalMesas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Unir Mesa - Restaurante el Cactus");

        jLabel1.setText("¿Cuantos Mesas vas a unir?");

        botAceptar.setText("Aceptar");
        botAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAceptarActionPerformed(evt);
            }
        });

        labelMensaje.setText("Bien ahora selecciona las mesas a unir.");

        tablaMesa1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaMesa1.setFocusable(false);
        tablaMesa1.setRowHeight(21);
        tablaMesa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMesa1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaMesa1);

        jLabel2.setText("Las mesas que se uniran son:");

        botEliminar.setText("Eliminar");
        botEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botEliminarActionPerformed(evt);
            }
        });

        tablaMesa2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaMesa2.setFocusable(false);
        tablaMesa2.setRowHeight(21);
        jScrollPane3.setViewportView(tablaMesa2);

        jLabel3.setText("Mesas unidas:");

        botGuardar.setText("Guardar");
        botGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botGuardarActionPerformed(evt);
            }
        });

        botCancelar.setText("Cancelar");
        botCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCancelarActionPerformed(evt);
            }
        });

        labelTotalMesas.setText("label");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTotalMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(botGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botCancelar))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(labelMensaje)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, labelTotalMesas});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botAceptar, botEliminar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botAceptar))
                .addGap(7, 7, 7)
                .addComponent(labelMensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botEliminar)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botGuardar)
                    .addComponent(botCancelar)
                    .addComponent(jLabel3)
                    .addComponent(labelTotalMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botAceptar, botEliminar, jLabel2});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAceptarActionPerformed
        cantidad_unirmesa = (Integer) textoCantidad.getValue();
        textoVisible(true);
    }//GEN-LAST:event_botAceptarActionPerformed

    private void tablaMesa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMesa1MouseClicked
        int id = obtenerId();
        GestionarMesaServicio gestionarMesaServicio = new GestionarMesaServicio();

        if (evt.getClickCount() == 2) {
            try {
                Mesa mesa = gestionarMesaServicio.buscarMesa(id);
                if (mesa != null) {
                    if (!pedido.datosIgualesMesa(id)) {
                        if (!pedido.agregarMesaUnida(mesa, cantidad_unirmesa)) {
                            return;
                        }
                        mostrarMesas();
                    }
                }
            } catch (Exception e) {
                Mensaje.mostrarAdvertencia(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_tablaMesa1MouseClicked

    private void botGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botGuardarActionPerformed
        pedido.ordenarMesas();
        //MesaPedido mesa = pedido.obtenerUltimaMesa();
        FormMPGestionarPedido formGestionarPedido = new FormMPGestionarPedido(this, pedido, mesa);
        formGestionarPedido.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botGuardarActionPerformed

    private void botEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botEliminarActionPerformed
        int numeroFila = tablaMesa2.getSelectedRow();
        if (numeroFila == -1) {
            Mensaje.mostrarFilaNoSeleccionada(this);
            return;
        }
        ModeloTabla modeloTabla = (ModeloTabla) tablaMesa2.getModel();
        modeloTabla.eliminarFila(numeroFila);
        pedido.eliminarMesa(numeroFila);
        activarBotonGuardar();
    }//GEN-LAST:event_botEliminarActionPerformed

    private void botCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botCancelarActionPerformed

    private int obtenerId() {
        int numeroFila = tablaMesa1.getSelectedRow();
        if (numeroFila == -1) {
            Mensaje.mostrarFilaNoSeleccionada(this);
            return 0;
        }
        ModeloTabla modeloTabla = (ModeloTabla) tablaMesa1.getModel();
        Fila fila = modeloTabla.obtenerFila(numeroFila);
        return (Integer) fila.obtenerCelda(0).getValor();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAceptar;
    private javax.swing.JButton botCancelar;
    private javax.swing.JButton botEliminar;
    private javax.swing.JButton botGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelMensaje;
    private javax.swing.JLabel labelTotalMesas;
    private javax.swing.JTable tablaMesa1;
    private javax.swing.JTable tablaMesa2;
    private javax.swing.JSpinner textoCantidad;
    // End of variables declaration//GEN-END:variables
}
