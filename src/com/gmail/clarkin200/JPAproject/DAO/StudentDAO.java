package com.gmail.clarkin200.JPAproject.DAO;

import com.gmail.clarkin200.JPAproject.Utils.HibernateUtil;
import com.gmail.clarkin200.JPAproject.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAO implements GenericDao<Student,Long>{

    @Override
    public void save(Student entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
    }

    @Override
    public Student findById(Long aLong) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Student.class, aLong);
        }
    }

    @Override
    public Student findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Student WHERE email = :email", Student.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }

    @Override
    public List<Student> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Student> fromStudent = session.createQuery("from Student", Student.class);
            return fromStudent.list();
        }
    }

    @Override
    public Student update(Student entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            return entity;
        }
    }

    @Override
    public boolean deleteById(Long aLong) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = findById(aLong);
            if (student != null) {
                session.delete(student);
                transaction.commit();
                return true;
            }
            return false;
        }
    }

}
