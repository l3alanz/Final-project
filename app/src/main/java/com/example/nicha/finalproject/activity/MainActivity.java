package com.example.nicha.finalproject.activity;

import android.app.ActivityManager;
import android.content.Context;
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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.nicha.finalproject.DailyJournalActivity;
import com.example.nicha.finalproject.DewyActivity;
import com.example.nicha.finalproject.FoodExerciseActivity;
import com.example.nicha.finalproject.Model.Tracking;
import com.example.nicha.finalproject.R;
import com.example.nicha.finalproject.RecommendationActivity;
import com.example.nicha.finalproject.Service.ActivityRecordService;
import com.example.nicha.finalproject.Service.FoodRecordService;
import com.example.nicha.finalproject.Service.MissionSystemService;
import com.example.nicha.finalproject.Service.TrackingProcess;
import com.example.nicha.finalproject.Service.TrackingService;
import com.example.nicha.finalproject.Service.UserService;
import com.example.nicha.finalproject.SettingActivity;
import com.example.nicha.finalproject.TrackingActivity;
import com.example.nicha.finalproject.Service.Database;
import com.facebook.stetho.Stetho;

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
    TextView mission1;
    TextView mission2;
    CheckBox ckMission1;
    CheckBox ckMission2;
    FoodRecordService voFoodRecord;
    UserService voUser;
    ActivityRecordService voActivityRecord;
    TrackingService voTracking;
    MissionSystemService voMissionSystem;
    String goal;
    String burned;
    String consumed;
    String remaining;
    String water;
    String exercise;
    int calTrack;
    List<String> summamry;
    Database mHelper;
    String[] str;
    String[] str2;
    List<String> nameList;
    List<String> typeList;
    String detail1;
    String detail2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelper = new Database(this);
        voFoodRecord = new FoodRecordService(this);
        voUser = new UserService(this);
        voActivityRecord = new ActivityRecordService(this);
        voTracking = new TrackingService(this);
        voTracking.checkData();
        voMissionSystem = new MissionSystemService(this);

        Button btnGoSetting;
        Button btnGoSummary;
        Button btnGoDaily;
        Button btnGoFoodEx;
        Button btnGoTracking;
        Button btnGoRecommendation;
        Button btnGoDewy;
        btnGoSetting = (Button) findViewById(R.id.btnGoSetting);
        btnGoSummary = (Button) findViewById(R.id.btnGoSummary);
        btnGoDaily = (Button) findViewById(R.id.btnGoDaily);
        btnGoFoodEx = (Button) findViewById(R.id.btnGoFoodEx);
        btnGoTracking = (Button) findViewById(R.id.btnGoTracking);
        btnGoRecommendation = (Button) findViewById(R.id.btnGoRecommendation);
        btnGoDewy = (Button) findViewById(R.id.btnGoDewy);


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

                if(isMyServiceRunning(TrackingProcess.class)) {
                    stopService(new Intent(MainActivity.this, TrackingProcess.class));
                }

                Intent intent5 = new Intent(MainActivity.this,
                        TrackingActivity.class);
                startActivity(intent5);

            }
        });

        btnGoDewy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(MainActivity.this,
                        DewyActivity.class);
                startActivity(intent6);

            }
        });

        initInstances();
        int trackNum = voTracking.checkData();
        if(trackNum == 0){
            voTracking.createData();
        }

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
        calFromTrack();
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
        //
        mission1 = (TextView)findViewById(R.id.tvMission1);
        mission2 = (TextView)findViewById(R.id.tvMission2);
        ckMission1 = (CheckBox) findViewById(R.id.cbMission1);
        ckMission2 = (CheckBox) findViewById(R.id.cbMission2);

        if(!isMyServiceRunning(TrackingProcess.class)) {
            startService(new Intent(MainActivity.this, TrackingProcess.class));
        }
        checkCountMission();
        setMission();
        checkCompleteMission();
        Stetho.initializeWithDefaults(this);

    }

    public void checkCompleteMission(){
        String states = voMissionSystem.getState();
        int firstMission = states.charAt(0);
        Log.i("data","here1 " + firstMission);
        int secondMission = states.charAt(1);
        int condition = 0;
        int missionGoal = 0;
        if(firstMission == 48){
            if(str2[0].equals("1")){
                condition = Integer.parseInt(consumed);
                missionGoal = Integer.parseInt(goal) + Integer.parseInt(detail1);
                int subcon = Integer.parseInt(goal)-Integer.parseInt(detail1);
                if(condition < missionGoal && condition > subcon){
                    voMissionSystem.updateState(str[0]);
                    ckMission1.setChecked(true);
                }

            }
            else  if(str2[0].equals("2")){
                condition = Integer.parseInt(water);
                missionGoal = Integer.parseInt(detail1);
                if(condition > missionGoal ){
                    voMissionSystem.updateState(str[0]);
                    ckMission1.setChecked(true);
                }
            }
            else  if(str2[0].equals("3")){
                condition = Integer.parseInt(exercise);
                missionGoal = Integer.parseInt(detail1);
                if(condition > missionGoal ){
                    voMissionSystem.updateState(str[0]);
                    ckMission1.setChecked(true);
                }
            }
            else  if(str2[0].equals("4")){
                condition = Integer.parseInt(burned);
                missionGoal = Integer.parseInt(detail1);
                if(condition > missionGoal ){
                    voMissionSystem.updateState(str[0]);
                    ckMission1.setChecked(true);
                }
            }
        }

        if(secondMission == 48){
            if(str2[1].equals("1")){
                condition = Integer.parseInt(consumed);
                missionGoal = Integer.parseInt(goal) + Integer.parseInt(detail2);
                int subcon = Integer.parseInt(goal)-Integer.parseInt(detail2);
                if(condition < missionGoal && condition > subcon){
                    secondMission =1;
                    voMissionSystem.updateState(str[1]);
                    ckMission2.setChecked(true);
                }

            }
            else  if(str2[1].equals("2")){
                condition = Integer.parseInt(water);
                missionGoal = Integer.parseInt(detail2);
                if(condition > missionGoal ){
                    secondMission =1;
                    voMissionSystem.updateState(str[1]);
                    ckMission2.setChecked(true);
                }
            }
            else  if(str2[1].equals("3")){
                condition = Integer.parseInt(exercise);
                missionGoal = Integer.parseInt(detail2);
                if(condition > missionGoal ){
                    secondMission =1;
                    voMissionSystem.updateState(str[1]);
                    ckMission2.setChecked(true);
                }
            }
            else  if(str2[1].equals("4")){
                condition = Integer.parseInt(burned);
                missionGoal = Integer.parseInt(detail2);
                if(condition > missionGoal ){
                    secondMission =1;
                    voMissionSystem.updateState(str[1]);
                    ckMission2.setChecked(true);
                }
            }
        }
    }

    public void setMission(){
        String states = voMissionSystem.getState();
        int firstMission = states.charAt(0);
        int secondMission = states.charAt(1);
        if(firstMission == 49){
            ckMission1.setChecked(true);
        }
        else{
            ckMission1.setChecked(false);
        }

        if(secondMission == 49){
            ckMission2.setChecked(true);
        }
        else{
            ckMission1.setChecked(false);
        }
        nameList = voMissionSystem.getNames();
        if(nameList != null) {
            String readLine = String.valueOf(nameList);
            str = readLine.split("//, ");
            str[0] = str[0].substring(1, str[0].length() - 1);
            str[1] = str[1].substring(1, str[1].length() - 1);
            detail1 = voMissionSystem.getDetail(str[0]);
            detail2 = voMissionSystem.getDetail(str[1]);
            typeList = voMissionSystem.getMissionType();
            readLine = String.valueOf(typeList);
            Log.i("dataType", String.valueOf(typeList));
            str2 = readLine.split("//, ");
            str2[0] = str2[0].substring(1, str2[0].length() - 1);
            str2[1] = str2[1].substring(1, str2[1].length() - 1);

            String confix1 = "";
            String confix2 = "";
            if(str2[0].equals("1")){
                confix1 = " Kcal";
            }
            else  if(str2[0].equals("2")){
                confix1 = " glasses";
            }
            else  if(str2[0].equals("3")){
                confix1 = " min";
            }
            else  if(str2[0].equals("4")){
                confix1 = " Kcal";
            }

            if(str2[1].equals("1")){
                confix2 = " Kcal";
            }
            else  if(str2[1].equals("2")){
                confix2 = " glasses";
            }
            else  if(str2[1].equals("3")){
                confix2 = " min";
            }
            else  if(str2[1].equals("4")){
                confix2 = " Kcal";
            }

            mission1.setText(str[0]+detail1+confix1);
            mission2.setText(str[1]+detail2+confix2);
        }


    }

    public void checkCountMission(){
        int missionCount = voMissionSystem.getCount();

        if(missionCount == 0) {
            createMission();
        }

    }

    public void createMission(){
        int temp = 0;
        int range = (4 - 1) + 1;

        int counter = 0;
        while (counter < 2){
            int ran = (int) (Math.random() * range) + 1;
            if(ran!= temp){
                voMissionSystem.createMission(ran,consumed);
                counter++;
                temp = ran;
            }
        }

    }

    public void calFromTrack(){
        Tracking track = new Tracking();
        int walk = 0;
        int run = 0;
        int bike = 0;
        track = voTracking.getTrack();

        if(track.getRunningTime() != null) {
            walk = Integer.parseInt(track.getWalkingTime());
        }
        if(track.getWalkingTime() != null) {
            run = Integer.parseInt(track.getRunningTime());
        }
        if(track.getBikingTime() != null) {
        bike = Integer.parseInt(track.getBikingTime());
        }
        calTrack = (walk/60000)*2 + (run/60000)*8 + (bike/60000)*6;
        int preburn = Integer.parseInt(burned) + calTrack;
        burned = String.valueOf(preburn);
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

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
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
