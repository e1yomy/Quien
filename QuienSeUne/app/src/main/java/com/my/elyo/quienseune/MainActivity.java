package com.my.elyo.quienseune;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    public static boolean sesion=true;
    static B b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //EditText e=(EditText)findViewById(R.id.editText);
        b= new B(this);

    }

    public void registrarse(View view){
        Intent i = new Intent(this,Registro.class);
        startActivity(i);
    }
    public void iniciarSesion(View view){
        A.sesion=true;
        Intent i = new Intent(this,Inicio.class);
        startActivity(i);
    }
}
