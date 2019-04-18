package com.example.fitnessfreaks.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fitnessfreaks.Adapters.NutritionAdapter;
import com.example.fitnessfreaks.DataClasses.NutritionList;
import com.example.fitnessfreaks.R;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class nutritionActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NutritionAdapter adapter;
    private List<NutritionList> nutritionLists = new ArrayList<>();
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);
        recyclerView = (RecyclerView)findViewById(R.id.nutritionRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NutritionAdapter(nutritionLists);
        recyclerView.setAdapter(adapter);
        NutritionData();
    }
    private void NutritionData(){

        //Todo: data comes here for nutrition

    }
}
