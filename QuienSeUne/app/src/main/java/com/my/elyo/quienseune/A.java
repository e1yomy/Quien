package com.my.elyo.quienseune;

import java.util.ArrayList;

/**
 * Created by elyo_ on 29/11/2016.
 */

public class A {
    static boolean sesion =true;
    static int i1;
    static int i2;
    static int i3;
    static int i4;
    static int i5;
    static int[] enteros={i1,i2,i3,i4,i5};
    static String S1;
    static String S2;
    static String S3;
    static String S4;
    static String S5;
    static String[] cadenas= {S1,S2,S3,S4,S5};
    static ArrayList<Integer> AE1;
    static ArrayList<Integer> AE2;
    static ArrayList<Integer> AE3;
    static ArrayList [] listaE={AE1,AE2,AE3};
    static ArrayList<String> AS1;
    static ArrayList<String> AS2;
    static ArrayList<String> AS3;
    static ArrayList [] listaC={AS1,AS2,AS3};

    static void limpiarTodo(){
        byte a;
        for (a=0;a<enteros.length;a++) {
            enteros[a] = Integer.parseInt(null);
            cadenas[a]="";
        }
        for (a=0;a<listaC.length;a++) {
            listaC[a].clear();
            listaE[a].clear();
        }
    }
}
