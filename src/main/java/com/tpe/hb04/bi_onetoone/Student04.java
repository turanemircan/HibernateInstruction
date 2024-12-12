package com.tpe.hb04.bi_onetoone;

import javax.persistence.*;

@Entity
@Table(name = "t_student04")
public class Student04 {

    @Id
    private Integer id;

    @Column(name = "std_name", nullable = false, unique = true, length = 50)
    private String name;

    private int grade;

    @OneToOne(mappedBy = "student")
    private Diary04 diary;

    public Student04() {
    }

    public Student04(Integer id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Diary04 getDiary() {
        return diary;
    }

    public void setDiary(Diary04 diary) {
        this.diary = diary;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
