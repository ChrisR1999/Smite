package com.arturo.linearyscrollbar.Controladores;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

    public ArrayList<ModeloDioses> getAllGods() {
        open();
        ArrayList<ModeloDioses> gods = new ArrayList<>();
        Cursor cursor = bdGods.rawQuery("SELECT * FROM datosDioses", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                gods.add(new ModeloDioses(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)
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
}
