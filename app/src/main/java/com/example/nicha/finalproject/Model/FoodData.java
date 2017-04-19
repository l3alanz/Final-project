package com.example.nicha.finalproject.Model;

import android.provider.BaseColumns;

/**
 * Created by Trinity on 4/18/2017.
 */

public class FoodData {
    //Database
    private static final String DB_NAME = "HealthMe";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "foodData";

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getAmountPerServing() {
        return amountPerServing;
    }

    public void setAmountPerServing(String amountPerServing) {
        this.amountPerServing = amountPerServing;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public String getCaloriesFromFat() {
        return caloriesFromFat;
    }

    public void setCaloriesFromFat(String caloriesFromFat) {
        this.caloriesFromFat = caloriesFromFat;
    }

    public double getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(double totalFat) {
        this.totalFat = totalFat;
    }

    public String getPercentDailyOfFat() {
        return percentDailyOfFat;
    }

    public void setPercentDailyOfFat(String percentDailyOfFat) {
        this.percentDailyOfFat = percentDailyOfFat;
    }

    public String getSaturatedFat() {
        return saturatedFat  + " g.";
    }

    public void setSaturatedFat(String saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public String getPercentDailyOfSaturatedFat() {
        return percentDailyOfSaturatedFat;
    }

    public void setPercentDailyOfSaturatedFat(String percentDailyOfSaturatedFat) {
        this.percentDailyOfSaturatedFat = percentDailyOfSaturatedFat;
    }

    public String getMonoSaturatedFat() {
        return monoSaturatedFat  + " g.";
    }

    public void setMonoSaturatedFat(String monoSaturatedFat) {
        this.monoSaturatedFat = monoSaturatedFat;
    }

    public String getPolySaturatedFat() {
        return polySaturatedFat  + " g.";
    }

    public void setPolySaturatedFat(String polySaturatedFat) {
        this.polySaturatedFat = polySaturatedFat;
    }

    public String getTranFat() {
        return tranFat  + " g.";
    }

    public void setTranFat(String tranFat) {
        this.tranFat = tranFat;
    }

    public String getCholesterol() {
        return cholesterol  + " mg.";
    }

    public void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol;
    }

    public String getPercentDailyCholesterol() {
        return percentDailyCholesterol;
    }

    public void setPercentDailyCholesterol(String percentDailyCholesterol) {
        this.percentDailyCholesterol = percentDailyCholesterol;
    }

    public String getSodium() {
        return sodium  + " mg.";
    }

    public void setSodium(String sodium) {
        this.sodium = sodium;
    }

    public String getPercentDailyOfSodium() {
        return percentDailyOfSodium;
    }

    public void setPercentDailyOfSodium(String percentDailyOfSodium) {
        this.percentDailyOfSodium = percentDailyOfSodium;
    }

    public String getPotassium() {
        return potassium  + " mg.";
    }

    public void setPotassium(String potassium) {
        this.potassium = potassium;
    }

    public String getPercentDailyOfPotassium() {
        return percentDailyOfPotassium;
    }

    public void setPercentDailyOfPotassium(String percentDailyOfPotassium) {
        this.percentDailyOfPotassium = percentDailyOfPotassium;
    }

    public double getCarb() {
        return carb;
    }

    public void setCarb(double carb) {
        this.carb = carb;
    }

    public String getPercentDailyOfCarb() {
        return percentDailyOfCarb;
    }

    public void setPercentDailyOfCarb(String percentDailyOfCarb) {
        this.percentDailyOfCarb = percentDailyOfCarb;
    }

    public String getFiber() {
        return fiber  + " g.";
    }

    public void setFiber(String fiber) {
        this.fiber = fiber;
    }

    public String getPercentDailyOfFiber() {
        return percentDailyOfFiber;
    }

    public void setPercentDailyOfFiber(String percentDailyOfFiber) {
        this.percentDailyOfFiber = percentDailyOfFiber;
    }

    public String getSugar() {
        return sugar  + " g.";
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public String getPercentDailyOfProtein() {
        return percentDailyOfProtein;
    }

    public void setPercentDailyOfProtein(String percentDailyOfProtein) {
        this.percentDailyOfProtein = percentDailyOfProtein;
    }

    public String getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(String vitaminA) {
        this.vitaminA = vitaminA;
    }

    public String getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(String vitaminC) {
        this.vitaminC = vitaminC;
    }

    public String getCalcium() {
        return calcium;
    }

    public void setCalcium(String calcium) {
        this.calcium = calcium;
    }

    public String getIron() {
        return iron;
    }

    public void setIron(String iron) {
        this.iron = iron;
    }

    public String getVitaminD() {
        return vitaminD;
    }

    public void setVitaminD(String vitaminD) {
        this.vitaminD = vitaminD;
    }

    public String getVitaminB6() {
        return vitaminB6;
    }

    public void setVitaminB6(String vitaminB6) {
        this.vitaminB6 = vitaminB6;
    }

    public String getVitaminB12() {
        return vitaminB12;
    }

    public void setVitaminB12(String vitaminB12) {
        this.vitaminB12 = vitaminB12;
    }

    public String getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(String magnesium) {
        this.magnesium = magnesium;
    }

    public class Column{
        public static final String COL_ID = BaseColumns._ID;
        public static final String COL_ITEM_NAME = "itemName";
        public static final String COL_AMOUNT = "amountPerServing";
        public static final String COL_CALORIES = "calories";
        public static final String COL_CALORIES_FROM_FAT = "caloriesFromFat";
        public static final String COL_TOTAL_FAT = "totalFat";
        public static final String COL_PERCENTAGE_DAILY_FAT = "percentDailyOfFat";
        public static final String COL_SATURATED_FAT = "saturatedFat";
        public static final String COL_PERCENTAGE_DAILY_SATURATED_FAT = "percentDailyOfSaturatedFat";
        public static final String COL_MONOSATURATED_FAT = "monoSaturatedFat";
        public static final String COL_POLYSATURATED_FAT = "polySaturatedFat";
        public static final String COL_TRAN_FAT = "tranFat";
        public static final String COL_CHOLESTEROL = "cholesterol";
        public static final String COL_PERCENTAGE_DAILY_CHOLESTEROL = "percentDailyCholesterol";
        public static final String COL_SODIUM = "sodium";
        public static final String COL_PERCENTAGE_DAILY_SODIUM = "percentDailyOfSodium";
        public static final String COL_POTASSIUM = "potassium";
        public static final String COL_PERCENTAGE_DAILY_POTASSIUM = "percentDailyOfPotassium";
        public static final String COL_CARB = "carb";
        public static final String COL_PERCENTAGE_DAILY_CARB = "percentDailyOfCarb";
        public static final String COL_Fiber = "fiber";
        public static final String COL_PERCENTAGE_DAILY_FIBER = "percentDailyOfFiber";
        public static final String COL_SUGAR = "sugar";
        public static final String COL_PROTEIN = "protein";
        public static final String COL_PERCENTAGE_DAILY_PROTEIN = "percentDailyOfProtein";
        public static final String COL_VITAMIN_A = "vitaminA";
        public static final String COL_VITAMIN_C = "vitaminC";
        public static final String COL_CALCIUM = "calcium";
        public static final String COL_IRON = "iron";
        public static final String COL_VITAMIN_D = "vitaminD";
        public static final String COL_VITAMIN_B6 = "vitaminB6";
        public static final String COL_VITAMIN_B12 = "vitaminB12";
        public static final String COL_MAGNESIUM = "magnesium";
    }
    private int id;
    private String itemName;
    private String amountPerServing;
    private double calories;
    private String caloriesFromFat;
    private double totalFat;
    private String percentDailyOfFat;
    private String saturatedFat;
    private String percentDailyOfSaturatedFat;
    private String monoSaturatedFat;
    private String polySaturatedFat;
    private String tranFat;
    private String cholesterol;
    private String percentDailyCholesterol;
    private String sodium;
    private String percentDailyOfSodium;
    private String potassium;
    private String percentDailyOfPotassium;
    private double carb;
    private String percentDailyOfCarb;
    private String fiber;
    private String percentDailyOfFiber;
    private String sugar;
    private double protein;
    private String percentDailyOfProtein;
    private String vitaminA;
    private String vitaminC;
    private String calcium;
    private String iron;
    private String vitaminD;
    private String vitaminB6;
    private String vitaminB12;
    private String magnesium;

    public FoodData(){

    }

    public FoodData(int id, String itemName, String amountPerServing, int calories, String caloriesFromFat, int totalFat, String percentDailyOfFat, String saturatedFat, String percentDailyOfSaturatedFat, String monoSaturatedFat, String polySaturatedFat, String tranFat, String cholesterol, String percentDailyCholesterol, String sodium, String percentDailyOfSodium, String potassium, String percentDailyOfPotassium, int carb, String percentDailyOfCarb, String fiber, String percentDailyOfFiber, String sugar, int protein, String percentDailyOfProtein, String vitaminA, String vitaminC, String calcium, String iron, String vitaminD, String vitaminB6, String vitaminB12, String magnesium) {
        this.id = id;
        this.itemName = itemName;
        this.amountPerServing = amountPerServing;
        this.calories = calories;
        this.caloriesFromFat = caloriesFromFat;
        this.totalFat = totalFat;
        this.percentDailyOfFat = percentDailyOfFat;
        this.saturatedFat = saturatedFat;
        this.percentDailyOfSaturatedFat = percentDailyOfSaturatedFat;
        this.monoSaturatedFat = monoSaturatedFat;
        this.polySaturatedFat = polySaturatedFat;
        this.tranFat = tranFat;
        this.cholesterol = cholesterol;
        this.percentDailyCholesterol = percentDailyCholesterol;
        this.sodium = sodium;
        this.percentDailyOfSodium = percentDailyOfSodium;
        this.potassium = potassium;
        this.percentDailyOfPotassium = percentDailyOfPotassium;
        this.carb = carb;
        this.percentDailyOfCarb = percentDailyOfCarb;
        this.fiber = fiber;
        this.percentDailyOfFiber = percentDailyOfFiber;
        this.sugar = sugar;
        this.protein = protein;
        this.percentDailyOfProtein = percentDailyOfProtein;
        this.vitaminA = vitaminA;
        this.vitaminC = vitaminC;
        this.calcium = calcium;
        this.iron = iron;
        this.vitaminD = vitaminD;
        this.vitaminB6 = vitaminB6;
        this.vitaminB12 = vitaminB12;
        this.magnesium = magnesium;
    }



}
