package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fitnessfreaks.R;

public class ExcersiceSetList extends AppCompatActivity {
    private ImageView men , women;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excersices_setlist);
        men = (ImageView) findViewById(R.id.menWorkout);
        women = (ImageView) findViewById(R.id.womenWorkout);

        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExcersiceSetList.this ,customExcersiceActivity.class);
                 intent.putExtra("sex","Men");
                 startActivity(intent);
            }
        });
        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExcersiceSetList.this,customExcersiceActivity.class);
                intent.putExtra("sex","Women");
            startActivity(intent);
            }
        });
    }
}
