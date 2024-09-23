package com.gmail.clarkin200.filehandler;

public class Main {

    private final static String BASE_PATH = "src/com/gmail/clarkin200/filehandler/files/";

    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        String fileName = "myfile";
        String fileContent = "My very important information.";
        String result = handler.writeFile(fileName, fileContent);
        String content = handler.readFile(BASE_PATH + fileName + ".txt");
        getOutput("RESULT: " + result);
        getOutput("FILE CONTENT: " + content);
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
