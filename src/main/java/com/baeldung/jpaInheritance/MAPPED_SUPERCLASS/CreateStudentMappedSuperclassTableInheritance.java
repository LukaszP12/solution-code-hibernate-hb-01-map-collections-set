package com.baeldung.jpaInheritance.MAPPED_SUPERCLASS;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentMappedSuperclassTableInheritance {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Instructor.class);

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.getCurrentSession();

        Student tempStudent = new Student("Mary", "Public", "mary@coding.com", "Hibernate");
        Instructor tempInstructor = new Instructor("John", "Doe", "john@coding.com", 20000.00);

        session.getTransaction().begin();

        session.persist(tempStudent);
        session.persist(tempInstructor);

        session.getTransaction().commit();
    }
}
