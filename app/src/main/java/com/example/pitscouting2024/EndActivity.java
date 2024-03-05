package com.example.pitscouting2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        setPrevious();
    }
    public void toAfter(View view){
        Intent next = new Intent(this, AfterActivity.class);
        startActivity(next);
        saveData();
    }

    public void backMatch(View view){
        Intent next = new Intent(this, MatchActivity.class);
        startActivity(next);
        saveData();
    }

    public void setPrevious(){

    }

    public void saveData() {

    }
}
