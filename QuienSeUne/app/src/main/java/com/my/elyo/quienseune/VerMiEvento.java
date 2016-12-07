package com.my.elyo.quienseune;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class VerMiEvento extends AppCompatActivity {
    ListView l;
    static B b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_mi_evento);
        ActionBar ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        ab.setTitle("Informacion del evento");
        ab.setIcon(R.mipmap.ic_info);
        l=(ListView)findViewById(R.id.vermievento);
        b=new B(this);
        CargarDatos();
    }

    private void CargarDatos() {
        String id=A.S5;
        ArrayList<String> ar = new ArrayList<>();

        try {
            Cursor c= Evento.mostrarEvento2(id);
            if (c.moveToFirst()) {
                do {
                    //ar.add(cr.getString(0) + " - " + cr.getString(2)+ ", " + cr.getString(1));
                    for (byte q = 1; q < c.getColumnCount(); q++)
                    {
                        switch (q)
                        {
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

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
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
    public void eliminar(View view)
    {
        if(Evento.eliminarEvento(A.S5))
        {
            Toast.makeText(getBaseContext(),"Evento borrado exitosamente." , Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    @Override
    public void onResume(){
        CargarDatos();
    }
}
