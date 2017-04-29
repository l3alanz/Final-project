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
        public static final String dewyLevel = "dewyLevel";
        public static final String dewyFood = "dewyFood";
        public static final String dewyEXP = "dewyEXP";
    }

    private int id;
    private String dewyName;
    private int dewyLevel;
    private int dewyFood;
    private int dewyEXP;

    public Dewy(int id, String dewyName, int dewyLevel, int dewyFood, int dewyEXP) {
        this.id = id;
        this.dewyName = dewyName;
        this.dewyLevel = dewyLevel;
        this.dewyFood = dewyFood;
        this.dewyEXP = dewyEXP;
    }

    public Dewy() {

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

    public int getDewyLevel() {
        return dewyLevel;
    }

    public void setDewyLevel(int dewyLevel) {
        this.dewyLevel = dewyLevel;
    }

    public int getDewyFood() {
        return dewyFood;
    }

    public void setDewyFood(int dewyFood) {
        this.dewyFood = dewyFood;
    }

    public int getDewyEXP() {
        return dewyEXP;
    }

    public void setDewyEXP(int dewyEXP) {
        this.dewyEXP = dewyEXP;
    }
}
