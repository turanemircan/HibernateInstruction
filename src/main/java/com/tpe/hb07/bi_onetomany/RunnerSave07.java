package com.tpe.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {

        Student07 student01 = new Student07(1001, "Emircan", 99);
        Student07 student02 = new Student07(1002, "Jack", 98);
        Student07 student03 = new Student07(1003, "Harry", 97);

        Book07 book01 = new Book07(101, "Suç ve Ceza", student01);
        Book07 book02 = new Book07(102, "Olasılıksız", student02);
        Book07 book03 = new Book07(103, "1984", student02);
        Book07 book04 = new Book07(104, "Hayvan Çiftliği", student03);
        Book07 book05 = new Book07(105, "Beyaz Kale", student01);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class); // hibernate.cfg.xml
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student01);
        session.save(student02);
        session.save(student03);

        session.save(book01);
        session.save(book02);
        session.save(book03);
        session.save(book04);
        session.save(book05);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
