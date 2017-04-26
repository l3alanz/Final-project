package com.example.nicha.finalproject.Model;

import android.provider.BaseColumns;

import com.example.nicha.finalproject.Utils;

import java.sql.Timestamp;

/**
 * Created by Trinity on 4/18/2017.
 */

public class ActivityRecord {
    //Database
    private static final String DB_NAME = "HealthMe";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "activityRecord";
    public class Column{
        public static final String id = BaseColumns._ID;
        public static final String activityName = "activityName";
        public static final String caloriesPerHour = "caloriesPerHour";
        public static final String minute = "minute";
        public static final String totalCalories = "totalCalories";
        public static final String updatedDate = "updatedDate";
    }

    private int id;
    private String activityName;
    private double caloriesPerHour;
    private int minute;
    private double totalCalories;
    private Timestamp updatedDate;

    public ActivityRecord(int id, String activityName, double caloriesPerHour, int minute, double totalCalories, Timestamp updatedDate){
        this.id = id;
        this.activityName = activityName;
        this.caloriesPerHour = caloriesPerHour;
        this.minute = minute;
        this.totalCalories = totalCalories;
        this.updatedDate = updatedDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public double getCaloriesPerHour() {
        return caloriesPerHour;
    }

    public void setCaloriesPerHour(double caloriesPerHour) {
        this.caloriesPerHour = caloriesPerHour;
    }

    public int getMin() {
        return minute;
    }

    public void setMin(int minute) {
        this.minute = minute;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedDateDisplay()
    {
        return Utils.convertTimestampToString(this.updatedDate, "dd-MMM-yyyy HH:mm:ss");
    }
}
