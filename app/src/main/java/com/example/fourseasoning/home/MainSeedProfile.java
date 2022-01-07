package com.example.fourseasoning.home;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fourseasoning.CustomAdapter;
import com.example.fourseasoning.DatabaseHelper;
import com.example.fourseasoning.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainSeedProfile extends Fragment {
    RecyclerView recyclerView;
    FloatingActionButton add_button;
    DatabaseHelper db;
    ArrayList<String> plantId,
            plantNames,
            plantBoxNumbers,
            plantMonthsToFull,
            plantSoilConditions,
            plantWaterFrequencies,
            plantWaterMethods,
            plantLightingConditions,
            plantAdditionalInfos;

    CustomAdapter customAdapter;
    ImageView ivNoPlants;
    TextView tvNoPlants;
    Context thisContext;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        thisContext = container.getContext();
        recyclerView = view.findViewById(R.id.rvPlants);
        ivNoPlants = view.findViewById(R.id.ivNoPlants);
        tvNoPlants = view.findViewById(R.id.tvNoPlants);

        db = new DatabaseHelper(thisContext);
        plantId = new ArrayList<>();
        plantNames = new ArrayList<>();
        plantBoxNumbers = new ArrayList<>();
        plantMonthsToFull= new ArrayList<>();
        plantSoilConditions = new ArrayList<>();
        plantWaterFrequencies = new ArrayList<>();
        plantWaterMethods = new ArrayList<>();
        plantLightingConditions = new ArrayList<>();
        plantAdditionalInfos = new ArrayList<>();

        storeDataInArrays();
        customAdapter = new CustomAdapter(getActivity(),
                thisContext,
                plantId,
                plantNames,
                plantBoxNumbers,
                plantMonthsToFull,
                plantSoilConditions,
                plantWaterFrequencies,
                plantWaterMethods,
                plantLightingConditions,
                plantAdditionalInfos);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(thisContext));
        return view;
    }

    void storeDataInArrays(){
        Cursor cursor = db.readAllData();
        if(cursor.getCount() == 0){
            //if no data present in the database
            ivNoPlants.setVisibility(View.VISIBLE);
            tvNoPlants.setVisibility(View.VISIBLE);
        }
        else{
            while(cursor.moveToNext()){
                plantId.add(cursor.getString(0));
                plantNames.add(cursor.getString(1));
                plantBoxNumbers.add(cursor.getString(2));
                plantMonthsToFull.add(cursor.getString(3));
                plantSoilConditions.add(cursor.getString(4));
                plantWaterFrequencies.add(cursor.getString(5));
                plantWaterMethods.add(cursor.getString(6));
                plantLightingConditions.add(cursor.getString(7));
                plantAdditionalInfos.add(cursor.getString(8));
            }
            ivNoPlants.setVisibility(View.GONE);
            tvNoPlants.setVisibility(View.GONE);
        }
    }
}
