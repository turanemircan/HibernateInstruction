/*
package com.tpe.hb09.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {
    public static void main(String[] args) {

        Student09 student01 = new Student09();
        Student09 student02 = new Student09();
        Student09 student03 = new Student09();
        Student09 student04 = new Student09();

        student01.setId(1001);
        student01.setName("Emircan Turan");
        student01.setGrade(99);

        student02.setId(1002);
        student02.setName("Ali Can");
        student02.setGrade(97);

        student03.setId(1003);
        student03.setName("Ayşe Yılmaz");
        student03.setGrade(95);

        student04.setId(1004);
        student04.setName("Zehra Nur");
        student04.setGrade(98);

        Book09 book01 = new Book09();
        book01.setId(11);
        book01.setName("A Book");

        Book09 book02 = new Book09();
        book02.setId(22);
        book02.setName("B Book");

        Book09 book03 = new Book09();
        book03.setId(33);
        book03.setName("C Book");

        Book09 book04 = new Book09();
        book04.setId(44);
        book04.setName("D Book");

        Book09 book05 = new Book09();
        book05.setId(55);
        book05.setName("E Book");

        //ilişki kurulmasi için book tarafından set edilmeli
        book01.setStudent(student01);
        book02.setStudent(student01);
        book03.setStudent(student02);
        book04.setStudent(student03);
        book05.setStudent(student03);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class); // hibernate.cfg.xml
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(book01);
        session.save(book02);
        session.save(book03);
        session.save(book04);
        session.save(book05);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
*/
package com.tpe.hb09.fetchtypes;

import com.tpe.hb08.manytomany.Course;
import com.tpe.hb08.manytomany.Student08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {
    public static void main(String[] args) {
        Student09 student1 = new Student09();
        Student09 student2 = new Student09();
        Student09 student3 = new Student09();
        Student09 student4 = new Student09();

        student1.setId(1001);
        student1.setName("Ali Can");
        student1.setGrade(99);

        student2.setId(1002);
        student2.setName("Veli Han");
        student2.setGrade(97);

        student3.setId(1003);
        student3.setName("Ayşe Can");
        student3.setGrade(95);

        student4.setId(1004);
        student4.setName("Ömer Faruk");
        student4.setGrade(98);

        Book09 book1 = new Book09();
        book1.setId(11);
        book1.setName("A Book");

        Book09 book2 = new Book09();
        book2.setId(22);
        book2.setName("B Book");

        Book09 book3 = new Book09();
        book3.setId(33);
        book3.setName("C Book");

        Book09 book4 = new Book09();
        book4.setId(44);
        book4.setName("D Book");

        Book09 book5 = new Book09();
        book5.setId(55);
        book5.setName("E Book");

        //ilişki kurulmasi için book tarafından set edilmeli
        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student3);
        book5.setStudent(student3);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction trs = session.beginTransaction();

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);
/*
        //CascadeType.ALL
        session.save(student4);
*/

        trs.commit();
        session.close();
        sessionFactory.close();
    }
}