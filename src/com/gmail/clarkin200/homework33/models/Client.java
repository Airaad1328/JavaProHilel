package com.gmail.clarkin200.homework33.models;

import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Client {
    private String name;
    private LocalDateTime authorizationDate;
    private Socket socket;

    public Client(String name, LocalDateTime authorizationDate, Socket socket) {
        this.name = name;
        this.authorizationDate = authorizationDate;
        this.socket = socket;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getAuthorizationDate() {
        return authorizationDate;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAuthorizationDate(LocalDateTime authorizationDate){
        this.authorizationDate = authorizationDate;
    }

    public void setSocket (Socket socket){
        this.socket = socket;
    }




}
