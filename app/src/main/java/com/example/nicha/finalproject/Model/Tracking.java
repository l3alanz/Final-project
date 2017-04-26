package com.example.nicha.finalproject.Model;

import android.provider.BaseColumns;

import java.sql.Timestamp;

/**
 * Created by Trinity on 4/26/2017.
 */

public class Tracking {
    //Database
    private static final String DB_NAME = "HealthMe";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "trackingRecord";

    public Tracking() {

    }

    public Tracking(int id, String stillTime, String walkingTime, String runningTime, String bikingTime, String drivingTime, Timestamp updatedDate) {
        this.id = id;
        this.stillTime = stillTime;
        this.walkingTime = walkingTime;
        this.runningTime = runningTime;
        this.bikingTime = bikingTime;
        this.drivingTime = drivingTime;
        this.updatedDate = updatedDate;
    }

    public String getStillTime() {
        return stillTime;
    }

    public void setStillTime(String stillTime) {
        this.stillTime = stillTime;
    }

    public String getWalkingTime() {
        return walkingTime;
    }

    public void setWalkingTime(String walkingTime) {
        this.walkingTime = walkingTime;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public String getBikingTime() {
        return bikingTime;
    }

    public void setBikingTime(String bikingTime) {
        this.bikingTime = bikingTime;
    }

    public String getDrivingTime() {
        return drivingTime;
    }

    public void setDrivingTime(String drivingTime) {
        this.drivingTime = drivingTime;
    }

    public class Column{
        public static final String id = BaseColumns._ID;
        public static final String walkingTime = "walkingTime";
        public static final String runningTime = "runningTime";
        public static final String bikingTime = "bikingTime";
        public static final String drivingTime = "drivingTime";
        public static final String stillTime = "stillTime";
        public static final String updatedDate = "updatedDate";
    }

    private int id;
    private String stillTime;
    private String walkingTime;
    private String runningTime;
    private String bikingTime;
    private String drivingTime;
    private Timestamp updatedDate;
}
