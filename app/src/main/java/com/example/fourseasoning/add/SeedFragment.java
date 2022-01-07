package com.example.fourseasoning.add;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.fourseasoning.R;

public class SeedFragment extends Fragment {
    private TextView tvPlantName,
            tvMonthsToFullMaturity,
            tvSoilCondition,tvWaterFrequency,
            tvWaterMethod,tvLightingCondition,
            tvAdditionalInfo;
    Context thisContext;
    Button btStartPlanting;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.infopage_newseed, container, false);
        thisContext = container.getContext();

        Bundle args = getArguments();
        String plantName = args.getString("plantName");
        String monthsToFull = args.getString("monthsToFull");
        String soilCondition = args.getString("soilCondition");
        String waterFrequency = args.getString("waterFrequency");
        String waterMethod = args.getString("waterMethod");
        String lightingCondition = args.getString("lightingCondition");
        String additionalInfo = args.getString("additionalInfo");
        tvPlantName = view.findViewById(R.id.tvPlantName);
        tvMonthsToFullMaturity = view.findViewById(R.id.tvMonthsToFullMaturity);
        tvSoilCondition = view.findViewById(R.id.tvSoilCondition);
        tvWaterFrequency = view.findViewById(R.id.tvWaterFrequency);
        tvWaterMethod = view.findViewById(R.id.tvWaterMethod);
        tvLightingCondition = view.findViewById(R.id.tvLightingCondition);
        tvAdditionalInfo = view.findViewById(R.id.tvAdditionalInfo);

        tvPlantName.setText(plantName);
        tvMonthsToFullMaturity.setText(monthsToFull);
        tvSoilCondition.setText(soilCondition);
        tvWaterFrequency.setText(waterFrequency);
        tvWaterMethod.setText(waterMethod);
        tvLightingCondition.setText(lightingCondition);
        tvAdditionalInfo.setText(additionalInfo);

        btStartPlanting = view.findViewById(R.id.btStartPlanting);

        btStartPlanting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }
    }
