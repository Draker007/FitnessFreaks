package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.renderscript.Sampler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessfreaks.R;

import org.w3c.dom.Text;

public class BMIActivity extends AppCompatActivity {

    private  TextView weight ,height , setbmi , category ;
    Button btnBmi;
    ConstraintLayout set, bmi, list, nutchart, home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        weight = (TextView)findViewById(R.id.bmiWeight);
        setbmi = (TextView)findViewById(R.id.bmi);
        height= (TextView)findViewById(R.id.bmiHeight);
        btnBmi=(Button)findViewById(R.id.BMIbtn);
        set = (ConstraintLayout)findViewById(R.id.BMISets);
        list = (ConstraintLayout)findViewById(R.id.BMIList);
        nutchart = (ConstraintLayout)findViewById(R.id.BMICharts);
        bmi = (ConstraintLayout)findViewById(R.id.BMIbmi);
        home = (ConstraintLayout)findViewById(R.id.BMIhome);
        category = (TextView)findViewById(R.id.weightBMI) ;
        btnBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String W = weight.getText().toString();
                String H = height.getText().toString();
                height.onEditorAction(EditorInfo.IME_ACTION_DONE);
                set.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(BMIActivity.this,excersiceSetActivity.class));
                    }
                });
                list.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(BMIActivity.this,frontPageActivity.class));
                    }
                });
                bmi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(BMIActivity.this, BMIActivity.class));
                    }
                });
                nutchart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(BMIActivity.this,nutritionActivity.class));
                    }
                });
                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(BMIActivity.this,MainActivity.class));
                    }
                });

                if (W.isEmpty() || H.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter the details",Toast.LENGTH_SHORT).show();
                }
                else {
                    Float w = Float.parseFloat(W);
                    Float h = Float.parseFloat(H);
                    Float a = (w / (h * h)) * 10000;
                    setbmi.setText(a.toString());
                    if(a<18.5){
                        category.setText("Underweight");
                    }else if (a<24.9)
                        category.setText("Normal");
                    else if(a<29.9)
                        category.setText("Overweight");
                    else
                        category.setText("Obesity");

                }
            }
        });

    }
}
