package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fitnessfreaks.R;

public class LoginActivity extends AppCompatActivity {
private Button Login,Gmail,Facebook;
private TextView newMember , forgotPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        InitializeUI();
        clickListener();
    }


    private void InitializeUI(){
       // Login = (Button) findViewById(R.id.LogIn);
       // Gmail = (Button) findViewById(R.id.loginGmailButton);
       // Facebook= (Button)findViewById(R.id.loginFacebookButton);
        newMember = (TextView)findViewById(R.id.newMember);
       // forgotPass =(TextView)findViewById(R.id.forgotPass);

    }


    private void clickListener(){

        newMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
            }
        });

    }
}
