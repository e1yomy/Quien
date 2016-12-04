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
    public void guardar(View view){
        if(c1.getText().toString().equals(c2.getText().toString())) {
            u = new Usuario();
            u.setUsuario(e1.getText().toString());
            u.setTelefono(e2.getText().toString());
            u.setContrasena(c1.getText().toString());
            u.setNombre(e3.getText().toString());
            u.setApellido(e4.getText().toString());
            u.setSexo(e5.getSelectedItem().toString());
            u.setEdad(e6.getSelectedItem().toString());
            u.setCiudad(e7.getText().toString());
            u.setDescripcion(e8.getText().toString());
            if(u.noHayVacios()) {
                if (u.guardarUsuario()) {
                    Toast.makeText(getBaseContext(), "Usuario registrado.", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getBaseContext(), "Iniciar sesion para continuar.", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(getBaseContext(), B.er + "\nAlgo ha salido mal. Intente nuevamente dentro de unos minutos.", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(getBaseContext(), "Verificar los datos por datos vacios.", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            c1.setText("");
            c2.setText("");
            Toast.makeText(getBaseContext(),"Los campos de contrasena no coinciden.\nVerificar y reintentar." , Toast.LENGTH_SHORT).show();
        }
    }


}
