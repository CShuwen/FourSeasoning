package com.example.fourseasoning.bluetooth;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fourseasoning.CustomAdapter;
import com.example.fourseasoning.DatabaseHelper;
import com.example.fourseasoning.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;


public class BluetoothControlFragment extends Fragment {
    RecyclerView rvBluetoothPlants;
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
    Context thisContext;

    //Bluetooth Functionalities
    Button bt1,btDisconnect;
    public static String EXTRA_ADDRESS = "device_address";
    String address = null;
    TextView tvAddress;
    TextView tvPlantName;
    BluetoothAdapter bluetoothAdapter = null;
    BluetoothSocket bluetoothSocket = null;
    private ProgressDialog progress;
    private boolean bluetoothConnected = false;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");


    public BluetoothControlFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
           address = bundle.getString(EXTRA_ADDRESS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bluetooth_control, container, false);
        thisContext = container.getContext();

        //Log.d("The address is:", address);
        tvAddress = view.findViewById(R.id.tvAddress);
        tvAddress.setText(address);
        db = new DatabaseHelper(thisContext);
        rvBluetoothPlants = view.findViewById(R.id.rvBluetoothPlants);
        bt1 = view.findViewById(R.id.btSetAsDisplayedPlant);
        tvPlantName = view.findViewById(R.id.tvPlantName);
        btDisconnect = view.findViewById(R.id.btDisconnect);
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




        new ConnectBT().execute();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String plantName = tvPlantName.getText().toString();
                if (plantName== "" || plantName == " " || plantName == "No Plant Selected for pot display.") {
                    Toast.makeText(thisContext,"Invalid plant name input!",Toast.LENGTH_SHORT).show();
                }
                else{
                    sendSignal(plantName);
                }
            }
        });

        btDisconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Disconnect();
            }
        });

        //use another adapter to put the name of the selected plant onto the screen
        CustomAdapterForBluetooth customAdapterForBluetooth = new CustomAdapterForBluetooth(getActivity(),
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

        rvBluetoothPlants.setAdapter(customAdapterForBluetooth);
        rvBluetoothPlants.setLayoutManager(new LinearLayoutManager(thisContext));
        return view;
    }

    private void sendSignal(String text){
        if(bluetoothSocket != null){
            try{

                bluetoothSocket.getOutputStream().write(text.getBytes());

            }
            catch (IOException e){
                msg("Error");
            }
        }
    }

    private void Disconnect(){
        if(bluetoothSocket != null){
            try {
                bluetoothSocket.close();
            }
            catch(IOException e){
                msg("Error");
            }
        }
        getFragmentManager().popBackStackImmediate();
        //finish();
    }

    private void msg(String s){
        Toast.makeText(thisContext, s, Toast.LENGTH_SHORT).show();
    }

    private class ConnectBT extends AsyncTask<Void, Void, Void> {
        private boolean connectSuccess = true;

        @Override
        protected void onPreExecute() {
            progress = ProgressDialog.show(thisContext, "Connecting...", "Please wait.");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                if( bluetoothSocket == null || !bluetoothConnected){
                    bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                    BluetoothDevice myBluetoothDevice = bluetoothAdapter.getRemoteDevice(address);
                    bluetoothSocket = myBluetoothDevice.createInsecureRfcommSocketToServiceRecord(myUUID);
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    bluetoothSocket.connect();
                }
            }
            catch (IOException e){
                connectSuccess = false;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            if(!connectSuccess){
                msg("Connection failed, please try again.");
                //finish();
                getFragmentManager().popBackStackImmediate();
            }
            else{
                msg("Connected!");
                bluetoothConnected = true;
            }
            progress.dismiss();
        }
    }

    void storeDataInArrays(){
        Cursor cursor = db.readAllData();
        if(cursor.getCount() == 0){
            //if no data present in the database
            Toast.makeText(thisContext, "No plants available yet :(", Toast.LENGTH_SHORT).show();
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
        }
    }

    //adapter such that clicking on an entry input the name on the plant oled
    private class CustomAdapterForBluetooth extends RecyclerView.Adapter<CustomAdapterForBluetooth.MyBTViewHolder> {
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

        public CustomAdapterForBluetooth(Activity activity,
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
        public MyBTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.plant_row,parent,false);
            return new MyBTViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomAdapterForBluetooth.MyBTViewHolder holder, int position) {
            holder.tvPlantName.setText(String.valueOf(plantNames.get(position)));
            holder.tvPlantWater.setText(String.valueOf(plantWaterFrequencies.get(position)));
            holder.tvSoilCondition.setText(String.valueOf(plantSoilConditions.get(position)));
            holder.tvLightingCondition.setText(String.valueOf(plantLightingConditions.get(position)));
            holder.mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvPlantName.setText(plantNames.get(position));
                }
            });
        }

        @Override
        public int getItemCount() {
            return plantNames.size();
        }

        private class MyBTViewHolder extends RecyclerView.ViewHolder{

            TextView tvPlantName, tvPlantWater, tvSoilCondition, tvLightingCondition;
            LinearLayout mainLayout;

            public MyBTViewHolder(@NonNull View itemView) {
                super(itemView);
                tvPlantName = itemView.findViewById(R.id.tvPlantName);
                tvPlantWater = itemView.findViewById(R.id.tvPlantWater);
                tvSoilCondition = itemView.findViewById(R.id.tvSoilCondition);
                tvLightingCondition = itemView.findViewById(R.id.tvLightingCondition);
                mainLayout = itemView.findViewById(R.id.row_layout);
            }
        }
    }
}