package com.cristofer.scrollybar1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cristofer.scrollybar1.R;
import com.cristofer.scrollybar1.Controladores.ControladorItemsRandom;
import com.cristofer.scrollybar1.Modelos.ModeloItemsRandom;
import com.cristofer.scrollybar1.Utillities.StringUtillities;

public class DatosDeLosItems extends AppCompatActivity {

    private ModeloItemsRandom modelo;
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
        setContentView(R.layout.activity_datos_de_los_items);
        initComponents();
    }


    public void initComponents() {
        ln2 = new LinearLayout(this);
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
        regreso = new Button(this);

        Intent intent = getIntent();
        ControladorItemsRandom controller = new ControladorItemsRandom(this);

        nombre = getIntent().getStringExtra("nombre");
        modelo = controller.getItemData(nombre);
        costo = modelo.getCosto();

        ln1 = (LinearLayout) findViewById(R.id.linearabajoitems);
        ln1.setOrientation(LinearLayout.VERTICAL);
        ln1.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);
        ln1.setBackgroundColor(getResources().getColor(R.color.Negro));

        ln2.setOrientation(LinearLayout.HORIZONTAL);
        ln2.setBackgroundColor(getResources().getColor(R.color.Negro));
        ln2.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);


        iteme = (ImageView) findViewById(R.id.fotito);
        iteme.setImageResource(getResources().getIdentifier(
                StringUtillities.parseItemName(nombre),
                "mipmap",
                getPackageName())
        );


        regreso.setTextSize(25);
        regreso.setText(R.string.todoslositems);
        regreso.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        regreso.setTextColor(getResources().getColor(R.color.Negro));
        regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backMenu();
            }
        });

        tv1.setText("  " + nombre);
        tv1.setTextColor(getResources().getColor(R.color.verde));
        tv1.setTextSize(26);
        tv2.setText("  " + getResources().getString(R.string.costo) + " " + String.valueOf(costo));
        tv2.setTextColor(getResources().getColor(R.color.amarillo));
        tv2.setTextSize(26);

        PoderFisico = modelo.getPhysicalPower();
        PoderMagico = modelo.getMagicalPower();
        Mana = modelo.getMana();
        AtackSpeed = modelo.getAttackSpeed();
        vida = modelo.getHealth();
        cooldown = modelo.getCoolDown();
        movement = modelo.getMovementSpeed();
        Penetration = modelo.getPenetration();
        MPS = modelo.getMPS();
        proteccionfisica = modelo.getPhysicalProtection();
        proteccionmagica = modelo.getMagicalProtection();
        robodevida = modelo.getLifeSteal();
        criticos = modelo.getCriticalStrikeChance();
        crowcontrol = modelo.getCrowdControlReduction();
        pasiva = modelo.getPasive();
        pasivaes = modelo.getPasivees();

        ln2.addView(tv1);
        ln2.addView(tv2);
        ln1.addView(ln2);

        fillData(tv3, getResources().getString(R.string.poderfisico), PoderFisico);
        fillData(tv4, getResources().getString(R.string.podermagico), PoderMagico);
        fillData(tv5, getResources().getString(R.string.velocidadedeataque), AtackSpeed);
        fillData(tv6, "Mana ", Mana);
        fillData(tv7, getResources().getString(R.string.velocidadedeataque), AtackSpeed);
        fillData(tv8, getResources().getString(R.string.vida), vida);
        fillData(tv9, getResources().getString(R.string.coldown), cooldown);
        fillData(tv10, getResources().getString(R.string.penetration), Penetration);
        fillData(tv11, "MPS ", MPS);
        fillData(tv12, getResources().getString(R.string.defensafisica), proteccionfisica);
        fillData(tv13, getResources().getString(R.string.defensamagica), proteccionmagica);
        fillData(tv14, getResources().getString(R.string.robodevida), robodevida);
        fillData(tv15, getResources().getString(R.string.criticos), criticos);
        fillData(tv16, getResources().getString(R.string.contromasas), crowcontrol);
        fillData(tv17, "HPS ", HPS);

        linearData(tv18, getResources().getString(R.string.pasiva), pasiva, 0);
        linearData(tv19, getResources().getString(R.string.pasiva) + "ES", pasivaes, 1);
        ln1.addView(regreso);
    }

    public void fillData(TextView texto, String previo, int poder) {
        if (poder != 0) {
            texto.setText("" + previo + ": +" + poder);
            texto.setTextColor(getResources().getColor(R.color.Blanco));
            texto.setTextSize(26);
            ln1.addView(texto);
        }
    }

    public void linearData(TextView texto, String previo, String poder, int esp) {
        texto.setText("" + previo + ": " + poder);
        if (esp == 0) {
            texto.setTextColor(getResources().getColor(R.color.Azul));
        } else {
            texto.setTextColor(getResources().getColor(R.color.amarillo));
        }
        texto.setTextSize(26);
        ln1.addView(texto);
    }

    public void backMenu() {
        Intent intent = new Intent(this, TodosLosItems.class);
        startActivity(intent);
        finish();
    }
}
