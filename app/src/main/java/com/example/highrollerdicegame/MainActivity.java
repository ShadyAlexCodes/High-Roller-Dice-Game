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

    EditText etPlayerOne, etPlayerTwo, etPlayerThree;
    TextView numberView, numberWin;
    Button getBtnStart, getBtnRoll;
    private int turnCounter, totalTurns;
    
    Player playerOne = new Player();
    Player playerTwo = new Player();
    Player playerThree = new Player();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initlaize all the variables that were defined above
        etPlayerOne = findViewById(R.id.etPlayerOne);
        etPlayerTwo = findViewById(R.id.etPlayerTwo);
        etPlayerThree = findViewById(R.id.etPlayerThree);

        // Grab the number view
        numberView = findViewById(R.id.tvNumberView);
        numberWin = findViewById(R.id.tvWinner);

        // Grab the buttons
        getBtnStart = findViewById(R.id.btnStart);
        getBtnRoll = findViewById(R.id.btnCreateRoll);

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

            // Enable the roll button!
            getBtnRoll.setEnabled(true);

            // Create the player

            playerOne.createPlayer(etPlayerOne.getText().toString(), 0);
            playerTwo.createPlayer(etPlayerTwo.getText().toString(), 0);
            playerThree.createPlayer(etPlayerThree.getText().toString(), 0);

            turnCounter = 1;
        }
    }

    public void rollGame(View view) {
        Dice dice = new Dice();
        if(totalTurns < 3) {
            switch (turnCounter) {
                case 1:
                    // Create a random number between 0 and 10...
                    dice.createRoll(0, 10, 4);

                    System.out.println("STORAGE: " + dice.getNumberStorage());
                    System.out.println("SUM: " + dice.getStorage());
                    numberView.setText(Arrays.toString(dice.getNumberStorage().toArray()));
                    playerOne.setPlayerScore(dice.getStorage());
                    etPlayerOne.append(dice.getStorage() + ", ");
                    turnCounter++;
                    break;
                case 2:
                    // Create a random number between 0 and 10...
                    dice.createRoll(0, 10, 4);

                    System.out.println("STORAGE: " + dice.getNumberStorage());
                    System.out.println("SUM: " + dice.getStorage());
                    numberView.setText(Arrays.toString(dice.getNumberStorage().toArray()));
                    playerTwo.setPlayerScore(dice.getStorage());
                    etPlayerTwo.append(dice.getStorage() + ", ");
                    turnCounter++;
                    break;
                case 3:
                    // Create a random number between 0 and 10...
                    dice.createRoll(0, 10, 4);

                    System.out.println("STORAGE: " + dice.getNumberStorage());
                    System.out.println("SUM: " + dice.getStorage());
                    numberView.setText(Arrays.toString(dice.getNumberStorage().toArray()));
                    playerThree.setPlayerScore(dice.getStorage());
                    etPlayerThree.append(dice.getStorage() + ", ");
                    turnCounter = 1;

                    // Increase the total turns
                    totalTurns++;
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
        } else {
            getBtnRoll.setEnabled(false);
            numberWin.setText(calculateTotal());
        }
    }

    private String calculateTotal() {
        System.out.println(playerOne.getPlayerName() + ": " + playerOne.getPlayerScore());
        System.out.println(playerTwo.getPlayerName() + ": " + playerTwo.getPlayerScore());
        System.out.println(playerThree.getPlayerName() + ": " + playerThree.getPlayerScore());
        if(playerOne.getPlayerScore() > playerTwo.getPlayerScore()) {
            if(playerOne.getPlayerScore() > playerThree.getPlayerScore()) {
                return playerOne.getPlayerName() + " has won the game with " + playerOne.getPlayerScore() + " points!";
            } else {
                return playerThree.getPlayerName() + " has won the game with " + playerThree.getPlayerScore() + " points!";
            }
        } else {
            if(playerTwo.getPlayerScore() > playerThree.getPlayerScore()) {
                return playerTwo.getPlayerName() + " has won the game with " + playerTwo.getPlayerScore() + " points!";
            } else {
                return playerThree.getPlayerName() + " has won the game with " + playerThree.getPlayerScore() + " points!";
            }
        }
    }

    private boolean checkEmpty(EditText input) {
        if (TextUtils.isEmpty(input.getText().toString())) {
            // Define the error
            input.setError("Please enter a number");
            return false;
        }
        return true;
    }


    public void resetGame(View view) {

        etPlayerOne.setText(null);
        etPlayerTwo.setText(null);
        etPlayerThree.setText(null);
        numberWin.setText(null);
        numberView.setText(null);

        etPlayerOne.setEnabled(false);
        etPlayerTwo.setEnabled(false);
        etPlayerThree.setEnabled(false);

        getBtnStart.setEnabled(true);

        totalTurns = 0;

    }

}