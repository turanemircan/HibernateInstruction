package com.tpe.hb08.manytomany;

import com.tpe.hb07.bi_onetomany.Book07;
import com.tpe.hb07.bi_onetomany.Student07;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave08 {
    public static void main(String[] args) {

        Student08 student01 = new Student08(1001, "Emircan", 99);
        Student08 student02 = new Student08(1002, "Jack", 98);
        Student08 student03 = new Student08(1003, "Harry", 97);
        Student08 student04 = new Student08(1004, "David", 96);

        Course course01 = new Course(101, "Adv Java");
        Course course02 = new Course(102, "Hibernate");
        Course course03 = new Course(103, "JDBC");

        student01.getCourseList().add(course01);
        student01.getCourseList().add(course02);
        student01.getCourseList().add(course03);
        student02.getCourseList().add(course02);
        student02.getCourseList().add(course03);
        student03.getCourseList().add(course03);
        student04.getCourseList().add(course02);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student08.class).addAnnotatedClass(Course.class); // hibernate.cfg.xml
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student01);
        session.save(student02);
        session.save(student03);
        session.save(student04);

        session.save(course01);
        session.save(course02);
        session.save(course03);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
