package com.my.elyo.quienseune;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by elyo_ on 30/11/2016.
 */

public class Configuracion {
    private final String SHARED_PREFS_FILE = "HMPrefs";
    private final String sesion="se";

    private Context mContext;

    public Configuracion(Context context)
    {
        mContext=context;
        cerrarSesion();

    }
    public String haySesion(){
        return getSettings().getString(sesion,null);
    }
    private SharedPreferences getSettings(){
        return mContext.getSharedPreferences(SHARED_PREFS_FILE, 0);
    }
    public void iniciarSesion(){
        SharedPreferences.Editor editor=getSettings().edit();
        editor.putString(sesion, "true");
        editor.commit();
    }
    public void cerrarSesion(){
        SharedPreferences.Editor editor=getSettings().edit();
        editor.remove(sesion);
        editor.commit();
    }
    public void haysesionn(){

    }
}
