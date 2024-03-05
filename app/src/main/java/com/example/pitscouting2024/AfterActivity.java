package com.example.pitscouting2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AfterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after);
        setPrevious();
    }
    public void toMain(View view){
        Intent next = new Intent(this, MainActivity.class);
        startActivity(next);
        saveData();
    }

    public void backEnd(View view){
        Intent next = new Intent(this, EndActivity.class);
        startActivity(next);
        saveData();
    }

    public void setPrevious(){

    }

    public void saveData() {

    }
}
