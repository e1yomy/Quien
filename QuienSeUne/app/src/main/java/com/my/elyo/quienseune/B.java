package com.my.elyo.quienseune;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by elyo_ on 25/11/2016.
 */

public class B extends SQLiteOpenHelper{
    String lastQuery="";
    String table="";
    public static Integer id=1;
    public static String er="";

    public B(Context c){
        super(c, "quien", null, 1);
        //B b=new B(this.Context, "quien");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Usuario.que);
        db.execSQL(Evento.que);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insertRow(String t, String []v)
    {
        try{
            updateId(t);
            getWritableDatabase()
                    .execSQL(createInsertQuery(t,v));
            return true;
        }
        catch (Exception ex)
        {
            er=ex.getMessage();
            return false;
        }
    }

    String createInsertQuery(String t, String []v)
    {
        lastQuery="INSERT INTO "+t+" VALUES ('"+id+"',";
        for(byte i=0;i<v.length;i++)
        {
            if(i!=v.length-1)
                lastQuery+="'"+v[i]+"', ";
            else
                lastQuery+="'"+v[i]+"')";
        }
        return lastQuery;
    }
    public boolean deleteQuery(String t, String w, String v)
    {
        try{
            lastQuery="delete from "+table+" where "+w+" = '"+v+"'";
            getWritableDatabase().execSQL(lastQuery);
            return true;
        }
        catch (Exception ex)
        {
            er=ex.getMessage();
            return false;
        }
    }
    public boolean updateQuery(String t, String w, String [] v)
    {
        try{

            return true;
        }
        catch (Exception ex)
        {
            er=ex.getMessage();
            return false;
        }
    }
    void updateId(String t) {
        lastQuery="select * from "+t;
        Cursor cr= getReadableDatabase().rawQuery(lastQuery,null);
        try {
            if (cr.moveToFirst()) {
                do {
                    id= Integer.valueOf(cr.getString(0));
                } while (cr.moveToNext());
                id++;
            }
        } catch (Exception ex) {
            er=ex.getMessage();
        }

    }
    public Cursor selectAll(String t, String c)
    {
        try{
            lastQuery="select * from "+t+" order by "+c+" asc";
            Cursor cu=getReadableDatabase().rawQuery(lastQuery,null);
            return cu;
        }
        catch(Exception ex)
        {
            er=ex.getMessage();
            return null;
        }
    }


}
