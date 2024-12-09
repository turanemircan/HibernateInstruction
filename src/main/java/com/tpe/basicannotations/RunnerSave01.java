package com.tpe.basicannotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory(); // Database ile app arasında köprü kuruyor.
        Session session = sessionFactory.openSession(); // Kurulan köprü üzerinden bilgi akışı sağlıyor.


    }
}
