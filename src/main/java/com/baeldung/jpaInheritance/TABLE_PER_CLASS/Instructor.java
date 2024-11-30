package com.baeldung.jpaInheritance.TABLE_PER_CLASS;

import jakarta.persistence.Entity;

@Entity
public class Instructor extends User{

    private Double salary;

    public Instructor() {
    }

    public Instructor(String email, String firstName, String lastName, Double salary) {
        super(email, firstName, lastName);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "salary=" + salary +
                "} " + super.toString();
    }
}
