package com.example.fitnessfreaks.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fitnessfreaks.DataClasses.NutritionList;
import com.example.fitnessfreaks.R;

import java.util.List;
import java.util.PriorityQueue;

public class NutritionAdapter extends RecyclerView.Adapter<NutritionAdapter.MyviewHolder> {

private List<NutritionList> nutritionLists;

    public NutritionAdapter(List<NutritionList> nutritionLists) {
        this.nutritionLists = nutritionLists;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nutrition_recycler,viewGroup,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder myviewHolder, int i) {
        NutritionList nut = nutritionLists.get(i);
        myviewHolder.NutName.setText(nut.getName());
        myviewHolder.Carbs.setText(nut.getCarbs());
        myviewHolder.protien.setText(nut.getProtien());
        myviewHolder.Fat.setText(nut.getFat());

    }

    @Override
    public int getItemCount() {
        return nutritionLists.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder {
        TextView NutName , qty , protien , Fat, Carbs;


        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            NutName = (TextView)itemView.findViewById(R.id.nutName);
            protien = (TextView)itemView.findViewById(R.id.nutProtien);
            Fat = (TextView) itemView.findViewById(R.id.nutFat);
            Carbs = (TextView) itemView.findViewById(R.id.nutCarbs);

        }
    }
}
