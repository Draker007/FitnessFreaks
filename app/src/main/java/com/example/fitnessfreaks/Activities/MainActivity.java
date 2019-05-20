package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fitnessfreaks.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    private ConstraintLayout allExcersice , myExcersice , nutrition ;
    FirebaseAuth.AuthStateListener mAuthListner;
    GoogleSignInClient mGoogle;
private Button signout;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signout = (Button) findViewById(R.id.signOut);
        mAuth = FirebaseAuth.getInstance();
        allExcersice = (ConstraintLayout) findViewById(R.id.AllWorkout);
        myExcersice = (ConstraintLayout) findViewById(R.id.CustomWokout);
        nutrition = (ConstraintLayout) findViewById(R.id.Nutrition);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("802997826990-8b4ihdbg5nqjhq0uofueicjbgmvn2j2f.apps.googleusercontent.com")
                .requestEmail()
                .build();
        mGoogle = GoogleSignIn.getClient(this, gso);
        allExcersice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,frontPageActivity.class));
            }
        });
        nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,nutritionActivity.class));
            }
        });
        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null){
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            } }
        };
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                mGoogle.revokeAccess();
            }
        });
        myExcersice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,excersiceSetActivity.class));
            }
        });

    }
}
