package com.tpe.hb11.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave11 {
    public static void main(String[] args) {

        Student11 student01 = new Student11();
        // student01.setId(1001);
        student01.setName("Jackie jack");
        student01.setGrade(99);

        Student11 student02 = new Student11();
        // student02.setId(1002);
        student02.setName("Fred Çakmaktaş");
        student02.setGrade(97);

        Student11 student03 = new Student11();
        // student03.setId(1002);
        student03.setName("Barnie");
        student03.setGrade(95);

        Student11 student04 = new Student11("Rod", 98);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student11.class); // hibernate.cfg.xml
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // 1001,1002,1003,,,,,,1009,1010
        // 1011,1012,1013

        session.save(student01);
        session.save(student02);
        session.save(student03);
        session.save(student04);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}