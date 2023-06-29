package com.example.workoutapp;

import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import androidx.appcompat.app.AppCompatActivity;

public class LowerBodyActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    LowerRecycleViewAdap Adapter;

    List<LowerTheExcersiseActivity> exercises;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower);


        exercises = new ArrayList<>();
        exercises.add(new LowerTheExcersiseActivity("Reverse lunge",
                "With a reverse lunge, you'll be stepping backward with one of your legs, says Tamir. You bend your back leg so your back knee will nearly touch the ground, and your front knee so your thigh is about parallel to the ground. Your front, planted leg is the one that will be working.",
                "Instruction",
                "1. Stand upright, with your hands at your hips.\n" +
                        "\n" +
                        "2. Take a large step backward with your left foot.\n" +
                        "\n" +
                        "3. Lower your hips so that your right thigh (front leg) becomes parallel to the floor with your right knee positioned directly over your ankle. Your left knee should be bent at a 90-degree angle and pointing toward the floor with your left heel lifted.\n" +
                        "\n" +
                        "4. Return to standing by pressing your right heel into the floor and bringing your left leg forward to complete one rep.\n" +
                        "\n" +
                        "5. Alternate legs, and step back with right leg.",R.drawable.img_reverselunge));


        exercises.add(new LowerTheExcersiseActivity("Squat",
                "A squat is a strength exercise in which the trainee lowers their hips from a standing position and then stands back up. During the descent, the hip and knee joints flex while the ankle joint dorsiflexes; conversely the hip and knee joints extend and the ankle joint plantarflexes when standing up.",
                "Instruction",
                "1. Stand with feet a little wider than hip width, toes facing front.\n" +
                        "\n" +
                        "2. Drive your hips back—bending at the knees and ankles and pressing your knees slightly open—as you…\n" +
                        "\n" +
                        "3. Sit into a squat position while still keeping your heels and toes on the ground, chest up and shoulders back.\n" +
                        "\n" +
                        "4. Strive to eventually reach parallel, meaning knees are bent to a 90-degree angle.\n" +
                        "\n" +
                        "5. Press into your heels and straighten legs to return to a standing upright position.",R.drawable.img_squat));


        exercises.add(new LowerTheExcersiseActivity("Glute Bridge",
                "A glute bridge is a physical exercise that helps to strengthen the gluteus muscles (located in your buttocks) and hamstrings. Glute bridges are done by laying on your back with both feet planted on the ground and lifting your pelvis. It can help to increase hip flexibility and lower back health.",
                "Instruction",
                "1. Lie on your back with your hands by your sides and your knees bent.\n" +
                        "\n" +
                        "2. Lift your hips off the mat, while keeping your back straight, and pause for 1 second.\n" +
                        "\n" +
                        "3. Return to the starting position and repeat the movement until the set is complete.",R.drawable.img_glutebridge));



        exercises.add(new LowerTheExcersiseActivity("Single Leg Deadlift",
                "The single-leg deadlift (SLDL) is an exercise characterized by a forward hip-hinge movement while lifting one leg off the ground and extending it backwards. Single-leg deadlifts work muscle groups in your posterior chain, including your calf muscles, lower back muscles, hamstrings, and glutes.",
                "Instruction",
                "1. Stand on one leg with your knee slightly bent and hold a dumbbell in each hand.\n" +
                        "\n" +
                        "2. Start bending at the hips and extend your free leg behind you.\n" +
                        "\n" +
                        "3. Lower your torso until you're parallel to the floor.\n" +
                        "\n" +
                        "4. Return to the starting position and repeat with the opposite leg.",R.drawable.img_singlelegdeadlift));


        exercises.add(new LowerTheExcersiseActivity("Calf Raises",
                "The calf raise, also known as the standing calf raise, is a bodyweight exercise that targets the muscle groups in your lower legs. Perform calf raises by standing tall with your feet hip-width apart. Lift your body by pushing into the fronts of your feet, activating your calf muscles as you stand on your tiptoes.",
                "Instruction",
                "1. Stand with your torso upright, your feet hip-width apart, and your toes pointing forward.\n" +
                        "\n" +
                        "2. Raise your heels off the floor and squeeze your calves.\n" +
                        "\n" +
                        "3. Return to the starting position, by slowly lowering your heels, and repeat.",R.drawable.img_calfraises));



        recyclerView = (RecyclerView)findViewById(R.id.recyclerView_id);

        Adapter = new LowerRecycleViewAdap(this, exercises);

        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        recyclerView.setAdapter(Adapter);



    }

}