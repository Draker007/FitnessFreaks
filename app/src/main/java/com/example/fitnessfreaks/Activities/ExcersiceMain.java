package com.example.fitnessfreaks.Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitnessfreaks.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import pl.droidsonroids.gif.GifImageView;

public class ExcersiceMain extends AppCompatActivity {

    TextView EMmuscle,EMequip,EMsets,EMrep,Exname;
    GifImageView EmImage;
    DatabaseReference mdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersice_main);
        EMmuscle=(TextView)findViewById(R.id.ExMuscle);
        EMequip=(TextView)findViewById(R.id.ExEquip);
        EMsets=(TextView)findViewById(R.id.ExSets);
        EMrep=(TextView)findViewById(R.id.ExMuscle);
        EmImage=(GifImageView) findViewById(R.id.ExImage);
        Exname=(TextView)findViewById(R.id.ExName);
        mdatabase = FirebaseDatabase.getInstance().getReference();
        setdata();
        setlistner();
    }
    private void setdata(){
        final String sex = getIntent().getStringExtra("sex");
        final String name = getIntent().getStringExtra("name");
        final String id = getIntent().getStringExtra("id");
        DatabaseReference db = mdatabase.child("ExcersiceSets").child(sex).child(name).child(id);
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map<String,String> map = (Map<String, String>)dataSnapshot.getValue();
                String getname = map.get("name");
                String getmuscle = map.get("")
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        })
    }

    private void setlistner(){

    }
}
