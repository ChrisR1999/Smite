package com.arturo.linearyscrollbar.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.arturo.linearyscrollbar.BuildMaker;
import com.arturo.linearyscrollbar.Modelos.ModeloDiosesMain;
import com.arturo.linearyscrollbar.R;
import com.arturo.linearyscrollbar.itemRandom;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


public class AdaptadorMain extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<ModeloDiosesMain> items;
    private Context contexto;


    public AdaptadorMain(Activity activity, ArrayList<ModeloDiosesMain> items, Context contexto) {
        this.activity = activity;
        this.items = items;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {

        View v = convertView;
        final ModeloDiosesMain dir = items.get(position);
        final TextView godName;
        final TextView godCategoryText;
        final TextView godPanteon;
        final ImageView godImage;
        final ImageButton randomButton;
        final ImageButton buildButton;
        String godTypeLabel = "";

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.god_card2, null);
        }

        godName = (TextView) v.findViewById(R.id.cardGodName2);
        godCategoryText = (TextView) v.findViewById(R.id.cardGodCategory2);
        godPanteon = (TextView) v.findViewById(R.id.pantheonGodCard2);
        godName.setText(dir.getGodName());
        godImage = (ImageView) v.findViewById(R.id.imageGodCard2);
        godImage.setImageDrawable(createImage(dir));
        randomButton = (ImageButton) v.findViewById(R.id.randomGodCard);
        buildButton = (ImageButton) v.findViewById(R.id.buildGodCard);

        switch (dir.getGodCategory()) {
            case 1:
                godCategoryText.setText(contexto.getResources().getString(R.string.categoriaGuerrero));
                break;
            case 2:
                godCategoryText.setText(contexto.getResources().getString(R.string.categoriaMago));
                break;
            case 3:
                godCategoryText.setText(contexto.getResources().getString(R.string.categoriaADC));
                break;
            case 4:
                godCategoryText.setText(contexto.getResources().getString(R.string.categoriaMagoSoporte));
                break;
            case 5:
                godCategoryText.setText(contexto.getResources().getString(R.string.categoriaTanque));
                break;
            case 6:
                godCategoryText.setText(contexto.getResources().getString(R.string.categoriaAsesino));
                break;
        }

        godCategoryText.setText(godCategoryText.getText().toString() + " | ");

        switch (dir.getGodPanteon()) {
            case 1:
                godPanteon.setText(contexto.getResources().getString(R.string.panteonGriego));
                break;
            case 2:
                godPanteon.setText(contexto.getResources().getString(R.string.panteonHindu));
                break;
            case 3:
                godPanteon.setText(contexto.getResources().getString(R.string.panteonMaya));
                break;
            case 4:
                godPanteon.setText(contexto.getResources().getString(R.string.panteonJapones));
                break;
            case 5:
                godPanteon.setText(contexto.getResources().getString(R.string.panteonEgipcio));
                break;
            case 6:
                godPanteon.setText(contexto.getResources().getString(R.string.panteonChino));
                break;
            case 7:
                godPanteon.setText(contexto.getResources().getString(R.string.panteonCelta));
                break;
            case 8:
                godPanteon.setText(contexto.getResources().getString(R.string.panteonRomano));
                break;
            case 9:
                godPanteon.setText(contexto.getResources().getString(R.string.panteonVudu));
                break;
            case 10:
                godPanteon.setText(contexto.getResources().getString(R.string.panteonEslavo));
                break;
            case 11:
                godPanteon.setText(contexto.getResources().getString(R.string.panteonNordico));
                break;
            case 12:
                godPanteon.setText(contexto.getResources().getString(R.string.panteonPolinesio));
                break;
            case 13:
                godPanteon.setText(contexto.getResources().getString(R.string.panteonExcalibur));
                break;
        }

        switch (dir.getGodType()) {
            case 1:
                godTypeLabel = "fisico";
                break;
            case 2:
                godTypeLabel = "magico";
                break;
        }


        final String finalGodTypeLabel = godTypeLabel;

        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, itemRandom.class);
                intent.putExtra("godName", dir.getGodName());
                intent.putExtra("godType", finalGodTypeLabel);
                activity.startActivity(intent);
            }
        });

        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, BuildMaker.class);
                intent.putExtra("godName", dir.getGodName());
                intent.putExtra("godType", finalGodTypeLabel);
                activity.startActivity(intent);
            }
        });

        return v;
    }

    public RoundedBitmapDrawable createImage(ModeloDiosesMain dir) {
        Bitmap bmp = BitmapFactory.decodeResource(contexto.getResources(), contexto.getResources().getIdentifier(dir.getResourceImage(), "mipmap", contexto.getPackageName()));
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(null, bmp);
        roundedDrawable.setCornerRadius(8);
        return roundedDrawable;
    }

    public int getTypeID(int position) {
        return items.get(position).getGodCategory();
    }


}