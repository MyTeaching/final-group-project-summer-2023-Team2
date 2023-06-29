package com.example.workoutapp;

public class ArmExercise {
    private String name;
    private String description;
    private int imageResource;
    private String difficulty;
    private String reps;
    private String videoUrl;


    public ArmExercise(String name, String description, int imageResource, String difficulty, String reps, String videoUrl) {
        this.name = name;
        this.description = description;
        this.imageResource = imageResource;
        this.difficulty = difficulty;
        this.reps = reps;
        this.videoUrl = videoUrl;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getImageResource(){
        return imageResource;
    }

    public String getDifficulty(){
        return difficulty;
    }

    public String getReps() {
        return reps;
    }

    public String getVideoUrl(){
        return videoUrl;
    }
}
