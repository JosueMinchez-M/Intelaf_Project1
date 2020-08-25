package com.mycompany.intelaf_project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joshua
 */
public class Cliente {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void mostrarDatosTabla(JTable clienteTable, JTextField txt_buscarCliente){
        String buscar = txt_buscarCliente.getText();
        String where = "";
         //Me permite buscar en la lista por medio del codigo del empleado al empleado
        if(!"".equals(buscar)){
            where = "WHERE nombre = '" + buscar + "' OR nit = '" + buscar + "'";
        }
        //El try me permite capturar el error que me sale por conexion
        //Tambien nos permite hacer la conexion con la DB para  mostrar los datos de la tabla empleados de
        //la DB en la tabla empleadosTable que tenemos en nuestra interfaz grafica
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            clienteTable.setModel(modelo);
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            
            String sql = "SELECT * FROM CLIENTE " + where + " ORDER BY nit ASC"; // aqui concatenar where
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("NIT");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("TELEFONO");
            modelo.addColumn("DPI");
            modelo.addColumn("CREDITO DE COMPRA");
            modelo.addColumn("CORREO ELECTRONICO");
            modelo.addColumn("DIRECCION");
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
    public void pasarDatosComponentes(JTextField txt_dpiCliente, JTable clienteTable, JTextField txt_nombreCliente, 
            JTextField txt_telefonoCliente, JTextField txt_nitCliente, JTextField txt_correoCliente, 
            JTextField txt_direccionCliente, JTextField txt_creditoCliente){
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            int Fila = clienteTable.getSelectedRow();//permite pasar los datos de cada trabajador
            String codigo = clienteTable.getValueAt(Fila, 0).toString();
            String sql = "SELECT * FROM CLIENTE WHERE nit = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            
            while(rs.next()){
                txt_nitCliente.setText(rs.getString("nit"));
                txt_nombreCliente.setText(rs.getString("nombre"));
                txt_telefonoCliente.setText(rs.getString("telefono"));
                txt_dpiCliente.setText(rs.getString("dpi"));
                txt_creditoCliente.setText(rs.getString("credito_compra"));
                txt_correoCliente.setText(rs.getString("correo_electronico"));
                txt_direccionCliente.setText(rs.getString("direccion"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public void guardarNuevosCliente(JTextField txt_dpiCliente, JTextField txt_nombreCliente, 
            JTextField txt_telefonoCliente, JTextField txt_nitCliente, JTextField txt_correoCliente, 
            JTextField txt_direccionCliente, JTextField txt_creditoCliente){
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "INSERT INTO CLIENTE (nit, nombre, telefono, dpi, credito_compra, correo_electronico, direccion) VALUES(?, ?, ?, ?, ?, ?, ?)";
            if((txt_nombreCliente.getText().equals("") || txt_telefonoCliente.getText().equals("") || txt_nitCliente.getText().equals(""))){

            }else{
                if(txt_creditoCliente.getText().equals("")){
                    txt_creditoCliente.setText("0");
                }
                
                ps = acceso.prepareStatement(sql);
                ps.setString(1, txt_nitCliente.getText());
                ps.setString(2, txt_nombreCliente.getText());
                ps.setString(3, txt_telefonoCliente.getText());
                ps.setString(4, txt_dpiCliente.getText());
                ps.setInt(5, Integer.valueOf(txt_creditoCliente.getText()));
                ps.setString(6, txt_correoCliente.getText());
                ps.setString(7, txt_direccionCliente.getText());
            }
            int res = ps.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "CLIENTE GUARDADO");
                //Pasamos los valores a la caja de texto
                Object[] fila = new Object[7];
                fila[0] = txt_nitCliente.getText();
                fila[1] = txt_nombreCliente.getText();
                fila[2] = txt_telefonoCliente.getText();
                fila[3] = txt_dpiCliente.getText();
                fila[4] = txt_creditoCliente.getText();
                fila[5] = txt_correoCliente.getText();
                fila[6] = txt_direccionCliente.getText();
            modelo.addRow(fila);
            }else{
                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR CLIENTE");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "CLIENTE NO GUARDADO, INGRESASTE CARACTERES NO VALIDOS");//ES OBLIGATORIO LLENAR NOMBRE, TELEFONO Y NIT
        }
    }
    public void modificarCliente(JTextField txt_dpiCliente, JTextField txt_nombreCliente, 
            JTextField txt_telefonoCliente, JTextField txt_nitCliente, JTextField txt_correoCliente, 
            JTextField txt_direccionCliente, JTextField txt_creditoCliente){
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "UPDATE CLIENTE SET nombre=?, telefono=?, dpi=?, credito_compra=?, correo_electronico=?, direccion=? WHERE nit=?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, txt_nombreCliente.getText());
            ps.setString(2, txt_telefonoCliente.getText());
            ps.setString(3, txt_dpiCliente.getText());
            ps.setString(4, txt_creditoCliente.getText());
            ps.setString(5, txt_correoCliente.getText());
            ps.setString(6, txt_direccionCliente.getText());
            ps.setString(7, txt_nitCliente.getText());
            int res = ps.executeUpdate(); //Pasamos los valores a la Base de Datos
            if(res > 0){
                JOptionPane.showMessageDialog(null, "CLIENTE MODIFICADO");
            //Con esto podemos ver nuevamente en la tabla de la lista los datos actualizados
            Object[] fila = new Object[6];
            fila[0] = txt_nombreCliente.getText();
            fila[1] = txt_telefonoCliente.getText();
            fila[2] = txt_dpiCliente.getText();
            fila[3] = txt_creditoCliente.getText();
            fila[4] = txt_correoCliente.getText();
            fila[5] = txt_direccionCliente.getText();
            modelo.addRow(fila);
            }else{
                JOptionPane.showMessageDialog(null, "ERROR, CLIENTE NO MODIFICADO");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "CLIENTE NO MODIFICADO, INGRESASTE CARACTERES NO VALIDOS");
        }
    }
    
    public void ListadoPedidosEnCursoCliente(){
        
    }
}
