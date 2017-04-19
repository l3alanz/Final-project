package com.example.nicha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static com.example.nicha.finalproject.R.id.btnFood;

import com.example.nicha.finalproject.activity.MainActivity;

public class DailyJournalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_journal);

        ImageButton btnAddBreakfast;
        ImageButton btnAddLunch;
        ImageButton btnAddDinner;
        ImageButton btnAddExercise;
/*
        btnAddBreakfast = (ImageButton) findViewById(R.id.btnAddBreakfast);
        btnAddLunch = (ImageButton) findViewById(R.id.btnAddLunch);
        btnAddDinner = (ImageButton) findViewById(R.id.btnAddDinner);
        btnAddExercise = (ImageButton) findViewById(R.id.btnAddExercise);

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
*/
    }
}
