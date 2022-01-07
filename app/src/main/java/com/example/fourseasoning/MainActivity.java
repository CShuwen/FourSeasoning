package com.example.fourseasoning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.fourseasoning.add.MainNewSeedList;
import com.example.fourseasoning.bluetooth.BluetoothFragment;
import com.example.fourseasoning.home.HomeFragment;
import com.example.fourseasoning.home.MainSeedProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FragmentContainerView fragmentContainerView;
    FloatingActionButton addPlantButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
        addPlantButton = findViewById(R.id.add_plant);
        fragmentContainerView = findViewById(R.id.fragment_container);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainSeedProfile()).commit();
        bottomNavigationView.setSelectedItemId(R.id.home);

        addPlantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainNewSeedList()).commit();
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.home:
                        fragment = new MainSeedProfile();
                        break;
                    case  R.id.bluetooth:

                        fragment = new BluetoothFragment();
                        break;
                        /*
                    case R.id.add:
                        Toast.makeText(getApplicationContext(), "add clicked", Toast.LENGTH_SHORT).show();
                        fragment = new MainNewSeedList();
                        break;
                        */

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                return true;
            }
        });

    }

}