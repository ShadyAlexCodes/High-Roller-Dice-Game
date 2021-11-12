package com.example.highrollerdicegame;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // Define all the EditText, TextView, and Button Variables
    EditText etPlayerOne, etPlayerTwo, etPlayerThree;
    TextView numberView, numberWin;
    Button getBtnStart, getBtnRoll, getBtnReset;

    // Create a private counter for total turns and placement
    private int turnCounter, totalTurns;

    // Create all the different player classes
    Player playerOne = new Player();
    Player playerTwo = new Player();
    Player playerThree = new Player();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the EditText variables
        etPlayerOne = findViewById(R.id.etPlayerOne);
        etPlayerTwo = findViewById(R.id.etPlayerTwo);
        etPlayerThree = findViewById(R.id.etPlayerThree);

        // Initialize the TextView variables
        numberView = findViewById(R.id.tvNumberView);
        numberWin = findViewById(R.id.tvWinner);

        // Initialize the Button variables
        getBtnStart = findViewById(R.id.btnStart);
        getBtnRoll = findViewById(R.id.btnCreateRoll);
        getBtnReset = findViewById(R.id.btnReset);

    }

    public void createGame(View view) {
        // Ensure they are not empty before locking them out
        if(checkEmpty(etPlayerOne) && checkEmpty(etPlayerTwo) && checkEmpty(etPlayerThree)) {
            // Disable Input
            etPlayerOne.setEnabled(false);
            etPlayerTwo.setEnabled(false);
            etPlayerThree.setEnabled(false);

            // Append a colon to the end of each one
            etPlayerOne.append(": ");
            etPlayerTwo.append(": ");
            etPlayerThree.append(": ");

            // Disable the begin game button
            getBtnStart.setEnabled(false);

            // Enable the roll and reset buttons!
            getBtnRoll.setEnabled(true);
            getBtnReset.setEnabled(true);

            // Create the player by grabbing their name and assigning them a score of 0
            playerOne.createPlayer(etPlayerOne.getText().toString(), 0);
            playerTwo.createPlayer(etPlayerTwo.getText().toString(), 0);
            playerThree.createPlayer(etPlayerThree.getText().toString(), 0);

            // Define the position of the first turn
            turnCounter = 1;
        }
    }

    public void rollGame(View view) {
        // Define the Dice Class
        Dice dice = new Dice();

        // Check if the total turns is less than 3
        if(totalTurns < 3) {
            // Create a switch statement to check what turn it is
            switch (turnCounter) {
                case 1:
                    // Create a random number between 0 and 10...
                    dice.createRoll(0, 10, 4);

                    // Set the text to the created array of student rolls
                    numberView.setText(Arrays.toString(dice.getNumberStorage().toArray()));

                    // Set the player score to the sum of all numbers
                    playerOne.setPlayerScore(dice.getStorage());

                    // Append the number to the end
                    etPlayerOne.append(dice.getStorage() + ", ");

                    // Increase the total number of turns
                    turnCounter++;
                    break;
                case 2:
                    // Create a random number between 0 and 10...
                    dice.createRoll(0, 10, 4);

                    // Set the text to the created array of the dice rolls
                    numberView.setText(Arrays.toString(dice.getNumberStorage().toArray()));

                    // Set the player score to the sum of all the numbers
                    playerTwo.setPlayerScore(dice.getStorage());

                    // Append the number to the end
                    etPlayerTwo.append(dice.getStorage() + ", ");

                    // Increase the total number of turns
                    turnCounter++;
                    break;
                case 3:
                    // Create a random number between 0 and 10...
                    dice.createRoll(0, 10, 4);

                    // Set the text of the created array of the dice rolls
                    numberView.setText(Arrays.toString(dice.getNumberStorage().toArray()));

                    // Set the player score to the sum of all the numbers
                    playerThree.setPlayerScore(dice.getStorage());

                    // Append the number to the end
                    etPlayerThree.append(dice.getStorage() + ", ");

                    // Reset the turn counter
                    turnCounter = 1;

                    // Increase the total turns
                    totalTurns++;
                    break;
                default:
                    // Inform the user of an error
                    System.out.println("ERROR");
                    break;
            }
        }
        // Otherwise..
        else {
            // Disable the roll button
            getBtnRoll.setEnabled(false);
            // Calculate the winner text.
            numberWin.setText(calculateTotal());
        }
    }

    private String calculateTotal() {
        // Check if player one is greater than player two
        if(playerOne.getPlayerScore() > playerTwo.getPlayerScore()) {
            // Check if player one is greater than player three
            if(playerOne.getPlayerScore() > playerThree.getPlayerScore()) {
                // inform them player one won
                return playerOne.getPlayerName() + " has won the game with " + playerOne.getPlayerScore() + " points!";
            } else {
                // otherwise.. inform them player three won
                return playerThree.getPlayerName() + " has won the game with " + playerThree.getPlayerScore() + " points!";
            }
        } else {
            // Check if player two is greater than player three
            if(playerTwo.getPlayerScore() > playerThree.getPlayerScore()) {
                // inform them player two won
                return playerTwo.getPlayerName() + " has won the game with " + playerTwo.getPlayerScore() + " points!";
            } else {
                // inform them player three won
                return playerThree.getPlayerName() + " has won the game with " + playerThree.getPlayerScore() + " points!";
            }
        }
    }

    private boolean checkEmpty(EditText input) {
        // Check if the inputted action is null.
        if (TextUtils.isEmpty(input.getText().toString())) {
            // Define the error
            input.setError("Please enter a number");
            return false;
        }
        return true;
    }


    public void resetGame(View view) {

        // Clear all the User Input boxes
        etPlayerOne.setText(null);
        etPlayerTwo.setText(null);
        etPlayerThree.setText(null);

        // Reset the Text View Boxes
        numberWin.setText(null);
        numberView.setText(null);

        // Re-Enable all the user input boxes
        etPlayerOne.setEnabled(true);
        etPlayerTwo.setEnabled(true);
        etPlayerThree.setEnabled(true);

        // Enable the start button
        getBtnStart.setEnabled(true);

        // Reset the total number of turns.
        totalTurns = 0;

    }

}