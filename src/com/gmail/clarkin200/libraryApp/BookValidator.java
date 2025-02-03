package com.gmail.clarkin200.libraryApp;

import com.gmail.clarkin200.homework33.server.ClientHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookValidator {

    private static final Logger log = LoggerFactory.getLogger(BookValidator.class);

    public static boolean isFieldTitleValidated(String input){
        if(input == null){
            log.info("Field title can't be null");
            return false;
        }

        if (input.isEmpty()) {
            log.info("Field title can't be empty");
            return false;
        } else if (!input.matches("[a-zA-Z0-9\\s]+")) {
            log.info("Field title can't contains special symbols");
            return false;
        } else if (input.length() >= 10) {
            log.info("Field title must be shorter than 10 characters");
            return false;
        } else {
            return true;
        }
    }

    public static boolean isFieldAuthorValidated(String input){
        if(input == null){
            log.info("Field author can't be null");
            return false;
        }

        if (input.isEmpty()) {
            log.info("Field author can't be empty");
            return false;
        } else if (!input.matches("[a-zA-Z\\s]+")) {
            log.info("Field author can't contains special symbols and numbers ");
            return false;
        } else if (input.length() >= 25) {
            log.info("Field author must be shorter than 25 characters");
            return false;
        } else {
            return true;
        }

    }
}
