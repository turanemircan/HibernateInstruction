package com.tpe.hb06.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {
    public static void main(String[] args) {

        Student06 student01 = new Student06(1001, "Emircan", 99);
        Student06 student02 = new Student06(1002, "Jack", 98);
        Student06 student03 = new Student06(1003, "Harry", 97);

        Book book01 = new Book(101, "Suç ve Ceza");
        Book book02 = new Book(102, "Olasılıksız");
        Book book03 = new Book(103, "1984");
        Book book04 = new Book(104, "Hayvan Çiftliği");
        Book book05 = new Book(105, "Beyaz Kale");

        student01.getBookList().add(book01);
        student01.getBookList().add(book02);
        student02.getBookList().add(book03);
        student02.getBookList().add(book04);
        student03.getBookList().add(book05);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student06.class).addAnnotatedClass(Book.class); // hibernate.cfg.xml
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
