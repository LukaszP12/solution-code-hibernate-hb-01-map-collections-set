package com.baeldung.jpaInheritance.SINGLE_TABLE;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DiscriminatorValue(value = "STUDENT")
public class Student extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String course;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, String course) {
        super(firstName,lastName,email);
        this.course = course;
    }

}
