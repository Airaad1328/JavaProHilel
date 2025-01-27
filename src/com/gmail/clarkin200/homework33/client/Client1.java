package com.gmail.clarkin200.homework33.client;

import com.gmail.clarkin200.homework33.server.ClientHandler;
import com.gmail.clarkin200.homework33.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client1 {
    private static final Logger log = LoggerFactory.getLogger(ClientHandler.class);
    public static void main(String[] args) {
        try (Socket socket = new Socket(Constants.HOST, Constants.SERVER_PORT)) {

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            log.info("[CLIENT] Connecting to server with port {}",Constants.SERVER_PORT);

            String userCommand;
            while (true) {
                System.out.println("Enter command exit to leave server");
                userCommand = userInput.readLine();
                out.println(userCommand);

                if ("exit".equals(userCommand)) {
                    log.info("[CLIENT] Exit ...");
                    break;
                }
                if("info".equalsIgnoreCase(userCommand)){
                    out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
