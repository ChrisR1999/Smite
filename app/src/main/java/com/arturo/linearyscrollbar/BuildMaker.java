package com.arturo.linearyscrollbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.arturo.linearyscrollbar.Controladores.ControladorItemsRandom;
import com.arturo.linearyscrollbar.Dialogs.ItemDialog;
import com.arturo.linearyscrollbar.Modelos.ModeloItemsRandom;

import java.util.ArrayList;

public class BuildMaker extends AppCompatActivity {
    private ImageButton itemImage1;
    private ImageButton itemImage2;
    private ImageButton itemImage3;
    private ImageButton itemImage4;
    private ImageButton itemImage5;
    private ImageButton itemImage6;
    private ImageView godImage;
    private ArrayList<ModeloItemsRandom> itemsList;
    private ModeloItemsRandom[] itemsSelected;
    private String godName;
    private String godType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_maker);
        initComponents();
    }

    private void initComponents() {
        Intent intent = getIntent();
        itemsSelected = new ModeloItemsRandom[7];
        itemImage1 = (ImageButton) findViewById(R.id.itemBuild1);
        itemImage2 = (ImageButton) findViewById(R.id.itemBuild2);
        itemImage3 = (ImageButton) findViewById(R.id.itemBuild3);
        itemImage4 = (ImageButton) findViewById(R.id.itemBuild4);
        itemImage5 = (ImageButton) findViewById(R.id.itemBuild5);
        itemImage6 = (ImageButton) findViewById(R.id.itemBuild6);
        godName = intent.getStringExtra("name");
        godType = intent.getStringExtra("type");
        itemsList = new ControladorItemsRandom(this).getAllRandomItems(godType);
        setOnClickList(itemImage1, 0);
        setOnClickList(itemImage2, 1);
        setOnClickList(itemImage3, 2);
        setOnClickList(itemImage4, 3);
        setOnClickList(itemImage5, 4);
        setOnClickList(itemImage6, 5);
    }

    private void setOnClickList(final ImageButton itemImage, final int pos) {
        itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWindowSelector(itemImage, pos);
            }
        });
        itemImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                quitItem(itemImage, pos);
                return true;
            }
        });
    }

    private void openWindowSelector(ImageButton image, int pos) {
        ItemDialog dialog = new ItemDialog(this, this, "Hola", itemsList);
        dialog.invokeDialog();
    }

    private void quitItem(ImageButton image, int pos) {
        image.setImageDrawable(getResources().getDrawable(R.drawable.ic_if_plus));
    }
}
