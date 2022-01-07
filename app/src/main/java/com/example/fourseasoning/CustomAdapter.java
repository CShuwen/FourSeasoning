package com.example.fourseasoning;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context context;
    ArrayList<String> plantId,
            plantNames,
            plantBoxNumbers,
            plantMonthsToFull,
            plantSoilConditions,
            plantWaterFrequencies,
            plantWaterMethods,
            plantLightingConditions,
            plantAdditionalInfos;
    Activity activity;

    public CustomAdapter(Activity activity,
                  Context context,
                  ArrayList plantId,
                  ArrayList plantNames,
                  ArrayList plantBoxNumbers,
                  ArrayList plantMonthsToFull,
                  ArrayList plantSoilConditions,
                  ArrayList plantWaterFrequencies,
                  ArrayList plantWaterMethods,
                  ArrayList plantLightingConditions,
                  ArrayList plantAdditionalInfos){

        this.activity = activity;
        this.context = context;
        this.plantId = plantId;
        this.plantNames = plantNames;
        this.plantBoxNumbers = plantBoxNumbers;
        this.plantMonthsToFull = plantMonthsToFull;
        this.plantSoilConditions = plantSoilConditions;
        this.plantWaterMethods = plantWaterMethods;
        this.plantWaterFrequencies = plantWaterFrequencies;
        this.plantLightingConditions = plantLightingConditions;
        this.plantAdditionalInfos = plantAdditionalInfos;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.plant_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tvPlantName.setText(String.valueOf(plantNames.get(position)));
        holder.tvPlantWater.setText(String.valueOf(plantWaterFrequencies.get(position)));
        holder.tvSoilCondition.setText(String.valueOf(plantSoilConditions.get(position)));
        holder.tvLightingCondition.setText(String.valueOf(plantLightingConditions.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment updateFragment =new UpdateFragment();
                Bundle bundle = new Bundle();

                bundle.putString("plantId",String.valueOf(plantId.get(position)));
                bundle.putString("plantName", String.valueOf(plantNames.get(position)));
                bundle.putString("boxNumber", String.valueOf(plantBoxNumbers.get(position)));
                bundle.putString("monthsToFull", String.valueOf(plantMonthsToFull.get(position)));
                bundle.putString("soilCondition", String.valueOf(plantSoilConditions.get(position)));
                bundle.putString("waterFrequency", String.valueOf(plantWaterFrequencies.get(position)));
                bundle.putString("waterMethod", String.valueOf(plantWaterMethods.get(position)));
                bundle.putString("lightingCondition", String.valueOf(plantLightingConditions.get(position)));
                bundle.putString("additionalInfo", String.valueOf(plantAdditionalInfos.get(position)));

                updateFragment.setArguments(bundle);
                activity.getFragmentManager().beginTransaction().replace(R.id.home_container, updateFragment).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return plantNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvPlantName, tvPlantWater, tvSoilCondition, tvLightingCondition;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlantName = itemView.findViewById(R.id.tvPlantName);
            tvPlantWater = itemView.findViewById(R.id.tvPlantWater);
            tvSoilCondition = itemView.findViewById(R.id.tvSoilCondition);
            tvLightingCondition = itemView.findViewById(R.id.tvLightingCondition);
            mainLayout = itemView.findViewById(R.id.row_layout);
        }
    }
}
