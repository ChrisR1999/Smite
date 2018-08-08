package com.arturo.linearyscrollbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.arturo.linearyscrollbar.Utillities.StringUtillities;

public class DotosDeLosItems extends AppCompatActivity {



    private LinearLayout ln1;
    private LinearLayout ln2;
    private String nombre;
    private ImageView iteme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dotos_de_los_items);
        IniciarProyecto();


    }



    public void IniciarProyecto()
    {

        iteme = new ImageView(this);
        nombre = getIntent().getStringExtra("nombre");
        ln1 = (LinearLayout)findViewById(R.id.linearabajoitems);
        ln1.setOrientation(LinearLayout.HORIZONTAL);
        ln1.setBackgroundColor(getResources().getColor(R.color.Negro));


        ln2 = new LinearLayout(this);
        ln2.setOrientation(LinearLayout.VERTICAL);
        ln2.setBackgroundColor(getResources().getColor(R.color.Negro));

        iteme.setImageResource(getResources().getIdentifier(StringUtillities.parseItemName(nombre), "mipmap", getPackageName()));

        ln1.addView(iteme);



    }
}
