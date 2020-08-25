package com.mycompany.intelaf_project1;

import com.mycompany.intelaf_project1.UI.trabajador.IngresarDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
public class TiempoTras {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void mostrarDatosTabla(JTable TiempoTable, JTextField txt_buscarTiempo, JComboBox cb_tiendaSeleccionada){
        String tiempoTienda = "TIEMPO" + String.valueOf(cb_tiendaSeleccionada.getSelectedItem());
        //String productoTienda = String.valueOf(cb_productoTienda.getSelectedItem());
        String buscar = txt_buscarTiempo.getText();
        String where = "";
         //Me permite buscar en la lista por medio del codigo del empleado al empleado
        if(!"".equals(buscar)){
            where = " WHERE Tienda_codigo = '" + buscar + "' OR tienda_destino = '" + buscar + "'";
        }
        //El try me permite capturar el error que me sale por conexion
        //Tambien nos permite hacer la conexion con la DB para  mostrar los datos de la tabla empleados de
        //la DB en la tabla empleadosTable que tenemos en nuestra interfaz grafica
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            TiempoTable.setModel(modelo);
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            
            String sql = "SELECT * FROM " + tiempoTienda + where; // aqui concatenar where
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("TIENDA ORIGEN");
            modelo.addColumn("TIENDA DESTINO");
            modelo.addColumn("TIEMPO EN DIAS");
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
    
    public void pasarDatosComponentes(JTable tiempoTable, JComboBox cb_tiendaSeleccion, JTextField txt_tiendaOrigenTiempo,
            JComboBox cb_tiendaDestinoTiempo, JTextField txt_tiempo){
        String tiempoTienda = "TIEMPO" + String.valueOf(cb_tiendaSeleccion.getSelectedItem());
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            int Fila = tiempoTable.getSelectedRow();//permite pasar los datos de cada trabajador
            System.out.println(Fila);
            String codigo = tiempoTable.getValueAt(Fila, 1).toString();
            String sql = "SELECT * FROM " + tiempoTienda + " WHERE tienda_destino = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            
            while(rs.next()){
                txt_tiendaOrigenTiempo.setText(rs.getString("Tienda_codigo"));
                cb_tiendaDestinoTiempo.setSelectedItem(rs.getString("tienda_destino"));
                txt_tiempo.setText(rs.getString("tiempo"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void guardarNuevosTiempo(JTable tiempoTable, JComboBox cb_tiendaSeleccion, JTextField txt_tiendaOrigenTiempo,
            JComboBox cb_tiendaDestinoTiempo, JTextField txt_tiempo){
        String comboBoxTiendaDestino = String.valueOf(cb_tiendaDestinoTiempo.getSelectedItem());
        String tiempoTienda = "TIEMPO" + String.valueOf(cb_tiendaSeleccion.getSelectedItem());
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "INSERT INTO " + tiempoTienda + " (Tienda_codigo, tienda_destino, tiempo) VALUES(?, ?, ?)";
            //Con esta condicion determinamos que si un campo obligatorio es vacio no acepta el registro de la persona
            if(comboBoxTiendaDestino.equals("") || txt_tiendaOrigenTiempo.getText().equals("") || txt_tiempo.getText().equals("")){
            }else{
                
                ps = acceso.prepareStatement(sql);
                ps.setString(1, txt_tiendaOrigenTiempo.getText());
                ps.setString(2, comboBoxTiendaDestino);
                ps.setString(3, txt_tiempo.getText());
            }
            
            boolean res = ps.execute(); //Pasamos los valores a la Base de Datos
            if(res == false){
                JOptionPane.showMessageDialog(null, "TIEMPO GUARDADO");
                //Pasamos los valores a la caja de texto
                Object[] fila = new Object[3];
                fila[0] = txt_tiendaOrigenTiempo.getText();
                fila[1] = comboBoxTiendaDestino;
                fila[2] = txt_tiempo.getText();
                modelo.addRow(fila);
            }else{
                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR TIEMPO");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "NO PUEDES VOLVER A INGRESAR UNA TIENDA\n"
                                              + "                             O\n"
                                              + "   INGRESASTE CARACTERES NO VALIDOS");
        }
    }
    
    public void modificarTiempo( JComboBox cb_tiendaSeleccion, JComboBox cb_tiendaDestinoTiempo ,JTextField txt_tiempo){
        String comboBoxTiendaDestino = String.valueOf(cb_tiendaDestinoTiempo.getSelectedItem());
        String tiempoTienda = "TIEMPO" + String.valueOf(cb_tiendaSeleccion.getSelectedItem());
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "UPDATE " + tiempoTienda +" SET tiempo=? WHERE tienda_destino=?";
            ps = acceso.prepareStatement(sql);
            ps.setString(1, txt_tiempo.getText());
            ps.setString(2, comboBoxTiendaDestino);
            
            int res = ps.executeUpdate(); //Pasamos los valores a la Base de Datos
            if(res > 0){
                JOptionPane.showMessageDialog(null, "TIEMPO MODIFICADO");
                //Con esto podemos ver nuevamente en la tabla de la lista los datos actualizados
                Object[] fila = new Object[1];
                fila[0] = txt_tiempo.getText();
                modelo.addRow(fila);

            }else{
                JOptionPane.showMessageDialog(null, "LAS CASILLAS ESTAN VACIAS");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "¡NO SE GUARDO!, INGRESASTE UN CARACTER NO VALIDO");
        }
    }
    
    public void cargarTiendasBD(JComboBox cb_tiendaDestinoTiempo, JTextField txt_tiendaOrigenTiempo){
        Conexion con = new Conexion();
        Connection acceso = con.Conectar();
        String query = "SELECT codigo FROM TIENDA";
        try {
            ps = acceso.prepareStatement(query);
            rs = ps.executeQuery();
            cb_tiendaDestinoTiempo.removeAllItems();
            while(rs.next()){
                if(txt_tiendaOrigenTiempo.getText().equals(rs.getString(1))){
                    //cb_tiendaDestinoTiempo.addItem(rs.getString(1));
                }else{
                    cb_tiendaDestinoTiempo.addItem(rs.getString(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void saberTiempoEnvioDias(JComboBox cb_tiendaOrigenPedido, JTextField txt_tiendaDestinoPedido){
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
                    String sqltiempo = "SELECT tiempo FROM TIEMPO" + nombreTienda + " WHERE tienda_codigo = ? AND tienda_destino = ?";

                    ps = acceso.prepareStatement(sqltiempo);
                    ps.setString(1, String.valueOf(cb_tiendaOrigenPedido.getSelectedItem()));
                    ps.setString(2, txt_tiendaDestinoPedido.getText());
                    rs = ps.executeQuery();
                    
                    while(rs.next()){
                        String tiempoEnvio = rs.getString(1);
                        
                    }
                } catch (Exception e) {
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
