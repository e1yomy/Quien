package com.my.elyo.quienseune;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences p ;
    static B b;
    EditText e1;
    EditText e2;
    Usuario u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b= new B(this);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        p = getSharedPreferences("P", Context.MODE_PRIVATE);
    }

    public void registrarse(View view){
        //e1.setText("");
        //e2.setText("");
        Intent i = new Intent(this,Registro.class);
        startActivity(i);
    }
    public void iniciarSesion(View view){
        String a;
        String b;

            try {
                a = e1.getText().toString();
                b = e2.getText().toString();

                if(Usuario.existeUsuario(a,b))
                {
                    SharedPreferences.Editor e=p.edit();
                    e.remove("sesion");
                    e.putBoolean("sesion",true);
                    e.putString("usuario",a);
                    e.commit();
                    Intent i = new Intent(this,Inicio.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getBaseContext(),"Numero o contrasena incorrecto, intente nuevamente." , Toast.LENGTH_SHORT).show();
                }
            }
            catch(Exception ex)
            {
                Toast.makeText(getBaseContext(),"Campos numero o contrasena vacio, intente nuevamente." , Toast.LENGTH_SHORT).show();
            }
    }
}
