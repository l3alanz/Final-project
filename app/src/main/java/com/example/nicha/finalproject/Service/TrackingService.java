package com.example.nicha.finalproject.Service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.nicha.finalproject.Model.Tracking;

/**
 * Created by Trinity on 4/26/2017.
 */

public class TrackingService {
    SQLiteDatabase mDb;
    Database mHelper;
    Context ctx;

    public TrackingService(Context ctx){
        this.ctx = ctx;
        mHelper = new Database(ctx);
    }


    public Tracking getTrack(){
        Tracking track = new Tracking();
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT " + Tracking.Column.stillTime + " , " +
                Tracking.Column.walkingTime + " , " +
                Tracking.Column.runningTime + " , " +
                Tracking.Column.bikingTime + " , " +
                Tracking.Column.drivingTime +
                " FROM " + Tracking.TABLE_NAME  + " WHERE " + Tracking.Column.updatedDate + " = date('now','localtime')", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        while ( !cursor.isAfterLast() ){
            track.setStillTime(cursor.getString(0));
            track.setWalkingTime(cursor.getString(1));
            track.setRunningTime(cursor.getString(2));
            track.setBikingTime(cursor.getString(3));
            track.setDrivingTime(cursor.getString(4));
            cursor.moveToNext();
        }
        mDb.close();
        mHelper.close();
        return track;
    }
/*
    public void updateTrack(){
        mDb = mHelper.getWritableDatabase();
        mDb.execSQL("UPDATE " + Tracking.TABLE_NAME
                + " SET " + Tracking.Column.stillTime + " = '" +stillTime + "' ,"
                + Tracking.Column.walkingTime + " = '" +walkingTime + "' ,"
                + Tracking.Column.runningTime + " = '" +runningTime + "' ,"
                + Tracking.Column.bikingTime + " = " +bikingTime + ","
                + Tracking.Column.drivingTime + " = " +drivingTime +
                " WHERE " + Tracking.Column.updatedDate + " = date('now','localtime')");
    }
*/

    public int checkData(){
        int count = 0;
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT Count(*) " +
                " FROM " + Tracking.TABLE_NAME  + " WHERE " + Tracking.Column.updatedDate + " = date('now','localtime')", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        while ( !cursor.isAfterLast() ){
            count = Integer.parseInt(cursor.getString(0));
            cursor.moveToNext();
        }

        mDb.close();
        mHelper.close();
        return count;
    }

    public void createData(){
        mDb = mHelper.getWritableDatabase();
        mDb.execSQL("INSERT INTO " + Tracking.TABLE_NAME
                + " (" + Tracking.Column.stillTime + ","
                + Tracking.Column.walkingTime + ","
                + Tracking.Column.runningTime + ","
                + Tracking.Column.bikingTime + ","
                + Tracking.Column.drivingTime  + ") VALUES ('" + 0
                + "', " + 0+ ", " + 0 + "," + 0
                + ", " + 0+ ");");

        mDb.close();
        mHelper.close();
    }

    public void updateStill(long stillTime){
        Log.i("DataUpdate", String.valueOf(stillTime));
        mDb = mHelper.getWritableDatabase();
        mDb.execSQL("UPDATE " + Tracking.TABLE_NAME
                + " SET " + Tracking.Column.stillTime + " = '" +stillTime +
                "' WHERE " + Tracking.Column.updatedDate + " = date('now','localtime')");
    }

    public void updateWalk(long walkingTime){
        mDb = mHelper.getWritableDatabase();
        mDb.execSQL("UPDATE " + Tracking.TABLE_NAME
                + " SET " + Tracking.Column.walkingTime + " = '" +walkingTime +
                "' WHERE " + Tracking.Column.updatedDate + " = date('now','localtime')");
    }

    public void updateRun(long runningTime){
        mDb = mHelper.getWritableDatabase();
        mDb.execSQL("UPDATE " + Tracking.TABLE_NAME
                + " SET " + Tracking.Column.runningTime + " = '" +runningTime +
                "' WHERE " + Tracking.Column.updatedDate + " = date('now','localtime')");
    }

    public void updateBike(long bikingTime){
        mDb = mHelper.getWritableDatabase();
        mDb.execSQL("UPDATE " + Tracking.TABLE_NAME
                + " SET " + Tracking.Column.bikingTime + " = '" +bikingTime +
                "' WHERE " + Tracking.Column.updatedDate + " = date('now','localtime')");
    }

    public void updateDrive(long drivingTime){
        mDb = mHelper.getWritableDatabase();
        mDb.execSQL("UPDATE " + Tracking.TABLE_NAME
                + " SET " + Tracking.Column.drivingTime + " = '" +drivingTime +
                "' WHERE " + Tracking.Column.updatedDate + " = date('now','localtime')");
    }
}
