package com.gmail.clarkin200.JDBC;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseConnector dbConnector = new DatabaseConnector();
        dbConnector.createTable();

        EmployeeDAO employeeDAO = new EmployeeDAO();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nDatabase Menu");
            System.out.println("1. Add employee");
            System.out.println("2. View All employers");
            System.out.println("3. View employee by ID");
            System.out.println("4. Update employee");
            System.out.println("5. Delete employee");
            System.out.println("0. Exit");
            System.out.println("Please choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter position: ");
                    String position = scanner.nextLine();
                    System.out.println("Enter salary: ");
                    float salary = scanner.nextFloat();
                    scanner.nextLine();

                    employeeDAO.addEmployee(new Employee(0, name, age, position, salary));
                    break;
                case 2:
                    employeeDAO.viewAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();
                    employeeDAO.findEmployeeById(id);
                    break;
                case 4:
                    System.out.println("Enter employee ID to change: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new position: ");
                    String newPosition = scanner.nextLine();
                    System.out.println("Enter new salary: ");
                    float newSalary = scanner.nextFloat();
                    scanner.nextLine();

                    employeeDAO.updateEmployee(new Employee(updateId, newName, newAge, newPosition,newSalary));
                    break;
                case 5:
                    System.out.println("Enter user ID to delete:");
                    int deleteEmployeeID = scanner.nextInt();
                    scanner.nextLine();
                    employeeDAO.deleteEmployeeById(deleteEmployeeID);
                    break;
                case 0:
                    dbConnector.closeConnection();
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }


    }
}
