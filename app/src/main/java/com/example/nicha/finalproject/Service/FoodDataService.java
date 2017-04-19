package com.example.nicha.finalproject.Service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.nicha.finalproject.Model.ActivityData;
import com.example.nicha.finalproject.Model.FoodData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trinity on 4/18/2017.
 */

public class FoodDataService {

    SQLiteDatabase mDb;
    Database mHelper;
    Context ctx;

    public FoodDataService(Context ctx){
        this.ctx = ctx;
        mHelper = new Database(ctx);
    }

    public List<String> getFoodDefaultList(){
        List<String> foods = new ArrayList<String>();
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT " + FoodData.Column.COL_ITEM_NAME +
                 " FROM " + FoodData.TABLE_NAME, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            foods.add(cursor.getString
                    (cursor.getColumnIndex(FoodData.Column.COL_ITEM_NAME)));
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();
        return foods;
    }

    public List<String> getFoodDataList(String searchItem){
        List<String> foods = new ArrayList<String>();
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT " + FoodData.Column.COL_ITEM_NAME +
                " FROM " + FoodData.TABLE_NAME + " WHERE " + FoodData.Column.COL_ITEM_NAME + " LIKE '" + searchItem + "%' " , null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            foods.add(cursor.getString
                    (cursor.getColumnIndex(FoodData.Column.COL_ITEM_NAME)));
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();
        return foods;
    }

    public List<String> getFood(String searchItem){
        List<String> food = new ArrayList<String>();
        mDb = mHelper.getReadableDatabase();

        Cursor cursor = mDb.rawQuery("SELECT * " +
                " FROM " + FoodData.TABLE_NAME + " WHERE " + FoodData.Column.COL_ITEM_NAME + " = '" + searchItem + "' " , null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        while ( !cursor.isAfterLast() ){
            for(int i=0; i<cursor.getColumnCount();i++)
            {
                if(i != 32) {
                    food.add(cursor.getString(i) + "//");
                }
                else {
                    food.add(cursor.getString(i));
                }
            }
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();
        return food;
    }
}
