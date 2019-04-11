package com.arturo.linearyscrollbar;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
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
    private Button magicItems;
    private Button physicItems;
    private Button bothTypeItems;
    private TextView allItems;
    private LinearLayout ln1;
    private LinearLayout ln2;
    private LinearLayout ln3;
    private LinearLayout ln4;
    private LinearLayout linearambos;
    private LinearLayout linearItem;
    private LinearLayout linearItemMagicos;
    private ArrayList<ModeloItemsRandom> modelo;
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
        ControladorItemsRandom controlador = new ControladorItemsRandom(this);
        Intent intent = getIntent();
        allItems = new TextView(this);
        magicItems = new Button(this);
        physicItems = new Button(this);
        bothTypeItems = new Button(this);
        // godImage = new ImageView(this);
        linearItem = new LinearLayout(this);
        linearItemMagicos = new LinearLayout(this);
        linearambos = new LinearLayout(this);
        regreso = new Button(this);
        ln1 = new LinearLayout(this);
        ln4 = new LinearLayout(this);
        ln2 = (LinearLayout) findViewById(R.id.linearabajo3);
        ln3 = new LinearLayout(this);
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
                menuBack();
            }
        });
        modelo = controlador.TodosLosITems(intent.getStringExtra("type"));

        styleHeaders(allItems, R.string.todoslositems);
        styleHeaders(magicItems, R.string.magicos);
        magicItems.setOnClickListener(new View.OnClickListener() {
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

        styleHeaders(physicItems, R.string.fisicos);
        physicItems.setOnClickListener(new View.OnClickListener() {
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

        styleHeaders(bothTypeItems, R.string.general);
        bothTypeItems.setOnClickListener(new View.OnClickListener() {
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
        ln2.addView(bothTypeItems);

        linearItem.setOrientation(LinearLayout.VERTICAL);
        linearItemMagicos.setOrientation(LinearLayout.VERTICAL);
        linearambos.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < 101; i++) {
            final ImageButton image = new ImageButton(this);
            final LinearLayout campito = new LinearLayout(this);
            final TextView Costo = new TextView(this);
            final TextView Nombre = new TextView(this);
            final TextView mas = new TextView(this);
            final String item = modelo.get(i).getNombre();
            final String tipo = modelo.get(i).getTipo();
            final int costo = modelo.get(i).getCosto();

            campito.setGravity(Gravity.CENTER_VERTICAL);
            campito.setOrientation(LinearLayout.HORIZONTAL);
            campito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openItem(item);
                }
            });

            image.setLayoutParams(
                    new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                    )
            );

            image.setImageResource(
                    getResources().getIdentifier(
                            StringUtillities.parseItemName(item),
                            "mipmap", getPackageName()
                    )
            );

            Costo.setTextSize(18);
            Costo.setText(getResources().getString(R.string.costo) + costo);
            Nombre.setTextSize(18);
            Nombre.setText(item);
            mas.setTextSize(18);
            mas.setText(getResources().getString(R.string.more));
            mas.setTextColor(getResources().getColor(R.color.verde));
            Costo.setTextColor(getResources().getColor(R.color.Blanco));
            Nombre.setTextColor(getResources().getColor(R.color.amarillo));

            if (tipo.equals("fisico")) {
                campito.addView(image);
                campito.addView(Nombre);
                campito.addView(Costo);
                campito.addView(mas);
                linearItem.addView(campito);
            } else {
                if (tipo.equals("magico")) {
                    campito.addView(image);
                    campito.addView(Nombre);
                    campito.addView(Costo);
                    campito.addView(mas);
                    linearItemMagicos.addView(campito);
                } else {
                    campito.addView(image);
                    campito.addView(Nombre);
                    campito.addView(Costo);
                    campito.addView(mas);
                    linearambos.addView(campito);
                }
            }
        }

        ln4.addView(linearambos);
        ln1.addView(linearItem);

        ln2.addView(ln4);
        ln2.addView(physicItems);
        ln2.addView(ln1);
        ln2.addView(magicItems);
        ln3.addView(linearItemMagicos);
        ln2.addView(ln3);
        ln2.addView(regreso);

        ln4.setVisibility(View.GONE);
        ln1.setVisibility(View.GONE);
        ln3.setVisibility(View.GONE);
    }


    public void styleHeaders(TextView text, int idTitle) {
        text.setTextSize(25);
        text.setText(idTitle);
        text.setGravity(Gravity.CENTER);
        text.setTypeface(null, Typeface.BOLD);
        text.setTextColor(getResources().getColor(R.color.gris));
    }

    public void openItem(String item) {
        Intent intent = new Intent(this, DatosDeLosItems.class);
        intent.putExtra("nombre", item);
        startActivity(intent);
    }

    public void menuBack() {
        Intent mandar = new Intent(this, MainActivity.class);
        startActivity(mandar);
        finish();
    }
}
