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
    private TextView mSeedName;
    private TextView mSeedCondition;
    private TextView mLifeCycleTitle;
    private TextView mSeedLifeCycle;
    Context thisContext;
    Button btStartPlanting;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.infopage_newseed, container, false);
        thisContext = container.getContext();

        Bundle args = getArguments();

        String seedName = args.getString("SeedName");
        String seedCondition = args.getString("SeedCondition");
        String lifeCycleTitle = args.getString("LifeCycleTitle");
        String seedLifeCycle = args.getString("SeedLifeCycle");



        mSeedName = view.findViewById(R.id.SeedName);
        mSeedCondition = view.findViewById(R.id.Conditions);
        mLifeCycleTitle = view.findViewById(R.id.LifeCycleTitle);
        mSeedLifeCycle = view.findViewById(R.id.LifeCycle);
        btStartPlanting = view.findViewById(R.id.btStartPlanting);

        mSeedName.setText(seedName);
        mSeedCondition.setText(seedCondition);
        mLifeCycleTitle.setText(lifeCycleTitle);
        mSeedLifeCycle.setText(seedLifeCycle);
        return view;
    }
    }
