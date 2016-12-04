package com.my.elyo.quienseune;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MostrarUsuario extends AppCompatActivity {
    static B b;
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_usuario);
        ActionBar ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        ab.setTitle("Detalles de usuario");
        ab.setIcon(R.mipmap.ic_id_card);
        l=(ListView)findViewById(R.id.listadetallesusuario);

        b=new B(this);
        CargarDatos();
    }

    private void CargarDatos() {
        String id=A.S2;
        A.S2="";
        ArrayList<String> ar = new ArrayList<>();
        Cursor c= Usuario.mostrarUsuario(id);
        try {
            if (c.moveToFirst()) {
                do {
                    //ar.add(cr.getString(0) + " - " + cr.getString(2)+ ", " + cr.getString(1));
                    for (byte q = 1; q < c.getColumnCount(); q++)
                    {
                        switch (q)
                        {

                            case 1:
                                ar.add("Usuario: "+ c.getString(q));
                                break;
                            case 2:
                                ar.add("Teléfono: "+ c.getString(q));
                                break;
                            case 4:
                                ar.add("Nombre (s): "+ c.getString(q));
                                break;
                            case 5:
                                ar.add("Apellidos (s): "+ c.getString(q));
                                break;
                            case 6:
                                ar.add("Genero: "+ c.getString(q));
                                break;
                            case 7:
                                ar.add("Edad: "+ c.getString(q));
                                break;
                            case 8:
                                ar.add("Ciudad: "+ c.getString(q));
                                break;
                            case 9:
                                ar.add("Descripcion: "+ c.getString(q));
                                break;
                        }
                    }
                } while (c.moveToNext());
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(getBaseContext(),ex.getMessage() , Toast.LENGTH_SHORT).show();
        }
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ar);
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

}
