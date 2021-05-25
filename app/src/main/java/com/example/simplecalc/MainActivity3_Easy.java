package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
/**
 * Is the easy level of tic-tac-toe versus the AI
 */
public class MainActivity3_Easy extends AppCompatActivity {

    private boolean hasWon = false; // becomes true when a winner is found, thus allows for the watermelons to be outputted
    private boolean whoWon = false; // helps determine if either the player or the AI won
    private boolean haveWinner = false; // ensures that no other buttons can be clicked when a winner is found

    private int player1Score = 0;// contains player's score
    private int aiScore = 0; // contains the AI's score
    @Override
    /**
     * Create and display the activity
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3__easy);
    }
    /**
     * Restarts the game, clears all the buttons of any text.
     * The score is not changed, typically used for ties.
     * @param obj is the button clicked
     */
    public void theNewGame(View obj)
    {
        // reseting all the buttons
        Button button1 = findViewById(R.id.button1_easy);
        button1.setText("");
        Button button2 = findViewById(R.id.button2_easy);
        button2.setText("");
        Button button3 = findViewById(R.id.button3_easy);
        button3.setText("");
        Button button4 = findViewById(R.id.button4_easy);
        button4.setText("");
        Button button5 = findViewById(R.id.button5_easy);
        button5.setText("");
        Button button6 = findViewById(R.id.button6_easy);
        button6.setText("");
        Button button7 = findViewById(R.id.button7_easy);
        button7.setText("");
        Button button8 = findViewById(R.id.button8_easy);
        button8.setText("");
        Button button9 = findViewById(R.id.button9_easy);
        button9.setText("");
        hasWon = false;
        whoWon = false;
        haveWinner = false;
    }
    /**
     * Resets the table, clears all the buttons and the score
     * @param obj is the button clicked
     */
    public void resetScore(View obj)
    {
        // reseting score
        TextView player1 = findViewById(R.id.player_easy);
        player1.setText("Player: 0");
        TextView player2 = findViewById(R.id.player2_easy);
        player2.setText("AI: 0");

        // reseting all the buttons
        Button button1 = findViewById(R.id.button1_easy);
        button1.setText("");
        Button button2 = findViewById(R.id.button2_easy);
        button2.setText("");
        Button button3 = findViewById(R.id.button3_easy);
        button3.setText("");
        Button button4 = findViewById(R.id.button4_easy);
        button4.setText("");
        Button button5 = findViewById(R.id.button5_easy);
        button5.setText("");
        Button button6 = findViewById(R.id.button6_easy);
        button6.setText("");
        Button button7 = findViewById(R.id.button7_easy);
        button7.setText("");
        Button button8 = findViewById(R.id.button8_easy);
        button8.setText("");
        Button button9 = findViewById(R.id.button9_easy);
        button9.setText("");
        hasWon = false;
        whoWon = false;
        haveWinner = false;
        player1Score = 0;
        aiScore = 0;
    }

    /**
     * Every time the player clicks a button this method is called. Outputs the users
     * choice while also displaying the ai's move.
     * @param obj is the button that is clicked
     */
    public void buttonClicked(View obj)
    {
        // if there is no winner then allow for new moved to be made
        if(!haveWinner)
        {
            Button buttonText = (Button) obj;
            String text = buttonText.getText().toString();
            // check if button has already been clicked
            if (text.equals("")) {
                buttonText.setText("X");
            } else {
                return;
            }
            // obtain next move
            int position = findNextMove();
            // check if there is a winner
            int winner = checkIfWinner();

            Button button1 = findViewById(R.id.button1_easy);
            Button button2 = findViewById(R.id.button2_easy);
            Button button3 = findViewById(R.id.button3_easy);
            Button button4 = findViewById(R.id.button4_easy);
            Button button5 = findViewById(R.id.button5_easy);
            Button button6 = findViewById(R.id.button6_easy);
            Button button7 = findViewById(R.id.button7_easy);
            Button button8 = findViewById(R.id.button8_easy);
            Button button9 = findViewById(R.id.button9_easy);

            if (!hasWon) {
                switch (position) {
                    case 1:
                        button1.setText("O");
                        break;
                    case 2:
                        button2.setText("O");
                        break;
                    case 3:
                        button3.setText("O");
                        break;
                    case 4:
                        button4.setText("O");
                        break;
                    case 5:
                        button5.setText("O");
                        break;
                    case 6:
                        button6.setText("O");
                        break;
                    case 7:
                        button7.setText("O");
                        break;
                    case 8:
                        button8.setText("O");
                        break;
                    case 9:
                        button9.setText("O");
                        break;
                }
                // if AI wins
                int val2 = checkIfWinner();
                if (val2 != 0) {
                    whoWon = true;
                    haveWinner = true;
                    displayWalermelons(obj, val2, whoWon);
                }
            }
            // if user wins
            else {
                displayWalermelons(obj, winner, whoWon);
            }
        }
    }

    /**
     * Returns a random position, as the AI's choice
     * @return integer will be the desired position (1-9)
     */
    public int findNextMove()
    {
        ArrayList<Integer> arr = new ArrayList<>();
        // must check available spots
        arr = avaliableSpaces();

        //choose one of those available spots randomly
        int index = (int)( Math.random() * arr.size());
        Log.d("WOW", String.valueOf(index) + "----Size:" + arr.size());
        int position = 0;
        if(!arr.isEmpty())
        {
            position = arr.get(index);
        }
        // if not empty return value, else return 0
        if(!arr.isEmpty())
        {
            return position;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Checks for any available spaces left on the board
     * @return an array contains the index of the buttons left (1-9)
     */
    public ArrayList<Integer> avaliableSpaces()
    {
        ArrayList<Integer> arr = new ArrayList<>();
        Button button1 = findViewById(R.id.button1_easy);
        Button button2 = findViewById(R.id.button2_easy);
        Button button3 = findViewById(R.id.button3_easy);
        Button button4 = findViewById(R.id.button4_easy);
        Button button5 = findViewById(R.id.button5_easy);
        Button button6 = findViewById(R.id.button6_easy);
        Button button7 = findViewById(R.id.button7_easy);
        Button button8 = findViewById(R.id.button8_easy);
        Button button9 = findViewById(R.id.button9_easy);

        if(button1.getText().toString() == "")
        {
            arr.add(1);
        }
        if(button2.getText().toString() == "")
        {
            arr.add(2);
        }
        if(button3.getText().toString() == "")
        {
            arr.add(3);
        }
        if(button4.getText().toString() == "")
        {
            arr.add(4);
        }
        if(button5.getText().toString() == "")
        {
            arr.add(5);
        }
        if(button6.getText().toString() == "")
        {
            arr.add(6);
        }
        if(button7.getText().toString() == "")
        {
            arr.add(7);
        }
        if(button8.getText().toString() == "")
        {
            arr.add(8);
        }
        if(button9.getText().toString() == "")
        {
            arr.add(9);
        }
        return arr;
    }

    /**
     * Checks if there is a winner, if a winner is found, it will
     * return an integer value that represents the line of buttons that
     * won.
     * @return an integer that represents a line of buttons that won, or 0 if no winner
     */
    public int checkIfWinner()
    {
        String value1 = ((TextView) findViewById(R.id.button1_easy)).getText().toString() + ((TextView) findViewById(R.id.button2_easy)).getText().toString()
                + ((TextView) findViewById(R.id.button3_easy)).getText().toString();
        if (value1.equals("XXX") || value1.equals("OOO")) {
            hasWon = true;
            return 1;
        }
        String value2 = ((TextView) findViewById(R.id.button4_easy)).getText().toString() + ((TextView) findViewById(R.id.button5_easy)).getText().toString()
                + ((TextView) findViewById(R.id.button6_easy)).getText().toString();
        if (value2.equals("XXX") || value2.equals("OOO")) {
            hasWon = true;
            return 2;
        }
        String value3 = ((TextView) findViewById(R.id.button7_easy)).getText().toString() + ((TextView) findViewById(R.id.button8_easy)).getText().toString()
                + ((TextView) findViewById(R.id.button9_easy)).getText().toString();
        if (value3.equals("XXX") || value3.equals("OOO")) {
            hasWon = true;
            return 3;
        }
        String value4 = ((TextView) findViewById(R.id.button1_easy)).getText().toString() + ((TextView) findViewById(R.id.button4_easy)).getText().toString()
                + ((TextView) findViewById(R.id.button7_easy)).getText().toString();
        if (value4.equals("XXX") || value4.equals("OOO")) {
            hasWon = true;
            return 4;
        }
        String value5 = ((TextView) findViewById(R.id.button2_easy)).getText().toString() + ((TextView) findViewById(R.id.button5_easy)).getText().toString()
                + ((TextView) findViewById(R.id.button8_easy)).getText().toString();
        if (value5.equals("XXX") || value5.equals("OOO")) {
            hasWon = true;
            return 5;
        }
        String value6 = ((TextView) findViewById(R.id.button3_easy)).getText().toString() + ((TextView) findViewById(R.id.button6_easy)).getText().toString()
                + ((TextView) findViewById(R.id.button9_easy)).getText().toString();
        if (value6.equals("XXX") || value6.equals("OOO")) {
            hasWon = true;
            return 6;
        }
        String value7 = ((TextView) findViewById(R.id.button1_easy)).getText().toString() + ((TextView) findViewById(R.id.button5_easy)).getText().toString()
                + ((TextView) findViewById(R.id.button9_easy)).getText().toString();
        if (value7.equals("XXX") || value7.equals("OOO")) {
            hasWon = true;
            return 7;
        }
        String value8 = ((TextView) findViewById(R.id.button3_easy)).getText().toString() + ((TextView) findViewById(R.id.button5_easy)).getText().toString()
                + ((TextView) findViewById(R.id.button7_easy)).getText().toString();
        if (value8.equals("XXX") || value8.equals("OOO")) {
            hasWon = true;
            return 8;
        }
        return 0;
    }

    /**
     * Converts the winning line of buttons to watermelons.
     * @param obj is the newGame button
     * @param val is the integer that represents the line of buttons that won
     * @param whoWon is the boolean value that is used to dertemine if 'x' or 'o' won
     */
    void displayWalermelons(final View obj, int val, boolean whoWon)
    {
        switch (val) {
            case 1:
                ((Button) findViewById(R.id.button1_easy)).setText("\uD83C\uDF49");
                ((Button) findViewById(R.id.button2_easy)).setText("\uD83C\uDF49");
                ((Button) findViewById(R.id.button3_easy)).setText("\uD83C\uDF49");
                break;
            case 2:
                ((Button) findViewById(R.id.button4_easy)).setText("\uD83C\uDF49");
                ((Button) findViewById(R.id.button5_easy)).setText("\uD83C\uDF49");
                ((Button) findViewById(R.id.button6_easy)).setText("\uD83C\uDF49");
                break;
            case 3:
                ((Button) findViewById(R.id.button7_easy)).setText("\uD83C\uDF49");
                ((Button) findViewById(R.id.button8_easy)).setText("\uD83C\uDF49");
                ((Button) findViewById(R.id.button9_easy)).setText("\uD83C\uDF49");
                break;
            case 4:
                ((Button) findViewById(R.id.button1_easy)).setText("\uD83C\uDF49");
                ((Button) findViewById(R.id.button4_easy)).setText("\uD83C\uDF49");
                ((Button) findViewById(R.id.button7_easy)).setText("\uD83C\uDF49");
                break;
            case 5:
                ((Button) findViewById(R.id.button2_easy)).setText("\uD83C\uDF49");
                ((Button) findViewById(R.id.button5_easy)).setText("\uD83C\uDF49");
                ((Button) findViewById(R.id.button8_easy)).setText("\uD83C\uDF49");
                break;
            case 6:
                ((Button) findViewById(R.id.button3_easy)).setText("\uD83C\uDF49");
                ((Button) findViewById(R.id.button6_easy)).setText("\uD83C\uDF49");
                ((Button) findViewById(R.id.button9_easy)).setText("\uD83C\uDF49");
                break;
            case 7:
                ((Button) findViewById(R.id.button1_easy)).setText("\uD83C\uDF49");
                ((Button) findViewById(R.id.button5_easy)).setText("\uD83C\uDF49");
                ((Button) findViewById(R.id.button9_easy)).setText("\uD83C\uDF49");
                break;
            case 8:
                ((Button) findViewById(R.id.button3_easy)).setText("\uD83C\uDF49");
                ((Button) findViewById(R.id.button5_easy)).setText("\uD83C\uDF49");
                ((Button) findViewById(R.id.button7_easy)).setText("\uD83C\uDF49");
                break;
        }

        if(hasWon) {
            if(whoWon)
            {
                aiScore++;
                ((TextView)findViewById(R.id.player2_easy)).setText("AI: " + aiScore);
                Toast.makeText(this, "AI Won!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                player1Score++;
                ((TextView)findViewById(R.id.player_easy)).setText("Player: " + player1Score);
                Toast.makeText(this, "You Won!", Toast.LENGTH_SHORT).show();

            }
            (new Handler()).postDelayed(new Runnable() {
                @Override
                public void run()
                {
                    theNewGame(obj);
                }
            }, 1000);
        }
    }
}