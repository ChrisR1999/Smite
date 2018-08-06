package com.arturo.linearyscrollbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arturo.linearyscrollbar.Controladores.ControladorItemsRandom;
import com.arturo.linearyscrollbar.Modelos.ModeloItemsRandom;
import com.arturo.linearyscrollbar.Utillities.StringUtillities;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class itemRandom extends AppCompatActivity {
    private Button regreso;
    private Button changeItems;
    private TextView godNameTitle;
    private TextView itemDivider;
    private ImageView godImage;
    private LinearLayout linearItem;
    private LinearLayout ln1;
    private LinearLayout ln2;
    private LinearLayout ln3;
    private ArrayList<ModeloItemsRandom> modelo;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_random);
        initComponents();

        MobileAds.initialize(this, "ca-app-pub-5146175048698339~6692980600");
        mAdView = findViewById(R.id.adViewRandom);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    public void initComponents(){
        godNameTitle = new TextView(this);
        itemDivider = new TextView(this);
        godImage = new ImageView(this);
        changeItems = new Button(this);
        regreso = new Button(this);
        linearItem = new LinearLayout(this);
        ln1 = new LinearLayout(this);
        ln2 = (LinearLayout) findViewById(R.id.linearabajo2);
        ln3 = new LinearLayout(this);
        ln1.setOrientation(LinearLayout.HORIZONTAL);
        ln1.setBackgroundColor(getResources().getColor(R.color.Negro));
        ln2.setBackgroundColor(getResources().getColor(R.color.Negro));
        ln3.setOrientation(LinearLayout.HORIZONTAL);
        styleHeaders(godNameTitle);
        godNameTitle.setText("Agni");
        godImage.setImageResource(getResources().getIdentifier("agni", "mipmap", getPackageName()));
        godImage.setBackgroundColor(getResources().getColor(R.color.Negro));
        godImage.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        ln3.setBackgroundColor(getResources().getColor(R.color.Negro));
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
        changeItems.setText("Rolar");
        changeItems.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        changeItems.setTextSize(25);
        changeItems.setTextColor(getResources().getColor(R.color.Negro));
        changeItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollItems();
            }
        });
        ln1.addView(godImage);
        ln3.addView(regreso);
        ln3.addView(godNameTitle);
        ln2.addView(itemDivider);
        ln2.addView(linearItem);
        rollItems();
        ln2.addView(changeItems);
    }

    public String getRandomItem() {
        String item = "";
        int index = (int)(Math.random()*modelo.size());
        item = modelo.get(index).getNombre();
        modelo.remove(index);
        return item;
    }

    private void rollItems(){
        Intent intent = getIntent();
        ControladorItemsRandom controlador = new ControladorItemsRandom(this);
        modelo = controlador.getAllRandomItems(intent.getStringExtra("type"));
        linearItem.removeAllViews();
        for (int i = 0; i < 6 ; i++){
            final ImageButton image = new ImageButton(this);
            final String item = getRandomItem();
            image.setImageResource(getResources().getIdentifier(StringUtillities.parseItemName(item), "mipmap", getPackageName()));
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openItem(item);
                }
            });
            linearItem.addView(image);
        }
    }

    public void openItem(String item){

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

    public void RegresoMenu() {
        Intent mandar = new Intent(this, MainActivity.class);
        startActivity(mandar);
        finish();
    }

}
