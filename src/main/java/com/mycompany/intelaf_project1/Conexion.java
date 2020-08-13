package com.mycompany.intelaf_project1;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author joshua
 */
public class Conexion {
    
    Connection con;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/Intelaf_BD";
    String user = "root";
    String pass = "root";
    
    public Connection Conectar(){
        con = null;
        try {//com.mysql.jdbc.Driver
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,pass);
            if(con != null){
                System.out.println("CONEXION ESTABLECIDA");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO SE A PODIDO CONECTAR CON LA BASE DE DATOS");
        }
        return con;
    }
}
