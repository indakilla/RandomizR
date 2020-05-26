package com.vallarmargoulisdevstudio.random_picker;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class RandomUsersActivity extends AppCompatActivity {

    private ArrayList<String> arrayList, arrayShuffled;
    private ArrayAdapter<String> adapter;
    private EditText enterName;
    private TextView randomNameDisplay;
    private Button addNameBtn, generateUsernameBtn, backButton, clearListBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_users);
        //setting the list and arrays
        ListView listView = (ListView) findViewById(R.id.listViewObject);
        String[] items = {};
        arrayList = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this, R.layout.list_items, R.id.addedNames,arrayList);
        listView.setAdapter(adapter);

        //adding new name to the list
        enterName = (EditText) findViewById(R.id.addNewName);
        addNameBtn = (Button) findViewById(R.id.addNameBtn);
        addNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = enterName.getText().toString();
                if ((TextUtils.isEmpty(newName))) {
                    enterName.setError(getResources().getString(R.string.emptyFieldAlert));
                    return;
                } else {
                    arrayList.add(newName);
                    adapter.notifyDataSetChanged();
                    enterName.setText("");}
            }
        });

        randomNameDisplay = (TextView) findViewById(R.id.randomNameDisplay);
        generateUsernameBtn = (Button) findViewById(R.id.generateUsernameBtn);
        generateUsernameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arrayList.isEmpty()) {
                    enterName.setError(getResources().getString(R.string.emptyListAlert));
                } else {
                    Random random_set = new Random();
                    int array_size = arrayList.size();
                    int random_name_int1 = random_set.nextInt(array_size);
                    int random_name_int2 = random_set.nextInt(array_size);
                    int random_name_int3 = random_set.nextInt(array_size);

                    String var1 = Integer.toString(random_name_int1);
                    String var2 = Integer.toString(random_name_int2);
                    String var3 = Integer.toString(random_name_int3);
                    String[] ShuffledItems = {};
                    arrayShuffled = new ArrayList<>(Arrays.asList(ShuffledItems));
                    arrayShuffled.add(var1);
                    arrayShuffled.add(var2);
                    arrayShuffled.add(var3);

                    Collections.shuffle(arrayShuffled);
                    String random_string = arrayShuffled.get(1);
                    int random_int = Integer.parseInt(random_string);
                    String array_size_txt = arrayList.get(random_int);
                    randomNameDisplay.setText(array_size_txt); }
            }
        });

        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_home();;
            }
        });

        clearListBtn = (Button) findViewById(R.id.clearListBtn);
        clearListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart_clear_list();
            }
        });

    }

    public void go_home () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void restart_clear_list () {
        Intent intent = new Intent(this, RandomUsersActivity.class);
        startActivity(intent);
    }
}