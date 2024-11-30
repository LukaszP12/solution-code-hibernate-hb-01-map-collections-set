package com.baeldung.jpaInheritance.TABLE_PER_CLASS;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentTablePerClassInheritance {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Instructor.class);

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.getCurrentSession();

        Student student = new Student("mary@coding.com", "Mary", "Public", "Hibernate");

        Instructor instructor = new Instructor("john@coding.com", "John", "Doe", 2000.00);

        Student buck = new Student("buck@coding.com", "Buck", "Russell", "acting");

        session.getTransaction().begin();

        session.persist(student);
        session.persist(instructor);
        session.persist(buck);

        session.getTransaction().commit();

    }
}
