package com.gmail.clarkin200.abstractfactory;

public class Plane implements Transport{
    @Override
    public void move(){
        System.out.println("Plane is created by PlaneFactory");
    }
}
