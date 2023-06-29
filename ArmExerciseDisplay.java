package com.example.workoutapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ArmExerciseDisplay extends AppCompatActivity {
    private TextView exerciseTitle;
    private TextView exerciseDes;
    private TextView exerciseDifficulty;
    private TextView exerciseReps;
    private TextView exerciseVideo;
    private ImageView imageExercise;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_exercise_display);

        Intent intent = getIntent();
        String Title = intent.getStringExtra("exercise_name");
        String Des = intent.getStringExtra("description");
        String Reps = intent.getStringExtra("reps");
        String Difficulty = intent.getStringExtra("difficulty");
        String Video = intent.getStringExtra("video");
        int imgExercise = intent.getIntExtra("exercise_image", 0);

        exerciseTitle = findViewById(R.id.exercise_title);
        imageExercise = findViewById(R.id.image_exercise);
        exerciseDes = findViewById(R.id.exercise_description);
        exerciseDifficulty = findViewById(R.id.exercise_difficulty);
        exerciseReps = findViewById(R.id.exercise_reps);
        exerciseVideo = findViewById(R.id.exercise_video);


        exerciseTitle.setText(Title);
        exerciseDes.setText(Des);
        exerciseReps.setText(Reps);
        exerciseDifficulty.setText(Difficulty);
        imageExercise.setImageResource(imgExercise);
        exerciseVideo.setText(Video);

        exerciseVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent website = new Intent(Intent.ACTION_VIEW);
                Uri link = Uri.parse(Video);
                website.setData(link);
                startActivity(website);

            }
        });
    }
}