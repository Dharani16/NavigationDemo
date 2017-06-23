package com.dharani.navigationdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private ArrayList<AndroidVersion> android;
    private String[] dataSet;
    private Context context;
    AndroidVersion av;

    public HomeAdapter(Context context, ArrayList<AndroidVersion> android) {
        this.android = android;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_adapter,parent,false);
        ViewHolder vHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context,""+android.get(0).getAndroidVersionName() , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,ElectronicsProduct.class);
                context.startActivity(intent);
            }
        });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvAndroid.setText(android.get(position).getAndroidVersionName());
        Picasso.with(context)
                .load(android.get(position).getAndroidImage())
                .resize(140,120)
                .into(holder.imgAndroid);
    }

    @Override
    public int getItemCount() {
        return android.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvAndroid;
        private ImageView imgAndroid;

        public ViewHolder(View itemView) {
            super(itemView);
            tvAndroid = (TextView)itemView.findViewById(R.id.textView_ID);
            imgAndroid = (ImageView)itemView.findViewById(R.id.imageView_ID);

        }
    }
}
