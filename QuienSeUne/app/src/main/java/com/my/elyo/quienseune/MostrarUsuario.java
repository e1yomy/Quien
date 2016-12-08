package com.my.elyo.quienseune;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MostrarUsuario extends AppCompatActivity {
    static B b;
    ListView l;
    String te;
    EditText ed;
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
        ed=(EditText)findViewById(R.id.editText3);
        b=new B(this);
        CargarDatos();
    }

    private void CargarDatos() {
        String id=A.S6;
        te="";
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
                                //ar.add("Usuario: "+ c.getString(q));
                                break;
                            case 2:
                                //ar.add("Teléfono: "+ c.getString(q));
                                te=c.getString(q);
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



    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true; /** true -> el menú ya está visible */
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                finish();
                return true;
            case R.id.inicio:
                Intent i=new Intent(this,Inicio.class);
                startActivity(i);
                finish();
                return true;
            case R.id.crearevento:
                Intent j=new Intent(this,CrearEvento.class);
                startActivity(j);
                finish();
                return true;
            case R.id.unirse:
                Intent k=new Intent(this,UnirseEvento.class);
                startActivity(k);
                finish();
                return true;
            case R.id.miseventos:
                Intent m=new Intent(this,MisEventos.class);
                startActivity(m);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void llamar(View view){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+te));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }
    public void enviarSms(View view){
        try {
            String me = ed.getText().toString();
            if (me.length() > 5) {
                SmsManager.getDefault().sendTextMessage(te, null, me, null, null);
                Toast.makeText(getBaseContext(),"Mensaje enviado correctamente." , Toast.LENGTH_SHORT).show();
                ed.setText("");
            }
            else
                Toast.makeText(getBaseContext(),"Mensaje muy corto, haz que valga la pena." , Toast.LENGTH_SHORT).show();

        }
        catch(Exception ex)
        {
            Toast.makeText(getBaseContext(),"Ha ocurrito un error inesperado.\nIntenta nuevamente en unos momentos." , Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onBackPressed()
    {
        finish();
    }
    public void onResume(){
        CargarDatos();
    }
}
