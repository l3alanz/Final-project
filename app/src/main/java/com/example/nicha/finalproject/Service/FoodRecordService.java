package com.example.nicha.finalproject.Service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Trinity on 4/18/2017.
 */

public class FoodRecordService {
    SQLiteDatabase mDb;
    Database mHelper;
    Context ctx;

    public FoodRecordService(Context ctx){
        this.ctx = ctx;
        mDb = mHelper.getWritableDatabase();
    }
}
