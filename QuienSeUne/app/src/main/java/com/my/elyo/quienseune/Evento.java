package com.my.elyo.quienseune;

import android.widget.TextView;

/**
 * Created by elyo_ on 29/11/2016.
 */

public class Evento {
    static TextView t;
    static String que="create table eventos(id text not null, titulo text not null,fechai text not null,horai text not null,fechaf text not null,horaf text not null,ciudad text not null,lugar text not null,latitud text not null,longitud text not null,descripcion text not null,disponibilidad)";
    String[] datos;
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
        datos= new String[]{titulo,fechai, horai, fechaf, horaf,ciudad,lugar,latitud,longitud,descripcion,disponibilidad};
    }
    public boolean guardarEvento()
    {
        try{

            return true;
        }
        catch (Exception ex)
        {
            return false;
        }

    }
    public String insertarDatos(){
        String que="insert int eventos values(";
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

    public void setDatos(String[] datos) {
        this.datos = datos;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setFechai(String fechai) {
        this.fechai = fechai;
    }
    public void setHorai(String horai) {
        this.horai = horai;
    }
    public void setFechaf(String fechaf) {
        this.fechaf = fechaf;
    }
    public void setHoraf(String horaf) {
        this.horaf = horaf;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    public String[] getDatos() {
        return datos;
    }
    public String getTitulo() {
        return titulo;
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