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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersice_set);

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
    }
    }

