package com.my.elyo.quienseune;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    static B b;
    Usuario u;
    EditText e1 ;
    EditText e2 ;
    EditText e3 ;
    EditText e4 ;
    Spinner e5;
    Spinner e6;
    EditText e7 ;
    EditText e8 ;
    EditText c1 ;
    EditText c2 ;
    Intent inin ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        ActionBar ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        ab.setTitle("Registro");
        ab.setIcon(R.mipmap.ic_hombre);


        e1 = (EditText)findViewById(R.id.registro1edit);
        e2 = (EditText)findViewById(R.id.registro2edit);
        e3 = (EditText)findViewById(R.id.registro3edit);
        e4 = (EditText)findViewById(R.id.registro4edit);
        e5 =(Spinner)findViewById(R.id.registro5spinner);
        e6=(Spinner)findViewById(R.id.registro6spinner);
        e7 = (EditText)findViewById(R.id.registro7edit);
        e8 = (EditText)findViewById(R.id.registro8edit);
        c1 = (EditText)findViewById(R.id.registro1contra);
        c2 = (EditText)findViewById(R.id.registro2contra);
        b=new B(this);
        inin = new Intent(this,MainActivity.class);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                startActivity(inin);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void cancelar(View view){
        startActivity(inin);
        finish();
    }
    public void guardar(View view) {
        boolean bien = true;
        String s1 = e1.getText().toString();
        String s2 = e2.getText().toString();
        String s3 = c1.getText().toString();
        String s4 = e3.getText().toString();
        String s5 = e4.getText().toString();
        String s6 = e5.getSelectedItem().toString();
        String s7 = e6.getSelectedItem().toString();
        String s8 = e7.getText().toString();
        String s9 = e8.getText().toString();

        if (s1.length() < 3) {
            e1.setError("Nombre de usuario muy corto");
            bien=false;
        }
        if (s2.length() < 10) {
            e2.setError("Ingresar número de teléfono a 10 digitos.");
            bien=false;
        }
        if (s3.length()<5){
            c1.setError("Contrasena muy corta.");
            bien=false;
        }
        if (s4.length()<2){
            e3.setError("Nombre muy corto.");
            bien=false;
        }
        if (s5.length()<2){
            e4.setError("Apellido muy corto.");
            bien=false;
        }

        if (bien) {
            if (s3.equals(c2.getText().toString())) {
                u = new Usuario();
                u.setUsuario(s1);
                u.setTelefono(s2);
                u.setContrasena(s3);
                u.setNombre(s4);
                u.setApellido(s5);
                u.setSexo(s6);
                u.setEdad(s7);
                u.setCiudad(s8);
                u.setDescripcion(s9);
                if (u.noHayVacios()) {
                    if (u.guardarUsuario()) {
                        Toast.makeText(getBaseContext(), "Usuario registrado.", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getBaseContext(), "Iniciar sesion para continuar.", Toast.LENGTH_SHORT).show();
                        startActivity(inin);
                        finish();
                    } else {
                        Toast.makeText(getBaseContext(), B.er + "\nAlgo ha salido mal. Intente nuevamente dentro de unos minutos.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getBaseContext(), "Verificar los datos por datos vacios.", Toast.LENGTH_SHORT).show();
                }
            } else {
                c2.setError("Las contrasenas no coinciden.");
            }
        }
    }


}
