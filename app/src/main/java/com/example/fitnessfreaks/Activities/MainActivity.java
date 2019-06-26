package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fitnessfreaks.R;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;

    private ConstraintLayout allExcersice , myExcersice , nutrition , bmil;
  //  FirebaseAuth.AuthStateListener mAuthListner;
    ConstraintLayout set, bmi, list, nutchart, home;
    GoogleSignInClient mGoogle;
private Button signout;

    @Override
    protected void onStart() {
        super.onStart();
       // mAuth.addAuthStateListener(mAuthListner);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        set = (ConstraintLayout)findViewById(R.id.MSets);
        list = (ConstraintLayout)findViewById(R.id.MList);
        nutchart = (ConstraintLayout)findViewById(R.id.MCharts);
        bmi = (ConstraintLayout)findViewById(R.id.Mbmi);
        home = (ConstraintLayout)findViewById(R.id.Mhome);
        bmil = (ConstraintLayout)findViewById(R.id.bmilay);


       // signout = (Button) findViewById(R.id.signOut);
        mAuth = FirebaseAuth.getInstance();
        allExcersice = (ConstraintLayout) findViewById(R.id.AllWorkout);
        myExcersice = (ConstraintLayout) findViewById(R.id.CustomWokout);
        nutrition = (ConstraintLayout) findViewById(R.id.Nutrition);
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken("802997826990-8b4ihdbg5nqjhq0uofueicjbgmvn2j2f.apps.googleusercontent.com")
//                .requestEmail()
//                .build();
//        mGoogle = GoogleSignIn.getClient(this, gso);
        allExcersice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,frontPageActivity.class));
            }
        });
        bmil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BMIActivity.class));
            }
        });
        nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,nutritionActivity.class));
            }
        });
//        mAuthListner = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                if (firebaseAuth.getCurrentUser() == null){
//                startActivity(new Intent(MainActivity.this,LoginActivity.class));
//            } }
//        };
//        signout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mAuth.signOut();
//                mGoogle.revokeAccess();
//            }
//        });
        myExcersice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,excersiceSetActivity.class));
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,excersiceSetActivity.class));
            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,frontPageActivity.class));
            }
        });
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BMIActivity.class));
            }
        });
        nutchart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,nutritionActivity.class));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });


    }


}
