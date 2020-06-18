package com.vallarmargoulisdevstudio.random_picker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.WheelItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RandomStartedSpinActivity extends AppCompatActivity {

    private ArrayList<String> options = new ArrayList<>();
    private ArrayList<Integer> colors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_started_spin);
        options = getIntent().getStringArrayListExtra("options");
        colors = getIntent().getIntegerArrayListExtra("colors");
        LuckyWheel luckyWheel = findViewById(R.id.vLuckyWheel);
        List<WheelItem> items = new ArrayList<>();
        Drawable drawable = getResources().getDrawable(R.drawable.ic_baseline_keyboard_arrow_down_24);
        Bitmap emptyBitmap = BitmapUtils.drawableToBitmap(drawable);
        emptyBitmap.setHeight(1);
        emptyBitmap.setWidth(1);
        items.add(new WheelItem(colors.get(0), emptyBitmap, options.get(0)));
        items.add(new WheelItem(colors.get(1), emptyBitmap, options.get(1)));
        items.add(new WheelItem(colors.get(2), emptyBitmap, options.get(2)));
        items.add(new WheelItem(colors.get(3), emptyBitmap, options.get(3)));
        items.add(new WheelItem(colors.get(4), emptyBitmap, options.get(4)));
        luckyWheel.addWheelItems(items);

        luckyWheel.rotateWheelTo(new Random().nextInt(4));
    }

}