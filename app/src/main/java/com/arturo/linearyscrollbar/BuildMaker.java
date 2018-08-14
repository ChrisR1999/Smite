package com.arturo.linearyscrollbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.arturo.linearyscrollbar.Controladores.ControladorItemsRandom;
import com.arturo.linearyscrollbar.Modelos.ModeloItemsRandom;
import com.arturo.linearyscrollbar.Utillities.StringUtillities;

import java.util.ArrayList;

public class BuildMaker extends AppCompatActivity {
    private ImageButton itemImage1;
    private ImageButton itemImage2;
    private ImageButton itemImage3;
    private ImageButton itemImage4;
    private ImageButton itemImage5;
    private ImageButton itemImage6;
    private TextView godTitle;
    private TextView buildStadistics;
    private TextView priceBuild;
    private ImageView godImage;
    private ScrollView scroll;
    private AlertDialog dialog;
    private LinearLayout linearItems;
    private ArrayList<ModeloItemsRandom> itemsList;
    private ArrayList itemsSelected;
    private String godName;
    private String godType;
    private int physicalPower;
    private int magicalPower;
    private int mana;
    private int attackSpeed;
    private int health;
    private int coolDownReduction;
    private int movementSpeed;
    private int mps;
    private int penetration;
    private int magicalProtection;
    private int physicalProtection;
    private int lifeSteal;
    private int criticalStrikeChance;
    private int crowdControlReduction;
    private int hps;
    private int buildPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_maker);
        initComponents();
    }

    private void initComponents() {
        Intent intent = getIntent();
        itemsSelected = new ArrayList<>();
        scroll = new ScrollView(this);
        linearItems = new LinearLayout(this);
        linearItems.setOrientation(LinearLayout.VERTICAL);
        scroll.addView(linearItems);
        itemImage1 = (ImageButton) findViewById(R.id.itemBuild1);
        itemImage2 = (ImageButton) findViewById(R.id.itemBuild2);
        itemImage3 = (ImageButton) findViewById(R.id.itemBuild3);
        itemImage4 = (ImageButton) findViewById(R.id.itemBuild4);
        itemImage5 = (ImageButton) findViewById(R.id.itemBuild5);
        itemImage6 = (ImageButton) findViewById(R.id.itemBuild6);
        godTitle = (TextView) findViewById(R.id.godBuildTitle);
        priceBuild = (TextView) findViewById(R.id.price);
        buildStadistics = (TextView) findViewById(R.id.buildStadistics);
        godImage = (ImageView) findViewById(R.id.godBuildImage);
        godName = "Agni";
        godType = "magico";
        physicalPower = 0;
        magicalPower = 0;
        mana = 0;
        health = 0;
        coolDownReduction = 0;
        movementSpeed = 0;
        mps = 0;
        penetration = 0;
        magicalProtection = 0;
        physicalProtection = 0;
        lifeSteal = 0;
        criticalStrikeChance = 0;
        crowdControlReduction = 0;
        hps = 0;
        buildPrice = 0;
        itemsList = new ControladorItemsRandom(this).TodosLosITems(godType);
        godTitle.setText(godName);
        godImage.setImageResource(getResources().getIdentifier(StringUtillities.parseItemName(godName), "mipmap", getPackageName()));
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
        int itemSelected;
        createDialog(image);
    }

    private void createDialog(final ImageButton imageItem) {
        final AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setTitle("");
        for (final ModeloItemsRandom c : itemsList) {
            final LayoutInflater inflater = LayoutInflater.from(this);
            final View dialogLayout = inflater.inflate(R.layout.item_card, null);
            final ImageView image = (ImageView) dialogLayout.findViewById(R.id.imageCard);
            final TextView name = (TextView) dialogLayout.findViewById(R.id.itemNameCard);
            final TextView cost = (TextView) dialogLayout.findViewById(R.id.itemCostCard);

            dialogLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //view.setBackgroundColor(context.getResources().getColor(R.color.foreground));
                    setStadistics(imageItem, c.getNombre() ,itemsList.lastIndexOf(c));
                    dialog.dismiss();
                }
            });
            image.setImageResource(getResources().getIdentifier(
                    StringUtillities.parseItemName(c.getNombre()),
                    "mipmap",
                    getPackageName()));
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
        dialog.show();
    }

    private void setStadistics(ImageButton image, String itemName,  int indexItem) {
        itemsSelected.add(indexItem);
        for (Object c: itemsSelected){
            final ModeloItemsRandom modelo = itemsList.get((Integer) c);
            physicalPower += modelo.getPhysicalPower();
            magicalPower += modelo.getMagicalPower();
            mana += modelo.getMana();
            attackSpeed += modelo.getAttackSpeed();
            health += modelo.getHealth();
            coolDownReduction += modelo.getCoolDown();
            movementSpeed += modelo.getMovementSpeed();
            mps += modelo.getMPS();
            penetration += modelo.getPenetration();
            magicalProtection += modelo.getMagicalProtection();
            physicalProtection += modelo.getPhysicalProtection();
            lifeSteal += modelo.getLifeSteal();
            criticalStrikeChance += modelo.getCriticalStrikeChance();
            crowdControlReduction += modelo.getCrowdControlReduction();
            hps += modelo.getHPS();
            buildPrice += modelo.getCosto();
        }

        priceBuild.setText(String.valueOf(buildPrice));
        image.setImageResource(getResources().getIdentifier(StringUtillities.parseItemName(itemName), "mipmap", getPackageName()));
        buildStadistics.setText("");
        buildStadistics.setText(
                "Estadisticas" +
                "\nAtaque fisico: " + physicalPower +
                "\nAtaque magico: " + magicalPower +
                "\nMana: " + mana +
                "\nVel. ataque:" + attackSpeed +
                "\nSalud: " + health +
                "\nCooldown: " + coolDownReduction +
                "\nVel. movimiento: " + movementSpeed +
                "\nMPS: " + mps +
                "\nPenetracion: " + penetration +
                "\nProt. magica: " + magicalProtection +
                "\nProt. fisica: " + physicalProtection +
                "\nRobo de vida: " + lifeSteal +
                "\nChance de critico: " + criticalStrikeChance +
                "\nI Dunno: " + crowdControlReduction +
                "\nHPS: " + hps
        );

    }

    private void quitItem(ImageButton image, int pos) {
        image.setImageDrawable(getResources().getDrawable(R.drawable.ic_if_plus));
    }
}
