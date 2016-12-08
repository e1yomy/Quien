package com.my.elyo.quienseune;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        ActionBar ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        ab.setTitle("Acerca de");
        ab.setIcon(R.mipmap.ic_help);

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
}
