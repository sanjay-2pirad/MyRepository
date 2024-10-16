package org.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private int age;

    // One-to-many relationship with Dependent
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Dependent> dependents;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String gender) {
        this.sex = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getters and Setters for dependents
    public Set<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(Set<Dependent> dependents) {
        this.dependents = dependents;
    }
}
