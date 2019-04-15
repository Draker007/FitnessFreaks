package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fitnessfreaks.R;

public class frontPageActivity extends AppCompatActivity {

    private ConstraintLayout Biceps,shoulders,legs,triceps,forearms,calves,abs,back,chest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        initialize();
        listner();
    }

    private void initialize(){
        Biceps = (ConstraintLayout)findViewById(R.id.biceps_layout);
        shoulders = (ConstraintLayout)findViewById(R.id.Shoulders);
        legs = (ConstraintLayout)findViewById(R.id.Legs);
        triceps = (ConstraintLayout)findViewById(R.id.Triceps);
        forearms= (ConstraintLayout)findViewById(R.id.Forearms);
        calves = (ConstraintLayout)findViewById(R.id.Calves);
        abs = (ConstraintLayout)findViewById(R.id.Abs);
        back = (ConstraintLayout)findViewById(R.id.Back);
        chest = (ConstraintLayout)findViewById(R.id.Chest);


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
                intent.putExtra("type","Forearms");
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



    }
}
