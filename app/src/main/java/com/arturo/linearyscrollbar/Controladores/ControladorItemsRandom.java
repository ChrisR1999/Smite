package com.arturo.linearyscrollbar.Controladores;

import android.content.Context;
import android.database.Cursor;

import com.arturo.linearyscrollbar.BD.VinculoBD;
import com.arturo.linearyscrollbar.Modelos.ModeloItemsRandom;

import java.util.ArrayList;
import java.util.List;

public class ControladorItemsRandom extends VinculoBD {

    public ControladorItemsRandom(){super();}
    public ControladorItemsRandom(Context context){super(context);}

    public ArrayList<ModeloItemsRandom> getAllRandomItems(String type){
        ArrayList<ModeloItemsRandom> list = new ArrayList<>();
        open();
        Cursor cursor = bdGods.rawQuery("SELECT Nombre FROM ItemRandom WHERE tipo = ?", new String[]{type});
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            ModeloItemsRandom model = new ModeloItemsRandom();
            model.setNombre(cursor.getString(0));
            list.add(model);

            cursor.moveToNext();
        }
        cursor.close();
        close();
        return list;
    }

    public ArrayList<ModeloItemsRandom> TodosLosITems(String type) {
        ArrayList<ModeloItemsRandom> list = new ArrayList<>();
        open();
        Cursor cursor = bdGods.rawQuery("SELECT Nombre,Tipo from ItemRandom ", null);

        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            ModeloItemsRandom model = new ModeloItemsRandom();
            model.setNombre(cursor.getString(0));
            model.setTipo(cursor.getString(1));
            list.add(model);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return list;
    }

}
