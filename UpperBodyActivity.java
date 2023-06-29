package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class UpperBodyActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<ArmExercise> exercises;
    private UpperRecycleViewAdap recyclerViewAdapter;

    private String title;
    private String description;
    private String ingredients;
    private String recipe;
    private String calories;

    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_upper_body);
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        exercises = new ArrayList<>();
        recyclerViewAdapter = new UpperRecycleViewAdap(this, exercises);
        recyclerView.setAdapter(recyclerViewAdapter);
        loadExerciseData();





    }

    private void loadExerciseData() {
        String[] exerciseName = getResources().getStringArray(R.array.exercise_name);
        TypedArray exerciseImage = getResources().obtainTypedArray(R.array.exercise_image);
        String[] exerciseDifficulty = getResources().getStringArray(R.array.difficulty);
        String[] exerciseReps = getResources().getStringArray(R.array.reps);
        String[] exerciseVideo = getResources().getStringArray(R.array.video);
        String[] exerciseDescription = getResources().getStringArray(R.array.description);


        for(int i=0; i < exerciseName.length; i++){
            exercises.add(new ArmExercise(exerciseName[i], exerciseDescription[i], exerciseImage.getResourceId(i,0), exerciseDifficulty[i], exerciseReps[i], exerciseVideo[i]));
        }
        recyclerViewAdapter.notifyDataSetChanged();
        exerciseImage.recycle();

    }



}