package com.vallarmargoulisdevstudio.random_picker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MainActivity extends AppCompatActivity {

    private Button random_number, random_dice, random_users, random_answer, random_spin;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

        random_number = (Button) findViewById(R.id.btn1);
        random_number.setOnClickListener( v -> {
            openRandomNumberGenerator();
        });

        random_dice = (Button) findViewById(R.id.btn3);
        random_dice.setOnClickListener( v -> {
            openRandomDice();
        });


        random_users = (Button) findViewById(R.id.btn4);
        random_users.setOnClickListener( v -> {
            openRandomUsers();
        });

        random_answer = (Button) findViewById(R.id.btn2);
        random_answer.setOnClickListener( v -> {
            openRandomAnswers();
        });

        random_spin = (Button) findViewById(R.id.btn5);
        random_spin.setOnClickListener( v -> {
            openRandomSpin();
        });
    }

    public void openRandomNumberGenerator(){
        Intent intent = new Intent(this, RandomNumbersActivity.class);
        startActivity(intent);
    }

    public void openRandomSpin(){
        Intent intent = new Intent(this, RandomSpinActivity.class);
        startActivity(intent);
    }

    public void openRandomDice() {
        Intent intent = new Intent(this, RandomDiceActivity.class);
        startActivity(intent);
    }

    public void openRandomUsers() {
        Intent intent = new Intent(this, RandomUsersActivity.class);
        startActivity(intent);
    }

    public void openRandomAnswers() {
        Intent intent = new Intent(this, RandomAnswerActivity.class);
        startActivity(intent);
    }

}