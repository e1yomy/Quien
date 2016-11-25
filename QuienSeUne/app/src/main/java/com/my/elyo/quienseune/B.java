package com.my.elyo.quienseune;

/**
 * Created by elyo_ on 25/11/2016.
 */

public class B {
    String lastQuery="";
    String table="";
    String base="";

    public B(){

    }
    public boolean insertRow(String t, String []v)
    {
        try{

            return true;
        }
        catch (Exception ex)
        {
            return false;
        }

    }
    public boolean insertRow(String query)
    {
        try{

            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    public boolean createInsertQuery(String t, String v)
    {
        //lastQuery="insert into"
        try{

            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    public boolean deleteQuery(String t, String w)
    {
        try{

            return true;
        }
        catch (Exception ex)
        {
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
            return false;
        }
    }


}
