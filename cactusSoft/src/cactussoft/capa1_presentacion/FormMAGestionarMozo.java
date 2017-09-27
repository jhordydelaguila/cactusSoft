package cactussoft.capa1_presentacion;

import cactussoft.capa1_presentacion.util.ConfiguradorDeTabla;
import cactussoft.capa1_presentacion.util.Formateador;
import cactussoft.capa1_presentacion.util.Mensaje;
import cactussoft.capa2_aplicacion.GestionarMozoServicio;
import cactussoft.capa3_dominio.entidades.Empleado;
import cactussoft.capa3_dominio.entidades.Mozo;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Fila;

public class FormMAGestionarMozo extends javax.swing.JDialog {

    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private final int ACCION_ELIMINAR = 3;
    private int tipo_accion;
    private Empleado mozo;

    public FormMAGestionarMozo(java.awt.Frame parent) {
        super(parent, true);
        initComponents();

        tipo_accion = ACCION_CREAR;
        Formateador.centrarVentanaDialog(this);
        activarBotonesCrud(true);
        tablaMozo.setModel(ConfiguradorDeTabla.crearTablaEmpleado());
        buscar();
    }

    private ArrayList<JTextField> listaDeCampoDeTexto() {
        ArrayList<JTextField> camposDeTexto = new ArrayList<>();
        camposDeTexto.add(txtDni);
        camposDeTexto.add(txtApellidos);
        camposDeTexto.add(txtNombre);
        camposDeTexto.add(txtTelefono);
        camposDeTexto.add(txtDireccion);
        camposDeTexto.add(txtCodigo);
        return camposDeTexto;
    }

    private ArrayList<JDateChooser> listaDeCampoDeFecha() {
        ArrayList<JDateChooser> camposDeFecha = new ArrayList<>();
        camposDeFecha.add(txtFechaNacimiento);
        return camposDeFecha;
    }

    private void activarBotonesCrud(boolean activar) {
        txtDni.requestFocus();
        btnNuevo.setEnabled(!activar);
        btnActualizar.setEnabled(!activar);
        btnEliminar.setEnabled(!activar);
        btnGuardar.setEnabled(activar);
    }

    private void buscar() {
        Fila filaTabla;
        String nombre = txtBuscar.getText().trim();
        GestionarMozoServicio gestionarMozoServicio = new GestionarMozoServicio();
        try {
            List<Empleado> mozos = gestionarMozoServicio.mostrarMozos(nombre);
            ModeloTabla modeloTabla = (ModeloTabla) tablaMozo.getModel();
            modeloTabla.eliminarTotalFilas();
            for (Empleado mozo : mozos) {
                filaTabla = new Fila();
                filaTabla.agregarValorCelda(mozo.getEmpleadoid());
                filaTabla.agregarValorCelda(mozo.getCodigo());
                filaTabla.agregarValorCelda(mozo.getNombre() + " " + mozo.getApellido());
                filaTabla.agregarValorCelda(mozo.getDni());
                filaTabla.agregarValorCelda(mozo.getTelefono());
                filaTabla.agregarValorCelda(mozo.getDireccion());
                modeloTabla.agregarFila(filaTabla);
            }
            modeloTabla.refrescarDatos();
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
    }

    private int obtenerId() {
        int numFila = tablaMozo.getSelectedRow();
        if (numFila == -1) {
            Mensaje.mostrarFilaNoSeleccionada(this);
            return 0;
        }
        ModeloTabla modeloTabla = (ModeloTabla) tablaMozo.getModel();
        Fila fila = modeloTabla.obtenerFila(numFila);
        return (Integer) fila.obtenerCelda(0).getValor();
    }

    private Empleado encontrar(int mozoid) {
        try {
            GestionarMozoServicio gestionarMozoServicio = new GestionarMozoServicio();
            Empleado mozo = gestionarMozoServicio.buscarMozo(mozoid);
            return mozo;
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
        return null;
    }

    private void mostrarEnCampoDeTexto(Empleado mozo) {
        txtDireccion.setText(mozo.getDireccion());
        txtDni.setText(mozo.getDni());
        txtCodigo.setText(mozo.getCodigo());
        txtApellidos.setText(mozo.getApellido());
        txtNombre.setText(mozo.getNombre());
        txtTelefono.setText(mozo.getTelefono());
        txtFechaNacimiento.setDate(mozo.getFechaNacimiento());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMozo = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Código:");

        jLabel2.setText("DNI:");

        jLabel3.setText("Nombre(s):");

        jLabel4.setText("Apellidos:");

        jLabel5.setText("Telefono:");

        jLabel6.setText("Dirección:");

        jLabel7.setText("F. de Nacimiento:");

        txtCodigo.setEditable(false);

        tablaMozo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaMozo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaMozo.setRowHeight(21);
        tablaMozo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMozoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaMozo);

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

        jButton1.setText("Generar código");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(39, 39, 39)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(txtNombre)
                                .addComponent(txtApellidos)
                                .addComponent(txtDireccion)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnActualizar, btnCancelar, btnEliminar, btnGuardar, btnNuevo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo)
                            .addComponent(btnGuardar)
                            .addComponent(btnActualizar)
                            .addComponent(btnEliminar)
                            .addComponent(btnCancelar))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnActualizar, btnCancelar, btnEliminar, btnGuardar, btnNuevo});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Empleado mozo = new Mozo();
        mozo.setCodigo(txtCodigo.getText());
        mozo.setNombre(txtNombre.getText());
        mozo.setApellido(txtApellidos.getText());
        mozo.setDni(txtDni.getText());
        mozo.setTelefono(txtTelefono.getText());
        mozo.setEstado("A");
        mozo.setDireccion(txtDireccion.getText());
        mozo.setFechaNacimiento(txtFechaNacimiento.getDate());
        mozo.setFechaCreado(mozo.generarFechaActual());
        mozo.setFechaActualizado(mozo.generarFechaActual());
        GestionarMozoServicio gestionarMozoServicio = new GestionarMozoServicio();
        try {
            if (tipo_accion == ACCION_CREAR) {
                int registros_afectados = gestionarMozoServicio.crearMozo(mozo);
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
        Formateador.limpiarCampoDeFecha(listaDeCampoDeFecha());
        activarBotonesCrud(true);

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        tipo_accion = ACCION_MODIFICAR;
        mozo.setCodigo(txtCodigo.getText());
        mozo.setNombre(txtNombre.getText());
        mozo.setApellido(txtApellidos.getText());
        mozo.setDni(txtDni.getText());
        mozo.setTelefono(txtTelefono.getText());
        mozo.setEstado("A");
        mozo.setDireccion(txtDireccion.getText());
        mozo.setFechaNacimiento(txtFechaNacimiento.getDate());
        mozo.setFechaActualizado(mozo.generarFechaActual());
        GestionarMozoServicio gestionarMozoServicio = new GestionarMozoServicio();

        try {
            int registros_afectados = gestionarMozoServicio.modificarProveedor(mozo);
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
        Formateador.limpiarCampoDeFecha(listaDeCampoDeFecha());
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        tipo_accion = ACCION_ELIMINAR;
        int mozoid = obtenerId();

        if (mozoid == 0) {
            return;
        }
        if (!Mensaje.mostrarPreguntaDeEliminacion(this)) {
            return;
        }

        GestionarMozoServicio gestionarMozoServicio = new GestionarMozoServicio();
        Empleado mozo = new Mozo();
        mozo.setEmpleadoid(mozoid);
        mozo.setEstado("E");

        try {
            int registros_afectados = gestionarMozoServicio.eliminarMozo(mozo);
            if (registros_afectados == 1) {
                Mensaje.mostrarAfirmacionDeEliminacion(this);
            } else {
                Mensaje.mostrarAdvertenciaDeEliminacion(this);
            }
            buscar();
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
        Formateador.limpiarCampoDeTexto(listaDeCampoDeTexto());
        Formateador.limpiarCampoDeFecha(listaDeCampoDeFecha());
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Formateador.limpiarCampoDeTexto(listaDeCampoDeTexto());
        Formateador.limpiarCampoDeFecha(listaDeCampoDeFecha());
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tablaMozoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMozoMouseClicked

        if (evt.getClickCount() == 1) {
            int mozoid = obtenerId();
            mozo = encontrar(mozoid);
            mostrarEnCampoDeTexto(mozo);
            activarBotonesCrud(false);
        }

    }//GEN-LAST:event_tablaMozoMouseClicked

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        buscar();
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Empleado mozo = new Mozo();
        mozo.setNombre(txtNombre.getText());
        mozo.setApellido(txtApellidos.getText());
        txtCodigo.setText(mozo.generarCodigo(totalMozo()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private int totalMozo() {
        try {
            GestionarMozoServicio gestionarMozoServicio = new GestionarMozoServicio();
            int total = gestionarMozoServicio.totalMozos();
            return total + 1;
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
        return 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMozo;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private com.toedter.calendar.JDateChooser txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
