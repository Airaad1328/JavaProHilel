package com.gmail.clarkin200.lambda;

public class StringListProcessor {

    public static int countUpperCase(String input) {
        int result = 0;
        for (char symbol : input.toCharArray()) {

            if (Character.isUpperCase(symbol)) {
                result++;
            }
        }
        return result;
    }

}
