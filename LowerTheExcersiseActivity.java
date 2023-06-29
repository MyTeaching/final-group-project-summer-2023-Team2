package com.example.workoutapp;

public class LowerTheExcersiseActivity {

    private String ExerciseName;
    private String ExerciseDescription;
    private String InstructionTitle;
    private String InstructionStepByStep;
    private int Image;


    public LowerTheExcersiseActivity(String name, String exerciseDescription, String instructionTitle, String instructionStepByStep, int image){

        ExerciseName = name;
        ExerciseDescription = exerciseDescription;
        InstructionTitle = instructionTitle;
        InstructionStepByStep = instructionStepByStep;
        Image = image;

    }


    public  String getExerciseName(){

        return ExerciseName;
    }
    public String getExerciseDescription(){
        return ExerciseDescription;
    }

    public String getInstructionTitle(){
        return InstructionTitle;
    }

    public String getInstructionStepByStep(){
        return InstructionStepByStep;
    }

    public int getImage(){
        return Image;
    }
}
