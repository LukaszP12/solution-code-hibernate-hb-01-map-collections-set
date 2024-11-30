package com.baeldung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class CreateStudentWithEnumObject {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student6.class);

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.getCurrentSession();

        Student6 tempStudent1 = new Student6("John", "Doe", "john@coding.com");
        tempStudent1.setStatus(Status.ACTIVE);

        Student6 tempStudent2 = new Student6("Mary", "Public", "mary@coding.com");
        tempStudent2.setStatus(Status.INACTIVE);

        session.getTransaction().begin();

        session.persist(tempStudent1);
        session.persist(tempStudent2);

        session.getTransaction().commit();

    }
}
