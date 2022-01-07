package com.example.fourseasoning.add;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fourseasoning.R;

import java.util.List;

public class RecyclerViewAdaptor_newseedlist extends RecyclerView.Adapter<RecyclerViewAdaptor_newseedlist.MyHolder> {
    private Context mContext;
    private List<NewSeed> mData;

    public RecyclerViewAdaptor_newseedlist(Context mContext, List<NewSeed> mData){
        this.mContext = mContext;
        this.mData = mData;
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
                Intent intent = new Intent(mContext, SeedActivity.class);

                intent.putExtra("SeedName", mData.get(i).getSeedName());
                intent.putExtra("SeedCondition", mData.get(i).getSeedCondition());
                intent.putExtra("LifeCycleTitle", mData.get(i).getLifeCycleTitle());
                intent.putExtra("SeedLifeCycle", mData.get(i).getSeedLifeCycle());
                intent.putExtra("Thumbnail", mData.get(i).getThumbnail());

                mContext.startActivity(intent);
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
