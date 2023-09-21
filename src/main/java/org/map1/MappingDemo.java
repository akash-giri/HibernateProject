package org.map1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MappingDemo {

    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        // SessionFactory is a interface factory for providing session
        // type of connection , is a thread safe,
        SessionFactory factory = cfg.buildSessionFactory();

        //creating Employee
        Emp e1=new Emp();
        Emp e2=new Emp();

        e1.setEid(34);
        e1.setName("Ram");

        e2.setEid(35);
        e2.setName("shyaam");

        Project p1=new Project();
        Project p2=new Project();
        p1.setPid(1212);
        p1.setProjectName("Library Management System");
        p2.setPid(1421);
        p2.setProjectName("CHATBOT");

        List<Emp> list=new ArrayList<>();
        list.add(e1);
        list.add(e2);

        List<Project> projectList=new ArrayList<>();
        projectList.add(p1);
        projectList.add(p2);

        e1.setProjects(projectList);
        p2.setEmps(list);

        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        s.save(e1);
        s.save(e2);
        s.save(p1);
        s.save(p2);
        tx.commit();
        s.close();

        factory.close();
    }
}
