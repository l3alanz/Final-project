package com.example.nicha.finalproject.Service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nicha.finalproject.Model.Dewy;

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

    public Dewy getDewy(){
        Dewy data = new Dewy();
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT *" +
                " FROM " + Dewy.TABLE_NAME, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            data.setDewyName(cursor.getString(cursor.getColumnIndex(Dewy.Column.dewyName)));
            data.setDewyLevel(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Dewy.Column.dewyLevel))));
            data.setDewyFood(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Dewy.Column.dewyFood))));
            data.setDewyEXP(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Dewy.Column.dewyEXP))));
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();
        return data;
    }

    public void updateDewy(Dewy data){
        mDb = mHelper.getWritableDatabase();
        mDb.execSQL("UPDATE " + Dewy.TABLE_NAME
                + " SET " + Dewy.Column.dewyName + " = '" + data.getDewyName() + "' ,"
                + Dewy.Column.dewyLevel + " = " + data.getDewyLevel() + ","
                + Dewy.Column.dewyFood + " = " + data.getDewyFood() + ","
                + Dewy.Column.dewyEXP + " = " + data.getDewyEXP() +
                " WHERE _id = 1;");

        mDb.close();
        mHelper.close();
    }

    public void gainDewyFood(){
        int food=0;
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT *" +
                " FROM " + Dewy.TABLE_NAME, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        while ( !cursor.isAfterLast() ){
            food = cursor.getInt(cursor.getColumnIndex(Dewy.Column.dewyFood));
            cursor.moveToNext();
        }

        food = food +1;

        mDb = mHelper.getWritableDatabase();
        mDb.execSQL("UPDATE " + Dewy.TABLE_NAME
                + " SET " + Dewy.Column.dewyFood + " = " + food +
                " WHERE _id = 1;");

        mDb.close();
        mHelper.close();

    }
}
