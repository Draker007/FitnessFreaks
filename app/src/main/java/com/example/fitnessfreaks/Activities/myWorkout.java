package com.example.fitnessfreaks.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.fitnessfreaks.Adapters.WeekAdapter;
import com.example.fitnessfreaks.DataClasses.weekNo;
import com.example.fitnessfreaks.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class myWorkout extends AppCompatActivity implements WeekAdapter.onWeekListner {
    RecyclerView recyclerView;
    private List<weekNo> weekNos = new ArrayList<>();
    WeekAdapter adapter;
    private DatabaseReference mDatabase;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_workout);
        recyclerView = (RecyclerView)findViewById(R.id.weekRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new WeekAdapter(weekNos,this);
        recyclerView.setAdapter(adapter);
        progressBar = findViewById(R.id.EMProgress);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        progressBar.setVisibility(View.INVISIBLE);
        weekData();


    }

    private void weekData(){}

    @Override
    public void OnWeekClick(int position) {


    }
}
