package com.gmail.clarkin200.JPAproject.entity;

import com.gmail.clarkin200.JPAproject.DAO.GenericDao;
import com.gmail.clarkin200.JPAproject.DAO.HomeworkDAO;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
@Entity
@Table(name = "students")
public class Student  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Homework> homeworks = new HashSet<>();

    public void addHomework(final Homework homework) {
        this.homeworks.add(homework);
        homework.setStudent(this);
        HomeworkDAO homeworkDAO = new HomeworkDAO();
        homeworkDAO.save(homework);
    }

    public void removeHomework(final Homework homework) {
        homeworks.remove(homework);
        HomeworkDAO homeworkDAO = new HomeworkDAO();
        homeworkDAO.delete(homework);
    }

    public Student(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Homework> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(Set<Homework> homeworks) {
        this.homeworks = homeworks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' + "\n" +
                ", homeworks=" + homeworks +
                '}';
    }
}
