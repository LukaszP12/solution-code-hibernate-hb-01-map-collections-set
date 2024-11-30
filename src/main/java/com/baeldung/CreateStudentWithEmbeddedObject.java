package com.baeldung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class CreateStudentWithEmbeddedObject {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student5.class);
        configuration.addAnnotatedClass(Address.class);

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.getCurrentSession();

        Student5 tempStudent = new Student5("John", "Doe", "john@coding.com");

        Address homeAddress = new Address("1 main St", "Philadelphia", "19103");

        Address billingAddress = new Address("Some Billing Address", "Some Billing City", "101010");

        tempStudent.setHomeAddress(homeAddress);
        tempStudent.setBillingAddress(billingAddress);

        session.getTransaction().begin();

        session.persist(tempStudent);

        session.getTransaction().commit();
    }
}
