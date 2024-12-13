package com.gmail.clarkin200.abstractfactory;

public class PlaneFactory extends TransportFactory{
    @Override
    public Transport createTransport() {
        return new Plane();
    }
}
