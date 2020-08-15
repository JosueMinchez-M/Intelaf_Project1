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
public class Tienda {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void mostrarDatosTabla(JTable tiendaTable, JTextField txt_buscarTienda){
        String buscar = txt_buscarTienda.getText();
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
            tiendaTable.setModel(modelo);
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            
            String sql = "SELECT * FROM TIENDA " + where + " ORDER BY codigo ASC"; // aqui concatenar where
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("CODIGO");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("DIRECCION");
            modelo.addColumn("TELEFONO 1");
            modelo.addColumn("TELEFONO 2");
            modelo.addColumn("CORREO ELECTRONICO");
            modelo.addColumn("HORARIO");
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
    /*Permite pasar los datos de la tienda a las casillas en donde se pueden modificar
      solo se agregan los datos que son posible modificar, asi como el codigo y dpi no se agregan
      porque son datos que no cambiaran*/
    public void pasarDatosComponentes(JTable tiendaTable, JTextField txt_nombreTienda, JTextField txt_telefono1Tienda, JTextField txt_telefono2Tienda,
            JTextField txt_codigoTienda, JTextField txt_horarioTienda, JTextField txt_correoTienda, JTextField txt_direccionTienda){
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            int Fila = tiendaTable.getSelectedRow();//permite pasar los datos de cada trabajador
            String codigo = tiendaTable.getValueAt(Fila, 0).toString();
            String sql = "SELECT * FROM TIENDA WHERE codigo = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            
            while(rs.next()){
                txt_nombreTienda.setText(rs.getString("nombre"));
                txt_telefono1Tienda.setText(rs.getString("telefono_1"));
                txt_telefono2Tienda.setText(rs.getString("telefono_2"));
                txt_correoTienda.setText(rs.getString("correo_electronico"));
                txt_direccionTienda.setText(rs.getString("direccion"));
                txt_codigoTienda.setText(rs.getString("codigo"));
                txt_horarioTienda.setText(rs.getString("Horario"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public void guardarNuevasTiendas(JTextField txt_nombreTienda, JTextField txt_telefono1Tienda, JTextField txt_telefono2Tienda,
            JTextField txt_codigoTienda, JTextField txt_horarioTienda, JTextField txt_correoTienda, JTextField txt_direccionTienda){
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "INSERT INTO TIENDA (codigo, nombre, direccion, telefono_1, telefono_2, correo_electronico, Horario) VALUES(?, ?, ?, ?, ?, ?, ?)";
            //Con esta condicion determinamos si los campos obligatorios estan vacios no ingresamos el registro a la DB
            if(txt_nombreTienda.getText().equals("") || txt_direccionTienda.getText().equals("") || 
                    txt_codigoTienda.getText().equals("") || txt_telefono1Tienda.getText().equals("")){
                
            }else{
                ps = acceso.prepareStatement(sql);
                ps.setString(1, txt_codigoTienda.getText());
                ps.setString(2, txt_nombreTienda.getText());
                ps.setString(3, txt_direccionTienda.getText());
                ps.setString(4, txt_telefono1Tienda.getText());
                ps.setString(5, txt_telefono2Tienda.getText());
                ps.setString(6, txt_correoTienda.getText());
                ps.setString(7, txt_horarioTienda.getText());
            }
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                JOptionPane.showMessageDialog(null, "TIENDA GUARDADA");
                //Pasamos los valores a la caja de texto
                Object[] fila = new Object[7];
                fila[0] = txt_codigoTienda.getText();
                fila[1] = txt_nombreTienda.getText();
                fila[2] = txt_direccionTienda.getText();
                fila[3] = txt_telefono1Tienda.getText();
                fila[4] = txt_telefono2Tienda.getText();
                fila[5] = txt_correoTienda.getText();
                fila[6] = txt_horarioTienda.getText();
                modelo.addRow(fila);
            }else{
                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR TIENDA");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "ES OBLIGATORIO LLENAR NOMBRE, DIRECCION, CODIGO Y TELEFONO 1");
        }
    }
}
