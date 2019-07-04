package com.cristofer.scrollybar1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cristofer.scrollybar1.R;
import com.cristofer.scrollybar1.Controladores.ControladorItemsRandom;
import com.cristofer.scrollybar1.Modelos.ModeloItemsRandom;
import com.cristofer.scrollybar1.Utillities.StringUtillities;
import com.cristofer.scrollybar1.Utillities.StyleUtillities;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class ItemRandom extends AppCompatActivity {
    private Button back;
    private Button changeItems;
    private LinearLayout linearItem;
    private LinearLayout linearItem2;
    private LinearLayout ln1;
    private LinearLayout ln2;
    private ArrayList<ModeloItemsRandom> modelo;
    private String godType;
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

    public void initComponents() {
        String godName = getIntent().getStringExtra("godName");
        ImageView godImage = new ImageView(this);
        TextView godNameTitle = new TextView(this);
        TextView itemDivider = new TextView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        godType = getIntent().getStringExtra("godType");
        changeItems = new Button(this);
        linearItem = new LinearLayout(this);
        linearItem2 = new LinearLayout(this);
        ln1 = new LinearLayout(this);

        ln1.setOrientation(LinearLayout.HORIZONTAL);
        ln1.setGravity(Gravity.CENTER);
        ln1.setBackgroundColor(getResources().getColor(R.color.Negro));

        ln2 = (LinearLayout) findViewById(R.id.mainLineal);
        ln2.setOrientation(LinearLayout.VERTICAL);
        ln2.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        ln2.setBackgroundColor(getResources().getColor(R.color.Negro));

        linearItem.setLayoutParams(layoutParams);

        layoutParams.setMargins(0, 20, 0, 0);
        linearItem2.setLayoutParams(layoutParams);

        back = (Button) findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backMenu();
            }
        });

        changeItems = (Button) findViewById(R.id.randomButton);
        changeItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollItems();
            }
        });

        styleHeaders(godNameTitle);
        godNameTitle.setText(godName);

        StyleUtillities.styleRandomImage(godImage);
        godImage.setImageResource(getResources().getIdentifier(StringUtillities.parseItemName(godName), "mipmap", getPackageName()));
        godImage.setBackgroundColor(getResources().getColor(R.color.Negro));

        ln1.addView(godNameTitle);
        ln2.addView(ln1);
        ln2.addView(godImage);
        ln2.addView(itemDivider);
        ln2.addView(linearItem);
        ln2.addView(linearItem2);
        rollItems();
    }

    public String getRandomItem() {
        String item = "";
        int index = (int) (Math.random() * modelo.size());
        item = modelo.get(index).getNombre();
        modelo.remove(index);
        return item;
    }

    private void rollItems() {
        ControladorItemsRandom controlador = new ControladorItemsRandom(this);
        modelo = controlador.getAllRandomItems(godType);
        linearItem.removeAllViews();
        linearItem2.removeAllViews();

        for (int i = 0; i < 6; i++) {
            final ImageButton image = new ImageButton(this);
            final String item = getRandomItem();
            StyleUtillities.styleImages(image);
            image.setImageResource(getResources().getIdentifier(StringUtillities.parseItemName(item), "mipmap", getPackageName()));
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openItem(item);
                }
            });

            if (i % 2 == 0)
                linearItem.addView(image);
            else
                linearItem2.addView(image);
        }
    }

    public void openItem(String item) {
        Intent intent = new Intent(this, DatosDeLosItems.class);
        intent.putExtra("nombre", item);
        startActivity(intent);
    }

    public void styleHeaders(TextView style) {
        style.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        style.setEnabled(false);
        style.setTextSize(28);
        style.setTextColor(getResources().getColor(R.color.Blanco));
        style.setTypeface(null, Typeface.BOLD);
        style.setBackgroundColor(getResources().getColor(R.color.Negro));
    }

    public void backMenu() {
        Intent mandar = new Intent(this, MainActivity.class);
        startActivity(mandar);
        finish();
    }

}
