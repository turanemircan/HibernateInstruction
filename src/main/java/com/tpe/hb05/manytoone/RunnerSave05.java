package com.tpe.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {

        Student05 student01 = new Student05(1001, "Emircan Turan", 99);
        Student05 student02 = new Student05(1002, "Ali Can", 78);
        Student05 student03 = new Student05(1003, "Ayşe Yılmaz", 25);

        University university01 = new University(59, "Tekirdağ namık Kemal Universty");
        University university02 = new University(60, "Techpro Education Universty");

        student01.setUniversity(university01);
        student02.setUniversity(university02);
        student03.setUniversity(university02);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student05.class).addAnnotatedClass(University.class); // hibernate.cfg.xml
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student01);
        session.save(student02);
        session.save(student03);

        session.save(university01);
        session.save(university02);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
