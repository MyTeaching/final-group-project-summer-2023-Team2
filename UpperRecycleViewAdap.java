package com.example.workoutapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class UpperRecycleViewAdap extends RecyclerView.Adapter<UpperRecycleViewAdap.ViewHolder> {
    private ArrayList<ArmExercise> exercises;
    private Context context;


    public UpperRecycleViewAdap(Context context, ArrayList<ArmExercise>exercisesArrayList) {
        this.context = context;
        exercises = exercisesArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder((LayoutInflater.from(context).inflate(R.layout.activity_arm_exercise, parent, false)));

    }

    @Override
    public void onBindViewHolder(@NonNull UpperRecycleViewAdap.ViewHolder holder, int position) {
        ArmExercise currExercise = exercises.get(position);
        holder.bindItem(currExercise);
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textTitle, textInfo;
        private ImageView imageViewExercise ;
        public ViewHolder(View exerciseView) {
            super(exerciseView);
            textTitle = exerciseView.findViewById(R.id.exercise_title);
            textInfo = exerciseView.findViewById(R.id.exercise_description);
            imageViewExercise = exerciseView.findViewById(R.id.image_exercise);
            exerciseView.setOnClickListener(this);

        }

            /*
            exerciseView.setOnLongClickListener(v -> {
                removeItemDialouge(getAdapterPosition());
                return true;
            });
        }

        public void removeItemDialouge(int position){
            AlertDialog.Builder build = new AlertDialog.Builder(context);
            build.setTitle("Remove Item").setMessage("Would you like to remove this meal item?").setPositiveButton("Remove", (dialog, which) -> removeItem(position)).setNegativeButton("No", (dialog, which) -> dialog.dismiss());
            build.show();
        }

        public void removeItem(int position){
            exercises.remove(position);
            notifyItemRemoved(position);
        }

             */

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            ArmExercise clickedExercise = exercises.get(position);
            Intent intent = new Intent(context, ArmExerciseDisplay.class);
            intent.putExtra("exercise_name", clickedExercise.getName());
            intent.putExtra("description", clickedExercise.getDescription());
            intent.putExtra("difficulty", clickedExercise.getDifficulty());
            intent.putExtra("reps", clickedExercise.getReps());
            intent.putExtra("video", clickedExercise.getVideoUrl());
            intent.putExtra("exercise_image", clickedExercise.getImageResource());
            context.startActivity(intent);
        }

        public void bindItem(ArmExercise currentExercise){
            textTitle.setText(currentExercise.getName());
            textInfo.setText(currentExercise.getDescription());
            Glide.with(context).load(currentExercise.getImageResource()).into(imageViewExercise);
        }
    }
}