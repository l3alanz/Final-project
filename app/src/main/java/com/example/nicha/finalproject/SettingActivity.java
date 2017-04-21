package com.example.nicha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nicha.finalproject.Model.User;
import com.example.nicha.finalproject.Service.UserService;
import com.example.nicha.finalproject.activity.MainActivity;

import java.util.ArrayList;
import java.util.Set;

public class SettingActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton bMale,bFemale;
    EditText eAge;
    EditText eHeight;
    EditText eWeight;
    Spinner eTarget;
    Spinner eType;
    User userInfo;
    UserService voUser;
    String target;
    String type;
    String gender;
    private ArrayList<String> targetList = new ArrayList<String>();
    private ArrayList<String> typeList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        voUser = new UserService(this);
        eTarget = (Spinner) findViewById(R.id.etGoal);
        eType = (Spinner) findViewById(R.id.spExercise);
        createTargetData();
        createTypeData();
        ArrayAdapter<String> adapterTarget = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, targetList);
        eTarget.setAdapter(adapterTarget);

        ArrayAdapter<String> adapterType = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, typeList);
        eType.setAdapter(adapterType);

        eAge = (EditText) findViewById(R.id.etAge);
        eHeight = (EditText) findViewById(R.id.etHeight);
        eWeight = (EditText) findViewById(R.id.etWeight);
        bMale = (RadioButton) findViewById(R.id.rbtnMale);
        bFemale = (RadioButton) findViewById(R.id.rbtnFemale);
        userInfo = voUser.getData();
        eAge.setText(String.valueOf(userInfo.getAge()));
        eHeight.setText(String.valueOf(userInfo.getHeight()));
        eWeight.setText(String.valueOf(userInfo.getWeight()));
        radioGroup = (RadioGroup)findViewById(R.id.radio);

        // Get Button
        if(userInfo.getGender().equals("male")){
            radioGroup.check(bMale.getId());
        } else if (userInfo.getGender().equals("female")){
            radioGroup.check(bFemale.getId());
        }
        //Get Spinner
        if(userInfo.getTarget().equals("A")){
            eTarget.setSelection(adapterTarget.getPosition("Loose Weight"));
        }
        else if(userInfo.getTarget().equals("B")){
            eTarget.setSelection(adapterTarget.getPosition("Maintain Weight"));
        }
        else if(userInfo.getTarget().equals("C")){
            eTarget.setSelection(adapterTarget.getPosition("Gain Weight"));
        }

        if(userInfo.getActivityType().equals("A")){
            eType.setSelection(adapterType.getPosition("Little or no exercise"));
        }
        else if(userInfo.getActivityType().equals("B")){
            eType.setSelection(adapterType.getPosition("Light exercise"));
        }
        else if(userInfo.getActivityType().equals("C")){
            eType.setSelection(adapterType.getPosition("Regular exercise"));
        }
        else if(userInfo.getActivityType().equals("D")){
            eType.setSelection(adapterType.getPosition("Heavy exercise"));
        }
        else if(userInfo.getActivityType().equals("E")){
            eType.setSelection(adapterType.getPosition("Very heavy exercise"));
        }

        //Set Spinner
        eTarget.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    target = "A";
                }
                else if(position == 1){
                    target = "B";
                }
                else if(position == 2){
                    target = "C";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        eType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    type = "A";
                }
                else if(position == 1){
                    type = "B";
                }
                else if(position == 2){
                    type = "C";
                }
                else if(position == 3){
                    type = "D";
                }
                else if(position == 4){
                    type = "E";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        Button btnNext;
        btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                userInfo.setAge(Integer.valueOf(eAge.getText().toString()));
                userInfo.setWeight(Double.valueOf(eWeight.getText().toString()));
                userInfo.setHeight(Double.valueOf(eHeight.getText().toString()));
                userInfo.setActivityType(type);
                userInfo.setTarget(target);
                if(bMale.isChecked())
                {
                    gender = "male";
                }
                else if(bFemale.isChecked())
                {
                    gender = "female";
                }
                userInfo.setGender(gender);
                voUser.updateData(userInfo);
                Intent intent1 = new Intent(SettingActivity.this,
                        MainActivity.class);
                startActivity(intent1);

            }
        });

    }

    public void createTargetData(){
        targetList.add("Loose Weight");
        targetList.add("Maintain Weight");
        targetList.add("Gain Weight");

    }

    public  void createTypeData(){
        typeList.add("Little or no exercise");
        typeList.add("Light exercise");
        typeList.add("Regular exercise");
        typeList.add("Heavy exercise");
        typeList.add("Very heavy exercise");
    }
}
