package com.tpe.basicannotations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_employee")
public class Employee {

    @Id
    private Long id;

    private String name;

    private Double salary;

    @Transient // DB'de bu fielda karşılık gelecek sütunun oluşmasını engeller
    private Double bonus;
    // bonus(ek mesai gibi düşün) tabloda yer almasına gerek yok
    // getter-setter

    // @Lob // Large Object : bu sütunun database'de büyük boyutlu dataları saklamasını saglar:resim,video,ses,cv vb.
    // private byte[] image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    // toString

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                '}';
    }
}
