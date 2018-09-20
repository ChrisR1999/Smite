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
import android.widget.Toast;

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
    private View auxView;
    private int[] bannedItems;
    private ArrayList<ModeloItemsRandom> items;
    private int indexSelected;
    private boolean selected;

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
        auxView = null;
        selected = false;
    }

    private void createDialog() {
        AlertDialog.Builder build = new AlertDialog.Builder(context);
        build.setTitle(title);
        for (final ModeloItemsRandom c : items) {
            final LayoutInflater inflater = LayoutInflater.from(context);
            final View dialogLayout = inflater.inflate(R.layout.item_card, null);
            final ImageView image = (ImageView) dialogLayout.findViewById(R.id.imageCard);
            final TextView name = (TextView) dialogLayout.findViewById(R.id.itemNameCard);
            final TextView cost = (TextView) dialogLayout.findViewById(R.id.itemCostCard);

            dialogLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //view.setBackgroundColor(context.getResources().getColor(R.color.foreground));
                    indexSelected = items.lastIndexOf(c);
                    dialog.dismiss();
                }
            });
            image.setImageResource(context.getResources().getIdentifier(
                    StringUtillities.parseItemName(c.getNombre()),
                    "mipmap",
                    context.getPackageName()));
            name.setText(c.getNombre());
            // cost.setText(c.getCosto());
            linearItems.addView(dialogLayout);
        }
        build.setView(scroll);
        build.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog = build.create();
    }

    public void invokeDialog() {
        dialog.show();
    }

    public int getItem() {
        Toast.makeText(context, String.valueOf(indexSelected), Toast.LENGTH_SHORT).show();
        return indexSelected;
    }

}
