package com.example.fitnessfreaks.Activities;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
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
import android.widget.TextView;

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

import java.util.Map;

import pl.droidsonroids.gif.GifImageView;

public class ExcersiceMain extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private checkExcersiceAdapter adapter;
    TextView excersiceName,type;
    DatabaseReference databaseReference;
    String TAG = "draker";
    String id,sex,name,day,status;
    Button btngonxt , btnBack;
    DatabaseReference mDatabase;

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
        day = getIntent().getStringExtra("day");
        name = getIntent().getStringExtra("name");
        sex = getIntent().getStringExtra("sex");
        id = getIntent().getStringExtra("id");
        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference db = mDatabase.child("ExcersiceSets").child(sex).child(name).child(day).child(id);

        Log.e(TAG, "onCreate: "+id );
        tabLayout = (TabLayout)findViewById(R.id.emTab);
        viewPager=(ViewPager)findViewById(R.id.emView);
        excersiceName=(TextView)findViewById(R.id.emName);
        adapter = new checkExcersiceAdapter(getSupportFragmentManager());
        //  type = (TextView)findViewById(R.id.Type);
        //    type.setText("yoyoyo");

        adapter.AddFragment(new Em1stFragment(),"Description");
        adapter.AddFragment(new Em2ndFragment(),"Instructions");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        btngonxt = findViewById(R.id.emGonxtbtn);
        btnBack = findViewById(R.id.emBackBtn);
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map<String , String > postMap = (Map<String, String>)dataSnapshot.getValue();
                status = postMap.get("status");
                String name = postMap.get("name");
                excersiceName.setText(name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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

}
