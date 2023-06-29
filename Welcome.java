package com.example.workoutapp;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {

    Button Park_Button, Gym_Button;
    Button Activity_three, Activity_four, Activity_five;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Gym_Button = findViewById(R.id.Gym_Button);
        Park_Button = findViewById(R.id.Park_Button);

        Activity_three = (Button) findViewById(R.id.Activity_Three_button);
        Activity_four = (Button) findViewById(R.id.Activity_Four_button);
        Activity_five = (Button) findViewById(R.id.Activity_Five_button);



        Activity_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openACTIVITY2();                                            ///NAME OF NEW ACTIVITY (REPLACE WITH ACTIVITY2 WITH NEW NAME)
            }
        });


        Activity_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openACTIVITY3();                                            ///NAME OF NEW ACTIVITY (REPLACE ACTIVITY3 WITH NEW NAME)
            }
        });


        Activity_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openACTIVITY4();                                            ///NAME OF NEW ACTIVITY (REPLACE ACTIVITY4 WITH NEW NAME)
            }
        });


        Intent intentAlarm = new Intent(this, Welcome.class);
        PendingIntent pendingAlarmIntent = PendingIntent.getBroadcast(this, 0, intentAlarm, PendingIntent.FLAG_ONE_SHOT | PendingIntent.FLAG_IMMUTABLE);
        //calls the alarm to happen
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (10 * 60 * 1000),   pendingAlarmIntent);
        Toast.makeText(this, "Take a break and hydrate!", Toast.LENGTH_LONG).show();
    }

    public void openACTIVITY2(){
        Intent intent=new Intent(this, StretchesActivity.class);
        startActivity(intent);
    }

    public void openACTIVITY3(){
        Intent intent=new Intent(this, UpperBodyActivity.class);
        startActivity(intent);
    }

    public void openACTIVITY4(){
        Intent intent=new Intent(this, LowerBodyActivity.class);
        startActivity(intent);
    }


    public void ParkNowButton (View v){
        Uri uri = Uri.parse("geo:0,0?q=Parks near me");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    public void GymNowButton (View v){
        Uri uri2 = Uri.parse("geo:0,0?q=Gyms near me");
        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
        intent2.setPackage("com.google.android.apps.maps");
        startActivity(intent2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.examplemenu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_share) {
            message();
            return true;
        } else if (id == R.id.action_info) {
            showInfo();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//}DELETE LAST ONE
    //ADDED

    private void message() {

        String message = "Come work out with me! Do you prefer outdoors or indoors?";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(intent, "Message"));
    }

    private void showInfo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Information")
                .setMessage("This app is dedicated to be your personal fitness tool that \n" +
                        "educates you on the most effective workouts for the entire human body. It consists of: \n" +
                        "1. Stretches to begin your workout" +
                        "\n2. Upper Body workouts" +
                        "\n3. Lower Body Workouts" +
                        "\nLast but not least you are able to invite friends over to workout and even find the nearest gyms or parks." +
                        "\nAll through a simple login account with us, your Lehman College Workout app.")
                .setPositiveButton("OK", null)
                .show();
    }
}


