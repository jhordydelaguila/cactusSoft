package cactussoft.capa1_presentacion;

import cactussoft.capa1_presentacion.util.Formateador;
import cactussoft.capa1_presentacion.util.Mensaje;
import cactussoft.capa2_aplicacion.GestionarCajeroServicio;
import cactussoft.capa3_dominio.entidades.Empleado;
import javax.swing.plaf.synth.Region;

public class FormMAMenu extends javax.swing.JFrame {

    private int cajeroid;

    public FormMAMenu() {
        asignarLookandfeel();
        initComponents();
//        Formateador.centrarVentanaFrame(this);
        Formateador.extenderVentanaFrameCompleta(this);
    }

    public FormMAMenu(Empleado cajero) {
        asignarLookandfeel();
        initComponents();
//        Formateador.centrarVentanaFrame(this);
        Formateador.extenderVentanaFrameCompleta(this);

        cajeroid = cajero.getEmpleadoid();
        Empleado c = buscarCajero();
        lblUsuario.setText(c.getNombre().toUpperCase() + " " + c.getApellido().toUpperCase());
    }

    private Empleado buscarCajero() {
        GestionarCajeroServicio gestionarCajeroServicio = new GestionarCajeroServicio();
        try {
            Empleado cajero = gestionarCajeroServicio.buscarCajero(cajeroid);
            return cajero;
        } catch (Exception e) {
//            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
        return null;
    }

    private void asignarLookandfeel() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMAMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMAMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMAMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMAMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menuBarOpciones = new javax.swing.JMenuBar();
        menuGestionDeRestaurante = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuGestionDeMozos = new javax.swing.JMenuItem();
        menuGestionDeCajero = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem23 = new javax.swing.JMenuItem();
        menuGestionInventario = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        menuGestionDeLaCarta = new javax.swing.JMenu();
        menuRegistroPlato = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuAlistarCarta = new javax.swing.JMenuItem();
        menuGestionVenta = new javax.swing.JMenu();
        menuGestionarVenta = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel principal - Sistema de restaurante CACTUS - Modulo Administrador");

        jPanel2.setBackground(new java.awt.Color(238, 235, 235));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoft/capa1_presentacion/recursos/64_64_verificacion.png"))); // NOI18N

        lblUsuario.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuario.setText("NombreUsuario");

        jButton1.setBackground(new java.awt.Color(102, 255, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoft/capa1_presentacion/recursos/64_64_tienda-online.png"))); // NOI18N
        jButton1.setText("Inventario");

        jButton2.setBackground(new java.awt.Color(255, 255, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoft/capa1_presentacion/recursos/64_64_restaurante.png"))); // NOI18N
        jButton2.setText("Platos");

        jButton3.setBackground(new java.awt.Color(255, 102, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoft/capa1_presentacion/recursos/64_64_carta-de-vino.png"))); // NOI18N
        jButton3.setText("Carta");

        jButton4.setBackground(new java.awt.Color(153, 153, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoft/capa1_presentacion/recursos/64_64_venta.png"))); // NOI18N
        jButton4.setText("Ventas");

        jButton5.setBackground(new java.awt.Color(51, 0, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoft/capa1_presentacion/recursos/64_64_reportar.png"))); // NOI18N
        jButton5.setText("Reportes");

        jButton6.setBackground(new java.awt.Color(255, 0, 51));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoft/capa1_presentacion/recursos/64_64_info.png"))); // NOI18N
        jButton6.setText("Ayuda");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("© Copyright  2017 - Derechos Reservados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5, jButton6});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5, jButton6});

        menuBarOpciones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuBarOpciones.setPreferredSize(new java.awt.Dimension(303, 25));

        menuGestionDeRestaurante.setText("Gestión de Restaurante");

        jMenuItem7.setText("Gestión de Administración");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menuGestionDeRestaurante.add(jMenuItem7);
        menuGestionDeRestaurante.add(jSeparator4);

        menuGestionDeMozos.setText("Gestión de Mozos");
        menuGestionDeMozos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGestionDeMozosActionPerformed(evt);
            }
        });
        menuGestionDeRestaurante.add(menuGestionDeMozos);

        menuGestionDeCajero.setText("Gestión de Cajero");
        menuGestionDeCajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGestionDeCajeroActionPerformed(evt);
            }
        });
        menuGestionDeRestaurante.add(menuGestionDeCajero);

        jMenuItem24.setText("Gestión de Proveedor");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        menuGestionDeRestaurante.add(jMenuItem24);
        menuGestionDeRestaurante.add(jSeparator3);

        jMenuItem23.setText("Salir");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        menuGestionDeRestaurante.add(jMenuItem23);

        menuBarOpciones.add(menuGestionDeRestaurante);

        menuGestionInventario.setText("Módulo Inventario");

        jMenuItem11.setText("Registro de bebidas");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        menuGestionInventario.add(jMenuItem11);

        jMenuItem25.setText("Informe de Stocks");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        menuGestionInventario.add(jMenuItem25);

        menuBarOpciones.add(menuGestionInventario);

        menuGestionDeLaCarta.setText("Módulo Carta");

        menuRegistroPlato.setText("Registro de platos");
        menuRegistroPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistroPlatoActionPerformed(evt);
            }
        });
        menuGestionDeLaCarta.add(menuRegistroPlato);
        menuGestionDeLaCarta.add(jSeparator1);

        menuAlistarCarta.setText("Gestionar Carta");
        menuAlistarCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAlistarCartaActionPerformed(evt);
            }
        });
        menuGestionDeLaCarta.add(menuAlistarCarta);

        menuBarOpciones.add(menuGestionDeLaCarta);

        menuGestionVenta.setText("Módulo Venta");

        menuGestionarVenta.setText("Gestionar Venta");
        menuGestionarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGestionarVentaActionPerformed(evt);
            }
        });
        menuGestionVenta.add(menuGestionarVenta);

        menuBarOpciones.add(menuGestionVenta);

        menuReportes.setText("Reportes");

        jMenuItem2.setText("Reporte de Gastos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuReportes.add(jMenuItem2);

        jMenuItem1.setText("Reporte de Productos mas Vendidos");
        menuReportes.add(jMenuItem1);

        jMenuItem5.setText("Reporte de Ventas de bebidas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuReportes.add(jMenuItem5);

        jMenuItem6.setText("Reporte de Ventas de platos");
        menuReportes.add(jMenuItem6);

        jMenuItem8.setText("Reporte de Ventas Canceladas");
        menuReportes.add(jMenuItem8);

        jMenuItem13.setText("Reporte de Cierre de caja, resumido");
        menuReportes.add(jMenuItem13);
        menuReportes.add(jSeparator6);

        jMenuItem15.setText("Reporte de ventas por empleado");
        menuReportes.add(jMenuItem15);

        jMenuItem17.setText("Reporte de Ventas por el Mes");
        menuReportes.add(jMenuItem17);
        menuReportes.add(jSeparator8);

        jMenuItem18.setText("Lista de productos");
        menuReportes.add(jMenuItem18);

        jMenuItem19.setText("Valoracion del Stock general");
        menuReportes.add(jMenuItem19);

        menuBarOpciones.add(menuReportes);

        menuAyuda.setText("Ayuda");

        jMenuItem3.setText("Contenido de Ayuda ");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuAyuda.add(jMenuItem3);

        jMenuItem4.setText("Acerca De");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuAyuda.add(jMenuItem4);

        menuBarOpciones.add(menuAyuda);

        setJMenuBar(menuBarOpciones);

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

    private void menuGestionDeMozosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGestionDeMozosActionPerformed
        new FormMAGestionarMozo(this).setVisible(true);
    }//GEN-LAST:event_menuGestionDeMozosActionPerformed

    private void menuGestionDeCajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGestionDeCajeroActionPerformed
        new FormMAGestionarCajero(this).setVisible(true);
    }//GEN-LAST:event_menuGestionDeCajeroActionPerformed

    private void menuRegistroPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistroPlatoActionPerformed
        new FormMAGestionarPlato(this).setVisible(true);
    }//GEN-LAST:event_menuRegistroPlatoActionPerformed

    private void menuAlistarCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAlistarCartaActionPerformed
        new FormMAGestionarCarta(this).setVisible(true);
    }//GEN-LAST:event_menuAlistarCartaActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new FormMAGestionarBebida(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new FormMAGestionarAdministrador(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        new FormMAGestionarProveedor(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void menuGestionarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGestionarVentaActionPerformed
        Empleado cajero = buscarCajero();
        new FormMCMenu(this, cajero).setVisible(true);
    }//GEN-LAST:event_menuGestionarVentaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new FormMAReporteBebida(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuItem menuAlistarCarta;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenuBar menuBarOpciones;
    private javax.swing.JMenuItem menuGestionDeCajero;
    private javax.swing.JMenu menuGestionDeLaCarta;
    private javax.swing.JMenuItem menuGestionDeMozos;
    private javax.swing.JMenu menuGestionDeRestaurante;
    private javax.swing.JMenu menuGestionInventario;
    private javax.swing.JMenu menuGestionVenta;
    private javax.swing.JMenuItem menuGestionarVenta;
    private javax.swing.JMenuItem menuRegistroPlato;
    private javax.swing.JMenu menuReportes;
    // End of variables declaration//GEN-END:variables
}
