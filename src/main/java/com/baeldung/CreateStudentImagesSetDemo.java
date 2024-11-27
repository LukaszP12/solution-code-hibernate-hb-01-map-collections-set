package com.baeldung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class CreateStudentImagesSetDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.getTransaction().begin();

        try {
            Student tempStudent = new Student("John", "Doe", "john@luv2code.com");
            Set<String> theImages = tempStudent.getImages();

            theImages.add("photo1.jpg");
            theImages.add("photo2.jpg");
            theImages.add("photo3.jpg");
            theImages.add("photo4.jpg");
            theImages.add("photo5.jpg");
            theImages.add("photo6.jpg");
            theImages.add("photo7.jpg");

            session.persist(tempStudent);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }

    }
}
