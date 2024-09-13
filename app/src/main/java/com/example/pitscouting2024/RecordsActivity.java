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
        public static String scoutName, teamName, teamNumber, dimensions, weight, drivetrain, autonomous, codingLanguage, visionTracking, shootingMechanism, shootingLocation, intakeFrom, intakeType, climbTime, climbPosition, driveTeam, bestAt, picture, bumper, gp, comments  = "";
        public static boolean ampScoring, speakerScoring, trapScoring, climb, harmonize = false;
        public static String createJSON() {
            String json = String.format("!%s",scoutName);
            json += String.format("*%s", teamNumber);
            json += String.format("*%s",teamName);
            json += String.format("*%s",dimensions);
            json += String.format("*%s",weight);
            json += String.format("*%s",drivetrain);
            json += String.format("*%s",codingLanguage);
            json += String.format("*%s",visionTracking);
            json += String.format("*%s",autonomous);
            json += String.format("*%s",intakeFrom);
            json += String.format("*%s",intakeType);
            json += String.format("*%s",ampScoring);
            json += String.format("*%s",speakerScoring);
            json += String.format("*%s",trapScoring);
            json += String.format("*%s",shootingMechanism);
            json += String.format("*%s",shootingLocation);
            json += String.format("*%s",climb);
            json += String.format("*%s",harmonize);
            json += String.format("*%s",climbTime);
            json += String.format("*%s",climbPosition);
            json += String.format("*%s",driveTeam);
            json += String.format("*%s",bestAt);
            json += String.format("*%s",picture);
            json += String.format("*%s",bumper);
            json += String.format("*%s",gp);
            json += String.format("*%s",comments);
            return json;
        }

        public static void clear(){
            teamName= ""; teamNumber= ""; dimensions= ""; weight= ""; drivetrain= ""; autonomous= ""; codingLanguage= ""; visionTracking= ""; shootingMechanism= ""; shootingLocation= ""; intakeFrom= ""; intakeType= ""; climbTime= ""; climbPosition= ""; driveTeam= ""; bestAt= ""; picture= ""; bumper= ""; gp= ""; comments= "";
            ampScoring= false; speakerScoring= false; trapScoring= false; climb= false; harmonize = false;
        }
    }
}
