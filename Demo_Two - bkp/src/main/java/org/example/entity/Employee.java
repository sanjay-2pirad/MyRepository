package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private Integer age;

    //One-to-many relationship with Dependent
    @OneToMany(mappedBy = "dependentId", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
   private List<Dependent> dependents=new ArrayList<>();

    public long getemployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setemployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //Getters and Setters for dependents
    public List<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(List<Dependent> dependents) {
        this.dependents = dependents;
    }

    public void addDependent(Dependent dependent) {
      dependent.setDependent(this);
      this.dependents.add(dependent);
    }
}
