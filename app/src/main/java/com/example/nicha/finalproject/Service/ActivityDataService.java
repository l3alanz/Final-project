package com.example.nicha.finalproject.Service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.nicha.finalproject.Model.ActivityData;
import com.example.nicha.finalproject.Model.FoodData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trinity on 4/18/2017.
 */

public class ActivityDataService  {
    SQLiteDatabase mDb;
    Database mHelper;
    Context ctx;

    public ActivityDataService(Context ctx){
        this.ctx = ctx;
        mHelper = new Database(ctx);
    }
    public List<String> getActivityDefaultList(){
        List<String> activities = new ArrayList<String>();
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT " + ActivityData.Column.activityName +
                " FROM " + ActivityData.TABLE_NAME, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            activities.add(cursor.getString
                    (cursor.getColumnIndex(ActivityData.Column.activityName)));
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();
        return activities;
    }

    public List<String> getActivityDataList(String searchItem){
        List<String> activities = new ArrayList<String>();
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT " + ActivityData.Column.activityName +
                " FROM " + ActivityData.TABLE_NAME + " WHERE " + ActivityData.Column.activityName + " LIKE '" + searchItem + "%' " , null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            activities.add(cursor.getString
                    (cursor.getColumnIndex(ActivityData.Column.activityName)));
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();
        return activities;
    }
}
