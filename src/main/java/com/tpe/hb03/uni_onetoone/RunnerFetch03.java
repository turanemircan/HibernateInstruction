package com.tpe.hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration config = new Configuration().configure().addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class); // hibernate.cfg.xml
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // id 1001 olan öğrenciyi görüntüleyelim
        Student03 student01 = session.get(Student03.class, 1001);
        System.out.println(student01);

        // id 11 olan günlüğü getirelim
        Diary diary01 = session.get(Diary.class, 11);
        System.out.println(diary01);

        System.out.println(diary01.getStudent()); // günlüğe sahip olan öğrencinin bilgilerini getir

        // id 1002 olan öğrenciye ait günlüğü bulmak istersek ne yapıcaz?
        Student03 student02 = session.get(Student03.class, 1002);
        // student02.getDiary(); // --> ilişkiyi diary üzerinden kurduk java kodlari buna ulasamıyoruz o zmn ne yapıcaz DB'den cekebiliriz
        String diaryName = (String) session.createSQLQuery("select name from t_diary where std_id=1002").uniqueResult();

        /*
        PROBLEM : sorgu yazmadan diaryden studenta ulşabiliyorkey ,studentta diarye ulaşamıyorum
        ulaşmak istersem?

        // uni_directional(Tek Yönlü) : Diary  -->Student
        // bi_directional(Çift Yönlü) : Diary <-->Student(veritabanında birşey değişmez) :)
        */
    }
}
