package com.my.elyo.quienseune;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UnirseEvento extends AppCompatActivity {
    static Context c;
    static B b;
    ArrayList<String> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unirse_evento);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Eventos");
        c=this;
        b= new B(c);
        Consulta();
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
    public void Consulta(){
        Cursor cr=b.selectAll("usuarios","id");
        try {
            if(cr.getCount()<1) {
                //t.setText("Lista de alumnos vacia.");
            }
            if (cr.moveToFirst()) {
                do {
                    lista.add(cr.getString(2));
                } while (cr.moveToNext());
            }
        } catch (Exception ex) {
            //t.setText(ex.getMessage());
        }
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        ListView l=(ListView)findViewById(R.id.listView);
        l.setAdapter(adapter);
    }
}
