package com.gmail.clarkin200.JPAproject;

import com.gmail.clarkin200.JPAproject.DAO.GenericDao;
import com.gmail.clarkin200.JPAproject.DAO.HomeworkDAO;
import com.gmail.clarkin200.JPAproject.DAO.StudentDAO;
import com.gmail.clarkin200.JPAproject.entity.Homework;
import com.gmail.clarkin200.JPAproject.entity.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        GenericDao<Student, Long> genericDao = new StudentDAO();
        HomeworkDAO homeworkDAO = new HomeworkDAO();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nDatabase Menu");
            System.out.println("1. Add student");
            System.out.println("2. View All students");
            System.out.println("3. View student by ID");
            System.out.println("4. Update student");
            System.out.println("5. Delete student");
            System.out.println("6. Add Homework to Students by ID");
            System.out.println("7. Delete Homework by Student ID");
            System.out.println("8. Find Students by Email");
            System.out.println("9. Find all Homeworks");
            System.out.println("10. Update Homework by ID");
            System.out.println("0. Exit");
            System.out.println("Please choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.println("Enter email: ");
                    String email = scanner.nextLine();

                    genericDao.save(new Student(0L, firstName, lastName, email));
                    break;
                case 2:
                    genericDao.findAll().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Enter id: ");
                    Long id = scanner.nextLong();
                    Student findedStudent = genericDao.findById(id);
                    System.out.println(findedStudent);
                    break;
                case 4:
                    System.out.println("Enter employee ID to change: ");
                    Long updateId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter new first name: ");
                    String newFirstName = scanner.nextLine();
                    System.out.println("Enter last name: ");
                    String newLastName = scanner.nextLine();
                    System.out.println("Enter new email: ");
                    String newEmail = scanner.nextLine();

                    genericDao.update(new Student(updateId, newFirstName, newLastName, newEmail));
                    break;
                case 5:
                    System.out.println("Enter user ID to delete:");
                    Long deleteStudentID = scanner.nextLong();
                    scanner.nextLine();
                    genericDao.deleteById(deleteStudentID);
                    break;

                case 6:
                    System.out.println("Enter Student ID to add Homework");
                    Long addHomeWorkID = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter Homework description");
                    String description = scanner.nextLine();
                    System.out.println("Enter Homework deadline format like dd-MM-yyyy:");
                    String deadline = scanner.nextLine();
                    System.out.println("Enter mark for Homework");
                    int mark = scanner.nextInt();
                    scanner.nextLine();

                    Student addHomeStudent = genericDao.findById(addHomeWorkID);
                    Homework addedHomework = new Homework(0L, description, dateParser(deadline), mark, addHomeStudent);
                    addHomeStudent.addHomework(addedHomework);

                    break;
                case 7:
                    System.out.println("Enter Student ID to delete homework");
                    Long StudentId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter Homework ID to delete");
                    Long homeworkId = scanner.nextLong();
                    Student studentToDeleteHome = genericDao.findById(StudentId);
                    Homework deletedHomework = homeworkDAO.findById(homeworkId);
                    studentToDeleteHome.removeHomework(deletedHomework);
                    break;
                case 8:
                    System.out.println("Enter Student email");
                    String studentEmail = scanner.nextLine();
                    System.out.println(genericDao.findByEmail(studentEmail));

                    break;
                case 9:
                    homeworkDAO.findAll().forEach(System.out::println);
                    break;
                case 10:
                    System.out.println("Enter Homework ID to Update");
                    Long idToUpdate = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter Homework description");
                    String newDescription = scanner.nextLine();
                    System.out.println("Enter Homework deadline format like dd-MM-yyyy:");
                    String newDeadline = scanner.nextLine();
                    System.out.println("Enter mark for Homework");
                    int newMark = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Student ID for Homework");
                    Long newStudentId = scanner.nextLong();
                    scanner.nextLine();

                    homeworkDAO.update(new Homework(idToUpdate,newDescription,dateParser(newDeadline)
                            ,newMark,genericDao.findById(newStudentId)));

                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }

    public static LocalDate dateParser(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, formatter);
    }
}

