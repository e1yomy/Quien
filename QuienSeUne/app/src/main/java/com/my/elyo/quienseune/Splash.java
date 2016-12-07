package com.my.elyo.quienseune;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class Splash extends AppCompatActivity{
    Intent i;
    SharedPreferences p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        p = getSharedPreferences("P", Context.MODE_PRIVATE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                i = new Intent(Splash.this, MainActivity.class);
                try {
                    A.S1= String.valueOf(p.getBoolean("sesion",false));
                    if (A.S1.equals("true"))
                        i = new Intent(Splash.this, Inicio.class);
                }
                catch(Exception ex){}
                startActivity(i);
            }},1500);
    }


}
