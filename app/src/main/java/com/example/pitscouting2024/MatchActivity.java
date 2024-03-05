package com.example.pitscouting2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MatchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
    }
    public void toEnd(View view){
        Intent next = new Intent(this, EndActivity.class);
        startActivity(next);
        saveData();
    }

    public void backMain(View view){
        Intent next = new Intent(this, MainActivity.class);
        startActivity(next);
        saveData();
    }

    public void saveData() {

    }
}
