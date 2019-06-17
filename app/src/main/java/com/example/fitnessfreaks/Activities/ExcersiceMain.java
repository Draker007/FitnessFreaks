package com.example.fitnessfreaks.Activities;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.fitnessfreaks.Adapters.checkExcersiceAdapter;
import com.example.fitnessfreaks.Fragments.Em1stFragment;
import com.example.fitnessfreaks.Fragments.Em2ndFragment;
import com.example.fitnessfreaks.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import pl.droidsonroids.gif.GifImageView;

public class ExcersiceMain extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private checkExcersiceAdapter adapter;
    TextView excersiceName;
    DatabaseReference databaseReference , db;
    ProgressBar progressBar;
    String TAG = "draker";
    String id,sex,name,day,status;
    Button btngonxt , btnBack , startEx;
    DatabaseReference mDatabase;
    Dialog dialog;
    ImageView popimage;
     int i = 20;

    public String getid(){
         id = getIntent().getStringExtra("id");
        return id;
    }
    public String getSex(){
         sex = getIntent().getStringExtra("sex");
        return sex;
    }
    public String getname(){
         name = getIntent().getStringExtra("name");
        return name;
    }
    public String getday(){
         day = getIntent().getStringExtra("day");
        return day;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersice_main);
        progressBar = (ProgressBar)findViewById(R.id.EMProgress);
        Initialse();
       databaseLinking();

//        startEx.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Showpopup();
//            }
//        });

        btngonxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "true";
                if (status.equals(str)){
                Intent intent = new Intent(ExcersiceMain.this,ExcersiceMain.class);
                intent.putExtra("sex",sex);
                Integer id1 = Integer.valueOf(id);
                id1++;
                intent.putExtra("id",id1.toString());
                intent.putExtra("name",name);
                intent.putExtra("day",day);
                    Log.e(TAG, "onClick: "+sex+id1+name+day );
                startActivity(intent);
 }else{
                    startActivity(new Intent(ExcersiceMain.this,allDoneActivity.class));
                }

            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExcersiceMain.this,dayExcersiceSet.class);
                intent.putExtra("sex",sex);
                intent.putExtra("name",name);
                intent.putExtra("day",day);
                startActivity(intent);
            }
        });

    }
    void Initialse(){
        tabLayout = (TabLayout)findViewById(R.id.emTab);
        viewPager=(ViewPager)findViewById(R.id.emView);
        excersiceName=(TextView)findViewById(R.id.emName);
        btngonxt = findViewById(R.id.emGonxtbtn);
        btnBack = findViewById(R.id.emBackBtn);

      //  startEx = findViewById(R.id.showPop);
        day = getIntent().getStringExtra("day");
        name = getIntent().getStringExtra("name");
        sex = getIntent().getStringExtra("sex");
        id = getIntent().getStringExtra("id");
    }

    void databaseLinking(){
        mDatabase = FirebaseDatabase.getInstance().getReference();
         db = mDatabase.child("ExcersiceSets").child(sex).child(name).child(day).child(id);
        dialog = new Dialog(this);
        Log.e(TAG, "onCreate: "+id );

        adapter = new checkExcersiceAdapter(getSupportFragmentManager());

        adapter.AddFragment(new Em1stFragment(),"Description");
        adapter.AddFragment(new Em2ndFragment(),"Instructions");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map<String , String > postMap = (Map<String, String>)dataSnapshot.getValue();
                status = postMap.get("status");
                String name = postMap.get("name");
                excersiceName.setText(name);
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
//    void Showpopup() {
//
//        final TextView count;
//        dialog.setContentView(R.layout.start_excersice_pop);
//        popimage = (ImageView) dialog.findViewById(R.id.popImage);
//
//        count = (TextView) dialog.findViewById(R.id.popCounter);
//
//
//        db.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Map<String, String> postMap = (Map<String, String>) dataSnapshot.getValue();
//                String name = postMap.get("name");
//                dialog.setTitle(name);
//                String image = postMap.get("video");
//                new CountDownTimer(22000, 1000) { // adjust the milli seconds here
//
//                    public void onTick(long millisUntilFinished) {
//                        String o = String.valueOf(i);
//                        i=i-1;
//                        count.setText(o);
//                    }
//
//                    @Override
//                    public void onFinish() {
//
//                    }
//                }.start();
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        dialog.show();
//    }

//    void loadImage(String image){
//    Glide.with(this).load(image).into(popimage);
//    }

}
