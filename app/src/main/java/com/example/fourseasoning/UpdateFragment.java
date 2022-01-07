package com.example.fourseasoning;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Fragment;
import androidx.appcompat.app.AlertDialog;


public class UpdateFragment extends Fragment {
    String plantId,
            plantName,
            boxNumber,
            monthsToFull,
            soilCondition,
            waterFrequency,
            waterMethod,
            lightingCondition,
            additionalInfo;

    EditText etPlantName,
            etBoxNumber,
            etMonthsToFull,
            etSoilCondition,
            etWaterFrequency,
            etWaterMethod,
            etLightingCondition,
            etAdditionalInfo;
    Context thisContext;
    Button btUpdate, btDelete;
    DatabaseHelper db;

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getBundleData();
        setBundleData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update, container, false);
        thisContext = container.getContext();
        etPlantName = view.findViewById(R.id.etPlantName);
        etBoxNumber = view.findViewById(R.id.etBoxNumber);
        etMonthsToFull = view.findViewById(R.id.etMonthsToFull);
        etSoilCondition = view.findViewById(R.id.etSoilCondition);
        etWaterFrequency = view.findViewById(R.id.etWaterFrequency);
        etWaterMethod = view.findViewById(R.id.etWaterMethod);
        etLightingCondition = view.findViewById(R.id.etLightingCondition);
        etAdditionalInfo = view.findViewById(R.id.etAdditionalInformation);

        //Initialise new database
        db = new DatabaseHelper(thisContext);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updatePlant();
            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
        return view;
    }

    private void updatePlant(){
        refreshCurrentValues();
        db.updateData(plantId,
                plantName,
                boxNumber,
                monthsToFull,
                soilCondition,
                waterFrequency,
                waterMethod,
                lightingCondition,
                additionalInfo);
    }


    private void getBundleData(){
        Bundle bundle =this.getArguments();
        if(bundle != null){
            plantId = bundle.getString("plantId");
            plantName = bundle.getString("plantName");
            boxNumber = bundle.getString("boxNumber");
            monthsToFull = bundle.getString("monthsToFull");
            soilCondition = bundle.getString("soilCondition");
            waterFrequency = bundle.getString("waterFrequency");
            waterMethod = bundle.getString("waterMethod");
            lightingCondition = bundle.getString("lightingCondition");
            additionalInfo = bundle.getString("additionalInfo");
        }
        else{
            Toast.makeText(thisContext, "No bundle from previous fragment.", Toast.LENGTH_SHORT).show();
        }

    }

    private void setBundleData(){
        etPlantName.setText(plantName);
        etBoxNumber.setText(boxNumber);
        etMonthsToFull.setText(monthsToFull);
        etSoilCondition.setText(soilCondition);
        etWaterFrequency.setText(waterFrequency);
        etWaterMethod.setText(waterMethod);
        etLightingCondition.setText(lightingCondition);
        etAdditionalInfo.setText(additionalInfo);
    }


    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(thisContext);
        builder.setTitle("Delete " + plantName + " ?");
        builder.setMessage("Confirm plant deletion " + plantName + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                db.deleteOneRow(plantId);
                //popback to previous fragment
                getFragmentManager().popBackStackImmediate();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    void refreshCurrentValues(){
        plantName = etPlantName.getText().toString().trim();
        boxNumber = etBoxNumber.getText().toString().trim();
        monthsToFull = etMonthsToFull.getText().toString().trim();
        soilCondition = etSoilCondition.getText().toString().trim();
        waterFrequency = etWaterFrequency.getText().toString().trim();
        waterMethod = etWaterMethod.getText().toString().trim();
        lightingCondition = etLightingCondition.getText().toString().trim();
        additionalInfo = etAdditionalInfo.getText().toString().trim();
    }
}