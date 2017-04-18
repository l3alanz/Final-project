package com.example.nicha.finalproject.Model;

import android.provider.BaseColumns;

import com.example.nicha.finalproject.Utils;

import java.sql.Timestamp;

/**
 * Created by Trinity on 4/18/2017.
 */

public class FoodRecord {
    //Database
    private static final String DB_NAME = "HealthMe";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "foodRecord";
    public class Column{
        public static final String id = BaseColumns._ID;
        public static final String itemName = "itemName";
        public static final String calories = "calories";
        public static final String totalFat = "totalFat";
        public static final String carb = "carb";
        public static final String protein = "protein";
        public static final String serving = "serving";
        public static final String totalCalories = "totalCalories";
        public static final String updatedDate = "updatedDate";
    }

    private int id;
    private String itemName;
    private double calories;
    private double totalFat;
    private double carb;
    private double protein;
    private int serving;
    private double totalCalories;
    private Timestamp updatedDate;

    public FoodRecord(){

    }

    public FoodRecord(int id, String itemName, double calories, double totalFat, double carb, double protein, int serving, double totalCalories, Timestamp updatedDate){
        this.id = id;
        this.itemName = itemName;
        this.calories = calories;
        this.totalFat = totalFat;
        this.carb = carb;
        this.protein = protein;
        this.serving = serving;
        this.totalCalories = totalCalories;
        this.updatedDate = updatedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(double totalFat) {
        this.totalFat = totalFat;
    }

    public double getCarb() {
        return carb;
    }

    public void setCarb(double carb) {
        this.carb = carb;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public int getServing() {
        return serving;
    }

    public void setServing(int serving) {
        this.serving = serving;
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
