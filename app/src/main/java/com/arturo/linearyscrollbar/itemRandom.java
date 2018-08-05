package com.arturo.linearyscrollbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class itemRandom extends AppCompatActivity {
    private Button regreso;
    private TextView godNameTitle;
    private ImageView godImage;
    private LinearLayout ln1;
    private LinearLayout ln2;
    private LinearLayout ln3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_random);
        initComponents();
    }

    public void initComponents(){
        godNameTitle = new TextView(this);
        godImage = new ImageView(this);
        regreso = new Button(this);
        ln1 = new LinearLayout(this);
        ln2 = (LinearLayout) findViewById(R.id.linearabajo2);
        ln3 = new LinearLayout(this);
        ln1.setOrientation(LinearLayout.HORIZONTAL);
        ln1.setBackgroundColor(getResources().getColor(R.color.Negro));
        ln2.setBackgroundColor(getResources().getColor(R.color.Negro));
        ln3.setOrientation(LinearLayout.HORIZONTAL);
        ln3.setBackgroundColor(getResources().getColor(R.color.Negro));
        regreso.setText(R.string.regresar);
        regreso.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        regreso.setTextSize(25);
        regreso.setTextColor(getResources().getColor(R.color.Negro));
        regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
