package com.cristofer.scrollybar1.Controladores;

import android.content.Context;
import android.database.Cursor;

import com.cristofer.scrollybar1.BD.VinculoBD;

public class ControladorItems extends VinculoBD {

    public ControladorItems() {
        super();
    }

    public ControladorItems(Context context) {
        super(context);
    }

    public String[] pullItemsByType(int type) {
        String[] items;
        open();
        Cursor cursor = bdGods.rawQuery("SELECT item1, item2, item3, item4, item5, item6, item7, item8, item9, item10 FROM items WHERE tipo = ?", new String[]{String.valueOf(type)});
        items = new String[10];
        cursor.moveToFirst();
        for (int i = 0; i < 10; i++)
            items[i] = cursor.getString(i);
        cursor.close();
        close();
        return items;
    }

}
