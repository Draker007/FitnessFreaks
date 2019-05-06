package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.fitnessfreaks.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class daysActivity extends AppCompatActivity {
    ConstraintLayout sun,mon,tue,wed,thurs,fri,sat;
    DatabaseReference mDatabase;
    String TAG = "Draker";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);
        sun=(ConstraintLayout)findViewById(R.id.Sunday);
        mon=(ConstraintLayout)findViewById(R.id.Monday);
        tue=(ConstraintLayout)findViewById(R.id.Tuesday);
        wed=(ConstraintLayout)findViewById(R.id.Wednesday);
        thurs=(ConstraintLayout)findViewById(R.id.Thursday);
        fri = (ConstraintLayout)findViewById(R.id.Friday);
        sat=(ConstraintLayout)findViewById(R.id.Saturday);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        final String name = getIntent().getStringExtra("name");
        final String sex = getIntent().getStringExtra("sex");
        sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = mDatabase.child("ExcersiceSets").child(sex).child(name).child("Sunday");
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Map<String,Boolean> post = (Map<String, Boolean>)dataSnapshot.getValue();
                        Boolean id = post.get("id");
                        Log.e(TAG, "onDataChange:"+id);
                        String id1 = "0";
                        if (id == false){
                            Log.e(TAG, "onDataChange: onPoint");
                            startActivity(new Intent(daysActivity.this, dayoffActivity.class));
                        }else{
                            startActivity(new Intent(daysActivity.this, dayExcersiceSet.class));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = mDatabase.child("ExcersiceSets").child(sex).child(name).child("Monday");
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Map<String,Boolean> post = (Map<String, Boolean>)dataSnapshot.getValue();
                        Boolean id = post.get("id");
                        Log.e(TAG, "onDataChange:"+id);
                        String id1 = "0";
                        if (id == false){
                            Log.e(TAG, "onDataChange: onPoint");
                            startActivity(new Intent(daysActivity.this, dayoffActivity.class));
                        }else{
                            startActivity(new Intent(daysActivity.this, dayExcersiceSet.class));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        tue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = mDatabase.child("ExcersiceSets").child(sex).child(name).child("Tuesday");
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Map<String,Boolean> post = (Map<String, Boolean>)dataSnapshot.getValue();
                        Boolean id = post.get("id");
                        Log.e(TAG, "onDataChange:"+id);
                        String id1 = "0";
                        if (id == false){
                            Log.e(TAG, "onDataChange: onPoint");
                            startActivity(new Intent(daysActivity.this, dayoffActivity.class));
                        }else{
                            startActivity(new Intent(daysActivity.this, dayExcersiceSet.class));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = mDatabase.child("ExcersiceSets").child(sex).child(name).child("Wednesday");
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Map<String,Boolean> post = (Map<String, Boolean>)dataSnapshot.getValue();
                        Boolean id = post.get("id");
                        Log.e(TAG, "onDataChange:"+id);
                        String id1 = "0";
                        if (id == false){
                            Log.e(TAG, "onDataChange: onPoint");
                            startActivity(new Intent(daysActivity.this, dayoffActivity.class));
                        }else{
                            startActivity(new Intent(daysActivity.this, dayExcersiceSet.class));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        thurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = mDatabase.child("ExcersiceSets").child(sex).child(name).child("Thursday");
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Map<String,Boolean> post = (Map<String, Boolean>)dataSnapshot.getValue();
                        Boolean id = post.get("id");
                        Log.e(TAG, "onDataChange:"+id);
                        String id1 = "0";
                        if (id == false){
                            Log.e(TAG, "onDataChange: onPoint");
                            startActivity(new Intent(daysActivity.this, dayoffActivity.class));
                        }else{
                            startActivity(new Intent(daysActivity.this, dayExcersiceSet.class));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = mDatabase.child("ExcersiceSets").child(sex).child(name).child("Friday");
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Map<String,Boolean> post = (Map<String, Boolean>)dataSnapshot.getValue();
                        Boolean id = post.get("id");
                        Log.e(TAG, "onDataChange:"+id);
                        String id1 = "0";
                        if (id == false){
                            Log.e(TAG, "onDataChange: onPoint");
                            startActivity(new Intent(daysActivity.this, dayoffActivity.class));
                        }else{
                            startActivity(new Intent(daysActivity.this, dayExcersiceSet.class));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = mDatabase.child("ExcersiceSets").child(sex).child(name).child("Saturday");
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Map<String,Boolean> post = (Map<String, Boolean>)dataSnapshot.getValue();
                        Boolean id = post.get("id");
                        Log.e(TAG, "onDataChange:"+id);
                        String id1 = "0";
                        if (id == false){
                            Log.e(TAG, "onDataChange: onPoint");
                            startActivity(new Intent(daysActivity.this, dayoffActivity.class));
                        }else{
                            startActivity(new Intent(daysActivity.this, dayExcersiceSet.class));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
