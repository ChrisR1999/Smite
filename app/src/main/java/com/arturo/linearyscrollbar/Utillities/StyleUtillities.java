package com.arturo.linearyscrollbar.Utillities;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

public class StyleUtillities {

    Activity activity;
    static Display display;
    static Point point;

    public StyleUtillities(Activity activity) {
        this.activity = activity;
        display = activity.getWindowManager().getDefaultDisplay();
        point = new Point();
        display.getSize(point);
    }

    public static void styleImages(ImageButton image) {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams((int) (point.x * 0.25), (int) (point.x * 0.25));
        image.setLayoutParams(params);
        image.setScaleType(ImageButton.ScaleType.FIT_XY);
    }

    public static void styleRandomImage(ImageView image) {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams((int) (point.x * 0.40), (int) (point.y * 0.35));
        image.setLayoutParams(params);
        image.setScaleType(ImageButton.ScaleType.FIT_XY);
    }

    /*public static void styleImages(ImageView image) {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(150, 150);
        image.setLayoutParams(params);
        image.setScaleType(ImageButton.ScaleType.FIT_XY);
    }*/

    public static Point getPoint() {
        return point;
    }

}
