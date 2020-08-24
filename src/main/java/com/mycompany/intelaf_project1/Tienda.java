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
                //Aqui se coloca el nuevo codigo
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
            //CREA LA TABLA PODUCTOS DE LAS TIENDAS QUE SE CREAN
            if(res > 0){
                JOptionPane.showMessageDialog(null, "TIENDA GUARDADA");
                String sql1 = "CREATE TABLE PRODUCTO" + txt_nombreTienda.getText() + " (codigo VARCHAR(10) NOT NULL, nombre VARCHAR(30) NOT NULL, fabricante VARCHAR(30) NOT NULL,"
                + "cantidad_disponible INT(6) NOT NULL, precio DOUBLE NOT NULL, descripcion VARCHAR(200), garantia VARCHAR(3), Tienda_codigo VARCHAR(10) NOT NULL,"
                + "PRIMARY KEY(codigo), FOREIGN KEY(Tienda_codigo) REFERENCES TIENDA(codigo))";
                try {
                    Conexion con1 = new Conexion();
                    Connection acceso1 = con1.Conectar();
                    ps = acceso1.prepareStatement(sql1);
                    ps.execute();
                    acceso.close();
                    JOptionPane.showMessageDialog(null, "TABLA CREADA CON EXITO");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERROR AL CREAR TABLA");
                }
                
                String sqlpedido = "CREATE TABLE PEDIDO" + txt_nombreTienda.getText() + " (codigo INT(10) NOT NULL, tienda_origen VARCHAR(15) NOT NULL,"
                + "tienda_destino VARCHAR(15) NOT NULL, fecha DATE NOT NULL, cliente_nit VARCHAR(15) NOT NULL, producto_codigo VARCHAR(10) NOT NULL,"
                + "cantidad_articulos INT(10) NOT NULL, total_pagar DOUBLE NOT NULL, anticipo DOUBLE NOT NULL,"
                + "FOREIGN KEY(cliente_nit) REFERENCES CLIENTE(nit))";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sqlpedido);
            ps.execute();
            acceso.close();
            JOptionPane.showMessageDialog(null, "TABLA CREADA CON EXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CREAR TABLA");
        }
        
        String sqltiempo = "CREATE TABLE TIEMPO" + txt_nombreTienda.getText() + " (Tienda_codigo VARCHAR(30), tienda_destino VARCHAR(30) NOT NULL,"
                + "tiempo INT(10) NOT NULL, PRIMARY KEY(tienda_destino), FOREIGN KEY(Tienda_codigo) REFERENCES TIENDA(codigo))";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sqltiempo);
            ps.execute();
            acceso.close();
            JOptionPane.showMessageDialog(null, "TABLA CREADA CON EXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CREAR TABLA");
        }
        String sqlventa = "CREATE TABLE VENTA" + txt_nombreTienda.getText() + " (id INT NOT NULL AUTO_INCREMENT, fecha DATE NOT NULL,"
                + "cliente_nit VARCHAR(15) NOT NULL, producto_codigo VARCHAR(15) NOT NULL, cantidad_articulos INT(10) NOT NULL,"
                + "total_pagar DOUBLE NOT NULL, PRIMARY KEY(id), FOREIGN KEY(cliente_nit) REFERENCES CLIENTE(nit))";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sqlventa);
            ps.execute();
            acceso.close();
            JOptionPane.showMessageDialog(null, "TABLA CREADA CON EXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CREAR TABLA");
        }
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
    
    public void obtenerCodigoTienda(JComboBox cb_tiendaSeleccion, JTextField txt_tiendaCodigo){
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "SELECT codigo FROM TIENDA WHERE nombre = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, String.valueOf(cb_tiendaSeleccion.getSelectedItem()));
            rs = ps.executeQuery();
            
            while(rs.next()){
                txt_tiendaCodigo.setText(rs.getString("codigo"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public void compararCodigosTienda(JComboBox cb_tiendaSeleccion, JTextField text1, JTextField text2){
        Conexion con = new Conexion();
        Connection acceso = con.Conectar();
        String query = "SELECT codigo FROM TIENDA";
        try {
            ps = acceso.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                if(text1.getText().equals(rs.getString(1)) && !(rs.getString(1).equals(text2.getText()))){
                    
                }
                //cb_productoTienda.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
