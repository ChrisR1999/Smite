package com.arturo.linearyscrollbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.arturo.linearyscrollbar.Controladores.ControladorDioses;
import com.arturo.linearyscrollbar.Modelos.ModeloDioses;

import java.util.ArrayList;

public  class MainActivity extends AppCompatActivity  {

    private LinearLayout linear;
    private EditText et1 ;
    //private EditText fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getActionBar().hide();

        linear = (LinearLayout)findViewById(R.id.Linear1);
        et1 = new EditText(this);
        //  fotos = new EditText(this);
        insertGods();//ikhkljhkj

    }

    private void insertGods() {
        ControladorDioses controlador = new ControladorDioses(this);
        ArrayList<ModeloDioses> model = controlador.getAllGods();
        if (model != null) {
            for (final ModeloDioses m : model) {
                final ImageButton btn = new ImageButton(this);
                final String resourceRoute = m.getResourceImage();
                final int id = m.getGodId();
                LinearLayout list = new LinearLayout(this);
                list.setOrientation(LinearLayout.VERTICAL);
                list.setId(id);
                list.setBackgroundColor(getResources().getColor(R.color.Azul));
                btn.setImageResource(getResources().getIdentifier(resourceRoute, "mipmap", getPackageName()));

                btn.setTag(m.getGodName());
                btn.setId(m.getGodId());
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        passActivity(m);
                    }
                });


                btn.setBackgroundColor(getResources().getColor(R.color.Negro));
                btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));


                TextView text = new TextView(this);
                text.setText(m.getGodName());
                text.setTextSize(25);
                text.setTextColor(getResources().getColor(R.color.Negro));

                text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));


                list.addView(text);
                list.addView(btn);
                linear.addView(list);

            }

        } else {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
        }
    }


    private void passActivity(ModeloDioses model) {
        Intent intent = new Intent(this,Buscar.class);
        intent.putExtra("id", model.getGodId());
        intent.putExtra("name", model.getGodName());
        intent.putExtra("combo", model.getGodCombo());
        intent.putExtra("counter", model.getCounter());
        intent.putExtra("counteredBy", model.getCounterBy());
        startActivity(intent);
    }

}
