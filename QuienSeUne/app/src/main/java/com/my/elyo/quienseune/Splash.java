package com.my.elyo.quienseune;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class Splash extends AppCompatActivity{

    Intent i1;
    Intent i2;
    Intent i;
    Thread t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        //i1 = new Intent(this, Inicio.class);
        //i2 = new Intent(this, MainActivity.class);
        if (A.sesion) {
            //startActivity(i1);
            i= new Intent(this, Inicio.class);
        } else {
            //startActivity(i2);
            i = new Intent(this, MainActivity.class);
        }
        startActivity(i);
        Toast.makeText(getBaseContext(), "asddas", Toast.LENGTH_SHORT).show();
    }


}
