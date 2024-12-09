package com.tpe.basicannotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Hedef:
// dataları persist etmek icin bu classa karsılık bir tablo gereklidir
// tablonun sutunları : id,name,surname,grade
// create table student(id int ,name varchar()...);
// hibernate(ORM) bizim icin bu hedefi otomatik olarak yapar.

@Entity // Bu sınıfın DB'de bir tabloya karşılık gelmesini saglıyor, tablonun adi: student
@Table(name = "t_student") // Tablomuzun istediğimiz ismi verilmesini saglar
// Biz burada pojo cLassLarı direkt olarak buyuk harfle isimlendiririz(Student)
// DB SQLCE t_student isimlendirilir
public class Student { // pojo class

    @Id // id sütunun PK olmasını saglar
    // @Column(name = "std_no")
    private Integer id; // ismi id olmak zorunda değil örnek student_no diyebiliriz // Integer'in default degeri ise=null idi; // int'in default degeri = 0;

    @Column(name = "std_name", unique = false, nullable = false, length = 50) // default : varchar(255)
    private String name;

    @Column(name = "std_surname", unique = false, nullable = false, length = 30)
    private String surname;

    private int grade; // null olması durumu kontrol edilmiyor = 0  gr

    // getter-setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    // toString

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", grade=" + grade +
                '}';
    }
}