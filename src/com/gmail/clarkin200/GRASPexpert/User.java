package com.gmail.clarkin200.GRASPexpert;

public class User {
    private final String name;
    private final int id;
    private final Address address;

    public User(String name, int id, Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }


    public String getAddress() {
        return address.getCity() + " " + address.getStreet();
    }

    public void setAddress(String city, String street) {
        this.address.setCity(city);
        this.address.setStreet(street);
    }
}
