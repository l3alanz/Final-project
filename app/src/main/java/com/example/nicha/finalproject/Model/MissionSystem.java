package com.example.nicha.finalproject.Model;

import android.provider.BaseColumns;

import java.sql.Timestamp;

/**
 * Created by Trinity on 4/26/2017.
 */

public class MissionSystem {


    //Database
    private static final String DB_NAME = "HealthMe";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "missionSystem";

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public int getMissionDetail() {
        return missionDetail;
    }

    public void setMissionDetail(int missionDetail) {
        this.missionDetail = missionDetail;
    }

    public int getMissionType() {
        return missionType;
    }

    public void setMissionType(int missionType) {
        this.missionType = missionType;
    }

    public int getMissionState() {
        return missionState;
    }

    public void setMissionState(int missionState) {
        this.missionState = missionState;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public class Column{
        public static final String id = BaseColumns._ID;
        public static final String missionName = "missionName";
        public static final String missionDetail = "missionDetail";
        public static final String missionType = "missionType";
        public static final String missionState = "missionState";
        public static final String updatedDate = "updatedDate";
    }
    public MissionSystem(){

    }

    public MissionSystem(int id, String missionName, int missionDetail, int missionType, int missionState, Timestamp updatedDate){
        this.id = id;
        this.missionName = missionName;
        this.missionDetail = missionDetail;
        this.missionType = missionType;
        this.missionState = missionState;
        this.updatedDate = updatedDate;
    }

    /* mission type
    1: Consume not more than xxx
    2: Drink water
    3: exercise min
    4: Burned xxx cal
     */

    /*mission State
    1 : Done
    0 : not Done
     */


    private int id;
    private String missionName;
    private int missionDetail;
    private int missionType;
    private int missionState;
    private Timestamp updatedDate;
}
