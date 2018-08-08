package com.arturo.linearyscrollbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arturo.linearyscrollbar.Controladores.ControladorItemsRandom;
import com.arturo.linearyscrollbar.Modelos.ModeloItemsRandom;
import com.arturo.linearyscrollbar.Utillities.StringUtillities;

import java.util.ArrayList;

public class DotosDeLosItems extends AppCompatActivity {



    private LinearLayout ln1;
    private LinearLayout ln2;
    private String nombre;
    private ImageView iteme;
    private TextView tv1;
    private  TextView tv3;
    private  TextView tv2;
    private  TextView tv4;
    private  TextView tv5;
    private  TextView tv6;
    private  TextView tv7;
    private  TextView tv8;
    private  TextView tv9;
    private  TextView tv10;
    private  TextView tv11;
    private  TextView tv12;
    private  TextView tv13;
    private  TextView tv14;
    private  TextView tv15;
    private  TextView tv16;
    private int costo;
    private ArrayList<ModeloItemsRandom> modelo;
    private int PoderFisico;
    private int PoderMagico;
    private int Mana;
    private int AtackSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dotos_de_los_items);
        IniciarProyecto();


    }



    public void IniciarProyecto()
    {

        ControladorItemsRandom controlador = new ControladorItemsRandom(this);
        Intent intent = getIntent();

        tv1= new TextView(this);
        tv2= new TextView(this);
        tv3= new TextView(this);
        tv4= new TextView(this);
        tv5= new TextView(this);
        tv6= new TextView(this);
        tv7= new TextView(this);
        tv8= new TextView(this);
        tv9= new TextView(this);
        tv10= new TextView(this);
        tv11= new TextView(this);
        tv12= new TextView(this);
        tv13= new TextView(this);
        tv14= new TextView(this);
        tv15= new TextView(this);
        iteme = (ImageView)findViewById(R.id.fotito);
        nombre = getIntent().getStringExtra("nombre");
        ln1 = (LinearLayout)findViewById(R.id.linearabajoitems);
        ln1.setOrientation(LinearLayout.VERTICAL);
        ln1.setBackgroundColor(getResources().getColor(R.color.Negro));

        modelo = controlador.TodosLosITems(intent.getStringExtra("type"));
        ln2 = new LinearLayout(this);
        ln2.setOrientation(LinearLayout.HORIZONTAL);
        ln2.setBackgroundColor(getResources().getColor(R.color.Negro));
         ln2.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);

         ln1.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);

        iteme.setImageResource(getResources().getIdentifier(StringUtillities.parseItemName(nombre), "mipmap", getPackageName()));

        costo = modelo.get(0).getCosto();

        tv1.setText("  "+nombre);
        tv1.setTextColor(getResources().getColor(R.color.verde));
        tv1.setTextSize(26);
        tv2.setText("  Costo"+costo);
        tv2.setTextColor(getResources().getColor(R.color.amarillo));
        tv2.setTextSize(26);
        PoderFisico = modelo.get(0).getPhysicalPower();
        PoderMagico = modelo.get(0).getMagicalPower();

       // ln2.addView(iteme);
        ln2.addView(tv1);
        ln2.addView(tv2);
        ln1.addView(ln2);

        if(PoderFisico == 0) {
            tv3.setText("Poder fisico  "+PoderFisico);
            tv3.setTextColor(getResources().getColor(R.color.Blanco));
            tv3.setTextSize(26);
            ln1.addView(tv3);
        }
        if(PoderMagico == 0) {
            tv4.setText("Poder MAagico  "+PoderMagico);
            tv4.setTextColor(getResources().getColor(R.color.Blanco));
            tv4.setTextSize(26);
            ln1.addView(tv4);
        }

    }
}
