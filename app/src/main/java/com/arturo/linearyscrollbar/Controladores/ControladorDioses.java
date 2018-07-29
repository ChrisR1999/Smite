package com.arturo.linearyscrollbar.Controladores;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.arturo.linearyscrollbar.BD.VinculoBD;
import com.arturo.linearyscrollbar.Modelos.ModeloDioses;
import com.arturo.linearyscrollbar.Modelos.ModeloDiosesMain;

import java.util.ArrayList;

public class ControladorDioses extends VinculoBD {

    public ControladorDioses() {
        super();
    }

    public ControladorDioses(Context context) {
        super(context);
    }

    public ArrayList<ModeloDiosesMain> getAllGods() {
        open();
        ArrayList<ModeloDiosesMain> gods = new ArrayList<>();
        Cursor cursor = bdGods.rawQuery("SELECT godId, godName, Tipo, panteon, resourceImage  FROM datosDioses", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                gods.add(new ModeloDiosesMain(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                ));
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

    public ModeloDioses godStadistics(String godName) {
        ArrayList<String> countersBy = new ArrayList<>();
        ArrayList<String> counters = new ArrayList<>();
        open();
        ModeloDioses god = new ModeloDioses();
        Cursor cursor = bdGods.rawQuery("SELECT godCombo, counteredBy, counteredBy2 , counteredBy3, counteredBy4, counteredBy5, counteredBy6, counter, counter2,counter3, resourceImage FROM datosDioses WHERE godName = ?", new String[]{godName});
        cursor.moveToFirst();
        god.setGodCombo(cursor.getString(0));
        for (int i = 1; i < 7; i++)
            countersBy.add(cursor.getString(i));
        god.setCountersBy(countersBy);

        for (int i = 7; i < 10; i++)
            counters.add(cursor.getString(i));
        god.setCounter(counters);


        god.setResourceImage(cursor.getString(10));
        cursor.close();
        close();
        return god;
    }

    public ArrayList<ModeloDiosesMain> searchResults(String search) {
        open();
        search = "%" + search + "%";
        ArrayList<ModeloDiosesMain> gods = new ArrayList<>();
        Log.d("error", search);
        Cursor cursor = bdGods.rawQuery("SELECT godId, godName, Tipo, panteon, resourceImage  FROM datosDioses WHERE godName LIKE ?", new String[]{search});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            gods.add(new ModeloDiosesMain(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            ));
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return gods;
    }

    public ModeloDiosesMain getGodNameAndTypeByResourceImage(String godName) {
        ModeloDiosesMain modelo = new ModeloDiosesMain();
        open();
        Cursor cursor = bdGods.rawQuery("SELECT godName, Tipo FROM datosDioses WHERE resourceImage = ?", new String[]{godName});
        cursor.moveToFirst();
        modelo.setGodName(cursor.getString(0));
        modelo.setGodCategory(cursor.getString(1));
        cursor.close();
        close();
        return modelo;
    }
}
