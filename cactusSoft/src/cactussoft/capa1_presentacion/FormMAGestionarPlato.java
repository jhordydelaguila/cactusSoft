package cactussoft.capa1_presentacion;

import cactussoft.capa1_presentacion.util.ConfiguradorDeTabla;
import cactussoft.capa1_presentacion.util.Formateador;
import cactussoft.capa1_presentacion.util.Mensaje;
import cactussoft.capa2_aplicacion.GestionarCategoriaServicio;
import cactussoft.capa2_aplicacion.GestionarPlatoServicio;
import cactussoft.capa3_dominio.entidades.Categoria;
import cactussoft.capa3_dominio.entidades.Plato;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Fila;

public class FormMAGestionarPlato extends javax.swing.JDialog {

    private int tipo_accion;
    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private final int ACCION_ELIMINAR = 3;
    private Plato plato = null;

    public FormMAGestionarPlato(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        Formateador.centrarVentanaDialog(this);
        tablaPlatos.setModel(ConfiguradorDeTabla.crearTablaPlato());

        tipo_accion = ACCION_CREAR;
        agregarCategoriaEnComboBox();
        agregarTotalPlatos();
        activarBotonesCrud(true);
        buscar();
    }

    public FormMAGestionarPlato(java.awt.Dialog parent) {
        super(parent, true);
        initComponents();
        Formateador.centrarVentanaDialog(this);
        tablaPlatos.setModel(ConfiguradorDeTabla.crearTablaPlato());

        tipo_accion = ACCION_CREAR;
        agregarCategoriaEnComboBox();
        activarBotonesCrud(true);
        buscar();
    }

    private void buscar() {
        Fila filaTabla;
        String nombre = txtBuscar.getText().trim();
        GestionarPlatoServicio gestionarPlatoServicio = new GestionarPlatoServicio();
        try {
            List<Plato> platos = gestionarPlatoServicio.buscarPlatos(nombre);
            ModeloTabla modeloTabla = (ModeloTabla) tablaPlatos.getModel();
            modeloTabla.eliminarTotalFilas();
            for (Plato plato : platos) {
                filaTabla = new Fila();
                filaTabla.agregarValorCelda(plato.getPlatoid());
                filaTabla.agregarValorCelda(plato.getNombre());
                filaTabla.agregarValorCelda(plato.getPrecio());
                filaTabla.agregarValorCelda(plato.getCategoria().getNombre());
                modeloTabla.agregarFila(filaTabla);
            }
            modeloTabla.refrescarDatos();
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
    }

    private void agregarCategoriaEnComboBox() {
        GestionarCategoriaServicio gestionarCategoriaServicio = new GestionarCategoriaServicio();
        try {
            List<Categoria> categorias = gestionarCategoriaServicio.mostrarCategorias(Categoria.TIPO_PLATO);
            cboCategoria.removeAllItems();
            cboCategoria.addItem("<seleccionar>");
            for (Categoria categoria : categorias) {
                cboCategoria.addItem(String.valueOf(categoria.getNombre()));
            }
            //categorias.clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private String obtenerNombreDeComboBox() {
        String nombre = (String) cboCategoria.getSelectedItem();
        if (!nombre.equals("<seleccionar>")) {
            return nombre;
        } else {
            JOptionPane.showMessageDialog(this, "Mistake, Debe seleccionar una categoria.!");
        }
        return "";
    }

    private Categoria obtenerCategoria() {
        String nombreCategoria = obtenerNombreDeComboBox();
        try {
            GestionarCategoriaServicio gestionarCategoriaServicio = new GestionarCategoriaServicio();
            Categoria categoria = gestionarCategoriaServicio.buscarCategoria(nombreCategoria);
            return categoria;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return null;
    }

    private ArrayList<JTextField> listaDeCampoDeTexto() {
        ArrayList<JTextField> camposDeTexto = new ArrayList<>();
        camposDeTexto.add(txtPrecio);
        camposDeTexto.add(txtNombrePlato);
        return camposDeTexto;
    }

    private ArrayList<JTextPane> listaDePanelDeTexto() {
        ArrayList<JTextPane> panelDeTexto = new ArrayList<>();
        panelDeTexto.add(txtDescripcion);
        return panelDeTexto;
    }

    private void limpiarComboBox() {
        cboCategoria.setSelectedIndex(0);
    }

    private int obtenerId() {
        int numFila = tablaPlatos.getSelectedRow();
        if (numFila == -1) {
            Mensaje.mostrarFilaNoSeleccionada(this);
            return 0;
        }
        ModeloTabla modeloTabla = (ModeloTabla) tablaPlatos.getModel();
        Fila fila = modeloTabla.obtenerFila(numFila);
        return (Integer) fila.obtenerCelda(0).getValor();
    }

    private Plato encontrar(int id) {
        try {
            GestionarPlatoServicio gestionarPlatoServicio = new GestionarPlatoServicio();
            Plato plato = gestionarPlatoServicio.buscarPlato(id);
            return plato;
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
        return null;
    }

    private void mostrarEnCampoDeTexto(Plato plato) {
        txtNombrePlato.setText(plato.getNombre());
        txtPrecio.setText(Double.toString(plato.getPrecio()));
        txtDescripcion.setText(plato.getDescripcion());
        cboCategoria.setSelectedItem(plato.getCategoria().getNombre());
    }

    private void activarBotonesCrud(boolean activar) {
        txtNombrePlato.requestFocus();
        btnNuevo.setEnabled(!activar);
        btnActualizar.setEnabled(!activar);
        btnEliminar.setEnabled(!activar);
        btnGuardar.setEnabled(activar);
    }

    private void agregarTotalPlatos() {
        GestionarPlatoServicio gestionarPlatoServicio = new GestionarPlatoServicio();
        try {
            int total = gestionarPlatoServicio.totalPlatos();
            txtTotal.setText(Integer.toString(total));
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rgOferta = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        panelPlatos = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        panelPlato = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox<>();
        txtNombrePlato = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaGua = new javax.swing.JTable();
        btnNuevo1 = new javax.swing.JButton();
        btnGuardar1 = new javax.swing.JButton();
        btnActualizar1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaPlatos = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        panelPlato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Nombre:");

        jLabel5.setText("Precio:");

        jScrollPane1.setViewportView(txtDescripcion);

        jLabel7.setText("Descripción:");

        jLabel8.setText("Categoria:");

        cboCategoria.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N

        jLabel6.setText("s/.");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPlatoLayout = new javax.swing.GroupLayout(panelPlato);
        panelPlato.setLayout(panelPlatoLayout);
        panelPlatoLayout.setHorizontalGroup(
            panelPlatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPlatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombrePlato)
                    .addComponent(cboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(panelPlatoLayout.createSequentialGroup()
                        .addGroup(panelPlatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelPlatoLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPlatoLayout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelPlatoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnActualizar, btnCancelar, btnEliminar, btnGuardar, btnNuevo});

        panelPlatoLayout.setVerticalGroup(
            panelPlatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlatoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombrePlato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPlatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(panelPlatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        panelPlatoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtNombrePlato, txtPrecio});

        panelPlatoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnActualizar, btnCancelar, btnEliminar, btnGuardar, btnNuevo});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPlato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPlato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelPlatos.addTab("Plato", jPanel2);

        jLabel2.setText("Nombre:");

        jLabel3.setText("Precio:");

        jLabel9.setText("s/.");

        tablaGua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(tablaGua);

        btnNuevo1.setText("Nuevo");
        btnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo1ActionPerformed(evt);
            }
        });

        btnGuardar1.setText("Guardar");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        btnActualizar1.setText("Actualizar");
        btnActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar1ActionPerformed(evt);
            }
        });

        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btnNuevo1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActualizar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar1)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnActualizar1, btnCancelar1, btnEliminar1, btnGuardar1, btnNuevo1});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo1)
                    .addComponent(btnGuardar1)
                    .addComponent(btnActualizar1)
                    .addComponent(btnEliminar1)
                    .addComponent(btnCancelar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnActualizar1, btnCancelar1, btnEliminar1, btnGuardar1, btnNuevo1});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelPlatos.addTab("Guarnición", jPanel3);

        tablaPlatos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaPlatos.setRowHeight(25);
        tablaPlatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPlatosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaPlatos);

        txtBuscar.setPreferredSize(new java.awt.Dimension(59, 30));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        jLabel1.setText("Platos registrados:");

        txtTotal.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPlatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelPlatos)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 263, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 262, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Plato plato = new Plato();
        plato.setNombre(txtNombrePlato.getText());
        plato.setPrecio(Double.parseDouble(txtPrecio.getText()));
        plato.setDescripcion(txtDescripcion.getText());
        plato.setEstado("A");
        Categoria categoria = obtenerCategoria();
        GestionarPlatoServicio gestionarPlatoServicio = new GestionarPlatoServicio();

        if (categoria != null) {
            plato.setCategoria(categoria);
            if (tipo_accion == ACCION_CREAR) {
                try {
                    int registros_afectados = gestionarPlatoServicio.crearPlato(plato);
                    if (registros_afectados == 1) {
                        Mensaje.mostrarAfirmacionDeCreacion(this);
                    } else {
                        Mensaje.mostrarAdvertenciaDeCreacion(this);
                    }
                    buscar();
                } catch (Exception e) {
                    Mensaje.mostrarAdvertencia(this, e.getMessage());
                }
                Formateador.limpiarCampoDeTexto(listaDeCampoDeTexto());
                Formateador.limpiarPanelDeTexto(listaDePanelDeTexto());
                limpiarComboBox();
                agregarTotalPlatos();
                activarBotonesCrud(true);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        tipo_accion = ACCION_MODIFICAR;
        plato.setNombre(txtNombrePlato.getText());
        plato.setPrecio(Double.parseDouble(txtPrecio.getText()));
        plato.setDescripcion(txtDescripcion.getText());
        plato.setEstado("A");
        Categoria categoria = obtenerCategoria();
        GestionarPlatoServicio gestionarPlatoServicio = new GestionarPlatoServicio();

        if (categoria != null) {
            plato.setCategoria(categoria);
            try {
                int registros_afectados = gestionarPlatoServicio.modificarPlato(plato);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeActualizacion(this);
                } else {
                    Mensaje.mostrarAdvertenciaDeActualizacion(this);
                }
                buscar();
            } catch (Exception e) {
                Mensaje.mostrarAdvertencia(this, e.getMessage());
            }
            Formateador.limpiarCampoDeTexto(listaDeCampoDeTexto());
            Formateador.limpiarPanelDeTexto(listaDePanelDeTexto());
            limpiarComboBox();
            activarBotonesCrud(true);
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        tipo_accion = ACCION_ELIMINAR;
        int id = obtenerId();

        if (id == 0) {
            return;
        }
        if (!Mensaje.mostrarPreguntaDeEliminacion(this)) {
            return;
        }

        GestionarPlatoServicio gestionarPlatoServicio = new GestionarPlatoServicio();
        Plato plato = new Plato();
        plato.setPlatoid(id);
        plato.setEstado("E");

        try {
            int registros_afectados = gestionarPlatoServicio.eliminarPlato(plato);
            if (registros_afectados == 1) {
                Mensaje.mostrarAfirmacionDeEliminacion(this);
            } else {
                Mensaje.mostrarAdvertenciaDeEliminacion(this);
            }
            buscar();
        } catch (Exception e) {
            Mensaje.mostrarErrorDeEliminacion(this);
        }
        Formateador.limpiarCampoDeTexto(listaDeCampoDeTexto());
        Formateador.limpiarPanelDeTexto(listaDePanelDeTexto());
        limpiarComboBox();
        agregarTotalPlatos();
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Formateador.limpiarCampoDeTexto(listaDeCampoDeTexto());
        Formateador.limpiarPanelDeTexto(listaDePanelDeTexto());
        limpiarComboBox();
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        buscar();
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void tablaPlatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPlatosMouseClicked
        if (evt.getClickCount() == 1) {
            int id = obtenerId();
            plato = encontrar(id);
            mostrarEnCampoDeTexto(plato);
            activarBotonesCrud(false);
        }
    }//GEN-LAST:event_tablaPlatosMouseClicked

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevo1ActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizar1ActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel panelPlato;
    private javax.swing.JTabbedPane panelPlatos;
    private javax.swing.ButtonGroup rgOferta;
    private javax.swing.JTable tablaGua;
    private javax.swing.JTable tablaPlatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextPane txtDescripcion;
    private javax.swing.JTextField txtNombrePlato;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
