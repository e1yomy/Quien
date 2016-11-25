package com.my.elyo.quienseune;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        getSupportActionBar().setTitle("Inicio");

    }
    public void crear(View view)
    {
        Intent i = new Intent(this,CrearEvento.class);
        startActivity(i);
    }
    public void unirse(View view)
    {
        Intent i = new Intent(this,UnirseEvento.class);
        startActivity(i);
    }
    public void cerrarSesion(View view)
    {
        finish();
    }
}
