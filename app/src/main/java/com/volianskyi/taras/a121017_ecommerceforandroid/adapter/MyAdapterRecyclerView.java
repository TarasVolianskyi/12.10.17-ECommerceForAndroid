package com.volianskyi.taras.a121017_ecommerceforandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.volianskyi.taras.a121017_ecommerceforandroid.R;


import java.util.ArrayList;

/**
 * Created by tarasvolianskyi on 28.10.17.
 */

public class MyAdapterRecyclerView extends RecyclerView.Adapter {
    private ArrayList<String> data;
    private Context context;

    public MyAdapterRecyclerView(ArrayList<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.images_layout, parent, false);
        return new MyRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyRecyclerViewHolder myHolder = (MyRecyclerViewHolder) holder;
        myHolder.tvName.setText(data.get(position));
        Picasso.with(context).load(data.get(position)).into(myHolder.ivPictureOfItem);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public ImageView ivPictureOfItem;

        public MyRecyclerViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tvImageItems);
            ivPictureOfItem = (ImageView) view.findViewById(R.id.ivImageItems);
        }
    }
}
