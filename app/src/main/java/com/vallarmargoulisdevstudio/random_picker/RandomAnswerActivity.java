package com.vallarmargoulisdevstudio.random_picker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Random;

public class RandomAnswerActivity extends AppCompatActivity {

    private Button generateBtn;
    private TextView generationCount, outputRandom, yestext, notext;
    private String countOutput;
    public static final Random random_set = new Random();
    private int countGenerations, sum;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_answer);
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


        countGenerations = 0;
        generationCount = (TextView) findViewById(R.id.generationCount);

        generateBtn = (Button) findViewById(R.id.generateBtn);

        yestext = (TextView) findViewById(R.id.YesText);
        notext = (TextView) findViewById(R.id.NoText);

        String name1 =  getResources().getString(R.string.YES)+"?";
        String name2 =  getResources().getString(R.string.NO)+"?";

        yestext.setText(name1);
        notext.setText(name2);

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.generateBtn:
                        countGenerations++;
                        countOutput = getResources().getString(R.string.spinNumberText)+" "+ countGenerations;
                        generationCount.setText(countOutput);
                        show_result();
                        break;
                }
            }
        });

    }


    public void show_result() {
        outputRandom = (TextView) findViewById(R.id.outputRandom);
        int random_var = random_set.nextInt(2);
        if (random_var == 0) {
            outputRandom.setText(getResources().getString(R.string.YES));
            yestext.setText("");
            notext.setText("");
        } else {
            outputRandom.setText(getResources().getString(R.string.NO));
            yestext.setText("");
            notext.setText("");
        }
    }

    public void go_to_main() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}