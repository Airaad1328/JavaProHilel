package com.gmail.clarkin200.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
    private static Connection connection;

    public DatabaseConnector() {
        try {
            connection = DriverManager.getConnection(DBProperties.URL, DBProperties.USER, DBProperties.PASSWORD);
        } catch (SQLException e) {
            System.out.println("Unable to connect" + e.getMessage());
        }
    }

    public void createTable () {
        try(Statement statement = connection.createStatement();){
            String employeesTable = "CREATE TABLE IF NOT EXISTS employees(" +
                    "id SERIAL PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "age INTEGER," +
                    "position VARCHAR(50)," +
                    "salary NUMERIC(10,2));";
            statement.execute(employeesTable);
        } catch (SQLException e) {
            System.out.println("Can't create table employees");
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Unable to close connection " + e.getMessage());
        }
    }
}

