/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.intelaf_project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.function.ObjIntConsumer;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joshua
 */
public class Empleado {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    public void mostrarDatosTabla(JTable empleadosTable, JTextField txt_buscar){
        String buscar = txt_buscar.getText();
        String where = "";
         //Me permite buscar en la lista por medio del codigo del empleado al empleado
        if(!"".equals(buscar)){
            where = "WHERE codigo = '" + buscar + "' OR nombre = '" + buscar + "'";
        }
        //El try me permite capturar el error que me sale por conexion
        //Tambien nos permite hacer la conexion con la DB para  mostrar los datos de la tabla empleados de
        //la DB en la tabla empleadosTable que tenemos en nuestra interfaz grafica
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            empleadosTable.setModel(modelo);
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            
            String sql = "SELECT * FROM EMPLEADO " + where + " ORDER BY codigo ASC"; // aqui concatenar where
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("CODIGO");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("TELEFONO");
            modelo.addColumn("DPI");
            modelo.addColumn("NIT");
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
    public void pasarDatosComponentes(JTable empleadosTable, JTextField txt_nombreEmpleado, 
            JTextField txt_telefonoEmpleado, JTextField txt_nitEmpleado, JTextField txt_correoEmpleado, 
            JTextField txt_direccionEmpleado){
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            int Fila = empleadosTable.getSelectedRow();//permite pasar los datos de cada trabajador
            String codigo = empleadosTable.getValueAt(Fila, 0).toString();
            String sql = "SELECT * FROM EMPLEADO WHERE codigo = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            
            while(rs.next()){
                txt_nombreEmpleado.setText(rs.getString("nombre"));
                txt_telefonoEmpleado.setText(rs.getString("telefono"));
                txt_nitEmpleado.setText(rs.getString("nit"));
                txt_correoEmpleado.setText(rs.getString("correo_electronico"));
                txt_direccionEmpleado.setText(rs.getString("direccion"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public void guardarNuevosEmpleados(JTextField txt_codigoEmpleado, JTextField txt_dpiEmpleado, JTextField txt_nombreEmpleado, JTextField txt_telefonoEmpleado, 
            JTextField txt_nitEmpleado, JTextField txt_correoEmpleado, JTextField txt_direccionEmpleado){
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "INSERT INTO EMPLEADO (codigo, nombre, telefono, dpi, nit, correo_electronico, direccion) VALUES(?, ?, ?, ?, ?, ?, ?)";
            
            ps = acceso.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txt_codigoEmpleado.getText()));
            ps.setString(2, txt_nombreEmpleado.getText());
            ps.setInt(3, Integer.parseInt(txt_telefonoEmpleado.getText()));
            ps.setString(4, txt_dpiEmpleado.getText());
            ps.setString(5, txt_nitEmpleado.getText());
            ps.setString(6, txt_correoEmpleado.getText());
            ps.setString(7, txt_direccionEmpleado.getText());
            
            ps.execute(); //Pasamos los valores a la Base de Datos
            
            JOptionPane.showMessageDialog(null, "EMPLEADO GUARDADO");
            //Pasamos los valores a la caja de texto
            Object[] fila = new Object[7];
            fila[0] = txt_codigoEmpleado.getText();
            fila[1] = txt_nombreEmpleado.getText();
            fila[2] = txt_telefonoEmpleado.getText();
            fila[3] = txt_dpiEmpleado.getText();
            fila[4] = txt_nitEmpleado.getText();
            fila[5] = txt_correoEmpleado.getText();
            fila[6] = txt_direccionEmpleado.getText();
            modelo.addRow(fila);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
