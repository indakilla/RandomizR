package com.vallarmargoulisdevstudio.random_picker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RandomDiceActivity extends AppCompatActivity {

    private Button diceBtn;
    private Button backBtn;
    private TextView rollCount;
    private int countRolls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_dice);
        int countRolls = 1;

        diceBtn = (Button) findViewById(R.id.diceBtn);
        backBtn = (Button) findViewById(R.id.backBtn);
        rollCount = (TextView) findViewById(R.id.rollCount);

        final ImageView dice1 = (ImageView) findViewById(R.id.dice1);
        final ImageView dice2 = (ImageView) findViewById(R.id.dice2);

        final int[] diceArray = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };


        diceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random_set = new Random();
                int dice_number1 = random_set.nextInt(6);
                int dice_number2 = random_set.nextInt(6);

                dice1.setImageResource(diceArray[dice_number1]);
                dice2.setImageResource(diceArray[dice_number2]);
                int sum = dice_number1 + dice_number2 + 2;
                Toast.makeText(RandomDiceActivity.this, getResources().getString(R.string.diceScore)+" " + sum, Toast.LENGTH_SHORT).show();
                add_counter();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_to_main();
            }
        });

    }

    public void add_counter () {
        countRolls++;
        String countRollsText = Integer.toString(countRolls);
        rollCount.setText(countRollsText);;
    }

    public void go_to_main () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}