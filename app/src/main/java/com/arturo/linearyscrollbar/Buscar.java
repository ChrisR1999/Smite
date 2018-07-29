package com.arturo.linearyscrollbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arturo.linearyscrollbar.Controladores.ControladorDioses;
import com.arturo.linearyscrollbar.Controladores.ControladorItems;
import com.arturo.linearyscrollbar.Modelos.ModeloDioses;
import com.arturo.linearyscrollbar.Utillities.StringUtillities;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class Buscar extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView combotext;
    private TextView starterDivider;
    private TextView coreDivider;
    private TextView attackDivider;
    private TextView defenseDivider;
    private Button tv5;
    private Button tv6;
    private Button tv7;
    private Button tv8;
    private Button regreso;
    private ImageButton imagenPrueba;
    private HorizontalScrollView scrollCounters;
    private HorizontalScrollView scrollCountersBy;
    private LinearLayout ln1;
    private LinearLayout ln2;
    private LinearLayout ln3;
    private LinearLayout linerdecombo;
    private LinearLayout linearCountersBy;
    private LinearLayout linearCounters;
    private LinearLayout linearStarter;
    private LinearLayout linearCore;
    private LinearLayout linearAttack;
    private LinearLayout linearDefense;
    private String godName;
    private String godType;
    private ImageButton[] imageCountersBy;
    private ImageButton[] imageCounter;
    private ImageButton fotocounter2;
    private Toolbar mToolbar;
    private AdView mAdView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;


    }

    private void initComponents() {
        tv1 = new TextView(this);
        tv2 = new TextView(this);
        tv3 = new TextView(this);
        tv4 = new TextView(this);
        combotext = new TextView(this);
        starterDivider = new TextView(this);
        coreDivider = new TextView(this);
        attackDivider = new TextView(this);
        defenseDivider = new TextView(this);
        tv5 = new Button(this);
        tv6 = new Button(this);
        tv7 = new Button(this);
        tv8 = new Button(this);

        regreso = new Button(this);
        imageCountersBy = new ImageButton[10];
        imageCounter = new ImageButton[3];
        imagenPrueba = new ImageButton(this);
        scrollCountersBy = new HorizontalScrollView(this);
        scrollCounters = new HorizontalScrollView(this);
        linearStarter = new LinearLayout(this);
        linearStarter.setOrientation(LinearLayout.HORIZONTAL);
        linearStarter.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);
        linearCore = new LinearLayout(this);
        linearCore.setOrientation(LinearLayout.HORIZONTAL);
        linearCore.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);
        linearAttack = new LinearLayout(this);
        linearAttack.setOrientation(LinearLayout.HORIZONTAL);
        linearAttack.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);
        linearDefense = new LinearLayout(this);
        linearDefense.setOrientation(LinearLayout.HORIZONTAL);
        linearDefense.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);
        linerdecombo = new LinearLayout(this);
        linerdecombo.setOrientation(LinearLayout.VERTICAL);
        linerdecombo.setBackgroundColor(getResources().getColor(R.color.Negro));
        godName = getIntent().getStringExtra("name");
        godType = getIntent().getStringExtra("type");
        ln2 = (LinearLayout) findViewById(R.id.linearabajo);
        ln2.setBackgroundColor(getResources().getColor(R.color.Negro));
        linearCountersBy.setOrientation(LinearLayout.HORIZONTAL);
        linearCountersBy.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);
        linearCounters.setOrientation(LinearLayout.HORIZONTAL);
        linearCounters.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);
        ln1 = new LinearLayout(this);
        ln1.setOrientation(LinearLayout.HORIZONTAL);
        ln1.setBackgroundColor(getResources().getColor(R.color.Negro));
        ln3 = new LinearLayout(this);
        ln3.setOrientation(LinearLayout.HORIZONTAL);
        ln3.setBackgroundColor(getResources().getColor(R.color.Negro));

        tv1.setText(R.string.Conterea);
        tv1.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        tv1.setEnabled(false);
        tv1.setTextSize(25);
        tv1.setTextColor(getResources().getColor(R.color.Blanco));
        tv1.setBackgroundColor(getResources().getColor(R.color.Negro));

        tv2.setText(R.string.EsContereado);
        tv2.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        tv2.setEnabled(false);
        tv2.setTextSize(25);
        tv2.setTextColor(getResources().getColor(R.color.Blanco));
        tv2.setBackgroundColor(getResources().getColor(R.color.Negro));

        tv3.setText(godName);
        tv3.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        tv3.setEnabled(false);
        tv3.setTextSize(25);
        tv3.setTextColor(getResources().getColor(R.color.Blanco));
        tv3.setBackgroundColor(getResources().getColor(R.color.Negro));

        tv4.setText("Combo");
        tv4.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        tv4.setEnabled(false);
        tv4.setTextSize(25);
        tv4.setTextColor(getResources().getColor(R.color.Blanco));
        tv4.setBackgroundColor(getResources().getColor(R.color.Negro));

        tv5.setText(R.string.BuildsPopulares);
        tv5.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        tv5.setEnabled(false);
        tv5.setTextSize(25);
        tv5.setTextColor(getResources().getColor(R.color.Blanco));
        tv5.setBackgroundColor(getResources().getColor(R.color.Negro));

        regreso.setText(R.string.regresar);
        regreso.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        regreso.setTextSize(25);
        regreso.setTextColor(getResources().getColor(R.color.Negro));

        regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegresoMenu();
            }
        });

        tv6.setText(R.string.conquista);
        tv6.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);

        tv6.setTextSize(25);
        tv6.setTextColor(getResources().getColor(R.color.Negro));

        tv7.setText(R.string.arena);
        tv7.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);

        tv7.setTextSize(25);
        tv7.setTextColor(getResources().getColor(R.color.Negro));
        // tv7.setBackgroundColor(getResources().getColor(R.color.gris));

        tv8.setText(R.string.justa);
        tv8.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);

        tv8.setTextSize(25);
        tv8.setTextColor(getResources().getColor(R.color.Negro));
        // tv8.setBackgroundColor(getResources().getColor(R.color.gris));

        starterDivider.setText(R.string.starterItem);
        starterDivider.setTextSize(25);
        starterDivider.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        starterDivider.setTextColor(getResources().getColor(R.color.Negro));

        coreDivider.setText(R.string.coreItem);
        coreDivider.setTextSize(25);
        coreDivider.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        coreDivider.setTextColor(getResources().getColor(R.color.Negro));

        attackDivider.setText(R.string.attackItem);
        attackDivider.setTextSize(25);
        attackDivider.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        attackDivider.setTextColor(getResources().getColor(R.color.Negro));

        defenseDivider.setText(R.string.defenseItem);
        defenseDivider.setTextSize(25);
        defenseDivider.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        defenseDivider.setTextColor(getResources().getColor(R.color.Negro));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        initComponents();
        final ImageView btn = new ImageView(this);
        final ControladorDioses controlador = new ControladorDioses(this);
        final ControladorItems controladorI = new ControladorItems(this);
        final ModeloDioses datos = controlador.godStadistics(godName);
        final String combo = datos.getGodCombo();
        final ArrayList<String> countersBy = datos.getCountersBy();
        final ArrayList<String> counters = datos.getCounter();
        final String[] items = controladorI.pullItemsByType(godType);
        // final String counter = datos.getCounter();
        final String resourceImage = datos.getResourceImage();
        int cont = 0;
        int cont2 = 0;


        combotext.setText(combo);
        combotext.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        combotext.setEnabled(false);
        combotext.setTextSize(25);
        combotext.setTextColor(getResources().getColor(R.color.Blanco));
        combotext.setBackgroundColor(getResources().getColor(R.color.Negro));

        btn.setImageResource(getResources().getIdentifier(resourceImage, "mipmap", getPackageName()));
        btn.setBackgroundColor(getResources().getColor(R.color.Negro));
        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));


        linerdecombo.addView(tv4);
        linerdecombo.addView(combotext);

        ln1.addView(linerdecombo);
        ln1.addView(btn);
        ln3.addView(regreso);
        ln3.addView(tv3);
        ln2.addView(ln3);
        ln2.addView(ln1);
        ln2.addView(tv1);
        ln2.addView(scrollCounters);
        scrollCounters.addView(linearCounters);
        ln2.addView(tv2);
        ln2.addView(scrollCountersBy);
        scrollCountersBy.addView(linearCountersBy);

        for (final String coun : counters) {

            imageCounter[cont2] = new ImageButton(this);
            if (coun != null) {
                imageCounter[cont2].setImageResource(getResources().getIdentifier(coun, "mipmap", getPackageName()));
                imageCounter[cont2].setTag(coun);
                imageCounter[cont2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        counterSearch(coun);
                    }
                });
                linearCounters.addView(imageCounter[cont2]);
                cont++;
            }
        }


        for (final String cs : countersBy) {
            imageCountersBy[cont] = new ImageButton(this);
            if (cs != null) {
                imageCountersBy[cont].setImageResource(getResources().getIdentifier(cs, "mipmap", getPackageName()));
                imageCountersBy[cont].setTag(cs);
                imageCountersBy[cont].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        counterSearch(cs);
                    }
                });
                linearCountersBy.addView(imageCountersBy[cont]);
                cont++;
            }
        }

        imagenPrueba.setImageResource(getResources().getIdentifier("armor", "mipmap", getPackageName()));
        imagenPrueba.setTag("armor");

        for (int i = 0; i < items.length; i++) {
            ImageButton item = new ImageButton(this);
            item.setTag(items[i]);
            item.setImageResource(getResources().getIdentifier(StringUtillities.parseItemName(items[i]), "mipmap", getPackageName()));
            switch (i) {
                case 0:
                    linearStarter.addView(item);
                    break;
                case 1 | 2 | 3:
                    linearCore.addView(item);
                    break;
                case 4 | 5 | 6:
                    linearAttack.addView(item);
                    break;
                case 7 | 8 | 9:
                    linearDefense.addView(item);
                    break;
            }
        }

        ln2.addView(starterDivider);
        ln2.addView(linearStarter);
        ln2.addView(coreDivider);
        ln2.addView(linearCore);
        ln2.addView(attackDivider);
        ln2.addView(linearAttack);
        ln2.addView(defenseDivider);
        ln2.addView(linearDefense);
        ln2.addView(tv5);
        ln2.addView(tv6);
        ln2.addView(tv7);
        ln2.addView(tv8);
        ln2.addView(imagenPrueba);


        MobileAds.initialize(this, "ca-app-pub-5146175048698339~6692980600");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }


    public void counterSearch(String god) {
        String name = new ControladorDioses(this).getGodNameByResourceImage(god);
        Intent mandar = new Intent(this, Buscar.class);
        mandar.putExtra("name", name);
        startActivity(mandar);
        finish();
    }

    public void RegresoMenu() {
        Intent mandar = new Intent(this, MainActivity.class);
        startActivity(mandar);
        finish();
    }

}
