package com.tpe.hb02.embeddable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {

        Student02 student01 = new Student02(1001, "Emircan Turan", 99);
        Student02 student02 = new Student02(1002, "Ali Can", 99);
        Student02 student03 = new Student02(1003, "Ayşe Yılmaz", 99);

        Address address01 = new Address("Orange Street", "London", "UK", "1234");
        Address address02 = new Address("Apple Street", "New York", "USA", "9876");

        student01.setAddress(address01);
        student02.setAddress(address02);
        student03.setAddress(address01);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student02.class); // hibernate.cfg.xml
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(student01);
        session.save(student02);
        session.save(student03);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
