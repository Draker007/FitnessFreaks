package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.fitnessfreaks.Adapters.DESadapter;
import com.example.fitnessfreaks.DataClasses.excersice;
import com.example.fitnessfreaks.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class dayExcersiceSet extends AppCompatActivity implements DESadapter.OnDESListener{
    String TAG = "draker";
    RecyclerView recyclerView;
    private List<excersice> excersices = new ArrayList<>();
    DESadapter adapter ;
    private DatabaseReference mdatabase;
    ProgressBar progressBar;
    private  List<String> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_excersice_set);
        recyclerView = (RecyclerView)findViewById(R.id.DESrecycler);
        progressBar = findViewById(R.id.DESProgress);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DESadapter(excersices,this);
        recyclerView.setAdapter(adapter);
        mdatabase = FirebaseDatabase.getInstance().getReference();
        setData();
    }
    private void setData(){
        final String sex = getIntent().getStringExtra("sex");
        final String name = getIntent().getStringExtra("name");
        final String day = getIntent().getStringExtra("day");
        final DatabaseReference databaseReference = mdatabase.child("ExcersiceSets").child(sex).child(name).child(day);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren() ) {
                    String id = snapshot.getKey();
                    String id1 = "id";
                    Log.e(TAG, "onDataChange: "+id);
                    if (id.equals(id1)) {
                        continue;
                    }else {

                        Map<String, String> map = (Map<String, String>) snapshot.getValue();
                        String name1 = map.get("name");
                        String image = map.get("Image");
                        //String id = map.get("id");
                        excersice excersice = new excersice(image, name1, id);
                        excersices.add(excersice);
                        recyclerView.setAdapter(adapter);


                    }
                }
                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }

    @Override
    public void onDESClick(int position) {
    final excersice model = excersices.get(position);
        Intent intent = new Intent(this,ExcersiceMain.class);
        String sex = getIntent().getStringExtra("sex");
        String name = getIntent().getStringExtra("name");
        String id = model.getId();
        intent.putExtra("sex",sex);
        intent.putExtra("name",name);
        intent.putExtra("id",id);
        String day = getIntent().getStringExtra("day");
        Log.e("draker", "onClick: "+day);
        intent.putExtra("day",day);
        Log.e(TAG, "onDESClick: "+sex+id+name);
        startActivity(intent);
    }
}
