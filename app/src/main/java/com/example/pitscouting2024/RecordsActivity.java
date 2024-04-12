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
            String json = String.format("\n%s",scoutName);
            json += String.format("\t%s", teamNumber);
            json += String.format("\t%s",teamName);
            json += String.format("\t%s",dimensions);
            json += String.format("\t%s",weight);
            json += String.format("\t%s",drivetrain);
            json += String.format("\t%s",codingLanguage);
            json += String.format("\t%s",visionTracking);
            json += String.format("\t%s",autonomous);
            json += String.format("\t%s",intakeFrom);
            json += String.format("\t%s",intakeType);
            json += String.format("\t%s",ampScoring);
            json += String.format("\t%s",speakerScoring);
            json += String.format("\t%s",trapScoring);
            json += String.format("\t%s",shootingMechanism);
            json += String.format("\t%s",shootingLocation);
            json += String.format("\t%s",climb);
            json += String.format("\t%s",harmonize);
            json += String.format("\t%s",climbTime);
            json += String.format("\t%s",climbPosition);
            json += String.format("\t%s",driveTeam);
            json += String.format("\t%s",bestAt);
            json += String.format("\t%s",picture);
            json += String.format("\t%s",bumper);
            json += String.format("\t%s",gp);
            json += String.format("\t%s",comments);
            return json;
        }

        public static void clear(){
            teamName= ""; teamNumber= ""; dimensions= ""; weight= ""; drivetrain= ""; autonomous= ""; codingLanguage= ""; visionTracking= ""; shootingMechanism= ""; shootingLocation= ""; intakeFrom= ""; intakeType= ""; climbTime= ""; climbPosition= ""; driveTeam= ""; bestAt= ""; picture= ""; bumper= ""; gp= ""; comments= "";
            ampScoring= false; speakerScoring= false; trapScoring= false; climb= false; harmonize = false;
        }
    }
}
