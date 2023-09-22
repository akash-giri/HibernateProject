package org.firstcache;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstDemo {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        // SessionFactory is a interface factory for providing session
        // type of connection , is a thread safe,
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Student student = session.get(Student.class, 1212);
        System.out.println(student);
        System.out.println("working something");
        // again calling same student then in that case because session is still not close
        // so it will go into the session and check if the value is present in
        // session cache or not then it will get the value and return the student1 result
        Student student1 = session.get(Student.class, 1212); // no query fire in the backend
        System.out.println(student1);

        session.contains(student1); // it will check for first cache contains the value or not.
        session.close();
    }
}
