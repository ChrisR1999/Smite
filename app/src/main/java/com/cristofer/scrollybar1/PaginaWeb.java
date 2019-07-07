package com.cristofer.scrollybar1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.cristofer.scrollybar1.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class PaginaWeb extends AppCompatActivity {


    private WebView wv1;
    private Toolbar mToolbar;
    private AdView mAdView;


    private void initComponents() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Buscar jugador");
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

        wv1 = (WebView) findViewById(R.id.wv1);
        WebSettings webSettings = wv1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        wv1.setWebViewClient(new WebViewClient());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_web);
        initComponents();
        String url = getIntent().getStringExtra("dato");
        String consola = getIntent().getStringExtra("dato2");

        if (consola.equals("Guru")) {
            wv1.loadUrl("http://smite.guru/profile/pc/" + url);
        } else {
            if (consola.equals("PS4")) {
                wv1.loadUrl("https://archive.smitegame.com/player-stats/?set_platform_preference=ps4&player-name=" + url);
            } else {
                if (consola.equals("XBOX")) {
                    wv1.loadUrl("https://archive.smitegame.com/player-stats/?set_platform_preference=xbox&player-name=" + url);
                } else {
                    if (consola.equals("Pc")) {
                        wv1.loadUrl("https://archive.smitegame.com/player-stats/?set_platform_preference=pc&player-name=" + url);
                    } else {
                        Toast.makeText(this, "NO SE ENCONTRO", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }

        //MobileAds.initialize(this, "ca-app-pub-5146175048698339~6692980600");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
