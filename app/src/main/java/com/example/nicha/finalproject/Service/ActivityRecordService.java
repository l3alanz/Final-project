package com.example.nicha.finalproject.Service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

    public List<String> getMinute(){
        List<String> summary = new ArrayList<String>();
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT SUM( " + ActivityRecord.Column.minute + ") " +
                " FROM " + ActivityRecord.TABLE_NAME  + " WHERE " + ActivityRecord.Column.updatedDate + " = date()", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            summary.add(cursor.getString(0));
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();
        return summary;
    }
}
