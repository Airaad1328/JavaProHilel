package com.gmail.clarkin200.homework33.server;

public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            MultiClientServer server = new MultiClientServer();
            server.start();
        }).start();
    }
}
