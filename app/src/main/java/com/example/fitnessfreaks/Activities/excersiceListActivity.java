package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.fitnessfreaks.Adapters.excersiceAdapter;
import com.example.fitnessfreaks.DataClasses.excersice;
import com.example.fitnessfreaks.Fragments.descriptionexcersice_fragment;
import com.example.fitnessfreaks.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class excersiceListActivity extends AppCompatActivity implements excersiceAdapter.OnExcersiceListener {

    RecyclerView recyclerView;
    private List<excersice> excersices = new ArrayList<>();
    excersiceAdapter adapter;
    private Uri uri;
    private DatabaseReference mDatabase;
    public List<String> data = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersice_list);

        recyclerView = (RecyclerView)findViewById(R.id.excersiceRecycler);

        final String data1 = getIntent().getStringExtra("type");


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new excersiceAdapter(excersices,this);
        recyclerView.setAdapter(adapter);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        excersicedata();

    }

    private void excersicedata(){
        final String data1 = getIntent().getStringExtra("type");
DatabaseReference excersiceData = mDatabase.child("exercises").child(data1);
Log.d("database","starting");
    excersiceData.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            Log.d("database","inside");
            for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                data.add(snapshot.getKey());
                Log.e("database","inside1");
                Map<String , String> postMap = (Map<String, String>)snapshot.getValue();
                String name = postMap.get("WorkoutName");
                Log.d("database",name);
                String id = postMap.get("id");
                String image = postMap.get("WorkoutImage1");
                
                excersice excersice = new excersice(name,id);
                excersices.add(excersice);
recyclerView.setAdapter(adapter);

            };
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });


    }

    @Override
    public void onExcersiceClick(int position) {
      String hihi =  excersices.get(position).toString();
        final excersice model = excersices.get(position);
        Intent intent = new Intent(this,CheckEexcersiceActivity.class);
        intent.putExtra("id",model.getId());
        final String data1 = getIntent().getStringExtra("type");
        Bundle bundle = new Bundle();
        bundle.putString("id",model.getId());
        bundle.putString("type",data1);
        descriptionexcersice_fragment fragobj = new descriptionexcersice_fragment();
        fragobj.setArguments(bundle);
        intent.putExtra("type",data1);
        startActivity(intent) ;
    }
}
