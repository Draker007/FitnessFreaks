package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitnessfreaks.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Map;

public class ExcersiceSetDescActivity extends AppCompatActivity {
    TextView name,weeks,desc;
    Button go;
    ImageView images;
    ConstraintLayout set, bmi, list, nutchart, home;
    DatabaseReference mdatabase;
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersice_set_desc);
        name = (TextView)findViewById(R.id.ESDname);
        weeks=(TextView)findViewById(R.id.ESDweeks);
        desc=(TextView)findViewById(R.id.ESDdesc);
        go = (Button)findViewById(R.id.ESDstart);
        images = (ImageView)findViewById(R.id.ESDimage);
        set = (ConstraintLayout)findViewById(R.id.ESDSets);
        list = (ConstraintLayout)findViewById(R.id.ESDList);
        nutchart = (ConstraintLayout)findViewById(R.id.ESDCharts);
        bmi = (ConstraintLayout)findViewById(R.id.ESDbmi);
        home = (ConstraintLayout)findViewById(R.id.ESDhome);

        mdatabase = FirebaseDatabase.getInstance().getReference();
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-9245993672547749/4301887763");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        prepareData();
    }

    private void prepareData(){
   final String name12 = getIntent().getStringExtra("name");
        final String sex = getIntent().getStringExtra("sex");
        Log.e("draker", name12 );
    DatabaseReference databaseReference = mdatabase.child("ExcersiceSets").child(sex).child(name12);
    databaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Map<String,String> postMap = (Map<String, String>)dataSnapshot.getValue();
                String name1 = postMap.get("who");
                 name.setText(name1);
                 String week = postMap.get("weeks");
                 weeks.setText(week);
                 String descr = postMap.get("desc");
                 desc.setText(descr);
                 String image = postMap.get("image");
            Picasso.get().load(image).into(images);


        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExcersiceSetDescActivity.this,excersiceSetActivity.class));
            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExcersiceSetDescActivity.this,frontPageActivity.class));
            }
        });
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExcersiceSetDescActivity.this, BMIActivity.class));
            }
        });
        nutchart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExcersiceSetDescActivity.this,nutritionActivity.class));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExcersiceSetDescActivity.this,MainActivity.class));
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(interstitialAd.isLoaded()){
                interstitialAd.show();
            }else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }

            Intent intent = new Intent(ExcersiceSetDescActivity.this,daysActivity.class);
             intent.putExtra("name", name12);
            intent.putExtra("sex",sex);

            startActivity(intent);
        }
    });
    }
}
