package cactussoftMP.capa1_presentacion;

import cactussoft.capa1_presentacion.util.Clock;
import cactussoft.capa1_presentacion.util.ConfiguradorDeTabla;
import cactussoft.capa1_presentacion.util.Constantes;
import cactussoft.capa1_presentacion.util.Formateador;
import cactussoft.capa1_presentacion.util.Mensaje;
import cactussoft.capa2_aplicacion.GestionarCartaServicio;
import cactussoft.capa2_aplicacion.GestionarMozoServicio;
import cactussoft.capa2_aplicacion.GestionarPedidoServicio;
import cactussoft.capa3_dominio.entidades.Bebida;
import cactussoft.capa3_dominio.entidades.BebidaPedido;
import cactussoft.capa3_dominio.entidades.Carta;
import cactussoft.capa3_dominio.entidades.Categoria;
import cactussoft.capa3_dominio.entidades.Mesa;
import cactussoft.capa3_dominio.entidades.Mozo;
import cactussoft.capa3_dominio.entidades.Pedido;
import cactussoft.capa3_dominio.entidades.Plato;
import cactussoft.capa3_dominio.entidades.PlatoPedido;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Fila;

public class FormMPGestionarPedido extends javax.swing.JDialog implements Runnable {

    private Pedido pedido;
    private Mesa mesa;
    private int tipo_accion;
    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private final int ACCION_UNIR = 3;
    //reloj
    Thread hiloclock = new Thread(this);

    public FormMPGestionarPedido(JFrame owener, Mesa mesa) {
        super(owener, true);
        initComponents();
        tablaPedido.setModel(ConfiguradorDeTabla.crearTablaPedido());

        this.mesa = mesa;
        this.pedido = new Pedido();
        tipo_accion = ACCION_CREAR;
        agregarDatosPanelInicio(pedido, mesa);
        agregarCartaEnComboBox();
        agregarObservacion();
        obtenerBotones();
        activarCategorias();

    }

    public FormMPGestionarPedido(JFrame owner, Pedido pedido, Mesa mesa) {
        super(owner, true);
        initComponents();
        tablaPedido.setModel(ConfiguradorDeTabla.crearTablaPedido());

        this.pedido = pedido;
        this.mesa = mesa;
        tipo_accion = ACCION_MODIFICAR;
        agregarDatosPanelInicio(pedido, mesa);
        agregarCartaEnComboBox();
        agregarObservacion();
        obtenerBotones();
        activarCategorias();
        mostrarPedido();
    }

    public FormMPGestionarPedido(JDialog owner, Pedido pedido, Mesa mesa) {
        super(owner, true);
        initComponents();
        tablaPedido.setModel(ConfiguradorDeTabla.crearTablaPedido());

        this.pedido = pedido;
        tipo_accion = ACCION_UNIR;
        agregarDatosPanelInicio(pedido, mesa);
        agregarCartaEnComboBox();
        agregarObservacion();
        obtenerBotones();
        activarCategorias();
    }

    private void agregarDatosPanelInicio(Pedido pedido, Mesa mesa) {
        switch (tipo_accion) {
            case ACCION_CREAR:
                labelNumeroMesa.setText(mesa.getNumero());
                labelNombreMozo.setText("NO ESPECIFICADO");
                botDisponibilidad.setBackground(Formateador.COLOR_MESA_LIBRE);
                lblFecha.setText("" + pedido.getFecha());
                hiloclock.start();
                break;
            case ACCION_MODIFICAR:
                labelNombreMozo.setText(pedido.getMozo().getNombre().toUpperCase());
                labelNumeroMesa.setText(mesa.getNumero());
                botDisponibilidad.setBackground(Formateador.COLOR_MESA_OCUPADO);
                lblFecha.setText("" + pedido.getFecha());
                hiloclock.start();
                break;
            case ACCION_UNIR:
                labelNombreMozo.setText("NO ESPECIFICADO");
                labelNumeroMesa.setText("MESAS UNIDAS");
                botDisponibilidad.setBackground(Formateador.COLOR_MESA_LIBRE);
                break;
        }
    }

    private void obtenerBotones() {
        ArrayList<JButton> botones = new ArrayList<>();
        botones.add(btnArroz);
        botones.add(btnCaprichosMarinos);
        botones.add(btnCebiches);
        botones.add(btnChicharron);
        botones.add(btnChupes);
        botones.add(btnCriollos);
        botones.add(btnEspeciales);
        botones.add(btnParihuelas);
        botones.add(btnPicantes);
        botones.add(btnSopas);
        botones.add(btnSudados);
        botones.add(btnTortillas);

        for (JButton boton : botones) {
            boton.setEnabled(false);
        }
    }

    private void activarCategorias() {
        GestionarCartaServicio gestionarCartaServicio = new GestionarCartaServicio();
        try {
            List<Categoria> categorias = gestionarCartaServicio.buscarCategoriasEnCarta();
            for (Categoria categoria : categorias) {
                if (categoria.getNombre().equals(Categoria.CATEGORIA_ARROZ)) {
                    btnArroz.setEnabled(true);
                } else if (categoria.getNombre().equals(Categoria.CATEGORIA_CAPRICHOS_MARINOS)) {
                    btnCaprichosMarinos.setEnabled(true);
                } else if (categoria.getNombre().equals(Categoria.CATEGORIA_TORTILLAS)) {
                    btnTortillas.setEnabled(true);
                } else if (categoria.getNombre().equals(Categoria.CATEGORIA_CEBICHES)) {
                    btnCebiches.setEnabled(true);
                } else if (categoria.getNombre().equals(Categoria.CATEGORIA_CHICHARON)) {
                    btnChicharron.setEnabled(true);
                } else if (categoria.getNombre().equals(Categoria.CATEGORIA_CHUPES)) {
                    btnChupes.setEnabled(true);
                } else if (categoria.getNombre().equals(Categoria.CATEGORIA_CRIOLLOS)) {
                    btnCriollos.setEnabled(true);
                } else if (categoria.getNombre().equals(Categoria.CATEGORIA_ESPECIALES)) {
                    btnEspeciales.setEnabled(true);
                } else if (categoria.getNombre().equals(Categoria.CATEGORIA_PARIHUELAS)) {
                    btnParihuelas.setEnabled(true);
                } else if (categoria.getNombre().equals(Categoria.CATEGORIA_PICANTES)) {
                    btnPicantes.setEnabled(true);
                } else if (categoria.getNombre().equals(Categoria.CATEGORIA_SOPAS)) {
                    btnSopas.setEnabled(true);
                } else if (categoria.getNombre().equals(Categoria.CATEGORIA_SUDADOS)) {
                    btnSudados.setEnabled(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    private void agregarCartaEnComboBox() {
        GestionarCartaServicio gestionarCartaServicio = new GestionarCartaServicio();
        try {
            Carta carta = gestionarCartaServicio.mostrarCarta();
            comboNombre.removeAllItems();
            comboNombre.addItem(carta.getNombre());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void agregarObservacion() {
        txtObservacion.setText("");
        txtObservacion.append("==> Los platos: ");
        txtObservacion.append("\n\n");

        for (PlatoPedido platoPedido : pedido.getPlatos()) {
            if (platoPedido.tieneObservacion()) {
                txtObservacion.append(platoPedido.getPlato().getNombre().toUpperCase());
                txtObservacion.append(" <== observación ==> ");
                txtObservacion.append(platoPedido.getObservacion().toUpperCase());
                txtObservacion.append("\n\n");
            }
        }
    }

    private void buscarPlato(String nombreDeLaCategoria) {
        GestionarCartaServicio gestionarCartaServicio = new GestionarCartaServicio();
        try {
            List<Categoria> categorias = gestionarCartaServicio.buscarCategoriasEnCarta();
            if (categorias != null) {
                Categoria categoria = new Categoria();
                if (categoria.encuentraCategoria(categorias, nombreDeLaCategoria)) {
                    FormMPBuscarPlato formBuscarPlatoDatos = new FormMPBuscarPlato(this, nombreDeLaCategoria);
                    formBuscarPlatoDatos.setVisible(true);
                    // Aca obtenemos el plato y agregamos al pedido
                    Plato plato = formBuscarPlatoDatos.obtenerPlato;
                    if (plato != null && !pedido.datosIgualesPlato(plato.getPlatoid())) {
                        pedido.agregarPlatoPedido(plato, 1, "");
                        mostrarPedido();
                    }
                    // termina la funcion de agregar al pedido
                } else {
                    JOptionPane.showMessageDialog(this, "No se encuentran platos registrados \n"
                            + "en la carta: \n" + nombreDeLaCategoria);
                }
            }
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
    }

    private void buscarBebida(String nombreCategoria) {
        FormMPBuscarBebida formBuscarBebida = new FormMPBuscarBebida(this, nombreCategoria);
        formBuscarBebida.setVisible(true);

        int cantidad = 1;
        Bebida bebida = formBuscarBebida.obtenerBebida;
        if (bebida != null && !pedido.datosIgualesBebida(bebida.getBebidaid())) {
            try {
                if (bebida.validarStock()) {                   
                    pedido.agregarBebidaPedido(bebida, cantidad);
//                    pedido.aumentarCantidadBebida(bebida.getNombre(), cantidad);
                    mostrarPedido();
                }
            } catch (Exception e) {
                Mensaje.mostrarAdvertencia(this, e.getMessage());
            }
        }

    }

    private void mostrarPedido() {
        Fila fila;
        ModeloTabla modeloTabla = (ModeloTabla) tablaPedido.getModel();
        modeloTabla.eliminarTotalFilas();
        for (PlatoPedido platoPedido : pedido.getPlatos()) {
            fila = new Fila();
            fila.agregarValorCelda(platoPedido.getPlato().getPlatoid());
            fila.agregarValorCelda(platoPedido.getPlato().getNombre());
            fila.agregarValorCelda(platoPedido.getCantidad());
            fila.agregarValorCelda(platoPedido.getPrecio());
            fila.agregarValorCelda(platoPedido.calcularSubTotal());
            modeloTabla.agregarFila(fila);
        }

        for (BebidaPedido bebidaPedido : pedido.getBebidas()) {
            fila = new Fila();
            fila.agregarValorCelda(bebidaPedido.getBebida().getBebidaid());
            fila.agregarValorCelda(bebidaPedido.getBebida().getNombre());
            fila.agregarValorCelda(bebidaPedido.getCantidad());
            fila.agregarValorCelda(bebidaPedido.getPrecio());
            fila.agregarValorCelda(bebidaPedido.calcularSubTotal());
            modeloTabla.agregarFila(fila);
        }

        agregarTextoMontoTotal(pedido);
    }

    private Mozo buscarMozo(String codigo) {
        GestionarMozoServicio gestionarMozoServicio = new GestionarMozoServicio();
        Mozo mozo = null;
        if (!codigo.equals("")) {
            try {
                mozo = gestionarMozoServicio.buscarMozo(codigo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        return mozo;
    }

    private void agregarTextoMontoTotal(Pedido pedido) {
        labelTotal.setText(String.valueOf(pedido.calcularMontoTotal()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedido = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelCarta = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboNombre = new javax.swing.JComboBox<>();
        btnCaprichosMarinos = new javax.swing.JButton();
        btnArroz = new javax.swing.JButton();
        btnCebiches = new javax.swing.JButton();
        btnCriollos = new javax.swing.JButton();
        btnEspeciales = new javax.swing.JButton();
        btnChupes = new javax.swing.JButton();
        btnSopas = new javax.swing.JButton();
        btnPicantes = new javax.swing.JButton();
        btnSudados = new javax.swing.JButton();
        btnChicharron = new javax.swing.JButton();
        btnParihuelas = new javax.swing.JButton();
        btnTortillas = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        botRefresco = new javax.swing.JButton();
        botGaseosa = new javax.swing.JButton();
        botCerveza = new javax.swing.JButton();
        btnAgua = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        botCancelar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        botDisponibilidad = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelNumeroMesa = new javax.swing.JLabel();
        lblMozo = new javax.swing.JLabel();
        labelNombreMozo = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnDisminuirCantidad = new javax.swing.JButton();
        btnAumenarCantidad = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        botAgregarObservacion = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Toma de Pedido - Restaurante Cactus");
        setMinimumSize(null);
        setUndecorated(true);

        tablaPedido.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaPedido.setMinimumSize(new java.awt.Dimension(60, 96));
        tablaPedido.setRequestFocusEnabled(false);
        tablaPedido.setRowHeight(25);
        jScrollPane1.setViewportView(tablaPedido);

        jLabel3.setText("Nombre");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(comboNombre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboNombre, jLabel3});

        btnCaprichosMarinos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoftMP/capa1_presentacion/recursos/153_52_Caprichos Marinos.png"))); // NOI18N
        btnCaprichosMarinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaprichosMarinosActionPerformed(evt);
            }
        });

        btnArroz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoftMP/capa1_presentacion/recursos/153_52_Arroz.png"))); // NOI18N
        btnArroz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArrozActionPerformed(evt);
            }
        });

        btnCebiches.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoftMP/capa1_presentacion/recursos/153_52_Cebiches.png"))); // NOI18N
        btnCebiches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCebichesActionPerformed(evt);
            }
        });

        btnCriollos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoftMP/capa1_presentacion/recursos/153_52_Criollos.png"))); // NOI18N
        btnCriollos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriollosActionPerformed(evt);
            }
        });

        btnEspeciales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoftMP/capa1_presentacion/recursos/153_52_Especiales.png"))); // NOI18N
        btnEspeciales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEspecialesActionPerformed(evt);
            }
        });

        btnChupes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoftMP/capa1_presentacion/recursos/153_52_Chupes.png"))); // NOI18N
        btnChupes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChupesActionPerformed(evt);
            }
        });

        btnSopas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoftMP/capa1_presentacion/recursos/153_52_Sopas.png"))); // NOI18N
        btnSopas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSopasActionPerformed(evt);
            }
        });

        btnPicantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoftMP/capa1_presentacion/recursos/153_52_Picantes.png"))); // NOI18N
        btnPicantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPicantesActionPerformed(evt);
            }
        });

        btnSudados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoftMP/capa1_presentacion/recursos/153_52_Sudados.png"))); // NOI18N
        btnSudados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSudadosActionPerformed(evt);
            }
        });

        btnChicharron.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoftMP/capa1_presentacion/recursos/153_52_Chicharrones.png"))); // NOI18N
        btnChicharron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChicharronActionPerformed(evt);
            }
        });

        btnParihuelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoftMP/capa1_presentacion/recursos/153_52_Parihuelas.png"))); // NOI18N
        btnParihuelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParihuelasActionPerformed(evt);
            }
        });

        btnTortillas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cactussoftMP/capa1_presentacion/recursos/153_52_Tortillas.png"))); // NOI18N
        btnTortillas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTortillasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCartaLayout = new javax.swing.GroupLayout(panelCarta);
        panelCarta.setLayout(panelCartaLayout);
        panelCartaLayout.setHorizontalGroup(
            panelCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCartaLayout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addGroup(panelCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCartaLayout.createSequentialGroup()
                        .addComponent(btnChicharron, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnParihuelas, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTortillas, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCartaLayout.createSequentialGroup()
                        .addGroup(panelCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnArroz, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCaprichosMarinos, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCebiches, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnCriollos, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnChupes, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEspeciales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSopas, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPicantes, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSudados, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        panelCartaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnArroz, btnCaprichosMarinos, btnCebiches, btnChicharron, btnChupes, btnCriollos, btnEspeciales, btnParihuelas, btnPicantes, btnSopas, btnSudados, btnTortillas});

        panelCartaLayout.setVerticalGroup(
            panelCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCartaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCartaLayout.createSequentialGroup()
                        .addComponent(btnPicantes, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSopas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSudados, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCartaLayout.createSequentialGroup()
                        .addComponent(btnArroz, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCaprichosMarinos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCebiches))
                    .addGroup(panelCartaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnChupes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCriollos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEspeciales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnParihuelas)
                    .addComponent(btnChicharron)
                    .addComponent(btnTortillas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        panelCartaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnArroz, btnCaprichosMarinos, btnCebiches, btnChicharron, btnChupes, btnCriollos, btnEspeciales, btnParihuelas, btnPicantes, btnSopas, btnSudados, btnTortillas});

        jTabbedPane1.addTab("CARTA", panelCarta);

        botRefresco.setText("Refresco");
        botRefresco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botRefrescoActionPerformed(evt);
            }
        });

        botGaseosa.setText("Gaseosa");
        botGaseosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botGaseosaActionPerformed(evt);
            }
        });

        botCerveza.setText("Cerveza");
        botCerveza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCervezaActionPerformed(evt);
            }
        });

        btnAgua.setText("Agua");
        btnAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAguaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botRefresco, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(btnAgua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botCerveza, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botGaseosa, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botCerveza, botGaseosa, botRefresco, btnAgua});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botCerveza, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botGaseosa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botRefresco, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botCerveza, botGaseosa, botRefresco, btnAgua});

        jTabbedPane1.addTab("BEBIDAS", jPanel6);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("GUARNICIONES", jPanel1);

        txtObservacion.setEditable(false);
        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        jScrollPane2.setViewportView(txtObservacion);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("OBSERVACIÓN", jPanel10);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TOMA DE PEDIDO - MESAS");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("HORA:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("FECHA:");

        lblFecha.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 204, 204));
        lblFecha.setText("fecha");

        lblHora.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblHora.setForeground(new java.awt.Color(0, 204, 204));
        lblHora.setText("hora");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(lblFecha)
                    .addComponent(lblHora))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        botCancelar.setText("SALIR");
        botCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1067, Short.MAX_VALUE)
                .addComponent(botCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botCancelar, btnGuardar});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botCancelar))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botCancelar, btnGuardar});

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DISPONIBILIDAD:");

        botDisponibilidad.setBorder(null);
        botDisponibilidad.setBorderPainted(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botDisponibilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MESA NÚMERO:");

        labelNumeroMesa.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        labelNumeroMesa.setForeground(new java.awt.Color(0, 204, 204));

        lblMozo.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblMozo.setForeground(new java.awt.Color(255, 255, 255));
        lblMozo.setText("MOZO:");

        labelNombreMozo.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        labelNombreMozo.setForeground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(lblMozo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNombreMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelNombreMozo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNumeroMesa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(lblMozo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnDisminuirCantidad.setText("-");
        btnDisminuirCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisminuirCantidadActionPerformed(evt);
            }
        });

        btnAumenarCantidad.setText("+");
        btnAumenarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumenarCantidadActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        botAgregarObservacion.setText("Observación");
        botAgregarObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAgregarObservacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEliminar)
                .addGap(219, 219, 219)
                .addComponent(btnAumenarCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDisminuirCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botAgregarObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDisminuirCantidad)
                    .addComponent(btnAumenarCantidad)
                    .addComponent(btnEliminar)
                    .addComponent(botAgregarObservacion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("PRECIO TOTAL");

        labelTotal.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotal.setText("0,00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTabbedPane1)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int registros_afectados;
        GestionarPedidoServicio gestionarPedidoServicio = new GestionarPedidoServicio();

        switch (tipo_accion) {
            case ACCION_CREAR:
                if (!pedido.tieneRegistros()) {
                    JOptionPane.showMessageDialog(this, "No se pudo registrar el pedido, debe ingresar algún plato o bebida \n"
                            + "para poder registrar correctamente.");
                    return;
                }
                String codigo = obtenerCodigoDelMozo();
                Mozo mozo = buscarMozo(codigo);
                if (mozo == null) {
                    JOptionPane.showMessageDialog(this, "No se encuentra el mozo registrado.");
                    return;
                }
                pedido.agregarMesaPedido(mesa, Constantes.CANTIDAD_CERO);
                pedido.setMozo(mozo);
                pedido.setEstado(Pedido.ESTADO_COMSUMIENDO);
                
                try {
                    registros_afectados = gestionarPedidoServicio.crearPedido(pedido);
                    if (registros_afectados == 1) {
                        JOptionPane.showMessageDialog(this, "Good, se creado correctamente y se ha enviado a cosina");
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error..");
                    }
                } catch (Exception e) {
                    Mensaje.mostrarAdvertencia(this, e.getMessage());
                }
                break;
            case ACCION_MODIFICAR:
                try {
                    registros_afectados = gestionarPedidoServicio.modificarPedido(pedido);
                    if (registros_afectados == 1) {
                        JOptionPane.showMessageDialog(this, "Good, se actualizado correctamente y se ha enviado a cosina");
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error..");
                    }
                } catch (Exception e) {
                    Mensaje.mostrarAdvertencia(this, e.getMessage());
                }
                break;
            case ACCION_UNIR:
                if (!pedido.tieneRegistros()) {
                    JOptionPane.showMessageDialog(this, "No se pudo registrar el pedido, debe ingresar algún plato o bebida \n"
                            + "para poder registrar correctamente.");
                    return;
                }
                String codigo1 = obtenerCodigoDelMozo();
                Mozo mozo1 = buscarMozo(codigo1);
                if (mozo1 == null) {
                    JOptionPane.showMessageDialog(this, "No se encuentra el mozo no se encuentra registrado.");
                    return;
                }
                pedido.setMozo(mozo1);
                pedido.setEstado(Pedido.ESTADO_COMSUMIENDO);
                try {
                    registros_afectados = gestionarPedidoServicio.crearPedidoUnirMesa(pedido);
                    if (registros_afectados == 1) {
                        JOptionPane.showMessageDialog(this, "Good, se creado correctamente y se ha enviado a cocina");
                        this.dispose();
                    }
                } catch (Exception e) {
                    Mensaje.mostrarAdvertencia(this, e.getMessage());
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void botCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botCancelarActionPerformed

    private void btnArrozActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArrozActionPerformed
        buscarPlato(Categoria.CATEGORIA_ARROZ);
    }//GEN-LAST:event_btnArrozActionPerformed

    private void btnCaprichosMarinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaprichosMarinosActionPerformed
        buscarPlato(Categoria.CATEGORIA_CAPRICHOS_MARINOS);
    }//GEN-LAST:event_btnCaprichosMarinosActionPerformed

    private void btnCebichesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCebichesActionPerformed
        buscarPlato(Categoria.CATEGORIA_CEBICHES);
    }//GEN-LAST:event_btnCebichesActionPerformed

    private void btnChicharronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChicharronActionPerformed
        buscarPlato(Categoria.CATEGORIA_CHICHARON);
    }//GEN-LAST:event_btnChicharronActionPerformed

    private void btnChupesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChupesActionPerformed
        buscarPlato(Categoria.CATEGORIA_CHUPES);
    }//GEN-LAST:event_btnChupesActionPerformed

    private void btnCriollosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriollosActionPerformed
        buscarPlato(Categoria.CATEGORIA_CRIOLLOS);
    }//GEN-LAST:event_btnCriollosActionPerformed

    private void btnEspecialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEspecialesActionPerformed
        buscarPlato(Categoria.CATEGORIA_ESPECIALES);
    }//GEN-LAST:event_btnEspecialesActionPerformed

    private void btnParihuelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParihuelasActionPerformed
        buscarPlato(Categoria.CATEGORIA_PARIHUELAS);
    }//GEN-LAST:event_btnParihuelasActionPerformed

    private void btnPicantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPicantesActionPerformed
        buscarPlato(Categoria.CATEGORIA_PICANTES);
    }//GEN-LAST:event_btnPicantesActionPerformed

    private void btnSopasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSopasActionPerformed
        buscarPlato(Categoria.CATEGORIA_SOPAS);
    }//GEN-LAST:event_btnSopasActionPerformed

    private void btnSudadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSudadosActionPerformed
        buscarPlato(Categoria.CATEGORIA_SUDADOS);
    }//GEN-LAST:event_btnSudadosActionPerformed

    private void btnTortillasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTortillasActionPerformed
        buscarPlato(Categoria.CATEGORIA_TORTILLAS);
    }//GEN-LAST:event_btnTortillasActionPerformed

    private void botRefrescoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botRefrescoActionPerformed
        buscarBebida(Categoria.CATEGORIA_REFRESCO);
    }//GEN-LAST:event_botRefrescoActionPerformed

    private void botGaseosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botGaseosaActionPerformed
        buscarBebida(Categoria.CATEGORIA_GASEOSA);
    }//GEN-LAST:event_botGaseosaActionPerformed

    private void botCervezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCervezaActionPerformed
        buscarBebida(Categoria.CATEGORIA_CERVEZA);
    }//GEN-LAST:event_botCervezaActionPerformed

    private void btnAguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAguaActionPerformed
        buscarBebida(Categoria.CATEGORIA_AGUA);
    }//GEN-LAST:event_btnAguaActionPerformed

    private void botAgregarObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAgregarObservacionActionPerformed
        String nombre = obtenerNombre();
        if (!nombre.equals("") && pedido.esPlato(nombre)) {
            new FormMPObservacion(this, pedido, nombre).setVisible(true);
        }
        agregarObservacion();
    }//GEN-LAST:event_botAgregarObservacionActionPerformed

    private void btnAumenarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumenarCantidadActionPerformed
        String nombre = obtenerNombre();
        int cantidad = obtenerCantidad();
        
        if (pedido.esPlato(nombre)) {
            pedido.aumentarCantidadPlato(nombre, cantidad);
        } else {
            try {
                pedido.aumentarCantidadBebida(nombre, cantidad+1);
            } catch (Exception e) {
                Mensaje.mostrarAdvertencia(this, e.getMessage());
            }
        }
        mostrarPedido();
    }//GEN-LAST:event_btnAumenarCantidadActionPerformed

    private void btnDisminuirCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisminuirCantidadActionPerformed
        String nombre = obtenerNombre();
        int cantidad = obtenerCantidad();

        if (pedido.esPlato(nombre)) {
            pedido.disminuirCantidadPlato(nombre, cantidad);
        } else {
            try {
                pedido.disminuirCantidadBebida(nombre, cantidad);
            } catch (Exception e) {
                Mensaje.mostrarAdvertencia(this, e.getMessage());
            }
        }
        mostrarPedido();
    }//GEN-LAST:event_btnDisminuirCantidadActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String nombre = obtenerNombre();
        pedido.eliminarPlatoPedido(nombre);
        pedido.eliminarBebidaPedido(nombre);
        mostrarPedido();

    }//GEN-LAST:event_btnEliminarActionPerformed

    private int obtenerCantidad() {
        int numeroFila = tablaPedido.getSelectedRow();
        if (numeroFila == -1) {
            Mensaje.mostrarFilaNoSeleccionada(this);
            return 0;
        }
        ModeloTabla modeloTabla = (ModeloTabla) tablaPedido.getModel();
        Fila fila = modeloTabla.obtenerFila(numeroFila);
        return (Integer) fila.obtenerCelda(2).getValor();
    }

    private String obtenerNombre() {
        int numeroFila = tablaPedido.getSelectedRow();
        if (numeroFila == -1) {
            Mensaje.mostrarFilaNoSeleccionada(this);
            return "";
        }
        ModeloTabla modeloTabla = (ModeloTabla) tablaPedido.getModel();
        Fila fila = modeloTabla.obtenerFila(numeroFila);
        return (String) fila.obtenerCelda(1).getValor();
    }

    private String obtenerCodigoDelMozo() {
        String codigoDelMozo = JOptionPane.showInputDialog(rootPane, "Debe ingresar su código para registrar\n"
                + "correctamente el pedido.\n"
                + "Ingrese su código:", "Mozo", JOptionPane.QUESTION_MESSAGE);
        if ((codigoDelMozo != null) && (codigoDelMozo.length() > 0)) {
            return codigoDelMozo;
        }
        return "";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAgregarObservacion;
    private javax.swing.JButton botCancelar;
    private javax.swing.JButton botCerveza;
    private javax.swing.JButton botDisponibilidad;
    private javax.swing.JButton botGaseosa;
    private javax.swing.JButton botRefresco;
    private javax.swing.JButton btnAgua;
    private javax.swing.JButton btnArroz;
    private javax.swing.JButton btnAumenarCantidad;
    private javax.swing.JButton btnCaprichosMarinos;
    private javax.swing.JButton btnCebiches;
    private javax.swing.JButton btnChicharron;
    private javax.swing.JButton btnChupes;
    private javax.swing.JButton btnCriollos;
    private javax.swing.JButton btnDisminuirCantidad;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEspeciales;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnParihuelas;
    private javax.swing.JButton btnPicantes;
    private javax.swing.JButton btnSopas;
    private javax.swing.JButton btnSudados;
    private javax.swing.JButton btnTortillas;
    private javax.swing.JComboBox<String> comboNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel labelNombreMozo;
    private javax.swing.JLabel labelNumeroMesa;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblMozo;
    private javax.swing.JPanel panelCarta;
    private javax.swing.JTable tablaPedido;
    private javax.swing.JTextArea txtObservacion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Thread hiloinicio = Thread.currentThread();

        while (hiloinicio == hiloclock) {
            Clock.calcula();
            lblHora.setText(Clock.hora + ":" + Clock.minutos + ":" + Clock.segundos + " " + Clock.ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
