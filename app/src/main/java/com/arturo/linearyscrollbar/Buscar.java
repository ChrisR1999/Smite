package com.arturo.linearyscrollbar;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Buscar extends AppCompatActivity {


    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private Button tv5;
    private Button tv6;
    private Button tv7;
    private Button tv8;
    private LinearLayout ln1;
    private LinearLayout ln2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        final ImageView btn = new ImageView(this);
        int id = getIntent().getIntExtra("id", 0);
        String name = getIntent().getStringExtra("name");
        String combo = getIntent().getStringExtra("combo");
        String counter = getIntent().getStringExtra("counter");
        String counteredBy = getIntent().getStringExtra("counteredBy");


        ln2 = (LinearLayout)findViewById(R.id.linearabajo) ;
        ln2.setBackgroundColor(getResources().getColor(R.color.Negro));

        ln1 = new LinearLayout(this);
        ln1.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams linearlayoutlayoutparams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ln1.setBackgroundColor(getResources().getColor(R.color.Negro));

        tv1 = new EditText(this);
        tv2 = new EditText(this);
        tv3 = new EditText(this);
        tv4 = new EditText(this);
        tv5 = new Button(this);
        tv6 = new Button(this);
        tv7 = new Button(this);
        tv8 = new Button(this);


        btn.setImageResource(getResources().getIdentifier(name, "mipmap", getPackageName()));

        btn.setBackgroundColor(getResources().getColor(R.color.Negro));
        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));


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

        tv3.setText(name);
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


        ln1.addView(tv4);
        ln1.addView(btn);

        ln2.addView(tv3);
        ln2.addView(ln1);
        ln2.addView(tv1);
        ln2.addView(tv2);
        ln2.addView(tv5);
        ln2.addView(tv6);
        ln2.addView(tv7);
        ln2.addView(tv8);

    }
}
