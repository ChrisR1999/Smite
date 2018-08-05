package com.arturo.linearyscrollbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TodosLosItems extends AppCompatActivity {

    private Button regreso;
    private TextView Magicos;
    private TextView Fisicos;
    private TextView Ambos;
    private TextView godNameTitle;
    private LinearLayout ln1;
    private LinearLayout ln2;
    private LinearLayout ln3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_los_items);
        initComponents();
    }


    public void initComponents(){
        godNameTitle = new TextView(this);
        Magicos = new TextView(this);
        Fisicos = new TextView(this);
        Ambos = new TextView(this);
       // godImage = new ImageView(this);
        regreso = new Button(this);
        ln1 = new LinearLayout(this);
        ln2 = (LinearLayout) findViewById(R.id.linearabajo3);
        ln3 = new LinearLayout(this);
        ln1.setOrientation(LinearLayout.VERTICAL);
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
               RegresoMenu();
            }
        });


        godNameTitle.setText("Todos los Items");
        godNameTitle.setTextSize(25);
        godNameTitle.setTextColor(getResources().getColor(R.color.Blanco));
        godNameTitle.setGravity(Gravity.CENTER);

        Magicos.setText("MAgicos");
        Magicos.setTextSize(25);
        Magicos.setTextColor(getResources().getColor(R.color.Blanco));
        Magicos.setGravity(Gravity.CENTER);

        Fisicos.setText("Fisicos");
        Fisicos.setTextSize(25);
        Fisicos.setTextColor(getResources().getColor(R.color.Blanco));
        Fisicos.setGravity(Gravity.CENTER);

       Ambos.setText("Generales");
        Ambos.setTextSize(25);
        Ambos.setTextColor(getResources().getColor(R.color.Blanco));
        Ambos.setGravity(Gravity.CENTER);

        ln2.addView(regreso);
        ln2.addView(godNameTitle);
        ln2.addView(Ambos);
        ln2.addView(Magicos);
        ln2.addView(Fisicos);


}


    public void RegresoMenu() {
        Intent mandar = new Intent(this, MainActivity.class);
        startActivity(mandar);
        finish();
    }
}
