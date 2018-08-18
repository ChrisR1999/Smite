package com.arturo.linearyscrollbar.Utillities;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

public class StyleUtillities {
    public static void styleImages(ImageView image){
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(150, 150);
        image.setLayoutParams(params);
        image.setScaleType(ImageButton.ScaleType.FIT_XY);
    }

    public static void styleImages(ImageButton image){
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(300, 300);
        image.setLayoutParams(params);
        image.setScaleType(ImageButton.ScaleType.FIT_XY);
    }

}
