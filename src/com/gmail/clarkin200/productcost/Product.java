package com.gmail.clarkin200.productcost;

public class Product {

    String name;
    int quota;
    double price;

    public Product(String name, int quota, double price) {
        this.name = name;
        this.quota = quota;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getQuota() {
        return quota;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product: " + name +
                ", quota is " + quota + " " +
                Constants.MEASURE +
                ", price is " + Constants.CURRENCY +
                " " + price + ".";
    }
}
