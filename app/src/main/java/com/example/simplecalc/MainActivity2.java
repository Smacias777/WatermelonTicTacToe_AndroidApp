package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Is the hard level of tic-tac-toe versus the AI
 */
public class MainActivity2 extends AppCompatActivity {

    @Override
    /**
     * Create and display the activity
     */
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    /**
     * Restarts the game, clears all the buttons of any text.
     * The score is not changed, typically used for ties.
     * @param obj is the button clicked
     */
    public void theNewGame(View obj)
    {
        // reseting all the buttons
        Button button1 = findViewById(R.id.button1);
        button1.setText("");
        Button button2 = findViewById(R.id.button2);
        button2.setText("");
        Button button3 = findViewById(R.id.button3);
        button3.setText("");
        Button button4 = findViewById(R.id.button4);
        button4.setText("");
        Button button5 = findViewById(R.id.button5);
        button5.setText("");
        Button button6 = findViewById(R.id.button6);
        button6.setText("");
        Button button7 = findViewById(R.id.button7);
        button7.setText("");
        Button button8 = findViewById(R.id.button8);
        button8.setText("");
        Button button9 = findViewById(R.id.button9);
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
        TextView player1 = findViewById(R.id.player1);
        player1.setText("Player: 0");
        TextView player2 = findViewById(R.id.player2);
        player2.setText("AI: 0");
        player1Score = 0;
        aiScore = 0;
        whoWon = false;
        haveWinner = false;
        // reseting all the buttons
        Button button1 = findViewById(R.id.button1);
        button1.setText("");
        Button button2 = findViewById(R.id.button2);
        button2.setText("");
        Button button3 = findViewById(R.id.button3);
        button3.setText("");
        Button button4 = findViewById(R.id.button4);
        button4.setText("");
        Button button5 = findViewById(R.id.button5);
        button5.setText("");
        Button button6 = findViewById(R.id.button6);
        button6.setText("");
        Button button7 = findViewById(R.id.button7);
        button7.setText("");
        Button button8 = findViewById(R.id.button8);
        button8.setText("");
        Button button9 = findViewById(R.id.button9);
        button9.setText("");
    }

    String ai = "O";
    String player = "X";
    boolean hasWon = false;
    int player1Score = 0;
    int aiScore = 0;
    boolean whoWon = false;
    int counter = 0; // this counter will be used to avoid calling a method when the program begins
    boolean haveWinner = false;

    /**
     * Runs outputs a 'x' on the button clicked by the user and runs the minimax algorithm
     * to determine the most optimal location for the "AI" to choose. After it is found it
     * then chooses that location by placing an 'o'.
     * @param obj is the button clicked
     */
    public void example( View obj)
    {
        if(!haveWinner) {
            Button buttonText = (Button) obj;
            String text = buttonText.getText().toString();
            if (text.equals("")) {
                buttonText.setText("X");
            }
            else {
                return;
            }
            Button button1 = findViewById(R.id.button1);
            Button button2 = findViewById(R.id.button2);
            Button button3 = findViewById(R.id.button3);
            Button button4 = findViewById(R.id.button4);
            Button button5 = findViewById(R.id.button5);
            Button button6 = findViewById(R.id.button6);
            Button button7 = findViewById(R.id.button7);
            Button button8 = findViewById(R.id.button8);
            Button button9 = findViewById(R.id.button9);

            int val = findBestMove(); // returnmos most optimal position
            int winnerLine = checkIfWinner();  // hasWon = true; if winner is found

            if (!hasWon) {
                switch (val) {
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
                displayWalermelons(obj, winnerLine, whoWon);
            }
        }
    }

    /**
     * Find the best posible move for the AI
     * @return the index of the button that is the most optimal move
     */
    public int findBestMove()
    {
        int bestVal = -1000;
        int bestMoveButton = 0;
        // traversing through all the buttons
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        // if button has not been clicked yet
        if(button1.getText().toString().equals(""))
        {
            button1.setText(ai);
            int value = miniMax(0, false);
            button1.setText("");
            if(value > bestVal)
            {
                bestMoveButton = 1;
                bestVal = value;
            }
        }
        if(button2.getText().toString().equals(""))
        {
            button2.setText(ai);
            int value = miniMax(0, false);
            button2.setText("");
            if(value > bestVal)
            {
                bestMoveButton = 2;
                bestVal = value;
            }
        }
        if(button3.getText().toString().equals(""))
        {
            button3.setText(ai);
            int value = miniMax(0, false);
            button3.setText("");
            if(value > bestVal)
            {
                bestMoveButton = 3;
                bestVal = value;
            }
        }
        if(button4.getText().toString().equals(""))
        {
            button4.setText(ai);
            int value = miniMax(0, false);
            button4.setText("");
            if(value > bestVal)
            {
                bestMoveButton = 4;
                bestVal = value;
            }
        }
        if(button5.getText().toString().equals(""))
        {
            button5.setText(ai);
            int value = miniMax(0, false);
            button5.setText("");
            if(value > bestVal)
            {
                bestMoveButton = 5;
                bestVal = value;
            }
        }
        if(button6.getText().toString().equals(""))
        {
            button6.setText(ai);
            int value = miniMax(0, false);
            button6.setText("");
            if(value > bestVal)
            {
                bestMoveButton = 6;
                bestVal = value;
            }
        }
        if(button7.getText().toString().equals(""))
        {
            button7.setText(ai);
            int value = miniMax(0, false);
            button7.setText("");
            if(value > bestVal)
            {
                bestMoveButton = 7;
                bestVal = value;
            }
        }
        if(button8.getText().toString().equals(""))
        {
            button8.setText(ai);
            int value = miniMax(0, false);
            button8.setText("");
            if(value > bestVal)
            {
                bestMoveButton = 8;
                bestVal = value;
            }
        }
        if(button9.getText().toString().equals(""))
        {
            button9.setText(ai);
            int value = miniMax(0, false);
            button9.setText("");
            if(value > bestVal)
            {
                bestMoveButton = 9;
                bestVal = value;
            }
        }
        return bestMoveButton;
    }

    /**
     * Recursively called and is the minimax algorithm. There the most optimal move is found.
     * @param depth is the depth of the recursive call
     * @param isMax changes between true (for maximizer) and or false (for minimizer).
     * @return whether the maximizer(10) and or minimizer(-10) won or there is no more spaces(0)
     */
    public int miniMax(int depth,boolean isMax)
    {
        int val = calculateIfWinner();
        if(val == 10)  // maximizer won
        {
            return val;
        }
        if(val == -10) // minimizer won
        {
            return val;
        }
        if(anySpacesLeft() == false) // check if theres any moves left

        {
            return 0;
        }
        Button button1 = ((Button)findViewById(R.id.button1));
        Button button2 = ((Button)findViewById(R.id.button2));
        Button button3 = ((Button)findViewById(R.id.button3));
        Button button4 = ((Button)findViewById(R.id.button4));
        Button button5 = ((Button)findViewById(R.id.button5));
        Button button6 = ((Button)findViewById(R.id.button6));
        Button button7 = ((Button)findViewById(R.id.button7));
        Button button8 = ((Button)findViewById(R.id.button8));
        Button button9 = ((Button)findViewById(R.id.button9));
        if(isMax) // maximizer
        {
            int best = -1000;
            if(button1.getText().toString().equals(""))
            {
               button1.setText(ai);
               best = Math.max(best, miniMax(depth+1, false)); // recursive call (returns largest val)
               button1.setText("");
            }
            if(button2.getText().toString().equals(""))
            {
                button2.setText(ai);
                best = Math.max(best, miniMax(depth+1, false)); // recursive call (returns largest val)
                button2.setText("");
            }
            if(button3.getText().toString().equals(""))
            {
                button3.setText(ai);
                best = Math.max(best, miniMax(depth+1, false)); // recursive call (returns largest val)
                button3.setText("");
            }
            if(button4.getText().toString().equals(""))
            {
                button4.setText(ai);
                best = Math.max(best, miniMax(depth+1, false)); // recursive call (returns largest val)
                button4.setText("");
            }
            if(button5.getText().toString().equals(""))
            {
                button5.setText(ai);
                best = Math.max(best, miniMax(depth+1, false)); // recursive call (returns largest val)
                button5.setText("");
            }
            if(button6.getText().toString().equals(""))
            {
                button6.setText(ai);
                best = Math.max(best, miniMax(depth+1, false)); // recursive call (returns largest val)
                button6.setText("");
            }
            if(button7.getText().toString().equals(""))
            {
                button7.setText(ai);
                best = Math.max(best, miniMax(depth+1, false)); // recursive call (returns largest val)
                button7.setText("");
            }
            if(button8.getText().toString().equals(""))
            {
                button8.setText(ai);
                best = Math.max(best, miniMax(depth+1, false)); // recursive call (returns largest val)
                button8.setText("");
            }
            if(button9.getText().toString().equals(""))
            {
                button9.setText(ai);
                best = Math.max(best, miniMax(depth+1, false)); // recursive call (returns largest val)
                button9.setText("");
            }
            return best;
        }
        else // minimizer
        {
            int best = 1000;
            if(button1.getText().toString().equals(""))
            {
                button1.setText(player);
                best = Math.min(best, miniMax(depth+1, true)); // recursive call (returns largest val)
                button1.setText("");
            }
            if(button2.getText().toString().equals(""))
            {
                button2.setText(player);
                best = Math.min(best, miniMax(depth+1, true)); // recursive call (returns largest val)
                button2.setText("");
            }
            if(button3.getText().toString().equals(""))
            {
                button3.setText(player);
                best = Math.min(best, miniMax(depth+1, true)); // recursive call (returns largest val)
                button3.setText("");
            }
            if(button4.getText().toString().equals(""))
            {
                button4.setText(player);
                best = Math.min(best, miniMax(depth+1, true)); // recursive call (returns largest val)
                button4.setText("");
            }
            if(button5.getText().toString().equals(""))
            {
                button5.setText(player);
                best = Math.min(best, miniMax(depth+1, true)); // recursive call (returns largest val)
                button5.setText("");
            }
            if(button6.getText().toString().equals(""))
            {
                button6.setText(player);
                best = Math.min(best, miniMax(depth+1, true)); // recursive call (returns largest val)
                button6.setText("");
            }
            if(button7.getText().toString().equals(""))
            {
                button7.setText(player);
                best = Math.min(best, miniMax(depth+1, true)); // recursive call (returns largest val)
                button7.setText("");
            }
            if(button8.getText().toString().equals(""))
            {
                button8.setText(player);
                best = Math.min(best, miniMax(depth+1, true)); // recursive call (returns largest val)
                button8.setText("");
            }
            if(button9.getText().toString().equals(""))
            {
                button9.setText(player);
                best = Math.min(best, miniMax(depth+1, true)); // recursive call (returns largest val)
                button9.setText("");
            }
            return best;
        }
    }

    /**
     * Checks if there is a winner. Returns -10 for 'x' and 10 for 'o'.
     * @return 10 or -10 depending on who won
     */
    public int calculateIfWinner()
    {
        //must check for winner (analyze all 8 winning directions)
        String value1 = ((TextView) findViewById(R.id.button1)).getText().toString() + ((TextView) findViewById(R.id.button2)).getText().toString()
                + ((TextView) findViewById(R.id.button3)).getText().toString();
        if (value1.equals("XXX")) {
            return -10;
        }
        if (value1.equals("OOO")) {
            return 10;
        }

        String value2 = ((TextView) findViewById(R.id.button4)).getText().toString() + ((TextView) findViewById(R.id.button5)).getText().toString()
                + ((TextView) findViewById(R.id.button6)).getText().toString();
        if (value2.equals("XXX")) {
            return -10;
        }
        if (value2.equals("OOO")) {
            return 10;
        }

        String value3 = ((TextView) findViewById(R.id.button7)).getText().toString() + ((TextView) findViewById(R.id.button8)).getText().toString()
                + ((TextView) findViewById(R.id.button9)).getText().toString();
        if (value3.equals("XXX")) {
            return -10;
        }
        if (value3.equals("OOO")) {
            return 10;
        }

        String value4 = ((TextView) findViewById(R.id.button1)).getText().toString() + ((TextView) findViewById(R.id.button4)).getText().toString()
                + ((TextView) findViewById(R.id.button7)).getText().toString();
        if (value4.equals("XXX")) {
            return -10;
        }
        if (value4.equals("OOO")) {
            return 10;
        }

        String value5 = ((TextView) findViewById(R.id.button2)).getText().toString() + ((TextView) findViewById(R.id.button5)).getText().toString()
                + ((TextView) findViewById(R.id.button8)).getText().toString();
        if (value5.equals("XXX")) {
            return -10;
        }
        if (value5.equals("OOO")) {
            return 10;
        }

        String value6 = ((TextView) findViewById(R.id.button3)).getText().toString() + ((TextView) findViewById(R.id.button6)).getText().toString()
                + ((TextView) findViewById(R.id.button9)).getText().toString();
        if (value6.equals("XXX")) {
            return -10;
        }
        if (value6.equals("OOO")) {
            return 10;
        }

        String value7 = ((TextView) findViewById(R.id.button1)).getText().toString() + ((TextView) findViewById(R.id.button5)).getText().toString()
                + ((TextView) findViewById(R.id.button9)).getText().toString();
        if (value7.equals("XXX")) {
            return -10;
        }
        if (value7.equals("OOO")) {
            return 10;
        }

        String value8 = ((TextView) findViewById(R.id.button3)).getText().toString() + ((TextView) findViewById(R.id.button5)).getText().toString()
                + ((TextView) findViewById(R.id.button7)).getText().toString();
        if (value8.equals("XXX")) {
            return -10;
        }
        if (value8.equals("OOO")) {
            return 10;
        }
        // if none of them have won then just return 0
        return 0;
    }

    /**
     * Checks whether there are any open spaces left
     * @return a boolean value if true or false
     */
    public boolean anySpacesLeft()
    {
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        if(button1.getText().toString() == "")
        {
            return true;
        }
        else if(button2.getText().toString() == "")
        {
            return true;
        }
        else if(button3.getText().toString() == "")
        {
            return true;
        }
        else if(button4.getText().toString() == "")
        {
            return true;
        }
        else if(button5.getText().toString() == "")
        {
            return true;
        }
        else if(button6.getText().toString() == "")
        {
            return true;
        }
        else if(button7.getText().toString() == "")
        {
            return true;
        }
        else if(button8.getText().toString() == "")
        {
            return true;
        }
        else if(button9.getText().toString() == "")
        {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks if there is a winner, if a winner is found, it will
     * return an integer value that represents the line of buttons that
     * won.
     * @return an integer that represents a line of buttons that won, or 0 if no winner
     */
    public int checkIfWinner()
    {
            String value1 = ((TextView) findViewById(R.id.button1)).getText().toString() + ((TextView) findViewById(R.id.button2)).getText().toString()
                    + ((TextView) findViewById(R.id.button3)).getText().toString();
            if (value1.equals("XXX") || value1.equals("OOO")) {
                hasWon = true;
                return 1;
            }
            String value2 = ((TextView) findViewById(R.id.button4)).getText().toString() + ((TextView) findViewById(R.id.button5)).getText().toString()
                    + ((TextView) findViewById(R.id.button6)).getText().toString();
            if (value2.equals("XXX") || value2.equals("OOO")) {
                hasWon = true;
                return 2;
            }
            String value3 = ((TextView) findViewById(R.id.button7)).getText().toString() + ((TextView) findViewById(R.id.button8)).getText().toString()
                    + ((TextView) findViewById(R.id.button9)).getText().toString();
            if (value3.equals("XXX") || value3.equals("OOO")) {
                hasWon = true;
                return 3;
            }
            String value4 = ((TextView) findViewById(R.id.button1)).getText().toString() + ((TextView) findViewById(R.id.button4)).getText().toString()
                    + ((TextView) findViewById(R.id.button7)).getText().toString();
            if (value4.equals("XXX") || value4.equals("OOO")) {
                hasWon = true;
                return 4;
            }
            String value5 = ((TextView) findViewById(R.id.button2)).getText().toString() + ((TextView) findViewById(R.id.button5)).getText().toString()
                    + ((TextView) findViewById(R.id.button8)).getText().toString();
            if (value5.equals("XXX") || value5.equals("OOO")) {
                hasWon = true;
                return 5;
            }
            String value6 = ((TextView) findViewById(R.id.button3)).getText().toString() + ((TextView) findViewById(R.id.button6)).getText().toString()
                    + ((TextView) findViewById(R.id.button9)).getText().toString();
            if (value6.equals("XXX") || value6.equals("OOO")) {
                hasWon = true;
                return 6;
            }
            String value7 = ((TextView) findViewById(R.id.button1)).getText().toString() + ((TextView) findViewById(R.id.button5)).getText().toString()
                    + ((TextView) findViewById(R.id.button9)).getText().toString();
            if (value7.equals("XXX") || value7.equals("OOO")) {
                hasWon = true;
                return 7;
            }
            String value8 = ((TextView) findViewById(R.id.button3)).getText().toString() + ((TextView) findViewById(R.id.button5)).getText().toString()
                    + ((TextView) findViewById(R.id.button7)).getText().toString();
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
                    ((Button) findViewById(R.id.button1)).setText("\uD83C\uDF49");
                    ((Button) findViewById(R.id.button2)).setText("\uD83C\uDF49");
                    ((Button) findViewById(R.id.button3)).setText("\uD83C\uDF49");
                    break;
                case 2:
                    ((Button) findViewById(R.id.button4)).setText("\uD83C\uDF49");
                    ((Button) findViewById(R.id.button5)).setText("\uD83C\uDF49");
                    ((Button) findViewById(R.id.button6)).setText("\uD83C\uDF49");
                    break;
                case 3:
                    ((Button) findViewById(R.id.button7)).setText("\uD83C\uDF49");
                    ((Button) findViewById(R.id.button8)).setText("\uD83C\uDF49");
                    ((Button) findViewById(R.id.button9)).setText("\uD83C\uDF49");
                    break;
                case 4:
                    ((Button) findViewById(R.id.button1)).setText("\uD83C\uDF49");
                    ((Button) findViewById(R.id.button4)).setText("\uD83C\uDF49");
                    ((Button) findViewById(R.id.button7)).setText("\uD83C\uDF49");
                    break;
                case 5:
                    ((Button) findViewById(R.id.button2)).setText("\uD83C\uDF49");
                    ((Button) findViewById(R.id.button5)).setText("\uD83C\uDF49");
                    ((Button) findViewById(R.id.button8)).setText("\uD83C\uDF49");
                    break;
                case 6:
                    ((Button) findViewById(R.id.button3)).setText("\uD83C\uDF49");
                    ((Button) findViewById(R.id.button6)).setText("\uD83C\uDF49");
                    ((Button) findViewById(R.id.button9)).setText("\uD83C\uDF49");
                    break;
                case 7:
                    ((Button) findViewById(R.id.button1)).setText("\uD83C\uDF49");
                    ((Button) findViewById(R.id.button5)).setText("\uD83C\uDF49");
                    ((Button) findViewById(R.id.button9)).setText("\uD83C\uDF49");
                    break;
                case 8:
                    ((Button) findViewById(R.id.button3)).setText("\uD83C\uDF49");
                    ((Button) findViewById(R.id.button5)).setText("\uD83C\uDF49");
                    ((Button) findViewById(R.id.button7)).setText("\uD83C\uDF49");
                    break;
            }

        if(hasWon) {
            if(whoWon)
            {
                aiScore++;
                ((TextView)findViewById(R.id.player2)).setText("AI: " + aiScore);
                Toast.makeText(this, "AI Won!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                player1Score++;
                ((TextView)findViewById(R.id.player1)).setText("Player: " + player1Score);
            }
            (new Handler()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    theNewGame(obj);
                }
            }, 1000);
        }
    }
}
