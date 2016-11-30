package com.my.elyo.quienseune;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {
    static B b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_inicio);
        b= new B(this);
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
    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();
    }
    public void cerrarSesion(View view)
    {
        A.sesion=false;
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
