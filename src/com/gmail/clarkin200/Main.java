package com.gmail.clarkin200;

public class Main {
    public static void main(String[] args) {
        Customer customer = getCustomer(getData());

        String output = "Customer: " + customer.getName() + ", phone " + customer.getPhone();

        getOutput(output);
    }

    public static String[] getData() {
        return new String[]{"Renat", "+3045834950"};
    }

    public static Customer getCustomer(String[] data) {
        return new Customer(data[0], data[1]);
    }

    public static void getOutput(String output) {
        System.out.println(output);
    }
}
