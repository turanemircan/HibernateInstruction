package com.tpe.hb08.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_course")
public class Course {

    @Id
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "courseList")
    private List<Student08> studentList = new ArrayList<>();

    public Course() {
    }

    public Course(Integer id, String name) {
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

    public List<Student08> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student08> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}