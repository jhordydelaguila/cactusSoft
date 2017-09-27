package cactussoft.capa1_presentacion;

import cactussoft.capa1_presentacion.util.ConfiguradorDeTabla;
import cactussoft.capa1_presentacion.util.Formateador;
import cactussoft.capa1_presentacion.util.Mensaje;
import cactussoft.capa2_aplicacion.GestionarCartaPrecioServicio;
import cactussoft.capa2_aplicacion.GestionarCartaServicio;
import cactussoft.capa3_dominio.entidades.Carta;
import cactussoft.capa3_dominio.entidades.Precio;
import cactussoft.capa3_dominio.entidades.Plato;
import java.util.List;
import javax.swing.JOptionPane;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Fila;

public class FormMAGestionarCarta extends javax.swing.JDialog {

    private int tipo_accion;
    private final int ACCION_MODIFICAR = 1;
    private final int ACCION_QUITAR_PLATO = 2;
    private final int ACCION_AGREGAR_PLATO = 3;
    private Carta carta;

    public FormMAGestionarCarta(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        Formateador.centrarVentanaDialog(this);
        tablaCarta.setModel(ConfiguradorDeTabla.crearTablaCarta());

        txtBuscarNombre.requestFocus();
        mostrarCarta();
        mostrarMensajePrecio();
    }

    private void mostrarCarta() {
        Fila fila;
        GestionarCartaServicio gestionarCartaServicio = new GestionarCartaServicio();
        try {
            carta = gestionarCartaServicio.mostrarCarta();
            txtNombre.setText(carta.getNombre());

            ModeloTabla modeloTabla = (ModeloTabla) tablaCarta.getModel();
            modeloTabla.eliminarTotalFilas();
            for (Plato plato : carta.getPlatos()) {
                fila = new Fila();
                fila.agregarValorCelda(plato.getPlatoid());
                fila.agregarValorCelda(plato.getNombre());
                fila.agregarValorCelda(plato.getPrecio());
                fila.agregarValorCelda(plato.getPrecioCarta());
                fila.agregarValorCelda(plato.getCategoria().getNombre());
                modeloTabla.agregarFila(fila);
            }
            modeloTabla.refrescarDatos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void buscar() {
        Fila fila;
        String nombre = txtBuscarNombre.getText().trim();
        try {
            GestionarCartaServicio gestionarCartaServicio = new GestionarCartaServicio();
            List<Plato> platos = gestionarCartaServicio.buscarCarta(nombre);
            ModeloTabla modeloTabla = (ModeloTabla) tablaCarta.getModel();
            modeloTabla.eliminarTotalFilas();
            for (Plato plato : platos) {
                fila = new Fila();
                fila.agregarValorCelda(plato.getPlatoid());
                fila.agregarValorCelda(plato.getNombre());
                fila.agregarValorCelda(plato.getPrecio());
                fila.agregarValorCelda(plato.getPrecioCarta());
                fila.agregarValorCelda(plato.getCategoria().getNombre());
                modeloTabla.agregarFila(fila);
            }
            modeloTabla.refrescarDatos();

        } catch (Exception e) {
            Mensaje.mostrarError(this, e.getMessage());
        }
    }

    private void agregarPlatoTablaDeLaCarta(Plato plato) {
        ModeloTabla modeloTabla = (ModeloTabla) tablaCarta.getModel();
        Fila fila = new Fila();
        fila.agregarValorCelda(plato.getPlatoid());
        fila.agregarValorCelda(plato.getNombre());
        fila.agregarValorCelda(plato.getPrecio());
        fila.agregarValorCelda(plato.getPrecioCarta());
        fila.agregarValorCelda(plato.getCategoria().getNombre());
        modeloTabla.agregarFila(fila);
        carta.agregarPlato(plato);
    }

    private void agregarPlatosTablaDeLaCarta(List<Plato> platos) {
        ModeloTabla modeloTabla = (ModeloTabla) tablaCarta.getModel();
        Fila fila;
        for (Plato plato : platos) {
            fila = new Fila();
            fila.agregarValorCelda(plato.getPlatoid());
            fila.agregarValorCelda(plato.getNombre());
            fila.agregarValorCelda(plato.getPrecio());
            fila.agregarValorCelda(plato.getPrecioCarta());
            fila.agregarValorCelda(plato.getCategoria().getNombre());
            modeloTabla.agregarFila(fila);
            carta.agregarPlato(plato);
        }
        modeloTabla.refrescarDatos();
    }

    private void activarGuardar(boolean activa) {
        btnGuardar.setEnabled(activa);
        btnCancelar.setEnabled(activa);
    }

    private void mostrarMensajePrecio() {
        txtMensaje.setText("");
        txtMensaje.setText(carta.mensajePrecio(carta.getPrecio()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtBuscarNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCarta = new javax.swing.JTable();
        btnQuitarPlato = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextPane();
        btnVerFestivo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAdministrar = new javax.swing.JMenu();
        menuCambiarNombre = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuSalir = new javax.swing.JMenuItem();
        menuPlato = new javax.swing.JMenu();
        menuCrearPlato = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuAgregarPlatos = new javax.swing.JMenuItem();
        menuFestivos = new javax.swing.JMenu();
        menuAumentarPrecio = new javax.swing.JMenuItem();
        menuRestaurarPrecio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurante Cactus - Administrar Carta");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(204, 255, 204));
        txtNombre.setText("Nombre de la carta");
        txtNombre.setPreferredSize(new java.awt.Dimension(97, 30));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        txtBuscarNombre.setPreferredSize(new java.awt.Dimension(232, 30));
        txtBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarNombreKeyPressed(evt);
            }
        });

        tablaCarta.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaCarta.setRowHeight(27);
        tablaCarta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCartaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCarta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnQuitarPlato.setText("Eliminar plato");
        btnQuitarPlato.setEnabled(false);
        btnQuitarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarPlatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnQuitarPlato)
                        .addGap(0, 511, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnQuitarPlato)
                .addContainerGap())
        );

        jTabbedPane1.addTab("CARTA - RESTAURANTE EL CACTUS", jPanel4);

        txtMensaje.setBackground(new java.awt.Color(204, 255, 204));
        txtMensaje.setSelectedTextColor(new java.awt.Color(204, 255, 255));
        jScrollPane2.setViewportView(txtMensaje);

        btnVerFestivo.setText("Ver estado");
        btnVerFestivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerFestivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(btnVerFestivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnGuardar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerFestivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addGap(139, 139, 139))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, btnGuardar});

        menuAdministrar.setText("Carta");

        menuCambiarNombre.setText("Cambiar nombre");
        menuCambiarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCambiarNombreActionPerformed(evt);
            }
        });
        menuAdministrar.add(menuCambiarNombre);
        menuAdministrar.add(jSeparator1);

        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        menuAdministrar.add(menuSalir);

        jMenuBar1.add(menuAdministrar);

        menuPlato.setText("Platos");

        menuCrearPlato.setText("Registrar plato");
        menuCrearPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCrearPlatoActionPerformed(evt);
            }
        });
        menuPlato.add(menuCrearPlato);
        menuPlato.add(jSeparator3);

        menuAgregarPlatos.setText("Agregar Platos");
        menuAgregarPlatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgregarPlatosActionPerformed(evt);
            }
        });
        menuPlato.add(menuAgregarPlatos);

        jMenuBar1.add(menuPlato);

        menuFestivos.setText("Precio");

        menuAumentarPrecio.setText("Precio de la carta");
        menuAumentarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAumentarPrecioActionPerformed(evt);
            }
        });
        menuFestivos.add(menuAumentarPrecio);

        menuRestaurarPrecio.setText("Restaurar precio");
        menuRestaurarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRestaurarPrecioActionPerformed(evt);
            }
        });
        menuFestivos.add(menuRestaurarPrecio);

        jMenuBar1.add(menuFestivos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuAumentarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAumentarPrecioActionPerformed
        new FormMACartaPrecio(this, carta).setVisible(true);
        mostrarCarta();
        mostrarMensajePrecio();
    }//GEN-LAST:event_menuAumentarPrecioActionPerformed

    private void menuCambiarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCambiarNombreActionPerformed
        txtNombre.setEditable(true);
        txtNombre.requestFocus();
        tipo_accion = ACCION_MODIFICAR;
    }//GEN-LAST:event_menuCambiarNombreActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtNombre.setEditable(false);
        activarGuardar(false);
        mostrarCarta();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombre = txtNombre.getText();
        int registros_afectados;
        GestionarCartaServicio gestionarCartaServicio = new GestionarCartaServicio();

        switch (tipo_accion) {
            case ACCION_MODIFICAR:
                try {
                    carta.setNombre(nombre);
                    registros_afectados = gestionarCartaServicio.modificarCarta(carta);
                    if (registros_afectados == 1) {
                        Mensaje.mostrarAfirmacionDeActualizacion(this);
                    } else {
                        Mensaje.mostrarAdvertenciaDeActualizacion(this);
                    }
                    txtNombre.setEditable(false);
                    activarGuardar(false);
                } catch (Exception e) {
                    Mensaje.mostrarAdvertencia(this, e.getMessage());
                }
                break;
            case ACCION_QUITAR_PLATO:
                try {
                    registros_afectados = gestionarCartaServicio.registrarPlato(carta);
                    if (registros_afectados == 1) {
                        JOptionPane.showMessageDialog(this, "Se ha eliminado el plato");
                    } else {
                        Mensaje.mostrarAdvertenciaDeCreacion(this);
                    }
                    activarGuardar(false);
                } catch (Exception e) {
                    Mensaje.mostrarAdvertencia(this, e.getMessage());
                }
                break;
            case ACCION_AGREGAR_PLATO:
                try {
                    registros_afectados = gestionarCartaServicio.registrarPlato(carta);
                    if (registros_afectados == 1) {
                        JOptionPane.showMessageDialog(this, "Se ha agregado un plato a la carta.");
                    } else {
                        Mensaje.mostrarAdvertenciaDeCreacion(this);
                    }
                    activarGuardar(false);
                } catch (Exception e) {
                    Mensaje.mostrarAdvertencia(this, e.getMessage());
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        if (txtNombre.isEditable()) {
            activarGuardar(true);
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void btnQuitarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarPlatoActionPerformed
        tipo_accion = ACCION_QUITAR_PLATO;
        int numeroFila = tablaCarta.getSelectedRow();
        if (numeroFila == -1) {
            Mensaje.mostrarFilaNoSeleccionada(this);
            return;
        }
        ModeloTabla modeloTabla = (ModeloTabla) tablaCarta.getModel();
        modeloTabla.eliminarFila(numeroFila);
        carta.eliminarCarta(numeroFila);
        modeloTabla.refrescarDatos();

        activarGuardar(true);
    }//GEN-LAST:event_btnQuitarPlatoActionPerformed

    private void menuRestaurarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRestaurarPrecioActionPerformed
        //obtenerFestivo
        Precio precio = obtenerFestivoPrecioRegular();

        String titulo = "Restaurar";
        String mensaje = "¿Desea restaurar precio?";
        GestionarCartaServicio gestionarCartaServicio = new GestionarCartaServicio();
        int opcion = JOptionPane.showConfirmDialog(this, mensaje, titulo, JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                carta.setPrecio(precio);
                int registros_afectados = gestionarCartaServicio.modificarPrecio(carta);
                if (registros_afectados == 1) {
                    JOptionPane.showMessageDialog(this, "Se restauro el precio");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo restaurar el precio");
                }
            } catch (Exception e) {
                Mensaje.mostrarAdvertencia(this, e.getMessage());
            }
        }
        mostrarCarta();
        mostrarMensajePrecio();
    }//GEN-LAST:event_menuRestaurarPrecioActionPerformed

    private void btnVerFestivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerFestivoActionPerformed
        mostrarMensajePrecio();
    }//GEN-LAST:event_btnVerFestivoActionPerformed

    private void tablaCartaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCartaMouseClicked
        btnQuitarPlato.setEnabled(true);
    }//GEN-LAST:event_tablaCartaMouseClicked

    private void txtBuscarNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarNombreKeyPressed
        buscar();
    }//GEN-LAST:event_txtBuscarNombreKeyPressed

    private void menuAgregarPlatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgregarPlatosActionPerformed
        tipo_accion = ACCION_AGREGAR_PLATO;
        FormMAMostrarPlatos formMAMostrarPlatos = new FormMAMostrarPlatos(this);
        formMAMostrarPlatos.setVisible(true);

        Plato plato = formMAMostrarPlatos.obtenerPlato();
        List<Plato> platos = formMAMostrarPlatos.obtenerPlatos();
        if (plato != null) {
            agregarPlatoTablaDeLaCarta(plato);
            activarGuardar(true);
        } else if (platos != null) {
            agregarPlatosTablaDeLaCarta(platos);
            activarGuardar(true);
        }
    }//GEN-LAST:event_menuAgregarPlatosActionPerformed

    private void menuCrearPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCrearPlatoActionPerformed
        new FormMAGestionarPlato(this).setVisible(true);
    }//GEN-LAST:event_menuCrearPlatoActionPerformed

    private Precio obtenerFestivoPrecioRegular() {
        GestionarCartaPrecioServicio gestionarCartaPrecioServicio = new GestionarCartaPrecioServicio();
        try {
            Precio precioRegular = gestionarCartaPrecioServicio.buscarPrecioRegular();
            return precioRegular;
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(this, e.getMessage());
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnQuitarPlato;
    private javax.swing.JButton btnVerFestivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenu menuAdministrar;
    private javax.swing.JMenuItem menuAgregarPlatos;
    private javax.swing.JMenuItem menuAumentarPrecio;
    private javax.swing.JMenuItem menuCambiarNombre;
    private javax.swing.JMenuItem menuCrearPlato;
    private javax.swing.JMenu menuFestivos;
    private javax.swing.JMenu menuPlato;
    private javax.swing.JMenuItem menuRestaurarPrecio;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JTable tablaCarta;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextPane txtMensaje;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
