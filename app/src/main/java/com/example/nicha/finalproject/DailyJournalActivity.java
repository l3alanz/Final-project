package com.example.nicha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.nicha.finalproject.R.id.btnFood;

import com.example.nicha.finalproject.Service.ActivityRecordService;
import com.example.nicha.finalproject.Service.FoodRecordService;
import com.example.nicha.finalproject.activity.MainActivity;

import java.util.List;

public class DailyJournalActivity extends AppCompatActivity {
    TextView tvShowCarb;
    TextView tvShowFat;
    TextView tvShowProtein;
    TextView tvBreakfast;
    TextView tvLunch;
    TextView tvDinner;
    TextView tvExercise;
    FoodRecordService voFoodRecord;
    ActivityRecordService voActivityRecord;
    List<String> mealList;
    List<String> exerciseList;
    String[] str;
    RelativeLayout breakfastLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_journal);

        ImageButton btnAddBreakfast;
        ImageButton btnAddLunch;
        ImageButton btnAddDinner;
        ImageButton btnAddExercise;

        voFoodRecord = new FoodRecordService(this);
        voActivityRecord = new ActivityRecordService(this);

        btnAddBreakfast = (ImageButton) findViewById(R.id.btnAddBreakfast);
        btnAddLunch = (ImageButton) findViewById(R.id.btnAddLunch);
        btnAddDinner = (ImageButton) findViewById(R.id.btnAddDinner);
        btnAddExercise = (ImageButton) findViewById(R.id.btnAddExercise);
        tvShowCarb = (TextView) findViewById(R.id.tvShowCarb);
        tvShowFat = (TextView)findViewById(R.id.tvShowFat);
        tvShowProtein = (TextView) findViewById(R.id.tvShowProtein);
        tvBreakfast = (TextView)findViewById(R.id.tvShowBreakfast);
        tvLunch = (TextView)findViewById(R.id.tvShowLunch);
        tvDinner = (TextView)findViewById(R.id.tvShowDinner);
        breakfastLayout = (RelativeLayout) findViewById(R.id.rltBreakfast) ;
        tvExercise = (TextView) findViewById(R.id.tvShowExercise);
        String carb = voFoodRecord.getCarb();
        if(carb == null)
            carb = "0";
        String fat = voFoodRecord.getFat();
        if(fat == null)
            fat = "0";
        String protein = voFoodRecord.getProtein();
        if(protein == null)
            protein = "0";
        tvShowCarb.setText(carb+" g.");
        tvShowFat.setText(fat+" g.");
        tvShowProtein.setText(protein+" g.");
        getMealList("Breakfast");
        getMealList("Lunch");
        getMealList("Dinner");
        getExerciseList();



        btnAddBreakfast.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DailyJournalActivity.this,
                        SearchFoodActivity.class);
                startActivity(intent1);

            }
        });

        btnAddLunch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(DailyJournalActivity.this,
                        SearchFoodActivity.class);
                startActivity(intent2);

            }
        });

        btnAddDinner.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(DailyJournalActivity.this,
                        SearchFoodActivity.class);
                startActivity(intent3);

            }
        });

        btnAddExercise.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(DailyJournalActivity.this,
                        SearchExerciseActivity.class);
                startActivity(intent4);

            }
        });

    }
    public void getMealList(String meal){
        mealList = voFoodRecord.getMealList(meal);
        TextView mealListTV = new TextView(this);
        if(meal.equals("Breakfast")){
            mealListTV = tvBreakfast;
        } else if(meal.equals("Lunch")){
            mealListTV = tvLunch;
        } else if(meal.equals("Dinner")){
            mealListTV = tvDinner;

        }

        if(mealList != null){
            String readLine = String.valueOf(mealList);
            str = readLine.split("//,");


            for (int i = 0; i < mealList.size(); i++) {
                String old = mealListTV.getText().toString();
                if(old.equals("showing food which is selected")){
                    old = "";
                }
                String newtext = old+str[i]+"\n"; // can manipulate using substring also

                mealListTV.setText(newtext);
            }
        }
    }

    public void getExerciseList(){
        exerciseList = voActivityRecord.getExerciseList();

        if(exerciseList != null){
            String readLine = String.valueOf(exerciseList);
            str = readLine.split("//,");


            for (int i = 0; i < exerciseList.size(); i++) {
                String old = tvExercise.getText().toString();
                if(old.equals("showing food which is selected")){
                    old = "";
                }
                String newtext = old+str[i]+"\n"; // can manipulate using substring also

                tvExercise.setText(newtext);
            }
        }
    }
}
