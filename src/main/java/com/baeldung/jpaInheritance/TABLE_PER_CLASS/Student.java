package com.baeldung.jpaInheritance.TABLE_PER_CLASS;

import jakarta.persistence.Entity;

@Entity
public class Student extends User{

    private String course;

    public Student() {
    }

    public Student(String email, String firstName, String lastName, String course) {
        super(email, firstName, lastName);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String
    toString() {
        return "Student{" +
                "course='" + course + '\'' +
                "} " + super.toString();
    }
}
