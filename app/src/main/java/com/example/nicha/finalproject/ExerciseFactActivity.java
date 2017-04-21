package com.example.nicha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nicha.finalproject.Service.ActivityDataService;
import com.example.nicha.finalproject.Service.ActivityRecordService;
import com.example.nicha.finalproject.activity.MainActivity;

public class ExerciseFactActivity extends AppCompatActivity {
    TextView tvExerciseName;
    EditText evMin;
    TextView tvCal;
    Button bAdd;
    String exerciseName;
    String calories;
    ActivityDataService voActivityData;
    ActivityRecordService voActivityRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_fact);
        tvExerciseName = (TextView)findViewById(R.id.tvExerciseName);
        evMin = (EditText)findViewById(R.id.evMin);
        tvCal = (TextView) findViewById(R.id.tvCal);
        bAdd =(Button)findViewById(R.id.btnAddExercise);
        exerciseName = getIntent().getStringExtra("exerciseName");
        voActivityData = new ActivityDataService(this);
        voActivityRecord = new ActivityRecordService(this);
        tvExerciseName.setText(exerciseName);
        calories = voActivityData.getCalories(exerciseName);
        tvCal.setText(calories);

        bAdd.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(evMin != null){
                    voActivityRecord.addExercise(exerciseName,Integer.parseInt(calories),Integer.parseInt(evMin.getText().toString()));
                    Intent intent1 = new Intent(ExerciseFactActivity.this,
                            MainActivity.class);
                    startActivity(intent1);
                }
            }
        });

    }
}
