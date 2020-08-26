/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.intelaf_project1.UI.trabajador;

import com.mycompany.intelaf_project1.Cliente;
import com.mycompany.intelaf_project1.Conexion;
import com.mycompany.intelaf_project1.Empleado;
import com.mycompany.intelaf_project1.Pedido;
import com.mycompany.intelaf_project1.Producto;
import com.mycompany.intelaf_project1.TiempoTras;
import com.mycompany.intelaf_project1.Tienda;
import com.mycompany.intelaf_project1.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author joshua
 */
public class IngresarDatos extends javax.swing.JFrame {
    
    Empleado e = new Empleado();
    Tienda t = new Tienda();
    Cliente c = new Cliente();
    Producto p = new Producto();
    Pedido pedido = new Pedido();
    TiempoTras tiempoTras = new TiempoTras();
    Venta v = new Venta();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public IngresarDatos() {
        initComponents();
        setLocationRelativeTo(null);
        ocultarTodasCasillasGuardarCliente();
        ocultarTodasCasillasModificarCliente();
        ocultarTodasCasillasGuardarEmpleado();
        ocultarTodasCasillasModificarEmpleado();
        ocultarComponentesTiempo();
         cargarTiendasBD();
         ocultarComponentesProducto();
         txt_seleccionarTienda.setEditable(false);
         txt_tiendaCodigo.setVisible(false);
         txt_tiendaOrigenTiempo.setVisible(false);
         txt_idTiempo.setVisible(false);
         btn_guardarPedido.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        cb_tiendaSeleccion = new javax.swing.JComboBox<>();
        txt_ingresarTienda = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_seleccionarTienda = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        txt_tiendaCodigo = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        EMPLEADO2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtProducto = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        txt_buscarProducto = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txt_cantDisponibleProducto = new javax.swing.JTextField();
        txt_descripcionProducto = new javax.swing.JTextField();
        txt_garantiaProducto = new javax.swing.JTextField();
        txt_nombreProducto = new javax.swing.JTextField();
        txt_fabricanteProducto = new javax.swing.JTextField();
        btn_guardarProducto = new javax.swing.JButton();
        btn_modificarProducto = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txt_codigoProducto = new javax.swing.JTextField();
        txt_precioProducto = new javax.swing.JTextField();
        cb_Producto = new javax.swing.JComboBox<>();
        btn_activarProducto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_nuevoProducto = new javax.swing.JTextField();
        txt_mostrarTiendaProducto = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        EMPLEADO5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtVenta = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        txt_buscarVenta = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        txt_nitClienteVenta = new javax.swing.JTextField();
        txt_fechaVenta = new javax.swing.JTextField();
        txt_codigoTiendaVenta = new javax.swing.JTextField();
        btn_registrarVenta = new javax.swing.JButton();
        btn_modificarVenta = new javax.swing.JButton();
        txt_cantArticulosVenta = new javax.swing.JTextField();
        cb_Venta = new javax.swing.JComboBox<>();
        btn_activarVenta = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        txt_totalPagarVenta = new javax.swing.JTextField();
        txt_mostrarTiendaVenta = new javax.swing.JTextField();
        cb_codigoProductoVenta = new javax.swing.JComboBox<>();
        txt_creditoClieteVenta = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel74 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        EMPLEADO4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtPedido = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        txt_buscarPedido = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txt_nitClientePedido = new javax.swing.JTextField();
        txt_fechaPedido = new javax.swing.JTextField();
        txt_tiendaDestinoPedido = new javax.swing.JTextField();
        btn_guardarPedido = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        txt_codigoPedido = new javax.swing.JTextField();
        txt_cantArticulosPedido = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        txt_anticipoPedido = new javax.swing.JTextField();
        txt_mostrarTiendaPedido = new javax.swing.JTextField();
        cb_tiendaOrigenPedido = new javax.swing.JComboBox<>();
        cb_codigoProductoPedido = new javax.swing.JComboBox<>();
        btn_mostrarProductos = new javax.swing.JButton();
        btn_anticipoPedido = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        EMPLEADO3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtTiempo = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        txt_buscarTiempo = new javax.swing.JTextField();
        txt_tiendaOrigenTiempo = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        btn_guardarTiempo = new javax.swing.JButton();
        btn_modificarTiempo = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        txt_tiempo = new javax.swing.JTextField();
        cb_Tiempo = new javax.swing.JComboBox<>();
        btn_activarTiempo = new javax.swing.JButton();
        txt_idTiempo = new javax.swing.JTextField();
        txt_mostrarTiendaTiempos = new javax.swing.JTextField();
        cb_tiendaDestinoTiempo = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        EMPLEADO7 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtReportes = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        txt_buscarReportes = new javax.swing.JTextField();
        txt_mostrarReporte = new javax.swing.JTextField();
        btn_pedidosLlegaranTienda = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        TIENDA = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTiendas = new javax.swing.JTable();
        btn_cargarDatosTienda = new javax.swing.JButton();
        txt_buscarTienda = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txt_correoTienda = new javax.swing.JTextField();
        txt_direccionTienda = new javax.swing.JTextField();
        txt_telefono2Tienda = new javax.swing.JTextField();
        txt_nombreTienda = new javax.swing.JTextField();
        txt_telefono1Tienda = new javax.swing.JTextField();
        btn_guardarTienda = new javax.swing.JButton();
        btn_modificarTienda = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txt_codigoTienda = new javax.swing.JTextField();
        txt_horarioTienda = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        EMPLEADO = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEmpleados = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_correoEmpleado = new javax.swing.JTextField();
        txt_direccionEmpleado = new javax.swing.JTextField();
        txt_nitEmpleado = new javax.swing.JTextField();
        txt_nombreEmpleado = new javax.swing.JTextField();
        txt_telefonoEmpleado = new javax.swing.JTextField();
        btn_guardarEmpleado = new javax.swing.JButton();
        btn_modificarEmpleado = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_codigoEmpleado = new javax.swing.JTextField();
        txt_dpiEmpleado = new javax.swing.JTextField();
        cb_Empleado = new javax.swing.JComboBox<>();
        btn_activarEmpleado = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        EMPLEADO1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();
        btn_cargarCliente = new javax.swing.JButton();
        txt_buscarCliente = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_correoCliente = new javax.swing.JTextField();
        txt_creditoCliente = new javax.swing.JTextField();
        txt_direccionCliente = new javax.swing.JTextField();
        txt_nombreCliente = new javax.swing.JTextField();
        txt_telefonoCliente = new javax.swing.JTextField();
        btn_guardarCliente = new javax.swing.JButton();
        btn_modificarCliente = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txt_nitCliente = new javax.swing.JTextField();
        txt_dpiCliente = new javax.swing.JTextField();
        cb_cliente = new javax.swing.JComboBox<>();
        btn_activarCliente = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INTELAF S.A");

        cb_tiendaSeleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR TIENDA" }));

        txt_ingresarTienda.setText("INGRESAR");
        txt_ingresarTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ingresarTiendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 836, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jLabel50.setFont(new java.awt.Font("Dyuthi", 1, 14)); // NOI18N
        jLabel50.setText("Version Trabajadores");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Dyuthi", 1, 36)); // NOI18N
        jLabel4.setText("SELECCIONA LA TIENDA QUE DESEAS INGRESAR");

        txt_seleccionarTienda.setFont(new java.awt.Font("Dyuthi", 0, 18)); // NOI18N
        txt_seleccionarTienda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_seleccionarTienda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(365, 365, 365)
                                .addComponent(cb_tiendaSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(424, 424, 424)
                                .addComponent(txt_ingresarTienda))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(txt_seleccionarTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(103, 103, 103)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(11, 11, 11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(cb_tiendaSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_ingresarTienda)
                                .addGap(39, 39, 39)
                                .addComponent(txt_seleccionarTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)))
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel50)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("SELECIONAR TIENDA", jPanel1);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        txt_tiendaCodigo.setEnabled(false);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(522, Short.MAX_VALUE)
                .addComponent(txt_tiendaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_tiendaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel42.setFont(new java.awt.Font("Dyuthi", 1, 14)); // NOI18N
        jLabel42.setText("Version Trabajadores");

        jtProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "FABRICANTE", "CANTIDAD DISPONIBLE", "PRECIO", "DESCRIPCION", "GARANTIA", "CODIGO TIENDA"
            }
        ));
        jtProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProductoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtProducto);

        jButton2.setText("CARGAR DATOS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel43.setText("NOMBRE: ");

        jLabel44.setText("FABRICANTE:");

        jLabel45.setText("GARANTIA: ");

        jLabel46.setText("CANTIDAD DISPONIBLE:");

        jLabel47.setText("DESCRIPCION: ");

        btn_guardarProducto.setText("GUARDAR");
        btn_guardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarProductoActionPerformed(evt);
            }
        });

        btn_modificarProducto.setText("MODIFICAR");
        btn_modificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarProductoActionPerformed(evt);
            }
        });

        jLabel48.setText("CODIGO: ");

        jLabel49.setText("PRECIO:");

        cb_Producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "GUARDAR", "MODIFICAR" }));

        btn_activarProducto.setText("ACTIVAR");
        btn_activarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_activarProductoActionPerformed(evt);
            }
        });

        jLabel1.setText("NUEVOS PRODUCTOS: ");

        txt_mostrarTiendaProducto.setEditable(false);
        txt_mostrarTiendaProducto.setFont(new java.awt.Font("Dyuthi", 0, 18)); // NOI18N
        txt_mostrarTiendaProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mostrarTiendaProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout EMPLEADO2Layout = new javax.swing.GroupLayout(EMPLEADO2);
        EMPLEADO2.setLayout(EMPLEADO2Layout);
        EMPLEADO2Layout.setHorizontalGroup(
            EMPLEADO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EMPLEADO2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(EMPLEADO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(EMPLEADO2Layout.createSequentialGroup()
                        .addComponent(txt_mostrarTiendaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_buscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADO2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(EMPLEADO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EMPLEADO2Layout.createSequentialGroup()
                                .addGroup(EMPLEADO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel43))
                                .addGap(104, 104, 104)
                                .addGroup(EMPLEADO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(EMPLEADO2Layout.createSequentialGroup()
                                        .addComponent(txt_fabricanteProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel49))
                                    .addGroup(EMPLEADO2Layout.createSequentialGroup()
                                        .addComponent(txt_nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(EMPLEADO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_precioProducto)
                                            .addComponent(txt_codigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txt_garantiaProducto)
                                    .addComponent(txt_descripcionProducto)
                                    .addGroup(EMPLEADO2Layout.createSequentialGroup()
                                        .addComponent(txt_cantDisponibleProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_nuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel47)
                            .addComponent(jLabel46))
                        .addGap(64, 64, 64)
                        .addGroup(EMPLEADO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_Producto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guardarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_modificarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_activarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)))
                .addGap(17, 17, 17))
        );
        EMPLEADO2Layout.setVerticalGroup(
            EMPLEADO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EMPLEADO2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(EMPLEADO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(txt_buscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mostrarTiendaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(EMPLEADO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EMPLEADO2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(EMPLEADO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_codigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EMPLEADO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fabricanteProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49)
                            .addComponent(txt_precioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(EMPLEADO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_garantiaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EMPLEADO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cantDisponibleProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_nuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EMPLEADO2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_descripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(EMPLEADO2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_activarProducto)
                        .addGap(31, 31, 31)
                        .addComponent(btn_guardarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificarProducto)
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(EMPLEADO2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(EMPLEADO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("PRODUCTO", jPanel5);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jtVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CODIGO TIENDA ACTUAL", "FECHA DE VENTA", "NIT CLIENTE", "CODIGO PRODUCTO", "CANTIDAD ARTICULOS", "TOTAL A PAGAR"
            }
        ));
        jtVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtVentaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jtVenta);

        jButton6.setText("CARGAR DATOS");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel66.setText("CODIGO TIENDA ACTUAL:");

        jLabel67.setText("FECHA DE VENTA:");

        jLabel68.setText("NIT CLIENTE:");

        jLabel69.setText("CANTIDAD ARTICULOS:");

        txt_codigoTiendaVenta.setEditable(false);

        btn_registrarVenta.setText("REGISTRAR");
        btn_registrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarVentaActionPerformed(evt);
            }
        });

        btn_modificarVenta.setText("MODIFICAR");
        btn_modificarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarVentaActionPerformed(evt);
            }
        });

        cb_Venta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "GUARDAR", "MODIFICAR" }));

        btn_activarVenta.setText("ACTIVAR");
        btn_activarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_activarVentaActionPerformed(evt);
            }
        });

        jLabel73.setText("CODIGO PRODUCTO EXISTENCIA:");

        txt_mostrarTiendaVenta.setEditable(false);
        txt_mostrarTiendaVenta.setFont(new java.awt.Font("Dyuthi", 0, 18)); // NOI18N
        txt_mostrarTiendaVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mostrarTiendaVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cb_codigoProductoVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CODIGO PRODUCTO" }));

        txt_creditoClieteVenta.setEditable(false);

        jButton7.setText("VER TOTAL A PAGAR:");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EMPLEADO5Layout = new javax.swing.GroupLayout(EMPLEADO5);
        EMPLEADO5.setLayout(EMPLEADO5Layout);
        EMPLEADO5Layout.setHorizontalGroup(
            EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADO5Layout.createSequentialGroup()
                .addGroup(EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EMPLEADO5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane7)
                            .addGroup(EMPLEADO5Layout.createSequentialGroup()
                                .addComponent(txt_mostrarTiendaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_buscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(EMPLEADO5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADO5Layout.createSequentialGroup()
                                .addGroup(EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel66)
                                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel68))
                                .addGap(68, 68, 68))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADO5Layout.createSequentialGroup()
                                .addComponent(jLabel73)
                                .addGap(18, 18, 18)))
                        .addGroup(EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EMPLEADO5Layout.createSequentialGroup()
                                .addGroup(EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cb_codigoProductoVenta, javax.swing.GroupLayout.Alignment.LEADING, 0, 185, Short.MAX_VALUE)
                                    .addComponent(txt_codigoTiendaVenta, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_fechaVenta, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nitClienteVenta, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(47, 47, 47)
                                .addGroup(EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(EMPLEADO5Layout.createSequentialGroup()
                                        .addComponent(jLabel69)
                                        .addGap(23, 23, 23)
                                        .addComponent(txt_cantArticulosVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(EMPLEADO5Layout.createSequentialGroup()
                                        .addComponent(jButton7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_totalPagarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADO5Layout.createSequentialGroup()
                                .addComponent(txt_creditoClieteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)))
                        .addGroup(EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_Venta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_registrarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_modificarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_activarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97)))
                .addGap(17, 17, 17))
        );
        EMPLEADO5Layout.setVerticalGroup(
            EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EMPLEADO5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(txt_buscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mostrarTiendaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigoTiendaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cantArticulosVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EMPLEADO5Layout.createSequentialGroup()
                        .addComponent(btn_activarVenta)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADO5Layout.createSequentialGroup()
                        .addGroup(EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_fechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7)
                            .addComponent(txt_totalPagarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EMPLEADO5Layout.createSequentialGroup()
                        .addGroup(EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(EMPLEADO5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txt_nitClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(EMPLEADO5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb_codigoProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADO5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(txt_creditoClieteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)))
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(EMPLEADO5Layout.createSequentialGroup()
                        .addComponent(btn_registrarVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificarVenta))))
        );

        jLabel74.setFont(new java.awt.Font("Dyuthi", 1, 14)); // NOI18N
        jLabel74.setText("Version Trabajadores");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EMPLEADO5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(EMPLEADO5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel74, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("VENTA", jPanel12);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        jLabel54.setFont(new java.awt.Font("Dyuthi", 1, 14)); // NOI18N
        jLabel54.setText("Version Trabajadores");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jtPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "TIENDA ORIGEN", "TIENDA DESTINO", "FECHA", "NIT CLIENTE", "CODIGO PRODUCTO", "CANTIDAD ARTICULOS", "TOTAL A PAGAR", "ANTICIPO"
            }
        ));
        jtPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPedidoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jtPedido);
        if (jtPedido.getColumnModel().getColumnCount() > 0) {
            jtPedido.getColumnModel().getColumn(0).setHeaderValue("CODIGO");
            jtPedido.getColumnModel().getColumn(1).setHeaderValue("TIENDA ORIGEN");
            jtPedido.getColumnModel().getColumn(2).setHeaderValue("TIENDA DESTINO");
            jtPedido.getColumnModel().getColumn(3).setHeaderValue("FECHA");
            jtPedido.getColumnModel().getColumn(4).setHeaderValue("NIT CLIENTE");
            jtPedido.getColumnModel().getColumn(5).setHeaderValue("CODIGO PRODUCTO");
            jtPedido.getColumnModel().getColumn(6).setHeaderValue("CANTIDAD ARTICULOS");
            jtPedido.getColumnModel().getColumn(7).setHeaderValue("TOTAL A PAGAR");
            jtPedido.getColumnModel().getColumn(8).setHeaderValue("ANTICIPO");
        }

        jButton3.setText("CARGAR DATOS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel55.setText("CODIGO TIENDA ORIGEN:");

        jLabel56.setText("CODIGO TIENDA ACTUAL:");

        jLabel58.setText("FECHA PEDIDO:");

        jLabel59.setText("NIT CLIENTE:");

        jLabel60.setText("CANTIDAD ARTICULOS:");

        txt_tiendaDestinoPedido.setEditable(false);

        btn_guardarPedido.setText("GUARDAR");
        btn_guardarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarPedidoActionPerformed(evt);
            }
        });

        jLabel61.setText("CODIGO PEDIDO: ");

        jLabel63.setText("ANTICIPO:");

        jLabel65.setText("CODIGO PRODUCTO EXISTENCIA:");

        txt_mostrarTiendaPedido.setEditable(false);
        txt_mostrarTiendaPedido.setFont(new java.awt.Font("Dyuthi", 0, 18)); // NOI18N
        txt_mostrarTiendaPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mostrarTiendaPedido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cb_tiendaOrigenPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CODIGO TIENDA" }));

        cb_codigoProductoPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CODIGO PRODUCTO" }));

        btn_mostrarProductos.setText("...");
        btn_mostrarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarProductosActionPerformed(evt);
            }
        });

        btn_anticipoPedido.setText("25% Anticipo o Más");
        btn_anticipoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anticipoPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EMPLEADO4Layout = new javax.swing.GroupLayout(EMPLEADO4);
        EMPLEADO4.setLayout(EMPLEADO4Layout);
        EMPLEADO4Layout.setHorizontalGroup(
            EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADO4Layout.createSequentialGroup()
                .addGroup(EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EMPLEADO4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_mostrarTiendaPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_buscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EMPLEADO4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(EMPLEADO4Layout.createSequentialGroup()
                                .addGroup(EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel58)
                                    .addComponent(jLabel56)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel65))
                                .addGap(15, 15, 15)
                                .addGroup(EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(EMPLEADO4Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(cb_tiendaOrigenPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_mostrarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cb_codigoProductoPedido, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_tiendaDestinoPedido, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_fechaPedido, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nitClientePedido, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(47, 47, 47)
                                .addGroup(EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel60)
                                    .addComponent(jLabel63)
                                    .addComponent(jLabel61))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_codigoPedido)
                                    .addComponent(txt_anticipoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txt_cantArticulosPedido)))
                            .addGroup(EMPLEADO4Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_anticipoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)))
                        .addGap(37, 37, 37)
                        .addComponent(btn_guardarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)))
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADO4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        EMPLEADO4Layout.setVerticalGroup(
            EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EMPLEADO4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(txt_buscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mostrarTiendaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_codigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_tiendaOrigenPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_mostrarProductos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EMPLEADO4Layout.createSequentialGroup()
                        .addGroup(EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tiendaDestinoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADO4Layout.createSequentialGroup()
                        .addGroup(EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cantArticulosPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_guardarPedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EMPLEADO4Layout.createSequentialGroup()
                        .addComponent(txt_anticipoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_anticipoPedido))
                    .addGroup(EMPLEADO4Layout.createSequentialGroup()
                        .addGroup(EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_fechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nitClientePedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0)
                .addGroup(EMPLEADO4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_codigoProductoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EMPLEADO4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(EMPLEADO4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("PEDIDO", jPanel9);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jLabel51.setFont(new java.awt.Font("Dyuthi", 1, 14)); // NOI18N
        jLabel51.setText("Version Trabajadores");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jtTiempo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "TIENDA ORIGEN", "TIENDA DESTINO", "TIEMPO"
            }
        ));
        jtTiempo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTiempoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jtTiempo);
        if (jtTiempo.getColumnModel().getColumnCount() > 0) {
            jtTiempo.getColumnModel().getColumn(0).setHeaderValue("TIENDA ORIGEN");
            jtTiempo.getColumnModel().getColumn(1).setHeaderValue("TIENDA DESTINO");
            jtTiempo.getColumnModel().getColumn(2).setHeaderValue("TIEMPO");
        }

        jButton4.setText("CARGAR DATOS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txt_tiendaOrigenTiempo.setEnabled(false);

        jLabel53.setText("TIENDA DESTINO:");

        btn_guardarTiempo.setText("GUARDAR");
        btn_guardarTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarTiempoActionPerformed(evt);
            }
        });

        btn_modificarTiempo.setText("MODIFICAR");
        btn_modificarTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarTiempoActionPerformed(evt);
            }
        });

        jLabel57.setText("TIEMPO:");

        cb_Tiempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "GUARDAR", "MODIFICAR" }));

        btn_activarTiempo.setText("ACTIVAR");
        btn_activarTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_activarTiempoActionPerformed(evt);
            }
        });

        txt_idTiempo.setText("              ");
        txt_idTiempo.setEnabled(false);

        txt_mostrarTiendaTiempos.setEditable(false);
        txt_mostrarTiendaTiempos.setFont(new java.awt.Font("Dyuthi", 0, 18)); // NOI18N
        txt_mostrarTiendaTiempos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mostrarTiendaTiempos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cb_tiendaDestinoTiempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR CODIGO" }));

        javax.swing.GroupLayout EMPLEADO3Layout = new javax.swing.GroupLayout(EMPLEADO3);
        EMPLEADO3.setLayout(EMPLEADO3Layout);
        EMPLEADO3Layout.setHorizontalGroup(
            EMPLEADO3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADO3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(EMPLEADO3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EMPLEADO3Layout.createSequentialGroup()
                        .addComponent(txt_mostrarTiendaTiempos, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_buscarTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5)
                    .addGroup(EMPLEADO3Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addGroup(EMPLEADO3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_tiendaOrigenTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(EMPLEADO3Layout.createSequentialGroup()
                                .addGroup(EMPLEADO3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(EMPLEADO3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_tiempo)
                                    .addComponent(txt_idTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_tiendaDestinoTiempo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(121, 121, 121)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                        .addGroup(EMPLEADO3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_Tiempo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guardarTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_modificarTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_activarTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(43, 43, 43)))
                .addContainerGap())
        );
        EMPLEADO3Layout.setVerticalGroup(
            EMPLEADO3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EMPLEADO3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(EMPLEADO3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(txt_buscarTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mostrarTiendaTiempos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(EMPLEADO3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_Tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_idTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(EMPLEADO3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EMPLEADO3Layout.createSequentialGroup()
                        .addGroup(EMPLEADO3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_activarTiempo)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_tiendaDestinoTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(EMPLEADO3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_guardarTiempo)
                            .addComponent(txt_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificarTiempo))
                    .addGroup(EMPLEADO3Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(txt_tiendaOrigenTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42)
                        .addComponent(EMPLEADO3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(EMPLEADO3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("TIEMPOS DE ENVIO", jPanel10);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jtReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtReportesMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jtReportes);

        jButton9.setText("CARGAR DATOS");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        txt_mostrarReporte.setEditable(false);
        txt_mostrarReporte.setFont(new java.awt.Font("Dyuthi", 0, 18)); // NOI18N
        txt_mostrarReporte.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mostrarReporte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_pedidosLlegaranTienda.setText("LISTADO DE TODOS LOS PEDIDOS QUE LLEGARAN A LA TIENDA");
        btn_pedidosLlegaranTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pedidosLlegaranTiendaActionPerformed(evt);
            }
        });

        jButton8.setText("LISTADO DE PEDIDOS QUE DEBE VERIFICARSE SU INGRESO");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setText("LISTADO DE PEDIDOS QUE SALIERON DE LA TIENDA Y ESTAN EN TRANSITO");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("LISTADO DE TODAS LAS COMPRAS REALIZADAS POR UN CLIENTE");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("LISTADO DE TODOS LOS PEDIDOS EN CURSO DE UN CLIENTE");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EMPLEADO7Layout = new javax.swing.GroupLayout(EMPLEADO7);
        EMPLEADO7.setLayout(EMPLEADO7Layout);
        EMPLEADO7Layout.setHorizontalGroup(
            EMPLEADO7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EMPLEADO7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EMPLEADO7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADO7Layout.createSequentialGroup()
                        .addComponent(txt_mostrarReporte)
                        .addGap(18, 18, 18)
                        .addComponent(txt_buscarReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADO7Layout.createSequentialGroup()
                        .addComponent(jScrollPane9)
                        .addContainerGap())))
            .addGroup(EMPLEADO7Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(EMPLEADO7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_pedidosLlegaranTienda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(EMPLEADO7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        EMPLEADO7Layout.setVerticalGroup(
            EMPLEADO7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EMPLEADO7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(EMPLEADO7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(txt_buscarReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mostrarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(EMPLEADO7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EMPLEADO7Layout.createSequentialGroup()
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12))
                    .addGroup(EMPLEADO7Layout.createSequentialGroup()
                        .addComponent(btn_pedidosLlegaranTienda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jLabel80.setFont(new java.awt.Font("Dyuthi", 1, 14)); // NOI18N
        jLabel80.setText("Version Trabajadores");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EMPLEADO7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(EMPLEADO7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel80, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("REPORTES", jPanel13);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1195, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("OTRAS OPCIONES --->", jPanel11);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jLabel34.setFont(new java.awt.Font("Dyuthi", 1, 14)); // NOI18N
        jLabel34.setText("Version Trabajadores");

        jtTiendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "DIRECCION", "TELEFONO 1", "TELEFONO 2", "CORREO ELECTRONICO", "HORARIO"
            }
        ));
        jtTiendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTiendasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtTiendas);

        btn_cargarDatosTienda.setText("CARGAR DATOS");
        btn_cargarDatosTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargarDatosTiendaActionPerformed(evt);
            }
        });

        jLabel35.setText("NOMBRE: ");

        jLabel36.setText("TELEFONO 1: ");

        jLabel37.setText("TELEFONO 2: ");

        jLabel38.setText("CORREO ELECTRONICO: ");

        jLabel39.setText("DIRECCION: ");

        btn_guardarTienda.setText("GUARDAR");
        btn_guardarTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarTiendaActionPerformed(evt);
            }
        });

        btn_modificarTienda.setText("TIEMPO DE TRASLADO");
        btn_modificarTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarTiendaActionPerformed(evt);
            }
        });

        jLabel40.setText("CODIGO: ");

        jLabel41.setText("HORARIO: ");

        javax.swing.GroupLayout TIENDALayout = new javax.swing.GroupLayout(TIENDA);
        TIENDA.setLayout(TIENDALayout);
        TIENDALayout.setHorizontalGroup(
            TIENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TIENDALayout.createSequentialGroup()
                .addGroup(TIENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TIENDALayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(TIENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TIENDALayout.createSequentialGroup()
                                .addGroup(TIENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel35))
                                .addGap(104, 104, 104)
                                .addGroup(TIENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(TIENDALayout.createSequentialGroup()
                                        .addComponent(txt_telefono1Tienda, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel41))
                                    .addGroup(TIENDALayout.createSequentialGroup()
                                        .addComponent(txt_nombreTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(TIENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_horarioTienda)
                                            .addComponent(txt_codigoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txt_telefono2Tienda)
                                    .addComponent(txt_correoTienda)
                                    .addComponent(txt_direccionTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(72, 72, 72)
                        .addGroup(TIENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_modificarTienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guardarTienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31))
                    .addGroup(TIENDALayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(TIENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(TIENDALayout.createSequentialGroup()
                                .addComponent(txt_buscarTienda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_cargarDatosTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))))
                .addGap(17, 17, 17))
        );
        TIENDALayout.setVerticalGroup(
            TIENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TIENDALayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(TIENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cargarDatosTienda)
                    .addComponent(txt_buscarTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(TIENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombreTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_codigoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TIENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefono1Tienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_guardarTienda)
                    .addComponent(jLabel41)
                    .addComponent(txt_horarioTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TIENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefono2Tienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificarTienda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TIENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_correoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TIENDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_direccionTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TIENDA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(TIENDA, javax.swing.GroupLayout.PREFERRED_SIZE, 434, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("TIENDAS", jPanel6);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel25.setFont(new java.awt.Font("Dyuthi", 1, 14)); // NOI18N
        jLabel25.setText("Version Trabajadores");

        jtEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "TELEFONO", "DPI", "NIT", "CORREO ELECTRONICO", "DIRECCION"
            }
        ));
        jtEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtEmpleados);

        jButton1.setText("CARGAR DATOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel18.setText("NOMBRE: ");

        jLabel19.setText("TELEFONO: ");

        jLabel20.setText("NIT:");

        jLabel21.setText("CORREO ELECTRONICO: ");

        jLabel22.setText("DIRECCION: ");

        btn_guardarEmpleado.setText("GUARDAR");
        btn_guardarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarEmpleadoActionPerformed(evt);
            }
        });

        btn_modificarEmpleado.setText("MODIFICAR");
        btn_modificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarEmpleadoActionPerformed(evt);
            }
        });

        jLabel23.setText("CODIGO: ");

        jLabel24.setText("DPI: ");

        cb_Empleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "GUARDAR", "MODIFICAR" }));

        btn_activarEmpleado.setText("ACTIVAR");
        btn_activarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_activarEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EMPLEADOLayout = new javax.swing.GroupLayout(EMPLEADO);
        EMPLEADO.setLayout(EMPLEADOLayout);
        EMPLEADOLayout.setHorizontalGroup(
            EMPLEADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADOLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(EMPLEADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EMPLEADOLayout.createSequentialGroup()
                        .addComponent(txt_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(EMPLEADOLayout.createSequentialGroup()
                        .addGap(0, 122, Short.MAX_VALUE)
                        .addGroup(EMPLEADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EMPLEADOLayout.createSequentialGroup()
                                .addGroup(EMPLEADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18))
                                .addGap(104, 104, 104)
                                .addGroup(EMPLEADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(EMPLEADOLayout.createSequentialGroup()
                                        .addComponent(txt_telefonoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel24))
                                    .addGroup(EMPLEADOLayout.createSequentialGroup()
                                        .addComponent(txt_nombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(EMPLEADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_dpiEmpleado)
                                            .addComponent(txt_codigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txt_nitEmpleado)
                                    .addComponent(txt_correoEmpleado)
                                    .addComponent(txt_direccionEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel22)
                            .addComponent(jLabel21))
                        .addGap(68, 68, 68)
                        .addGroup(EMPLEADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_Empleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guardarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_modificarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_activarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)))
                .addGap(17, 17, 17))
        );
        EMPLEADOLayout.setVerticalGroup(
            EMPLEADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EMPLEADOLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(EMPLEADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(EMPLEADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_codigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EMPLEADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefonoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txt_dpiEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_activarEmpleado))
                .addGap(8, 8, 8)
                .addGroup(EMPLEADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EMPLEADOLayout.createSequentialGroup()
                        .addGroup(EMPLEADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nitEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EMPLEADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_correoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EMPLEADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_direccionEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(EMPLEADOLayout.createSequentialGroup()
                        .addComponent(btn_guardarEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificarEmpleado)
                        .addGap(4, 4, 4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EMPLEADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(EMPLEADO, javax.swing.GroupLayout.PREFERRED_SIZE, 434, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("EMPLEADOS", jPanel3);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jtCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NOMBRE", "TELEFONO", "NIT", "DPI", "CREDITO DE COMPRA", "CORREO ELECTRONICO", "DIRECCION"
            }
        ));
        jtCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtClienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtCliente);

        btn_cargarCliente.setText("CARGAR DATOS");
        btn_cargarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargarClienteActionPerformed(evt);
            }
        });

        jLabel26.setText("NOMBRE: ");

        jLabel27.setText("TELEFONO: ");

        jLabel28.setText("DIRECCION:");

        jLabel29.setText("CORREO ELECTRONICO: ");

        jLabel30.setText("CREDITO DE COMPRA: ");

        btn_guardarCliente.setText("GUARDAR");
        btn_guardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarClienteActionPerformed(evt);
            }
        });

        btn_modificarCliente.setText("MODIFICAR");
        btn_modificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarClienteActionPerformed(evt);
            }
        });

        jLabel31.setText("NIT:");

        jLabel32.setText("DPI: ");

        cb_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "GUARDAR", "MODIFICAR" }));

        btn_activarCliente.setText("ACTIVAR");
        btn_activarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_activarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EMPLEADO1Layout = new javax.swing.GroupLayout(EMPLEADO1);
        EMPLEADO1.setLayout(EMPLEADO1Layout);
        EMPLEADO1Layout.setHorizontalGroup(
            EMPLEADO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EMPLEADO1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(EMPLEADO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EMPLEADO1Layout.createSequentialGroup()
                        .addComponent(txt_buscarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cargarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1108, Short.MAX_VALUE)
                    .addGroup(EMPLEADO1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(EMPLEADO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EMPLEADO1Layout.createSequentialGroup()
                                .addGroup(EMPLEADO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel26))
                                .addGap(104, 104, 104)
                                .addGroup(EMPLEADO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(EMPLEADO1Layout.createSequentialGroup()
                                        .addComponent(txt_telefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel32))
                                    .addGroup(EMPLEADO1Layout.createSequentialGroup()
                                        .addComponent(txt_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(EMPLEADO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_dpiCliente)
                                            .addComponent(txt_nitCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txt_direccionCliente)
                                    .addComponent(txt_correoCliente)
                                    .addComponent(txt_creditoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel30)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(EMPLEADO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_guardarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_cliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_modificarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_activarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(128, 128, 128)))
                .addGap(17, 17, 17))
        );
        EMPLEADO1Layout.setVerticalGroup(
            EMPLEADO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EMPLEADO1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(EMPLEADO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cargarCliente)
                    .addComponent(txt_buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(EMPLEADO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_nitCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EMPLEADO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(txt_dpiCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_activarCliente))
                .addGap(8, 8, 8)
                .addGroup(EMPLEADO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EMPLEADO1Layout.createSequentialGroup()
                        .addGroup(EMPLEADO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_direccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EMPLEADO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_correoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EMPLEADO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_creditoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(EMPLEADO1Layout.createSequentialGroup()
                        .addComponent(btn_guardarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificarCliente)
                        .addGap(4, 4, 4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jLabel33.setFont(new java.awt.Font("Dyuthi", 1, 14)); // NOI18N
        jLabel33.setText("Version Trabajadores");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EMPLEADO1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(EMPLEADO1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("CLIENTES", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_modificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarEmpleadoActionPerformed
        if(txt_codigoEmpleado.getText().equals("")){
            txt_codigoEmpleado.setText("0");
        }
        e.modificarEmpleado(txt_codigoEmpleado, jtEmpleados, txt_nombreEmpleado, txt_telefonoEmpleado, txt_nitEmpleado, txt_correoEmpleado, txt_direccionEmpleado);
        limpiarCasillasEmpleado();
        ocultarTodasCasillasGuardarEmpleado();
        ocultarTodasCasillasModificarEmpleado();
    }//GEN-LAST:event_btn_modificarEmpleadoActionPerformed

    private void btn_guardarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarEmpleadoActionPerformed
        e.guardarNuevosEmpleados(txt_codigoEmpleado, txt_dpiEmpleado, txt_nombreEmpleado, txt_telefonoEmpleado, txt_nitEmpleado, txt_correoEmpleado, txt_direccionEmpleado);
        //limpiarCasillasEmpleado();
        ocultarTodasCasillasModificarEmpleado();
        ocultarTodasCasillasGuardarEmpleado();
    }//GEN-LAST:event_btn_guardarEmpleadoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        e.mostrarDatosTabla(jtEmpleados, txt_buscar);
        txt_buscar.setText("");
        limpiarCasillasEmpleado();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEmpleadosMouseClicked
        e.pasarDatosComponentes(txt_dpiEmpleado, txt_codigoEmpleado, jtEmpleados, txt_nombreEmpleado, txt_telefonoEmpleado, txt_nitEmpleado, txt_correoEmpleado, txt_direccionEmpleado);
    }//GEN-LAST:event_jtEmpleadosMouseClicked

    private void btn_modificarTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarTiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificarTiendaActionPerformed

    private void btn_guardarTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarTiendaActionPerformed
        t.guardarNuevasTiendas(txt_nombreTienda, txt_telefono1Tienda, txt_telefono2Tienda, txt_codigoTienda, txt_horarioTienda, txt_correoTienda, txt_direccionTienda);
        cargarTiendasBD();
        tiempoTras.cargarTiendasBD(cb_tiendaDestinoTiempo, txt_tiendaOrigenTiempo);
        pedido.cargarTiendasBD(cb_tiendaOrigenPedido, txt_tiendaDestinoPedido);
    }//GEN-LAST:event_btn_guardarTiendaActionPerformed

    private void btn_cargarDatosTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargarDatosTiendaActionPerformed
        t.mostrarDatosTabla(jtTiendas, txt_buscarTienda);
        txt_buscarTienda.setText("");
    }//GEN-LAST:event_btn_cargarDatosTiendaActionPerformed

    private void jtTiendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTiendasMouseClicked
        t.pasarDatosComponentes(jtTiendas, txt_nombreTienda, txt_telefono1Tienda, txt_telefono2Tienda, txt_codigoTienda, txt_horarioTienda, txt_correoTienda, txt_direccionTienda);
    }//GEN-LAST:event_jtTiendasMouseClicked

    private void jtClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClienteMouseClicked
        c.pasarDatosComponentes(txt_dpiCliente, jtCliente, txt_nombreCliente, txt_telefonoCliente, txt_nitCliente, txt_correoCliente, txt_direccionCliente, txt_creditoCliente);
    }//GEN-LAST:event_jtClienteMouseClicked

    private void btn_cargarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargarClienteActionPerformed
        c.mostrarDatosTabla(jtCliente, txt_buscarCliente);
        limpiarCasillasCliente();
    }//GEN-LAST:event_btn_cargarClienteActionPerformed

    private void btn_guardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarClienteActionPerformed
        c.guardarNuevosCliente(txt_dpiCliente, txt_nombreCliente, txt_telefonoCliente, txt_nitCliente, txt_correoCliente, txt_direccionCliente, txt_creditoCliente);
        //limpiarCasillasCliente();
        ocultarTodasCasillasGuardarCliente();
        ocultarTodasCasillasModificarCliente();
    }//GEN-LAST:event_btn_guardarClienteActionPerformed

    private void btn_modificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarClienteActionPerformed
        c.modificarCliente(txt_dpiCliente, txt_nombreCliente, txt_telefonoCliente, txt_nitCliente, txt_correoCliente, txt_direccionCliente, txt_creditoCliente);
        limpiarCasillasCliente();
        ocultarTodasCasillasGuardarCliente();
        ocultarTodasCasillasModificarCliente();
    }//GEN-LAST:event_btn_modificarClienteActionPerformed

    private void btn_activarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_activarClienteActionPerformed
        String cliente = String.valueOf(cb_cliente.getSelectedItem());
        if(cliente.equals("GUARDAR")){
            ocultarTodasCasillasModificarCliente();
            mostrarCasillasGuardarCliente();
            
        }else if(cliente.equals("MODIFICAR")){
            ocultarTodasCasillasGuardarCliente();
            mostrarCasillasModificarCliente();
        }
    }//GEN-LAST:event_btn_activarClienteActionPerformed

    private void btn_activarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_activarEmpleadoActionPerformed
        String empleado = String.valueOf(cb_Empleado.getSelectedItem());
        if(empleado.equals("GUARDAR")){
            ocultarTodasCasillasModificarEmpleado();
            mostrarTodasCasillasGuardarEmpleado();
        }else if(empleado.equals("MODIFICAR")){
            ocultarTodasCasillasGuardarEmpleado();
            mostrarTodasCasillasModificarEmpleado();
        }
    }//GEN-LAST:event_btn_activarEmpleadoActionPerformed

    private void jtProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductoMouseClicked
        p.pasarDatosComponentes(txt_codigoProducto, txt_nombreProducto, jtProducto, txt_fabricanteProducto,
        txt_cantDisponibleProducto, txt_precioProducto, txt_descripcionProducto, txt_garantiaProducto, 
        cb_tiendaSeleccion, txt_tiendaCodigo);
    }//GEN-LAST:event_jtProductoMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        p.mostrarDatosTabla(jtProducto, txt_buscarProducto, cb_tiendaSeleccion);
        limpiarComponentesProducto();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_guardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarProductoActionPerformed
        //JOptionPane.showMessageDialog(null, jtProducto.getRowCount());
            t.obtenerCodigoTienda(cb_tiendaSeleccion, txt_tiendaCodigo);
            p.guardarNuevosProducto(txt_codigoProducto, txt_nombreProducto, txt_fabricanteProducto, txt_cantDisponibleProducto, txt_precioProducto, txt_descripcionProducto, txt_garantiaProducto, cb_tiendaSeleccion, txt_tiendaCodigo);
            v.mostrarProductoTienda(cb_tiendaSeleccion, cb_codigoProductoVenta);
            ocultarComponentesProducto();
            txt_tiendaCodigo.setText("");
    }//GEN-LAST:event_btn_guardarProductoActionPerformed

    private void btn_modificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarProductoActionPerformed
        if(txt_nuevoProducto.getText().equals("")){
            txt_nuevoProducto.setText("0");
        }
        if(txt_cantDisponibleProducto.getText().equals("")){
            txt_cantDisponibleProducto.setText("0");
        }
        p.modificarProducto(txt_cantDisponibleProducto, txt_codigoProducto, txt_precioProducto, cb_tiendaSeleccion, txt_nuevoProducto, txt_descripcionProducto, txt_garantiaProducto);
        //txt_nuevoProducto.setText("");
        limpiarComponentesProducto();
        ocultarComponentesProducto();
    }//GEN-LAST:event_btn_modificarProductoActionPerformed

    private void btn_activarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_activarProductoActionPerformed
        String producto = String.valueOf(cb_Producto.getSelectedItem());
        if(producto.equals("GUARDAR")){
            mostrarComponentesGuardarProducto();
            //limpiarComponentesProducto();
            //ocultarComponentesProducto();
            
        }else if(producto.equals("MODIFICAR")){
            mostrarComponentesModificarProducto();
        }
    }//GEN-LAST:event_btn_activarProductoActionPerformed

    private void txt_ingresarTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ingresarTiendaActionPerformed
        txt_seleccionarTienda.setText("LOS DATOS DE LA TIENDA **" + cb_tiendaSeleccion.getSelectedItem() + "** HAN SIDO CARGADOS");
        txt_mostrarTiendaProducto.setText("TIENDA " + cb_tiendaSeleccion.getSelectedItem() + " PRODUCTOS");
        txt_mostrarTiendaPedido.setText("TIENDA " + cb_tiendaSeleccion.getSelectedItem() + " PEDIDOS");
        txt_mostrarTiendaTiempos.setText("TIENDA " + cb_tiendaSeleccion.getSelectedItem() + " TIEMPOS");
        txt_mostrarTiendaVenta.setText("TIENDA " + cb_tiendaSeleccion.getSelectedItem() + " VENTAS");
        p.mostrarDatosTabla(jtProducto, txt_buscarProducto, cb_tiendaSeleccion);
        tiempoTras.mostrarDatosTabla(jtTiempo, txt_buscarTiempo, cb_tiendaSeleccion);
        pedido.mostrarDatosTabla(jtPedido, txt_buscarPedido, cb_tiendaSeleccion);
        t.mostrarDatosTabla(jtTiendas, txt_buscarTienda);
        e.mostrarDatosTabla(jtEmpleados, txt_buscar);
        c.mostrarDatosTabla(jtCliente, txt_buscarCliente);
        t.obtenerCodigoTienda(cb_tiendaSeleccion, txt_tiendaOrigenTiempo);
        tiempoTras.cargarTiendasBD(cb_tiendaDestinoTiempo, txt_tiendaOrigenTiempo);
        pedido.obtenerCodigoTienda(cb_tiendaSeleccion, txt_tiendaDestinoPedido);
        pedido.cargarTiendasBD(cb_tiendaOrigenPedido, txt_tiendaDestinoPedido);
        v.mostrarProductoTienda(cb_tiendaSeleccion, cb_codigoProductoVenta);
        v.mostrarDatosTabla(jtVenta, txt_buscarVenta, cb_tiendaSeleccion);
        v.obtenerCodigoTienda(cb_tiendaSeleccion, txt_codigoTiendaVenta);
        //txt_codigoTiendaVenta.setText(String.valueOf(cb_tiendaSeleccion.getSelectedItem()));
        limpiarTabla(jtReportes);
    }//GEN-LAST:event_txt_ingresarTiendaActionPerformed
    public void limpiarTabla(JTable nombreTabla){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setRowCount(0);
        nombreTabla.setModel(modelo);
    }
    private void jtTiempoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTiempoMouseClicked
        tiempoTras.pasarDatosComponentes(jtTiempo, cb_tiendaSeleccion, txt_tiendaOrigenTiempo, cb_tiendaDestinoTiempo, txt_tiempo);
    }//GEN-LAST:event_jtTiempoMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        tiempoTras.mostrarDatosTabla(jtTiempo, txt_buscarTiempo, cb_tiendaSeleccion);
        limpiarComponentesTiempo();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_guardarTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarTiempoActionPerformed
            tiempoTras.guardarNuevosTiempo(jtTiempo, cb_tiendaSeleccion, txt_tiendaOrigenTiempo, cb_tiendaDestinoTiempo, txt_tiempo);
            ocultarComponentesTiempo();
    }//GEN-LAST:event_btn_guardarTiempoActionPerformed

    private void btn_modificarTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarTiempoActionPerformed
        tiempoTras.modificarTiempo(cb_tiendaSeleccion, cb_tiendaDestinoTiempo, txt_tiempo, txt_tiendaOrigenTiempo);
        ocultarComponentesTiempo();
    }//GEN-LAST:event_btn_modificarTiempoActionPerformed

    private void btn_activarTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_activarTiempoActionPerformed
        String tiempo = String.valueOf(cb_Tiempo.getSelectedItem());
        if(tiempo.equals("GUARDAR")){
            mostrarComponentesGuardarTiempo();

            
        }else if(tiempo.equals("MODIFICAR")){
            mostrarComponentesModificarTiempo();
        }
    }//GEN-LAST:event_btn_activarTiempoActionPerformed

    private void jtPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPedidoMouseClicked
    }//GEN-LAST:event_jtPedidoMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        pedido.mostrarDatosTabla(jtPedido, txt_buscarPedido, cb_tiendaSeleccion);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_guardarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarPedidoActionPerformed
        pedido.guardarNuevosPedido(jtPedido, cb_tiendaOrigenPedido, txt_fechaPedido, txt_nitClientePedido, cb_codigoProductoPedido, txt_codigoPedido, txt_cantArticulosPedido, txt_anticipoPedido, cb_tiendaSeleccion, txt_tiendaDestinoPedido);
        btn_anticipoPedido.setEnabled(true);
        btn_guardarPedido.setEnabled(false);
    }//GEN-LAST:event_btn_guardarPedidoActionPerformed

    private void btn_mostrarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarProductosActionPerformed
        pedido.obtenerProductoTienda(cb_tiendaOrigenPedido, cb_codigoProductoPedido);
        tiempoTras.saberTiempoEnvioDias(cb_tiendaOrigenPedido, txt_tiendaDestinoPedido);
    }//GEN-LAST:event_btn_mostrarProductosActionPerformed

    private void btn_anticipoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anticipoPedidoActionPerformed

        String comboBoxCodigoProductoPedido = String.valueOf(cb_codigoProductoPedido.getSelectedItem());
        if(comboBoxCodigoProductoPedido.equals("") || txt_fechaPedido.getText().equals("") || txt_nitClientePedido.getText().equals("")
            || cb_codigoProductoPedido.getSelectedItem().equals("") || txt_codigoPedido.getText().equals("") 
            || txt_cantArticulosPedido.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LOS COMPONENTES NO PUEDEN ESTAR VACIOS");
        }else{
            pedido.porcentajeAnticipo(txt_anticipoPedido, cb_tiendaOrigenPedido, cb_codigoProductoPedido, txt_cantArticulosPedido);
            pedido.usoCreditoCliente(txt_nitClientePedido);
            btn_guardarPedido.setEnabled(true);
            btn_anticipoPedido.setEnabled(false);
        }
    }//GEN-LAST:event_btn_anticipoPedidoActionPerformed

    private void jtVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtVentaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtVentaMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        v.mostrarDatosTabla(jtVenta, txt_buscarVenta, cb_tiendaSeleccion);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btn_registrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarVentaActionPerformed
        v.registrarVenta(txt_codigoTiendaVenta, txt_fechaVenta, txt_nitClienteVenta, cb_codigoProductoVenta, txt_cantArticulosVenta, txt_creditoClieteVenta, cb_tiendaSeleccion);
    }//GEN-LAST:event_btn_registrarVentaActionPerformed

    private void btn_modificarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificarVentaActionPerformed

    private void btn_activarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_activarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_activarVentaActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String comboBoxCodigoProductoPedido = String.valueOf(cb_codigoProductoVenta.getSelectedItem());
        try {
            if(comboBoxCodigoProductoPedido.equals("") || txt_fechaVenta.getText().equals("") || txt_nitClienteVenta.getText().equals("")
                || cb_codigoProductoVenta.getSelectedItem().equals("") || txt_cantArticulosVenta.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LOS COMPONENTES NO PUEDEN ESTAR VACIOS");
        }else{
            v.previstaTotalPagarVentas(txt_totalPagarVenta, cb_tiendaSeleccion, cb_codigoProductoVenta, txt_cantArticulosVenta);
            v.usoCreditoCliente(txt_nitClienteVenta);
        } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "INGRESASTE EN ALGUN COMPONENTE CARACTERES NO VALIDOS");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jtReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtReportesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtReportesMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btn_pedidosLlegaranTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pedidosLlegaranTiendaActionPerformed
        pedido.mostrarDatosTabla(jtReportes, txt_buscarReportes, cb_tiendaSeleccion);
    }//GEN-LAST:event_btn_pedidosLlegaranTiendaActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        pedido.mostrarPedidoVerificarIngresoTabla(jtReportes, cb_tiendaSeleccion);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        pedido.mostrarPedidoQueSalieronDeLaTiendaTabla(jtReportes, txt_tiendaDestinoPedido);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        v.mostrarListadoComprasClienteTabla(jtReportes, txt_buscarReportes);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        c.ListadoPedidosEnCursoCliente(jtReportes, txt_buscarReportes);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void ocultarComponentesTiempo(){
        txt_tiempo.setEditable(false);
        cb_tiendaDestinoTiempo.setEnabled(false);
        txt_tiendaOrigenTiempo.setEditable(false);
        btn_guardarTiempo.setEnabled(false);
        btn_modificarTiempo.setEnabled(false);
    }
    
    private void limpiarComponentesTiempo(){
        txt_tiempo.setText("");
        txt_tiendaOrigenTiempo.setText("");
    }
    private void mostrarComponentesGuardarTiempo(){
        txt_tiempo.setEditable(true);
        cb_tiendaDestinoTiempo.setEnabled(true);
        txt_tiendaOrigenTiempo.setEditable(true);
        btn_guardarTiempo.setEnabled(true);
    }
    private void mostrarComponentesModificarTiempo(){
        txt_tiempo.setEditable(true);
        btn_modificarTiempo.setEnabled(true);
    }
    private void mostrarComponentesGuardarProducto(){
        txt_nombreProducto.setEditable(true);
        txt_cantDisponibleProducto.setEditable(true);
        txt_codigoProducto.setEditable(true);
        txt_descripcionProducto.setEditable(true);
        txt_fabricanteProducto.setEditable(true);
        txt_garantiaProducto.setEditable(true);
        txt_precioProducto.setEditable(true);
        btn_guardarProducto.setEnabled(true);
    }
    private void limpiarComponentesProducto(){
        txt_cantDisponibleProducto.setText("");
        txt_codigoProducto.setText("");
        txt_descripcionProducto.setText("");
        txt_fabricanteProducto.setText("");
        txt_garantiaProducto.setText("");
        txt_nombreProducto.setText("");
        txt_precioProducto.setText("");
        txt_nuevoProducto.setText("");
    }
    private void mostrarComponentesModificarProducto(){
        txt_precioProducto.setEditable(true);
        txt_garantiaProducto.setEditable(true);
        txt_nuevoProducto.setEditable(true);
        txt_descripcionProducto.setEditable(true);
        btn_modificarProducto.setEnabled(true);
    }
    private void ocultarComponentesProducto(){
        txt_cantDisponibleProducto.setEditable(false);
        txt_codigoProducto.setEditable(false);
        txt_descripcionProducto.setEditable(false);
        txt_fabricanteProducto.setEditable(false);
        txt_garantiaProducto.setEditable(false);
        txt_nombreProducto.setEditable(false);
        txt_nuevoProducto.setEditable(false);
        txt_precioProducto.setEditable(false);
        btn_guardarProducto.setEnabled(false);
        btn_modificarProducto.setEnabled(false);
    }
    private void limpiarCasillasEmpleado(){
        txt_codigoEmpleado.setText("");
        txt_nombreEmpleado.setText("");
        txt_nitEmpleado.setText("");
        txt_dpiEmpleado.setText("");
        txt_telefonoEmpleado.setText("");
        txt_correoEmpleado.setText("");
        txt_direccionEmpleado.setText("");
        
    }
    private void ocultarTodasCasillasGuardarEmpleado(){
        txt_codigoEmpleado.setEditable(false);
        txt_dpiEmpleado.setEditable(false);
        txt_nombreEmpleado.setEditable(false);
        txt_telefonoEmpleado.setEditable(false);
        txt_correoEmpleado.setEditable(false);
        txt_direccionEmpleado.setEditable(false);
        txt_nitEmpleado.setEditable(false);
        btn_guardarEmpleado.setEnabled(false);
    }
    private void ocultarTodasCasillasModificarEmpleado(){
        txt_nitEmpleado.setEditable(false);
        txt_dpiEmpleado.setEditable(false);
        txt_nombreEmpleado.setEditable(false);
        txt_telefonoEmpleado.setEditable(false);
        txt_correoEmpleado.setEditable(false);
        txt_direccionEmpleado.setEditable(false);
        btn_modificarEmpleado.setEnabled(false);
    }
    private void mostrarTodasCasillasGuardarEmpleado(){
        txt_codigoEmpleado.setEditable(true);
        txt_dpiEmpleado.setEditable(true);
        txt_nombreEmpleado.setEditable(true);
        txt_telefonoEmpleado.setEditable(true);
        txt_correoEmpleado.setEditable(true);
        txt_direccionEmpleado.setEditable(true);
        txt_nitEmpleado.setEditable(true);
        btn_guardarEmpleado.setEnabled(true);
    }
    private void mostrarTodasCasillasModificarEmpleado(){
        txt_nitEmpleado.setEditable(true);
        txt_dpiEmpleado.setEditable(true);
        txt_nombreEmpleado.setEditable(true);
        txt_telefonoEmpleado.setEditable(true);
        txt_correoEmpleado.setEditable(true);
        txt_direccionEmpleado.setEditable(true);
        btn_modificarEmpleado.setEnabled(true);
    }
    private void limpiarCasillasCliente(){
        txt_correoCliente.setText("");
        txt_nombreCliente.setText("");
        txt_dpiCliente.setText("");
        txt_nitCliente.setText("");
        txt_creditoCliente.setText("");
        txt_direccionCliente.setText("");
        txt_telefonoCliente.setText("");
    }
    private void ocultarTodasCasillasGuardarCliente(){
        txt_correoCliente.setEditable(false);
        txt_nombreCliente.setEditable(false);
        txt_dpiCliente.setEditable(false);
        txt_nitCliente.setEditable(false);
        txt_creditoCliente.setEditable(false);
        txt_direccionCliente.setEditable(false);
        txt_telefonoCliente.setEditable(false);
        btn_guardarCliente.setEnabled(false);
    }
    private void ocultarTodasCasillasModificarCliente(){
        txt_correoCliente.setEditable(false);
        txt_nombreCliente.setEditable(false);
        txt_dpiCliente.setEditable(false);
        txt_creditoCliente.setEditable(false);
        txt_direccionCliente.setEditable(false);
        txt_telefonoCliente.setEditable(false);
        btn_modificarCliente.setEnabled(false);
    }
    private void  mostrarCasillasGuardarCliente(){
        txt_correoCliente.setEditable(true);
        txt_nombreCliente.setEditable(true);
        txt_dpiCliente.setEditable(true);
        txt_nitCliente.setEditable(true);
        txt_creditoCliente.setEditable(true);
        txt_direccionCliente.setEditable(true);
        txt_telefonoCliente.setEditable(true);
        btn_guardarCliente.setEnabled(true);
    }
    
    private void mostrarCasillasModificarCliente(){
        txt_correoCliente.setEditable(true);
        txt_nombreCliente.setEditable(true);
        txt_dpiCliente.setEditable(true);
        txt_creditoCliente.setEditable(true);
        txt_direccionCliente.setEditable(true);
        txt_telefonoCliente.setEditable(true);
        btn_modificarCliente.setEnabled(true);
    }
//        private void validarCodigosTiendas(){
//        Conexion con = new Conexion();
//        Connection acceso = con.Conectar();
//        String query = "SELECT codigo FROM TIENDA";
//        try {
//            ps = acceso.prepareStatement(query);
//            rs = ps.executeQuery();
//            while(rs.next()){
//                if(rs.getString(1).equals(txt_tiendaDestinoTiempo.getText())){
//                    
//                }
//                //cb_productoTienda.addItem(rs.getString(1));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    //Guarda las tablas de productos de cada tienda en el comboBox para seleccionar a conveniencia
//    public void cargarTablasBD(){
//        Conexion con = new Conexion();
//        Connection acceso = con.Conectar();
//        String query = "SHOW TABLES";
//        try {
//            ps = acceso.prepareStatement(query);
//            rs = ps.executeQuery();
//            cb_productoTienda.removeAllItems();
//            while(rs.next()){
//                if(rs.getString(1).matches("PRODUCTO.*")){
//                    cb_productoTienda.addItem(rs.getString(1));
//                }
//                //cb_productoTienda.addItem(rs.getString(1));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void cargarTiendasBD(){
        Conexion con = new Conexion();
        Connection acceso = con.Conectar();
        String query = "SELECT nombre FROM TIENDA";
        try {
            ps = acceso.prepareStatement(query);
            rs = ps.executeQuery();
            cb_tiendaSeleccion.removeAllItems();
            while(rs.next()){
                    cb_tiendaSeleccion.addItem(rs.getString(1));
                //cb_productoTienda.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(IngresarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EMPLEADO;
    private javax.swing.JPanel EMPLEADO1;
    private javax.swing.JPanel EMPLEADO2;
    private javax.swing.JPanel EMPLEADO3;
    private javax.swing.JPanel EMPLEADO4;
    private javax.swing.JPanel EMPLEADO5;
    private javax.swing.JPanel EMPLEADO7;
    private javax.swing.JPanel TIENDA;
    private javax.swing.JButton btn_activarCliente;
    private javax.swing.JButton btn_activarEmpleado;
    private javax.swing.JButton btn_activarProducto;
    private javax.swing.JButton btn_activarTiempo;
    private javax.swing.JButton btn_activarVenta;
    private javax.swing.JButton btn_anticipoPedido;
    private javax.swing.JButton btn_cargarCliente;
    private javax.swing.JButton btn_cargarDatosTienda;
    private javax.swing.JButton btn_guardarCliente;
    private javax.swing.JButton btn_guardarEmpleado;
    private javax.swing.JButton btn_guardarPedido;
    private javax.swing.JButton btn_guardarProducto;
    private javax.swing.JButton btn_guardarTiempo;
    private javax.swing.JButton btn_guardarTienda;
    private javax.swing.JButton btn_modificarCliente;
    private javax.swing.JButton btn_modificarEmpleado;
    private javax.swing.JButton btn_modificarProducto;
    private javax.swing.JButton btn_modificarTiempo;
    private javax.swing.JButton btn_modificarTienda;
    private javax.swing.JButton btn_modificarVenta;
    private javax.swing.JButton btn_mostrarProductos;
    private javax.swing.JButton btn_pedidosLlegaranTienda;
    private javax.swing.JButton btn_registrarVenta;
    private javax.swing.JComboBox<String> cb_Empleado;
    private javax.swing.JComboBox<String> cb_Producto;
    private javax.swing.JComboBox<String> cb_Tiempo;
    private javax.swing.JComboBox<String> cb_Venta;
    private javax.swing.JComboBox<String> cb_cliente;
    private javax.swing.JComboBox<String> cb_codigoProductoPedido;
    private javax.swing.JComboBox<String> cb_codigoProductoVenta;
    private javax.swing.JComboBox<String> cb_tiendaDestinoTiempo;
    private javax.swing.JComboBox<String> cb_tiendaOrigenPedido;
    private javax.swing.JComboBox<String> cb_tiendaSeleccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jtCliente;
    private javax.swing.JTable jtEmpleados;
    private javax.swing.JTable jtPedido;
    private javax.swing.JTable jtProducto;
    private javax.swing.JTable jtReportes;
    private javax.swing.JTable jtTiempo;
    private javax.swing.JTable jtTiendas;
    private javax.swing.JTable jtVenta;
    private javax.swing.JTextField txt_anticipoPedido;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_buscarCliente;
    private javax.swing.JTextField txt_buscarPedido;
    private javax.swing.JTextField txt_buscarProducto;
    private javax.swing.JTextField txt_buscarReportes;
    private javax.swing.JTextField txt_buscarTiempo;
    private javax.swing.JTextField txt_buscarTienda;
    private javax.swing.JTextField txt_buscarVenta;
    private javax.swing.JTextField txt_cantArticulosPedido;
    private javax.swing.JTextField txt_cantArticulosVenta;
    private javax.swing.JTextField txt_cantDisponibleProducto;
    private javax.swing.JTextField txt_codigoEmpleado;
    private javax.swing.JTextField txt_codigoPedido;
    private javax.swing.JTextField txt_codigoProducto;
    private javax.swing.JTextField txt_codigoTienda;
    private javax.swing.JTextField txt_codigoTiendaVenta;
    private javax.swing.JTextField txt_correoCliente;
    private javax.swing.JTextField txt_correoEmpleado;
    private javax.swing.JTextField txt_correoTienda;
    private javax.swing.JTextField txt_creditoCliente;
    private javax.swing.JTextField txt_creditoClieteVenta;
    private javax.swing.JTextField txt_descripcionProducto;
    private javax.swing.JTextField txt_direccionCliente;
    private javax.swing.JTextField txt_direccionEmpleado;
    private javax.swing.JTextField txt_direccionTienda;
    private javax.swing.JTextField txt_dpiCliente;
    private javax.swing.JTextField txt_dpiEmpleado;
    private javax.swing.JTextField txt_fabricanteProducto;
    private javax.swing.JTextField txt_fechaPedido;
    private javax.swing.JTextField txt_fechaVenta;
    private javax.swing.JTextField txt_garantiaProducto;
    private javax.swing.JTextField txt_horarioTienda;
    private javax.swing.JTextField txt_idTiempo;
    private javax.swing.JButton txt_ingresarTienda;
    private javax.swing.JTextField txt_mostrarReporte;
    private javax.swing.JTextField txt_mostrarTiendaPedido;
    private javax.swing.JTextField txt_mostrarTiendaProducto;
    private javax.swing.JTextField txt_mostrarTiendaTiempos;
    private javax.swing.JTextField txt_mostrarTiendaVenta;
    private javax.swing.JTextField txt_nitCliente;
    private javax.swing.JTextField txt_nitClientePedido;
    private javax.swing.JTextField txt_nitClienteVenta;
    private javax.swing.JTextField txt_nitEmpleado;
    private javax.swing.JTextField txt_nombreCliente;
    private javax.swing.JTextField txt_nombreEmpleado;
    private javax.swing.JTextField txt_nombreProducto;
    private javax.swing.JTextField txt_nombreTienda;
    private javax.swing.JTextField txt_nuevoProducto;
    private javax.swing.JTextField txt_precioProducto;
    private javax.swing.JTextField txt_seleccionarTienda;
    private javax.swing.JTextField txt_telefono1Tienda;
    private javax.swing.JTextField txt_telefono2Tienda;
    private javax.swing.JTextField txt_telefonoCliente;
    private javax.swing.JTextField txt_telefonoEmpleado;
    private javax.swing.JTextField txt_tiempo;
    private javax.swing.JTextField txt_tiendaCodigo;
    private javax.swing.JTextField txt_tiendaDestinoPedido;
    private javax.swing.JTextField txt_tiendaOrigenTiempo;
    private javax.swing.JTextField txt_totalPagarVenta;
    // End of variables declaration//GEN-END:variables
}
