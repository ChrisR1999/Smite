package com.arturo.linearyscrollbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arturo.linearyscrollbar.Controladores.ControladorItemsRandom;
import com.arturo.linearyscrollbar.Modelos.ModeloItemsRandom;
import com.arturo.linearyscrollbar.Utillities.StringUtillities;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class TodosLosItems extends AppCompatActivity {

    private Button regreso;
    private Button Magicos;
    private Button Fisicos;
    private Button Ambos;
    private TextView allItems;
    private LinearLayout ln1;
    private LinearLayout ln2;
    private LinearLayout ln3;
    private LinearLayout ln4;
    private LinearLayout linearambos;
    private LinearLayout linearItem;
    private LinearLayout linearItemMagicos;
    private ArrayList<ModeloItemsRandom> itemList;
    private int nummagicos = 0;
    private int numfisicos = 0;
    private int numambos = 0;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_los_items);
        initComponents();
    }


    public void initComponents() {
        itemList = new ControladorItemsRandom(this).TodosLosITems();
        allItems = new TextView(this);
        Magicos = new Button(this);
        Fisicos = new Button(this);
        Ambos = new Button(this);
        linearItem = new LinearLayout(this);
        linearItemMagicos = new LinearLayout(this);
        linearambos = new LinearLayout(this);
        regreso = new Button(this);
        ln1 = new LinearLayout(this);
        ln2 = (LinearLayout) findViewById(R.id.linearabajo3);
        ln3 = new LinearLayout(this);
        ln4 = new LinearLayout(this);

        ln1.setOrientation(LinearLayout.VERTICAL);
        ln1.setBackgroundColor(getResources().getColor(R.color.Negro));
        ln2.setBackgroundColor(getResources().getColor(R.color.Negro));
        ln3.setOrientation(LinearLayout.HORIZONTAL);
        ln3.setBackgroundColor(getResources().getColor(R.color.Negro));
        ln4.setOrientation(LinearLayout.HORIZONTAL);
        ln4.setBackgroundColor(getResources().getColor(R.color.Negro));

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

        allItems.setText(R.string.todoslositems);
        allItems.setTextSize(25);
        allItems.setTextColor(getResources().getColor(R.color.Blanco));
        allItems.setGravity(Gravity.CENTER);

        Magicos.setText(R.string.magicos);
        Magicos.setTextSize(25);
        Magicos.setTextColor(getResources().getColor(R.color.gris));
        Magicos.setGravity(Gravity.CENTER);
        Magicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nummagicos == 0) {
                    ln3.setVisibility(View.VISIBLE);
                    nummagicos = 1;
                } else {
                    ln3.setVisibility(View.GONE);
                    nummagicos = 0;

                }


            }
        });

        Fisicos.setText(R.string.fisicos);
        Fisicos.setTextSize(25);
        Fisicos.setTextColor(getResources().getColor(R.color.gris));
        Fisicos.setGravity(Gravity.CENTER);
        Fisicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numfisicos == 0) {
                    ln1.setVisibility(View.VISIBLE);
                    numfisicos = 1;
                } else {
                    ln1.setVisibility(View.GONE);
                    numfisicos = 0;
                }
            }
        });

        Ambos.setText(R.string.general);
        Ambos.setTextSize(25);
        Ambos.setTextColor(getResources().getColor(R.color.gris));
        Ambos.setGravity(Gravity.CENTER);
        Ambos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numambos == 0) {
                    ln4.setVisibility(View.VISIBLE);
                    numambos = 1;
                } else {
                    ln4.setVisibility(View.GONE);
                    numambos = 0;
                }
            }
        });

        ln2.addView(allItems);
        ln2.addView(Ambos);

        linearItem.setOrientation(LinearLayout.VERTICAL);
        linearItemMagicos.setOrientation(LinearLayout.VERTICAL);
        linearambos.setOrientation(LinearLayout.VERTICAL);

        for (ModeloItemsRandom mi: itemList) {
            final ImageButton image = new ImageButton(this);
            final LinearLayout campito = new LinearLayout(this);
            final TextView Costo = new TextView(this);
            final TextView Nombre = new TextView(this);
            final TextView mas = new TextView(this);
            final String item = mi.getNombre();
            final String tipo = mi.getTipo();
            final int costo = mi.getCosto();

            campito.setOrientation(LinearLayout.HORIZONTAL);
            image.setImageResource(getResources().getIdentifier(StringUtillities.parseItemName(item), "mipmap", getPackageName()));
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openItem(item);
                }
            });
            Nombre.setText(item);
            Nombre.setTextColor(getResources().getColor(R.color.amarillo));

            Costo.setText(getResources().getString(R.string.costo) + " " + String.valueOf(costo) + " ");
            Costo.setTextColor(getResources().getColor(R.color.Blanco));

            mas.setText(getResources().getString(R.string.mas));
            mas.setTextColor(getResources().getColor(R.color.verde));

            if (tipo.equals("fisico")) {
                campito.addView(image);
                campito.addView(Costo);
                campito.addView(Nombre);
                campito.addView(mas);
                linearItem.addView(campito);
            } else {
                if (tipo.equals("magico")) {
                    campito.addView(image);
                    campito.addView(Costo);
                    campito.addView(Nombre);
                    campito.addView(mas);
                    linearItemMagicos.addView(campito);
                } else {
                    campito.addView(image);
                    campito.addView(Costo);
                    campito.addView(Nombre);
                    campito.addView(mas);
                    linearambos.addView(campito);
                }
            }
        }

        ln4.addView(linearambos);
        ln1.addView(linearItem);

        ln2.addView(ln4);
        ln2.addView(Fisicos);
        ln2.addView(ln1);
        ln2.addView(Magicos);
        ln3.addView(linearItemMagicos);
        ln2.addView(ln3);
        ln2.addView(regreso);

        ln4.setVisibility(View.GONE);
        ln1.setVisibility(View.GONE);
        ln3.setVisibility(View.GONE);

    }


    public void openItem(String item) {

        Intent intent = new Intent(this, DotosDeLosItems.class);
        intent.putExtra("nombre", item);
        startActivity(intent);

    }

    public void RegresoMenu() {
        Intent mandar = new Intent(this, MainActivity.class);
        startActivity(mandar);
        finish();
    }
}
