package com.example.fitnessfreaks.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.fitnessfreaks.Adapters.checkExcersiceAdapter;
import com.example.fitnessfreaks.Fragments.Em1stFragment;
import com.example.fitnessfreaks.Fragments.Em2ndFragment;
import com.example.fitnessfreaks.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class ExcersiceMain extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private checkExcersiceAdapter adapter;
    ConstraintLayout set, bmi, list, nutchart, home;
    TextView excersiceName;
    DatabaseReference databaseReference , db;
    ProgressBar progressBar;
    String TAG = "draker";
    String id,sex,name,day,status;
    Button btngonxt , btnBack , startEx;
    DatabaseReference mDatabase;
    Dialog dialog;
    ImageView popimage;
     int i = 20;

    public String getid(){
         id = getIntent().getStringExtra("id");
        return id;
    }
    public String getSex(){
         sex = getIntent().getStringExtra("sex");
        return sex;
    }
    public String getname(){
         name = getIntent().getStringExtra("name");
        return name;
    }
    public String getday(){
         day = getIntent().getStringExtra("day");
        return day;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersice_main);
        progressBar = (ProgressBar)findViewById(R.id.EMProgress);
        Initialse();
       databaseLinking();
       setonclicklistner();

//        startEx.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Showpopup();
//            }
//        });

        btngonxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "true";
                if (status.equals(str)){
                Intent intent = new Intent(ExcersiceMain.this,ExcersiceMain.class);
                intent.putExtra("sex",sex);
                Integer id1 = Integer.valueOf(id);
                id1++;
                intent.putExtra("id",id1.toString());
                intent.putExtra("name",name);
                intent.putExtra("day",day);
                    Log.e(TAG, "onClick: "+sex+id1+name+day );
                startActivity(intent);
 }else{
                    startActivity(new Intent(ExcersiceMain.this,allDoneActivity.class));
                }

            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExcersiceMain.this,dayExcersiceSet.class);
                intent.putExtra("sex",sex);
                intent.putExtra("name",name);
                intent.putExtra("day",day);
                startActivity(intent);
            }
        });

    }
    void Initialse(){
        tabLayout = (TabLayout)findViewById(R.id.emTab);
        viewPager=(ViewPager)findViewById(R.id.emView);
        excersiceName=(TextView)findViewById(R.id.emName);
        btngonxt = findViewById(R.id.emGonxtbtn);
        btnBack = findViewById(R.id.emBackBtn);
        set = (ConstraintLayout)findViewById(R.id.EMSets);
        list = (ConstraintLayout)findViewById(R.id.EMList);
        nutchart = (ConstraintLayout)findViewById(R.id.EMCharts);
        bmi = (ConstraintLayout)findViewById(R.id.EMbmi);
        home = (ConstraintLayout)findViewById(R.id.EMhome);



      //  startEx = findViewById(R.id.showPop);
        day = getIntent().getStringExtra("day");
        name = getIntent().getStringExtra("name");
        sex = getIntent().getStringExtra("sex");
        id = getIntent().getStringExtra("id");
    }

    void databaseLinking(){
        mDatabase = FirebaseDatabase.getInstance().getReference();
         db = mDatabase.child("ExcersiceSets").child(sex).child(name).child(day).child(id);
        dialog = new Dialog(this);
        Log.e(TAG, "onCreate: "+id );

        adapter = new checkExcersiceAdapter(getSupportFragmentManager());

        adapter.AddFragment(new Em1stFragment(),"Description");
        adapter.AddFragment(new Em2ndFragment(),"Instructions");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map<String , String > postMap = (Map<String, String>)dataSnapshot.getValue();
                status = postMap.get("status");
                String name = postMap.get("name");
                excersiceName.setText(name);
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

void setonclicklistner(){
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExcersiceMain.this,excersiceSetActivity.class));
            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExcersiceMain.this,frontPageActivity.class));
            }
        });
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExcersiceMain.this, BMIActivity.class));
            }
        });
        nutchart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExcersiceMain.this,nutritionActivity.class));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExcersiceMain.this,MainActivity.class));
            }
        });

}
}
