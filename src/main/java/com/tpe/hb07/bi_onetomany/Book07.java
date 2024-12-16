package com.tpe.hb07.bi_onetomany;

import javax.persistence.*;

@Entity
@Table(name = "t_book07")
public class Book07 { // Many

    @Id
    private Integer id;

    private String name;

    @ManyToOne // FK burada olsun isteriz
    // @JoinColumn // --> OPSİYONEL
    // kullanmazsam JOİNTABLE olur
    private Student07 student07; // One

    public Book07() {
    }

    public Book07(Integer id, String name, Student07 student07) {
        this.id = id;
        this.name = name;
        this.student07 = student07;
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

    public Student07 getStudent07() {
        return student07;
    }

    public void setStudent07(Student07 student07) {
        this.student07 = student07;
    }

    @Override
    public String toString() {
        return "Book07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student07=" + student07 +
                '}';
    }
}
