package com.mycompany.intelaf_project1;

import com.mycompany.intelaf_project1.UI.trabajador.IngresarDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public void ListadoPedidosEnCursoCliente(JTable reportesTable, JTextField txt_buscarReportes){
        //String productoTienda = String.valueOf(cb_productoTienda.getSelectedItem());
        String buscar = txt_buscarReportes.getText();
        String where = "";
         //Me permite buscar en la lista por medio del codigo del empleado al empleado
        if(!"".equals(buscar)){
            where = " cliente_nit = '" + buscar + "'";
        }
        //El try me permite capturar el error que me sale por conexion
        //Tambien nos permite hacer la conexion con la DB para  mostrar los datos de la tabla empleados de
        //la DB en la tabla empleadosTable que tenemos en nuestra interfaz grafica
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            reportesTable.setModel(modelo);
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            
            String sql = "SELECT * FROM PEDIDO WHERE "+ where + " tiempo_envio <> '0' ORDER BY id ASC"; // aqui concatenar where
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
//    //NUEVOS METODOS CLIENTE
//    public void usoCreditoCliente(JTextField txt_nitClientePedido){
//        Conexion con = new Conexion();
//        Connection acceso = con.Conectar();
//        String query = "SELECT credito_compra FROM CLIENTE WHERE nit = '" + txt_nitClientePedido.getText() + "'";
//        try {
//            ps = acceso.prepareStatement(query);
//            rs = ps.executeQuery();
//            //cb_codigoTiendaOrigenPedido.removeAllItems();
//            while(rs.next()){//rs.getString(1)
//                if(rs.getDouble(1) <= 0){
//                    JOptionPane.showMessageDialog(null, "¡NO TIENES CREDITO DISPONIBLE!");
//                }else{
//                    JOptionPane.showMessageDialog(null, "TU CRÉDITO DISPONIBLE ES = " + rs.getInt(1));
//                    double creditoIngresado = Double.parseDouble(JOptionPane.showInputDialog(null, "|||INGRESA EL CRÉDITO QUE USARÁS|||"));
//                    if(creditoIngresado >= 0 && creditoIngresado <= rs.getInt(1)){
//                        double restaCredito = rs.getDouble(1) - creditoIngresado;
//                        guardarNuevoCreditoCliente(txt_nitClientePedido, restaCredito);
//                    }else{
//                        JOptionPane.showMessageDialog(null, "SOLO TIENES DE CRÉDITO DISPONIBLE: " + rs.getInt(1));
//                    }
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void guardarNuevoCreditoCliente(JTextField txt_nitClientePedido, double creditoIngresado){
//            Conexion con = new Conexion();
//            Connection acceso = con.Conectar();
//                
//                try {
//                    DefaultTableModel modelo = new DefaultTableModel();
//                    String sql1 = "UPDATE CLIENTE SET credito_compra=? WHERE nit=?";
//                    //Con esta condicion determinamos que si un campo obligatorio es vacio no acepta el registro de la persona
//
//                        ps = acceso.prepareStatement(sql1);
//                        ps.setDouble(1, creditoIngresado);
//                        ps.setString(2, txt_nitClientePedido.getText());
//
//                    int res = ps.executeUpdate(); //Pasamos los valores a la Base de Datos
//                    if(res > 0){
//                        JOptionPane.showMessageDialog(null, "PRODUCTO GUARDADO");
//                        //Pasamos los valores a la caja de texto
//                        Object[] fila = new Object[1];
//                        fila[0] = creditoIngresado;
//                        modelo.addRow(fila);
//                    }else{
//                        JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR PRODUCTO");
//                    }
//                } catch (Exception e) {
//                    System.out.println(e.toString());
//                    JOptionPane.showMessageDialog(null, "                          EL CODIGO NO PUEDE REPETIRSE \n"
//                            + "ES OBLIGATORIO LLENAR NOMBRE, FABRICANTE, CODIGO, CANTIDAD, PRECIO");
//                }
//    }
}
