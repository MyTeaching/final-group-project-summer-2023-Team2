package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayStretches extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display_stretches);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ImageView gridIcon = findViewById(R.id.imageView);
            String name = bundle.getString("Testing");
            String details = bundle.getString("details");

            if (name.equals("Upper Body Stretches")) {
                TextView mName = findViewById(R.id.nameExer);
                TextView mDetails = findViewById(R.id.exerDetails);
                mName.setText(name);
                mDetails.setText(R.string.how_to_1);
            }
            else if (name.equals("Lower Body Stretches")) {

                TextView mName = findViewById(R.id.nameExer);
                TextView mDetails = findViewById(R.id.exerDetails);
                mName.setText(name);
                mDetails.setText(R.string.how_to_2);
            }
            else if (name.equals("Dynamic Stretches")) {

                TextView mName = findViewById(R.id.nameExer);
                TextView mDetails = findViewById(R.id.exerDetails);
                mName.setText(name);
                mDetails.setText(R.string.how_to_3);
            }
            else if (name.equals("Static Stretches")) {

                TextView mName = findViewById(R.id.nameExer);
                TextView mDetails = findViewById(R.id.exerDetails);
                mName.setText(name);
                mDetails.setText(R.string.how_to_4);
            }

        }


    }
}