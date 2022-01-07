package com.example.fourseasoning;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;
public class MainNewSeedList extends Fragment {
    RecyclerView myrecyclerView;
    RecyclerViewAdaptor_newseedlist myAdapter;
    List<NewSeed> seed1;
    Context thiscontext;
    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        seed1 = new ArrayList<>();
        seed1.add(new NewSeed("Peppermint", "Soil Condition : Alkaline\n"
                + "water frequency : daily / Once per 24 Hours\n"
                + "water method : optional\n"
                + "preferred location : Full Sun",
                "Life Cycle",
                "6 Months to Full Maturity", R.drawable.peppermint));
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

        myrecyclerView = view.findViewById(R.id.recyclerView_id);

        myAdapter = new RecyclerViewAdaptor_newseedlist(thiscontext, seed1);

        myrecyclerView.setLayoutManager(new GridLayoutManager(thiscontext, 2));

        myrecyclerView.setAdapter(myAdapter);

        return view;
    }
    }
}
