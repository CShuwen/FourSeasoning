package com.example.fourseasoning.add;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fourseasoning.MainActivity;
import com.example.fourseasoning.R;

import java.util.List;

public class RecyclerViewAdaptor_newseedlist extends RecyclerView.Adapter<RecyclerViewAdaptor_newseedlist.MyHolder> {
    private Context mContext;
    private List<NewSeed> mData;
    private Fragment fragment;

    public RecyclerViewAdaptor_newseedlist(Context mContext, List<NewSeed> mData, Fragment fragment){
        this.mContext = mContext;
        this.mData = mData;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_newseedlist, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i) {

        myHolder.seedName.setText(mData.get(i).getSeedName());
        myHolder.img_seed_thumbnail.setImageResource(mData.get(i).getThumbnail());
        myHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                Fragment newFragment = new SeedFragment();
                bundle.putString("SeedName", mData.get(i).getSeedName());
                bundle.putString("SeedCondition", mData.get(i).getSeedCondition());
                bundle.putString("LifeCycleTitle", mData.get(i).getLifeCycleTitle());
                bundle.putString("SeedLifeCycle", mData.get(i).getSeedLifeCycle());
                bundle.putInt("Thumbnail", mData.get(i).getThumbnail());
                newFragment.setArguments(bundle);
                FragmentTransaction transaction = fragment.getFragmentManager().beginTransaction();
                transaction.replace(R.id.add_container,newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount(){
        return mData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView seedName;
        CardView cardView;
        ImageView img_seed_thumbnail;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            seedName = itemView.findViewById(R.id.text_newseed_id);
            cardView = itemView.findViewById(R.id.cardview_newseedlistid);
            img_seed_thumbnail = (ImageView)itemView.findViewById(R.id.newseed_img_id);
        }
    }


}
