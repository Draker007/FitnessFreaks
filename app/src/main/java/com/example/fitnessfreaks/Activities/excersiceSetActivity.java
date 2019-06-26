package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fitnessfreaks.R;

public class excersiceSetActivity extends AppCompatActivity {
    private ConstraintLayout men , women;
    ConstraintLayout set, bmi, list, nutchart, home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersice_set);
        set = (ConstraintLayout)findViewById(R.id.ESSets);
        list = (ConstraintLayout)findViewById(R.id.ESList);
        nutchart = (ConstraintLayout)findViewById(R.id.ESCharts);
        bmi = (ConstraintLayout)findViewById(R.id.ESbmi);
        home = (ConstraintLayout)findViewById(R.id.EShome);
        men = (ConstraintLayout) findViewById(R.id.menLayout);
        women = (ConstraintLayout) findViewById(R.id.womenLayout);

        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(excersiceSetActivity.this ,customExcersiceActivity.class);
                intent.putExtra("sex","Men");
                startActivity(intent);
            }
        });
        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(excersiceSetActivity.this,customExcersiceActivity.class);
                intent.putExtra("sex","Women");
                startActivity(intent);
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(excersiceSetActivity.this,excersiceSetActivity.class));
            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(excersiceSetActivity.this,frontPageActivity.class));
            }
        });
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(excersiceSetActivity.this, BMIActivity.class));
            }
        });
        nutchart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(excersiceSetActivity.this,nutritionActivity.class));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(excersiceSetActivity.this,MainActivity.class));
            }
        });
    }
    }

