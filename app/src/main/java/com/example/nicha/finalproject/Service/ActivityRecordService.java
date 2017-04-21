package com.example.nicha.finalproject.Service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.nicha.finalproject.Model.ActivityRecord;
import com.example.nicha.finalproject.Model.FoodRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trinity on 4/18/2017.
 */

public class ActivityRecordService {
    SQLiteDatabase mDb;
    Database mHelper;
    Context ctx;

    public ActivityRecordService(Context ctx){
        this.ctx = ctx;
        mHelper = new Database(ctx);
    }

    public String getMinute(){
        String summary = new String();
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT SUM( " + ActivityRecord.Column.minute + ") " +
                " FROM " + ActivityRecord.TABLE_NAME  + " WHERE " + ActivityRecord.Column.updatedDate + " = date('now','localtime')", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            summary = cursor.getString(0);
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();
        if(summary == null){
            summary = "0";
        }
        return summary;
    }

    public String getBurned(){
        String summary = new String();
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT SUM( " + ActivityRecord.Column.totalCalories + ") " +
                " FROM " + ActivityRecord.TABLE_NAME  + " WHERE " + ActivityRecord.Column.updatedDate + " = date('now','localtime')", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            summary = cursor.getString(0);
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();
        if(summary == null){
            summary = "0";
        }
        return summary;
    }
    public void addExercise(String exerciseName,int caloriesPerhour, int min){

        int totalCalories = (caloriesPerhour/60) * min;

        mDb = mHelper.getWritableDatabase();
        mDb.execSQL("INSERT INTO " + ActivityRecord.TABLE_NAME
                + " (" + ActivityRecord.Column.activityName + ","
                + ActivityRecord.Column.caloriesPerHour + ","
                + ActivityRecord.Column.minute + ","
                + ActivityRecord.Column.totalCalories  + ") VALUES ('" + exerciseName
                + "', " + caloriesPerhour+ ", " + min
                + ", " + totalCalories+ ");");

    }

    public List<String> getExerciseList(){
        List<String> exercises = new ArrayList<String>();
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT " + ActivityRecord.Column.activityName +
                " FROM " + ActivityRecord.TABLE_NAME + " WHERE " + ActivityRecord.Column.updatedDate + " = date('now','localtime')", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        while ( !cursor.isAfterLast() ){
            if(cursor.isLast() && cursor.isFirst()) {
                exercises.add(cursor.getString(0));
            }
            else if(cursor.isFirst()){
                exercises.add(cursor.getString(0) + "]//");
            }else if(cursor.isLast()){
                exercises.add("["+cursor.getString(0));
            } else {
                exercises.add("["+cursor.getString(0) + "]//");
            }
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();
        return exercises;
    }
}
