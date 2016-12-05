package com.my.elyo.quienseune;

import android.database.Cursor;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MisEventos extends AppCompatActivity {
    static B b;
    ListView l;
    ArrayList<String> lista = new ArrayList<>();
    ArrayList<String> id = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_eventos);
        ActionBar ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        ab.setTitle("Mis eventos");
        ab.setIcon(R.mipmap.ic_red_flag);
        b=new B(this);
        l=(ListView)findViewById(R.id.listamiseventos);
        OnItemClicListener();
        CargarDatos();
    }

    private void CargarDatos() {
        String usr=A.S2;
        ArrayList<String> ar = new ArrayList<>();
        Cursor c= Evento.mostrarEventos(usr);
        try{
            if(c.moveToFirst())
            {
                do{
                    lista.add(c.getString(2));
                    id.add(c.getString(0));
                } while (c.moveToNext());
            }
        }
        catch (Exception ex)
        {

        }
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        l.setAdapter(adapter);
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

    private void OnItemClicListener() {
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemC, int position, long idd) {
                TextView t=(TextView) itemC;
                String tit=t.getText().toString();
                id.get(position);

            }
        });
    }
}
