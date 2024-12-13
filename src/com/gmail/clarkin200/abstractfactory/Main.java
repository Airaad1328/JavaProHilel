package com.gmail.clarkin200.abstractfactory;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();

        client.run("car");
        client.run("plane");
    }
}
