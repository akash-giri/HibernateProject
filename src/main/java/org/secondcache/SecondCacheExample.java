package org.secondcache;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondCacheExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        //first
        Student student = session.get(Student.class, 12424);
        System.out.println(student);
        session.close();

        Session session1 = factory.openSession();
        //second
        Student student1 = session1.get(Student.class, 12424);
        System.out.println(student1);
        session1.close();
    }
}
