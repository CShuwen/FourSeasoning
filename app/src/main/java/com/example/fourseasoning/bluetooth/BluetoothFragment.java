package com.example.fourseasoning.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fourseasoning.R;
import com.example.fourseasoning.bluetooth.BluetoothControlFragment;

import java.util.ArrayList;
import java.util.Set;

public class BluetoothFragment extends Fragment {

    private BluetoothAdapter bluetoothAdap = null;
    private Set<BluetoothDevice> pairedDevices;
    public static String EXTRA_ADDRESS = "device_address";
    Context theContext;
    Button btPaired;
    ListView lvDevices;

    public BluetoothFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bluetooth, container, false);
        theContext = container.getContext();
        bluetoothAdap = BluetoothAdapter.getDefaultAdapter();
        btPaired = view.findViewById(R.id.btPaired);
        lvDevices = view.findViewById(R.id.lvDevices);

        btPaired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pairedDevicesList();
            }
        });
        if(bluetoothAdap == null){
            //device does not support bluetooth
            Toast.makeText(theContext, "Bluetooth devices not available", Toast.LENGTH_LONG).show();
        }
        else if(!bluetoothAdap.isEnabled()){
            Intent turnBluetoothOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnBluetoothOn,1);
        }
        return view;
    }

    private void pairedDevicesList(){
        pairedDevices = bluetoothAdap.getBondedDevices();
        ArrayList list = new ArrayList();

        if(pairedDevices.size() > 0){
            for(BluetoothDevice bt: pairedDevices){
                list.add(bt.getName().toString() + "\n" + bt.getAddress().toString());
            }
        }
        else{
            Toast.makeText(theContext, "No paired bluetooth devices found.", Toast.LENGTH_SHORT).show();
        }

        final ArrayAdapter deviceAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list);
        lvDevices.setAdapter(deviceAdapter);
        lvDevices.setOnItemClickListener(deviceListClickListener);
    }

    private AdapterView.OnItemClickListener deviceListClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String info = ((TextView)view).getText().toString();
            String address = info.substring(info.length() -17);
            Fragment bluetoothControlFragment = new BluetoothControlFragment();
            /*
            Bundle addressBundle = new Bundle();
            addressBundle.putString(EXTRA_ADDRESS, address);
            bluetoothControlFragment.setArguments(addressBundle);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerView, bluetoothControlFragment);
            transaction.addToBackStack(null);
            transaction.commit();
             */
        }
    };
}