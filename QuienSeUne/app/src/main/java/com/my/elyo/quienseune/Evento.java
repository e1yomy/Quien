package com.my.elyo.quienseune;

import android.database.Cursor;
import android.widget.TextView;

/**
 * Created by elyo_ on 29/11/2016.
 */

public class Evento {
    static TextView t;
    static String que="create table eventos(" +
            "id text not null, " +
            "usuario text not null, " +
            "titulo text not null," +
            "fechai text not null," +
            "horai text not null," +
            "fechaf text not null," +
            "horaf text not null," +
            "ciudad text not null," +
            "lugar text not null," +
            "latitud text not null," +
            "longitud text not null," +
            "disponibilidad text not null, " +
            "descripcion text not null)";
    String[] datos;
    String usuario;
    String titulo;
    String fechai;
    String horai;
    String fechaf;
    String horaf;
    String ciudad;
    String lugar;
    String latitud;
    String longitud;
    String descripcion;
    String disponibilidad;
    int i=0;

    public Evento(){
        datos= new String[]{usuario, titulo,fechai, horai, fechaf, horaf,ciudad,lugar,latitud,longitud,descripcion,disponibilidad};
    }
    public boolean guardarEvento()
    {
        if(noHayVacios())
        {
            if(CrearEvento.b.insertRow("eventos", datos)) {
                return true;
            }
            else
                return false;
        }
        return false;

    }
    boolean noHayVacios(){
        i=0;
        while (i<datos.length) {
            if(datos[i].equals("")||datos[i].equals(" "))
                return false;
            i++;
        }
        return true;
    }
    static Cursor mostrarEvento(String id)
    {
        return MostrarEvento.b.selectRow("eventos","id",id);
    }
    public void setDatos(String[] datos) {
        this.datos = datos;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
        datos[0]=usuario;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
        datos[1]=titulo;
    }
    public void setFechai(String fechai) {
        this.fechai = fechai;
        datos[2]=fechai;
    }
    public void setHorai(String horai) {
        this.horai = horai;
        datos[3]=horai;
    }
    public void setFechaf(String fechaf) {
        this.fechaf = fechaf;
        datos[4]=fechaf;
    }
    public void setHoraf(String horaf) {
        this.horaf = horaf;
        datos[5]=horaf;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
        datos[6]=ciudad;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
        datos[7]=lugar;
    }
    public void setLatitud(String latitud) {
        this.latitud = latitud;
        datos[8]=latitud;
    }
    public void setLongitud(String longitud) {
        this.longitud = longitud;
        datos[9]=longitud;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        datos[10]=descripcion;
    }
    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
        datos[11]=disponibilidad;
    }
    public String[] getDatos() {
        return datos;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getUsuario() {
        return usuario;
    }
    public String getFechai() {
        return fechai;
    }
    public String getHorai() {
        return horai;
    }
    public String getFechaf() {
        return fechaf;
    }
    public String getHoraf() {
        return horaf;
    }
    public String getCiudad() {
        return ciudad;
    }
    public String getLugar() {
        return lugar;
    }
    public String getLatitud() {
        return latitud;
    }
    public String getLongitud() {
        return longitud;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getDisponibilidad() {
        return disponibilidad;
    }


}
