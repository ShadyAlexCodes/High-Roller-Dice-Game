package com.example.highrollerdicegame;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
            System.out.println("A: " + rollValue);
            // Store that in the storage variable
            storage += rollValue;
            System.out.println("B: " + storage);
            // Append the output
            numberStorage.add(rollValue);
            System.out.println("C: " + Arrays.toString(numberStorage.toArray()));

            // reset the roll value
            rollValue = 0;

        }

        // return their sum
        return rollValue;
    }

    public List<Integer> getNumberStorage() {
        return numberStorage;
    }

    public int getStorage() {
        return storage;
    }

    public int getRollValue() {
        return rollValue;
    }

    private int generateRandomNumber(int min, int max) {
        // Generate a random number in the inclusivity range of the min and max
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

}
