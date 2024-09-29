package com.example.sp_three.employees;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @SequenceGenerator(name = "employee_sequence",
    sequenceName = "employee_sequence",
    allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate birthday;
    @Transient
    private Integer age;
    private Integer salary;

    public Employee() {
    }

    public Employee(Long id, String name, String email, LocalDate birthday, Integer salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.age = Period.between(birthday, LocalDate.now()).getYears();
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Integer getAge() {
        if (age == null) {
            this.age = Period.between(birthday, LocalDate.now()).getYears();
        }
        return age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
