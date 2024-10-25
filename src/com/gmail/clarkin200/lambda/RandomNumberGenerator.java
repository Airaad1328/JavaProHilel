package com.gmail.clarkin200.lambda;

import java.util.Random;

public class RandomNumberGenerator {
    public static int generateRandomNumber(int min, int max) {

        Random rand = new Random();
        return rand.nextInt(min,max);
    }
}
