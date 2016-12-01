package com.my.elyo.quienseune;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CrearEvento extends AppCompatActivity {
    static B b;
    static String fechai, fechaf;
    Evento e;
    EditText e1 ;
    EditText e2 ;
    EditText e3 ;
    DatePicker e4;
    Spinner e51;
    Spinner e52;
    DatePicker e6;
    Spinner e71;
    Spinner e72;
    Spinner e8;
    EditText e9 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_evento);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Crear evento");
        b=new B(this);
        e1 = (EditText)findViewById(R.id.evento1edit);
        e2 = (EditText)findViewById(R.id.evento2edit);
        e3 = (EditText)findViewById(R.id.evento3edit);
        e4=(DatePicker)findViewById(R.id.evento4datepicker);
        e51 =(Spinner)findViewById(R.id.evento5spinner1);
        e52 =(Spinner)findViewById(R.id.evento5spinner2);
        e6=(DatePicker)findViewById(R.id.evento6datepicker);
        e71 =(Spinner)findViewById(R.id.evento7spinner1);
        e72 =(Spinner)findViewById(R.id.evento7spinner2);
        e8 =(Spinner)findViewById(R.id.evento8spinner);
        e9 = (EditText)findViewById(R.id.evento9edit);
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
    public void cancelar(View view){
        finish();
    }
    public void guardar(View view){
        /*if(c1.getText().toString().equals(c2.getText().toString())) {
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
            if (u.guardarUsuario()) {
                Toast.makeText(getBaseContext(),"Usuario registrado." , Toast.LENGTH_SHORT).show();
                Toast.makeText(getBaseContext(),"Iniciar sesion para continuar." , Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(getBaseContext(),B.er+"\nAlgo ha salido mal. Intente nuevamente dentro de unos minutos." , Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            c1.setText("");
            c2.setText("");
            Toast.makeText(getBaseContext(),"Los campos de contrasena no coinciden.\nVerificar y reintentar." , Toast.LENGTH_SHORT).show();
        }*/
    }
}
