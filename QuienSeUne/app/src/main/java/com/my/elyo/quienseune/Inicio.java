package com.my.elyo.quienseune;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {
    static B b;
    SharedPreferences p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_inicio);
        p = getSharedPreferences("P", Context.MODE_PRIVATE);
        b= new B(this);
        A.S2=p.getString("usuario","");
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
    public void acercade(View view)
    {
        Intent i = new Intent(this,AcercaDe.class);
        startActivity(i);
    }
    public void miseventos(View view)
    {
        Intent i = new Intent(this,MisEventos.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        //super.onBackPressed();
    }
    public void cerrarSesion(View view)
    {
        A.S2="";
        SharedPreferences.Editor e=p.edit();
        e.remove("sesion");
        e.putBoolean("sesion",false);
        e.remove("usuario");
        e.commit();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
