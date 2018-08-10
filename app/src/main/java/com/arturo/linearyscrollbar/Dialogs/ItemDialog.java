package com.arturo.linearyscrollbar.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.arturo.linearyscrollbar.Modelos.ModeloItemsRandom;
import com.arturo.linearyscrollbar.R;
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
        linearItems.setOrientation(LinearLayout.VERTICAL);
        scroll.addView(linearItems);
    }

    private void createDialog() {
        AlertDialog.Builder build = new AlertDialog.Builder(activity);
        build.setTitle(title);
        for (final ModeloItemsRandom c : items) {
            final LayoutInflater inflater = LayoutInflater.from(context);
            final View dialogLayout = inflater.inflate(R.layout.item_card, null);
            final LinearLayout item = new LinearLayout(context);
            final ImageView image = dialogLayout.findViewById(R.id.imageCard);
            final TextView name = dialogLayout.findViewById(R.id.itemNameCard);
            final TextView cost = dialogLayout.findViewById(R.id.itemCostCard);
            image.setImageResource(context.getResources().getIdentifier(
                    StringUtillities.parseItemName(c.getNombre()),
                    "mipmap",
                    context.getPackageName()));
            name.setText(c.getNombre());
            cost.setText(c.getCosto());
            linearItems.addView(image);
        }
        build.setView(scroll);
        build.setNegativeButton("Cancelar",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog = build.create();
    }

    public void invokeDialog(){
        dialog.show();
    }
}