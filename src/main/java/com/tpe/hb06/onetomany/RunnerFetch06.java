package com.tpe.hb06.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch06 {
    public static void main(String[] args) {

        Configuration config = new Configuration().configure().addAnnotatedClass(Student06.class).addAnnotatedClass(Book.class); // hibernate.cfg.xml
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // id 101 olan kitabı getirelim (3 yöntem var sql hql get)

        Book book01 = session.get(Book.class, 101);
        System.out.println(book01);

        // Yukardaki metodun kime ait olduğunu nasıl bulurum --> method yok hql/sql ile yapabiliriz.
        // ODEV

        // id 1001 olan öğrenciyi getirelim
        Student06 student01 = session.get(Student06.class, 1001);
        System.out.println(student01);

        System.out.println("----------- Ogrencinin Sahip Oldugu Kitaplar -----------");
        System.out.println(student01.getBookList());

        // Ben öğrenci bilgisini sorguladıgım zaman sadece ogrenci bilgileri sorgulanırken
        // ogrencinin sahip oldugu kitapları getir dedigim zaman bizim icin 2. bir sorgu olusturarak kitap bilgilerine erisildi

    }
}
