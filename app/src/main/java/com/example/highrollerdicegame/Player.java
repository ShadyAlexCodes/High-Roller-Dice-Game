package com.example.highrollerdicegame;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String playerName;
    private int playerScore;

    public void createPlayer(String playerName, int playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore += playerScore;
    }

    public String toString() {
        return this.playerName + ": " + this.playerScore;
    }
}
