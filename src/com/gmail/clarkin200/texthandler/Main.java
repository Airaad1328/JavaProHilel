package com.gmail.clarkin200.texthandler;

import java.nio.file.Paths;

public class Main {

    private static final String BASE_PATH = "src/com/gmail/clarkin200/texthandler/files/";

    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        String newFileName = "myfile";
        String content = "Super information.";
        String path = BASE_PATH + newFileName + ".txt";
        getOutput(handler.createFile(path));
        getOutput(handler.writeToFile(Paths.get(path), content));
        getOutput("CONTENT: " + handler.readFromFile(path));
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
