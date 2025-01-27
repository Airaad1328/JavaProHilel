package com.gmail.clarkin200.JDBC;

import java.sql.*;

public class EmployeeDAO {

    public void addEmployee(Employee employee) {
        String insertEmployeeSQL = "INSERT INTO employees(name,age,position,salary) " +
                "VALUES(?,?,?,?);";

        Connection connection = DatabaseConnector.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(insertEmployeeSQL)) {
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getAge());
            statement.setString(3, employee.getPosition());
            statement.setFloat(4, employee.getSalary());

            statement.executeUpdate();

            System.out.println("Employee added successfully");

        } catch (SQLException e) {
            System.out.println("Can't create statement to insertEmployee");
        }
    }

    public void viewAllEmployee() {
        String selectAllEmployeeSQL = "SELECT * FROM employees;";

        Connection connection = DatabaseConnector.getConnection();

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(selectAllEmployeeSQL);

            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("position"),
                        resultSet.getFloat("salary")
                );

                System.out.println(employee);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void findEmployeeById(int id) {
        String selectEmployeeByID = "SELECT * FROM employees WHERE id = ?;";

        Connection connection = DatabaseConnector.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectEmployeeByID)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Employee employee = new Employee(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("age"),
                            resultSet.getString("position"),
                            resultSet.getFloat("salary")
                    );

                    System.out.println(employee);
                } else {
                    System.out.println("Employee with id " + id + " not found ");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateEmployee(Employee employee) {
        String updateEmployeeSQL = "UPDATE employees SET name = ?, age = ?, position = ?, salary = ? WHERE id = ?;";

        Connection connection = DatabaseConnector.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateEmployeeSQL)) {

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getAge());
            preparedStatement.setString(3, employee.getPosition());
            preparedStatement.setFloat(4, employee.getSalary());
            preparedStatement.setInt(5, employee.getId());

            int countRow = preparedStatement.executeUpdate();
            System.out.println("Rows updated: " + countRow);

        } catch (SQLException e) {
            System.out.println("Employee with id " + employee.getId() + " not found ");
        }
    }

    public void deleteEmployeeById(int id) {
        String deleteEmployeeSQL = "DELETE FROM employees WHERE id = ?;";

        Connection connection = DatabaseConnector.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteEmployeeSQL)) {
            preparedStatement.setInt(1, id);

            System.out.println("Deleted employees with id : " + id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Employee with id " + id + " not found ");
        }
    }
}
