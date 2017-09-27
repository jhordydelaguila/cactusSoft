package cactussoftMP.capa1_presentacion;

import cactussoft.capa1_presentacion.util.Formateador;
import cactussoft.capa2_aplicacion.GestionarMesaServicio;
import cactussoft.capa2_aplicacion.GestionarPedidoServicio;
import cactussoft.capa3_dominio.entidades.Mesa;
import cactussoft.capa3_dominio.entidades.MesaPedido;
import cactussoft.capa3_dominio.entidades.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class FormMPMenu extends javax.swing.JFrame {

    private String numeroDeMesa;

    public FormMPMenu() {
        asignarLookandfeel();
        initComponents();
        Formateador.extenderVentanaFrameCompleta(this);

//        Formateador.insertarImagenEnBoton(obtenerBotones(), obtenerImagen());
        pintarBoton();
    }

    private ArrayList<JButton> obtenerBotones() {
        ArrayList<JButton> botones = new ArrayList<>();
        botones.add(btnMesa1);
        botones.add(btnMesa2);
        botones.add(btnMesa3);
        botones.add(btnMesa4);
        botones.add(btnMesa5);
        botones.add(btnMesa6);
        botones.add(btnMesa7);
        botones.add(btnMesa8);
        botones.add(btnMesa9);
        botones.add(btnMesa10);
        botones.add(btnMesa11);
        botones.add(btnMesa12);
        return botones;
    }

//    private ImageIcon obtenerImagen() {
//        ImageIcon imagen = new ImageIcon(getClass().getResource("/cactusMP/capa1_presentacion/imagenes/32_32_mesa.png"));
//        return imagen;
//    }

    private void pintarBoton() {
        Mesa mesa;
        int numero = 1;
        ArrayList<JButton> botones = obtenerBotones();
        for (JButton boton : botones) {
            mesa = buscarMesa(Integer.toString(numero));
            if (mesa.estaLibre())
                boton.setBackground(Formateador.COLOR_MESA_LIBRE);
            else 
                boton.setBackground(Formateador.COLOR_MESA_OCUPADO);
            numero++;
        }
    }

    private Mesa buscarMesa(String numeroDeMesa) {
        GestionarMesaServicio gestionarMesaServicio = new GestionarMesaServicio();
        try {
            Mesa mesa = gestionarMesaServicio.buscarMesa(numeroDeMesa);
            return mesa;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return null;
    }

    private Pedido buscarPedido(String numeroDeMesa) {
        GestionarPedidoServicio gestionarPedidoServicio = new GestionarPedidoServicio();
        try {
            Pedido pedido = gestionarPedidoServicio.buscarPedidoPorMesa(numeroDeMesa);
            return pedido;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return null;
    }
    
    private void buscar(String numeroDeMesa) {
        Mesa mesa = buscarMesa(numeroDeMesa);
        Pedido pedido = buscarPedido(numeroDeMesa);
        FormMPGestionarPedido  formGestionarPedido;
        
        if (mesa.estaLibre()) {
            formGestionarPedido = new FormMPGestionarPedido(this,mesa);
            formGestionarPedido.setVisible(true);
            pintarBoton();
        } else {
            if (pedido != null) {
                formGestionarPedido = new FormMPGestionarPedido(this, pedido,mesa);
                formGestionarPedido.setVisible(true);
            }
        }       
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
            java.util.logging.Logger.getLogger(FormMPMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMPMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMPMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMPMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoVerMesas = new javax.swing.JTextArea();
        btnVerMesasUnidas = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        panelMesas = new javax.swing.JPanel();
        btnMesa1 = new javax.swing.JButton();
        btnMesa2 = new javax.swing.JButton();
        btnMesa3 = new javax.swing.JButton();
        btnMesa4 = new javax.swing.JButton();
        btnMesa5 = new javax.swing.JButton();
        btnMesa6 = new javax.swing.JButton();
        btnMesa7 = new javax.swing.JButton();
        btnMesa8 = new javax.swing.JButton();
        btnMesa9 = new javax.swing.JButton();
        btnMesa10 = new javax.swing.JButton();
        btnMesa11 = new javax.swing.JButton();
        btnMesa12 = new javax.swing.JButton();
        btnMesa13 = new javax.swing.JButton();
        btnMesa14 = new javax.swing.JButton();
        btnMesa15 = new javax.swing.JButton();
        btnMesa16 = new javax.swing.JButton();
        btnMesa17 = new javax.swing.JButton();
        btnMesa18 = new javax.swing.JButton();
        btnMesa19 = new javax.swing.JButton();
        btnMesa20 = new javax.swing.JButton();
        btnMesa21 = new javax.swing.JButton();
        btnMesa22 = new javax.swing.JButton();
        btnMesa23 = new javax.swing.JButton();
        btnMesa24 = new javax.swing.JButton();
        btnMesa25 = new javax.swing.JButton();
        btnMesa26 = new javax.swing.JButton();
        btnMesa27 = new javax.swing.JButton();
        btnMesa28 = new javax.swing.JButton();
        btnMesa29 = new javax.swing.JButton();
        btnMesa30 = new javax.swing.JButton();
        btnMesa31 = new javax.swing.JButton();
        btnMesa32 = new javax.swing.JButton();
        btnMesa33 = new javax.swing.JButton();
        btnMesa34 = new javax.swing.JButton();
        btnMesa35 = new javax.swing.JButton();
        btnMesa36 = new javax.swing.JButton();
        btnMesa37 = new javax.swing.JButton();
        btnMesa38 = new javax.swing.JButton();
        btnMesa39 = new javax.swing.JButton();
        btnMesa40 = new javax.swing.JButton();
        btnMesa41 = new javax.swing.JButton();
        btnMesa42 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        botSalir = new javax.swing.JButton();
        btnUnirMesa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modulo Pedido - Restaurante el Cactus");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("LOGO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel2)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel2)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jLabel1.setText("Panel de Mensajes");

        jLabel21.setText("Ver las mesas que sean unido.");

        textoVerMesas.setEditable(false);
        textoVerMesas.setColumns(20);
        textoVerMesas.setRows(5);
        jScrollPane1.setViewportView(textoVerMesas);

        btnVerMesasUnidas.setText("VER MESAS UNIDAS");
        btnVerMesasUnidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMesasUnidasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(35, 35, 35)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVerMesasUnidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerMesasUnidas)
                .addContainerGap())
        );

        jTabbedPane1.addTab("VER MESAS UNIDAS", jPanel2);

        jLabel6.setText("Estado de mesas");

        jButton3.setBackground(new java.awt.Color(0, 255, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Libre");
        jButton3.setBorder(null);

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Ocupado");
        jButton4.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton3, jButton4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(284, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton3, jButton4});

        jTabbedPane1.addTab("LEYENDA", jPanel1);

        panelMesas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnMesa1.setText("1");
        btnMesa1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa1ActionPerformed(evt);
            }
        });

        btnMesa2.setText("2");
        btnMesa2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa2ActionPerformed(evt);
            }
        });

        btnMesa3.setText("3");
        btnMesa3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa3ActionPerformed(evt);
            }
        });

        btnMesa4.setText("4");
        btnMesa4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa4ActionPerformed(evt);
            }
        });

        btnMesa5.setText("5");
        btnMesa5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa5ActionPerformed(evt);
            }
        });

        btnMesa6.setText("6");
        btnMesa6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa6ActionPerformed(evt);
            }
        });

        btnMesa7.setText("7");
        btnMesa7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa7ActionPerformed(evt);
            }
        });

        btnMesa8.setText("8");
        btnMesa8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa8ActionPerformed(evt);
            }
        });

        btnMesa9.setText("9");
        btnMesa9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa9ActionPerformed(evt);
            }
        });

        btnMesa10.setText("10");
        btnMesa10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa10ActionPerformed(evt);
            }
        });

        btnMesa11.setText("11");
        btnMesa11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa11ActionPerformed(evt);
            }
        });

        btnMesa12.setText("12");
        btnMesa12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa12ActionPerformed(evt);
            }
        });

        btnMesa13.setText("13");
        btnMesa13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa14.setText("14");
        btnMesa14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa15.setText("15");
        btnMesa15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa16.setText("16");
        btnMesa16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa17.setText("17");
        btnMesa17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa17.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa18.setText("18");
        btnMesa18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa18.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa19.setText("19");
        btnMesa19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa19.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa20.setText("20");
        btnMesa20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa20.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa21.setText("21");
        btnMesa21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa21.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa22.setText("22");
        btnMesa22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa22.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa23.setText("23");
        btnMesa23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa23.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa24.setText("24");
        btnMesa24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa24.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa25.setText("25");
        btnMesa25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa25.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa26.setText("26");
        btnMesa26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa26.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa27.setText("27");
        btnMesa27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa27.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa28.setText("28");
        btnMesa28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa28.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa29.setText("29");
        btnMesa29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa29.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa30.setText("30");
        btnMesa30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa30.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa31.setText("31");
        btnMesa31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa31.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa32.setText("32");
        btnMesa32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa32.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa33.setText("33");
        btnMesa33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa33.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa34.setText("34");
        btnMesa34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa34.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa35.setText("35");
        btnMesa35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa35.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa36.setText("36");
        btnMesa36.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa36.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa37.setText("13");
        btnMesa37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa37.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa38.setText("14");
        btnMesa38.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa38.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa39.setText("15");
        btnMesa39.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa39.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa40.setText("16");
        btnMesa40.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa40.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa41.setText("17");
        btnMesa41.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa41.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa42.setText("18");
        btnMesa42.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa42.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout panelMesasLayout = new javax.swing.GroupLayout(panelMesas);
        panelMesas.setLayout(panelMesasLayout);
        panelMesasLayout.setHorizontalGroup(
            panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMesasLayout.createSequentialGroup()
                        .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMesa7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMesa13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesasLayout.createSequentialGroup()
                                .addComponent(btnMesa8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa12))
                            .addGroup(panelMesasLayout.createSequentialGroup()
                                .addComponent(btnMesa14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa18))
                            .addGroup(panelMesasLayout.createSequentialGroup()
                                .addComponent(btnMesa2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa6)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelMesasLayout.createSequentialGroup()
                        .addComponent(btnMesa19, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMesa20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesasLayout.createSequentialGroup()
                        .addComponent(btnMesa25, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMesa26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa30))
                    .addGroup(panelMesasLayout.createSequentialGroup()
                        .addComponent(btnMesa31, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMesa32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesasLayout.createSequentialGroup()
                        .addComponent(btnMesa37, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMesa38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa42)))
                .addContainerGap())
        );

        panelMesasLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnMesa1, btnMesa10, btnMesa11, btnMesa12, btnMesa13, btnMesa14, btnMesa15, btnMesa16, btnMesa17, btnMesa18, btnMesa19, btnMesa2, btnMesa20, btnMesa21, btnMesa22, btnMesa23, btnMesa24, btnMesa25, btnMesa26, btnMesa27, btnMesa28, btnMesa29, btnMesa3, btnMesa30, btnMesa31, btnMesa32, btnMesa33, btnMesa34, btnMesa35, btnMesa36, btnMesa37, btnMesa38, btnMesa39, btnMesa4, btnMesa40, btnMesa41, btnMesa42, btnMesa5, btnMesa6, btnMesa7, btnMesa8, btnMesa9});

        panelMesasLayout.setVerticalGroup(
            panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMesa2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMesa7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMesa13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa17, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa18, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMesa19, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa20, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa21, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa22, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa23, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa24, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMesa25, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa26, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa27, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa28, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa29, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa30, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMesa31, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa32, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa33, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa34, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa35, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa36, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMesa37, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa38, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa39, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa40, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa41, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa42, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelMesasLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnMesa1, btnMesa10, btnMesa11, btnMesa12, btnMesa13, btnMesa14, btnMesa15, btnMesa16, btnMesa17, btnMesa18, btnMesa19, btnMesa2, btnMesa20, btnMesa21, btnMesa22, btnMesa23, btnMesa24, btnMesa25, btnMesa26, btnMesa27, btnMesa28, btnMesa29, btnMesa3, btnMesa30, btnMesa31, btnMesa32, btnMesa33, btnMesa34, btnMesa35, btnMesa36, btnMesa37, btnMesa38, btnMesa39, btnMesa4, btnMesa40, btnMesa41, btnMesa42, btnMesa5, btnMesa6, btnMesa7, btnMesa8, btnMesa9});

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("#Mesas");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("RESTAURANTE EL CAPTUS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 494, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        botSalir.setText("SALIR (Alt + 10)");
        botSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSalirActionPerformed(evt);
            }
        });

        btnUnirMesa.setText("UNIR MESA");
        btnUnirMesa.setFocusable(false);
        btnUnirMesa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUnirMesa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUnirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnirMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUnirMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botSalir)
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botSalir, btnUnirMesa});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUnirMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botSalir, btnUnirMesa});

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(panelMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 54, Short.MAX_VALUE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTabbedPane1)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUnirMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnirMesaActionPerformed
        FormMPUnirMesa formUnirMesa = new FormMPUnirMesa(this);
        formUnirMesa.setVisible(true);
        pintarBoton();
    }//GEN-LAST:event_btnUnirMesaActionPerformed

    private void botSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botSalirActionPerformed

    private void btnVerMesasUnidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMesasUnidasActionPerformed
        textoVerMesas.setText("");
        GestionarMesaServicio gestionarMesaServicio = new GestionarMesaServicio();
        int temporal = 0;
        int anterior = 0;
        int contador = 0;
        try {
            List<MesaPedido> mesaspedido = gestionarMesaServicio.mostrarMesasOcupado();
            textoVerMesas.setText("==> LAS MESAS\n\n");
            for (MesaPedido mesaPedido: mesaspedido) {
                temporal = mesaPedido.getPedidoid();
                if (mesaPedido.getPedidoid() == mesaPedido.getUnirMesa()) {
                    contador++;
                    if (contador == 1) {
                        anterior = temporal;
                        textoVerMesas.append("" + mesaPedido.getMesa().getNumero() + ", ");
                    } else {
                        if (anterior!=temporal) {
                            textoVerMesas.append("\n");
                            textoVerMesas.append("======================");
                            textoVerMesas.append("\n");
                            anterior = temporal;
                        }
                        textoVerMesas.append("" + mesaPedido.getMesa().getNumero() + ", ");
                    }
                } else{ 
                    textoVerMesas.append("\n\n");
                    contador=0;
                } 
            }
            textoVerMesas.append("\n\nTIENEN EL MISMO PEDIDO.");
        } catch (Exception e) {
                
        }

    }//GEN-LAST:event_btnVerMesasUnidasActionPerformed

    private void btnMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa1ActionPerformed
        numeroDeMesa = "1";
        buscar(numeroDeMesa);
    }//GEN-LAST:event_btnMesa1ActionPerformed

    private void btnMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa2ActionPerformed
        numeroDeMesa = "2";
        buscar(numeroDeMesa);
    }//GEN-LAST:event_btnMesa2ActionPerformed

    private void btnMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa3ActionPerformed
        numeroDeMesa = "3";
        buscar(numeroDeMesa);
    }//GEN-LAST:event_btnMesa3ActionPerformed

    private void btnMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa4ActionPerformed
        numeroDeMesa = "4";
        buscar(numeroDeMesa);
    }//GEN-LAST:event_btnMesa4ActionPerformed

    private void btnMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa5ActionPerformed
        numeroDeMesa = "5";
        buscar(numeroDeMesa);
    }//GEN-LAST:event_btnMesa5ActionPerformed

    private void btnMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa6ActionPerformed
        numeroDeMesa = "6";
        buscar(numeroDeMesa);
    }//GEN-LAST:event_btnMesa6ActionPerformed

    private void btnMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa7ActionPerformed
        numeroDeMesa = "7";
        buscar(numeroDeMesa);
    }//GEN-LAST:event_btnMesa7ActionPerformed

    private void btnMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa8ActionPerformed
        numeroDeMesa = "8";
        buscar(numeroDeMesa);
    }//GEN-LAST:event_btnMesa8ActionPerformed

    private void btnMesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa9ActionPerformed
        numeroDeMesa = "9";
        buscar(numeroDeMesa);
    }//GEN-LAST:event_btnMesa9ActionPerformed

    private void btnMesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa10ActionPerformed
        numeroDeMesa = "10";
        buscar(numeroDeMesa);
    }//GEN-LAST:event_btnMesa10ActionPerformed

    private void btnMesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa11ActionPerformed
        numeroDeMesa = "11";
        buscar(numeroDeMesa);
    }//GEN-LAST:event_btnMesa11ActionPerformed

    private void btnMesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa12ActionPerformed
        numeroDeMesa = "12";
        buscar(numeroDeMesa);
    }//GEN-LAST:event_btnMesa12ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botSalir;
    private javax.swing.JButton btnMesa1;
    private javax.swing.JButton btnMesa10;
    private javax.swing.JButton btnMesa11;
    private javax.swing.JButton btnMesa12;
    private javax.swing.JButton btnMesa13;
    private javax.swing.JButton btnMesa14;
    private javax.swing.JButton btnMesa15;
    private javax.swing.JButton btnMesa16;
    private javax.swing.JButton btnMesa17;
    private javax.swing.JButton btnMesa18;
    private javax.swing.JButton btnMesa19;
    private javax.swing.JButton btnMesa2;
    private javax.swing.JButton btnMesa20;
    private javax.swing.JButton btnMesa21;
    private javax.swing.JButton btnMesa22;
    private javax.swing.JButton btnMesa23;
    private javax.swing.JButton btnMesa24;
    private javax.swing.JButton btnMesa25;
    private javax.swing.JButton btnMesa26;
    private javax.swing.JButton btnMesa27;
    private javax.swing.JButton btnMesa28;
    private javax.swing.JButton btnMesa29;
    private javax.swing.JButton btnMesa3;
    private javax.swing.JButton btnMesa30;
    private javax.swing.JButton btnMesa31;
    private javax.swing.JButton btnMesa32;
    private javax.swing.JButton btnMesa33;
    private javax.swing.JButton btnMesa34;
    private javax.swing.JButton btnMesa35;
    private javax.swing.JButton btnMesa36;
    private javax.swing.JButton btnMesa37;
    private javax.swing.JButton btnMesa38;
    private javax.swing.JButton btnMesa39;
    private javax.swing.JButton btnMesa4;
    private javax.swing.JButton btnMesa40;
    private javax.swing.JButton btnMesa41;
    private javax.swing.JButton btnMesa42;
    private javax.swing.JButton btnMesa5;
    private javax.swing.JButton btnMesa6;
    private javax.swing.JButton btnMesa7;
    private javax.swing.JButton btnMesa8;
    private javax.swing.JButton btnMesa9;
    private javax.swing.JButton btnUnirMesa;
    private javax.swing.JButton btnVerMesasUnidas;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelMesas;
    private javax.swing.JTextArea textoVerMesas;
    // End of variables declaration//GEN-END:variables
}
