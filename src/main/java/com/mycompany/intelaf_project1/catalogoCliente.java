package com.mycompany.intelaf_project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joshua
 */
public class catalogoCliente {
    
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    public void mostrarDatosTabla(JTable catalogoTable, JTextField txt_buscarCatalogo, JComboBox cb_tiendaCatalogo, JComboBox cb_tipoOrden,
            JComboBox bn_ordenEnBase, JTextField txt_ordenCatalogo, JTextField txt_ordenEnBase){
        String productoTienda = "PRODUCTO" + String.valueOf(cb_tiendaCatalogo.getSelectedItem());
        //String productoTienda = String.valueOf(cb_productoTienda.getSelectedItem());
        String buscar = txt_buscarCatalogo.getText();
        String where = "";
         //Me permite buscar en la lista por medio del codigo del empleado al empleado
        if(!"".equals(buscar)){
            where = " WHERE codigo = '" + buscar + "' OR nombre = '" + buscar + "' OR fabricante = '" + buscar + "'";
            //" WHERE codigo = '" + buscar + "' OR nombre = '" + buscar + "' OR fabricante = '" + buscar + "'";
        }
        String ordenEnBase = txt_ordenEnBase.getText();
        String tipoOrden = txt_ordenCatalogo.getText();
        //El try me permite capturar el error que me sale por conexion
        //Tambien nos permite hacer la conexion con la DB para  mostrar los datos de la tabla empleados de
        //la DB en la tabla empleadosTable que tenemos en nuestra interfaz grafica
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            catalogoTable.setModel(modelo);
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            
            String sql = "SELECT * FROM " + productoTienda + where + " ORDER BY " + ordenEnBase + " " + tipoOrden; // aqui concatenar where
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
}
