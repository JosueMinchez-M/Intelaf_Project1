package com.mycompany.intelaf_project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joshua
 */
public class Producto {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    public void mostrarDatosTabla(JTable productoTable, JTextField txt_buscarProducto, JComboBox cb_productoTienda){
        String productoTienda = String.valueOf(cb_productoTienda.getSelectedItem());
        String buscar = txt_buscarProducto.getText();
        String where = "";
         //Me permite buscar en la lista por medio del codigo del empleado al empleado
        if(!"".equals(buscar)){
            where = " WHERE codigo = '" + buscar + "' OR nombre = '" + buscar + "'";
        }
        //El try me permite capturar el error que me sale por conexion
        //Tambien nos permite hacer la conexion con la DB para  mostrar los datos de la tabla empleados de
        //la DB en la tabla empleadosTable que tenemos en nuestra interfaz grafica
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            productoTable.setModel(modelo);
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            
            String sql = "SELECT * FROM " + productoTienda + where + " ORDER BY codigo ASC"; // aqui concatenar where
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("CODIGO");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("FABRICANTE");
            modelo.addColumn("CANTIDAD DISPONIBLE");
            modelo.addColumn("PRECIO");
            modelo.addColumn("DESCRIPCION");
            modelo.addColumn("GARANTIA");
            modelo.addColumn("CODIGO TIENDA");
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
    
    /*Permite pasar los datos del empleado a las casillas en donde se pueden modificar
      solo se agregan los datos que son posible modificar, asi como el codigo y dpi no se agregan
      porque son datos que no cambiaran*/
    public void pasarDatosComponentes(JTextField txt_codigoProducto, JTextField txt_nombreProducto, JTable productoTable, JTextField txt_fabricanteProducto, 
            JTextField txt_cantidadProducto, JTextField txt_precioProducto, JTextField txt_descripcionProducto, 
            JTextField txt_garantiaProducto, JComboBox cb_productoTienda, JTextField txt_prodTienda){
        String productoTienda = String.valueOf(cb_productoTienda.getSelectedItem());
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            int Fila = productoTable.getSelectedRow();//permite pasar los datos de cada trabajador
            System.out.println(Fila);
            String codigo = productoTable.getValueAt(Fila, 0).toString();
            String sql = "SELECT * FROM " + productoTienda + " WHERE codigo = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            
            while(rs.next()){
                txt_codigoProducto.setText(rs.getString("codigo"));
                txt_nombreProducto.setText(rs.getString("nombre"));
                txt_fabricanteProducto.setText(rs.getString("fabricante"));
                txt_cantidadProducto.setText(rs.getString("cantidad_disponible"));
                txt_precioProducto.setText(rs.getString("precio"));
                txt_descripcionProducto.setText(rs.getString("descripcion"));
                txt_garantiaProducto.setText(rs.getString("garantia"));
                txt_prodTienda.setText(rs.getString("Tienda_codigo"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void guardarNuevosProducto(JTextField txt_codigoProducto, JTextField txt_nombreProducto, JTextField txt_fabricanteProducto, JTextField txt_cantidadProducto, 
            JTextField txt_precioProducto, JTextField txt_descripcionProducto, JTextField txt_garantiaProducto, JComboBox cb_productoTienda, JTextField txt_tiendaCodigo){
        String productosTienda = String.valueOf(cb_productoTienda.getSelectedItem());
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "INSERT INTO " + productosTienda + " (codigo, nombre, fabricante, cantidad_disponible, precio, descripcion, garantia, Tienda_codigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            //Con esta condicion determinamos que si un campo obligatorio es vacio no acepta el registro de la persona
            if(txt_codigoProducto.getText().equals("") || txt_precioProducto.getText().equals("") || txt_nombreProducto.getText().equals("")
                || txt_fabricanteProducto.getText().equals("") || txt_cantidadProducto.getText().equals("")){
            }else{
                
                ps = acceso.prepareStatement(sql);
                ps.setString(1, txt_codigoProducto.getText());
                ps.setString(2, txt_nombreProducto.getText());
                ps.setString(3, txt_fabricanteProducto.getText());
                ps.setInt(4, Integer.parseInt(txt_cantidadProducto.getText()));
                ps.setDouble(5, Double.parseDouble(txt_precioProducto.getText()));
                ps.setString(6, txt_descripcionProducto.getText());
                ps.setString(7, txt_garantiaProducto.getText());
                ps.setString(8, txt_tiendaCodigo.getText());
            }
            
            int res = ps.executeUpdate(); //Pasamos los valores a la Base de Datos
            if(res > 0){
                JOptionPane.showMessageDialog(null, "PRODUCTO GUARDADO");
                //Pasamos los valores a la caja de texto
                Object[] fila = new Object[8];
                fila[0] = txt_codigoProducto.getText();
                fila[1] = txt_nombreProducto.getText();
                fila[2] = txt_fabricanteProducto.getText();
                fila[3] = txt_cantidadProducto.getText();
                fila[4] = txt_precioProducto.getText();
                fila[5] = txt_descripcionProducto.getText();
                fila[6] = txt_garantiaProducto.getText();
                fila[7] = txt_tiendaCodigo.getText();
                modelo.addRow(fila);
            }else{
                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR PRODUCTO");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "                EL CODIGO NO PUEDE ESTAR REPETIDO, \n"
                    + "ES OBLIGATORIO LLENAR NOMBRE, FABRICANTE, CODIGO, CANTIDAD, PRECIO");
        }
    }
}
