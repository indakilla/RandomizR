package com.vallarmargoulisdevstudio.random_picker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;

import java.util.ArrayList;


public class RandomSpinActivity extends AppCompatActivity implements ColorPickerDialogListener {
    private ArrayList<String> options = new ArrayList<>();
    private ArrayList<Integer> colors = new ArrayList<>();
    private EditText option1, option2, option3, option4, option5;
    private View color1, color2, color3, color4, color5;
    private AdView mAdView;
    private int changedPositionView = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_spin);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setAdUnitId("ca-app-pub-7898563371986745/6670548113");
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        option1 = findViewById(R.id.edOption1);
        option2 = findViewById(R.id.edOption2);
        option3 = findViewById(R.id.edOption3);
        option4 = findViewById(R.id.edOption4);
        option5 = findViewById(R.id.edOption5);

        color1 = findViewById(R.id.colorOption1);
        color2 = findViewById(R.id.colorOption2);
        color3 = findViewById(R.id.colorOption3);
        color4 = findViewById(R.id.colorOption4);
        color5 = findViewById(R.id.colorOption5);

        color1.setOnClickListener(v -> {
            changedPositionView = 1;
            showPickerDialog();
        });
        color2.setOnClickListener(v -> {
            changedPositionView = 2;
            showPickerDialog();
        });
        color3.setOnClickListener(v -> {
            changedPositionView = 3;
            showPickerDialog();
        });
        color4.setOnClickListener(v -> {
            changedPositionView = 4;
            showPickerDialog();
        });
        color5.setOnClickListener(v -> {
            changedPositionView = 5;
            showPickerDialog();
        });

        option1.setHint(String.format(getString(R.string.option), "1"));
        option2.setHint(String.format(getString(R.string.option), "2"));
        option3.setHint(String.format(getString(R.string.option), "3"));
        option4.setHint(String.format(getString(R.string.option), "4"));
        option5.setHint(String.format(getString(R.string.option), "5"));

        Button bStart = findViewById(R.id.bStart);
        bStart.setOnClickListener(v -> {
            addOption(ViewUtils.getText(option1), ViewUtils.getColor(color1));
            addOption(ViewUtils.getText(option2), ViewUtils.getColor(color2));
            addOption(ViewUtils.getText(option3), ViewUtils.getColor(color3));
            addOption(ViewUtils.getText(option4), ViewUtils.getColor(color4));
            addOption(ViewUtils.getText(option5), ViewUtils.getColor(color5));
            Intent intent = new Intent(this, RandomStartedSpinActivity.class);
            intent.putStringArrayListExtra("options", options);
            intent.putIntegerArrayListExtra("colors",colors);
            startActivity(intent);
        });
    }

    private void addOption(String text, int color) {
        options.add(text);
        colors.add(color);
    }

    private void changeColor(int color) {
        switch (changedPositionView) {
            case 1:
                color1.setBackgroundColor(color);
                break;
            case 2:
                color2.setBackgroundColor(color);
                break;
            case 3:
                color3.setBackgroundColor(color);
                break;
            case 4:
                color4.setBackgroundColor(color);
                break;
            case 5:
                color5.setBackgroundColor(color);
                break;
        }
        changedPositionView = 0;
    }

    private void showPickerDialog() {
        ColorPickerDialog.newBuilder()
                .setColor(getColor(R.color.colorAccent))
                .show(this);

    }

    @Override
    public void onColorSelected(int dialogId, int color) {
        changeColor(color);
    }

    @Override
    public void onDialogDismissed(int dialogId) {

    }
}