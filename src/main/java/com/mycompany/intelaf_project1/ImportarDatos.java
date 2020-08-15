package com.mycompany.intelaf_project1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author joshua
 */
public class ImportarDatos {
    
    PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Connection acceso;
    String lineaArray[];
    String palabrasExtras[];
    int numLines;
    String lineas[];
    
    public void Importar(JTextField path, JTextArea cuadroTexto){
        try {
            for (String line : Files.readAllLines(Paths.get(path.getText()))) {//-------------
            String lineas = line;
            //System.out.println(line);
            lineaArray = lineas.split(",");
            palabrasExtras = lineaArray[1].split(" ");
            //Separamos las palabras extras como TIENDA o NOMBRE de las columnas nombres de algunos atributos
            if(palabrasExtras.length == 2){
                lineaArray[1] = palabrasExtras[1];
                //JOptionPane.showMessageDialog(null, lineaArray[1]);
            }
            
            for (int i = 0; i < lineaArray.length; i++) {
                System.out.print(lineaArray[i] + "  ");
            }
            errorIngresarDatos(cuadroTexto);
            System.out.print("\n");
            }
        } catch (Exception e) {
            
        }
//        if(lineaArray[0].equals("EMPLEADO")){
//            insertarEmpleado();
//        }
    }
    
    public void insertarEmpleado(){
        //JOptionPane.showMessageDialog(null, "ESTA ES LA ULTIMA TABLA " + lineaArray[0]);
        String sql = "INSERT INTO "+ lineaArray[0] +" (nombre, codigo, telefono, dpi, nit, correo_electronico, direccion) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, lineaArray[1]);
            ps.setInt(2, Integer.parseInt(lineaArray[2]));
            ps.setString(3, lineaArray[3]);
            ps.setString(4, lineaArray[4]);
            ps.setString(5, "N/E");
            ps.setString(6, "N/E");
            ps.setString(7, "N/E");
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
    
    public void insertarTienda(){
        //JOptionPane.showMessageDialog(null, "ESTA ES LA ULTIMA TABLA " + lineaArray[0]);
        String sql = "INSERT INTO "+ lineaArray[0] +" (nombre, direccion, codigo, telefono_1, telefono_2, correo_electronico) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, lineaArray[1]);
            ps.setString(2, lineaArray[2]);
            ps.setString(3, lineaArray[3]);
            ps.setString(4, lineaArray[4]);
            ps.setString(5, "N/E");
            ps.setString(6, "N/E");
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
    public void insertarProducto(){
        String sql = "INSERT INTO "+ lineaArray[0] +" (nombre, fabricante, codigo, cantidad_disponible, precio, descripcion, garantia, Tienda_codigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, lineaArray[1]);
            ps.setString(2, lineaArray[2]);
            ps.setString(3, lineaArray[3]);
            ps.setString(4, lineaArray[4]);
            ps.setString(5, lineaArray[5]);
            ps.setString(6, "N/E");
            ps.setString(7, "N/E");
            ps.setString(8, lineaArray[6]);
            
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
    
    public void insertarCliente(){
        String sql = "INSERT INTO "+ lineaArray[0] +" (nombre, nit, telefono, credito_compra, dpi, correo_electronico, direccion) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, lineaArray[1]);
            ps.setString(2, lineaArray[2]);
            ps.setString(3, lineaArray[3]);
            ps.setInt(4, Integer.parseInt(lineaArray[4]));
            ps.setString(5, "N/E");
            ps.setString(6, "N/E");
            ps.setString(7, "N/E");
            
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
    public void insertarPedido(){
        String sql = "INSERT INTO "+ lineaArray[0] +" (codigo, tienda_origen, tienda_destino, fecha, Cliente_nit, Producto_codigo, cantidad_articulos, total_pagar, anticipo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, lineaArray[1]);
            ps.setString(2, lineaArray[2]);
            ps.setString(3, lineaArray[3]);
            ps.setString(4, lineaArray[4]);
            ps.setString(5, lineaArray[5]);
            ps.setString(6, lineaArray[6]);
            ps.setString(7, lineaArray[7]);
            ps.setString(8, lineaArray[8]);
            ps.setString(9, lineaArray[9]);
            
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
    public void errorIngresarDatos(JTextArea cuadroTexto){
        if(lineaArray[0].equals("EMPLEADO")){
            //---------
            if(!(lineaArray[2].matches("[0-9]+"))){//++++++++++++++++++++++
                cuadroTexto.append("--> El EMPLEADO con el DPI No. " + lineaArray[4] + ""
                    + "\nfue ignorado debido a ERROR en el CODIGO: \n"
                    + ""+ lineaArray[2]+" por no seguir el patron del codigo.\n\n");
            }else{
                insertarEmpleado();
            }if(!(lineaArray[3].matches("[0-9]+"))){
                cuadroTexto.append("--> El EMPLEADO con el DPI No. " + lineaArray[4] + ""
                    + "\nfue ignorado debido a ERROR en el TELEFONO: \n"
                    + ""+ lineaArray[3]+" por no contener solo numeros.\n\n");
            }else{
                insertarEmpleado();
            }if(!(lineaArray[4].matches("[0-9]+"))){
                cuadroTexto.append("--> El EMPLEADO con el DPI No. " + lineaArray[4] + ""
                + "\nfue ignorado debido a ERROR en el DPI: \n"
                + ""+ lineaArray[4]+" por no contener solo numeros.\n\n");
            }else{
                insertarEmpleado();
            }
        }else if(lineaArray[0].equals("TIENDA")){
            if(!(lineaArray[3].matches(".*ABC-*." + "[0-9]+")) || !(lineaArray[4].matches("[0-9]+"))){//lineaArray[3].matches("ABC-" + "[0-9]+")
                cuadroTexto.append("--> La TIENDA con el NOMBRE: " + lineaArray[1] + ""
                + "\nfue ignorada debido a INCOPATIBILIDAD en sus datos.\n\n");
            }else{
                insertarTienda();
            }
        }else if(lineaArray[0].equals("PRODUCTO")){
            Pattern patP3 = Pattern.compile("[A-Z]{3,3}"+"-"+"[0-9]{3,4}");
            Matcher matP3 = patP3.matcher(lineaArray[3]);
            if(!(matP3.matches())){
                cuadroTexto.append("--> El PRODUCTO con el CODIGO: " + lineaArray[3] + "\n"
                + "para la TIENDA: " + lineaArray[6] + " fue ignorado debido a"
                + "\nINCOPATIBILIDAD en sus datos.\n\n");
            }else{
                insertarProducto();
            }
        }else if(lineaArray[0].equals("CLIENTE")){
            Pattern patC3 = Pattern.compile("[A-Z]{1,1}"+"-"+"[0-9]{4,4}");
            Matcher matC3 = patC3.matcher(lineaArray[2]);
            if(!(matC3.matches()) || !(lineaArray[3].matches("[0-9]+"))){
                cuadroTexto.append("--> El CLIENTE con el NIT: " + lineaArray[2] + " fue ignorado\n"
                + "debido a INCOPATIBILIDAD en sus datos.\n\n");
            }else{
                insertarCliente();
            }
        }else if(lineaArray[0].equals("PEDIDO")){
            insertarPedido();
        }
    }
}
