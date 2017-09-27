package cactussoft.capa1_presentacion;

import cactussoft.capa1_presentacion.util.Formateador;
import cactussoft.capa2_aplicacion.GestionarMesaServicio;
import cactussoft.capa2_aplicacion.GestionarPedidoServicio;
import cactussoft.capa3_dominio.entidades.Empleado;
import cactussoft.capa3_dominio.entidades.Mesa;
import cactussoft.capa3_dominio.entidades.Pedido;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class FormMCMenu extends javax.swing.JDialog {

    private String numeroDeMesa;
    private Empleado cajero;

    public FormMCMenu(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        Formateador.centrarVentanaDialog(this);

        pintarBoton();
    }

    public FormMCMenu(java.awt.Frame parent, Empleado cajero) {
        super(parent, true);
        initComponents();
        Formateador.centrarVentanaDialog(this);

        this.cajero = cajero;
        pintarBoton();
    }

    public ArrayList<JButton> obtenerBotones() {
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

    private void pintarBoton() {
        Mesa mesa;
        int numero = 1;
        ArrayList<JButton> botones = obtenerBotones();
        for (JButton boton : botones) {
            mesa = buscarMesa(Integer.toString(numero));
            if (mesa.estaLibre()) {
                boton.setBackground(Formateador.COLOR_MESA_LIBRE);
            } else {
                boton.setBackground(Formateador.COLOR_MESA_OCUPADO);
            }
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

    public void actualizarPantalla() {
//        FormMCMenu menu = new FormMCMenu();
//        menu.repaint();
//        menu.validate();
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
        FormMCGestionarVenta formGestionarPedido;

        if (mesa.estaLibre()) {
            JOptionPane.showMessageDialog(null, "LA MESA ESTA LIBRE");
        } else if (pedido != null) {
            formGestionarPedido = new FormMCGestionarVenta(this, mesa, pedido, cajero);
            formGestionarPedido.setVisible(true);
            pintarBoton();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        btnMesa43 = new javax.swing.JButton();
        btnMesa44 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("#MESAS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

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

        btnMesa15.setText("13");
        btnMesa15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa16.setText("14");
        btnMesa16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa17.setText("15");
        btnMesa17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa17.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa18.setText("16");
        btnMesa18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa18.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa19.setText("17");
        btnMesa19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa19.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa20.setText("18");
        btnMesa20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa20.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa21.setText("19");
        btnMesa21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa21.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa22.setText("20");
        btnMesa22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa22.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa23.setText("21");
        btnMesa23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa23.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa24.setText("22");
        btnMesa24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa24.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa25.setText("23");
        btnMesa25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa25.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa26.setText("24");
        btnMesa26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa26.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa27.setText("25");
        btnMesa27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa27.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa28.setText("26");
        btnMesa28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa28.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa29.setText("27");
        btnMesa29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa29.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa30.setText("28");
        btnMesa30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa30.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa31.setText("29");
        btnMesa31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa31.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa32.setText("30");
        btnMesa32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa32.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa33.setText("31");
        btnMesa33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa33.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa34.setText("32");
        btnMesa34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa34.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa35.setText("33");
        btnMesa35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa35.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa36.setText("34");
        btnMesa36.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa36.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa37.setText("35");
        btnMesa37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa37.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa38.setText("36");
        btnMesa38.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa38.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa39.setText("13");
        btnMesa39.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa39.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa40.setText("14");
        btnMesa40.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa40.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa41.setText("15");
        btnMesa41.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa41.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa42.setText("16");
        btnMesa42.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa42.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa43.setText("17");
        btnMesa43.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa43.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnMesa44.setText("18");
        btnMesa44.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMesa44.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout panelMesasLayout = new javax.swing.GroupLayout(panelMesas);
        panelMesas.setLayout(panelMesasLayout);
        panelMesasLayout.setHorizontalGroup(
            panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMesasLayout.createSequentialGroup()
                        .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMesa7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMesa15, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesasLayout.createSequentialGroup()
                                .addComponent(btnMesa16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa17, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa18, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMesa20, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMesasLayout.createSequentialGroup()
                                .addComponent(btnMesa8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMesasLayout.createSequentialGroup()
                                .addComponent(btnMesa2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMesa6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelMesasLayout.createSequentialGroup()
                        .addComponent(btnMesa21, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMesa22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa23, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa24, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa25, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa26, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesasLayout.createSequentialGroup()
                        .addComponent(btnMesa27, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMesa28, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa29, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa30, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa31, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa32, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMesasLayout.createSequentialGroup()
                        .addComponent(btnMesa33, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMesa34, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa36, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa37, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa38, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesasLayout.createSequentialGroup()
                        .addComponent(btnMesa39, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMesa40, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa41, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa42, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa43, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMesa44)))
                .addContainerGap())
        );

        panelMesasLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnMesa1, btnMesa10, btnMesa11, btnMesa12, btnMesa15, btnMesa16, btnMesa17, btnMesa18, btnMesa19, btnMesa2, btnMesa20, btnMesa21, btnMesa22, btnMesa23, btnMesa24, btnMesa25, btnMesa26, btnMesa27, btnMesa28, btnMesa29, btnMesa3, btnMesa30, btnMesa31, btnMesa32, btnMesa33, btnMesa34, btnMesa35, btnMesa36, btnMesa37, btnMesa38, btnMesa39, btnMesa4, btnMesa40, btnMesa41, btnMesa42, btnMesa43, btnMesa44, btnMesa5, btnMesa6, btnMesa7, btnMesa8, btnMesa9});

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
                    .addComponent(btnMesa15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa17, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa18, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa20, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMesa21, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa22, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa23, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa24, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa25, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa26, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMesa27, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa28, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa29, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa30, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa31, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa32, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMesa33, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa34, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa35, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa36, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa37, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa38, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMesa39, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa40, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa41, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa42, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa43, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMesa44, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelMesasLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnMesa1, btnMesa10, btnMesa11, btnMesa12, btnMesa15, btnMesa16, btnMesa17, btnMesa18, btnMesa19, btnMesa2, btnMesa20, btnMesa21, btnMesa22, btnMesa23, btnMesa24, btnMesa25, btnMesa26, btnMesa27, btnMesa28, btnMesa29, btnMesa3, btnMesa30, btnMesa31, btnMesa32, btnMesa33, btnMesa34, btnMesa35, btnMesa36, btnMesa37, btnMesa38, btnMesa39, btnMesa4, btnMesa40, btnMesa41, btnMesa42, btnMesa43, btnMesa44, btnMesa5, btnMesa6, btnMesa7, btnMesa8, btnMesa9});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JButton btnMesa1;
    private javax.swing.JButton btnMesa10;
    private javax.swing.JButton btnMesa11;
    private javax.swing.JButton btnMesa12;
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
    private javax.swing.JButton btnMesa43;
    private javax.swing.JButton btnMesa44;
    private javax.swing.JButton btnMesa5;
    private javax.swing.JButton btnMesa6;
    private javax.swing.JButton btnMesa7;
    private javax.swing.JButton btnMesa8;
    private javax.swing.JButton btnMesa9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel panelMesas;
    // End of variables declaration//GEN-END:variables
}
