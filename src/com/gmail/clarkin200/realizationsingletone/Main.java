package com.gmail.clarkin200.realizationsingletone;


public class Main {
    public static void main(String[] args) {

        Logger log = Logger.getInstance();
        Logger logToTest = Logger.getInstance();
        Logger logToShow = Logger.getInstance();

        log.logMessage("Log this from log");
        log.logMessage("Log this from log");
        logToTest.logMessage("Log this from logToTest");

        logToShow.showMessage("06-12-2024_03-24");

    }
}
