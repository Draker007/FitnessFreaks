package com.example.fitnessfreaks.Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fitnessfreaks.Adapters.NutritionAdapter;
import com.example.fitnessfreaks.DataClasses.NutritionList;
import com.example.fitnessfreaks.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        mDatabase = FirebaseDatabase.getInstance().getReference();
        NutritionData();
    }
    private void NutritionData(){
        final DatabaseReference databaseReference = mDatabase.child("Nutrition");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot db : dataSnapshot.getChildren()){
                    Map<String,String> map = (Map<String, String>) db.getValue();
                    String name = db.getKey();
                    String cal = map.get("Calories");
                    String protien = map.get("Protein");
                    String carbs = map.get("carbs");
                    String fat = map.get("fat");
                    NutritionList nutritionList = new NutritionList(name,protien,fat,carbs);
                    nutritionLists.add(nutritionList);
                    recyclerView.setAdapter(adapter);
                }


        }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }});


    }
}
