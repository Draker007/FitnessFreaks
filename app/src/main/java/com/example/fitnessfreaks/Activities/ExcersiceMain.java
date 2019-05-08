package com.example.fitnessfreaks.Activities;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
    String status;
    TextView EMmuscle,EMequip,EMsets,EMrep,Exname,EMType,EMInst,EMCaution;
    WebView EmImage;
    Button gonxt,goback;
    DatabaseReference mdatabase;
    String TAG = "draker";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersice_main);
        EMmuscle=(TextView)findViewById(R.id.ExMuscle);
        EMequip=(TextView)findViewById(R.id.ExEquip);
        EMsets=(TextView)findViewById(R.id.ExSets);
        EMrep=(TextView)findViewById(R.id.ExReps);
        EmImage=(WebView) findViewById(R.id.ExImage);
        Exname=(TextView)findViewById(R.id.ExName);
        EMType=(TextView)findViewById(R.id.EMType);
        EMInst=(TextView)findViewById(R.id.ExInst);
        EMCaution=(TextView)findViewById(R.id.Excaution);
        gonxt=(Button)findViewById(R.id.btnGo);
        goback = (Button)findViewById(R.id.btnGoBack);
        mdatabase = FirebaseDatabase.getInstance().getReference();
        setdata();
        setlistner();
    }
    private void setdata(){
        final String sex = getIntent().getStringExtra("sex");
        final String name = getIntent().getStringExtra("name");
        final String id = getIntent().getStringExtra("id");
        final String day = getIntent().getStringExtra("day");
        Log.e(TAG, "setdata:"+ id +day+sex+name);
        DatabaseReference db = mdatabase.child("ExcersiceSets").child(sex).child(name).child(day).child(id);
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map<String,String> map = (Map<String, String>)dataSnapshot.getValue();
                String getname = map.get("name");
                String getmuscle = map.get("Main Muscle Worked");
                String getvideo = map.get("video");
                String getEquip = map.get("Equipment");
                String getInst = map.get("Instruction");
                String getCaution = map.get("Caution");
                String getSet = map.get("sets");
                String getRep = map.get("reps");
                String getType = map.get("Type");
                status = map.get("status");
                EMmuscle.setText(getmuscle);
                EMequip.setText(getEquip);
                EMsets.setText(getSet);
                EMrep.setText(getRep);
                EMInst.setText(getInst);
                EMCaution.setText(getCaution);
                Exname.setText(getname);
                EmImage.loadUrl(getvideo);
                Exname.setText(getname);
                EMType.setText(getType);




            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void setlistner(){
  gonxt.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          String str1 ="true";
          if (str1.equals(status)) {
              Intent intent = new Intent(ExcersiceMain.this, ExcersiceMain.class);
              String id = getIntent().getStringExtra("id");
              Integer id1 = Integer.valueOf(id);
              id1++;
              String sex = getIntent().getStringExtra("sex");
              String name = getIntent().getStringExtra("name");
              String day = getIntent().getStringExtra("day");
              intent.putExtra("id", id1.toString());
              intent.putExtra("sex", sex);
              intent.putExtra("name", name);
              intent.putExtra("day", day);
              startActivity(intent);
          }
          else{
              startActivity(new Intent(ExcersiceMain.this,allDoneActivity.class));
          }


      }
  });
  goback.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          String sex = getIntent().getStringExtra("sex");
          String name = getIntent().getStringExtra("name");
          String day = getIntent().getStringExtra("day");
          Intent intent = new Intent(ExcersiceMain.this,dayExcersiceSet.class);
          intent.putExtra("sex", sex);
          intent.putExtra("name", name);
          intent.putExtra("day", day);
          startActivity(intent);
      }
  });
    }
}
