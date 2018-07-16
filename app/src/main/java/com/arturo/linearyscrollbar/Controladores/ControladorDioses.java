package com.arturo.linearyscrollbar.Controladores;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;

import com.arturo.linearyscrollbar.BD.VinculoBD;
import com.arturo.linearyscrollbar.MainActivity;
import com.arturo.linearyscrollbar.Modelos.ModeloDioses;
import com.arturo.linearyscrollbar.Modelos.ModeloDiosesMain;

import java.util.ArrayList;

public class ControladorDioses extends VinculoBD{

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

    public ModeloDioses godStadistics(String godName){
        open();
        ModeloDioses god = new ModeloDioses();
        Cursor cursor = bdGods.rawQuery("SELECT godCombo, counter, counteredBy, resourceImage FROM datosDioses WHERE godName = ?", new String[]{godName});
        cursor.moveToFirst();
        god.setGodCombo(cursor.getString(0));
        god.setCounter(cursor.getString(1));
        god.setCounterBy(cursor.getString(2));
        god.setResourceImage(cursor.getString(3));
        cursor.close();
        close();
        return god;
    }

    public ArrayList<ModeloDiosesMain> searchResults(String search){
        open();
        search = "%" + search + "%";
        ArrayList<ModeloDiosesMain> gods = new ArrayList<>();
        Log.d("error", search);
        Cursor cursor = bdGods.rawQuery("SELECT godId, godName, Tipo, panteon, resourceImage  FROM datosDioses WHERE godName LIKE ?", new String[]{search});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            gods.add(new ModeloDiosesMain(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            ));
            cursor.moveToNext();
        }
        close();
        return gods;
    }
}
