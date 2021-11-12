package com.example.highrollerdicegame;

public class Player {

    // Define the player name and score
    private String playerName;
    private int playerScore;

    // Create a constructor that'll define the player
    public void createPlayer(String playerName, int playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;
    }

    // Grab the player Score
    public int getPlayerScore() {
        return playerScore;
    }

    // Set the player score
    public void setPlayerScore(int playerScore) {
        this.playerScore += playerScore;
    }

    // Grab the player name
    public String getPlayerName() {
        return playerName;
    }

    // Set the player score
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}
