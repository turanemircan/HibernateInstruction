package com.tpe.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {
    public static void main(String[] args) {

        Configuration config = new Configuration().configure().addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class); // hibernate.cfg.xml
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        /*
        // id'si 101 olan kıtabi getirelim
        Book07 book = session.get(Book07.class, 101);
        // System.out.println(book);
        // System.out.println(book.getStudent());
        */

        /*
        // id'si 1003 öğrenciye erişmek istersem
        Student07 student01 = session.get(Student07.class, 1003);
        System.out.println(student01);

        // yukarıdaki öğrencinin kıtap bilgilerini cagırın
        System.out.println(student01.getBookList());
        */

        /*
        // book07 tablosundaki tüm kıtapları silelim
        String hql01 = "delete from Book07";
        int deletedBooks = session.createQuery(hql01).executeUpdate();
        System.out.println("Silinen kitap sayısı : " + deletedBooks);
        System.out.println(student01.getBookList());
        */

        /*
        // student07 tablosundaki verileri silelim
        String hql02 = "delete from Student07";
        int deleteStudents = session.createQuery(hql02).executeUpdate();
        System.out.println("silinen öğrenci sayisi : " + deleteStudents);
        */

        /*
        // ismi Sefiller olan kıtabı hql ile silelim
        String hql03 = "Delete from Book07 b where b.name='Sefiller'";
        int numDeletedBook = session.createQuery(hql03).executeUpdate();
        System.out.println("silinen satır sayisi : " + numDeletedBook);
        */
        /*
        // id'si 1002 olan öğrenciyi silelim
        Student07 student02 = session.get(Student07.class, 1002);
        session.delete(student02);
        */

        // kitap bilgisi olan bir öğrenci silmek istersek
        // 1.Yol) bunun için öğrencinin sahip olduğu kitapları silmemiz gerekir
        // 2.Yol) cascade yapısını eklemek

        // id'si 1001 olan öğrencinin kitap listesinden bir kıtabi silelim
        Student07 student03 = session.get(Student07.class, 1001);
        student03.getBookList().remove(0);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
