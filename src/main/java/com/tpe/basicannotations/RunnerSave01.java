package com.tpe.basicannotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {

        Student student01 = new Student();
        student01.setId(1001);
        student01.setName("Emircan");
        student01.setSurname("Turan");
        student01.setGrade(99);

        Student student02 = new Student();
        student02.setId(1002);
        student02.setName("Ali");
        student02.setSurname("Can");
        student02.setGrade(98);

        Student student03 = new Student();
        student03.setId(1003);
        student03.setName("Ayşe");
        student03.setSurname("Yılmaz");
        student03.setGrade(97);

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Employee.class); // cfg dosyasinin ismini yazıyorduk eğer yazmasanız hata vermez çünkü default olarak icerisine "hibernate.cfg.xml" yazar
        SessionFactory sessionFactory = configuration.buildSessionFactory(); // Database ile app arasında köprü kuruyor.
        Session session = sessionFactory.openSession(); // Kurulan köprü üzerinden bilgi akışı sağlıyor.

        // hibernatede default olarak auto-commit false yani sorgular bekler neyi commit komutunu
        // db de işlemlerin kalıcı olmasi icin transaction başlatıp onaylaması gerekiyor
        Transaction transaction = session.beginTransaction();
        // transaction(db'de atomik işlem birimi) başlatılır.

        session.save(student01);
        session.save(student02);
        session.save(student03);

        transaction.commit(); // gümrük tüm işlemleri onayladı geçiş serbest
        session.close();
        sessionFactory.close();
    }
}
