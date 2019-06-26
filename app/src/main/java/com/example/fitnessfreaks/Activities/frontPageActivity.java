package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fitnessfreaks.R;

public class frontPageActivity extends AppCompatActivity {

    private ConstraintLayout Biceps,shoulders,legs,triceps,forearms,calves,abs,back,chest;
    ConstraintLayout set, bmi, list, nutchart, home,search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        initialize();
        listner();
    }

    private void initialize(){
        Biceps = (ConstraintLayout)findViewById(R.id.biceps_layout);
        shoulders = (ConstraintLayout)findViewById(R.id.shoulder);
        legs = (ConstraintLayout)findViewById(R.id.Legs);
        triceps = (ConstraintLayout)findViewById(R.id.Triceps);
        forearms= (ConstraintLayout)findViewById(R.id.Forearms);
        calves = (ConstraintLayout)findViewById(R.id.Calves);
        abs = (ConstraintLayout)findViewById(R.id.Abs);
        back = (ConstraintLayout)findViewById(R.id.Back);
        chest = (ConstraintLayout)findViewById(R.id.Chest);
        set = (ConstraintLayout)findViewById(R.id.FPSets);
        list = (ConstraintLayout)findViewById(R.id.FPList);
        nutchart = (ConstraintLayout)findViewById(R.id.FPCharts);
        bmi = (ConstraintLayout)findViewById(R.id.FPbmi);
        home = (ConstraintLayout)findViewById(R.id.FPhome);

    }


    private void listner(){
        Biceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),excersiceListActivity.class);
                intent.putExtra("type","Biceps");
                startActivity(intent);
            }
        });
        shoulders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),excersiceListActivity.class);
                intent.putExtra("type","Shoulders");
                startActivity(intent);
            }
        });
        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),excersiceListActivity.class);
                intent.putExtra("type","Legs");
                startActivity(intent);
            }
        });

        triceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),excersiceListActivity.class);
                intent.putExtra("type","Tricep");
                startActivity(intent);
            }
        }); forearms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),excersiceListActivity.class);
                intent.putExtra("type","Forearm");
                startActivity(intent);
            }
        });
        abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),excersiceListActivity.class);
                intent.putExtra("type","Abs");
                startActivity(intent);
            }
        }); back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),excersiceListActivity.class);
                intent.putExtra("type","Back");
                startActivity(intent);
            }
        });
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),excersiceListActivity.class);
                intent.putExtra("type","Chest");
                startActivity(intent);
            }
        });
        calves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),excersiceListActivity.class);
                intent.putExtra("type","calves");
                startActivity(intent);
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(frontPageActivity.this,excersiceSetActivity.class));
            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(frontPageActivity.this,frontPageActivity.class));
            }
        });
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(frontPageActivity.this, BMIActivity.class));
            }
        });
        nutchart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(frontPageActivity.this,nutritionActivity.class));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(frontPageActivity.this,MainActivity.class));
            }
        });


    }
}
