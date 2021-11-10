package com.example.highrollerdicegame;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Dice {

    private int storage, rollValue;
    private List<Integer> numberStorage = new ArrayList<>();
    // create an array to store the numbers?


    public int createRoll(int min, int max, int rolls) {

        // Set the storage to 0
        storage = 0;
        // While the counter is less than the total rolls
        for(int i = 0; i < rolls; i++) {

            // Generate a random number..
            rollValue = generateRandomNumber(min, max);

            // Store that in the storage variable
            storage += rollValue;

            // Append the output

            // reset the roll value
            rollValue = 0;

        }

        // return their sum
        return storage;
    }

    public String toString() {
        return "";
    }

    private int generateRandomNumber(int min, int max) {
        // Generate a random number in the inclusivity range of the min and max
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

}
