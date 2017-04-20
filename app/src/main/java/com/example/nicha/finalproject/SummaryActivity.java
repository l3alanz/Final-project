package com.example.nicha.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.nicha.finalproject.Service.FoodRecordService;

import java.util.List;

public class SummaryActivity extends AppCompatActivity {
    TextView tvShowGoal;
    TextView tvShowBurned;
    TextView tvShowConsumed;
    TextView tvShowRemaining;
    TextView tvShowWater;
    TextView tvShowExercise;
    FoodRecordService poFoodRecordService;
    List<String> summary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        tvShowGoal = (TextView)findViewById(R.id.tvShowGoal);
        tvShowBurned = (TextView)findViewById(R.id.tvShowBurned);
        tvShowConsumed = (TextView)findViewById(R.id.tvShowConsumed);
        tvShowRemaining = (TextView)findViewById(R.id.tvShowRemaining);
        tvShowWater = (TextView)findViewById(R.id.tvShowWater);
        tvShowExercise = (TextView)findViewById(R.id.tvShowExercise);
        poFoodRecordService = new FoodRecordService(this);
        summary = poFoodRecordService.getConsume();
        String consume = clearString(String.valueOf(summary));
        tvShowConsumed.setText(consume);
    }

    public String clearString(String s){
        return s.substring(1, s.length() - 1);
    }
}
