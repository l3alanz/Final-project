package com.example.nicha.finalproject.Model;

import android.provider.BaseColumns;

/**
 * Created by Trinity on 4/18/2017.
 */

public class Dewy {
    private static final String DB_NAME = "HealthMe";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "dewy";

    public class Column{
        public static final String id = BaseColumns._ID;
        public static final String dewyName = "dewyName";
        public static final String dewyHungry = "dewyHungry";
        public static final String dewyFood = "dewyFood";
        public static final String dewyState = "dewyState";
    }

    private int id;
    private String dewyName;
    private int dewyHungry;
    private int dewyFood;
    private int dewyState;

    public Dewy(int id, String dewyName, int dewyHungry, int dewyFood, int dewyState) {
        this.id = id;
        this.dewyName = dewyName;
        this.dewyHungry = dewyHungry;
        this.dewyFood = dewyFood;
        this.dewyState = dewyState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDewyName() {
        return dewyName;
    }

    public void setDewyName(String dewyName) {
        this.dewyName = dewyName;
    }

    public int getDewyHungry() {
        return dewyHungry;
    }

    public void setDewyHungry(int dewyHungry) {
        this.dewyHungry = dewyHungry;
    }

    public int getDewyFood() {
        return dewyFood;
    }

    public void setDewyFood(int dewyFood) {
        this.dewyFood = dewyFood;
    }

    public int getDewyState() {
        return dewyState;
    }

    public void setDewyState(int dewyState) {
        this.dewyState = dewyState;
    }
}
