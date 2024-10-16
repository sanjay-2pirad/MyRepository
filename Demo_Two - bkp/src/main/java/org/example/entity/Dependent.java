package org.example.entity;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "dependent")
public class Dependent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dependentId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private Integer age;

    // Many-to-one relationship with Employee
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employeeId", nullable = false)
    private Employee employeeId;

    public long getdependentId() {
        return dependentId;
    }

    public void setdependentId(long dependentId) {
        this.dependentId = dependentId;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Employee getDependent() {
        return employeeId;
    }

    public void setDependent(Employee employee) {
        this.employeeId = employee;
    }
}
