package com.example.fitnessfreaks.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fitnessfreaks.Activities.CheckEexcersiceActivity;
import com.example.fitnessfreaks.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class descriptionexcersice_fragment extends Fragment {
View v;
TextView type1,muscle,equipment;
DatabaseReference databaseReference;
String id , type;
String type12;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       v=inflater.inflate(R.layout.descriptionexcersice_fragment,container,false);
            type1 = (TextView) container.findViewById(R.id.Type);
            muscle = (TextView) container.findViewById(R.id.Muscle);
            equipment = (TextView) container.findViewById(R.id.Equipment);
//            type1.setText(type12);
       return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CheckEexcersiceActivity checkEexcersiceActivity = (CheckEexcersiceActivity) getActivity();

       final String id = checkEexcersiceActivity.getid();
        final String type = checkEexcersiceActivity.gettype();
        Log.e("desc",type+id);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference excersice  = databaseReference.child("exercises").child(type);
        excersice.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    Map<String, String> postMap = (Map<String, String>) snap.getValue();

                    String id1 = postMap.get("id");
                    Log.e("inside10", id1);
//                    if(id1 ==id) {
                         type12 = postMap.get("Type");
                        //type1.setText(t);

                        break;

//                    }


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void setType (String type){
        type1.setText(type);
}
}
