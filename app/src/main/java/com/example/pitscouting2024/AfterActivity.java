package com.example.pitscouting2024;

import android.content.Intent;
import android.health.connect.datatypes.Record;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AfterActivity extends AppCompatActivity {
    EditText bumper, gp, comments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after);
        bumper = findViewById(R.id.bumperEditText);
        gp = findViewById(R.id.gpEditText);
        comments = findViewById(R.id.commentsEditText);
        setPrevious();
    }
    public void toMain(View view){
        Intent next = new Intent(this, MainActivity.class);
        startActivity(next);
        //RecordsActivity.Info.makeFile();
        RecordsActivity.Info.clear();
    }

    public void backEnd(View view){
        Intent next = new Intent(this, EndActivity.class);
        startActivity(next);
        saveData();
    }

    public void setPrevious(){
        bumper.setText(RecordsActivity.Info.bumper);
        gp.setText(RecordsActivity.Info.gp);
        comments.setText(RecordsActivity.Info.comments);
    }

    public void saveData() {
        RecordsActivity.Info.bumper = bumper.getText().toString();
        RecordsActivity.Info.gp = gp.getText().toString();
        RecordsActivity.Info.comments = comments.getText().toString();
    }
}
