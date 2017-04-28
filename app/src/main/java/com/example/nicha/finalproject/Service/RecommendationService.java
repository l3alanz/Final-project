package com.example.nicha.finalproject.Service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.nicha.finalproject.Model.FoodData;

/**
 * Created by Trinity on 4/27/2017.
 */

public class RecommendationService {
    SQLiteDatabase mDb;
    Database mHelper;
    Context ctx;

    public RecommendationService(Context ctx){
        this.ctx = ctx;
        mHelper = new Database(ctx);
    }

    public String getBreakfast(){
        String menu = "";
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT " + FoodData.Column.COL_ITEM_NAME +
                " FROM " + FoodData.TABLE_NAME +
                " WHERE " + FoodData.Column.COL_PROTEIN + " < 45 AND " +
                FoodData.Column.COL_CARB + " BETWEEN 40 AND 100 AND " +
                FoodData.Column.COL_TOTAL_FAT + " < 20 " +
                " ORDER BY RANDOM() LIMIT 1", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            menu = cursor.getString(0);
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();
        Log.i("data",menu);
        return menu;
    }

    public String getLunch(){
        String menu = "";
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT " + FoodData.Column.COL_ITEM_NAME +
                " FROM " + FoodData.TABLE_NAME +
                " WHERE " + FoodData.Column.COL_PROTEIN + " < 40 AND " +
                FoodData.Column.COL_CARB + " BETWEEN 40 AND 100 AND " +
                FoodData.Column.COL_TOTAL_FAT + " < 20 " +
                " ORDER BY RANDOM() LIMIT 1", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            menu = cursor.getString(0);
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();

        return menu;
    }

    public String getDinner(){
        String menu = "";
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT " + FoodData.Column.COL_ITEM_NAME +
                " FROM " + FoodData.TABLE_NAME +
                " WHERE " + FoodData.Column.COL_PROTEIN + " < 40 AND " +
                FoodData.Column.COL_CARB + " BETWEEN 40 AND 100 AND " +
                FoodData.Column.COL_TOTAL_FAT + " < 15 " +
                " ORDER BY RANDOM() LIMIT 1", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            menu = cursor.getString(0);
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();

        return menu;
    }


}
