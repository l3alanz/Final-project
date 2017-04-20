package com.example.nicha.finalproject.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.nicha.finalproject.DailyJournalActivity;
import com.example.nicha.finalproject.FoodExerciseActivity;
import com.example.nicha.finalproject.R;
import com.example.nicha.finalproject.RecommendationActivity;
import com.example.nicha.finalproject.SettingActivity;
import com.example.nicha.finalproject.TrackingActivity;
import com.example.nicha.finalproject.Service.Database;


public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle; // Hamburger button
    Toolbar toolbar;
    SQLiteDatabase mDb;
    Database mHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
