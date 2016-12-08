package com.my.elyo.quienseune;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MostrarEvento extends AppCompatActivity {
    ListView l;
    static B b;
    static LatLng ub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_evento);
        l=(ListView)findViewById(R.id.listdetallesevento);
        ActionBar ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        ab.setTitle("Informacion del evento");
        ab.setIcon(R.mipmap.ic_info);

        b=new B(this);
        CargarDatos();

    }

    private void CargarDatos() {
        String id=A.S5;
        A.S5="";
        ArrayList<String> ar = new ArrayList<>();
        Cursor c= Evento.mostrarEvento(id);
        try {
            if (c.moveToFirst()) {
                do {
                    //ar.add(cr.getString(0) + " - " + cr.getString(2)+ ", " + cr.getString(1));
                    for (byte q = 1; q < c.getColumnCount(); q++)
                    {
                        switch (q)
                        {

                            case 1:
                                A.S6=c.getString(q);
                                //ar.add("Usuario: "+ c.getString(q));
                                break;
                            case 2:
                                ar.add("Titulo: "+ c.getString(q));
                                break;
                            case 3:
                                ar.add("Fecha de inicio: "+ c.getString(q));
                                break;
                            case 4:
                                ar.add("Hora de inicio: "+ c.getString(q));
                                break;
                            case 5:
                                ar.add("Finaliza el: "+ c.getString(q));
                                break;
                            case 6:
                                ar.add("Finaliza a las: "+ c.getString(q));
                                break;
                            case 7:
                                ar.add("Ciudad: "+ c.getString(q));
                                break;
                            case 8:
                                ar.add("Nombre del lugar: "+ c.getString(q));
                                break;
                            case 9:
                                A.S3=c.getString(q);
                                break;
                            case 10:
                                A.S4=c.getString(q);
                                break;
                            case 11:
                                ar.add("Descripcion: "+ c.getString(q));
                                break;
                            case 12:
                                ar.add("Lugares disponibles: "+ c.getString(q));
                                break;
                        }
                        //ar.add(c.getString(q));
                    }
                } while (c.moveToNext());
            }
        }
        catch (Exception ex)
        {

        }
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ar);
        l.setAdapter(adapter);

        //ub=new LatLng(Double.parseDouble(A.S3),Double.parseDouble(A.S4));
    }


    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true; /** true -> el menú ya está visible */
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                finish();
                return true;
            case R.id.inicio:
                Intent i=new Intent(this,Inicio.class);
                startActivity(i);
                finish();
                return true;
            case R.id.crearevento:
                Intent j=new Intent(this,CrearEvento.class);
                startActivity(j);
                finish();
                return true;
            case R.id.unirse:
                Intent k=new Intent(this,UnirseEvento.class);
                startActivity(k);
                finish();
                return true;
            case R.id.miseventos:
                Intent m=new Intent(this,MisEventos.class);
                startActivity(m);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void mostrarMapa(View view)
    {
        Intent i=new Intent(this,VerUbicacion.class);
        startActivity(i);
    }
    public void mostrarUsuario(View view)
    {
        Intent i=new Intent(this,MostrarUsuario.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed()
    {
        finish();
    }

}
