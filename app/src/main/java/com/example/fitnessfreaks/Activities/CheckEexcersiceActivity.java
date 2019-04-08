package com.example.fitnessfreaks.Activities;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fitnessfreaks.Adapters.checkExcersiceAdapter;
import com.example.fitnessfreaks.Fragments.descriptionexcersice_fragment;
import com.example.fitnessfreaks.Fragments.instructionexcersice_fragment;
import com.example.fitnessfreaks.R;

public class CheckEexcersiceActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private checkExcersiceAdapter adapter;
    TextView excersiceName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_eexcersice);

        Initialize();
        clickListeners();
        fragments();
    }


    public void Initialize(){
         tabLayout = (TabLayout)findViewById(R.id.checkExcersiceTabLayout);
         viewPager=(ViewPager)findViewById(R.id.checkExcersiceViewer);
         excersiceName=(TextView)findViewById(R.id.exerciseName);
         adapter = new checkExcersiceAdapter(getSupportFragmentManager());

    }

    public void clickListeners(){



    }

    public void fragments(){
    adapter.AddFragment(new descriptionexcersice_fragment(),"Description");
    adapter.AddFragment(new instructionexcersice_fragment(),"Instructions");
    viewPager.setAdapter(adapter);
    tabLayout.setupWithViewPager(viewPager);

    }
}
