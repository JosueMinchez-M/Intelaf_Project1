package com.mycompany.intelaf_project1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            if(lineaArray[0].equals("EMPLEADO")){
                    //---------
                    if(!(lineaArray[2].matches("[0-9]+"))){//++++++++++++++++++++++
                        cuadroTexto.append("--> El EMPLEADO con el DPI No. " + lineaArray[4] + ""
                                + "\nfue ignorado debido a ERROR en el CODIGO: \n"
                                + ""+ lineaArray[2]+" por no contener solo numeros\n\n");
                        
                    }
                    if(!(lineaArray[3].matches("[0-9]+"))){
                        cuadroTexto.append("--> El EMPLEADO con el DPI No. " + lineaArray[4] + ""
                                + "\nfue ignorado debido a ERROR en el TELEFONO: \n"
                                + ""+ lineaArray[3]+" por no contener solo numeros\n\n");
                    }
                    if(!(lineaArray[4].matches("[0-9]+"))){
                        cuadroTexto.append("--> El EMPLEADO con el DPI No. " + lineaArray[4] + ""
                                + "\nfue ignorado debido a ERROR en el DPI: \n"
                                + ""+ lineaArray[4]+" por no contener solo numeros\n\n");
                    }else{
                        insertarEmpleado();
                    }
                     //------
                    //insertarEmpleado();
                }
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
    //Cuenta el numero de lineas que contiene el archivo y lo devuelve en la variable numLines
//    public void numeroLineas(JTextField path){
//        File input = new File(path.getText());
//        try {
//            Scanner iterate = new Scanner(input);
//            numLines=0; 
//            while(iterate.hasNextLine()) { 
//                String currLine=iterate.nextLine(); numLines++; 
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ImportarDatos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    private  boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
}
