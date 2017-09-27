package cactussoft.capa1_presentacion;

import cactussoft.capa1_presentacion.util.ConfiguradorDeTabla;
import cactussoft.capa1_presentacion.util.Formateador;
import cactussoft.capa1_presentacion.util.Mensaje;
import cactussoft.capa2_aplicacion.GestionarProveedorServicio;
import cactussoft.capa3_dominio.entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Fila;

public class FormMAGestionarProveedor extends javax.swing.JDialog {

    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private final int ACCION_ELIMINAR = 3;
    private int tipo_accion;
    private Proveedor proveedor = null;

    public FormMAGestionarProveedor(JFrame frame) {
        super(frame, true);
        initComponents();

        tipo_accion = ACCION_CREAR;
        Formateador.centrarVentanaDialog(this);
        tablaProveedor.setModel(ConfiguradorDeTabla.crearTablaProveedor());
        buscar();
        activarBotonesCrud(true);
    }

    public FormMAGestionarProveedor(JDialog dialog) {
        super(dialog, true);
        initComponents();

        Formateador.centrarVentanaDialog(dialog);
        tipo_accion = ACCION_CREAR;
        Formateador.centrarVentanaDialog(this);
        tablaProveedor.setModel(ConfiguradorDeTabla.crearTablaProveedor());
        buscar();
    }

    private ArrayList<JTextField> listaDeCampoDeTexto() {
        ArrayList<JTextField> camposDeTexto = new ArrayList<>();
        camposDeTexto.add(txtNombre);
        camposDeTexto.add(txtTelefono);
        return camposDeTexto;
    }

    private ArrayList<JTextArea> listaDeCampoDeArea() {
        ArrayList<JTextArea> camposDeArea = new ArrayList<>();
        camposDeArea.add(txtZona);
        return camposDeArea;
    }

    private void activarBotonesCrud(boolean activar) {
        txtNombre.requestFocus();
        btnNuevo.setEnabled(!activar);
        btnActualizar.setEnabled(!activar);
        btnEliminar.setEnabled(!activar);
        btnGuardar.setEnabled(activar);
    }

    private void buscar() {
        Fila filaTabla;

        GestionarProveedorServicio gestionarProveedorServicio = new GestionarProveedorServicio();
        try {
            List<Proveedor> proveedores = gestionarProveedorServicio.mostrarTodo();
            ModeloTabla modeloTabla = (ModeloTabla) tablaProveedor.getModel();
            modeloTabla.eliminarTotalFilas();
            for (Proveedor proveedor : proveedores) {
                filaTabla = new Fila();
                filaTabla.agregarValorCelda(proveedor.getProveedorid());
                filaTabla.agregarValorCelda(proveedor.getNombre());
                filaTabla.agregarValorCelda(proveedor.getTelefono());
                filaTabla.agregarValorCelda(proveedor.getZona());

                modeloTabla.agregarFila(filaTabla);
            }
            modeloTabla.refrescarDatos();
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
    }

    private int obtenerId() {
        int numFila = tablaProveedor.getSelectedRow();
        if (numFila == -1) {
            Mensaje.mostrarFilaNoSeleccionada(this);
            return 0;
        }
        ModeloTabla modeloTabla = (ModeloTabla) tablaProveedor.getModel();
        Fila fila = modeloTabla.obtenerFila(numFila);
        return (Integer) fila.obtenerCelda(0).getValor();
    }

    private Proveedor encontrar(int proveedorid) {
        try {
            GestionarProveedorServicio gestionarProveedorServicio = new GestionarProveedorServicio();
            Proveedor proveedor = gestionarProveedorServicio.buscarProveedor(proveedorid);
            return proveedor;
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
        return null;
    }

    private void mostrarEnCampoDeTexto(Proveedor proveedor) {
        txtNombre.setText(proveedor.getNombre());
        txtTelefono.setText(proveedor.getTelefono());
        txtZona.setText(proveedor.getZona());
    }

    public Proveedor devolverProveedor() {
        return proveedor;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedor = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtTelefono = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtZona = new javax.swing.JTextArea();
        btnSeleccionar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tablaProveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProveedor.setRowHeight(21);
        tablaProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProveedor);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Nombre:");

        jLabel1.setText("Telefono:");

        jLabel3.setText("Zona:");

        txtZona.setColumns(20);
        txtZona.setRows(5);
        jScrollPane3.setViewportView(txtZona);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtNombre)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addGap(0, 42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnActualizar, btnCancelar, btnEliminar, btnGuardar, btnNuevo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeleccionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnActualizar, btnCancelar, btnEliminar, btnGuardar, btnNuevo});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(txtNombre.getText());
        proveedor.setTelefono(txtTelefono.getText());
        proveedor.setZona(txtZona.getText());
        proveedor.setEstado("A");
        GestionarProveedorServicio gestionarProveedorServicio = new GestionarProveedorServicio();
        try {
            if (tipo_accion == ACCION_CREAR) {
                int registros_afectados = gestionarProveedorServicio.crearProveedor(proveedor);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeCreacion(this);
                } else {
                    Mensaje.mostrarAdvertenciaDeCreacion(this);
                }
                buscar();
            }
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }

        Formateador.limpiarCampoDeTexto(listaDeCampoDeTexto());
        Formateador.limpiarCampoDeArea(listaDeCampoDeArea());
        activarBotonesCrud(true);

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        tipo_accion = ACCION_MODIFICAR;
        proveedor.setNombre(txtNombre.getText());
        proveedor.setTelefono(txtTelefono.getText());
        proveedor.setZona(txtZona.getText());
        GestionarProveedorServicio gestionarProveedorServicio = new GestionarProveedorServicio();

        try {
            int registros_afectados = gestionarProveedorServicio.modificarProveedor(proveedor);
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
        Formateador.limpiarCampoDeArea(listaDeCampoDeArea());
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        tipo_accion = ACCION_ELIMINAR;
        int proveedorid = obtenerId();

        if (proveedorid == 0) {
            return;
        }
        if (!Mensaje.mostrarPreguntaDeEliminacion(this)) {
            return;
        }

        GestionarProveedorServicio gestionarProveedorServicio = new GestionarProveedorServicio();
        Proveedor proveedor = new Proveedor();
        proveedor.setProveedorid(proveedorid);
        proveedor.setEstado("E");

        try {
            int registros_afectados = gestionarProveedorServicio.eliminarProveedor(proveedor);
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
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Formateador.limpiarCampoDeTexto(listaDeCampoDeTexto());
        Formateador.limpiarCampoDeArea(listaDeCampoDeArea());
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tablaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProveedorMouseClicked
        if (evt.getClickCount() == 1) {
            int proveedorid = obtenerId();
            proveedor = encontrar(proveedorid);
            mostrarEnCampoDeTexto(proveedor);
            activarBotonesCrud(false);
        }
    }//GEN-LAST:event_tablaProveedorMouseClicked

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int proveedorid = obtenerId();
        proveedor = encontrar(proveedorid);
        if (proveedor != null) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaProveedor;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextArea txtZona;
    // End of variables declaration//GEN-END:variables
}
