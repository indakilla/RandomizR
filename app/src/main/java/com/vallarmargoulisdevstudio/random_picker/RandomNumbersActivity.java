package com.vallarmargoulisdevstudio.random_picker;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RandomNumbersActivity extends AppCompatActivity {

    private EditText minimum_number, maximum_number;
    private Button generateBtn;
    private Button backBtn;
    private TextView outputRandom, generationCount;
    public static final Random random_set = new Random();
    private String editTextValueMax, editTextValueMin, countOutput;
    private int countGenerations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_numbers);
        countGenerations = 0;

        generationCount = (TextView) findViewById(R.id.generationCount);

        minimum_number = (EditText) findViewById(R.id.minimum_number);
        maximum_number = (EditText) findViewById(R.id.maximum_number);

        minimum_number.setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "999999999" )}) ;
        maximum_number.setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "999999999" )}) ;

        generateBtn = (Button) findViewById(R.id.generateBtn);
        backBtn = (Button) findViewById(R.id.backBtn);

        generateBtn.setOnClickListener(RandomNumbersActivity.this);
        backBtn.setOnClickListener(RandomNumbersActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.generateBtn:
                String inputMin = minimum_number.getText().toString();
                String inputMax = maximum_number.getText().toString();


                if ((TextUtils.isEmpty(inputMin))) {
                    minimum_number.setError(getResources().getString(R.string.minAlert));
                    return;
                } else if ((TextUtils.isEmpty(inputMax))){
                    maximum_number.setError(getResources().getString(R.string.maxAlert));
                    return;
                } else {
                    countGenerations++;
                    countOutput = getResources().getString(R.string.spinNumberText)+" "+ countGenerations;
                    generationCount.setText(countOutput);
                    show_result();
                    break;}
            case R.id.backBtn:
                go_to_main();
                break;
        }
    }

    public void show_result() {
        int min = Integer.parseInt(minimum_number.getText().toString());
        int max = Integer.parseInt(maximum_number.getText().toString());

        if (min > max) {
            maximum_number.setError(getResources().getString(R.string.maxNotMoreThanMin));
        } else if (min == max) {
            maximum_number.setError(getResources().getString(R.string.maxNotMoreThanMin));
        } else {
            int random_var = random_set.nextInt(max - min + 1) + min;
            String random_var_text = Integer.toString(random_var);
            outputRandom = (TextView) findViewById(R.id.outputRandom);
            outputRandom.setText(random_var_text);
            Toast.makeText(this, getResources().getString(R.string.outputText)+" "+ random_var, Toast.LENGTH_SHORT).show();
        }
    }

    public void go_to_main() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void restart() {
        Intent intent = new Intent(this, RandomNumbersActivity.class);
        startActivity(intent);

    }
}