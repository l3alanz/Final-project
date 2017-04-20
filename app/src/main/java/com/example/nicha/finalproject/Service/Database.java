package com.example.nicha.finalproject.Service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.nicha.finalproject.Model.ActivityData;
import com.example.nicha.finalproject.Model.ActivityRecord;
import com.example.nicha.finalproject.Model.Dewy;
import com.example.nicha.finalproject.Model.FoodData;
import com.example.nicha.finalproject.Model.FoodRecord;
import com.example.nicha.finalproject.Model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trinity on 4/18/2017.
 */

public class Database extends SQLiteOpenHelper {

    private static final String DB_NAME = "HealthMe";
    private static final int DB_VERSION = 1;
    SQLiteDatabase mDb;

    Context context;

    public Database(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
        context = ctx;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FoodData_TABLE = String.format("CREATE TABLE %s " +
                        "(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s DOUBLE, %s TEXT, %s DOUBLE, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT," +
                        "%s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s DOUBLE, %s TEXT, %s TEXT," +
                        "%s TEXT, %s TEXT, %s DOUBLE, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT," +
                        "%s TEXT, %s TEXT)",
                FoodData.TABLE_NAME,
                FoodData.Column.COL_ID,
                FoodData.Column.COL_ITEM_NAME,
                FoodData.Column.COL_AMOUNT,
                FoodData.Column.COL_CALORIES,
                FoodData.Column.COL_CALORIES_FROM_FAT,
                FoodData.Column.COL_TOTAL_FAT,
                FoodData.Column.COL_PERCENTAGE_DAILY_FAT,
                FoodData.Column.COL_SATURATED_FAT,
                FoodData.Column.COL_PERCENTAGE_DAILY_SATURATED_FAT,
                FoodData.Column.COL_MONOSATURATED_FAT,
                FoodData.Column.COL_POLYSATURATED_FAT,
                FoodData.Column.COL_TRAN_FAT,
                FoodData.Column.COL_CHOLESTEROL,
                FoodData.Column.COL_PERCENTAGE_DAILY_CHOLESTEROL,
                FoodData.Column.COL_SODIUM,
                FoodData.Column.COL_PERCENTAGE_DAILY_SODIUM,
                FoodData.Column.COL_POTASSIUM,
                FoodData.Column.COL_PERCENTAGE_DAILY_POTASSIUM,
                FoodData.Column.COL_CARB,
                FoodData.Column.COL_PERCENTAGE_DAILY_CARB,
                FoodData.Column.COL_Fiber,
                FoodData.Column.COL_PERCENTAGE_DAILY_FIBER,
                FoodData.Column.COL_SUGAR,
                FoodData.Column.COL_PROTEIN,
                FoodData.Column.COL_PERCENTAGE_DAILY_PROTEIN,
                FoodData.Column.COL_VITAMIN_A,
                FoodData.Column.COL_VITAMIN_C,
                FoodData.Column.COL_CALCIUM,
                FoodData.Column.COL_IRON,
                FoodData.Column.COL_VITAMIN_D,
                FoodData.Column.COL_VITAMIN_B6,
                FoodData.Column.COL_VITAMIN_B12,
                FoodData.Column.COL_MAGNESIUM);
        db.execSQL(CREATE_FoodData_TABLE);


        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(
                            "foodData.csv")));
            String readLine = null;
            readLine = br.readLine();

            try {
                while ((readLine = br.readLine()) != null) {
                    String[] str = readLine.split("//,");
                    db.execSQL("INSERT INTO " + FoodData.TABLE_NAME
                            + " (" + FoodData.Column.COL_ITEM_NAME + ","
                            + FoodData.Column.COL_AMOUNT + ","
                            + FoodData.Column.COL_CALORIES + ","
                            + FoodData.Column.COL_CALORIES_FROM_FAT + ","
                            + FoodData.Column.COL_TOTAL_FAT + ","
                            + FoodData.Column.COL_PERCENTAGE_DAILY_FAT + ","
                            + FoodData.Column.COL_SATURATED_FAT + ","
                            + FoodData.Column.COL_PERCENTAGE_DAILY_SATURATED_FAT + ","
                            + FoodData.Column.COL_MONOSATURATED_FAT + ","
                            + FoodData.Column.COL_POLYSATURATED_FAT + ","
                            + FoodData.Column.COL_TRAN_FAT + ","
                            + FoodData.Column.COL_CHOLESTEROL + ","
                            + FoodData.Column.COL_PERCENTAGE_DAILY_CHOLESTEROL + ","
                            + FoodData.Column.COL_SODIUM + ","
                            + FoodData.Column.COL_PERCENTAGE_DAILY_SODIUM + ","
                            + FoodData.Column.COL_POTASSIUM + ","
                            + FoodData.Column.COL_PERCENTAGE_DAILY_POTASSIUM + ","
                            + FoodData.Column.COL_CARB + ","
                            + FoodData.Column.COL_PERCENTAGE_DAILY_CARB + ","
                            + FoodData.Column.COL_Fiber + ","
                            + FoodData.Column.COL_PERCENTAGE_DAILY_FIBER + ","
                            + FoodData.Column.COL_SUGAR + ","
                            + FoodData.Column.COL_PROTEIN + ","
                            + FoodData.Column.COL_PERCENTAGE_DAILY_PROTEIN + ","
                            + FoodData.Column.COL_VITAMIN_A + ","
                            + FoodData.Column.COL_VITAMIN_C + ","
                            + FoodData.Column.COL_CALCIUM + ","
                            + FoodData.Column.COL_IRON + ","
                            + FoodData.Column.COL_VITAMIN_D + ","
                            + FoodData.Column.COL_VITAMIN_B6 + ","
                            + FoodData.Column.COL_VITAMIN_B12 + ","
                            + FoodData.Column.COL_MAGNESIUM + ") VALUES ('" + str[0]
                            + "', '" + str[1] + "', '" + str[2]
                            + "', '" + str[3] + "', '" + str[4]
                            + "', '" + str[5] + "', '" + str[6]
                            + "', '" + str[7] + "', '" + str[8]
                            + "', '" + str[9] + "', '" + str[10]
                            + "', '" + str[11] + "', '" + str[12]
                            + "', '" + str[13] + "', '" + str[14]
                            + "', '" + str[15] + "', '" + str[16]
                            + "', '" + str[17] + "', '" + str[18]
                            + "', '" + str[19] + "', '" + str[20]
                            + "', '" + str[21] + "', '" + str[22]
                            + "', '" + str[23] + "', '" + str[24]
                            + "', '" + str[25] + "', '" + str[26]
                            + "', '" + str[27] + "', '" + str[28]
                            + "', '" + str[29] + "', '" + str[30]
                            + "', '" + str[31] + "');");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Create Activity Data info Database
        String CREATE_ACTIVITY_DATA_TABLE = String.format("CREATE TABLE %s " +
                        "(%s INTEGER PRIMARY KEY  AUTOINCREMENT, %s TEXT, %s DOUBLE)",
                ActivityData.TABLE_NAME,
                ActivityData.Column.id,
                ActivityData.Column.activityName,
                ActivityData.Column.caloriesPerHour);
        db.execSQL(CREATE_ACTIVITY_DATA_TABLE);
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(
                            "activityData.csv")));
            String readLine = null;
            readLine = br.readLine();

            try {
                while ((readLine = br.readLine()) != null) {
                    String[] str = readLine.split("//");
                    db.execSQL("INSERT INTO " + ActivityData.TABLE_NAME
                            + " (" + ActivityData.Column.activityName + ","
                            + ActivityData.Column.caloriesPerHour + ") VALUES ('" + str[0]
                            + "', '" + str[1] + "');");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create User info Database
        String CREATE_USER_TABLE = String.format("CREATE TABLE %s " +
                        "(%s INTEGER PRIMARY KEY  AUTOINCREMENT, %s TEXT, %s TEXT,%s TEXT, %s INTEGER, %s DOUBLE, %s DOUBLE, %s TEXT, %s TEXT, %s DOUBLE, %s DOUBLE, %s DOUBLE)",
                User.TABLE_NAME,
                User.Column.id,
                User.Column.firstName,
                User.Column.lastName,
                User.Column.gender,
                User.Column.age,
                User.Column.weight,
                User.Column.height,
                User.Column.activityType,
                User.Column.target,
                User.Column.BMR,
                User.Column.TDEE,
                User.Column.goal);
        db.execSQL(CREATE_USER_TABLE);
        //set user
        String firstName = "Pattarachai";
        String lastName = "Daovijitr";
        int age = 22;
        String gender = "male";
        double weight = 78.8;
        double height = 173;
        String activityType = "A";
        String target = "B";
        double BMR = 150;
        double TDEE = 160;
        double goal = 170;

        db.execSQL("INSERT INTO " + User.TABLE_NAME
                + " (" + User.Column.firstName + ","
                + User.Column.lastName + ","
                + User.Column.gender + ","
                + User.Column.age + ","
                + User.Column.weight + ","
                + User.Column.height + ","
                + User.Column.activityType + ","
                + User.Column.target + ","
                + User.Column.BMR + ","
                + User.Column.TDEE + ","
                + User.Column.goal + ") VALUES ('" + firstName
                + "', '" + lastName + "', '" + age
                + "', '" + gender+ "', '" + weight
                + "', '" + height+ "', '" + activityType
                + "', '" + target+ "', '" + BMR
                + "', '" + TDEE+ "', '" + goal + "');");

        // Create food record
        String CREATE_FOOD_RECORD_TABLE = String.format("CREATE TABLE %s " +
                        "(%s INTEGER PRIMARY KEY  AUTOINCREMENT, %s TEXT, %s DOUBLE, %s DOUBLE, %s DOUBLE, %s DOUBLE, %s INTEGER, %s DOUBLE, %s DATE DEFAULT CURRENT_DATE)",
                FoodRecord.TABLE_NAME,
                FoodRecord.Column.id,
                FoodRecord.Column.itemName,
                FoodRecord.Column.calories,
                FoodRecord.Column.totalFat,
                FoodRecord.Column.carb,
                FoodRecord.Column.protein,
                FoodRecord.Column.serving,
                FoodRecord.Column.totalCalories,
                FoodRecord.Column.updatedDate);
        db.execSQL(CREATE_FOOD_RECORD_TABLE);
       // set food
        String itemName = "Pizza" ;
        double calories = 250;
        double totalFat = 0;
        double carb = 0;
        double protein = 0;
        int serving = 2;
        double totalCalories = 2*calories;
        db.execSQL("INSERT INTO " + FoodRecord.TABLE_NAME
                + " (" + FoodRecord.Column.itemName + ","
                + FoodRecord.Column.calories + ","
                + FoodRecord.Column.totalFat + ","
                + FoodRecord.Column.carb + ","
                + FoodRecord.Column.protein + ","
                + FoodRecord.Column.serving + ","
                + FoodRecord.Column.totalCalories + ") VALUES ('" + itemName
                + "', '" + calories+ "', '" + totalFat
                + "', '" + carb+ "', '" + protein
                + "', '" + serving+ "', '" + totalCalories + "');");

        // Create activity record
        String CREATE_ACTIVITY_RECORD_TABLE = String.format("CREATE TABLE %s " +
                        "(%s INTEGER PRIMARY KEY  AUTOINCREMENT, %s TEXT, %s DOUBLE, %s INTEGER, %s DOUBLE, %s DATE DEFAULT CURRENT_DATE)",
                ActivityRecord.TABLE_NAME,
                ActivityRecord.Column.id,
                ActivityRecord.Column.activityName,
                ActivityRecord.Column.caloriesPerHour,
                ActivityRecord.Column.minute,
                ActivityRecord.Column.totalCalories,
                ActivityRecord.Column.updatedDate);
        db.execSQL(CREATE_ACTIVITY_RECORD_TABLE);

        // Create Duey Data
        String CREATE_DEWY_TABLE = String.format("CREATE TABLE %s " +
                        "(%s INTEGER PRIMARY KEY  AUTOINCREMENT, %s TEXT, %s INTEGER, %s INTEGER, %s INTEGER)",
                Dewy.TABLE_NAME,
                Dewy.Column.id,
                Dewy.Column.dewyName,
                Dewy.Column.dewyHungry,
                Dewy.Column.dewyFood,
                Dewy.Column.dewyState);
        db.execSQL(CREATE_DEWY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + FoodData.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + FoodRecord.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ActivityData.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ActivityRecord.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Dewy.TABLE_NAME);
        onCreate(db);
    }
    public List<String> getActivityDataList(){
        List<String> activities = new ArrayList<String>();
        mDb = this.getWritableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT " + ActivityData.Column.activityName +
                " FROM " + ActivityData.TABLE_NAME, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            activities.add("Name : " + cursor.getString
                    (cursor.getColumnIndex(ActivityData.Column.activityName)));
            Log.i("Test1", String.valueOf(activities));
            cursor.moveToNext();
        }
        mDb.close();
        return activities;
    }
}
