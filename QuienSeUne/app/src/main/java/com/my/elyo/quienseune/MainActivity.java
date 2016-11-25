package com.my.elyo.quienseune;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText e=(EditText)findViewById(R.id.editText);
        e.clearFocus();
        getSupportActionBar().setTitle("Inicio de sesion");
    }

    public void registrarse(View view){
        Intent i = new Intent(this,Registro.class);
        startActivity(i);
    }
    public void iniciarSesion(View view){
        Intent i = new Intent(this,Inicio.class);
        startActivity(i);
    }
}
