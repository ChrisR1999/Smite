package com.arturo.linearyscrollbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import com.arturo.linearyscrollbar.Adapters.AdaptadorMain;
import com.arturo.linearyscrollbar.Controladores.ControladorDioses;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;

    private LinearLayout linear;
    private EditText searchBar;
    private Toolbar mToolbar;
    private Animation animOut;
    private Animation animIn;
    private ListView listMain;
    private FrameLayout ghost;
    private ArrayList godCards;
    private boolean searchFlag;
    private AdaptadorMain adapter;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_search:
                searchBar.setVisibility(View.VISIBLE);
                searchBar.setEnabled(true);
                searchBar.startAnimation(animIn);
                break;
            case R.id.action_user:
                Intent intent = new Intent(this, Smiteguru.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        MobileAds.initialize(this, "ca-app-pub-5146175048698339~6692980600");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initComponents() {
        godCards = new ArrayList();
        ghost = (FrameLayout) findViewById(R.id.ghostFrame);
        listMain = (ListView) findViewById(R.id.listMain);
        searchBar = (EditText) findViewById(R.id.godSearch);
        searchFlag = false;
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("SMITE");
        mToolbar.setTitleTextColor(getResources().getColor(R.color.Negro));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        animOut = AnimationUtils.loadAnimation(this, R.anim.searchout);
        animIn = AnimationUtils.loadAnimation(this, R.anim.searchin);
        searchBar.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
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
                consultGodsBySearch(search);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        ghost.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (searchBar.isFocused()) {
                        Rect outRect = new Rect();
                        searchBar.getGlobalVisibleRect(outRect);
                        if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                            searchBar.clearFocus();
                            InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                        }
                    }
                }
                return false;
            }
        });

        listMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final TextView god = (TextView) view.findViewById(R.id.nombre);
                final String godNameClick = god.getText().toString();
                passActivity(godNameClick);
            }
        });
        consultAllGods();
    }

    private void consultAllGods() {
        ControladorDioses controller = new ControladorDioses(this);
        godCards = controller.getAllGods();
        adapter = new AdaptadorMain(this, godCards, this);
        listMain.setAdapter(adapter);
    }

    private void consultGodsBySearch(String search) {
        ControladorDioses controller = new ControladorDioses(this);
        godCards = controller.searchResults(search);
        adapter = new AdaptadorMain(this, godCards, this);
        listMain.setAdapter(adapter);
    }


/*
    private void insertResultGods(String name){
        int id = 1;
        /*
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
    }*/

/*
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
    }*/


    private void passActivity(String name) {
        Intent intent = new Intent(this, Buscar.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }


    public void Iralaweb(View view){
        Intent intent = new Intent(this, Smiteguru.class);
        startActivity(intent);
    }

    public void recargarlista(View view){
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        this.finish();
    }
}
