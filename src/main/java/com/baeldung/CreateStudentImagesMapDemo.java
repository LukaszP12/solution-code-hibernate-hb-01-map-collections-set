package com.baeldung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Map;

class CreateStudentImagesMapDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student2.class);

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.getCurrentSession();

        // Student and Images
        // A student will have a map of images
        // Each image will have a file name and description
        // Duplicate file names are not allowed

        Student2 tempStudent = new Student2("John", "Doe", "john@coding.com");
        Map<String, String> theImages = tempStudent.getImages();

        theImages.put("photo1.jpg", "Photo 1");
        theImages.put("photo2.jpg", "Photo 2");
        theImages.put("photo3.jpg", "Photo 3");

        session.getTransaction().begin();

        session.persist(tempStudent);

        session.getTransaction().commit();

    }
}
