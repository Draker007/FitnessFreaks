package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fitnessfreaks.R;

public class frontPageActivity extends AppCompatActivity {

    private ConstraintLayout Biceps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        initialize();
        listner();
    }

    private void initialize(){
        Biceps = (ConstraintLayout)findViewById(R.id.biceps_layout);
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
    }
}
