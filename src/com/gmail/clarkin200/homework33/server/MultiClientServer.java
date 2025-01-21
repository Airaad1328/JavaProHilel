package com.gmail.clarkin200.homework33.server;

import com.gmail.clarkin200.homework33.models.Client;
import com.gmail.clarkin200.homework33.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;

public class MultiClientServer {
    private final Logger log = LoggerFactory.getLogger(MultiClientServer.class);
    private static final ConcurrentHashMap<String, Client> activeConnections = new ConcurrentHashMap<>();
    private static int clientCount = 0;

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(Constants.SERVER_PORT)) {

            log.info("[SERVER] the server is running on the port {}", Constants.SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Client client = new Client("Client-" + clientCount, LocalDateTime.now(), clientSocket);
                activeConnections.put(client.getName(), client);
                log.info("[SERVER] {} user connect at time {}", client.getName(),
                        client.getAuthorizationDate().format(DateTimeFormatter.ofPattern("yyyy-M-dd MM:HH")));

                ClientHandler clientHandler = new ClientHandler(client, activeConnections);
                new Thread(clientHandler).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
