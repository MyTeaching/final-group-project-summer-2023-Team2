package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LowerExActivity extends AppCompatActivity {


    private TextView aExerciseName;
    private TextView aExerciseDescription;
    private TextView aInstructionTitle;
    private TextView aInstructionStepByStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower_ex);

        aExerciseName = (TextView)findViewById(R.id.exercisename);
        aExerciseDescription = (TextView)findViewById(R.id.exercisedescription);
        aInstructionTitle = (TextView)findViewById(R.id.instructiontitle);
        aInstructionStepByStep = (TextView)findViewById(R.id.instructionstepbystep);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("ExerciseName");
        String Descrip = intent.getExtras().getString("ExerciseDescription");
        String otherTitle = intent.getExtras().getString("InstructionTitle");
        String stepByStep = intent.getExtras().getString("InstructionStepByStep");

        aExerciseName.setText(Title);
        aExerciseDescription.setText(Descrip);
        aInstructionTitle.setText(otherTitle);
        aInstructionStepByStep.setText(stepByStep);

    }
}

