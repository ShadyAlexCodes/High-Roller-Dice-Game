package com.example.highrollerdicegame;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dice {

    // Create integers to hold the numbers
    private int storage, rollValue;
    // Store the numbers in an array for visual purposes
    private List<Integer> numberStorage = new ArrayList<>();


    // Function that will create an array of numbers
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
            numberStorage.add(rollValue);
            // reset the roll value
            rollValue = 0;

        }

        // return their sum
        return rollValue;
    }

    // Grab the array
    public List<Integer> getNumberStorage() {
        return numberStorage;
    }

    // Grab the storage number
    public int getStorage() {
        return storage;
    }

    // Grab the roll numbers
    public int getRollValue() {
        return rollValue;
    }

    // Generate a random number.
    private int generateRandomNumber(int min, int max) {
        // Generate a random number in the inclusivity range of the min and max
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

}
