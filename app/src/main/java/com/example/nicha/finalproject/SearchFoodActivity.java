package com.example.nicha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;


import com.example.nicha.finalproject.Service.FoodDataService;

import java.util.List;

public class SearchFoodActivity extends AppCompatActivity {

    SearchView searchFood;
    ListView foodListView;
    FoodDataService poFoodDataService;
    List<String> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_food);
        Intent intent = getIntent();
        searchFood = (SearchView)findViewById(R.id.svSearchFood);
        foodListView = (ListView)findViewById(R.id.tvFood);
        poFoodDataService = new FoodDataService(this);
        firstSearch();
        searchFood.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                query = searchFood.getQuery().toString();
                if (searchFood.getQuery().length() == 0) {
                    foodList = poFoodDataService.getFoodDefaultList();
                }
                else{
                    foodList = poFoodDataService.getFoodDataList(query);
                }
                ArrayAdapter<String> adapterDir =
                        new ArrayAdapter<String>(getApplicationContext()
                                , android.R.layout.simple_list_item_1, foodList);
                foodListView.setAdapter(adapterDir);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = searchFood.getQuery().toString();
                if (searchFood.getQuery().length() == 0) {
                    foodList = poFoodDataService.getFoodDefaultList();
                }
                else{
                    foodList = poFoodDataService.getFoodDataList(newText);
                }
                ArrayAdapter<String> adapterDir =
                        new ArrayAdapter<String>(getApplicationContext()
                                , android.R.layout.simple_list_item_1, foodList);
                foodListView.setAdapter(adapterDir);
                return true;
            }
        });
       selectData();

    }

    public void firstSearch(){
        foodList = poFoodDataService.getFoodDefaultList();
        ArrayAdapter<String> adapterDir =
                new ArrayAdapter<String>(getApplicationContext()
                        , android.R.layout.simple_list_item_1, foodList);
        foodListView.setAdapter(adapterDir);
    }

    public void selectData(){
        foodListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        foodListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                    Object item = parent.getItemAtPosition(position);
                    String label = item.toString();
                    searchFood.setQuery(label,false);
                    Intent intent = new Intent(getBaseContext(), FoodFactActivity.class);
                      intent.putExtra("foodName", label);
                    foodListView.clearFocus();
                     startActivity(intent);
                }
            }
        );
    }
}
