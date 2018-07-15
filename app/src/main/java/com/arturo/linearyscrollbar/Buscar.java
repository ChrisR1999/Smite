package com.arturo.linearyscrollbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arturo.linearyscrollbar.Controladores.ControladorDioses;
import com.arturo.linearyscrollbar.Modelos.ModeloDioses;

public class Buscar extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private Button tv5;
    private Button tv6;
    private Button tv7;
    private Button tv8;
    private Button regreso;
    private LinearLayout ln1;
    private LinearLayout ln2;
    private LinearLayout ln3;
    private String godName;
    private ImageButton fotocounter;
    private ImageButton fotocountereadopor;

    private void initComponents(){
        tv1 = new EditText(this);
        tv2 = new EditText(this);
        tv3 = new EditText(this);
        tv4 = new EditText(this);
        tv5 = new Button(this);
        tv6 = new Button(this);
        tv7 = new Button(this);
        tv8 = new Button(this);
        regreso = new Button(this);
        fotocounter = new ImageButton(this);
        fotocountereadopor = new ImageButton(this);

        godName = getIntent().getStringExtra("name");
        ln2 = (LinearLayout)findViewById(R.id.linearabajo) ;
        ln2.setBackgroundColor(getResources().getColor(R.color.Negro));
        ln1 = new LinearLayout(this);
        ln1.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams linearlayoutlayoutparams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ln1.setBackgroundColor(getResources().getColor(R.color.Negro));
        ln3 = new LinearLayout(this);
        ln3.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams linearlayoutlayoutparams2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
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
        //regreso.setBackgroundColor(getResources().getColor(R.color.Negro));

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
        // tv6.setBackgroundColor(getResources().getColor(R.color.gris));

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
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        //getActionBar().hide();
        initComponents();
        final ImageView btn = new ImageView(this);
        ControladorDioses controlador = new ControladorDioses (this);
        ModeloDioses datos = controlador.godStadistics(godName);
        String counter = datos.getCounter();
        String counterby = datos.getCounterBy();

        btn.setImageResource(getResources().getIdentifier(godName, "mipmap", getPackageName()));
        btn.setBackgroundColor(getResources().getColor(R.color.Negro));
        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        fotocounter.setImageResource(getResources().getIdentifier(counter.toString(), "mipmap", getPackageName()));
        fotocounter.setTag(counter);
        fotocounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiar();
            }
        });

        fotocountereadopor.setImageResource(getResources().getIdentifier(counterby.toString(), "mipmap", getPackageName()));
        fotocountereadopor.setTag(counterby);
        fotocountereadopor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiar2();
            }
        });

        ln1.addView(tv4);
        ln1.addView(btn);
        ln3.addView(regreso);
        ln3.addView(tv3);

        ln2.addView(ln3);
        ln2.addView(ln1);
        ln2.addView(tv1);
        ln2.addView(fotocounter);
        ln2.addView(tv2);
        ln2.addView(fotocountereadopor);
        ln2.addView(tv5);
        ln2.addView(tv6);
        ln2.addView(tv7);
        ln2.addView(tv8);

    }


       public void cambiar(){
           Intent mandar = new Intent(this,Buscar.class);
           mandar.putExtra("godgodName",fotocounter.getTag().toString());
           startActivity(mandar);
           finish();
       }

    public void cambiar2(){
        Intent mandar = new Intent(this,Buscar.class);
        mandar.putExtra("godgodName",fotocountereadopor.getTag().toString());
        startActivity(mandar);
        finish();
    }

    public void RegresoMenu(){
        Intent mandar = new Intent(this,MainActivity.class);
        startActivity(mandar);
        finish();
    }

}
