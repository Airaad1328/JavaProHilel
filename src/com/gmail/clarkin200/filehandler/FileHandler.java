package com.gmail.clarkin200.filehandler;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private final static String BASE_PATH = "src/com/gmail/clarkin200/filehandler/files/";

    public String writeFile(String fileName, String fileContent) {
        try (FileWriter fw = new FileWriter(BASE_PATH + fileName + ".txt")) {
            fw.write(fileContent);
            return "Success.";
        } catch (Exception e) {
            return "Can't create a file: " + e.getMessage();
        }
    }

    public String readFile(String path) {
        try (FileReader reader = new FileReader(path)) {
            int sym;
            StringBuilder stringBuilder = new StringBuilder();
            while ((sym = reader.read()) != -1) {
                stringBuilder.append((char) sym);
            }
            return stringBuilder.toString();
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }
}
