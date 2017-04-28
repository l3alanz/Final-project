package com.example.nicha.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.nicha.finalproject.Service.RecommendationService;

public class RecommendationActivity extends AppCompatActivity {
    TextView tvBreakfast1;
    TextView tvBreakfast2;
    TextView tvLunch1;
    TextView tvLunch2;
    TextView tvDinner1;
    TextView tvDinner2;
    RecommendationService voRecommendation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);
        voRecommendation = new RecommendationService(this);
        tvBreakfast1 = (TextView) findViewById(R.id.tvRecBreakfast1);
        tvBreakfast2 = (TextView) findViewById(R.id.tvRecBreakfast2);
        tvLunch1 = (TextView) findViewById(R.id.tvRecLunch1);
        tvLunch2 = (TextView)findViewById(R.id.tvRecLunch2);
        tvDinner1 = (TextView) findViewById(R.id.tvRecDinner1);
        tvDinner2 = (TextView) findViewById(R.id.tvRecDinner2);
        tvBreakfast1.setText(voRecommendation.getBreakfast());
        tvBreakfast2.setText(voRecommendation.getBreakfast());
        tvLunch1.setText(voRecommendation.getLunch());
        tvLunch2.setText(voRecommendation.getLunch());
        tvDinner1.setText(voRecommendation.getDinner());
        tvDinner2.setText(voRecommendation.getDinner());
    }
}
