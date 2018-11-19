package com.arturo.linearyscrollbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Smiteguru extends AppCompatActivity {


    private Toolbar mToolbar;
    private EditText et1;
    private AdView mAdView;
    private AdView mAdView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smiteguru);
        et1 = (EditText) findViewById(R.id.searchPlayer);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.removeAllViews();
        mToolbar.setTitle(R.string.BuscarJugador);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.Negro));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        MobileAds.initialize(this, "ca-app-pub-5146175048698339/1447542724");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        MobileAds.initialize(this, "ca-app-pub-5146175048698339~6692980600");
        mAdView = findViewById(R.id.segundoanuncio);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest2);

    }

    public void siguiente(View view) {
        Intent mandar = new Intent(this, MainActivity.class);
        startActivity(mandar);
    }


    public void buscar(View view) {

        if (et1.length() == 0) {
            Toast.makeText(this, getResources().getString(R.string.ingrsanombre), Toast.LENGTH_LONG).show();
        } else {
            Intent i = new Intent(this, PaginaWeb.class);
            i.putExtra("dato", et1.getText().toString());
            i.putExtra("dato2", "Pc");
            startActivity(i);
        }
    }

    public void buscarps(View view) {
        if (et1.length() == 0) {
            Toast.makeText(this, getResources().getString(R.string.ingrsanombre), Toast.LENGTH_LONG).show();
        } else {
            Intent i = new Intent(this, PaginaWeb.class);
            i.putExtra("dato", et1.getText().toString());
            i.putExtra("dato2", "PS4");
            startActivity(i);
        }

    }

    public void buscarxbox(View view) {
        if (et1.length() == 0) {
            Toast.makeText(this, getResources().getString(R.string.ingrsanombre), Toast.LENGTH_LONG).show();
        } else {
            Intent i = new Intent(this, PaginaWeb.class);
            i.putExtra("dato", et1.getText().toString());
            i.putExtra("dato2", "XBOX");
            startActivity(i);

        }

    }

    public void guru(View view) {
        if (et1.length() == 0) {
            Toast.makeText(this, getResources().getString(R.string.ingrsanombre), Toast.LENGTH_LONG).show();
        } else {
            Intent i = new Intent(this, PaginaWeb.class);
            i.putExtra("dato", et1.getText().toString());
            i.putExtra("dato2", "Guru");
            startActivity(i);
        }

    }

}
