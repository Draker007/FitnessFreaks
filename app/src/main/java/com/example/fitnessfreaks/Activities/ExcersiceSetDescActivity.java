package com.example.fitnessfreaks.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fitnessfreaks.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class ExcersiceSetDescActivity extends AppCompatActivity {
    TextView name,weeks,desc;
    Button go;
    DatabaseReference mdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersice_set_desc);
        name = (TextView)findViewById(R.id.ESDname);
        weeks=(TextView)findViewById(R.id.ESDweeks);
        desc=(TextView)findViewById(R.id.ESDdesc);
        go = (Button)findViewById(R.id.ESDstart);
        mdatabase = FirebaseDatabase.getInstance().getReference();
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


        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    go.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ExcersiceSetDescActivity.this,daysActivity.class);
             intent.putExtra("name", name12);
            intent.putExtra("sex",sex);

            startActivity(intent);
        }
    });
    }
}
