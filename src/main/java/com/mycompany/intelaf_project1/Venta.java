package com.mycompany.intelaf_project1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joshua
 */
public class Venta {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
//    public void registrarVenta(JTextField txt_codigoTiendaVenta, JTextField txt_fechaVenta, JTextField txt_nitClienteVenta,
//            JComboBox cb_codigoProductoVenta, JTextField txt_cantArticulosVenta, JTextField txt_creditoClieteVenta){
//        String comboBoxCodigoProductoPedido = String.valueOf(cb_codigoProductoPedido.getSelectedItem());
////        String comboBoxTiendaOrigenPedido = String.valueOf(cb_tiendaOrigenPedido.getSelectedItem());
//        String pedidoTienda = "PEDIDO" + String.valueOf(cb_tiendaSeleccion.getSelectedItem());
//        try {
//            DefaultTableModel modelo = new DefaultTableModel();
//            Conexion con = new Conexion();
//            Connection acceso = con.Conectar();
//            String sql = "INSERT INTO " + pedidoTienda + " (codigo, tienda_origen, tienda_destino, fecha, "
//                    + "cliente_nit, producto_codigo, cantidad_articulos, total_pagar, anticipo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            //Se toma la cantidad en existencia de articulos de cierto producto y se resta con los productos que se solicitan en el pedido
//            int restaProductoExistenteyPedido = cantidadArticulosDisponibles(cb_tiendaOrigenPedido, cb_codigoProductoPedido) - Integer.parseInt(txt_cantArticulosPedido.getText());
//            double cantidadTotalPago = Double.parseDouble(cortarDecimal.format(precioDeArticulosDisponibles(cb_tiendaOrigenPedido, cb_codigoProductoPedido) * Double.parseDouble(txt_cantArticulosPedido.getText())));
//            JOptionPane.showMessageDialog(null, cantidadTotalPago);
//            //Con esta condicion determinamos que si un campo obligatorio es vacio no acepta el registro de la persona
//            if(comboBoxCodigoProductoPedido.equals("") || txt_fechaPedido.getText().equals("") || txt_nitClientePedido.getText().equals("")
//                || cb_codigoProductoPedido.getSelectedItem().equals("") || txt_codigoPedido.getText().equals("") 
//                || txt_cantArticulosPedido.getText().equals("") || txt_anticipoPedido.getText().equals("") || !(Double.parseDouble(txt_anticipoPedido.getText()) >= Double.parseDouble(cortarDecimal.format(porcentajeAnticipo)))){
//            }else{
//                producto.guardarCantidadExistente(cb_tiendaOrigenPedido, restaProductoExistenteyPedido, cb_codigoProductoPedido);
//                ps = acceso.prepareStatement(sql);
//                ps.setInt(1, Integer.parseInt(txt_codigoPedido.getText()));
//                ps.setString(2, comboBoxTiendaOrigenPedido);
//                ps.setString(3, txt_tiendaDestinoPedido.getText());
//                ps.setDate(4, Date.valueOf(txt_fechaPedido.getText()));
//                ps.setString(5, txt_nitClientePedido.getText());
//                ps.setString(6, comboBoxCodigoProductoPedido);
//                ps.setInt(7, Integer.parseInt(txt_cantArticulosPedido.getText()));
//                ps.setDouble(8, cantidadTotalPago);
//                ps.setDouble(9, Double.parseDouble(txt_anticipoPedido.getText()));
//            }
//            
//            int res = ps.executeUpdate(); //Pasamos los valores a la Base de Datos
//            if(res > 0){
//                JOptionPane.showMessageDialog(null, "PEDIDO GUARDADO");
//                //Pasamos los valores a la caja de texto
//                Object[] fila = new Object[9];
//                fila[0] = txt_codigoPedido.getText();
//                fila[1] = comboBoxTiendaOrigenPedido;
//                fila[2] = txt_tiendaDestinoPedido.getText();
//                fila[3] = txt_fechaPedido.getText();
//                fila[4] = txt_nitClientePedido.getText();
//                fila[5] = comboBoxCodigoProductoPedido;
//                fila[6] = txt_cantArticulosPedido;
//                fila[7] = cantidadTotalPago;
//                fila[8] = txt_anticipoPedido.getText();
//                modelo.addRow(fila);
//            }else{
//                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR PEDIDO");
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//            JOptionPane.showMessageDialog(null, "                          EL CODIGO NO PUEDE REPETIRSE \n"
//                    + "ES OBLIGATORIO LLENAR NOMBRE, FABRICANTE, CODIGO, CANTIDAD, PRECIO");
//        }
//    }
}
