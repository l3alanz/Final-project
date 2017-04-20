package com.example.nicha.finalproject.Service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
        return summary;
    }
}
