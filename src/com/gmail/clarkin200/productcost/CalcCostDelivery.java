package com.gmail.clarkin200.productcost;

public class CalcCostDelivery extends CalcCostBase {

    private final static double deliveryPrice = 4;

    @Override
    public double calcCost(Product product) {
        return product.getQuota() * product.getPrice()
                + deliveryPrice;
    }
}
