package com.tpe.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {

        Student04 student01 = new Student04(1001, "Emircan Turan", 99);
        Student04 student02 = new Student04(1002, "Ali Can", 78);
        Student04 student03 = new Student04(1003, "Ayşe Yılmaz", 25);

        Diary04 diary01 = new Diary04(99, "Emircan'nın günlüğü");
        Diary04 diary02 = new Diary04(88, "Ayse'nin günlüğü");

        diary01.setStudent(student01);
        diary02.setStudent(student03);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class); // hibernate.cfg.xml
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student01);
        session.save(student02);
        session.save(student03);

        session.save(diary01);
        session.save(diary02);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
