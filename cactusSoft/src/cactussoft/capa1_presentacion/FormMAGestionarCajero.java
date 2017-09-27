package cactussoft.capa1_presentacion;

import cactussoft.capa1_presentacion.util.ConfiguradorDeTabla;
import cactussoft.capa1_presentacion.util.Formateador;
import cactussoft.capa1_presentacion.util.Mensaje;
import cactussoft.capa2_aplicacion.GestionarCajeroServicio;
import cactussoft.capa2_aplicacion.GestionarCategoriaServicio;
import cactussoft.capa3_dominio.entidades.Cajero;
import cactussoft.capa3_dominio.entidades.Empleado;
import cactussoft.capa3_dominio.entidades.Usuario;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Fila;

public class FormMAGestionarCajero extends javax.swing.JDialog {

    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private final int ACCION_ELIMINAR = 3;
    private int tipo_accion;
    private Empleado cajero;

    public FormMAGestionarCajero(java.awt.Frame parent) {
        super(parent, true);
        initComponents();

        tipo_accion = ACCION_CREAR;
        Formateador.centrarVentanaDialog(this);
        activarBotonesCrud(true);
        tablaCajero.setModel(ConfiguradorDeTabla.crearTablaEmpleado());
        buscar();
    }

    private ArrayList<JTextField> listaDeCampoDeTexto() {
        ArrayList<JTextField> camposDeTexto = new ArrayList<>();
        camposDeTexto.add(txtDni);
        camposDeTexto.add(txtApellidos);
        camposDeTexto.add(txtNombre);
        camposDeTexto.add(txtTelefono);
        camposDeTexto.add(txtDireccion);
        camposDeTexto.add(txtUsuario);
        camposDeTexto.add(txtEmail);
        camposDeTexto.add(txtPassword);
        camposDeTexto.add(txtPassowrdAgain);
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
        GestionarCajeroServicio gestionarMozoServicio = new GestionarCajeroServicio();
        try {
            List<Empleado> cajeros = gestionarMozoServicio.mostrarCajeros(nombre);
            ModeloTabla modeloTabla = (ModeloTabla) tablaCajero.getModel();
            modeloTabla.eliminarTotalFilas();
            for (Empleado mozo : cajeros) {
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
        int numFila = tablaCajero.getSelectedRow();
        if (numFila == -1) {
            Mensaje.mostrarFilaNoSeleccionada(this);
            return 0;
        }
        ModeloTabla modeloTabla = (ModeloTabla) tablaCajero.getModel();
        Fila fila = modeloTabla.obtenerFila(numFila);
        return (Integer) fila.obtenerCelda(0).getValor();
    }

    private Empleado encontrar(int cajeroid) {
        try {
            GestionarCajeroServicio gestionarCajeroServicio = new GestionarCajeroServicio();
            Empleado mozo = gestionarCajeroServicio.buscarCajero(cajeroid);
            return mozo;
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
        return null;
    }

    private void mostrarEnCampoDeTexto(Empleado mozo) {
        txtDireccion.setText(mozo.getDireccion());
        txtDni.setText(mozo.getDni());
//        txtCodigo.setText(mozo.getCodigo());
        txtApellidos.setText(mozo.getApellido());
        txtNombre.setText(mozo.getNombre());
        txtTelefono.setText(mozo.getTelefono());
        txtFechaNacimiento.setDate(mozo.getFechaNacimiento());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCajero = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtPassowrdAgain = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("DNI:");

        jLabel3.setText("Nombre(s):");

        jLabel4.setText("Apellidos:");

        jLabel5.setText("Telefono:");

        jLabel6.setText("Dirección:");

        jLabel7.setText("F. de Nacimiento:");

        tablaCajero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaCajero.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaCajero.setRowHeight(21);
        tablaCajero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCajeroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCajero);

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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Email:");

        jLabel9.setText("Contraseña:");

        jLabel10.setText("Repetir Contraseña:");

        jLabel11.setText("Usuario:");

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword)
                    .addComponent(txtPassowrdAgain)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(txtEmail))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPassowrdAgain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Panel de usuario:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtNombre)
                                    .addComponent(txtDireccion)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtApellidos)))
                            .addComponent(jSeparator1)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addGap(14, 14, 14)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnActualizar, btnCancelar, btnEliminar, btnGuardar, btnNuevo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 39, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo)
                            .addComponent(btnGuardar)
                            .addComponent(btnActualizar)
                            .addComponent(btnEliminar)
                            .addComponent(btnCancelar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
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
        //captura de usuario
        Usuario usuario = new Usuario();
        usuario.setUser(txtUsuario.getText());
        usuario.setEmail(txtEmail.getText());
        usuario.setPassword(new String(txtPassword.getPassword()));
        usuario.setEstado("A");

        Empleado cajero = new Cajero(usuario);
        cajero.setNombre(txtNombre.getText());
        cajero.setApellido(txtApellidos.getText());
        cajero.setDni(txtDni.getText());
        cajero.setTelefono(txtTelefono.getText());
        cajero.setEstado("A");
        cajero.setDireccion(txtDireccion.getText());
        cajero.setFechaNacimiento(txtFechaNacimiento.getDate());
        cajero.setFechaCreado(cajero.generarFechaActual());
        cajero.setFechaActualizado(cajero.generarFechaActual());
        GestionarCajeroServicio gestionarCajeroServicio = new GestionarCajeroServicio();
        try {
            if (tipo_accion == ACCION_CREAR) {
                int registros_afectados = gestionarCajeroServicio.crearCajero(cajero);
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
        cajero.setNombre(txtNombre.getText());
        cajero.setApellido(txtApellidos.getText());
        cajero.setDni(txtDni.getText());
        cajero.setTelefono(txtTelefono.getText());
        cajero.setEstado("A");
        cajero.setDireccion(txtDireccion.getText());
        cajero.setFechaNacimiento(txtFechaNacimiento.getDate());
        cajero.setFechaActualizado(cajero.generarFechaActual());
        GestionarCajeroServicio gestionarCajeroServicio = new GestionarCajeroServicio();

        try {
            int registros_afectados = gestionarCajeroServicio.modificarCajero(cajero);
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
        int cajeroid = obtenerId();

        if (cajeroid == 0) {
            return;
        }
        if (!Mensaje.mostrarPreguntaDeEliminacion(this)) {
            return;
        }

        GestionarCajeroServicio gestionarCajeroServicio = new GestionarCajeroServicio();
        Empleado cajero = new Cajero();
        cajero.setEmpleadoid(cajeroid);
        cajero.setEstado("E");

        try {
            int registros_afectados = gestionarCajeroServicio.eliminarCajero(cajero);
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
        Formateador.limpiarCampoDeFecha(listaDeCampoDeFecha());
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Formateador.limpiarCampoDeTexto(listaDeCampoDeTexto());
        Formateador.limpiarCampoDeFecha(listaDeCampoDeFecha());
        activarBotonesCrud(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tablaCajeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCajeroMouseClicked

        if (evt.getClickCount() == 1) {
            int mozoid = obtenerId();
            cajero = encontrar(mozoid);
            mostrarEnCampoDeTexto(cajero);
            activarBotonesCrud(false);
        }

    }//GEN-LAST:event_tablaCajeroMouseClicked

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        buscar();
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Empleado mozo = new Cajero();
        mozo.setNombre(txtNombre.getText());
        mozo.setApellido(txtApellidos.getText());
        txtUsuario.setText(mozo.generarCodigo(total()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private int total() {
        try {
            GestionarCajeroServicio gestionarCajeroServicio = new GestionarCajeroServicio();
            int total = gestionarCajeroServicio.totalCajeros();
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaCajero;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEmail;
    private com.toedter.calendar.JDateChooser txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassowrdAgain;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
