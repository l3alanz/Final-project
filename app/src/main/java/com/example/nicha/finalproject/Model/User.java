package com.example.nicha.finalproject.Model;

import android.provider.BaseColumns;

/**
 * Created by Trinity on 4/18/2017.
 */

public class User {
    //Database
    private static final String DB_NAME = "HealthMe";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "user";


    public class Column{
        public static final String id = BaseColumns._ID;
        public static final String firstName = "firstName";
        public static final String lastName = "lastName";
        public static final String age = "age";
        public static final String gender = "gender";
        public static final String weight = "weight";
        public static final String height = "height";
        public static final String activityType = "activityType";
        public static final String target = "target";
        public static final String BMR = "BMR";
        public static final String TDEE = "TDEE";
        public static final String goal = "goal";
    }

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private double weight;
    private double height;
    private String activityType;
    private String target;
    private double BMR;
    private double TDEE;
    private double goal;


    //Default Constructor
    public User() {
    }

    //Constructor
    public User(int id, String firstName, String lastName, int age, String gender, double weight, double height, String activityType, String target,
                double BMR, double TDEE, double goal) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.activityType = activityType;
        this.target = target;
        this.BMR = BMR;
        this.TDEE = TDEE;
        this.goal = goal;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public double getBMR() {
        return BMR;
    }

    public void setBMR(double BMR) {
        this.BMR = BMR;
    }

    public double getTDEE() {
        return TDEE;
    }

    public void setTDEE(double TDEE) {
        this.TDEE = TDEE;
    }

    public double getGoal() {
        return goal;
    }

    public void setGoal(double goal) {
        this.goal = goal;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
