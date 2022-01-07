package com.example.fourseasoning.add;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fourseasoning.R;

public class SeedActivity extends AppCompatActivity {
    private TextView mSeedName;
    private TextView mSeedCondition;
    private TextView mLifeCycleTitle;
    private TextView mSeedLifeCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.infopage_newseed);

        mSeedName = findViewById(R.id.SeedName);
        mSeedCondition = findViewById(R.id.Conditions);
        mLifeCycleTitle = findViewById(R.id.LifeCycleTitle);
        mSeedLifeCycle = findViewById(R.id.LifeCycle);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("SeedName");
        String Condition = intent.getExtras().getString("SeedCondition");
        String LifeCycleTitle = intent.getExtras().getString("LifeCycleTitle");
        String LifeCycle = intent.getExtras().getString("SeedLifeCycle");

        mSeedName.setText(Title);
        mSeedCondition.setText(Condition);
        mLifeCycleTitle.setText(LifeCycleTitle);
        mSeedLifeCycle.setText(LifeCycle);
    }
}