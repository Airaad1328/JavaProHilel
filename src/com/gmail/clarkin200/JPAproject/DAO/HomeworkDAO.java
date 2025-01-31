package com.gmail.clarkin200.JPAproject.DAO;

import com.gmail.clarkin200.JPAproject.Utils.HibernateUtil;
import com.gmail.clarkin200.JPAproject.entity.Homework;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HomeworkDAO {
    public void save(Homework entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
    }
    public Homework findById(Long id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Homework.class,id);
        }
    }

    public List<Homework> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Homework> fromHomework = session.createQuery("from Homework", Homework.class);
            return fromHomework.list();
        }
    }

    public Homework update(Homework entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            return entity;
        }
    }

    public void delete(Homework homework) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(homework);
            transaction.commit();
        }
    }
}
