package com.gmail.clarkin200.GRASPexpert;

public class Main {
    public static void main(String[] args) {
        Address userAddress = new Address();
        User user = new User("Renat", 1, userAddress);

        user.setAddress("Kyiv", "Revutskogo");

        System.out.println("Address user with id " + user.getId()
                + " and name: " + user.getName() + " is " + user.getAddress());
    }

}
