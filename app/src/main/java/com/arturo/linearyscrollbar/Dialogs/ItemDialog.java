package com.arturo.linearyscrollbar.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.arturo.linearyscrollbar.Modelos.ModeloItemsRandom;
import com.arturo.linearyscrollbar.Utillities.StringUtillities;

import java.util.ArrayList;

public class ItemDialog {
    private Context context;
    private Activity activity;
    private String title;
    private AlertDialog dialog;
    private ScrollView scroll;
    private LinearLayout linearItems;
    private int[] bannedItems;
    private ArrayList<ModeloItemsRandom> items;

    public ItemDialog(Context context, Activity activity, String title, ArrayList<ModeloItemsRandom> items) {
        this.context = context;
        this.activity = activity;
        this.title = title;
        this.items = items;
        initComponents();
        createDialog();
    }

    private void initComponents() {
        scroll = new ScrollView(context);
        linearItems = new LinearLayout(context);
        scroll.addView(linearItems);
    }

    private void createDialog() {
        AlertDialog.Builder build = new AlertDialog.Builder(activity);
        build.setTitle(title);
        for (final ModeloItemsRandom c : items) {
            final ImageView image = new ImageView(context);
            image.setImageResource(context.getResources().getIdentifier(
                    StringUtillities.parseItemName(c.getNombre()),
                    "mipmap",
                    context.getPackageName()));
            linearItems.addView(image);
        }
        build.setView(linearItems);

    }
}
