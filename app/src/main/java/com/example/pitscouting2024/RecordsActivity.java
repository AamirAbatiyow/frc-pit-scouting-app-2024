package com.example.pitscouting2024;

import android.media.MediaScannerConnection;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class RecordsActivity {
    public static class Info {
        public static String scoutName, teamName, teamNumber, pitNumber, dimensions, weight, drivetrain, autonomous, codingLanguage, visionTracking = "";

        public static String CreateJSON() {
            String json = String.format("\t%s",scoutName);
            json += String.format("\t%s",teamNumber);
            return json;
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
                //MediaScannerConnection.scanFile(this, new String[]{file.getAbsolutePath()}, null, null); 3/4/2024


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
    }
}
