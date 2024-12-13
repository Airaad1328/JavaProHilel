package com.gmail.clarkin200.abstractfactory;

public class Car implements Transport{
    @Override
    public void move(){
        System.out.println("Car is created by CarFactory");
    }

}
