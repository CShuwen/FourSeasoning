package com.example.fourseasoning;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


public class AddFragment extends Fragment {

    EditText etPlantName,
            etBoxNumber,
            etMonthsToFull,
            etSoilCondition,
            etWaterFrequency,
            etWaterMethod,
            etLightingCondition,
            etAdditionalInfo;
    Context thisContext;
    Button btInsert;
    DatabaseHelper db;



    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        thisContext = container.getContext();
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        etPlantName = view.findViewById(R.id.etPlantName);
        etBoxNumber = view.findViewById(R.id.etBoxNumber);
        etMonthsToFull = view.findViewById(R.id.etMonthsToFull);
        etSoilCondition = view.findViewById(R.id.etSoilCondition);
        etWaterFrequency = view.findViewById(R.id.etWaterFrequency);
        etWaterMethod = view.findViewById(R.id.etWaterMethod);
        etLightingCondition = view.findViewById(R.id.etLightingCondition);
        etAdditionalInfo = view.findViewById(R.id.etAdditionalInformation);
        btInsert = view.findViewById(R.id.btInsert);

        //Initialise new database helper
        db = new DatabaseHelper(thisContext);

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertPlant();
            }
        });
        return view;
    }


    private void insertPlant(){
        String plantName = etPlantName.getText().toString().trim();
        String boxNumber = etBoxNumber.getText().toString().trim();
        String monthsToFull= etMonthsToFull.getText().toString().trim();
        String soilCondition = etSoilCondition.getText().toString().trim();
        String waterFrequency = etWaterFrequency.getText().toString().trim();
        String waterMethod = etWaterMethod.getText().toString().trim();
        String lightingCondition = etLightingCondition.getText().toString().trim();
        String additionalInfo = etAdditionalInfo.getText().toString().trim();

        db.addPlant(plantName,
                boxNumber,
                monthsToFull,
                soilCondition,
                waterFrequency,
                waterMethod,
                lightingCondition,
                additionalInfo);
    }
}