package com.tpe.basicannotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

// Uygulamaya veritabanından data çekme işlemi sağlar.
public class RunnerFetch01 {
    public static void main(String[] args) {

        /*
           DB den data cekmek icin
           Task id=1001 olan öğrenciyi tüm fieldlarıyla birlikte getirmek(fetch)istiyoruz
           1) session methodu:get() en pratik ama kullanım alanı kısıtlı
           2) SQL kodu oluşturarak DB'ce
           3) HQL (Hibernate Query Language), Hibernate ORM tarafından sağlanan,
           nesne odaklı bir sorgulama dilidir. HQL, SQL'e benzer şekilde çalışır
           ancak doğrudan veritabanı tablolarıyla değil,
           Java sınıfları (entity'ler) ve onların özellikleriyle çalışır
        */

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // 1) session icerisinde bulunan get methodunu id ile veri cekerken kullanabiliriz
        Student student01 = session.get(Student.class, 1001); // student classında database'de karsılık gelen tablosuna git ve 1001 id'sine sahip degeri getir
        System.out.println(student01);

        // 2) SQL
        System.out.println("--------------- SQL ---------------");
        String sql = "select * from t_student where id=1002";
        Object[] student02 = (Object[]) session.createSQLQuery(sql).uniqueResult(); // Tek değer geldiği zaman uniqueResult() kullanmak zorundayız.
        // uniqueResult(): sorgunun tek satır getirecegi durumlarda kullanılır
        // geriye bir satırdan birden fazla farklı data geldigi icin data tipleri farklı oldugu icin
        // Object[] icine alınır
        System.out.println(Arrays.toString(student02));

        // 3) HQL Javaca // SQL sorgusu gibi çalışıyor ama javadaki isimlendirme ile
        System.out.println("--------------- HQL ---------------");
        String hql = "From Student Where id= 1003";
        Student student03 = session.createQuery(hql, Student.class).uniqueResult(); // Tek değer geldiği zaman uniqueResult() kullanmak zorundayız.
        System.out.println(student03);

        // Tüm kayıtları çekelim
        // HQL
        List<Student> studentList = session.createQuery("From Student", Student.class).getResultList();
        // Birden fazla kayıt ya da veri donduruldugunde getResultList() kullanılır.
        System.out.println("Tüm Öğrenciler");
        for (Student s : studentList) {
            System.out.println(s);
        }

        // SQL
        System.out.println("--------------- SQL ---------------");

        String sql02 = "select std_name from t_student";
        List<String> studentName = session.createSQLQuery(sql02).getResultList();
        for (String name : studentName) {
            System.out.println("Name = " + name);
        }

        //HQL ile grade degeri 98 olan ogrencilerin id ve name bilgilerini getirelim

        String hql2 = "select id,name from Student where grade=98";
        List<Object[]> resultList02 = session.createQuery(hql2).getResultList();
        for (Object[] a : resultList02
        ) {
            System.out.println(Arrays.toString(a));
        }

        session.close();
        sessionFactory.close();

        // practice:HQL ile
        // 1-ismi Ali Can olan öğrencileri getirelim


        // 2-tüm öğrencilerin sadece isimlerini getirelim
        // SQL ile
        // 1-tüm öğrencilerin sadece isimlerini getirelim
    }
}
