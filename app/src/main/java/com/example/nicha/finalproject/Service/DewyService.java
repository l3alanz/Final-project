package com.example.nicha.finalproject.Service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Trinity on 4/18/2017.
 */

public class DewyService {
    SQLiteDatabase mDb;
    Database mHelper;
    Context ctx;

    public DewyService(Context ctx){
        this.ctx = ctx;
        mHelper = new Database(ctx);
    }
}
