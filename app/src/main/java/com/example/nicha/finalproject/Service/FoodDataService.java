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

    public List<String> getFoodDataList(){
        List<String> foods = new ArrayList<String>();
        mDb = mHelper.getWritableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT " + FoodData.Column.COL_ITEM_NAME +
                 " FROM " + FoodData.TABLE_NAME + " WHERE _id = 50 ", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            foods.add("Name : " + cursor.getString
                    (cursor.getColumnIndex(FoodData.Column.COL_ITEM_NAME)));
            Log.i("Test1", String.valueOf(foods));
            cursor.moveToNext();
        }
        mDb.close();
        return foods;
    }
}
