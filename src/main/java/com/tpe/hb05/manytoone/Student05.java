package com.tpe.hb05.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_student05")
public class Student05 {
    @Id
    private Integer id;

    @Column(name = "std_name", nullable = false, unique = true, length = 50)
    private String name;

    private int grade;

    private LocalDateTime createOn; // Olusturuldugu tarih diğer bir değişle üniversiteye kayıt tarihi

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @PrePersist
    public void prePersist() {
        createOn = LocalDateTime.now();
    }

    public Student05() {
    }

    public Student05(Integer id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

//    public void setCreateOn(LocalDateTime createOn) {
//        this.createOn = createOn;
//    }

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
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", university=" + university +
                '}';
    }
}
