package com.mycompany.intelaf_project1;

import com.mycompany.intelaf_project1.UI.trabajador.IngresarDatos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
    public void pasarDatosComponentes(JTable pedidoTable, JTextField txt_tiendaOrigenPedido, JTextField txt_fechaPedido, JTextField txt_nitClientePedido,
            JTextField txt_codigoProductoPedido, JTextField txt_codigoPedido, JTextField txt_cantArticulosPedido,
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
                txt_tiendaOrigenPedido.setText(rs.getString("tienda_origen"));
                txt_fechaPedido.setText(rs.getString("fecha"));
                txt_nitClientePedido.setText(rs.getString("cliente_nit"));
                txt_codigoProductoPedido.setText(rs.getString("producto_codigo"));
                txt_cantArticulosPedido.setText(rs.getString("cantidad_articulos"));
                txt_totalPagarPedido.setText(rs.getString("total_pagar"));
                txt_anticipoPedido.setText(rs.getString("anticipo"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void guardarNuevosProducto(JTable pedidoTable, JTextField txt_tiendaOrigenPedido, JTextField txt_fechaPedido, JTextField txt_nitClientePedido,
            JTextField txt_codigoProductoPedido, JTextField txt_codigoPedido, JTextField txt_cantArticulosPedido,
            JTextField txt_totalPagarPedido, JTextField txt_anticipoPedido, JComboBox cb_tiendaSeleccion, JTextField txt_tiendaDestinoPedido){
        String pedidoTienda = "PEDIDO" + String.valueOf(cb_tiendaSeleccion.getSelectedItem());
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "INSERT INTO " + pedidoTienda + " (codigo, tienda_origen, tienda_destino, fecha, "
                    + "cliente_nit, producto_codigo, cantidad_articulos, total_pagar, anticipo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            //Con esta condicion determinamos que si un campo obligatorio es vacio no acepta el registro de la persona
            if(txt_tiendaOrigenPedido.getText().equals("") || txt_fechaPedido.getText().equals("") || txt_nitClientePedido.getText().equals("")
                || txt_codigoProductoPedido.getText().equals("") || txt_codigoPedido.getText().equals("") 
                || txt_cantArticulosPedido.getText().equals("") || txt_totalPagarPedido.getText().equals("") || txt_anticipoPedido.getText().equals("")){
            }else{
                
                ps = acceso.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(txt_codigoPedido.getText()));
                ps.setString(2, txt_tiendaOrigenPedido.getText());
                ps.setString(3, txt_tiendaDestinoPedido.getText());
                ps.setDate(4, Date.valueOf(txt_fechaPedido.getText()));
                ps.setString(5, txt_nitClientePedido.getText());
                ps.setString(6, txt_codigoProductoPedido.getText());
                ps.setInt(7, Integer.parseInt(txt_cantArticulosPedido.getText()));
                ps.setDouble(8, Double.parseDouble(txt_totalPagarPedido.getText()));
                ps.setDouble(9, Double.parseDouble(txt_anticipoPedido.getText()));
            }
            
            int res = ps.executeUpdate(); //Pasamos los valores a la Base de Datos
            if(res > 0){
                JOptionPane.showMessageDialog(null, "PEDIDO GUARDADO");
                //Pasamos los valores a la caja de texto
                Object[] fila = new Object[9];
                fila[0] = txt_codigoPedido.getText();
                fila[1] = txt_tiendaOrigenPedido.getText();
                fila[2] = txt_tiendaDestinoPedido.getText();
                fila[3] = txt_fechaPedido.getText();
                fila[4] = txt_nitClientePedido.getText();
                fila[5] = txt_codigoProductoPedido.getText();
                fila[6] = txt_cantArticulosPedido.getText();
                fila[7] = txt_totalPagarPedido.getText();
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
    }
//    public void multiplicarPedidoProducto(JTable pedidoTable, JTextField txt_buscarPedido, JComboBox cb_tiendaSeleccionada){
//        String pedido = "PEDIDO" + String.valueOf(cb_tiendaSeleccionada.getSelectedItem());
//        String producto = "PRODUCTO" + String.valueOf(cb_tiendaSeleccionada.getSelectedItem());
//        //String productoTienda = String.valueOf(cb_productoTienda.getSelectedItem());
//        String buscar = txt_buscarPedido.getText();
//        String where = "";
//         //Me permite buscar en la lista por medio del codigo del empleado al empleado
//        if(!"".equals(buscar)){
//            where = " WHERE codigo = '" + buscar + "' OR cliente_nit = '" + buscar + "'";
//        }
//        //El try me permite capturar el error que me sale por conexion
//        //Tambien nos permite hacer la conexion con la DB para  mostrar los datos de la tabla empleados de
//        //la DB en la tabla empleadosTable que tenemos en nuestra interfaz grafica
//        try {
//            DefaultTableModel modelo = new DefaultTableModel();
//            pedidoTable.setModel(modelo);
//            Conexion con = new Conexion();
//            Connection acceso = con.Conectar();
//            
//            String sql = "SELECT * FROM " + pedido + where + " ORDER BY codigo ASC"; // aqui concatenar where
//            ps = acceso.prepareStatement(sql);
//            rs = ps.executeQuery();
//            ResultSetMetaData rsMd = rs.getMetaData();
//            int cantidadColumnas = rsMd.getColumnCount();
//            modelo.addColumn("No. PEDIDO");
//            modelo.addColumn("CODIGO PEDIDO");
//            modelo.addColumn("CODIGO TIENDA ORIGEN");
//            modelo.addColumn("CODIGO TIENDA ACTUAL");
//            modelo.addColumn("FECHA DE PEDIDO");
//            modelo.addColumn("NIT CLIENTE");
//            modelo.addColumn("CODIGO PRODUCTO");
//            modelo.addColumn("CANTIDAD DE ARTICULOS");
//            modelo.addColumn("TOTAL A PAGAR");
//            modelo.addColumn("ANTICIPO");
//            //Capturamos en las columnas que contiene nuestra tabla de interfaz los datos de nuestra DB
//            while(rs.next()){
//                Object[] filas = new Object[cantidadColumnas];
//                for (int i = 0; i < cantidadColumnas; i++) {
//                    if(i == 8){
//                        filas[i] = rs.getObject(i + 1);
//                    }
//                    filas[i] = rs.getObject(i + 1);
//                }
//                modelo.addRow(filas);//agregamos las filas al modelo que en este caso es la tabla Interfaz
//            }
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//                
//        }
//    }
    
//    public void cargarTiendasBD(JComboBox cb_tiendaSeleccionada){
//        Conexion con = new Conexion();
//        Connection acceso = con.Conectar();
////        String query1 = "";
////        try {
////            ps = acceso.prepareStatement(query1);
////            rs = ps.executeQuery();
////            //cb_tiendaSeleccion.removeAllItems();
////            while(rs.next()){
////                System.out.println(rs.getString(1));
////                    //cb_tiendaSeleccion.addItem(rs.getString(1));
////                //cb_productoTienda.addItem(rs.getString(1));
////            }
////        } catch (SQLException ex) {
////            Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
////        }
//        String pedido = "PEDIDO" + String.valueOf(cb_tiendaSeleccionada.getSelectedItem());
//        String producto = "PRODUCTO" + String.valueOf(cb_tiendaSeleccionada.getSelectedItem());
//        String query = "SELECT Pe.cantidad_articulos*Pr.precio FROM PEDIDOB Pe JOIN PRODUCTOA Pr ON Pe.producto_codigo = Pr.codigo";
//        try {
//            ps = acceso.prepareStatement(query);
//            rs = ps.executeQuery();
//            //cb_tiendaSeleccion.removeAllItems();
//            while(rs.next()){
//                System.out.println(rs.getString(1));
//                    //cb_tiendaSeleccion.addItem(rs.getString(1));
//                //cb_productoTienda.addItem(rs.getString(1));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
