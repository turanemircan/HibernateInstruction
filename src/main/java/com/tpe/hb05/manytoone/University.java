package com.tpe.hb05.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_universty")
public class University {

    @Id
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    public University() {
    }

    public University(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
