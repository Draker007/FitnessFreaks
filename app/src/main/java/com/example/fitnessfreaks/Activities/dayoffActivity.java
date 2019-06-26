package com.example.fitnessfreaks.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fitnessfreaks.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class dayoffActivity extends AppCompatActivity {

    AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dayoff);
        MobileAds.initialize(this,
                "ca-app-pub-9245993672547749/9806507648");


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
