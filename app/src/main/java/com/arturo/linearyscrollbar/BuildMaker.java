package com.arturo.linearyscrollbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.arturo.linearyscrollbar.Controladores.ControladorItemsRandom;
import com.arturo.linearyscrollbar.Modelos.ModeloItemsRandom;
import com.arturo.linearyscrollbar.Utillities.StringUtillities;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Collections;

public class BuildMaker extends AppCompatActivity {
    private AdView mAdView;
    private Typeface bebas = null;
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
    private AlertDialog dialog;
    private Button backButton;
    private ArrayList<ModeloItemsRandom> itemsList;
    private ArrayList<Integer> itemsSelected;
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
        bebas = Typeface.createFromAsset(getAssets(),"arremaquina.ttf");
        MobileAds.initialize(this, "ca-app-pub-5146175048698339~6692980600");
        mAdView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        initComponents();
    }

    private void initComponents() {
        Intent intent = getIntent();
        itemsSelected = new ArrayList<Integer>();
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
        backButton = (Button) findViewById(R.id.backBuildButton);
        godName = intent.getStringExtra("godName");
        godType = intent.getStringExtra("godType");
        if(godType.equals("mago"))
            godType = "magico";
        itemsList = new ControladorItemsRandom(this).getStadisticsByType(godType);
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
        itemImage.setTag(-1);
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
        createDialog(image);
    }

    private void createDialog(final ImageButton imageItem) {
        final AlertDialog.Builder build = new AlertDialog.Builder(this);
        final LinearLayout linearItems = new LinearLayout(this);
        final ScrollView scroll = new ScrollView(this);
        int count = 0;
        linearItems.setOrientation(LinearLayout.VERTICAL);
        build.setTitle("");
        build.setView(null);
        if (itemsSelected.size() > 0) {
            Collections.sort(itemsSelected);
        }
        for (final ModeloItemsRandom c : itemsList) {
            final LayoutInflater inflater = LayoutInflater.from(this);
            final View dialogLayout = inflater.inflate(R.layout.item_card, null);
            final ImageView image = (ImageView) dialogLayout.findViewById(R.id.imageCard);
            final TextView name = (TextView) dialogLayout.findViewById(R.id.itemNameCard);
            final TextView cost = (TextView) dialogLayout.findViewById(R.id.itemCostCard);

            boolean exist = false;

            if (itemsSelected.size() > 0) {
                if(count < itemsSelected.size()) {
                    if (itemsList.get(itemsSelected.get(count)) == c) {
                        count++;
                        exist = true;
                    }
                }
            }

            if (!exist) {
                dialogLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //view.setBackgroundColor(context.getResources().getColor(R.color.foreground));
                        if ((int) imageItem.getTag() != -1) {
                            int previousIndex = (int) imageItem.getTag();
                            itemsSelected.remove((Object) itemsList.lastIndexOf(itemsList.get(previousIndex)));
                        }
                        imageItem.setImageResource(getResources().getIdentifier(
                                StringUtillities.parseItemName(c.getNombre()),
                                "mipmap",
                                getPackageName()));
                        imageItem.setTag(itemsList.lastIndexOf(c));
                        setStadistics(itemsList.lastIndexOf(c), 1);
                        dialog.dismiss();
                    }
                });

                image.setImageResource(getResources().getIdentifier(
                        StringUtillities.parseItemName(c.getNombre()),
                        "mipmap",
                        getPackageName()));
                name.setText(c.getNombre());
                cost.setText(cost.getText().toString() + c.getCosto());


                linearItems.addView(dialogLayout);
            }
        }
        for (Integer cc: itemsSelected){
            Toast.makeText(this, cc.toString(), Toast.LENGTH_SHORT).show();
        }
        scroll.addView(linearItems);
        build.setView(scroll);
        build.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog = build.create();
        dialog.show();
    }

    private void setStadistics(int indexItem, int action) {

        bebas = Typeface.createFromAsset(getAssets(),"arremaquina.ttf");
        initStadistics();
        if (action == 1)
            itemsSelected.add(indexItem);
        for (Integer q : itemsSelected) {
            final ModeloItemsRandom modelo = itemsList.get(q);
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
        buildStadistics.setText("");
        buildStadistics.setTypeface(bebas);
        buildStadistics.setBackgroundColor(getResources().getColor(R.color.azulclaro));
        buildStadistics.setTextColor(getResources().getColor(R.color.monitaa));
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
                        "\nHPS: " + hps+
                        "\n." +
                        "\n." +
                        "\n."

        );

    }

    private void initStadistics() {
        physicalPower = 0;
        magicalPower = 0;
        mana = 0;
        attackSpeed = 0;
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
    }

    private void quitItem(ImageButton image, int pos) {
        if ((int) image.getTag() != 0) {
            itemsSelected.remove((Object) itemsList.lastIndexOf(itemsList.get((int) image.getTag())));
            image.setTag(-1);
            image.setImageDrawable(getResources().getDrawable(R.drawable.ic_if_plus));
            setStadistics(0, 0);
        }
    }

    public void RegresoMenu(View view) {
        Intent mandar = new Intent(this, MainActivity.class);
        startActivity(mandar);
        finish();
    }

    public void recargarlista2(View view) {
        Intent intent = new Intent(this, TodosLosItems.class);
        startActivity(intent);
    }
}
