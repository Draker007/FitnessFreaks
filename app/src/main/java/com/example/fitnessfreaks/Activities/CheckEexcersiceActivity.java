package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fitnessfreaks.Adapters.checkExcersiceAdapter;
import com.example.fitnessfreaks.Fragments.descriptionexcersice_fragment;
import com.example.fitnessfreaks.Fragments.instructionexcersice_fragment;
import com.example.fitnessfreaks.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DatabaseReference;

public class CheckEexcersiceActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private checkExcersiceAdapter adapter;
    TextView excersiceName,type;
    DatabaseReference databaseReference;
    ConstraintLayout set, bmi, list, nutchart, home;

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
         excersiceName=(TextView)findViewById(R.id.excersiceName101);
         adapter = new checkExcersiceAdapter(getSupportFragmentManager());
       //  type = (TextView)findViewById(R.id.Type);
        //    type.setText("yoyoyo");
        set = (ConstraintLayout)findViewById(R.id.CESets);
        list = (ConstraintLayout)findViewById(R.id.CEList);
        nutchart = (ConstraintLayout)findViewById(R.id.CECharts);
        bmi = (ConstraintLayout)findViewById(R.id.CEbmi);
        home = (ConstraintLayout)findViewById(R.id.CEhome);
        String name = getIntent().getStringExtra("name");
        excersiceName.setText(name);
    }

    public void clickListeners(){

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckEexcersiceActivity.this,excersiceSetActivity.class));
            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckEexcersiceActivity.this,frontPageActivity.class));
            }
        });
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckEexcersiceActivity.this, BMIActivity.class));
            }
        });
        nutchart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckEexcersiceActivity.this,nutritionActivity.class));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckEexcersiceActivity.this,MainActivity.class));
            }
        });

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
