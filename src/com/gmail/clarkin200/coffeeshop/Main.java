package com.gmail.clarkin200.coffeeshop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        Scanner scanner = new Scanner(System.in);
        boolean onWork = true;

        while (onWork) {
            System.out.println("Choose operation");
            System.out.println("1. Add order");
            System.out.println("2. Deliver first in queue");
            System.out.println("3. Deliver by ID");
            System.out.println("4. Draw all orders");
            System.out.println("0. Exit");

            int operation = scanner.nextInt();
            scanner.nextLine();

            switch (operation) {
                case 1:
                    System.out.println("Enter order name to add");
                    String newOrderName = scanner.nextLine();
                    orderBoard.add(newOrderName);
                    break;
                case 2:
                    orderBoard.deliver();
                    break;
                case 3:
                    System.out.println("Enter order ID to deliver");
                    Long deliverId = scanner.nextLong();
                    orderBoard.deliver(deliverId);
                    break;
                case 4:
                    orderBoard.draw();
                    break;
                case 0:
                    onWork = false;
                    break;
            }
        }

    }
}
