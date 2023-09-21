package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        // SessionFactory is a interface factory for providing session
        // type of connection , is a thread safe,
        SessionFactory factory = cfg.buildSessionFactory();

        Student student=new Student();
        student.setId(123);
        student.setName("Ankit");
        student.setCity("LKO");

        Certificate certificate=new Certificate();
        certificate.setCourse("Andriod");
        certificate.setDuration("2 months");
        student.setCertificate(certificate);

        Student student1=new Student();
        student1.setId(193);
        student1.setName("Ravi");
        student1.setCity("Delhi");

        Certificate certificate1=new Certificate();
        certificate1.setCourse("Hibernate");
        certificate1.setDuration("1 months");
        student1.setCertificate(certificate1);

        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();

        //objects save
        session.save(student);
        session.save(student1);
        tx.commit();

        session.close();
        factory.close();
    }
}
