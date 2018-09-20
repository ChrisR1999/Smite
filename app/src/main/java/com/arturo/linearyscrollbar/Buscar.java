package com.arturo.linearyscrollbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.arturo.linearyscrollbar.Modelos.ModeloDiosesMain;
import com.arturo.linearyscrollbar.Utillities.StringUtillities;
import com.arturo.linearyscrollbar.Utillities.StyleUtillities;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class Buscar extends AppCompatActivity {

    private TextView goodAgainstTitle;
    private TextView badAgainstTitle;
    private TextView godNameTitle;
    private TextView comboTitle;
    private TextView comboText;
    private TextView starterDivider;
    private TextView coreDivider;
    private TextView attackDivider;
    private TextView defenseDivider;
    private Button popularBuildsTitle;
    private Button buildsConquest;
    private Button buildsArena;
    private Button buildsJoust;
    private Button regreso;
    private HorizontalScrollView scrollCounters;
    private HorizontalScrollView scrollCountersBy;
    private LinearLayout ln1;
    private LinearLayout ln2;
    private LinearLayout ln3;
    private LinearLayout linearCombo;
    private LinearLayout linearCountersBy;
    private LinearLayout linearCounters;
    private LinearLayout linearStarter;
    private LinearLayout linearCore;
    private LinearLayout linearAttack;
    private LinearLayout linearDefense;
    private String godName;
    private int godType;
    private AdView mAdView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private void initComponents() {
        goodAgainstTitle = new TextView(this);
        badAgainstTitle = new TextView(this);
        godNameTitle = new TextView(this);
        comboTitle = new TextView(this);
        linearCountersBy = new LinearLayout(this);
        linearCounters = new LinearLayout(this);
        comboText = new TextView(this);
        starterDivider = new TextView(this);
        coreDivider = new TextView(this);
        attackDivider = new TextView(this);
        defenseDivider = new TextView(this);
        popularBuildsTitle = new Button(this);
        buildsConquest = new Button(this);
        buildsArena = new Button(this);
        buildsJoust = new Button(this);
        regreso = new Button(this);
        scrollCountersBy = new HorizontalScrollView(this);
        scrollCounters = new HorizontalScrollView(this);
        ln1 = new LinearLayout(this);
        ln2 = (LinearLayout) findViewById(R.id.linearabajo);
        ln3 = new LinearLayout(this);
        linearCombo = new LinearLayout(this);
        linearStarter = new LinearLayout(this);
        linearCore = new LinearLayout(this);
        linearAttack = new LinearLayout(this);
        linearDefense = new LinearLayout(this);

        styleLinearItems(linearStarter);
        styleLinearItems(linearCore);
        styleLinearItems(linearAttack);
        styleLinearItems(linearDefense);

        ln1.setOrientation(LinearLayout.HORIZONTAL);
        ln1.setBackgroundColor(getResources().getColor(R.color.Negro));
        linearCombo.setOrientation(LinearLayout.VERTICAL);
        linearCombo.setBackgroundColor(getResources().getColor(R.color.Negro));
        ln2.setBackgroundColor(getResources().getColor(R.color.Negro));
        ln3.setOrientation(LinearLayout.HORIZONTAL);
        ln3.setBackgroundColor(getResources().getColor(R.color.Negro));
        linearCountersBy.setOrientation(LinearLayout.HORIZONTAL);
        linearCountersBy.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);
        linearCounters.setOrientation(LinearLayout.HORIZONTAL);
        linearCounters.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);

        goodAgainstTitle.setText(R.string.Conte);
        styleHeaders(goodAgainstTitle);

        badAgainstTitle.setText(R.string.EsContereado);
        styleHeaders(badAgainstTitle);

        godNameTitle.setText(godName);
        styleHeaders(godNameTitle);

        comboTitle.setText("Combo");
        styleHeaders(comboTitle);

        popularBuildsTitle.setText(R.string.BuildsPopulares);
        styleHeaders(popularBuildsTitle);

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

        buildsConquest.setText(R.string.conquista);
        buildsConquest.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);

        buildsConquest.setTextSize(25);
        buildsConquest.setTextColor(getResources().getColor(R.color.Negro));

        buildsArena.setText(R.string.arena);
        buildsArena.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);

        buildsArena.setTextSize(25);
        buildsArena.setTextColor(getResources().getColor(R.color.Negro));
        // buildsArena.setBackgroundColor(getResources().getColor(R.color.gris));

        buildsJoust.setText(R.string.justa);
        buildsJoust.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);

        buildsJoust.setTextSize(25);
        buildsJoust.setTextColor(getResources().getColor(R.color.Negro));
        // buildsJoust.setBackgroundColor(getResources().getColor(R.color.gris));

        starterDivider.setText(R.string.starterItem);
        styleHeaders(starterDivider);

        coreDivider.setText(R.string.coreItem);
        styleHeaders(coreDivider);

        attackDivider.setText(R.string.attackItem);
        styleHeaders(attackDivider);

        defenseDivider.setText(R.string.defenseItem);
        styleHeaders(defenseDivider);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        initComponents();
        godName = getIntent().getStringExtra("name");
        godType = getIntent().getIntExtra("type", 0);
        final ImageView btn = new ImageView(this);
        final ControladorDioses controlador = new ControladorDioses(this);
        final ControladorItems controladorI = new ControladorItems(this);
        final ModeloDioses datos = controlador.godStadistics(godName);
        final String combo = datos.getGodCombo();
        final ArrayList<String> countersBy = datos.getCountersBy();
        final ArrayList<String> counters = datos.getCounter();
        final String[] items = controladorI.pullItemsByType(godType);
        final String resourceImage = datos.getResourceImage();

        comboText.setText(combo);
        styleHeaders(comboText);

        btn.setImageResource(getResources().getIdentifier(resourceImage, "mipmap", getPackageName()));
        btn.setBackgroundColor(getResources().getColor(R.color.Negro));
        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));


        linearCombo.addView(comboTitle);
        linearCombo.addView(comboText);

        ln1.addView(linearCombo);
        ln1.addView(btn);
        ln3.addView(regreso);
        ln3.addView(godNameTitle);
        ln2.addView(ln3);
        ln2.addView(ln1);
        ln2.addView(goodAgainstTitle);
        ln2.addView(scrollCounters);
        scrollCounters.addView(linearCounters);
        ln2.addView(badAgainstTitle);
        ln2.addView(scrollCountersBy);
        scrollCountersBy.addView(linearCountersBy);

        for (final String coun : counters) {
            final ImageButton imageCounter = new ImageButton(this);
            if (coun != null) {
                imageCounter.setImageResource(getResources().getIdentifier(coun, "mipmap", getPackageName()));
                imageCounter.setTag(coun);
                imageCounter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        counterSearch(coun);
                    }
                });
                linearCounters.addView(imageCounter);
            }
        }


        for (final String cs : countersBy) {
            ImageButton imageCountersBy = new ImageButton(this);
            if (cs != null) {
                imageCountersBy.setImageResource(getResources().getIdentifier(cs, "mipmap", getPackageName()));
                imageCountersBy.setTag(cs);
                imageCountersBy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        counterSearch(cs);
                    }
                });
                linearCountersBy.addView(imageCountersBy);
            }
        }

        for ( int i = 0; i < 10; i++) {
            final int aux = i;
            final ImageButton item = new ImageButton(this);
            final String newItem = StringUtillities.parseItemName(items[i]);
            item.setTag(items[i]);
            item.setImageResource(getResources().getIdentifier(newItem, "mipmap", getPackageName()));
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openItem(items[aux]);
                }
            });
            StyleUtillities.styleImages(item);

            if (i == 0)
                linearStarter.addView(item);
            if (i > 0 && i < 4)
                linearCore.addView(item);
            if (i > 3 && i < 7)
                linearAttack.addView(item);
            if (i > 6)
                linearDefense.addView(item);
        }

        ln2.addView(starterDivider);
        ln2.addView(linearStarter);
        ln2.addView(coreDivider);
        ln2.addView(linearCore);
        ln2.addView(attackDivider);
        ln2.addView(linearAttack);
        ln2.addView(defenseDivider);
        ln2.addView(linearDefense);
        ln2.addView(popularBuildsTitle);
        ln2.addView(buildsConquest);
        ln2.addView(buildsArena);
        ln2.addView(buildsJoust);

        MobileAds.initialize(this, "ca-app-pub-5146175048698339~6692980600");
        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    public void styleHeaders(TextView style) {
        style.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        style.setEnabled(false);
        style.setTextSize(25);
        style.setTextColor(getResources().getColor(R.color.Blanco));
        style.setBackgroundColor(getResources().getColor(R.color.Negro));
    }
    
    public void styleLinearItems(LinearLayout style){
        style.setOrientation(LinearLayout.HORIZONTAL);
        style.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);
    }

    public void counterSearch(String god) {
        ModeloDiosesMain modelo = new ControladorDioses(this).getGodNameAndTypeByResourceImage(god);
        String name = modelo.getGodName();
        int type = modelo.getGodCategory();
        Intent mandar = new Intent(this, Buscar.class);
        mandar.putExtra("name", name);
        mandar.putExtra("type", type);
        startActivity(mandar);
        finish();
    }

    public void openItem(String item) {
        Intent intent = new Intent(this, DatosDeLosItems.class);
        intent.putExtra("nombre", item);
        startActivity(intent);
    }

    public void RegresoMenu() {
        finish();
    }

}
