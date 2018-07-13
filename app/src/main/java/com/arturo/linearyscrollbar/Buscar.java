package com.arturo.linearyscrollbar;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Buscar extends AppCompatActivity {


    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private Button tv5;
    private Button tv6;
    private Button tv7;
    private Button tv8;
    private LinearLayout ln1;
    private LinearLayout ln2;
    private String name;
    private TextView Counter;
    private TextView CounterBy;
    private TextView Combo;
    private TextView url1;
    private TextView url2;
    private TextView url3;
    private TextView url4;
    private ImageButton fotocounter;
    private ImageButton fotocountereadopor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        //getActionBar().hide();

        final ImageView btn = new ImageView(this);
         name = getIntent().getStringExtra("name");


        ln2 = (LinearLayout)findViewById(R.id.linearabajo) ;
        ln2.setBackgroundColor(getResources().getColor(R.color.Negro));

        ln1 = new LinearLayout(this);
        ln1.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams linearlayoutlayoutparams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ln1.setBackgroundColor(getResources().getColor(R.color.Negro));

        tv1 = new EditText(this);
        tv2 = new EditText(this);
        tv3 = new EditText(this);
        tv4 = new EditText(this);
        tv5 = new Button(this);
        tv6 = new Button(this);
        tv7 = new Button(this);
        tv8 = new Button(this);
        Counter = new EditText(this);
        CounterBy = new EditText(this);
        Combo = new EditText(this);
        url1 = new EditText(this);
        url2 = new EditText(this);
        url3= new EditText(this);
        url4 = new EditText(this);
        fotocounter = new ImageButton(this);
        fotocountereadopor = new ImageButton(this);





        btn.setImageResource(getResources().getIdentifier(name, "mipmap", getPackageName()));

        btn.setBackgroundColor(getResources().getColor(R.color.Negro));
        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));


        tv1.setText(R.string.Conterea);
        tv1.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        tv1.setEnabled(false);
        tv1.setTextSize(25);
        tv1.setTextColor(getResources().getColor(R.color.Blanco));
        tv1.setBackgroundColor(getResources().getColor(R.color.Negro));

        tv2.setText(R.string.EsContereado);
        tv2.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        tv2.setEnabled(false);
        tv2.setTextSize(25);
        tv2.setTextColor(getResources().getColor(R.color.Blanco));
        tv2.setBackgroundColor(getResources().getColor(R.color.Negro));

        tv3.setText(name);
        tv3.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        tv3.setEnabled(false);
        tv3.setTextSize(25);
        tv3.setTextColor(getResources().getColor(R.color.Blanco));
        tv3.setBackgroundColor(getResources().getColor(R.color.Negro));

        tv4.setText("Combo");
        tv4.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        tv4.setEnabled(false);
        tv4.setTextSize(25);
        tv4.setTextColor(getResources().getColor(R.color.Blanco));
        tv4.setBackgroundColor(getResources().getColor(R.color.Negro));

        tv5.setText(R.string.BuildsPopulares);
        tv5.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        tv5.setEnabled(false);
        tv5.setTextSize(25);
        tv5.setTextColor(getResources().getColor(R.color.Blanco));
        tv5.setBackgroundColor(getResources().getColor(R.color.Negro));

        tv6.setText(R.string.conquista);
        tv6.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);

        tv6.setTextSize(25);
        tv6.setTextColor(getResources().getColor(R.color.Negro));
        // tv6.setBackgroundColor(getResources().getColor(R.color.gris));

        tv7.setText(R.string.arena);
        tv7.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);

        tv7.setTextSize(25);
        tv7.setTextColor(getResources().getColor(R.color.Negro));
        // tv7.setBackgroundColor(getResources().getColor(R.color.gris));

        tv8.setText(R.string.justa);
        tv8.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);

        tv8.setTextSize(25);
        tv8.setTextColor(getResources().getColor(R.color.Negro));
        // tv8.setBackgroundColor(getResources().getColor(R.color.gris));



        Buscar();
        //fotocounter.setImageResource(getResources().getIdentifier(Counter.toString(), "mipmap", getPackageName()));
        //fotocountereadopor.setImageResource(getResources().getIdentifier(CounterBy.toString(), "mipmap", getPackageName()));

        ln1.addView(tv4);
        ln1.addView(btn);

        ln2.addView(tv3);
        ln2.addView(ln1);
        ln2.addView(tv1);
       // ln2.addView(fotocounter);
        ln2.addView(tv2);
        //ln2.addView(fotocountereadopor);
        ln2.addView(tv5);
        ln2.addView(tv6);
        ln2.addView(tv7);
        ln2.addView(tv8);

    }

    public void Buscar(){

        OpenBaseDeDatos aministrador = new OpenBaseDeDatos(this,"administracion",null,1);
        SQLiteDatabase BasedeDatos =  aministrador.getWritableDatabase();


        String dios = name;

        Cursor Fila = BasedeDatos.rawQuery
                //
                        ("select Combo,Counter,Counterby,arena,Clash,Conquista from Dioses where Dios = "+dios,null);


        if(Fila.moveToFirst()){
            Combo.setText(Fila.getString(0));
            Counter.setText(Fila.getString(1));
            CounterBy.setText(Fila.getString(2));
            url1.setText(Fila.getString(3));
            url2.setText(Fila.getString(4));
            url3.setText(Fila.getString(5));
            url4.setText(Fila.getString(6));
            BasedeDatos.close();
        }else{
            Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show();
            BasedeDatos.close();
        }


    }


}
