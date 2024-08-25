package com.gmail.clarkin200;

public class Customer {

    private final String name;
    private final String phone;

    public Customer(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
}
