package com.baeldung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.SortedMap;

class RetrieveStudentImagesSortedMapDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student4.class);

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.getTransaction().begin();

        Student4 student4 = session.find(Student4.class, 1);
        SortedMap<String, String> images = student4.getImages();

        System.out.println("images belonging to " + student4.getFirstName() + ", " + student4.getLastName());
        System.out.println("in sorted order ");
        images.forEach(
                (key, value) -> {
                    System.out.println("file_name: " + key + " image_name");
                }
        );

        session.getTransaction().commit();
    }
}
