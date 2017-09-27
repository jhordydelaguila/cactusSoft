package cactussoft.capa1_presentacion;

import cactussoft.capa1_presentacion.util.Formateador;
import cactussoft.capa1_presentacion.util.Mensaje;
import cactussoft.capa2_aplicacion.GestionarCartaPrecioServicio;
import cactussoft.capa2_aplicacion.GestionarCartaServicio;
import cactussoft.capa3_dominio.entidades.Carta;
import cactussoft.capa3_dominio.entidades.Precio;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class FormMACartaPrecio extends javax.swing.JDialog {

    private Carta carta;
    private List<Precio> precios;

    public FormMACartaPrecio(JDialog parent, Carta carta) {
        super(parent, true);
        initComponents();

        Formateador.centrarVentanaDialog(this);

        this.carta = carta;
        mostrarPrecio();
    }

    private void mostrarPrecio() {
        try {
            GestionarCartaPrecioServicio gestionarCartaPrecioServicio = new GestionarCartaPrecioServicio();
            precios = gestionarCartaPrecioServicio.mostrarPrecios();
            cboNombre.removeAllItems();
            for (Precio precio : precios) {
                cboNombre.addItem(precio.getNombre());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnElegir = new javax.swing.JButton();
        cboNombre = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAccion = new javax.swing.JTextPane();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aumentar Precio - Restaurante Cactus");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnElegir.setText("Elegir");
        btnElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirActionPerformed(evt);
            }
        });

        cboNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNombreActionPerformed(evt);
            }
        });

        jButton1.setText("Crear nuevo precio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtAccion.setEditable(false);
        jScrollPane1.setViewportView(txtAccion);

        jLabel1.setText("* Elegir el precio para la carta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnElegir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1)
                                .addComponent(cboNombre, 0, 302, Short.MAX_VALUE)
                                .addComponent(jSeparator1))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnElegir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed
        String nombre = (String) cboNombre.getSelectedItem();
        Precio precio = buscarPrecio(nombre);
        GestionarCartaServicio gestionarCartaServicio = new GestionarCartaServicio();
        
        try {
            carta.setPrecio(precio);
            int registros_afectados = gestionarCartaServicio.modificarPrecio(carta);
            if (registros_afectados == 1) {
                Mensaje.mostrarAfirmacionDeCreacion(this);
            } else {
                Mensaje.mostrarAdvertenciaDeCreacion(this);
            }
            this.dispose();
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
    }//GEN-LAST:event_btnElegirActionPerformed

    private void cboNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNombreActionPerformed
        String nombre = (String) cboNombre.getSelectedItem();
        buscarPrecio(nombre);
    }//GEN-LAST:event_cboNombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new FormMAGestionarCartaPrecio(this).setVisible(true);
        mostrarPrecio();
    }//GEN-LAST:event_jButton1ActionPerformed

    private Precio buscarPrecio(String nombre) {
        for (Precio precio : precios) {
            if (precio.getNombre().equals(nombre)) {
                txtAccion.setText(mensaje(precio.getAccion(),precio.getMonto()));
                return precio;
            }
        }
        return null;
    }

    private String mensaje(String accion, double monto) {
        return accion + " s/." + monto +"";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElegir;
    private javax.swing.JComboBox<String> cboNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane txtAccion;
    // End of variables declaration//GEN-END:variables
}
