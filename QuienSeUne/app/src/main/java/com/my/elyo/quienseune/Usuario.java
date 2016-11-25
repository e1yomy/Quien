package com.my.elyo.quienseune;

/**
 * Created by elyo_ on 24/11/2016.
 */

public class Usuario {
    String[] datos;
    String usuario;
    String telefono;
    String nombre;
    String apellido;
    String sexo;
    String edad;
    String ciudad;
    String descripcion;
    int i=0;

    public Usuario(){
        datos= new String[]{usuario, telefono, nombre, apellido, sexo, edad, ciudad, descripcion};
    }
    public String getUsuario() {
        return usuario;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getSexo(){
        return sexo;
    }
    public String getEdad() {
        return edad;
    }
    public String getCiudad() {
        return ciudad;
    }
    public String getDescripcion(){
        return descripcion;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean guardarUsuario(){

        try{
            //llamar conexion a base de datos y enviar consulta de insert con insertarDatos()
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    String insertarDatos(){

        String que="insert into usuarios values(";
        if(noHayVacios()) {
            while (i < datos.length) {

                if (i != datos.length - 1)
                    que += "'" + datos[i] + "',";
                else
                    que += "'" + datos[i] + "');";
                i++;
            }
            i = 0;
            return que;
        }
        else
        {
            return "Error: elementos vacios.";
        }

    }
    boolean noHayVacios(){
        while (i<datos.length) {
            if(datos[i].equals("")||datos[i].equals(" "))
                return false;
            i++;
        }
        return true;
    }


}
