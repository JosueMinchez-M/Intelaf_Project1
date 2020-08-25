package com.mycompany.intelaf_project1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
    
    DecimalFormat cortarDecimal = new DecimalFormat("#.00");
    PreparedStatement ps = null;
    ResultSet rs = null;
    double cantidadTotalPago = 0;
    
    public void mostrarDatosTabla(JTable ventaTable, JTextField txt_buscarVenta, JComboBox cb_tiendaSeleccionada){
        String venta = "VENTA" + String.valueOf(cb_tiendaSeleccionada.getSelectedItem());
        //String productoTienda = String.valueOf(cb_productoTienda.getSelectedItem());
        String buscar = txt_buscarVenta.getText();
        String where = "";
         //Me permite buscar en la lista por medio del codigo del empleado al empleado
        if(!"".equals(buscar)){
            where = " WHERE id = '" + buscar + "' OR cliente_nit = '" + buscar + "'";
        }
        //El try me permite capturar el error que me sale por conexion
        //Tambien nos permite hacer la conexion con la DB para  mostrar los datos de la tabla empleados de
        //la DB en la tabla empleadosTable que tenemos en nuestra interfaz grafica
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            ventaTable.setModel(modelo);
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            
            String sql = "SELECT * FROM " + venta + where + " ORDER BY id ASC"; // aqui concatenar where
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CODIGO TIENDA");
            modelo.addColumn("FECHA DE VENTA");
            modelo.addColumn("NIT CLIENTE");
            modelo.addColumn("CODIGO DE PRODUCTO");
            modelo.addColumn("CANTIDAD ARTICULOS");
            modelo.addColumn("TOTAL A PAGAR");
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
    
    public void registrarVenta(JTextField txt_codigoTiendaVenta, JTextField txt_fechaVenta, JTextField txt_nitClienteVenta,
        JComboBox cb_codigoProductoVenta, JTextField txt_cantArticulosVenta, JTextField txt_creditoClieteVenta, JComboBox cb_tiendaSeleccion){
        String comboBoxCodigoProductoPedido = String.valueOf(cb_codigoProductoVenta.getSelectedItem());
//        String comboBoxTiendaOrigenPedido = String.valueOf(cb_tiendaOrigenPedido.getSelectedItem());
        String ventaTienda = "VENTA" + String.valueOf(cb_tiendaSeleccion.getSelectedItem());
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "INSERT INTO " + ventaTienda + " (fecha, codigo_tienda, cliente_nit, producto_codigo, cantidad_articulos, total_pagar) VALUES(?, ?, ?, ?, ?, ?)";
            //Se toma la cantidad en existencia de articulos de cierto producto y se resta con los productos que se solicitan en el pedido
            //int restaProductoExistenteyPedido = cantidadArticulosDisponibles(cb_tiendaOrigenPedido, cb_codigoProductoPedido) - Integer.parseInt(txt_cantArticulosPedido.getText());
            //double cantidadTotalPago = Double.parseDouble(cortarDecimal.format(precioDeArticulosDisponibles(cb_tiendaOrigenPedido, cb_codigoProductoPedido) * Double.parseDouble(txt_cantArticulosPedido.getText())));
            //JOptionPane.showMessageDialog(null, cantidadTotalPago);
            //Con esta condicion determinamos que si un campo obligatorio es vacio no acepta el registro de la persona
            int restaProductoExistenteyPedido = articulosDisponibles(cb_tiendaSeleccion, cb_codigoProductoVenta) - Integer.parseInt(txt_cantArticulosVenta.getText());
            cantidadTotalPago = Double.parseDouble(cortarDecimal.format(precioDeArticulosDisponibles(cb_tiendaSeleccion, cb_codigoProductoVenta) * Double.parseDouble(txt_cantArticulosVenta.getText())));
            if(comboBoxCodigoProductoPedido.equals("") || txt_fechaVenta.getText().equals("") || txt_nitClienteVenta.getText().equals("")
                || cb_codigoProductoVenta.getSelectedItem().equals("") || txt_cantArticulosVenta.getText().equals("")){
            }else{
                guardarCantidadExistenteArticulos(cb_tiendaSeleccion, restaProductoExistenteyPedido, cb_codigoProductoVenta);
                ps = acceso.prepareStatement(sql);
                ps.setDate(1, Date.valueOf(txt_fechaVenta.getText()));
                ps.setString(2, txt_codigoTiendaVenta.getText());
                ps.setString(3, txt_nitClienteVenta.getText());
                ps.setString(4, String.valueOf(cb_codigoProductoVenta.getSelectedItem()));
                ps.setInt(5, Integer.parseInt(txt_cantArticulosVenta.getText()));
                ps.setDouble(6, cantidadTotalPago);
            }
            
            int res = ps.executeUpdate(); //Pasamos los valores a la Base de Datos
            if(res > 0){
                JOptionPane.showMessageDialog(null, "VENTA GUARDADA");
                //Pasamos los valores a la caja de texto
                Object[] fila = new Object[4];
                fila[0] = txt_fechaVenta.getText();
                fila[1] = txt_nitClienteVenta.getText();
                fila[2] = String.valueOf(cb_codigoProductoVenta.getSelectedItem());
                fila[3] = txt_cantArticulosVenta.getText();
                modelo.addRow(fila);
            }else{
                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR VENTA");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "                          EL CODIGO NO PUEDE REPETIRSE \n"
                    + "ES OBLIGATORIO LLENAR NOMBRE, FABRICANTE, CODIGO, CANTIDAD, PRECIO");
        }
        insertarCompraCliente(txt_codigoTiendaVenta, txt_fechaVenta, txt_nitClienteVenta, cb_codigoProductoVenta, txt_cantArticulosVenta, txt_creditoClieteVenta, cb_tiendaSeleccion);
    }
    
    public void mostrarProductoTienda(JComboBox cb_tiendaSeleccion, JComboBox cb_codigoProductoVenta){
        Conexion con = new Conexion();
        Connection acceso = con.Conectar();
        String tiendaSeleccion = String.valueOf(cb_tiendaSeleccion.getSelectedItem());
        String sql = "SELECT codigo FROM PRODUCTO" + tiendaSeleccion;
        try {
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            cb_codigoProductoVenta.removeAllItems();
            
            while (rs.next()) { 
                System.out.println(rs.getString(1));
                cb_codigoProductoVenta.addItem(rs.getString(1));
            }
            
            } catch (Exception e) {
       }
    }
    
    public int articulosDisponibles(JComboBox cb_tiendaSeleccion, JComboBox cb_codigoProductoVenta){
        int cantidadArticulos = 0;
        Conexion con = new Conexion();
        Connection acceso = con.Conectar();
        String nombreTienda = String.valueOf(cb_tiendaSeleccion.getSelectedItem());
        try {
            String sql1 = "SELECT cantidad_disponible FROM PRODUCTO" + nombreTienda + " WHERE codigo = ?";
                    
            ps = acceso.prepareStatement(sql1);
            ps.setString(1, String.valueOf(cb_codigoProductoVenta.getSelectedItem()));
            rs = ps.executeQuery();
            //cb_codigoProductoPedido.removeAllItems();
            while (rs.next()) { 
                System.out.println(rs.getString(1));
                cantidadArticulos = Integer.parseInt(rs.getString(1));
            }
        } catch (Exception e) {
            
        }
        return cantidadArticulos;
    }
    
    public double precioDeArticulosDisponibles(JComboBox cb_tiendaSeleccion, JComboBox cb_codigoProductoVenta){
        double precioArticulos = 0;
        Conexion con = new Conexion();
        Connection acceso = con.Conectar();
        String nombreTienda = String.valueOf(cb_tiendaSeleccion.getSelectedItem());
        try {
            String sql1 = "SELECT precio FROM PRODUCTO" + nombreTienda + " WHERE codigo = ?";
                    
            ps = acceso.prepareStatement(sql1);
            ps.setString(1, String.valueOf(cb_codigoProductoVenta.getSelectedItem()));
            rs = ps.executeQuery();
            //cb_codigoProductoPedido.removeAllItems();
            while (rs.next()) { 
                System.out.println(rs.getString(1));
                JOptionPane.showMessageDialog(null, rs.getString(1));
                precioArticulos = Double.parseDouble(rs.getString(1));
            }
        } catch (Exception e) {
        }
        return precioArticulos;
    }
    
    public void previstaTotalPagarVentas(JTextField txt_totalPagarVenta, JComboBox cb_tiendaSeleccion, JComboBox cb_codigoProductoVenta, JTextField txt_cantArticulosVenta){
        JOptionPane.showMessageDialog(null, precioDeArticulosDisponibles(cb_tiendaSeleccion, cb_codigoProductoVenta));
        if(txt_cantArticulosVenta.getText().equals("")|| cb_codigoProductoVenta.getSelectedItem().equals("CODIGO PRODUCTO")){
            
        }else{
            double cantidadTotalPago = precioDeArticulosDisponibles(cb_tiendaSeleccion, cb_codigoProductoVenta) * Double.parseDouble(txt_cantArticulosVenta.getText());
            txt_totalPagarVenta.setText(String.valueOf(cortarDecimal.format(cantidadTotalPago)));
        }
    }
    
    public void guardarCantidadExistenteArticulos(JComboBox cb_tiendaSeleccion, int cantidadDisponibleProducto, JComboBox cb_codigoProductoVenta){
        Conexion con = new Conexion();
        Connection acceso = con.Conectar();
        String nombreTienda = String.valueOf(cb_tiendaSeleccion.getSelectedItem());
                
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            String sql1 = "UPDATE PRODUCTO" + nombreTienda +" SET cantidad_disponible=? WHERE codigo=?";
            //Con esta condicion determinamos que si un campo obligatorio es vacio no acepta el registro de la persona

            ps = acceso.prepareStatement(sql1);
            ps.setInt(1, cantidadDisponibleProducto);
            ps.setString(2, String.valueOf(cb_codigoProductoVenta.getSelectedItem()));

            int res = ps.executeUpdate(); //Pasamos los valores a la Base de Datos
            if(res > 0){
                JOptionPane.showMessageDialog(null, "PRODUCTO GUARDADO");
                //Pasamos los valores a la caja de texto
                Object[] fila = new Object[1];
                fila[0] = cantidadDisponibleProducto;
                modelo.addRow(fila);
            }else{
                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR PRODUCTO");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "                          EL CODIGO NO PUEDE REPETIRSE \n"
                            + "ES OBLIGATORIO LLENAR NOMBRE, FABRICANTE, CODIGO, CANTIDAD, PRECIO");
        }
    }
    
    public void insertarCompraCliente(JTextField txt_codigoTiendaVenta, JTextField txt_fechaVenta, JTextField txt_nitClienteVenta,
        JComboBox cb_codigoProductoVenta, JTextField txt_cantArticulosVenta, JTextField txt_creditoClieteVenta, JComboBox cb_tiendaSeleccion){
        Conexion con = new Conexion();
        Connection acceso = con.Conectar();
        String sql = "INSERT INTO COMPRACLIENTE (codigo_tienda, fecha, cliente_nit, producto_codigo, cantidad_articulos, total_pagar) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            ps = acceso.prepareStatement(sql);
            ps.setString(1, txt_codigoTiendaVenta.getText());
            ps.setDate(2, Date.valueOf(txt_fechaVenta.getText()));
            ps.setString(3, txt_nitClienteVenta.getText());
            ps.setString(4, String.valueOf(cb_codigoProductoVenta.getSelectedItem()));
            ps.setInt(5, Integer.parseInt(txt_cantArticulosVenta.getText()));
            ps.setDouble(6, cantidadTotalPago);
            
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
    
    public void obtenerCodigoTienda(JComboBox cb_tiendaSeleccion, JTextField txt_codigoTiendaVenta){
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "SELECT codigo FROM TIENDA WHERE nombre = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, String.valueOf(cb_tiendaSeleccion.getSelectedItem()));
            rs = ps.executeQuery();
            
            while(rs.next()){
                txt_codigoTiendaVenta.setText(rs.getString("codigo"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    //Listado de todas las compras realizadas por un cliente
    public void mostrarListadoComprasClienteTabla(JTable reportesTable, JTextField txt_buscarReportes){
        //String productoTienda = String.valueOf(cb_productoTienda.getSelectedItem());
        String buscar = txt_buscarReportes.getText();
        String where = "";
         //Me permite buscar en la lista por medio del codigo del empleado al empleado
        if(!"".equals(buscar)){
            where = " WHERE codigo_tienda = '" + buscar + "' OR cliente_nit = '" + buscar + "'";
        }
        //El try me permite capturar el error que me sale por conexion
        //Tambien nos permite hacer la conexion con la DB para  mostrar los datos de la tabla empleados de
        //la DB en la tabla empleadosTable que tenemos en nuestra interfaz grafica
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            reportesTable.setModel(modelo);
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            
            String sql = "SELECT * FROM COMPRACLIENTE" + where + " ORDER BY id ASC"; // aqui concatenar where
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CODIGO TIENDA");
            modelo.addColumn("FECHA DE VENTA");
            modelo.addColumn("NIT CLIENTE");
            modelo.addColumn("CODIGO DE PRODUCTO");
            modelo.addColumn("CANTIDAD ARTICULOS");
            modelo.addColumn("TOTAL A PAGAR");
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
}
