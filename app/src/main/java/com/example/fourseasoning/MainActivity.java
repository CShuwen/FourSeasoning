package com.example.fourseasoning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fourseasoning.add.MainNewSeedList;
import com.example.fourseasoning.bluetooth.BluetoothFragment;
import com.example.fourseasoning.home.HomeFragment;
import com.example.fourseasoning.home.MainSeedProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container, new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.home);

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
                    case R.id.add:
                        fragment = new MainNewSeedList();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container, fragment).commit();
                return true;
            }
        });

    }

}