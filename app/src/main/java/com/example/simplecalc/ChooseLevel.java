package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Proves the user the option to choose between different levels
 */
public class ChooseLevel extends AppCompatActivity {

    @Override
    /**
     * Creates and displays activity
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level);
    }

    /**
     * Starts new activity, MainActivity3_Easy (Easy Level)
     * @param obj is the button clicked
     */
    public void easyLevel(View obj)
    {
        Intent intent = new Intent(this, MainActivity3_Easy.class);
        startActivity(intent);
    }

    /**
     * Starts new activity =, MainActivity2 (Hard Level)
     * @param obj is the button clicked
     */
    public void hardLevel(View obj)
    {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}