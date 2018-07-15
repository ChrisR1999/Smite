package com.arturo.linearyscrollbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.arturo.linearyscrollbar.Controladores.ControladorDioses;

import java.util.ArrayList;

public  class MainActivity extends AppCompatActivity  {

    private LinearLayout linear;
    private EditText searchBar ;
    private Toolbar mToolbar;
    private Animation animOut;
    private Animation animIn;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        
        if (id == R.id.action_search){
            searchBar.setVisibility(View.VISIBLE);
            searchBar.setEnabled(true);
            searchBar.startAnimation(animIn);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents(){


        linear = (LinearLayout)findViewById(R.id.Linear1);
        searchBar = (EditText) findViewById(R.id.godSearch);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        animOut = AnimationUtils.loadAnimation(this,  R.anim.searchout);
        animIn = AnimationUtils.loadAnimation(this,  R.anim.searchin);
        searchBar.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    searchBar.startAnimation(animOut);
                    searchBar.setVisibility(View.GONE);
                }
            }
        });
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String search = searchBar.getText().toString();
                linear.removeAllViews();
                insertResultGods(search);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        insertGods();
    }


    private void insertResultGods(String name){
        int id = 1;
        ControladorDioses controlador = new ControladorDioses(this);
        ArrayList<String> model = controlador.searchResults(name);
        if (model != null) {
            for (final String m : model) {
                final ImageButton btn = new ImageButton(this);
                final String resourceRoute = m;
                LinearLayout list = new LinearLayout(this);
                list.setOrientation(LinearLayout.VERTICAL);
                list.setId(id);
                list.setBackgroundColor(getResources().getColor(R.color.Azul));
                btn.setImageResource(getResources().getIdentifier(resourceRoute, "mipmap", getPackageName()));
                btn.setTag(m);
                btn.setId(id);
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
                text.setText(m);
                text.setTextSize(25);
                text.setTextColor(getResources().getColor(R.color.Negro));

                text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));


                list.addView(text);
                list.addView(btn);
                linear.addView(list);
                id++;
            }

        } else {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
        }
    }

    private void insertGods() {
        int id = 1;
        ControladorDioses controlador = new ControladorDioses(this);
        ArrayList<String> model = controlador.getAllGodsNames();
        if (model != null) {
            for (final String m : model) {
                final ImageButton btn = new ImageButton(this);
                final String resourceRoute = m;
                LinearLayout list = new LinearLayout(this);
                list.setOrientation(LinearLayout.VERTICAL);
                list.setId(id);
                list.setBackgroundColor(getResources().getColor(R.color.Azul));
                btn.setImageResource(getResources().getIdentifier(resourceRoute, "mipmap", getPackageName()));
                btn.setTag(m);
                btn.setId(id);
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
                text.setText(m);
                text.setTextSize(25);
                text.setTextColor(getResources().getColor(R.color.Negro));

                text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));


                list.addView(text);
                list.addView(btn);
                linear.addView(list);
                id++;
            }

        } else {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
        }
    }


    private void passActivity(String model) {
        Intent intent = new Intent(this,Buscar.class);
        intent.putExtra("name", model);
        startActivity(intent);
    }


    public void siguiente(View view){
        Intent mandar = new Intent(this,Smiteguru.class);

        startActivity(mandar);
    }


    public void recargar(View view){
        recreate();
    }

}
