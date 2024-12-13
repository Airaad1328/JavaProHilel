package com.gmail.clarkin200.abstractfactory;

public class Client {
    public void run(String transport) {
        CarFactory carFactory = new CarFactory();
        PlaneFactory planeFactory = new PlaneFactory();
        if (transport.equalsIgnoreCase("car")) {
            Transport car = carFactory.createTransport();
            car.move();
        } else if (transport.equalsIgnoreCase("plane")) {
            Transport plane = planeFactory.createTransport();
            plane.move();
        } else {
            throw new IllegalArgumentException("Non valid value");
        }
    }
}
