package com.example.fitnessfreaks.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fitnessfreaks.Activities.CheckEexcersiceActivity;
import com.example.fitnessfreaks.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.Map;

public class instructionexcersice_fragment extends Fragment {
    View v;
    DatabaseReference databaseReference;
     String inst10;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.instructionexcersice_fragment,container,false);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        View v = getView();
        if (v != null){
        final TextView Instruction = (TextView) v.findViewById(R.id.Instruction101);
           AdView adView = v.findViewById(R.id.banner2);
            MobileAds.initialize(getContext(),
                    "ca-app-pub-9245993672547749/2605253595");

            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
            CheckEexcersiceActivity checkEexcersiceActivity = (CheckEexcersiceActivity) getActivity();
            final String id1 = checkEexcersiceActivity.getid();
            final String type1 = checkEexcersiceActivity.gettype();
            Log.e("draker",type1);
            databaseReference = FirebaseDatabase.getInstance().getReference();
            final DatabaseReference excersise = databaseReference.child("exercises").child(type1).child(id1);
            excersise.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Map<String,String> post = (Map<String, String>)dataSnapshot.getValue();
                    inst10 = post.get("WorkoutDesc");
                    Log.e("ladua", String.valueOf(inst10.length()));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Instruction.setText(Html.fromHtml(inst10, Html.FROM_HTML_MODE_COMPACT));
                    } else {
                        Instruction.setText(Html.fromHtml(inst10));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


    }}
}
