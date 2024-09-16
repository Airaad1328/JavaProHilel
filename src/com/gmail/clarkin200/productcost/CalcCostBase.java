package com.gmail.clarkin200.productcost;

public class CalcCostBase {

    public double calcCost(Product product) {
        return product.getQuota() * product.getPrice();
    }
}
