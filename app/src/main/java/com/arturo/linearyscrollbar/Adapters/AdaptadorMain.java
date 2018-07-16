package com.arturo.linearyscrollbar.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.arturo.linearyscrollbar.Modelos.ModeloDiosesMain;
import com.arturo.linearyscrollbar.R;

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
        TextView godName;
        TextView godCategoryText;
        TextView godPanteon;
        ImageView godImage;
        ImageView godImageCategory;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.godcard, null);
        }

        final ModeloDiosesMain dir = items.get(position);

        ImageButton special = (ImageButton) v.findViewById(R.id.special);
        special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        godName = (TextView) v.findViewById(R.id.nombre);
        godCategoryText = (TextView) v.findViewById(R.id.godCategory);
        godPanteon = (TextView) v.findViewById(R.id.godGroup);
        godName.setText(dir.getGodName());
        godCategoryText.setText(dir.getGodCategory());
        godPanteon.setText(dir.getGodPanteon());
        godImage = (ImageView) v.findViewById(R.id.godImage);
        godImage.setImageResource(contexto.getResources().getIdentifier(dir.getResourceImage(), "mipmap", contexto.getPackageName()));
        godImageCategory = (ImageView) v.findViewById(R.id.godCategoryImg);
        switch (dir.getGodCategory()) {
            case "Guerrero":
                godImageCategory.setImageResource(R.drawable.ic_sword);
                break;
            case "Asesino":
                godImageCategory.setImageResource(R.drawable.ic_assassin);
                break;
            case "Mago":
                godImageCategory.setImageResource(R.drawable.ic_mage);
                break;
            case "Tanque":
                godImageCategory.setImageResource(R.drawable.ic_shield);
                break;
            case "ADC":
                godImageCategory.setImageResource(R.drawable.ic_adc);
                break;
            default:
                godImageCategory.setImageResource(R.drawable.ic_question);
                break;
        }
        return v;
    }

    public void borrar(int i) {

    }

}