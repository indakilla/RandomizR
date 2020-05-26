package com.vallarmargoulisdevstudio.random_picker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MainActivity extends AppCompatActivity {

    private Button random_number, random_dice, random_users, random_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setAdUnitId("ca-app-pub-7898563371986745/6670548113");
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        random_number = (Button) findViewById(R.id.btn1);
        random_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRandomNumberGenerator();
            }
        });

        random_dice = (Button) findViewById(R.id.btn3);
        random_dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRandomDice();
            }
        });

        random_users = (Button) findViewById(R.id.btn4);
        random_users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRandomUsers();
            }
        });

        random_answer = (Button) findViewById(R.id.btn2);
        random_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRandomAnswers();
            }
        });
    }

    public void openRandomNumberGenerator(){
        Intent intent = new Intent(this, RandomNumbersActivity.class);
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