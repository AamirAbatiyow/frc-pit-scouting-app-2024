package com.example.pitscouting2024;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;


public class MatchActivity extends AppCompatActivity {
    EditText shootingMechanism, shootingLocation;
    CheckBox ampScoring, speakerScoring, trapScoring;
    RadioButton source, floor, both, over, under;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        shootingMechanism = findViewById(R.id.shootingMechanismEditText);
        shootingLocation = findViewById(R.id.shootingLocationEditText);
        source = findViewById(R.id.sourceRadioButton);
        floor = findViewById(R.id.floorRadioButton);
        both = findViewById(R.id.bothRadioButton);
        over = findViewById(R.id.overRadioButton);
        under = findViewById(R.id.underRadioButton);
        ampScoring = findViewById(R.id.ampCheckBox);
        speakerScoring = findViewById(R.id.speakerCheckBox);
        trapScoring = findViewById(R.id.trapCheckBox);
        setPrevious();
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

    public void setPrevious(){
        shootingMechanism.setText(RecordsActivity.Info.shootingMechanism);
        shootingLocation.setText(RecordsActivity.Info.shootingLocation);
        ampScoring.setChecked(RecordsActivity.Info.ampScoring);
        speakerScoring.setChecked(RecordsActivity.Info.speakerScoring);
        trapScoring.setChecked(RecordsActivity.Info.trapScoring);
        if (RecordsActivity.Info.intakeFrom=="Source"){
            source.setChecked(true);
        }
        if (RecordsActivity.Info.intakeFrom=="Floor"){
            floor.setChecked(true);
        }
        if (RecordsActivity.Info.intakeFrom=="Both"){
            both.setChecked(true);
        }
        if (RecordsActivity.Info.intakeType == "Over the Bumper") {
            over.setChecked(true);
        }
        if (RecordsActivity.Info.intakeType == "Under the Bumper") {
            under.setChecked(true);
        }
    }

    public void saveData() {
        RecordsActivity.Info.shootingMechanism = shootingMechanism.getText().toString();
        RecordsActivity.Info.shootingLocation = shootingLocation.getText().toString();
        RecordsActivity.Info.ampScoring = ampScoring.isChecked();
        RecordsActivity.Info.speakerScoring = speakerScoring.isChecked();
        RecordsActivity.Info.trapScoring = trapScoring.isChecked();
        if(source.isChecked()){
            RecordsActivity.Info.intakeFrom = "Source";
        } else if (floor.isChecked()){
            RecordsActivity.Info.intakeFrom = "Floor";
        } else if (both.isChecked()){
            RecordsActivity.Info.intakeFrom = "Both";
        } else {
            RecordsActivity.Info.intakeFrom = "";
        }
        if(over.isChecked()){
            RecordsActivity.Info.intakeType = "Over the Bumper";
        } else if (under.isChecked()){
            RecordsActivity.Info.intakeType = "Under the Bumper";
        } else {
            RecordsActivity.Info.intakeType = "";
        }
    }
}
