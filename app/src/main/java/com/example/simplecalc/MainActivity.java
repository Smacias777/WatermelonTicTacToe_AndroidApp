package com.example.simplecalc;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Allows for two individuals to play tic-tac-toe
 */
public class MainActivity extends AppCompatActivity {

    @Override
    /**
     * Creates and displays the activity
     */
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Resets the table, clears all the buttons and the score
     * @param obj is the button clicked
     */
    public void reset(View obj)
    {
        onlyOneWinner = 0;
        // reseting score
        TextView player1 = findViewById(R.id.player1);
        player1.setText("Player1: 0");
        TextView player2 = findViewById(R.id.player2);
        player2.setText("Player2: 0");
        player1Score = 0;
        player2Score = 0;

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

    /**
     * Restarts the game, clears all the buttons of any text.
     * The score is not changed, typically used for ties.
     * @param obj is the button clicked
     */
    public void theNewGame(View obj)
    {
        onlyOneWinner = 0;
        winner = false;
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
    //boolean position= false;
    boolean type = false; // if "type" is false, display "X"
                          // if "type" is true, display "O"
    int player1Score = 0;
    int player2Score = 0;
    boolean winner = false; // will become true if there is a winner
    String winnerType = ""; // did 'X' win or 'O'
    int position = 0; // corresponds to which type of win it was(8 types)
    int winningPosition = 0; // the position and or line that won
    int onlyOneWinner = 0;  // helps avoid any bugs of multiple winners in a single game

    /**
     * Called by every in game button(Total = 9)
     *  First checks whether the button has already been clicked
     *  if not then "X" or "O" are displayed on the button that was clicked (Note! Bool value is used to ensure, that each value goes after the other)
     *  Next it loops through each possible way of winning (8 ways)
     *  it seeks to find "XXX" or "OOO" indicating that there is a winner ("val" contains this string value)
     *  Once it is determined that there is a winner, a toast is used to display who won and a new game begins( by caliing theNewGame func)
     * @param obj is the button clicked, one of the nine options
     */
    public void example(final View obj)
    {
        // places 'X' or 'O' into button
        // ensures that once a value is printed on the button, it cannot be changed
        TextView buttonText = (TextView) obj;
        String text = buttonText.getText().toString();
        if(type == false && text == "")
       {
           buttonText.setText("X");
           type = true;
       }
       else if(type == true && text == "")
       {
           buttonText.setText("O");
           type = false;
       }
        String val = "";

       // this loop check every single posibility for a "win" to occur
        // winner is set to true when a winner is found
       for(int i = 1 ; i < 9; i++)
       {
           switch (i) {
               case 1:
                   val = ((TextView) findViewById(R.id.button1)).getText().toString() + ((TextView) findViewById(R.id.button2)).getText().toString()
                           + ((TextView) findViewById(R.id.button3)).getText().toString();
                   position = 1;
                   winner = isWinner(val, winner,position);
                   break;
               case 2:
                   val = ((TextView) findViewById(R.id.button4)).getText().toString() + ((TextView) findViewById(R.id.button5)).getText().toString()
                           + ((TextView) findViewById(R.id.button6)).getText().toString();
                   position = 2;
                   winner = isWinner(val,winner,position);
                   break;
               case 3:
                   val = ((TextView) findViewById(R.id.button7)).getText().toString() + ((TextView) findViewById(R.id.button8)).getText().toString()
                           + ((TextView) findViewById(R.id.button9)).getText().toString();
                   position = 3;
                   winner = isWinner(val,winner,position);
                   break;
               case 4:
                   val = ((TextView) findViewById(R.id.button1)).getText().toString() + ((TextView) findViewById(R.id.button4)).getText().toString()
                           + ((TextView) findViewById(R.id.button7)).getText().toString();
                   position = 4;
                   winner = isWinner(val,winner,position);
                   break;
               case 5:
                   val = ((TextView) findViewById(R.id.button2)).getText().toString() + ((TextView) findViewById(R.id.button5)).getText().toString()
                           + ((TextView) findViewById(R.id.button8)).getText().toString();
                   position = 5;
                   winner = isWinner(val,winner,position);
                   break;
               case 6:
                   val = ((TextView) findViewById(R.id.button3)).getText().toString() + ((TextView) findViewById(R.id.button6)).getText().toString()
                           + ((TextView) findViewById(R.id.button9)).getText().toString();
                   position = 6;
                   winner = isWinner(val,winner,position);
                   break;
               case 7:
                   val = ((TextView) findViewById(R.id.button1)).getText().toString() + ((TextView) findViewById(R.id.button5)).getText().toString()
                           + ((TextView) findViewById(R.id.button9)).getText().toString();
                   position = 7;
                   winner = isWinner(val,winner,position);
                   break;
               case 8:
                   val = ((TextView) findViewById(R.id.button3)).getText().toString() + ((TextView) findViewById(R.id.button5)).getText().toString()
                           + ((TextView) findViewById(R.id.button7)).getText().toString();
                   position = 8;
                   winner = isWinner(val,winner,position);
                   break;
           }
       }
        // if there is a winner we want to cross a line by the winning section
        // Toasts are used to display a message on who won.
        if(winner == true && onlyOneWinner == 1)
        {
            switch (winningPosition)
            {
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
            if(winnerType.equals("X"))
            {
                Toast.makeText(this, "X wins!", Toast.LENGTH_SHORT).show();
            }
            else if(winnerType.equals("O"))
            {
                Toast.makeText(this, "O wins!", Toast.LENGTH_SHORT).show();
            }

            (new Handler()).postDelayed(new Runnable()
            {
                @Override
                public void run() {
                   theNewGame(obj);
                }
            }, 1500);
           // theNewGame(obj);
        }
    }

    /**
     * Checks if there is a winner. If the "val" variable contains three repeating letters,
     * such as "XXX", if so then a winner has been reached and winner = true, and
     * winner is them returned.
     * EXTRA: winnerType contains whether the winner was using "X" or "O"
     * @param val string containing x's and o's
     * @param winner true if someone has won, if not then false
     * @param position an integer that represents the line that won
     * @return a boolean whether there is a winner or not
     */
    public boolean isWinner(String val, boolean winner, int position)
    {
        // if x is a winner
        if(val.equals("XXX"))
        {
            onlyOneWinner++;
            // increase the score only one time
            if(onlyOneWinner == 1) {
                player1Score++;
                ((TextView) findViewById(R.id.player1)).setText("Player1: " + player1Score);
                winner = true;
                winnerType = "X";
                winningPosition = position;
            }
        }
        // if o is a winner
        if(val.equals("OOO"))
        {
            onlyOneWinner++;
            // increase the score only one time
            if(onlyOneWinner == 1)
            {
                player2Score++;
                ((TextView) findViewById(R.id.player2)).setText("Player2: " + player2Score);
                winner = true;
                winnerType = "O";
                winningPosition = position;
            }
        }
        return winner;
    }
}