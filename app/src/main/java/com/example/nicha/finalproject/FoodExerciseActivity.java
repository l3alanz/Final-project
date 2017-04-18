package com.example.nicha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FoodExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_exercise);

        Button btnExercise;
        Button btnFood;
        btnFood = (Button) findViewById(R.id.btnFood);
        btnExercise = (Button) findViewById(R.id.btnExercise);

        btnExercise.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FoodExerciseActivity.this,
                        SearchExerciseActivity.class);
                startActivity(intent1);

            }
        });

        btnFood.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(FoodExerciseActivity.this,
                        SearchFoodActivity.class);
                startActivity(intent2);

            }
        });


    }
}
