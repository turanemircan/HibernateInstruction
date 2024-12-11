package com.tpe.hb03.uni_onetoone;

import com.tpe.hb02.embeddable.Student02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {
        Student03 student01 = new Student03(1001, "Emircan Turan", 99);
        Student03 student02 = new Student03(1002, "Ali Can", 99);
        Student03 student03 = new Student03(1003, "Ayşe Yılmaz", 99);

        Diary diary01 = new Diary(11, "X");
        Diary diary02 = new Diary(22, "Y");
        Diary diary03 = new Diary(33, "Z");

        //-------------------------------------------------------------------------------------
        // diary01 ile student1 ilişkilendirelim
        diary01.setStudent(student01);
        diary02.setStudent(student02);
        diary03.setStudent(student03);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class); // hibernate.cfg.xml
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student01);
        session.save(student02);
        session.save(student03);

        session.save(diary01);
        session.save(diary02);
        session.save(diary03);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
