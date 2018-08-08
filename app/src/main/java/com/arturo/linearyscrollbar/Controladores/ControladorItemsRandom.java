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
        Cursor cursor = bdGods.rawQuery("SELECT Nombre,Tipo,Costo,PhysicalPower,Pasiva from ItemRandom ", null);

        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            ModeloItemsRandom model = new ModeloItemsRandom();
            model.setNombre(cursor.getString(0));
            model.setTipo(cursor.getString(1));
            model.setPhysicalPower(cursor.getInt(3));
            model.setCosto(cursor.getInt(2));
            model.setPasive(cursor.getString(4));
            list.add(model);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return list;
    }


    public ArrayList<ModeloItemsRandom> Lllamada(String type) {
        ArrayList<ModeloItemsRandom> list = new ArrayList<>();
        open();
        Cursor cursor = bdGods.rawQuery("SELECT Nombre,Costo,PhysicalPower,MagicalPower,Mana,AtackSpeed,Health,CooldownReduction,MovementSpeed,MPS,Penetration,MagicalProtection,PhysicalProtection,Lifesteal,CriticalStrikeChance,CrowdControlReduction,HPS,Pasiva from ItemRandom where Nombre = ? ", null);

        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            ModeloItemsRandom model = new ModeloItemsRandom();
            model.setNombre(cursor.getString(0));
            model.setPhysicalPower(cursor.getInt(2));
            model.setCosto(cursor.getInt(1));
            model.setMagicalPower(cursor.getInt(3));
            model.setMana(cursor.getInt(5));
            model.setAttackSpeed(cursor.getInt(6));
            model.setHealth(cursor.getInt(7));
            model.setCoolDown(cursor.getInt(8));
            model.setMovementSpeed(cursor.getInt(9));
            model.setMPS(cursor.getInt(10));
            model.setPenetration(cursor.getInt(11));
            model.setMagicalProtection(cursor.getInt(12));
            model.setMagicalProtection(cursor.getInt(13));
            model.setLifeSteal(cursor.getInt(14));
            model.setCriticalStrikeChance(cursor.getInt(15));
            model.setCrowdControlReduction(cursor.getInt(16));
            model.setHPS(cursor.getInt(17));
            model.setPasive(cursor.getString(18));
            list.add(model);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return list;
    }

}
