package com.example.pitscouting2024;

import android.content.Intent;
import android.health.connect.datatypes.Record;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

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
        saveData();
        makeFile();
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

    public void makeFile() { // made this static 3/4/2024
        // Create a path where we will place our private file on external storage
        File file = new File("/storage/self/primary/Android/data", "pit_scouting.txt"); //Records.Info.position.replaceAll("\\s","").toLowerCase()

        if (!isExternalStorageWritable())
            return;
        try {
            FileOutputStream os = new FileOutputStream(file, true);
            //PrintWriter pw = new PrintWriter(os);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            String json = RecordsActivity.Info.createJSON();
            osw.write("\n " + json);
            osw.flush();
            //pw.println(json);
            //pw.flush();
            //pw.close();
            os.close();
            MediaScannerConnection.scanFile(this, new String[]{file.getAbsolutePath()}, null, null);


        } catch (IOException e) {
            // Unable to create file, likely because external storage is
            // not currently mounted.
            Log.w("ExternalStorage", "Error writing " + file, e);
        }

    }

    public boolean isExternalStorageWritable() { // made this static 3/4/2024
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
}
