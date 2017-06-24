package com.dharani.navigationdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dharani.navigationdemo.data.AndroidVersion;
import com.dharani.navigationdemo.activity.ProductListActivity;
import com.dharani.navigationdemo.R;
import com.dharani.navigationdemo.fragment.HomeFragment;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private ArrayList<AndroidVersion> android;
    private String[] dataSet;
    private String[] image;
    Context context;
    AndroidVersion av;

    public HomeAdapter(String [] data,String[] image) {
        this.dataSet = data;
        this.image = image;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_adapter,parent,false);
        view.setOnClickListener(HomeFragment.myOnClickListener);
        ViewHolder vHolder = new ViewHolder(view);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvAndroid.setText(dataSet[position].toString());
//        Picasso.with(context)
//                .load(dataSet[position])
//                .resize(140,120)
//                .into(holder.imgAndroid);
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvAndroid;
        private ImageView imgAndroid;
        Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            context =  itemView.getContext();
            tvAndroid = (TextView)itemView.findViewById(R.id.textView_ID);
            imgAndroid = (ImageView)itemView.findViewById(R.id.imageView_ID);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Clicked item !!"+getPosition(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,ProductListActivity.class);
                    intent.putExtra("pos",getPosition());
                    context.startActivity(intent);
                }
            });

        }
    }
}
