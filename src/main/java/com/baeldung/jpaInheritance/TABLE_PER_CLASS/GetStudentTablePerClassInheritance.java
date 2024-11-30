package com.baeldung.jpaInheritance.TABLE_PER_CLASS;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/*
Table per class strategy works similiar, as there was
no strategy user, but querying the parent class will
also retrieve the subclasses
 */

public class GetStudentTablePerClassInheritance {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Instructor.class);

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.getTransaction().begin();

        Query query = session.createQuery("from User");
        List<Student> resultList = query.getResultList();
        for (User user : resultList) {
            if (user instanceof Student) {
                Student student = (Student) user;
                System.out.println(student);
            } else if (user instanceof Instructor) {
                Instructor instructor = (Instructor) user;
                System.out.println(instructor);
            } else {
                System.out.println(user);
            }
        }

        session.getTransaction().commit();
    }
}
