package com.example.pitscouting2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {
    CheckBox climb, harmonize;
    EditText climbTime, climbPosition, driveTeam, bestAt, picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        climb = findViewById(R.id.climbCheckBox);
        harmonize = findViewById(R.id.harmonizeCheckBox);
        climbTime = findViewById(R.id.climbTimeEditText);
        climbPosition = findViewById(R.id.climbPositionEditText);
        driveTeam = findViewById(R.id.driveTeamEditText);
        bestAt = findViewById(R.id.bestAtEditText);
        picture = findViewById(R.id.pictureEditText);
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
        climb.setChecked(RecordsActivity.Info.climb);
        harmonize.setChecked(RecordsActivity.Info.harmonize);
        climbTime.setText(RecordsActivity.Info.climbTime);
        climbPosition.setText(RecordsActivity.Info.climbPosition);
        driveTeam.setText(RecordsActivity.Info.driveTeam);
        bestAt.setText(RecordsActivity.Info.bestAt);
        picture.setText(RecordsActivity.Info.picture);
    }

    public void saveData() {
        RecordsActivity.Info.climb = climb.isChecked();
        RecordsActivity.Info.harmonize = harmonize.isChecked();
        RecordsActivity.Info.climbTime = climbTime.getText().toString();
        RecordsActivity.Info.climbPosition = climbPosition.getText().toString();
        RecordsActivity.Info.driveTeam = driveTeam.getText().toString();
        RecordsActivity.Info.bestAt = bestAt.getText().toString();
        RecordsActivity.Info.picture = picture.getText().toString();
    }
}
