package com.mycompany.intelaf_project1;

import com.mycompany.intelaf_project1.UI.trabajador.IngresarDatos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joshua
 */
public class Pedido {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    Producto producto = new Producto();
    DecimalFormat cortarDecimal = new DecimalFormat("#.00");
    double porcentajeAnticipo = 0;
    String tiempoEnvio = "";
    double cantidadTotalPago = 0;
    int restaProductoExistenteyPedido = 0;
    double creditoIngresado = 0;
    
    
    public void mostrarDatosTabla(JTable pedidoTable, JTextField txt_buscarPedido, JComboBox cb_tiendaSeleccionada){
        String pedido = "PEDIDO" + String.valueOf(cb_tiendaSeleccionada.getSelectedItem());
        //String productoTienda = String.valueOf(cb_productoTienda.getSelectedItem());
        String buscar = txt_buscarPedido.getText();
        String where = "";
         //Me permite buscar en la lista por medio del codigo del empleado al empleado
        if(!"".equals(buscar)){
            where = " WHERE codigo = '" + buscar + "' OR cliente_nit = '" + buscar + "'";
        }
        //El try me permite capturar el error que me sale por conexion
        //Tambien nos permite hacer la conexion con la DB para  mostrar los datos de la tabla empleados de
        //la DB en la tabla empleadosTable que tenemos en nuestra interfaz grafica
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            pedidoTable.setModel(modelo);
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            
            String sql = "SELECT * FROM " + pedido + where + " ORDER BY codigo ASC"; // aqui concatenar where
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            modelo.addColumn("No. PEDIDO");
            modelo.addColumn("CODIGO PEDIDO");
            modelo.addColumn("CODIGO TIENDA ORIGEN");
            modelo.addColumn("CODIGO TIENDA ACTUAL");
            modelo.addColumn("FECHA DE PEDIDO");
            modelo.addColumn("NIT CLIENTE");
            modelo.addColumn("CODIGO PRODUCTO");
            modelo.addColumn("CANTIDAD DE ARTICULOS");
            modelo.addColumn("TOTAL A PAGAR");
            modelo.addColumn("ANTICIPO");
            modelo.addColumn("FECHA ENTREGA");
            //Capturamos en las columnas que contiene nuestra tabla de interfaz los datos de nuestra DB
            while(rs.next()){
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
//                    if(i == 10){
//                        filas[i] = new JButton("Validar Entrega");
//                    }
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);//agregamos las filas al modelo que en este caso es la tabla Interfaz
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
                
        }
    }
    public void pasarDatosComponentes(JTable pedidoTable, JComboBox cb_tiendaOrigenPedido, JTextField txt_fechaPedido, JTextField txt_nitClientePedido,
            JComboBox cb_codigoProductoPedido, JTextField txt_codigoPedido, JTextField txt_cantArticulosPedido,
            JTextField txt_totalPagarPedido, JTextField txt_anticipoPedido, JComboBox cb_tiendaSeleccion){
        String pedidoTienda = "PEDIDO" + String.valueOf(cb_tiendaSeleccion.getSelectedItem());
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            int Fila = pedidoTable.getSelectedRow();//permite pasar los datos de cada trabajador
            System.out.println(Fila);
            String codigo = pedidoTable.getValueAt(Fila, 0).toString();
            String sql = "SELECT * FROM " + pedidoTienda + " WHERE id = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            
            while(rs.next()){
                txt_codigoPedido.setText(rs.getString("codigo"));
                cb_tiendaOrigenPedido.setSelectedItem(rs.getString("tienda_origen"));
                txt_fechaPedido.setText(rs.getString("fecha"));
                txt_nitClientePedido.setText(rs.getString("cliente_nit"));
                cb_codigoProductoPedido.setSelectedItem(rs.getString("producto_codigo"));
                txt_cantArticulosPedido.setText(rs.getString("cantidad_articulos"));
                txt_totalPagarPedido.setText(rs.getString("total_pagar"));
                txt_anticipoPedido.setText(rs.getString("anticipo"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void guardarNuevosPedido(JTable pedidoTable, JComboBox cb_tiendaOrigenPedido, JTextField txt_fechaPedido, JTextField txt_nitClientePedido,
        JComboBox cb_codigoProductoPedido, JTextField txt_codigoPedido, JTextField txt_cantArticulosPedido,
        JTextField txt_anticipoPedido, JComboBox cb_tiendaSeleccion, JTextField txt_tiendaDestinoPedido){
        Date fechaModificada = null;
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sqlnombreTienda = "SELECT nombre FROM TIENDA WHERE codigo = ?";
            
            ps = acceso.prepareStatement(sqlnombreTienda);
            ps.setString(1, String.valueOf(cb_tiendaOrigenPedido.getSelectedItem()));
            rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
                String nombreTienda = rs.getString("nombre");
                try {
                    String sqltiempo = "SELECT tiempo FROM TIEMPO" + nombreTienda + " WHERE tienda_codigo = ? AND tienda_destino = ?";

                    ps = acceso.prepareStatement(sqltiempo);
                    ps.setString(1, String.valueOf(cb_tiendaOrigenPedido.getSelectedItem()));
                    ps.setString(2, txt_tiendaDestinoPedido.getText());
                    rs = ps.executeQuery();
                    
                    while(rs.next()){
                        tiempoEnvio = rs.getString(1);
                        String comboBoxCodigoProductoPedido = String.valueOf(cb_codigoProductoPedido.getSelectedItem());
                        String comboBoxTiendaOrigenPedido = String.valueOf(cb_tiendaOrigenPedido.getSelectedItem());
                        String pedidoTienda = "PEDIDO" + String.valueOf(cb_tiendaSeleccion.getSelectedItem());
                        try {
                            DefaultTableModel modelo = new DefaultTableModel();
                            String sql = "INSERT INTO " + pedidoTienda + " (codigo, tienda_origen, tienda_destino, fecha, "
                                    + "cliente_nit, producto_codigo, cantidad_articulos, total_pagar, anticipo, tiempo_envio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            //Se toma la cantidad en existencia de articulos de cierto producto y se resta con los productos que se solicitan en el pedido
                            restaProductoExistenteyPedido = cantidadArticulosDisponibles(cb_tiendaOrigenPedido, cb_codigoProductoPedido) - Integer.parseInt(txt_cantArticulosPedido.getText());
                            cantidadTotalPago = (Double.parseDouble(cortarDecimal.format(precioDeArticulosDisponibles(cb_tiendaOrigenPedido, cb_codigoProductoPedido) * Double.parseDouble(txt_cantArticulosPedido.getText())))) - Double.parseDouble(txt_anticipoPedido.getText()) - creditoIngresado;
                            JOptionPane.showMessageDialog(null, cantidadTotalPago);
                            //Con esta condicion determinamos que si un campo obligatorio es vacio no acepta el registro de la persona
                            if(comboBoxCodigoProductoPedido.equals("") || txt_fechaPedido.getText().equals("") || txt_nitClientePedido.getText().equals("")
                                || cb_codigoProductoPedido.getSelectedItem().equals("") || txt_codigoPedido.getText().equals("") 
                                || txt_cantArticulosPedido.getText().equals("") || txt_anticipoPedido.getText().equals("") || !(Double.parseDouble(txt_anticipoPedido.getText()) >= Double.parseDouble(cortarDecimal.format(porcentajeAnticipo)))
                                || (tiempoEnvio.equals(""))){
                            }else{
                                producto.guardarCantidadExistente(cb_tiendaOrigenPedido, restaProductoExistenteyPedido, cb_codigoProductoPedido);
                                String query1 = "SELECT date_add(DATE('" + txt_fechaPedido.getText() +"'), INTERVAL "+ tiempoEnvio +" DAY);";
                                try {
                                    ps = acceso.prepareStatement(query1);
                                    rs = ps.executeQuery();
                                    while(rs.next()){
                                           fechaModificada = rs.getDate(1);
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                ps = acceso.prepareStatement(sql);
                                ps.setInt(1, Integer.parseInt(txt_codigoPedido.getText()));
                                ps.setString(2, comboBoxTiendaOrigenPedido);
                                ps.setString(3, txt_tiendaDestinoPedido.getText());
                                ps.setDate(4, Date.valueOf(txt_fechaPedido.getText()));
                                ps.setString(5, txt_nitClientePedido.getText());
                                ps.setString(6, comboBoxCodigoProductoPedido);
                                ps.setInt(7, Integer.parseInt(txt_cantArticulosPedido.getText()));
                                ps.setDouble(8, cantidadTotalPago);
                                ps.setDouble(9, Double.parseDouble(txt_anticipoPedido.getText()));
                                ps.setDate(10, fechaModificada);
                            }
                            int res = ps.executeUpdate(); //Pasamos los valores a la Base de Datos
                            if(res > 0){
                                JOptionPane.showMessageDialog(null, "PEDIDO GUARDADO");
                                //Pasamos los valores a la caja de texto
                                Object[] fila = new Object[9];
                                fila[0] = txt_codigoPedido.getText();
                                fila[1] = comboBoxTiendaOrigenPedido;
                                fila[2] = txt_tiendaDestinoPedido.getText();
                                fila[3] = txt_fechaPedido.getText();
                                fila[4] = txt_nitClientePedido.getText();
                                fila[5] = comboBoxCodigoProductoPedido;
                                fila[6] = txt_cantArticulosPedido;
                                fila[7] = cantidadTotalPago;
                                fila[8] = txt_anticipoPedido.getText();
                                modelo.addRow(fila);
                            }else{
                                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR PEDIDO");
                            }
                        } catch (Exception e) {
                            System.out.println(e.toString());
                            JOptionPane.showMessageDialog(null, "                          EL CODIGO NO PUEDE REPETIRSE \n"
                                    + "ES OBLIGATORIO LLENAR NOMBRE, FABRICANTE, CODIGO, CANTIDAD, PRECIO");
                        }
                        String sql1 = "INSERT INTO PEDIDO (codigo, tienda_origen, tienda_destino, fecha, cliente_nit, producto_codigo, cantidad_articulos, total_pagar, anticipo, tiempo_envio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        try {
                            ps = acceso.prepareStatement(sql1);
                            ps.setInt(1, Integer.parseInt(txt_codigoPedido.getText()));
                            ps.setString(2, comboBoxTiendaOrigenPedido);
                            ps.setString(3, txt_tiendaDestinoPedido.getText());
                            ps.setDate(4, Date.valueOf(txt_fechaPedido.getText()));
                            ps.setString(5, txt_nitClientePedido.getText());
                            ps.setString(6, comboBoxCodigoProductoPedido);
                            ps.setInt(7, Integer.parseInt(txt_cantArticulosPedido.getText()));
                            ps.setDouble(8, cantidadTotalPago);
                            ps.setDouble(9, Double.parseDouble(txt_anticipoPedido.getText()));
                            ps.setDate(10, fechaModificada);

                            int res = ps.executeUpdate();
                            if(res > 0){
                                //JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
                                System.out.println("GUARDANDO DATOS");
                            }else{
                                //JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
                                System.out.println("ERROR AL GUARDAR");
                            }
                            //acceso.close();
                        } catch (Exception e) {
                            //JOptionPane.showMessageDialog(null, "Debes llenar los datos que se te piden");
                        }
                        
                    }
                    if(tiempoEnvio.equals("")){
                        JOptionPane.showMessageDialog(null, "ERROR, NO TIENES REGISTRADO EL TIEMPO ENTRE LAS TIENDAS QUE QUIERES INGRESAR");
                    }else{
                        tiempoEnvio = "";
                    }
                } catch (Exception e) {
                }
                //System.out.println("HOLA MUNDO");
            }
            //System.out.println("HOLA MUNDO");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void cargarTiendasBD(JComboBox cb_codigoTiendaOrigenPedido, JTextField txt_tiendaDestinoPedido){
        Conexion con = new Conexion();
        Connection acceso = con.Conectar();
        String query = "SELECT codigo FROM TIENDA";
        try {
            ps = acceso.prepareStatement(query);
            rs = ps.executeQuery();
            cb_codigoTiendaOrigenPedido.removeAllItems();
            while(rs.next()){
                if(txt_tiendaDestinoPedido.getText().equals(rs.getString(1))){
                    //cb_tiendaDestinoTiempo.addItem(rs.getString(1));
                }else{
                    cb_codigoTiendaOrigenPedido.addItem(rs.getString(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void obtenerCodigoTienda(JComboBox cb_tiendaSeleccion, JTextField txt_tiendaDestinoPedido){
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "SELECT codigo FROM TIENDA WHERE nombre = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, String.valueOf(cb_tiendaSeleccion.getSelectedItem()));
            rs = ps.executeQuery();
            
            while(rs.next()){
                txt_tiendaDestinoPedido.setText(rs.getString("codigo"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void obtenerProductoTienda(JComboBox cb_tiendaOrigenPedido, JComboBox cb_codigoProductoPedido){
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "SELECT nombre FROM TIENDA WHERE codigo = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, String.valueOf(cb_tiendaOrigenPedido.getSelectedItem()));
            rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
                String nombreTienda = rs.getString("nombre");
                try {
                    String sql1 = "SELECT codigo FROM PRODUCTO" + nombreTienda;
                    
                    ps = acceso.prepareStatement(sql1);
                    rs = ps.executeQuery();
                    cb_codigoProductoPedido.removeAllItems();
                    while (rs.next()) { 
                        System.out.println(rs.getString(1));
                        cb_codigoProductoPedido.addItem(rs.getString(1));
                    }
                } catch (Exception e) {
                }

            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public int cantidadArticulosDisponibles(JComboBox cb_tiendaOrigenPedido, JComboBox cb_codigoProductoPedido){
        int cantidadArticulos = 0;
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "SELECT nombre FROM TIENDA WHERE codigo = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, String.valueOf(cb_tiendaOrigenPedido.getSelectedItem()));
            rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
                String nombreTienda = rs.getString("nombre");
                try {
                    String sql1 = "SELECT cantidad_disponible FROM PRODUCTO" + nombreTienda + " WHERE codigo = ?";
                    
                    ps = acceso.prepareStatement(sql1);
                    ps.setString(1, String.valueOf(cb_codigoProductoPedido.getSelectedItem()));
                    rs = ps.executeQuery();
                    //cb_codigoProductoPedido.removeAllItems();
                    while (rs.next()) { 
                        System.out.println(rs.getString(1));
                        cantidadArticulos = Integer.parseInt(rs.getString(1));
                    }
                } catch (Exception e) {
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return cantidadArticulos;
    }
    
    public double precioDeArticulosDisponibles(JComboBox cb_tiendaOrigenPedido, JComboBox cb_codigoProductoPedido){
        double precioArticulos = 0;
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "SELECT nombre FROM TIENDA WHERE codigo = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, String.valueOf(cb_tiendaOrigenPedido.getSelectedItem()));
            rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
                String nombreTienda = rs.getString("nombre");
                try {
                    String sql1 = "SELECT precio FROM PRODUCTO" + nombreTienda + " WHERE codigo = ?";
                    
                    ps = acceso.prepareStatement(sql1);
                    ps.setString(1, String.valueOf(cb_codigoProductoPedido.getSelectedItem()));
                    rs = ps.executeQuery();
                    //cb_codigoProductoPedido.removeAllItems();
                    while (rs.next()) { 
                        System.out.println(rs.getString(1));
                        precioArticulos = Double.parseDouble(rs.getString(1));
                    }
                } catch (Exception e) {
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return precioArticulos;
    }
    
    public void porcentajeAnticipo(JTextField txt_anticipoPedido, JComboBox cb_tiendaOrigenPedido, JComboBox cb_codigoProductoPedido, JTextField txt_cantArticulosPedido){ 
        if(txt_cantArticulosPedido.equals("")|| cb_codigoProductoPedido.getSelectedItem().equals("CODIGO PRODUCTO")){
            
        }else{
            double cantidadTotalPago = precioDeArticulosDisponibles(cb_tiendaOrigenPedido, cb_codigoProductoPedido) * Double.parseDouble(txt_cantArticulosPedido.getText());
            porcentajeAnticipo = cantidadTotalPago * 0.25;
            txt_anticipoPedido.setText(String.valueOf(cortarDecimal.format(porcentajeAnticipo)));
        }
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void cambioDeTiempoEnvio(JComboBox cb_tiendaDestinoTiempo, JTextField txt_tiendaOrigenTiempo, JTextField txt_tiempo){
        Date fechaModificada = null;
        Date fechaEntrega = null;
        //Date fechaPedido = null;
        int numeroDias = 0;
        Date fechaActual = null;
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "SELECT nombre FROM TIENDA WHERE codigo = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, String.valueOf(cb_tiendaDestinoTiempo.getSelectedItem()));
            rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
                String nombreTienda = rs.getString("nombre");//"SELECT fecha FROM PEDIDO" + nombreTienda + " WHERE tienda_origen = ? AND tienda_destino = ?";
                
                String query1 = "SELECT CURDATE()";
                        try {
                            ps = acceso.prepareStatement(query1);
                            rs = ps.executeQuery();
                            while(rs.next()){
                                fechaActual = rs.getDate(1);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
                try {
                    String sql3 = "SELECT tiempo_envio FROM PEDIDO" + nombreTienda + " WHERE fecha = '" + fechaActual + "'";
                    
                    ps = acceso.prepareStatement(sql3);
                    //ps.setString(1, txt_tiendaOrigenTiempo.getText());
                    //ps.setString(2, String.valueOf(cb_tiendaDestinoTiempo.getSelectedItem()));
                    rs = ps.executeQuery();
                    //cb_codigoProductoPedido.removeAllItems();
                    while (rs.next()) { 
//                        if(!rs.getDate(1).equals(fechaActual)){
//                            fechaPedido = rs.getDate(1);
//                            JOptionPane.showMessageDialog(null, fechaPedido);
                        //}else{
                            fechaEntrega = rs.getDate(1);
                            JOptionPane.showMessageDialog(null, fechaEntrega);
                       // }
//                        fechaPedido = rs.getDate(1);
//                        JOptionPane.showMessageDialog(null, fechaPedido);
//                        fechaPedido = rs.getDate(1);
//                        JOptionPane.showMessageDialog(null, fechaPedido);
                    }
                } catch (Exception e) {
                }
                
                String query7 = "SELECT DATEDIFF('"+ fechaEntrega +"','" + fechaActual + "')";
                        try {
                            ps = acceso.prepareStatement(query7);
                            rs = ps.executeQuery();
                            while(rs.next()){
                                // cb_tiendaCatalogo.addItem(rs.getString(1));
//                                if(rs.getDate(1).equals(fechaActual)){
//                                    fechaModificada = rs.getDate(1);
                                //}else{
                                    numeroDias = rs.getInt(1);
                                    JOptionPane.showMessageDialog(null, numeroDias);
                                //}
                                //fechaModificada = rs.getDate(1);
                                //cb_productoTienda.addItem(rs.getString(1));
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
                        String query2 = "SELECT DATE_SUB(DATE('" + fechaEntrega + "'), INTERVAL "+ numeroDias +" DAY);";
                        try {
                            ps = acceso.prepareStatement(query2);
                            rs = ps.executeQuery();
                            while(rs.next()){
                                // cb_tiendaCatalogo.addItem(rs.getString(1));
//                                if(rs.getDate(1).equals(fechaActual)){
                                    fechaModificada = rs.getDate(1);
//                                }else{
//                                    fechaPedido = rs.getDate(1);
//                                    JOptionPane.showMessageDialog(null, fechaPedido);
                               // }
                                //fechaModificada = rs.getDate(1);
                                //cb_productoTienda.addItem(rs.getString(1));
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
//                        String query2 = "SELECT date_add(DATE('" + fechaPedido + "'), INTERVAL "+ txt_tiempo.getText() +" DAY);";
//                        try {
//                            ps = acceso.prepareStatement(query2);
//                            rs = ps.executeQuery();
//                            while(rs.next()){
//                                // cb_tiendaCatalogo.addItem(rs.getString(1));
//                                if(rs.getDate(1).equals(fechaActual)){
//                                    fechaModificada = rs.getDate(1);
//                                }else{
//                                    fechaPedido = rs.getDate(1);
//                                    JOptionPane.showMessageDialog(null, fechaPedido);
//                                }
//                                //fechaModificada = rs.getDate(1);
//                                //cb_productoTienda.addItem(rs.getString(1));
//                            }
//                        } catch (SQLException ex) {
//                            Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                
                try {
                    DefaultTableModel modelo = new DefaultTableModel();
                    String sql1 = "UPDATE PEDIDO" + nombreTienda +" SET tiempo_envio=? WHERE tienda_origen=? AND tienda_destino=?";
                    //Con esta condicion determinamos que si un campo obligatorio es vacio no acepta el registro de la persona
                        ps = acceso.prepareStatement(sql1);
                        ps.setDate(1, fechaModificada);
                        ps.setString(2, txt_tiendaOrigenTiempo.getText());
                        ps.setString(3, String.valueOf(cb_tiendaDestinoTiempo.getSelectedItem()));

                    int res = ps.executeUpdate(); //Pasamos los valores a la Base de Datos
                    if(res > 0){
                        JOptionPane.showMessageDialog(null, "TIEMPO ENVIO MODIFICADO");
                        //Pasamos los valores a la caja de texto
                        Object[] fila = new Object[1];
                        fila[0] = fechaModificada;
                        modelo.addRow(fila);
                    }else{
                        JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR TIEMPO ENVIO");
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                    JOptionPane.showMessageDialog(null, "                          EL CODIGO NO PUEDE REPETIRSE \n"
                            + "ES OBLIGATORIO LLENAR NOMBRE, FABRICANTE, CODIGO, CANTIDAD, PRECIO");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void mostrarPedidoVerificarIngresoTabla(JTable pedidoTable, JComboBox cb_tiendaSeleccionada){
        Date fechaActual = null;
        String pedido = "PEDIDO" + String.valueOf(cb_tiendaSeleccionada.getSelectedItem());
        //El try me permite capturar el error que me sale por conexion
        //Tambien nos permite hacer la conexion con la DB para  mostrar los datos de la tabla empleados de
        //la DB en la tabla empleadosTable que tenemos en nuestra interfaz grafica
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            pedidoTable.setModel(modelo);
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            
            String query = "SELECT CURDATE()";
            try {
                ps = acceso.prepareStatement(query);
                rs = ps.executeQuery();
                while(rs.next()){
                       // cb_tiendaCatalogo.addItem(rs.getString(1));
                       fechaActual = rs.getDate(1);
                    //cb_productoTienda.addItem(rs.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT * FROM " + pedido + " WHERE tiempo_envio = '" + fechaActual + "' ORDER BY codigo ASC"; // aqui concatenar where
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            modelo.addColumn("No. PEDIDO");
            modelo.addColumn("CODIGO PEDIDO");
            modelo.addColumn("CODIGO TIENDA ORIGEN");
            modelo.addColumn("CODIGO TIENDA ACTUAL");
            modelo.addColumn("FECHA DE PEDIDO");
            modelo.addColumn("NIT CLIENTE");
            modelo.addColumn("CODIGO PRODUCTO");
            modelo.addColumn("CANTIDAD DE ARTICULOS");
            modelo.addColumn("TOTAL A PAGAR");
            modelo.addColumn("ANTICIPO");
            modelo.addColumn("FECHA ENTREGA");
            //Capturamos en las columnas que contiene nuestra tabla de interfaz los datos de nuestra DB
            while(rs.next()){
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
//                    if(i == 10){
//                        filas[i] = new JButton("Validar Entrega");
//                    }
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);//agregamos las filas al modelo que en este caso es la tabla Interfaz
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
                
        }
    }
    
    public void mostrarPedidoQueSalieronDeLaTiendaTabla(JTable reportesTable, JTextField txt_tiendaDestinoPedido){
        //El try me permite capturar el error que me sale por conexion
        //Tambien nos permite hacer la conexion con la DB para  mostrar los datos de la tabla empleados de
        //la DB en la tabla empleadosTable que tenemos en nuestra interfaz grafica
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            reportesTable.setModel(modelo);
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            
            String sql = "SELECT * FROM PEDIDO WHERE tienda_origen = '" + txt_tiendaDestinoPedido.getText() + "' ORDER BY id ASC"; // aqui concatenar where
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("No. PEDIDO");
            modelo.addColumn("CODIGO PEDIDO");
            modelo.addColumn("CODIGO TIENDA ORIGEN");
            modelo.addColumn("CODIGO TIENDA ACTUAL");
            modelo.addColumn("FECHA DE PEDIDO");
            modelo.addColumn("NIT CLIENTE");
            modelo.addColumn("CODIGO PRODUCTO");
            modelo.addColumn("CANTIDAD DE ARTICULOS");
            modelo.addColumn("TOTAL A PAGAR");
            modelo.addColumn("ANTICIPO");
            modelo.addColumn("TIEMPO ENVIO");
            //Capturamos en las columnas que contiene nuestra tabla de interfaz los datos de nuestra DB
            while(rs.next()){
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);//agregamos las filas al modelo que en este caso es la tabla Interfaz
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
                
        }
    }
    //NUEVOS METODOS CLIENTE
    public void usoCreditoCliente(JTextField txt_nitClientePedido){
        Conexion con = new Conexion();
        Connection acceso = con.Conectar();
        String query = "SELECT credito_compra FROM CLIENTE WHERE nit = '" + txt_nitClientePedido.getText() + "'";
        try {
            ps = acceso.prepareStatement(query);
            rs = ps.executeQuery();
            //cb_codigoTiendaOrigenPedido.removeAllItems();
            while(rs.next()){//rs.getString(1)
                if(rs.getDouble(1) <= 0){
                    JOptionPane.showMessageDialog(null, "¡NO TIENES CREDITO DISPONIBLE!");
                    creditoIngresado = 0;
                }else{
                    JOptionPane.showMessageDialog(null, "TU CRÉDITO DISPONIBLE ES = " + rs.getInt(1));
                    try {
                        creditoIngresado = Double.parseDouble(JOptionPane.showInputDialog(null, "|||INGRESA EL CRÉDITO QUE USARÁS|||"));

                    } catch (Exception e) {
                        creditoIngresado = 0;
                    }
                    if(creditoIngresado >= 0 && creditoIngresado <= rs.getInt(1)){
                        double restaCredito = rs.getDouble(1) - creditoIngresado;
                        guardarNuevoCreditoCliente(txt_nitClientePedido, restaCredito);
                    }else{
                        JOptionPane.showMessageDialog(null, "SOLO TIENES DE CRÉDITO DISPONIBLE: " + rs.getInt(1));
                        creditoIngresado = 0;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarNuevoCreditoCliente(JTextField txt_nitClientePedido, double creditoIngresado){
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
                
                try {
                    DefaultTableModel modelo = new DefaultTableModel();
                    String sql1 = "UPDATE CLIENTE SET credito_compra=? WHERE nit=?";
                    //Con esta condicion determinamos que si un campo obligatorio es vacio no acepta el registro de la persona

                        ps = acceso.prepareStatement(sql1);
                        ps.setDouble(1, creditoIngresado);
                        ps.setString(2, txt_nitClientePedido.getText());

                    int res = ps.executeUpdate(); //Pasamos los valores a la Base de Datos
                    if(res > 0){
                        //JOptionPane.showMessageDialog(null, "PRODUCTO GUARDADO");
                        //Pasamos los valores a la caja de texto
                        Object[] fila = new Object[1];
                        fila[0] = creditoIngresado;
                        modelo.addRow(fila);
                    }else{
                        JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR CREDITO");
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                    JOptionPane.showMessageDialog(null, "OBLIGATORIO LLENAR TODOS LOS DATOS");
                }
    }
}