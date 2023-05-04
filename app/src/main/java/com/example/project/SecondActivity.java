package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private final String key = String.valueOf(R.string.ShowData);
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        sharedPreferences = getSharedPreferences(key, MODE_PRIVATE);

        button = findViewById(R.id.ViewButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveUserData();
                finish();
            }
        });
    }
    void saveUserData() {
        EditText input = findViewById(R.id.Writeinput);
        String data = input.getText().toString();
        SharedPreferences.Editor sharedPrefDataEditor = sharedPreferences.edit();
        sharedPrefDataEditor.putString(key, data);
        sharedPrefDataEditor.apply();
    }
}