package com.example.nicha.finalproject.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nicha.finalproject.DailyJournalActivity;
import com.example.nicha.finalproject.FoodExerciseActivity;
import com.example.nicha.finalproject.R;
import com.example.nicha.finalproject.RecommendationActivity;
import com.example.nicha.finalproject.Service.ActivityRecordService;
import com.example.nicha.finalproject.Service.FoodRecordService;
import com.example.nicha.finalproject.Service.UserService;
import com.example.nicha.finalproject.SettingActivity;
import com.example.nicha.finalproject.TrackingActivity;
import com.example.nicha.finalproject.Service.Database;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle; // Hamburger button
    Toolbar toolbar;
    TextView showGoal;
    TextView showBurned;
    TextView showConsumed;
    TextView showRemaining;
    TextView showWater;
    TextView showExercise;
    FoodRecordService voFoodRecord;
    UserService voUser;
    ActivityRecordService voActivityRecord;
    String goal;
    String burned;
    String consumed;
    String remaining;
    String water;
    String exercise;
    List<String> summamry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        voFoodRecord = new FoodRecordService(this);
        voUser = new UserService(this);
        voActivityRecord = new ActivityRecordService(this);

        Button btnGoSetting;
        Button btnGoSummary;
        Button btnGoDaily;
        Button btnGoFoodEx;
        Button btnGoTracking;
        Button btnGoRecommendation;
        btnGoSetting = (Button) findViewById(R.id.btnGoSetting);
        btnGoSummary = (Button) findViewById(R.id.btnGoSummary);
        btnGoDaily = (Button) findViewById(R.id.btnGoDaily);
        btnGoFoodEx = (Button) findViewById(R.id.btnGoFoodEx);
        btnGoTracking = (Button) findViewById(R.id.btnGoTracking);
        btnGoRecommendation = (Button) findViewById(R.id.btnGoRecommendation);


        btnGoSetting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,
                        SettingActivity.class);
                startActivity(intent1);

            }
        });

        btnGoSummary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this,
                        MainActivity.class);
                startActivity(intent2);

            }
        });

        btnGoDaily.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this,
                        DailyJournalActivity.class);
                startActivity(intent3);

            }
        });

        btnGoFoodEx.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity.this,
                        FoodExerciseActivity.class);
                startActivity(intent4);

            }
        });

        btnGoRecommendation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity.this,
                        RecommendationActivity.class);
                startActivity(intent4);

            }
        });

        btnGoTracking.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(MainActivity.this,
                        TrackingActivity.class);
                startActivity(intent5);

            }
        });

        initInstances();
        // main
        showGoal = (TextView)findViewById(R.id.tvShowGoal);
        showBurned = (TextView)findViewById(R.id.tvShowBurned);
        showConsumed = (TextView)findViewById(R.id.tvShowConsumed);
        showRemaining = (TextView)findViewById(R.id.tvShowRemaining);
        showWater = (TextView)findViewById(R.id.tvShowWater);
        showExercise = (TextView)findViewById(R.id.tvShowExercise);
        //
        goal = voUser.getGoal();
        consumed = voFoodRecord.getConsume();
        burned = voActivityRecord.getBurned();
        remaining = getRemain(goal,consumed,burned);
        water = voFoodRecord.getWater();
        exercise = voActivityRecord.getMinute();
        //
        showGoal.setText(goal);
        showBurned.setText(burned);
        showConsumed.setText(consumed);
        showRemaining.setText(remaining);
        showWater.setText(water);
        showExercise.setText(exercise);
        ฟฟหก;
    }

    public String getRemain(String goal,String consumed, String burned){
        int remain = Integer.parseInt(goal) - Integer.parseInt(consumed) + Integer.parseInt(burned);
        if (remain < 0) {
            showRemaining = (TextView) findViewById(R.id.tvShowRemaining);
            showRemaining.setTextColor(Color.RED);
        }
        return String.valueOf(remain);
    }

    private void initInstances() {
        toolbar = (Toolbar) findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerLayout,
                R.string.open_drawer,
                R.string.close_drawer  // for blind
        );
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}
