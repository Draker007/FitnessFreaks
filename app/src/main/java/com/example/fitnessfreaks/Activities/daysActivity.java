package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.fitnessfreaks.R;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
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
    String id1 = "false";
    private AdView mAdView;
    ConstraintLayout set, bmi, list, nutchart, home;
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
        set = (ConstraintLayout)findViewById(R.id.DSets);
        list = (ConstraintLayout)findViewById(R.id.DList);
        nutchart = (ConstraintLayout)findViewById(R.id.DCharts);
        bmi = (ConstraintLayout)findViewById(R.id.Dbmi);
        home = (ConstraintLayout)findViewById(R.id.Dhome);
    MobileAds.initialize(this,"ca-app-pub-9245993672547749/9806507648");
        mAdView=(AdView) findViewById(R.id.BannerAd1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
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
                        Map<String,String> post = (Map<String, String>)dataSnapshot.getValue();
                        String id = post.get("id");
                        Log.e(TAG, "onDataChange:"+id);

                        if (id .equals(id1)){
                            Log.e(TAG, "onDataChange: onPoint");
                            startActivity(new Intent(daysActivity.this, dayoffActivity.class));
                        }else{
                            Intent intent = new Intent(daysActivity.this, dayExcersiceSet.class);
                            intent.putExtra("sex",sex);
                            intent.putExtra("name",name);
                            intent.putExtra("day","Monday");
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(daysActivity.this,excersiceSetActivity.class));
            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(daysActivity.this,frontPageActivity.class));
            }
        });
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(daysActivity.this, BMIActivity.class));
            }
        });
        nutchart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(daysActivity.this,nutritionActivity.class));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(daysActivity.this,MainActivity.class));
            }
        });
        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = mDatabase.child("ExcersiceSets").child(sex).child(name).child("Monday");
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Map<String,String> post = (Map<String, String>)dataSnapshot.getValue();
                        String id = post.get("id");
                        Log.e(TAG, "onDataChange:"+id);

                        if (id .equals(id1)){
                            Log.e(TAG, "onDataChange: onPoint");
                            startActivity(new Intent(daysActivity.this, dayoffActivity.class));
                        }else{
                            Intent intent = new Intent(daysActivity.this, dayExcersiceSet.class);
                            intent.putExtra("sex",sex);
                            intent.putExtra("name",name);
                            intent.putExtra("day","Monday");
                            startActivity(intent);
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
                        Map<String,String> post = (Map<String, String>)dataSnapshot.getValue();
                        String id = post.get("id");
                        Log.e(TAG, "onDataChange:"+id);

                        if (id .equals(id1)){
                            Log.e(TAG, "onDataChange: onPoint");
                            startActivity(new Intent(daysActivity.this, dayoffActivity.class));
                        }else{
                            Intent intent = new Intent(daysActivity.this, dayExcersiceSet.class);
                            intent.putExtra("sex",sex);
                            intent.putExtra("name",name);
                            intent.putExtra("day","Tuesday");
                            startActivity(intent);
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
                        Map<String,String> post = (Map<String, String>)dataSnapshot.getValue();
                        String id = post.get("id");
                        Log.e(TAG, "onDataChange:"+id);

                        if (id .equals(id1)){
                            Log.e(TAG, "onDataChange: onPoint");
                            startActivity(new Intent(daysActivity.this, dayoffActivity.class));
                        }else{
                            Intent intent = new Intent(daysActivity.this, dayExcersiceSet.class);
                            intent.putExtra("sex",sex);
                            intent.putExtra("name",name);
                            intent.putExtra("day","Wednesday");
                            startActivity(intent);
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
                        Map<String,String> post = (Map<String, String>)dataSnapshot.getValue();
                        String id = post.get("id");
                        Log.e(TAG, "onDataChange:"+id);
                        if (id .equals(id1)){
                            Log.e(TAG, "onDataChange: onPoint");
                            startActivity(new Intent(daysActivity.this, dayoffActivity.class));
                        }else{
                            Intent intent = new Intent(daysActivity.this, dayExcersiceSet.class);
                            intent.putExtra("sex",sex);
                            intent.putExtra("name",name);
                            intent.putExtra("day","Thursday");
                            startActivity(intent);
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
                        Map<String,String> post = (Map<String, String>)dataSnapshot.getValue();
                        String id = post.get("id");
                        Log.e(TAG, "onDataChange:"+id);

                        if (id .equals(id1)){
                            Log.e(TAG, "onDataChange: onPoint");
                            startActivity(new Intent(daysActivity.this, dayoffActivity.class));
                        }else{
                            Intent intent = new Intent(daysActivity.this, dayExcersiceSet.class);
                            intent.putExtra("sex",sex);
                            intent.putExtra("name",name);
                            intent.putExtra("day","Friday");
                            startActivity(intent);
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
                        Map<String,String> post = (Map<String, String>)dataSnapshot.getValue();
                        String id = post.get("id");
                        Log.e(TAG, "onDataChange:"+id);

                        if (id.equals(id1)){
                            Log.e(TAG, "onDataChange: onPoint");
                            startActivity(new Intent(daysActivity.this, dayoffActivity.class));
                        }else{
                            Intent intent = new Intent(daysActivity.this, dayExcersiceSet.class);
                            intent.putExtra("sex",sex);
                            intent.putExtra("name",name);
                            intent.putExtra("day","Saturday");
                            startActivity(intent);
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
