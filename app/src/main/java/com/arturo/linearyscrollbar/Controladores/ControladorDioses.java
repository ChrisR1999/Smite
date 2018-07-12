package com.arturo.linearyscrollbar.Controladores;

import android.content.Context;
import android.database.Cursor;
import com.arturo.linearyscrollbar.BD.VinculoBD;
import com.arturo.linearyscrollbar.Modelos.ModeloDioses;

import java.util.ArrayList;

public class ControladorDioses extends VinculoBD{

    public ControladorDioses() {
        super();
    }

    public ControladorDioses(Context context) {
        super(context);
    }

    public ArrayList<String> getAllGodsNames() {
        open();
        ArrayList<String> gods = new ArrayList<>();
        Cursor cursor = bdGods.rawQuery("SELECT godName  FROM datosDioses", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                gods.add(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
            close();
            return gods;
        } else {
            cursor.close();
            close();
            return null;
        }
    }

    public ModeloDioses godStadistics(String godName){
        open();
        ModeloDioses god = new ModeloDioses();
        Cursor cursor = bdGods.rawQuery("SELECT godCombo, counter, counteredBy FROM datosDioses WHERE godName = ?", new String[]{godName});
        cursor.moveToFirst();
        god.setGodCombo(cursor.getString(0));
        god.setCounter(cursor.getString(1));
        god.setCounterBy(cursor.getString(2));
        cursor.close();
        close();
        return god;
    }

    public ArrayList<String> searchResults(String search){
        open();
        search = "%" + search + "%";
        ArrayList<String> gods = new ArrayList<>();
        Cursor cursor = bdGods.rawQuery("SELECT godName FROM datosDioses WHERE godName = ?", new String[]{search});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            gods.add(cursor.getString(0));
            cursor.moveToNext();
        }
        close();
        return gods;
    }
}
