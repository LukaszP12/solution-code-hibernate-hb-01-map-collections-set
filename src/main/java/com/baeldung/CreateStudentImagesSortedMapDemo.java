package com.baeldung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.SortedMap;

class CreateStudentImagesSortedMapDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student4.class);

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.getCurrentSession();

        Student4 tempStudent = new Student4("Joe", "Doe", "john@coding.com");
        SortedMap<String, String> theImages = tempStudent.getImages();

        theImages.put("photo1.jpg", "Photo 1");
        theImages.put("photo2.jpg", "Photo 2");
        theImages.put("photo3.jpg", "Photo 3");

        tempStudent.setImages(theImages);


        session.getTransaction().begin();

        session.persist(tempStudent);

        session.getTransaction().commit();
    }
}
