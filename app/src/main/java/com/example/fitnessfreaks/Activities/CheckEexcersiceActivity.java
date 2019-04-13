package com.example.fitnessfreaks.Activities;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.fitnessfreaks.Adapters.checkExcersiceAdapter;
import com.example.fitnessfreaks.Fragments.descriptionexcersice_fragment;
import com.example.fitnessfreaks.Fragments.instructionexcersice_fragment;
import com.example.fitnessfreaks.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class CheckEexcersiceActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private checkExcersiceAdapter adapter;
    TextView excersiceName,type;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_eexcersice);

        Initialize();
        clickListeners();
        fragments();
        fragmentdata();
    }
    public String getid(){
        String id = getIntent().getStringExtra("id");
        return id;
    }
    public String gettype(){
        String type = getIntent().getStringExtra("type");
        return type;
    }

    public void Initialize(){
         tabLayout = (TabLayout)findViewById(R.id.checkExcersiceTabLayout);
         viewPager=(ViewPager)findViewById(R.id.checkExcersiceViewer);
         excersiceName=(TextView)findViewById(R.id.exerciseName);
         adapter = new checkExcersiceAdapter(getSupportFragmentManager());
       //  type = (TextView)findViewById(R.id.Type);
        //    type.setText("yoyoyo");

    }

    public void clickListeners(){



    }



    public void fragments(){
    adapter.AddFragment(new descriptionexcersice_fragment(),"Description");
    adapter.AddFragment(new instructionexcersice_fragment(),"Instructions");
    viewPager.setAdapter(adapter);
    tabLayout.setupWithViewPager(viewPager);

    }

    private void fragmentdata(){

    }
}
