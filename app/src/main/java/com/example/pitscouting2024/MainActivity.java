package com.example.pitscouting2024;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeFile();
    }
    public void makeFile() {
        // Create a path where we will place our private file on external storage
        File file = new File("/storage/self/primary/Android/data", "test.txt"); //Records.Info.position.replaceAll("\\s","").toLowerCase()

        if (!isExternalStorageWritable())
            return;
        try {
            FileOutputStream os = new FileOutputStream(file, true);
            //PrintWriter pw = new PrintWriter(os);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            String json = "TEST";
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

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}