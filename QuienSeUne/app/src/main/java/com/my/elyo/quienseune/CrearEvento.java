package com.my.elyo.quienseune;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
        ActionBar ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        ab.setTitle("Crear evento");
        ab.setIcon(R.mipmap.ic_add);

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
        A.S3="";
        A.S4="";
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
    public void ubicacion(View view){
        startActivity(new Intent(this,GuardarUbicacion.class));
    }
    public void cancelar(View view){
        finish();
    }
    public void guardar(View view){
        if(A.S3.equals("")||A.S4.equals(""))
        {
            Toast.makeText(getBaseContext(),"Debes seleccionar la ubicacion del evento  ." , Toast.LENGTH_SHORT).show();
            return;
        }
        e= new Evento();
        e.setUsuario(A.S2);
        e.setTitulo(e1.getText().toString());
        e.setFechai(e4.getDayOfMonth()+"/"+(e4.getMonth()+1)+"/"+e4.getYear());
        e.setHorai(e51.getSelectedItem().toString()+":"+e52.getSelectedItem().toString());
        e.setFechaf(e6.getDayOfMonth()+"/"+(e6.getMonth()+1)+"/"+e6.getYear());
        e.setHoraf(e71.getSelectedItem().toString()+":"+e72.getSelectedItem().toString());
        e.setCiudad(e3.getText().toString());
        e.setLugar(e2.getText().toString());
        e.setLatitud(A.S3);
        e.setLongitud(A.S4);
        e.setDisponibilidad(e8.getSelectedItem().toString());
        e.setDescripcion(e9.getText().toString());

        if(e.guardarEvento())
        {
            Toast.makeText(getBaseContext(),"Evento creado." , Toast.LENGTH_SHORT).show();
            finish();
        }
        else
        {
            Toast.makeText(getBaseContext(),"Algo ha salido mal. Verifique los datos e intente nuevamente.\n"+B.er , Toast.LENGTH_SHORT).show();
        }
    }


}
