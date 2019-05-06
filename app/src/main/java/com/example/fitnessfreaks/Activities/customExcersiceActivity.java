package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fitnessfreaks.Adapters.customExcersiceAdapter;
import com.example.fitnessfreaks.DataClasses.excersicesCustom;
import com.example.fitnessfreaks.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class customExcersiceActivity extends AppCompatActivity implements customExcersiceAdapter.onCustomExcersiceListner{

    RecyclerView recyclerView;
    private List<excersicesCustom> excersicesCustomList = new ArrayList<>();
    customExcersiceAdapter adapter;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_excersice);
        recyclerView = (RecyclerView)findViewById(R.id.customExcersiceRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new customExcersiceAdapter(excersicesCustomList,this);
        recyclerView.setAdapter(adapter);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        customExcersiceData();
    }
    private  void customExcersiceData(){
    final String sex = getIntent().getStringExtra("sex");
    DatabaseReference setData = mDatabase.child("ExcersiceSets").child(sex);
    setData.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                Map<String,String> postMap = (Map<String, String>)snapshot.getValue();
                String name = postMap.get("name");
                excersicesCustom excersicesCustom = new excersicesCustom(name);
                excersicesCustomList.add(excersicesCustom);
                recyclerView.setAdapter(adapter);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    }

    @Override
    public void OnCustomExcersiceClick(int position) {
        final excersicesCustom model = excersicesCustomList.get(position);
        Intent intent = new Intent(this,ExcersiceSetDescActivity.class);
        intent.putExtra("name",model.getName());
        String sex = getIntent().getStringExtra("sex");
        intent.putExtra("sex",sex);
        startActivity(intent);
    }
}
