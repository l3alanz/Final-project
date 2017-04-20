package com.example.nicha.finalproject.Service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.nicha.finalproject.Model.FoodRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trinity on 4/18/2017.
 */

public class FoodRecordService {
    SQLiteDatabase mDb;
    Database mHelper;
    Context ctx;

    public FoodRecordService(Context ctx){
        this.ctx = ctx;
        mHelper = new Database(ctx);
    }
    public String getConsume(){
        //List<String> summary = new ArrayList<String>();
        String summary = new String();
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT SUM( " + FoodRecord.Column.totalCalories + ") " +
                " FROM " + FoodRecord.TABLE_NAME  + " WHERE " + FoodRecord.Column.updatedDate + " = date()", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            summary = cursor.getString(0);
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();
        return summary;
    }
}
