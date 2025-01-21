package com.gmail.clarkin200.homework33.server;

import com.gmail.clarkin200.homework33.models.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;

public class ClientHandler implements Runnable {

    private final Logger log = LoggerFactory.getLogger(ClientHandler.class);
    private final Client client;
    private final ConcurrentHashMap<String, Client> activeConnections;

    public ClientHandler(Client client, ConcurrentHashMap<String, Client> activeConnections) {
        this.client = client;
        this.activeConnections = activeConnections;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getSocket().getInputStream()))) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                log.info("[SERVER] отримано від {}: {}", client.getName(), inputLine);
                if (inputLine.equals("exit")) {
                    log.info("[SERVER] {} відключився", client.getName());
                    activeConnections.remove(client.getName());
                    break;
                }
                if (inputLine.equalsIgnoreCase("info")) {
                    PrintWriter out = new PrintWriter(client.getSocket().getOutputStream(), true);
                    out.println("Name:" + client.getName() + client.getAuthorizationDate()
                            .format(DateTimeFormatter.ofPattern("yyyy-M-dd MM:HH")));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                client.getSocket().close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
