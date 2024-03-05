package com.example.pitscouting2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.app.AlertDialog;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText scoutName, teamName, teamNumber, pitNumber, dimensions, weight, drivetrain, autonomous, codingLanguage, visionTracking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoutName = findViewById(R.id.scoutNameEditText);
        teamName = findViewById(R.id.teamNameEditText);
        teamNumber = findViewById(R.id.teamNumberEditText);
        pitNumber = findViewById(R.id.pitNumberEditText);
        dimensions = findViewById(R.id.pitNumberEditText);
        weight = findViewById(R.id.robotWeightEditText);
        drivetrain = findViewById(R.id.driveTrainEditText);
        autonomous = findViewById(R.id.autonomousEditText);
        codingLanguage = findViewById(R.id.codingLanguageEditText);
        visionTracking = findViewById(R.id.visionTrackingEditText);
        setPrevious();
    }
    public void toMatch(View view){
        Intent next = new Intent(this, MatchActivity.class);
        startActivity(next);
        saveData();
    }

    public void setPrevious(){
        scoutName.setText(RecordsActivity.Info.scoutName);
        teamNumber.setText(RecordsActivity.Info.teamNumber);
        teamName.setText(RecordsActivity.Info.teamName);
        pitNumber.setText(RecordsActivity.Info.pitNumber);
        dimensions.setText(RecordsActivity.Info.dimensions);
        weight.setText(RecordsActivity.Info.weight);
        drivetrain.setText(RecordsActivity.Info.drivetrain);
        autonomous.setText(RecordsActivity.Info.autonomous);
        codingLanguage.setText(RecordsActivity.Info.codingLanguage);
        visionTracking.setText(RecordsActivity.Info.visionTracking);
    }

    public void saveData() {
        RecordsActivity.Info.scoutName = scoutName.getText().toString();
        RecordsActivity.Info.teamNumber = teamNumber.getText().toString();
        RecordsActivity.Info.teamName = teamName.getText().toString();
        RecordsActivity.Info.pitNumber = pitNumber.getText().toString();
        RecordsActivity.Info.dimensions = dimensions.getText().toString();
        RecordsActivity.Info.weight = weight.getText().toString();
        RecordsActivity.Info.drivetrain = drivetrain.getText().toString();
        RecordsActivity.Info.autonomous = autonomous.getText().toString();
        RecordsActivity.Info.codingLanguage = codingLanguage.getText().toString();
        RecordsActivity.Info.visionTracking = visionTracking.getText().toString();
    }
}