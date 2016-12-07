package com.my.elyo.quienseune;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class UnirseEvento extends AppCompatActivity{
    static Context c;
    static B b;
    ArrayList<String> lista = new ArrayList<>();
    ArrayList<String> id = new ArrayList<>();
    ListView l;
    Intent i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unirse_evento);
        ActionBar ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        ab.setTitle("Eventos disponibles");
        ab.setIcon(R.mipmap.ic_find);


        c=this;
        b= new B(c);
        l=(ListView)findViewById(R.id.listView);
        OnItemClicListener();
        Consulta();
        i=new Intent(this,MostrarEvento.class);
    }

    private void OnItemClicListener() {
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemC, int position, long idd) {
                TextView t=(TextView) itemC;
                String tit=t.getText().toString();
                A.S5= id.get(position);
                startActivity(i);
            }
        });
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
        TextView t= (TextView)findViewById(R.id.textViewer);
        t.setText("");
        try {
            Cursor cr=b.selectAll("eventos");
            if(cr.getCount()<1)
            {
                t.setText("No hay eventos disponibles.");
            }
            if (cr.moveToFirst()) {
                do {
                    lista.add(cr.getString(2));
                    id.add(cr.getString(0));
                } while (cr.moveToNext());
            }
            //lista.sort();
        } catch (Exception ex) {
            t.setText(B.er);
        }
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        l.setAdapter(adapter);
    }
    @Override
    public void onBackPressed()
    {
        finish();
    }
    public void onResume(){
        Consulta();
    }

}
