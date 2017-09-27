package cactussoft.capa1_presentacion;

import cactussoft.capa1_presentacion.util.ConfiguradorDeTabla;
import cactussoft.capa1_presentacion.util.Fecha;
import cactussoft.capa1_presentacion.util.Formateador;
import cactussoft.capa1_presentacion.util.Mensaje;
import cactussoft.capa2_aplicacion.GestionarBebidaServicio;
import cactussoft.capa2_aplicacion.GestionarCategoriaServicio;
import cactussoft.capa2_aplicacion.GestionarProveedorServicio;
import cactussoft.capa3_dominio.entidades.Bebida;
import cactussoft.capa3_dominio.entidades.Categoria;
import cactussoft.capa3_dominio.entidades.Proveedor;
import com.sun.org.apache.bcel.internal.classfile.Constant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Fila;

public class FormMAGestionarBebida extends javax.swing.JDialog {

    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private final int ACCION_ELIMINAR = 3;
    private int tipo_accion;
    private Bebida bebida = null;
    private Proveedor proveedor = null;

    public FormMAGestionarBebida(java.awt.Frame parent) {
        super(parent, true);
        initComponents();

        tipo_accion = ACCION_CREAR;
        agregarCategoriaEnComboBox();
        Formateador.centrarVentanaDialog(this);
        activarBotonesCrud(true);
        tablaBebida.setModel(ConfiguradorDeTabla.crearTablaBebida());
        buscar();
    }

    private ArrayList<JTextField> listaDeCampoDeTexto() {
        ArrayList<JTextField> camposDeTexto = new ArrayList<>();
        camposDeTexto.add(txtPrecio);
        camposDeTexto.add(txtProveedor);
        camposDeTexto.add(txtNombre);
        return camposDeTexto;
    }

    private ArrayList<JSpinner> listaDeCampoDeSpinner() {
        ArrayList<JSpinner> listaDecamposSpinner = new ArrayList<>();
        listaDecamposSpinner.add(txtStock);
        listaDecamposSpinner.add(txtStockminimo);
        return listaDecamposSpinner;
    }

    private ArrayList<JTextArea> listaDeCampoDeArea() {
        ArrayList<JTextArea> listaDeCamposDeArea = new ArrayList<>();
        listaDeCamposDeArea.add(txtDescripcion);
        return listaDeCamposDeArea;
    }

    private void activarBotonesCrud(boolean activar) {
        txtNombre.requestFocus();
        btnNuevo.setEnabled(!activar);
        btnActualizar.setEnabled(!activar);
        btnEliminar.setEnabled(!activar);
        btnGuardar.setEnabled(activar);
    }

    private void agregarCategoriaEnComboBox() {
        GestionarCategoriaServicio gestionarCategoriaServicio = new GestionarCategoriaServicio();
        try {
            List<Categoria> categorias = gestionarCategoriaServicio.mostrarCategorias(Categoria.TIPO_BEBIDA);
            cboCategoria.removeAllItems();
            cboCategoria.addItem("<seleccionar>");
            for (Categoria categoria : categorias) {
                cboCategoria.addItem(String.valueOf(categoria.getNombre()));
            }
            //categorias.clear();
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
    }

    private void buscar() {
        Fila filaTabla;
        String nombre = txtBuscar.getText().trim();
        GestionarBebidaServicio gestionarBebidaServicio = new GestionarBebidaServicio();
        try {
            List<Bebida> bebidas = gestionarBebidaServicio.mostrarBebidas(nombre);
            ModeloTabla modeloTabla = (ModeloTabla) tablaBebida.getModel();
            modeloTabla.eliminarTotalFilas();
            for (Bebida bebida : bebidas) {
                filaTabla = new Fila();
                filaTabla.agregarValorCelda(bebida.getBebidaid());
                filaTabla.agregarValorCelda(bebida.getNombre());
                filaTabla.agregarValorCelda(bebida.getPrecio());
                filaTabla.agregarValorCelda(bebida.getStock());
                filaTabla.agregarValorCelda(bebida.getCategoria().getNombre());
                modeloTabla.agregarFila(filaTabla);
            }
            modeloTabla.refrescarDatos();
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
    }

    private int obtenerId() {
        int numFila = tablaBebida.getSelectedRow();
        if (numFila == -1) {
            Mensaje.mostrarFilaNoSeleccionada(this);
            return 0;
        }
        ModeloTabla modeloTabla = (ModeloTabla) tablaBebida.getModel();
        Fila fila = modeloTabla.obtenerFila(numFila);
        return (Integer) fila.obtenerCelda(0).getValor();
    }

    private Bebida encontrar(int bebidaid) {
        try {
            GestionarBebidaServicio gestionarBebidaServicio = new GestionarBebidaServicio();
            Bebida bebida = gestionarBebidaServicio.buscarBebida(bebidaid);
            return bebida;
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
        return null;
    }

    private void mostrarEnCampoDeTexto(Bebida bebida) {
        txtPrecio.setText("" + bebida.getPrecio());
        cboCategoria.setSelectedItem(bebida.getCategoria().getNombre());
        txtDescripcion.setText(bebida.getDescripcion());
        txtNombre.setText(bebida.getNombre());
        txtProveedor.setText(bebida.getProveedor().getNombre());
        txtStock.setValue(bebida.getStock());
        txtStockminimo.setValue(bebida.getStockminimo());
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
        Categoria categoria = null;
        String nombreCategoria = obtenerNombreDeComboBox();
        GestionarCategoriaServicio gestionarCategoriaServicio = new GestionarCategoriaServicio();
        try {
            categoria = gestionarCategoriaServicio.buscarCategoria(nombreCategoria);
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
        return categoria;
    }

    private Proveedor obtenerProveedor(String nombre) {
        try {
            GestionarProveedorServicio gestionarProveedorServicio = new GestionarProveedorServicio();
            Proveedor proveedor = gestionarProveedorServicio.buscarProveedor(nombre);
            return proveedor;
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        cboCategoria = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtPrecio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtStock = new javax.swing.JSpinner();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtStockminimo = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBebida = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Nombre:");

        jLabel3.setText("Precio:");

        jLabel5.setText("Descripción:");

        jLabel6.setText("Categoria:");

        jLabel7.setText("Proveedor:");

        txtProveedor.setEditable(false);

        cboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel4.setText("Stock:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("s/.");

        jLabel8.setText("Stock mínimo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtProveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addComponent(cboCategoria, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStockminimo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(txtStockminimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnBuscar)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registro", jPanel3);

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
        tablaBebida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBebidaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaBebida);

        txtBuscar.setPreferredSize(new java.awt.Dimension(84, 35));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnActualizar, btnCancelar, btnEliminar, btnGuardar, btnNuevo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo)
                            .addComponent(btnGuardar)
                            .addComponent(btnActualizar)
                            .addComponent(btnEliminar)
                            .addComponent(btnCancelar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnActualizar, btnCancelar, btnEliminar, btnGuardar, btnNuevo});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        FormMAGestionarProveedor formMAGestionarProveedor = new FormMAGestionarProveedor(this);
        formMAGestionarProveedor.setVisible(true);

        proveedor = formMAGestionarProveedor.devolverProveedor();
        if (proveedor != null) {
            txtProveedor.setText(proveedor.getNombre());
        } else {
            txtProveedor.setText("Debe seleccionar un proveedor");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Categoria categoria = obtenerCategoria();
        Bebida bebida = new Bebida();
        bebida.setNombre(txtNombre.getText());
        bebida.setPrecio(Double.parseDouble(txtPrecio.getText()));
        bebida.setStock(Integer.parseInt(txtStock.getValue().toString()));
        bebida.setStockactual(Integer.parseInt(txtStock.getValue().toString()));
        bebida.setStockminimo(Integer.parseInt(txtStockminimo.getValue().toString()));
        bebida.setDescripcion(txtDescripcion.getText());
        bebida.setEstado("A");
        bebida.setFechaCreado(Fecha.fechaActualString());
        bebida.setFechaActualizado(Fecha.fechaActualString());
        GestionarBebidaServicio gestionarBebidaServicio = new GestionarBebidaServicio();

        if (categoria != null && proveedor != null) {
            bebida.setCategoria(categoria);
            bebida.setProveedor(proveedor);
            if (tipo_accion == ACCION_CREAR) {
                try {
                    int registros_afectados = gestionarBebidaServicio.crearBebida(bebida);
                    if (registros_afectados == 1) {
                        Mensaje.mostrarAfirmacionDeCreacion(this);
                    } else {
                        Mensaje.mostrarAdvertenciaDeActualizacion(this);
                    }
                    buscar();
                } catch (Exception e) {
                    Mensaje.mostrarAdvertencia(this, e.getMessage());
                }
            }
        } else {
            cboCategoria.requestFocusInWindow();
        }
        Formateador.limpiarCampoDeTexto(listaDeCampoDeTexto());
        Formateador.limpiarCampoDeArea(listaDeCampoDeArea());
        Formateador.limpiarCampoDeSpinner(listaDeCampoDeSpinner());
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        tipo_accion = ACCION_MODIFICAR;
        Categoria categoria = obtenerCategoria();
        Proveedor proveedor = obtenerProveedor(txtProveedor.getText());
        bebida.setNombre(txtNombre.getText());
        bebida.setPrecio(Double.parseDouble(txtPrecio.getText()));
        bebida.setStock(Integer.parseInt(txtStock.getValue().toString()));
        bebida.setStockactual(Integer.parseInt(txtStock.getValue().toString()));
        bebida.setStockminimo(Integer.parseInt(txtStockminimo.getValue().toString()));
        bebida.setDescripcion(txtDescripcion.getText());
        bebida.setFechaActualizado(Fecha.fechaActualString());
        GestionarBebidaServicio gestionarBebidaServicio = new GestionarBebidaServicio();

        if (categoria != null && proveedor != null) {
            bebida.setCategoria(categoria);
            bebida.setProveedor(proveedor);
            try {
                int registros_afectados = gestionarBebidaServicio.modificarBebida(bebida);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeActualizacion(this);
                } else {
                    Mensaje.mostrarAdvertenciaDeActualizacion(this);
                }
                buscar();
            } catch (Exception e) {
                Mensaje.mostrarAdvertencia(this, e.getMessage());
            }
        }
        Formateador.limpiarCampoDeTexto(listaDeCampoDeTexto());
        Formateador.limpiarCampoDeArea(listaDeCampoDeArea());
        Formateador.limpiarCampoDeSpinner(listaDeCampoDeSpinner());
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        tipo_accion = ACCION_ELIMINAR;
        int bebidaid = obtenerId();

        if (bebidaid == 0) {
            return;
        }
        if (!Mensaje.mostrarPreguntaDeEliminacion(this)) {
            return;
        }

        GestionarBebidaServicio gestionarBebidaServicio = new GestionarBebidaServicio();
        Bebida bebida = new Bebida();
        bebida.setBebidaid(bebidaid);
        bebida.setEstado("E");

        try {
            int registros_afectados = gestionarBebidaServicio.eliminarBebida(bebida);
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
        Formateador.limpiarCampoDeArea(listaDeCampoDeArea());
        Formateador.limpiarCampoDeSpinner(listaDeCampoDeSpinner());
        activarBotonesCrud(true);

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Formateador.limpiarCampoDeTexto(listaDeCampoDeTexto());
        Formateador.limpiarCampoDeArea(listaDeCampoDeArea());
        Formateador.limpiarCampoDeSpinner(listaDeCampoDeSpinner());
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        buscar();
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void tablaBebidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBebidaMouseClicked
        if (evt.getClickCount() == 1) {
            int bebidaid = obtenerId();
            bebida = encontrar(bebidaid);
            mostrarEnCampoDeTexto(bebida);
            activarBotonesCrud(false);
        }
    }//GEN-LAST:event_tablaBebidaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaBebida;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProveedor;
    private javax.swing.JSpinner txtStock;
    private javax.swing.JSpinner txtStockminimo;
    // End of variables declaration//GEN-END:variables
}
