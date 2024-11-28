package com.baeldung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

class CreateStudentImagesSetDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student3.class);

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.getCurrentSession();

        Student3 tempStudent = new Student3("Paul", "Wall", "paul@coding.com");
        Set<String> theImages = tempStudent.getImages();

        theImages.add("photo1.jpg");
        theImages.add("photo2.jpg");
        theImages.add("photo3.jpg");
        theImages.add("photo4.jpg");
        theImages.add("photo5.jpg");

        session.getTransaction().begin();

        session.persist(tempStudent);

        session.getTransaction().commit();
    }
}
