package com.my.elyo.quienseune;

import android.database.Cursor;
import android.widget.TextView;

/**
 * Created by elyo_ on 24/11/2016.
 */

public class Usuario {
    static TextView t;
    static String que="create table usuarios (" +
            "id text not null, " +
            "usuario text not null, " +
            "telefono text not null, " +
            "contrasena text not null, " +
            "nombre text not null, " +
            "apellido text not null," +
            "sexo text not null, " +
            "edad text not null," +
            "ciudad text not null," +
            "descripcion text not null)";
    String[] datos;
    String usuario;
    String telefono;
    String contrasena;
    String nombre;
    String apellido;
    String sexo;
    String edad;
    String ciudad;
    String descripcion;
    int i=0;

    public Usuario(){
        datos= new String[]{usuario, telefono, contrasena, nombre, apellido, sexo, edad, ciudad, descripcion};
    }
    public String getUsuario() {
        return usuario;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getContrasena() {
        return contrasena;
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
    public String[] getDatos() {
        return datos;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
        datos[0]=usuario;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
        datos[1]=telefono;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
        datos[2]=contrasena;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
        datos[3]=nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
        datos[4]=apellido;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
        datos[5]=sexo;
    }
    public void setEdad(String edad) {
        this.edad = edad;
        datos[6]=edad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
        datos[7]=ciudad;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        datos[8]=descripcion;
    }
    public void setDatos(String[] datos) {
        this.datos = datos;
    }
    public boolean guardarUsuario(){

        try{
            //llamar conexion a base de datos y enviar consulta de insert con insertarDatos()
            if(noHayVacios()) {
                Registro.b.insertRow("usuarios", datos);
                return true;
            }
            return false;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    boolean noHayVacios(){
        i=0;
        while (i<datos.length) {
            if(datos[i].equals("")||datos[i].equals(" ") || datos[i]==null)
                return false;
            i++;
        }
        return true;
    }
    static boolean existeUsuario(String u, String p)
    {
        String lastQuery="select * from usuarios where usuario='"+u+"' and contrasena='"+p+"'";
        Cursor cr =Registro.b.select(lastQuery);
        try {
            if(cr.getCount()<1) {
                //t.setText("Lista de alumnos vacia.");
            }
            if (cr.moveToFirst()) {
                do {
                    if (cr.getString(1).equals(u) && cr.getString(2).equals(p)) {
                        A.S2=cr.getString(0);
                        return true;
                    }
                } while (cr.moveToNext());
            }
            return false;
        }
        catch (Exception ex) {
            //t.setText(ex.getMessage());
            return false;
        }
    }
    static Cursor mostrarUsuario(String id)
    {
        return  MostrarUsuario.b.selectRow("usuarios","usuario",id);
    }

}
