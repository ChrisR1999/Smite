package com.arturo.linearyscrollbar.Controladores;

import android.content.Context;
import android.database.Cursor;

import com.arturo.linearyscrollbar.BD.VinculoBD;
import com.arturo.linearyscrollbar.Modelos.ModeloItemsRandom;

import java.util.ArrayList;

public class ControladorItemsRandom extends VinculoBD {

    public ControladorItemsRandom() {
        super();
    }

    public ControladorItemsRandom(Context context) {
        super(context);
    }

    public ArrayList<ModeloItemsRandom> getAllRandomItems(String type) {
        ArrayList<ModeloItemsRandom> list = new ArrayList<>();
        open();
        Cursor cursor = bdGods.rawQuery("SELECT Nombre FROM ItemRandom WHERE Tipo = ? OR Tipo = ?", new String[]{type, "ambos"});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ModeloItemsRandom model = new ModeloItemsRandom();
            model.setNombre(cursor.getString(0));
            list.add(model);

            cursor.moveToNext();
        }
        cursor.close();
        close();
        return list;
    }

    public ArrayList<ModeloItemsRandom> getStadisticsByType(String type) {
        ArrayList<ModeloItemsRandom> list = new ArrayList<>();
        open();
        Cursor cursor = bdGods.rawQuery("SELECT Nombre, Costo, PhysicalPower, MagicalPower, " +
                        "Mana, AtackSpeed, Health, CooldownReduction, MovementSpeed, MPS, Penetration, " +
                        "MagicalProtection, PhysicalProtection, Lifesteal, CriticalStrikeChance, " +
                        "CrowdControlReduction, HPS, Pasiva FROM ItemRandom WHERE Tipo = ? OR Tipo = ?",
                new String[]{type, "ambos"}
        );
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ModeloItemsRandom model = new ModeloItemsRandom();
            model.setNombre(cursor.getString(0));
            model.setPhysicalPower(cursor.getInt(2));
            model.setCosto(cursor.getInt(1));
            model.setMagicalPower(cursor.getInt(3));
            model.setMana(cursor.getInt(4));
            model.setAttackSpeed(cursor.getInt(5));
            model.setHealth(cursor.getInt(6));
            model.setCoolDown(cursor.getInt(7));
            model.setMovementSpeed(cursor.getInt(8));
            model.setMPS(cursor.getInt(9));
            model.setPenetration(cursor.getInt(10));
            model.setMagicalProtection(cursor.getInt(11));
            model.setPhysicalProtection(cursor.getInt(12));
            model.setLifeSteal(cursor.getInt(13));
            model.setCriticalStrikeChance(cursor.getInt(14));
            model.setCrowdControlReduction(cursor.getInt(15));
            model.setHPS(cursor.getInt(16));
            model.setPasive(cursor.getString(17));
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
        Cursor cursor = bdGods.rawQuery("SELECT Nombre,Tipo,Costo,Pasiva from ItemRandom ", null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            ModeloItemsRandom model = new ModeloItemsRandom();
            model.setNombre(cursor.getString(0));
            model.setTipo(cursor.getString(1));
            //model.setPhysicalPower(cursor.getInt(3));
            model.setCosto(cursor.getInt(2));
            model.setPasive(cursor.getString(3));
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
        Cursor cursor = bdGods.rawQuery("" +
                "SELECT Nombre,Costo,PhysicalPower," +
                "MagicalPower,Mana,AtackSpeed,Health," +
                "CooldownReduction,MovementSpeed,MPS," +
                "Penetration,MagicalProtection,PhysicalProtection," +
                "Lifesteal,CriticalStrikeChance,CrowdControlReduction," +
                "HPS,Pasiva,PasivaEs " +
                "FROM ItemRandom " +
                "WHERE Nombre = ? ", new String[]{type});

        cursor.moveToFirst();


        ModeloItemsRandom model = new ModeloItemsRandom();
        model.setNombre(cursor.getString(0));
        model.setPhysicalPower(cursor.getInt(2));
        model.setCosto(cursor.getInt(1));
        model.setMagicalPower(cursor.getInt(3));
        model.setMana(cursor.getInt(4));
        model.setAttackSpeed(cursor.getInt(5));
        model.setHealth(cursor.getInt(6));
        model.setCoolDown(cursor.getInt(7));
        model.setMovementSpeed(cursor.getInt(8));
        model.setMPS(cursor.getInt(9));
        model.setPenetration(cursor.getInt(10));
        model.setMagicalProtection(cursor.getInt(11));
        model.setPhysicalProtection(cursor.getInt(12));
        model.setLifeSteal(cursor.getInt(13));
        model.setCriticalStrikeChance(cursor.getInt(14));
        model.setCrowdControlReduction(cursor.getInt(15));
        model.setHPS(cursor.getInt(16));
        model.setPasive(cursor.getString(17));
        model.setPasivees(cursor.getString(18));
        list.add(model);

        cursor.close();
        close();
        return list;
    }

}
