package org.example.entity;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "dependent")
public class Dependent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String sex;

    @Column(nullable = true)
    private Integer age;

    // Many-to-one relationship with Employee
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dependent_of", nullable = true)
    private Employee dependentOf;*/

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*public Employee getDependentOf() {
        return dependentOf;
    }

    public void setDependentOf(Employee employee) {
        this.dependentOf = employee;
    }*/
}
