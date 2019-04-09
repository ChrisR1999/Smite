package com.arturo.linearyscrollbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arturo.linearyscrollbar.Controladores.ControladorItemsRandom;
import com.arturo.linearyscrollbar.Modelos.ModeloItemsRandom;
import com.arturo.linearyscrollbar.Utillities.StringUtillities;

import java.util.ArrayList;

public class DatosDeLosItems extends AppCompatActivity {

    private Button regreso;
    private LinearLayout ln1;
    private LinearLayout ln2;
    private String nombre;
    private ImageView iteme;
    private TextView tv1;
    private TextView tv3;
    private TextView tv2;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private TextView tv9;
    private TextView tv10;
    private TextView tv11;
    private TextView tv12;
    private TextView tv13;
    private TextView tv14;
    private TextView tv15;
    private TextView tv16;
    private TextView tv17;
    private TextView tv18;
    private TextView tv19;
    private int costo;
    private ArrayList<ModeloItemsRandom> modelo;
    private int PoderFisico;
    private int PoderMagico;
    private int Mana;
    private int AtackSpeed;
    private int vida;
    private int cooldown;
    private int movement;
    private int MPS;
    private int Penetration;
    private int proteccionmagica;
    private int proteccionfisica;
    private int robodevida, criticos, crowcontrol, HPS;
    private String pasiva;
    private String pasivaes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dotos_de_los_items);
        IniciarProyecto();
    }


    public void IniciarProyecto() {
        ControladorItemsRandom controlador = new ControladorItemsRandom(this);
        Intent intent = getIntent();

        tv1 = new TextView(this);
        tv2 = new TextView(this);
        tv3 = new TextView(this);
        tv4 = new TextView(this);
        tv5 = new TextView(this);
        tv6 = new TextView(this);
        tv7 = new TextView(this);
        tv8 = new TextView(this);
        tv9 = new TextView(this);
        tv10 = new TextView(this);
        tv11 = new TextView(this);
        tv12 = new TextView(this);
        tv13 = new TextView(this);
        tv14 = new TextView(this);
        tv15 = new TextView(this);
        tv16 = new TextView(this);
        tv17 = new TextView(this);
        tv18 = new TextView(this);
        tv19 = new TextView(this);
        iteme = (ImageView) findViewById(R.id.fotito);
        nombre = getIntent().getStringExtra("nombre");
        ln1 = (LinearLayout) findViewById(R.id.linearabajoitems);
        ln1.setOrientation(LinearLayout.VERTICAL);
        ln1.setBackgroundColor(getResources().getColor(R.color.Negro));
        regreso = new Button(this);
        modelo = controlador.Lllamada(intent.getStringExtra("nombre"));
        ln2 = new LinearLayout(this);
        ln2.setOrientation(LinearLayout.HORIZONTAL);
        ln2.setBackgroundColor(getResources().getColor(R.color.Negro));
        ln2.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);

        ln1.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);
        regreso.setText(R.string.todoslositems);
        regreso.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        regreso.setTextSize(25);
        regreso.setTextColor(getResources().getColor(R.color.Negro));
        regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegresoMenu();
            }
        });

        iteme.setImageResource(getResources().getIdentifier(StringUtillities.parseItemName(nombre), "mipmap", getPackageName()));

        costo = modelo.get(0).getCosto();

        tv1.setText("  " + nombre);
        tv1.setTextColor(getResources().getColor(R.color.verde));
        tv1.setTextSize(26);
        tv2.setText("  " + getResources().getString(R.string.costo) + " " + costo);
        tv2.setTextColor(getResources().getColor(R.color.amarillo));
        tv2.setTextSize(26);
        PoderFisico = modelo.get(0).getPhysicalPower();
        PoderMagico = modelo.get(0).getMagicalPower();
        Mana = modelo.get(0).getMana();
        AtackSpeed = modelo.get(0).getAttackSpeed();
        vida = modelo.get(0).getHealth();
        cooldown = modelo.get(0).getCoolDown();
        movement = modelo.get(0).getMovementSpeed();
        Penetration = modelo.get(0).getPenetration();
        MPS = modelo.get(0).getMPS();
        proteccionfisica = modelo.get(0).getPhysicalProtection();
        proteccionmagica = modelo.get(0).getMagicalProtection();
        robodevida = modelo.get(0).getLifeSteal();
        criticos = modelo.get(0).getCriticalStrikeChance();
        crowcontrol = modelo.get(0).getCrowdControlReduction();
        pasiva = modelo.get(0).getPasive();
        pasivaes = modelo.get(0).getPasivees();


//        Toast.makeText(this,pasiva+"",Toast.LENGTH_LONG).show();

        // ln2.addView(iteme);
        ln2.addView(tv1);
        ln2.addView(tv2);
        ln1.addView(ln2);
        llenardatos(tv3, getResources().getString(R.string.poderfisico), PoderFisico);
        llenardatos(tv4, getResources().getString(R.string.podermagico), PoderMagico);
        llenardatos(tv5, getResources().getString(R.string.velocidadedeataque), AtackSpeed);
        llenardatos(tv6, "Mana ", Mana);
        llenardatos(tv7, getResources().getString(R.string.velocidadedeataque), AtackSpeed);
        llenardatos(tv8, getResources().getString(R.string.vida), vida);
        llenardatos(tv9, getResources().getString(R.string.coldown), cooldown);
        llenardatos(tv10, getResources().getString(R.string.penetration), Penetration);
        llenardatos(tv11, "MPS ", MPS);
        llenardatos(tv12, getResources().getString(R.string.defensafisica), proteccionfisica);
        llenardatos(tv13, getResources().getString(R.string.defensamagica), proteccionmagica);
        llenardatos(tv14, getResources().getString(R.string.robodevida), robodevida);
        llenardatos(tv15, getResources().getString(R.string.criticos), criticos);
        llenardatos(tv16, getResources().getString(R.string.contromasas), crowcontrol);
        llenardatos(tv17, "HPS ", HPS);
        datosdellinear(tv18, getResources().getString(R.string.pasiva), pasiva, 0);
        datosdellinear(tv19, getResources().getString(R.string.pasiva) + "ES", pasivaes, 1);
        ln1.addView(regreso);
    }

    public void llenardatos(TextView texto, String previo, int poder) {
        if (poder != 0) {
            texto.setText("" + previo + ": +" + poder);
            texto.setTextColor(getResources().getColor(R.color.Blanco));
            texto.setTextSize(26);
            ln1.addView(texto);

        }

    }

    public void datosdellinear(TextView texto, String previo, String poder, int esp) {

        texto.setText("" + previo + ": " + poder);
        if (esp == 0) {
            texto.setTextColor(getResources().getColor(R.color.Azul));
        } else {
            texto.setTextColor(getResources().getColor(R.color.amarillo));
        }
        texto.setTextSize(26);
        ln1.addView(texto);
    }

    public void RegresoMenu() {
        Intent mandar = new Intent(this, TodosLosItems.class);
        startActivity(mandar);
        finish();
    }
}
