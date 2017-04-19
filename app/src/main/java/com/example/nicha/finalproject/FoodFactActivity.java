package com.example.nicha.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.nicha.finalproject.Service.FoodDataService;

import java.util.List;

public class FoodFactActivity extends AppCompatActivity {

    FoodDataService poFoodDataService;
    List<String> food;
    TextView tvFoodName;
    TextView tvCalories;
    TextView tvTotalFat;
    TextView tvSaturatedFat;
    TextView tvMonoSaturatedFat;
    TextView tvPolySaturatedFat;
    TextView tvTransFat;
    TextView tvCholesterol;
    TextView tvSodium;
    TextView tvPotassium;
    TextView tvTotalCarb;
    TextView tvDietaryFiber;
    TextView tvSugars;
    TextView tvProtein;
    TextView tvVitaminA;
    TextView tvVitaminC;
    TextView tvCalcium;
    TextView tvIron;
    TextView tvVitaminD;
    TextView tvVitaminB6;
    TextView tvVitaminB12;
    TextView tvMagnesium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_fact);
        String foodReceiver = getIntent().getStringExtra("foodName");
        tvFoodName = (TextView)findViewById(R.id.tvFoodName);
        tvFoodName.setText(foodReceiver);
        poFoodDataService = new FoodDataService(this);
        food = poFoodDataService.getFood(foodReceiver);
        String readLine = String.valueOf(food);
        String[] str = readLine.split("//,");
        tvCalories = (TextView)findViewById(R.id.tvCalories);
        tvTotalFat = (TextView)findViewById(R.id.tvTotalFat);
        tvSaturatedFat = (TextView)findViewById(R.id.tvSaturatedFat);
        tvMonoSaturatedFat = (TextView)findViewById(R.id.tvMonoSaturatedFat);
        tvPolySaturatedFat = (TextView)findViewById(R.id.tvPolySaturatedFat);
        tvTransFat = (TextView)findViewById(R.id.tvTransFat);
        tvCholesterol = (TextView)findViewById(R.id.tvCholesterol);
        tvSodium = (TextView)findViewById(R.id.tvSodium);
        tvPotassium = (TextView)findViewById(R.id.tvPotassium);
        tvTotalCarb = (TextView)findViewById(R.id.tvTotalCarb);
        tvDietaryFiber = (TextView)findViewById(R.id.tvDietaryFiber);
        tvSugars = (TextView)findViewById(R.id.tvSugars);
        tvProtein = (TextView)findViewById(R.id.tvProtein);
        tvVitaminA = (TextView)findViewById(R.id.tvVitaminA);
        tvVitaminC = (TextView)findViewById(R.id.tvVitaminC);
        tvCalcium = (TextView)findViewById(R.id.tvCalcium);
        tvIron = (TextView)findViewById(R.id.tvIron);
        tvVitaminD = (TextView)findViewById(R.id.tvVitaminD);
        tvVitaminB6 = (TextView)findViewById(R.id.tvVitaminB6);
        tvVitaminB12 = (TextView)findViewById(R.id.tvVitaminB12);
        tvMagnesium = (TextView)findViewById(R.id.tvMagnesium);

        tvCalories.setText(str[3]+" Kcal");
        tvTotalFat.setText(str[5]+ " g.");
        tvSaturatedFat.setText(str[7] + " g.");
        tvMonoSaturatedFat.setText(str[9] + " g.");
        tvPolySaturatedFat.setText(str[10] + " g.");
        tvTransFat.setText(str[11] + " g.");
        tvCholesterol.setText(str[12] + " mg.");
        tvSodium.setText(str[14]  + " mg.");
        tvPotassium.setText(str[16]  + " mg.");
        tvTotalCarb.setText(str[18] + " g.");
        tvDietaryFiber.setText(str[20] + " g.");
        tvSugars.setText(str[22] + " g.");
        tvProtein.setText(str[23] + " g.");
        tvVitaminA.setText(str[25] + "%");
        tvVitaminC.setText(str[26] + "%");
        tvCalcium.setText(str[27] + "%");
        tvIron.setText(str[28] + "%");
        tvVitaminD.setText(str[29] + "%");
        tvVitaminB6.setText(str[30] + "%");
        tvVitaminB12.setText(str[31] + "%");
        str[32] = str[32].substring(0, str[32].length() - 1);
        tvMagnesium.setText(str[32]);


    }
}
