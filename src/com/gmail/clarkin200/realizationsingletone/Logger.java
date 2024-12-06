package com.gmail.clarkin200.realizationsingletone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger instance;
    private final String LOG_PATH = "src/com/gmail/clarkin200/realizationsingletone/logfiles/";

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void logMessage(String message) {
        String fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY_HH-mm"));
        Path filePath = Paths.get(LOG_PATH + fileName);

        try {
            Files.writeString(filePath, message + "\n",
                    StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Помилка запису файла.");
        }
    }

    public void showMessage(String fileName) {
        Path filePath = Paths.get(LOG_PATH + fileName);

        try {
            System.out.println(Files.readString(filePath));
        } catch (IOException e) {
            System.out.println("Файл для читання не знайдено.");
        }
    }

}
