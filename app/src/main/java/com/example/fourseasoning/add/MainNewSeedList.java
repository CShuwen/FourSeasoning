package com.example.fourseasoning.add;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


import com.example.fourseasoning.AddFragment;
import com.example.fourseasoning.MainActivity;
import com.example.fourseasoning.R;

import java.util.ArrayList;
import java.util.List;
public class MainNewSeedList extends Fragment {
    RecyclerView myrecyclerView;
    RecyclerViewAdaptor_newseedlist myAdapter;
    List<NewSeed> sampleSeeds;
    Context thiscontext;
    ImageButton btDiyPlant;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        thiscontext = container.getContext();
        btDiyPlant = view.findViewById(R.id.btDiyPlant);
        sampleSeeds = new ArrayList<>();
        //peppermint
        sampleSeeds.add(new NewSeed("Peppermint",
                        "6 Months to full maturity",
                        "Alkaline",
                        "Daily",
                        "Optional",
                        "Full Sun",
                        ""));
        //parsley
        sampleSeeds.add(new NewSeed("Parsley",
                "2 Months to Full Maturity",
                "Slightly Acidic",
                "Daily",
                "Optional",
                "Full Sun",
                ""));
        //beansprout
        sampleSeeds.add(new NewSeed("Bean Sprout",
                "6 Months to full maturity",
                "Alkaline",
                "Daily",
                "Optional",
                "Full Sun",
                ""));
        //mimosa
        sampleSeeds.add(new NewSeed("Mimosa",
                "6 Months to full maturity",
                "Alkaline",
                "Daily",
                "Optional",
                "Full Sun",
                ""));
        //catgrass
        sampleSeeds.add(new NewSeed("Cat Grass",
                "6 Months to full maturity",
                "Alkaline",
                "Daily",
                "Optional",
                "Full Sun",
                ""));
        //basil
        sampleSeeds.add(new NewSeed("Basil",
                "6 Months to full maturity",
                "Alkaline",
                "Daily",
                "Optional",
                "Full Sun",
                ""));
        //ginger
        sampleSeeds.add(new NewSeed("Ginger",
                "6 Months to full maturity",
                "Alkaline",
                "Daily",
                "Optional",
                "Full Sun",
                ""));
        //oregano
        sampleSeeds.add(new NewSeed("Oregano",
                "6 Months to full maturity",
                "Alkaline",
                "Daily",
                "Pour",
                "Full Sun",
                ""));
        //rosemary
        sampleSeeds.add(new NewSeed("Rosemary",
                "6 Months to full maturity",
                "Acidic, Neutral",
                "Daily",
                "Optional",
                "Full Sun",
                ""));
        //spadeleaf
        sampleSeeds.add(new NewSeed("Spade Leaf",
                "6 Months to full maturity",
                "Alkaline",
                "Daily",
                "Optional",
                "Full Sun",
                ""));
        //zebraplant
        sampleSeeds.add(new NewSeed("Zebra Plant",
                "6 Months to full maturity",
                "Alkaline",
                "Daily",
                "Optional",
                "Full Sun",
                ""));

        btDiyPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to the addfragment
                Fragment addFragment = new AddFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.add_container, addFragment).commit();
            }
        });

        myrecyclerView = view.findViewById(R.id.recyclerView_add_id);

        myAdapter = new RecyclerViewAdaptor_newseedlist(thiscontext, seed1,this);

        myrecyclerView.setLayoutManager(new GridLayoutManager(thiscontext, 2));

        myrecyclerView.setAdapter(myAdapter);

        return view;
    }

}
