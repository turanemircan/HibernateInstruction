package com.tpe.hb03.uni_onetoone;

import javax.persistence.*;

@Entity
@Table(name = "t_diary")
public class Diary { // ONE

    @Id
    private Integer id;

    private String name;

    @OneToOne // diary ile t_student03 arasında 1-1 ilişki kurulmasını sağlar.
    // Bunun için diary'e FK ekler, default ismi : student_id
    @JoinColumn(name = "std_id", unique = true) // default ismi değiştirmek istiyorsak kullanırız.
    private Student03 student; // ONE

    public Diary() {
    }

    public Diary(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
