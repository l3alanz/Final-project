package com.example.nicha.finalproject.Service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.nicha.finalproject.Model.MissionSystem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trinity on 4/26/2017.
 */

public class MissionSystemService {
    SQLiteDatabase mDb;
    Database mHelper;
    Context ctx;

    public MissionSystemService(Context ctx){
        this.ctx = ctx;
        mHelper = new Database(ctx);
    }

    public int getCount(){
        int count = 0;
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT Count(*) " +
                " FROM " + MissionSystem.TABLE_NAME  + " WHERE " + MissionSystem.Column.updatedDate + " = date('now','localtime')", null);
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

    public void updateState(String missionName){
        mDb = mHelper.getWritableDatabase();
        mDb.execSQL("UPDATE " + MissionSystem.TABLE_NAME
                + " SET " + MissionSystem.Column.missionState + " = 1 " +
                " WHERE " + MissionSystem.Column.missionName + " = '" + missionName + "' AND "
                + MissionSystem.Column.updatedDate + " = date('now','localtime')");
    }

    public List<String> getNames(){
        List<String> names = new ArrayList<String>();
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT " + MissionSystem.Column.missionName +
                " FROM " + MissionSystem.TABLE_NAME  + " WHERE " + MissionSystem.Column.updatedDate + " = date('now','localtime')", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        while ( !cursor.isAfterLast() ){

            if(cursor.isLast() && cursor.isFirst()) {
                names.add(cursor.getString(0));
            }
            if(cursor.isFirst()){
                names.add(cursor.getString(0) + "]//");
            }else if(cursor.isLast()){
                names.add("["+cursor.getString(0));
            } else {
                names.add("["+cursor.getString(0) + "]//");
            }
            cursor.moveToNext();
        }

        mDb.close();
        mHelper.close();
        return names;
    }

    public String getDetail(String missionName){
        String details = "";
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT " + MissionSystem.Column.missionDetail +
                " FROM " + MissionSystem.TABLE_NAME  + " WHERE " + MissionSystem.Column.missionName + " = '" + missionName + "' AND "
                + MissionSystem.Column.updatedDate + " = date('now','localtime')", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        while ( !cursor.isAfterLast() ){
                details = cursor.getString(0);

            cursor.moveToNext();
        }

        mDb.close();
        mHelper.close();
        return details;
    }

    public String getState(){
        String state = "";
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT " + MissionSystem.Column.missionState +
                " FROM " + MissionSystem.TABLE_NAME  + " WHERE " + MissionSystem.Column.updatedDate + " = date('now','localtime')", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        while ( !cursor.isAfterLast() ){
                state = state + cursor.getString(0);

            cursor.moveToNext();
        }

        mDb.close();
        mHelper.close();
        return state;
    }

    public  List<String> getMissionType(){
        List<String> typed = new ArrayList<String>();
        mDb = mHelper.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("SELECT " + MissionSystem.Column.missionType +
                " FROM " + MissionSystem.TABLE_NAME  + " WHERE " + MissionSystem.Column.updatedDate + " = date('now','localtime')", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        while ( !cursor.isAfterLast() ){
            if(cursor.isLast() && cursor.isFirst()) {
                typed.add(cursor.getString(0));
            }
            if(cursor.isFirst()){
                typed.add(cursor.getString(0) + "]//");
            }else if(cursor.isLast()){
                typed.add("["+cursor.getString(0));
            } else {
                typed.add("["+cursor.getString(0) + "]//");
            }
            cursor.moveToNext();
        }

        return typed;
    }

    public void createMission(int type, String consumed){
        String name;
        int detail;
        int state = 0;
        int range;
        int ran;

        if(type == 1){
            name = "Consume less than ";
            range = (200 - 100) + 1;
            ran =(int) (Math.random() * range) + 100;
            if ((ran % 3) == 0)
                ran = ran * (-1);
            detail = Integer.parseInt(consumed)+ ran;
        }
        else if(type == 2){
            name = "Drink water ";
            range = (7 - 5) + 1;
            detail =(int) (Math.random() * range) + 5;
        }
        else if(type == 3){
            name = "Exercise more than ";
            range = (60-20) + 1;
            detail =(int) (Math.random() * range) + 20;
        }
        else{
            name = "Burned at least ";
            range = (300-100) + 1;
            detail =(int) (Math.random() * range) + 100;
        }

        mDb = mHelper.getWritableDatabase();
        mDb.execSQL("INSERT INTO " + MissionSystem.TABLE_NAME
                + " (" + MissionSystem.Column.missionName + ","
                + MissionSystem.Column.missionDetail + ","
                + MissionSystem.Column.missionType + ","
                + MissionSystem.Column.missionState  + ") VALUES ('" + name
                + "', " + detail+ ", " + type
                + ", " + state+ ");");

    }
}
