package com.tpe.hb12.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave12 {
    public static void main(String[] args) {

        Student12 student01 = new Student12("Jack", 99);
        Student12 student02 = new Student12("Fred", 98);
        Student12 student03 = new Student12("Barnie", 97);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student12.class); // hibernate.cfg.xml
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student01); // serilazable dödürüyor. Direkt DB kaydeder
        session.persist(student02); // void yani hiçbir şey dödürmüyor. Kaydedilirken ekstra id oluşturur. Bu id üzerinden işlem yapar.
        session.persist(student03); // save:deprecated

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
