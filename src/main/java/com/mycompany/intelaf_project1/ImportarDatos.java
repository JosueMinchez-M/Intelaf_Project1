package com.mycompany.intelaf_project1;

import com.mycompany.intelaf_project1.UI.trabajador.IngresarDatos;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    String palabrasExtras1[];
    String palabrasExtras2[];
    int numLines;
    int contTienda = 0;
    String lineas[];
    
    public void Importar(JTextField path, JTextArea cuadroTexto){
        try {
            for (String line : Files.readAllLines(Paths.get(path.getText()))) {//-------------
            String lineas = line;
            //System.out.println(line);
            lineaArray = lineas.split(",");
            palabrasExtras1 = lineaArray[1].split(" ");
            //Separamos las palabras extras como TIENDA o NOMBRE de las columnas nombres de algunos atributos
            if(palabrasExtras1.length == 2){
                lineaArray[1] = palabrasExtras1[1];
                //JOptionPane.showMessageDialog(null, lineaArray[1]);
            }
            palabrasExtras2 = lineaArray[2].split(" ");
            if(palabrasExtras2.length == 2){
                lineaArray[2] = palabrasExtras2[1];
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
    //Insertar empleado está bien
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
    //Insertar Tienda esta bien
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
        //Con este metodo se insertan los productos en la tabla que le pertenece a cada tienda
        //Se hace por medio de la columna Tienda_codigo comparandola con la tabla TIENDA
        String nombreTienda = null;
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "SELECT nombre FROM TIENDA WHERE codigo = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, lineaArray[6]);
            rs = ps.executeQuery();
            
            while(rs.next()){
                nombreTienda = rs.getString("nombre");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        //Agregamos las tiendas creadas en el combobox para hacer uso de ellas
        String sql = "INSERT INTO PRODUCTO"+ nombreTienda +" (nombre, fabricante, codigo, cantidad_disponible, precio, descripcion, garantia, Tienda_codigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, lineaArray[1]);
            ps.setString(2, lineaArray[2]);
            ps.setString(3, lineaArray[3]);
            ps.setString(4, lineaArray[4]);
            ps.setDouble(5, Double.parseDouble(lineaArray[5]));
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
    public void insertarTiempo(){
        //JOptionPane.showMessageDialog(null, "ESTA ES LA ULTIMA TABLA " + lineaArray[0]);
        String nombreTienda = null;
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "SELECT nombre FROM TIENDA WHERE codigo = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, lineaArray[1]);
            rs = ps.executeQuery();
            
            while(rs.next()){
                nombreTienda = rs.getString("nombre");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        String sql = "INSERT INTO TIEMPO"+ nombreTienda +" (Tienda_codigo, tienda_destino, tiempo) VALUES(?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, lineaArray[1]);
            ps.setString(2, lineaArray[2]);
            ps.setInt(3, Integer.parseInt(lineaArray[3]));
            int res = ps.executeUpdate();
            if(res > 0){
                //JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO");
                System.out.println("GUARDANDO TIEMPOS DE TIENDAA");
            }else{
                //JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
                System.out.println("ERROR AL GUARDAR TIEMPOS DE TIENDA");
            }
            //acceso.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Debes llenar los datos que se te piden");
        }
    }
    //Insertar cliente esta bien
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
        String nombreTienda = null;
        String otroNombreTienda = null;
        int diaEnvio = 0;
        Date fechaModificada = null;
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "SELECT nombre FROM TIENDA WHERE codigo = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, lineaArray[2]);
            rs = ps.executeQuery();
            
            while(rs.next()){
                otroNombreTienda = rs.getString("nombre");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        String query = "SELECT tiempo FROM TIEMPO" + otroNombreTienda + " WHERE Tienda_codigo = '" + lineaArray[2] + "' AND tienda_destino = '" + lineaArray[3] + "'";
            try {
                ps = acceso.prepareStatement(query);
                rs = ps.executeQuery();
                while(rs.next()){
                        //cb_tiendaCatalogo.addItem(rs.getString(1));
                    if(rs.getInt(1) >= 0){
                        diaEnvio = rs.getInt(1);
                        JOptionPane.showMessageDialog(null, diaEnvio);
                    }else{
                        diaEnvio = 0;
                        JOptionPane.showMessageDialog(null, diaEnvio);
                    }
                    //cb_productoTienda.addItem(rs.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String query1 = "SELECT date_add(DATE('" + lineaArray[4] + "'), INTERVAL "+ diaEnvio +" DAY);";
        try {
            ps = acceso.prepareStatement(query1);
            rs = ps.executeQuery();
            while(rs.next()){
                   // cb_tiendaCatalogo.addItem(rs.getString(1));
                   fechaModificada = rs.getDate(1);
                //cb_productoTienda.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngresarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try {
            Conexion con = new Conexion();
            Connection acceso = con.Conectar();
            String sql = "SELECT nombre FROM TIENDA WHERE codigo = ?";
            
            ps = acceso.prepareStatement(sql);
            ps.setString(1, lineaArray[3]);
            rs = ps.executeQuery();
            
            while(rs.next()){
                nombreTienda = rs.getString("nombre");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        String sql = "INSERT INTO PEDIDO"+ nombreTienda +" (codigo, tienda_origen, tienda_destino, fecha, cliente_nit, producto_codigo, cantidad_articulos, total_pagar, anticipo, tiempo_envio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(lineaArray[1]));
            ps.setString(2, lineaArray[2]);
            ps.setString(3, lineaArray[3]);
            ps.setString(4, lineaArray[4]);
            ps.setString(5, lineaArray[5]);
            ps.setString(6, lineaArray[6]);
            ps.setInt(7, Integer.parseInt(lineaArray[7]));
            ps.setDouble(8, Double.parseDouble(lineaArray[8]));
            ps.setDouble(9, Double.parseDouble(lineaArray[9]));
            ps.setDate(10, fechaModificada);
            
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
        
        String sql1 = "INSERT INTO PEDIDO (codigo, tienda_origen, tienda_destino, fecha, cliente_nit, producto_codigo, cantidad_articulos, total_pagar, anticipo, tiempo_envio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql1);
            ps.setInt(1, Integer.parseInt(lineaArray[1]));
            ps.setString(2, lineaArray[2]);
            ps.setString(3, lineaArray[3]);
            ps.setString(4, lineaArray[4]);
            ps.setString(5, lineaArray[5]);
            ps.setString(6, lineaArray[6]);
            ps.setInt(7, Integer.parseInt(lineaArray[7]));
            ps.setDouble(8, Double.parseDouble(lineaArray[8]));
            ps.setDouble(9, Double.parseDouble(lineaArray[9]));
            ps.setDate(10, fechaModificada);
            
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
                //Se necesita para comparar el codigo de tienda entre tienda y producto
                insertarTienda();
                crearTablaProductoTienda();
                crearTablaTiempoTienda();
                crearTablaPedidoTienda();
                crearTablaVentaTienda();
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
        }else if(lineaArray[0].equals("TIEMPO")){
            insertarTiempo();
        }
    }
    public void crearTablaProductoTienda(){
        String sql = "CREATE TABLE PRODUCTO" + lineaArray[1] + " (codigo VARCHAR(10) NOT NULL, nombre VARCHAR(30) NOT NULL, fabricante VARCHAR(30) NOT NULL,"
                + "cantidad_disponible INT(6) NOT NULL, precio DOUBLE NOT NULL, descripcion VARCHAR(200), garantia VARCHAR(3), Tienda_codigo VARCHAR(10) NOT NULL,"
                + "PRIMARY KEY(codigo), FOREIGN KEY(Tienda_codigo) REFERENCES TIENDA(codigo))";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.execute();
            acceso.close();
            //JOptionPane.showMessageDialog(null, "TABLA CREADA CON EXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CREAR TABLA");
        }
    }
    public void crearTablaTiempoTienda(){
        String sql = "CREATE TABLE TIEMPO" + lineaArray[1] + " (Tienda_codigo VARCHAR(30), tienda_destino VARCHAR(30) NOT NULL,"
                + "tiempo INT(10) NOT NULL, PRIMARY KEY(tienda_destino), FOREIGN KEY(Tienda_codigo) REFERENCES TIENDA(codigo))";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.execute();
            acceso.close();
            //JOptionPane.showMessageDialog(null, "TABLA CREADA CON EXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CREAR TABLA");
        }
    }
    
    public void crearTablaPedidoTienda(){
        String sql = "CREATE TABLE PEDIDO" + lineaArray[1] + " (id INT NOT NULL AUTO_INCREMENT, "
                + "codigo INT(10) NOT NULL, tienda_origen VARCHAR(15) NOT NULL,"
                + "tienda_destino VARCHAR(15) NOT NULL, fecha DATE NOT NULL, cliente_nit VARCHAR(15) NOT NULL, producto_codigo VARCHAR(10) NOT NULL,"
                + "cantidad_articulos INT(10) NOT NULL, total_pagar DOUBLE NOT NULL, anticipo DOUBLE NOT NULL, tiempo_envio DATE NOT NULL,"
                + "PRIMARY KEY(id), FOREIGN KEY(cliente_nit) REFERENCES CLIENTE(nit))";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.execute();
            acceso.close();
            //JOptionPane.showMessageDialog(null, "TABLA CREADA CON EXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CREAR TABLA");
        }
    }
    
    public void crearTablaVentaTienda(){
        String sql = "CREATE TABLE VENTA" + lineaArray[1] + " (id INT NOT NULL AUTO_INCREMENT, codigo_tienda VARCHAR(15) NOT NULL, fecha DATE NOT NULL,"
                + "cliente_nit VARCHAR(15) NOT NULL, producto_codigo VARCHAR(15) NOT NULL, cantidad_articulos INT(10) NOT NULL,"
                + "total_pagar DOUBLE NOT NULL, PRIMARY KEY(id), FOREIGN KEY(cliente_nit) REFERENCES CLIENTE(nit))";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.execute();
            acceso.close();
            //JOptionPane.showMessageDialog(null, "TABLA CREADA CON EXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL CREAR TABLA");
        }
    }
}
