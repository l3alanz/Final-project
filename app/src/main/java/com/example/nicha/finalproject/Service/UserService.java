package com.example.nicha.finalproject.Service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Trinity on 4/18/2017.
 */

public class UserService {
    SQLiteDatabase mDb;
    Database mHelper;
    Context ctx;

    public UserService(Context ctx){
        this.ctx = ctx;
        mDb = mHelper.getReadableDatabase();
    }
}
