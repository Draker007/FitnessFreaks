package com.example.fitnessfreaks.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitnessfreaks.DataClasses.excersice;
import com.example.fitnessfreaks.R;

import java.util.List;

public class excersiceAdapter extends RecyclerView.Adapter<excersiceAdapter.MyViewHolder> {

        Context mcontext;
        private List<excersice> excersices;


    public excersiceAdapter(Context mcontext, List<excersice> excersices) {
        this.mcontext = mcontext;
        this.excersices = excersices;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mcontext).inflate(R.layout.exercise_recycler,viewGroup,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
    myViewHolder.excersiceName.setText(excersices.get(i).getExcersiceName());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class  MyViewHolder extends  RecyclerView.ViewHolder{
    ImageView excersiceImage;
    TextView excersiceName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            excersiceImage = itemView.findViewById(R.id.exerciseImage);
            excersiceName = itemView.findViewById(R.id.exerciseName);


        }
    }}

