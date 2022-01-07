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

        sampleSeeds.add(new NewSeed("Peppermint",
                        "6 Months to full maturity",
                        "Alkaline",
                        "Daily",
                        "Optional",
                        "Full Sun",
                        "",
                R.drawable.peppermint));
        sampleSeeds.add(new NewSeed("Parsley",
                "2 Months to Full Maturity",
                "Slightly Acidic",
                "Daily",
                "Optional",
                "Full Sun, Indoor",
                "",
                R.drawable.parsley));
        //beansprout
        sampleSeeds.add(new NewSeed("Bean Sprout",
                " Week to Full Maturity",
                "Neutral",
                "1 -2 times daily",
                "Mist",
                "Low Light",
                "",
                R.drawable.bean_sprout));
        //mimosa
        sampleSeeds.add(new NewSeed("Mimosa",
                "3 months to Full Maturity",
                "Acidic to Neutral (5.0-7.5)",
                "Daily",
                "Mist",
                "Bright light, some direct sunlight",
                "",
                R.drawable.mimosa));
        //catgrass
        sampleSeeds.add(new NewSeed("Cat Grass",
                "Half a Month to Full Maturity",
                "Neutral",
                "Daily",
                "Mist",
                "Leave it out of direct sunlight",
                "",
                R.drawable.catgrass));
        //basil
        sampleSeeds.add(new NewSeed("Basil",
                "10 days to Full Maturity",
                "Slightly Acidic to Slightly Alkaline",
                "Daily",
                "Pour 1 Inch",
                "Full Sun",
                "",
                R.drawable.basil));
        //ginger
        sampleSeeds.add(new NewSeed("Ginger",
                "4 - 7 Months to Full Maturity",
                "Acidic",
                "Daily",
                "Mist",
                "Full Sun",
                "",
                R.drawable.ginger));
        //oregano
        sampleSeeds.add(new NewSeed("Oregano",
                "1.5 Months to Full Maturity",
                "Slightly Acidic to Neutral (6.5 to 7.0)",
                "Daily",
                "Mist",
                "Full Sun",
                "",
                R.drawable.oregano));
        //rosemary
        sampleSeeds.add(new NewSeed("Rosemary",
                "6 - 12 Months to Full Maturity",
                "Acidic, Neutral (6.0 to 7.0)",
                "Daily",
                "Pour",
                "Full Sun",
                "",
                R.drawable.rosemary));
        //spadeleaf
        sampleSeeds.add(new NewSeed("Spade Leaf",
                "3 Months to full maturity",
                "Neutral to Slightly Alkaline (6-7.8)",
                "Daily",
                "Mist",
                "4 - 6 Hours Of Full Sun",
                "",
                R.drawable.spadeleaf));
        //zebraplant
        sampleSeeds.add(new NewSeed("Zebra Plant",
                "6 Months to full maturity",
                "Neutral",
                "Water when the top nch of soil has dried out",
                "Pour",
                "4 - 6 hours of non-direct Sunlight",
                "",
                R.drawable.zebraplant));
        seed1.add(new NewSeed("Parsley", "Soil Condition : Slightly Acidic\n"
                + "water frequency : daily / Once per 24 Hours\n"
                + "water method : pour\n"
                + "preferred location : Full Sun, Indoor",
                "Life Cycle",
                "2 Months to Full Maturity", R.drawable.parsley));
        seed1.add(new NewSeed("Bean Sprout", "Soil Condition : Neutral\n"
                + "water frequency : 1 -2 times daily / Once or Twice per 24 Hours\n"
                + "water method : Mist\n"
                + "preferred location : Low Light",
                "Life Cycle",
                "A Week to Full Maturity", R.drawable.bean_sprout));
        seed1.add(new NewSeed("Mimosa", "Soil Condition : Acidic to Neutral (5.0-7.5)\n"
                + "water frequency : Daily\n"
                + "water method : Mist\n"
                + "preferred location : Bright light, some direct sunlight",
                "Life Cycle",
                "Three months to Full Maturity", R.drawable.mimosa));
        seed1.add(new NewSeed("Cat Grass", "Soil Condition : Neutral \n"
                + "water frequency : Daily\n"
                + "water method : Mist\n"
                + "preferred location : Leave it out of direct sunlight",
                "Life Cycle",
                "Half a Month to Full Maturity", R.drawable.catgrass));
        seed1.add(new NewSeed("Basil", "Soil Condition : Slightly Acidic to Slightly Alkaline\n"
                + "water frequency : Daily\n"
                + "water method : Pour 1 Inch\n"
                + "preferred location : Full Sun\n",
                "Life Cycle",
                "10 days to Full Maturity", R.drawable.basil));
        seed1.add(new NewSeed("Ginger", "Soil Condition : Acidic\n"
                + "water frequency : Daily\n"
                + "water method : Mist\n"
                + "preferred location : Full Sun\n",
                "Life Cycle",
                "4 - 7 Months to Full Maturity", R.drawable.ginger));
        seed1.add(new NewSeed("Oregano", "Soil Condition : Slightly Acidic to Neutral (6.5 to 7.0)\n"
                + "water frequency : Daily\n"
                + "water method : Mist\n"
                + "preferred location : Full Sun\n",
                "Life Cycle",
                "1.5 Months to Full Maturity", R.drawable.oregano));
        seed1.add(new NewSeed("rosemary", "Soil Condition : Acidic, neutral (6.0 to 7.0)\n"
                + "water frequency : Daily\n"
                + "water method : Pour\n"
                + "preferred location : Full Sun\n",
                "Life Cycle",
                "6 - 12 Months to Full Maturity", R.drawable.rosemary));
        seed1.add(new NewSeed("Spade Leaf", "Soil Condition : Neutral to Slightly Alkaline (6-7.8)\n"
                + "water frequency : Daily\n"
                + "water method : Mist\n"
                + "preferred location : 4 - 6 Hours Of Full Sun\n",
                "Life Cycle",
                "3 Months to Full Maturity", R.drawable.spadeleaf));
        seed1.add(new NewSeed("Zebra Plant", "Soil Condition : Neutral\n"
                + "water frequency :  Water when the top nch of soil has dried out\n"
                + "water method : Pour\n"
                + "preferred location : 4 - 6 hours of non-direct Sunlight\n",
                "Life Cycle",
                "6 Months to Full Maturity", R.drawable.zebraplant));
        btDiyPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to the addfragment
                Fragment addFragment = new AddFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.add_container, addFragment).commit();
            }
        });

        myrecyclerView = view.findViewById(R.id.recyclerView_add_id);

        myAdapter = new RecyclerViewAdaptor_newseedlist(thiscontext, sampleSeeds,this);

        myrecyclerView.setLayoutManager(new GridLayoutManager(thiscontext, 2));

        myrecyclerView.setAdapter(myAdapter);

        return view;
    }

}
