package com.example.workoutapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class StretchesActivity extends AppCompatActivity {



    public static final int TEXT_REQUEST =1;
    RecyclerView dataList;
    List<String> titles;
    List <Integer> images;
    AdapterStretches adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretches);
        dataList = findViewById(R.id.dataList);

        Log.d("Stretches MAIN"," ENTERING !!");

        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("Upper Body Stretches");
        titles.add("Lower Body Stretches");
        titles.add("Dynamic Stretches");
        titles.add("Static Stretches");

        images.add(R.drawable.img_upper01);
        images.add(R.drawable.img_lower);
        images.add(R.drawable.img_dynamic1);
        images.add(R.drawable.img_static1);


        adapter = new AdapterStretches(this, titles, images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1,GridLayoutManager.VERTICAL, false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);
        Log.d("Stretches MAIN"," finish !!");

    }




}