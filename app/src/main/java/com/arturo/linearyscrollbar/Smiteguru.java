package com.arturo.linearyscrollbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class Smiteguru extends AppCompatActivity {


    private Toolbar mToolbar;
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smiteguru);
        et1 = (EditText)findViewById(R.id.searchPlayer);
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



    }

    public void siguiente(View view){
        Intent mandar = new Intent(this,MainActivity.class);
        startActivity(mandar);
    }


    public void buscar(View view){
        Intent i = new Intent(this,PaginaWeb.class);
        i.putExtra("dato",et1.getText().toString());
        i.putExtra("dato2","Pc");
        startActivity(i);
    }

    public void buscarps(View view){
        Intent i = new Intent(this,PaginaWeb.class);
        i.putExtra("dato",et1.getText().toString());
        i.putExtra("dato2","PS4");
        startActivity(i);
    }

    public void buscarxbox(View view){
        Intent i = new Intent(this,PaginaWeb.class);
        i.putExtra("dato",et1.getText().toString());
        i.putExtra("dato2","XBOX");
        startActivity(i);
    }

    public void guru(View view){
        Intent i = new Intent(this,PaginaWeb.class);
        i.putExtra("dato",et1.getText().toString());
        i.putExtra("dato2","Guru");
        startActivity(i);
    }

}
