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
import android.widget.ListView;
import android.widget.TextView;

import com.arturo.linearyscrollbar.Adapters.AdaptadorMain;
import com.arturo.linearyscrollbar.Controladores.ControladorDioses;
import com.arturo.linearyscrollbar.Utillities.StyleUtillities;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    private EditText searchBar;
    private Toolbar mToolbar;
    private ListView listMain;
    private FrameLayout ghost;
    private ArrayList godCards;
    private AdaptadorMain adapter;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch (id) {
            /*case R.id.action_favorites:
                break;*/

            case R.id.refreshList:
                searchBar.setText("");
                this.recreate();
                break;

            case R.id.searchPlayers:
                intent = new Intent(this, Smiteguru.class);
                startActivity(intent);
                break;

            case R.id.items:
                intent = new Intent(this, TodosLosItems.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.SplashTheme);
        setContentView(R.layout.activity_main);
        initComponents();
        // MobileAds.initialize(this, "ca-app-pub-5146175048698339~6692980600");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initComponents() {
        StyleUtillities style = new StyleUtillities(this);
        godCards = new ArrayList();
        ghost = (FrameLayout) findViewById(R.id.ghostFrame);
        listMain = (ListView) findViewById(R.id.listMain);
        searchBar = (EditText) findViewById(R.id.godSearch);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        searchBar.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
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
                final TextView godName = (TextView) view.findViewById(R.id.cardGodName2);
                final String godNameClick = godName.getText().toString();
                final int type = adapter.getTypeID(i);
                passActivity(godNameClick, type);
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

    private void passActivity(String name, int type) {
        Intent intent = new Intent(this, Buscar.class);
        intent.putExtra("type", type);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
