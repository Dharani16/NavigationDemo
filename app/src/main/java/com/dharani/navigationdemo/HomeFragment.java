package com.dharani.navigationdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

import static com.dharani.navigationdemo.MyData.productImage;
import static com.dharani.navigationdemo.MyData.productName;

public class HomeFragment extends Fragment {
    View view;
    ViewFlipper viewFlipper;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
//    int flipperImages[] = {R.drawable.ecommerce,R.drawable.electronics,R.drawable.furniture};

//    private final String productName[] = {
//            "Electronics",
//            "Home Appliances",
//            "Furnitures",
//            "Home Appliances",
//            "Furnitures",
//            "Dress"};
//
//    private final String productImage[] = {
//            "http://api.androidhive.info/json/movies/1.jpg",
//            "http://api.androidhive.info/json/movies/1.jpg",
//            "http://api.androidhive.info/json/movies/1.jpg",
//            "http://api.androidhive.info/json/movies/1.jpg",
//            "http://api.androidhive.info/json/movies/1.jpg",
//            "http://api.androidhive.info/json/movies/1.jpg"
//    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);
        viewFlipper = (ViewFlipper)view.findViewById(R.id.viewFlipper_ID);
        collapsingToolbarLayout = (CollapsingToolbarLayout)view.findViewById(R.id.collapsingToolbar);

        for (int i = 0; i < MyData.flipperImages.length; i++){
            setFlipperImage(MyData.flipperImages[i]);
        }
        initViews();
        return view;
    }

    private void initViews() {
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView_ID);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<AndroidVersion> android_version = new ArrayList<>();
        for (int i = 0; i < productName.length; i++) {
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroidVersionName(productName[i]);
            androidVersion.setAndroidImage(productImage[i]);
            android_version.add(androidVersion);
        }

        HomeAdapter adapter = new HomeAdapter(getActivity(), android_version);
        recyclerView.setAdapter(adapter);
    }

    private void setFlipperImage(int image) {
        ImageView img = new ImageView(getActivity());
        img.setBackgroundResource(image);
        viewFlipper.addView(img);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(3000);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Ecommerce App");
    }
}
