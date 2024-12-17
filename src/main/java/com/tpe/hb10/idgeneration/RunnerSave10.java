package com.tpe.hb10.idgeneration;

import com.tpe.hb09.fetchtypes.Book09;
import com.tpe.hb09.fetchtypes.Student09;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {
    public static void main(String[] args) {

        Student10 student01 = new Student10();
        // student01.setId(1001);
        student01.setName("Jackie jack");
        student01.setGrade(99);

        Student10 student02 = new Student10();
        // student02.setId(1002);
        student02.setName("Fred Çakmaktaş");
        student02.setGrade(97);

        Student10 student03 = new Student10();
        // student03.setId(1002);
        student03.setName("Barnie");
        student03.setGrade(95);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student10.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction trs = session.beginTransaction();

        // 1001,1002,1003,,,,,,1009,1010
        // 1011,1012,1013
        session.save(student03);

        trs.commit();
        session.close();
        sessionFactory.close();
    }
}