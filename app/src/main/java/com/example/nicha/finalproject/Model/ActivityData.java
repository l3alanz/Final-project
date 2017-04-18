package com.example.nicha.finalproject.Model;

import android.provider.BaseColumns;

/**
 * Created by Trinity on 4/18/2017.
 */

public class ActivityData {
    //Database
    private static final String DB_NAME = "HealthMe";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "activityData";
    public class Column{
        public static final String id = BaseColumns._ID;
        public static final String activityName = "activityName";
        public static final String caloriesPerHour = "caloriesPerHour";
    }

    private int id;
    private String activityName;
    private double caloriesPerHour;

    public  ActivityData(){

    }

    public ActivityData(int id, String activityName, double caloriesPerHour) {
        this.id = id;
        this.activityName = activityName;
        this.caloriesPerHour = caloriesPerHour;
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
}
