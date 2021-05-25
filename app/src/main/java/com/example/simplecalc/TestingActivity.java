package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TestingActivity extends AppCompatActivity {

    @Override
    /**
     * Create and display the activity
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
    }
    protected void onResume() {
        super.onResume();
    }
    protected void onPause() {
        super.onPause();
    }

    /**
     * Launches the 'MainActity' activity
     * @param obj is the button clicked
     */
    public void launchActivity(View obj)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    /**
     * Launches the 'ChooseLevel' activity
     * @param obj is the button clicked
     */
    public void launchActivity2(View obj)
    {
        Intent intent = new Intent(this,ChooseLevel.class);
        startActivity(intent);
    }
}