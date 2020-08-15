package com.mycompany.intelaf_project1;

/**
 *
 * @author joshua
 */
public class ValidarEmpleado {
    
    private int codigo;
    private String nombre;
    private String telefono;
    private String dpi;
    private String nit;
    private String correoElectronico;
    private String direccion;
    
    public ValidarEmpleado(){
        
    }

    public ValidarEmpleado(int codigo, String nombre, String telefono, String dpi, String nit, String correoElectronico, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.dpi = dpi;
        this.nit = nit;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
