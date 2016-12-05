package com.my.elyo.quienseune;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by elyo_ on 29/11/2016.
 */

public class A {
    static boolean sesion = true;
    static int i1;
    static int i2;
    static int i3;
    static int i4;
    static int i5;
    static int[] enteros = {i1, i2, i3, i4, i5};

    static String S1; //Sesion
    static String S2; //Usuario
    static String S3; //Latitud
    static String S4; //Longitud
    static String S5; //IdEvento
    static String S6; //otrousuario
    static String[] cadenas = {S1, S2, S3, S4, S5};
    static ArrayList<Integer> AE1;
    static ArrayList<Integer> AE2;
    static ArrayList<Integer> AE3;
    static ArrayList[] listaE = {AE1, AE2, AE3};
    static ArrayList<String> AS1;
    static ArrayList<String> AS2;
    static ArrayList<String> AS3;
    static ArrayList[] listaC = {AS1, AS2, AS3};

    public A() {

    }

    static void limpiarTodo() {
        byte a;
        for (a = 0; a < enteros.length; a++) {
            enteros[a] = Integer.parseInt(null);
            cadenas[a] = "";
        }
        for (a = 0; a < listaC.length; a++) {
            listaC[a].clear();
            listaE[a].clear();
        }
    }
}