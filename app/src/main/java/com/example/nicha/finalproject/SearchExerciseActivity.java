package com.example.nicha.finalproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nicha.finalproject.Service.ActivityDataService;
import com.example.nicha.finalproject.Service.Database;

import java.util.List;
import java.util.Objects;

public class SearchExerciseActivity extends AppCompatActivity {

    SearchView searchExercise;
    ListView exerciseListView;
    ActivityDataService poActivityDataService;
    List<String> exerciseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_exercise);
        searchExercise = (SearchView)findViewById(R.id.svSearchExercise);
        exerciseListView = (ListView)findViewById(R.id.tvEx);
        poActivityDataService = new ActivityDataService(this);
        firstSearch();
        searchExercise.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                query = searchExercise.getQuery().toString();
                if (searchExercise.getQuery().length() == 0) {
                    exerciseList = poActivityDataService.getActivityDefaultList();
                }
                else{
                    exerciseList = poActivityDataService.getActivityDataList(query);
                }
                ArrayAdapter<String> adapterDir =
                        new ArrayAdapter<String>(getApplicationContext()
                                , android.R.layout.simple_list_item_1, exerciseList);
                exerciseListView.setAdapter(adapterDir);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = searchExercise.getQuery().toString();
                if (searchExercise.getQuery().length() == 0) {
                    exerciseList = poActivityDataService.getActivityDefaultList();
                }
                else{
                    exerciseList = poActivityDataService.getActivityDataList(newText);
                }
                ArrayAdapter<String> adapterDir =
                        new ArrayAdapter<String>(getApplicationContext()
                                , android.R.layout.simple_list_item_1, exerciseList);
                exerciseListView.setAdapter(adapterDir);
                return true;
            }
        });
        //selectData();
    }

    public void firstSearch(){
        exerciseList = poActivityDataService.getActivityDefaultList();
        ArrayAdapter<String> adapterDir =
                new ArrayAdapter<String>(getApplicationContext()
                        , android.R.layout.simple_list_item_1, exerciseList);
        exerciseListView.setAdapter(adapterDir);
    }

    public void selectData(){
        exerciseListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        exerciseListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                    Object item = parent.getItemAtPosition(position);
                    String label = item.toString();
                    //searchExercise.setQuery(label,false);
                    /*Intent intent = new Intent(getBaseContext(), SignoutActivity.class);
                    intent.putExtra("exerciseName", label);
                    startActivity(intent);
                    */
                }
            }
        );
    }

    @Override
    protected void onPause(){
        super.onPause();
    }
}
