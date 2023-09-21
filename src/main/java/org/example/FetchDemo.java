package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

    public static void main(String[] args) {
        // get, load
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        // SessionFactory is a interface factory for providing session
        // type of connection , is a thread safe,
        SessionFactory factory = cfg.buildSessionFactory();
        Session session=factory.openSession();

        // get-student:1
//        Student student=(Student)session.get(Student.class,101);
//        System.out.println(student);

        // load
        Student student=(Student)session.load(Student.class,101);
        System.out.println(student);


        session.close();
        factory.close();
    }
}
