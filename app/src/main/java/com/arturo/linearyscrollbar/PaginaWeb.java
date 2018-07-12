package com.arturo.linearyscrollbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class PaginaWeb extends AppCompatActivity {


    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_web);

        wv1 = (WebView)findViewById(R.id.wv1);
        String url = getIntent().getStringExtra("dato");
        String consola = getIntent().getStringExtra("dato2");

        wv1.setWebViewClient(new WebViewClient());


        if(consola.equals("Guru")){
            wv1.loadUrl("http://smite.guru/profile/pc/"+url);
        }else {
            if(consola.equals("PS4")){
                wv1.loadUrl("https://archive.smitegame.com/player-stats/?set_platform_preference=ps4&player-name="+url);


            }else{
                if(consola.equals("XBOX")){
                    wv1.loadUrl("https://archive.smitegame.com/player-stats/?set_platform_preference=xbox&player-name="+url);

                }else{
                    if (consola.equals("Pc")){
                        wv1.loadUrl("https://archive.smitegame.com/player-stats/?set_platform_preference=pc&player-name="+url);

                    }
                    else {
                        Toast.makeText(this,"NO SE ENCONTRO",Toast.LENGTH_LONG).show();
                    }
                }
            }
        }








    }
}
