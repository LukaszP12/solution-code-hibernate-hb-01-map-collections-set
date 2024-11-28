package com.baeldung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

class RetrieveStudentImagesSetDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student3.class);

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.getTransaction().begin();

        Student3 student3 = session.find(Student3.class,1);
        Set<String> images = student3.getImages();

        System.out.println("images belonging to " + student3.getFirstName() + ", " + student3.getLastName());
        images.forEach(System.out::println);

        session.getTransaction().commit();

    }
}
