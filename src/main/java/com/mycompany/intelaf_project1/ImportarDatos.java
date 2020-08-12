package com.mycompany.intelaf_project1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.BorderUIResource;


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
    int numLines;
    String lineas[];
    
    public void Importar(JTextField path, JTextArea cuadroTexto){
        //JTextField clave, JTextField nombre, JTextField domicilio, JTextField telefono, JTextField correo, JTextField nacimiento, JComboBox genero, JTextField id
//        numeroLineas(path);
        try {
//            List prueba = Files.readAllLines(Paths.get(path.getText()));
//            for (int i = 0; i < prueba.size(); i++) {
//                lineas[i] = (String) prueba.get(i);
//            }
            for (String line : Files.readAllLines(Paths.get(path.getText()))) {//-------------
            String lineas = line;
            //System.out.println(line);
            lineaArray = lineas.split(",");
            
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
            ps.setString(2, lineaArray[2]);
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
    
    public void errorIngresarDatos(JTextArea cuadroTexto){
        if(lineaArray[0].equals("EMPLEADO")){
            //---------
            if(!(lineaArray[2].matches("[0-9]+"))){//++++++++++++++++++++++
                cuadroTexto.append("--> El EMPLEADO con el DPI No. " + lineaArray[4] + ""
                    + "\nfue ignorado debido a ERROR en el CODIGO: \n"
                    + ""+ lineaArray[2]+" por no contener solo numeros\n\n");
            }else{
                insertarEmpleado();
            }if(!(lineaArray[3].matches("[0-9]+"))){
                cuadroTexto.append("--> El EMPLEADO con el DPI No. " + lineaArray[4] + ""
                    + "\nfue ignorado debido a ERROR en el TELEFONO: \n"
                    + ""+ lineaArray[3]+" por no contener solo numeros\n\n");
            }else{
                insertarEmpleado();
            }if(!(lineaArray[4].matches("[0-9]+"))){
                cuadroTexto.append("--> El EMPLEADO con el DPI No. " + lineaArray[4] + ""
                + "\nfue ignorado debido a ERROR en el DPI: \n"
                + ""+ lineaArray[4]+" por no contener solo numeros\n\n");
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
        }
    }
}
