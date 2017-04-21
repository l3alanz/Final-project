package com.example.nicha.finalproject.Service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.nicha.finalproject.Model.User;

/**
 * Created by Trinity on 4/18/2017.
 */

public class UserService {
    SQLiteDatabase mDb;
    Database mHelper;
    Context ctx;

    public UserService(Context ctx){
        this.ctx = ctx;
        mHelper = new Database(ctx);
    }

    public User getData(){
        User summary = new User();
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT * " +
                " FROM " + User.TABLE_NAME, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            summary.setId(cursor.getInt(0));
            summary.setFirstName(cursor.getString(1));
            summary.setLastName(cursor.getString(2));
            summary.setGender(cursor.getString(3));
            summary.setAge(cursor.getInt(4));
            summary.setWeight(cursor.getDouble(5));
            summary.setHeight(cursor.getDouble(6));
            summary.setActivityType(cursor.getString(7));
            summary.setTarget(cursor.getString(8));
            summary.setBMR(cursor.getDouble(9));
            summary.setTDEE(cursor.getDouble(10));
            summary.setGoal(cursor.getDouble(11));
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();

        return summary;
    }

    public String getGoal(){
        String summary = new String();
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT SUM( " + User.Column.goal + ") " +
                " FROM " + User.TABLE_NAME, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            summary = cursor.getString(0);
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();
        if(summary != null){
        Double sum = Math.floor(Double.parseDouble(summary));
        summary = String.valueOf(sum.intValue());
        }
        return summary;
    }

    public  void updateData(User userInfo){
        //set user
        String firstName = userInfo.getFirstName();
        String lastName = userInfo.getLastName();
        int age = userInfo.getAge();
        String gender = userInfo.getGender();
        double weight = userInfo.getWeight();
        double height = userInfo.getHeight();
        String activityType = userInfo.getActivityType();
        String target = userInfo.getTarget();
        double BMR = 0;
        if(gender.equals("male")){
            BMR = 66 + (13.7 * weight) + (5 * height) - (6.76 * age);
        }
        else if (gender.equals("female")){
            BMR = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
        }

        double TDEE = 0 ;
        if(activityType.equals("A")){
            TDEE = BMR*1.2;
        } else if(activityType.equals("B")){
            TDEE = BMR*1.375;
        } else if(activityType.equals("C")){
            TDEE = BMR*1.55;
        } else if(activityType.equals("D")){
            TDEE = BMR*1.725;
        } else if(activityType.equals("E")){
            TDEE = BMR*1.9;
        }
        double goal = 0;
        if(target.equals("A")) {
            goal = TDEE - 500;
        } else if(target.equals("B")){
            goal = TDEE;
        } else if(target.equals("C")){
            goal = TDEE + 500;
        }
        mDb = mHelper.getWritableDatabase();
        mDb.execSQL("UPDATE " + User.TABLE_NAME
                + " SET " + User.Column.firstName + " = '" +firstName + "' ,"
                + User.Column.lastName + " = '" +lastName + "' ,"
                + User.Column.gender + " = '" +gender + "' ,"
                + User.Column.age + " = " +age + ","
                + User.Column.weight + " = " +weight + ","
                + User.Column.height + " = " +height + ","
                + User.Column.activityType + " = '" +activityType + "' ,"
                + User.Column.target + " = '" +target + "' ,"
                + User.Column.BMR + " = " +BMR + ","
                + User.Column.TDEE + " = " +TDEE + ","
                + User.Column.goal + " = " +goal +
                " WHERE _id = 1;");
    }
}
