package org.states;

import org.example.Certificate;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
    public static void main(String[] args) {
        //Practical of hibernate object states:
        //Transient
        //Persistent
        //Detached
        //Removed
        System.out.println("Example: ");
        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Creating Student object:
        Student student=new Student();
        student.setId(1414);
        student.setName("New Name");
        student.setCity("ABC");
        student.setCertificate(new Certificate("Java Hibernate Course","2 months"));
        //student :Transient

        Session session= sessionFactory.openSession();
        Transaction tx= session.beginTransaction();
        session.save(student);
        //student: Persistent -session, database

        student.setName("John");

        tx.commit();
        session.close();
        student.setName("Sachin");
        //student: detached state
        System.out.println(student);
        sessionFactory.close();
    }
}
