package com.example.fitnessfreaks.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fitnessfreaks.Adapters.excersiceAdapter;
import com.example.fitnessfreaks.DataClasses.excersice;
import com.example.fitnessfreaks.R;

import java.util.ArrayList;
import java.util.List;

public class excersiceListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<excersice> excersices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersice_list);

        recyclerView = (RecyclerView)findViewById(R.id.excersiceRecycler);

        excersices = new ArrayList<>();
        excersices.add(new excersice("asdasdasd","Barbel"));
        excersices.add(new excersice("asdasdasd","dumbels"));
        excersices.add(new excersice("asdasdasd","dole"));
        excersices.add(new excersice("asdasdasd","Big arms"));
        excersices.add(new excersice("asdasdasd","bade dole"));

recyclerView.setLayoutManager(new LinearLayoutManager(excersiceListActivity.this));
recyclerView.setAdapter(new excersiceAdapter(excersiceListActivity.this,excersices));

    }
}
