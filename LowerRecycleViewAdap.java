package com.example.workoutapp;

import android.content.Context;
import android.content.Intent;


import androidx.annotation.NonNull;


import androidx.recyclerview.widget.RecyclerView;
import androidx.cardview.widget.CardView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class LowerRecycleViewAdap extends RecyclerView.Adapter<LowerRecycleViewAdap.MyHolder> {

    private Context aContext;
    private List<LowerTheExcersiseActivity> aData;

    public LowerRecycleViewAdap(Context aContext, List<LowerTheExcersiseActivity> aData){
        this.aContext = aContext;
        this.aData = aData;
    }



    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup vG, int i) {

        View v ;
        LayoutInflater layoutInflater = LayoutInflater.from(aContext);
        v = layoutInflater.inflate(R.layout.cardview1,vG,false);
        return  new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, final int i) {

        myHolder.exercisestitle.setText(aData.get(i).getExerciseName());
        myHolder.imageForExercises.setImageResource(aData.get(i).getImage());
        myHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aContext, LowerExActivity.class);

                intent.putExtra("ExerciseName", aData.get(i).getExerciseName());
                intent.putExtra("ExerciseDescription", aData.get(i).getExerciseDescription());
                intent.putExtra("InstructionTitle", aData.get(i).getInstructionTitle());
                intent.putExtra("InstructionStepByStep", aData.get(i).getInstructionStepByStep());
                intent.putExtra("Thumbnail", aData.get(i).getImage());

                aContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return aData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView exercisestitle;
        CardView cardView;
        ImageView imageForExercises;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            exercisestitle = (TextView)itemView.findViewById(R.id.nameOfCardviewUnderIt);
            imageForExercises = (ImageView)itemView.findViewById(R.id.imageForCardview);
            cardView = (CardView)itemView.findViewById(R.id.cardview_id);


        }
    }
}
