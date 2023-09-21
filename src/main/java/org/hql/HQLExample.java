package org.hql;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class HQLExample {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session = factory.openSession();

        //HQL
        //Syntax:
        //
        String query="from Student where city=:x";

        Query sessionQuery = session.createQuery(query);
        sessionQuery.setParameter("x","Lucknow");
        //single -(Unique)
        //multiple-list
        List<Student>studentList = sessionQuery.list();
        for(Student s:studentList)
        {
            System.out.println(s.getName());
        }

        System.out.println("----------------------------------------------------------");
        Transaction tx= session.beginTransaction();
        // delete query
//        Query sessionQuery1 = session.createQuery("delete from Student s where s.city=:c");
//        sessionQuery1.setParameter("c","ABC");
//        int executeUpdate = sessionQuery1.executeUpdate();
//        System.out.println("Deleted:");
//        System.out.println(executeUpdate);

        //update query
        Query sessionQuery1 = session.createQuery("update Student set city=:c where name=:n");
        sessionQuery1.setParameter("c","Delhi");
        sessionQuery1.setParameter("n","PETER");
        int executeUpdate = sessionQuery1.executeUpdate();
        System.out.println("Updated:");
        System.out.println(executeUpdate);

        tx.commit();

        // how to execute join query
        Query sessionQuery2 = session.createQuery("select q.question,q.questionId,a.questionId from Question as q" +
                "INNER JOIN q.answers as a ");
        List<Object[]> resultList = sessionQuery2.getResultList();
        for(Object[] arr:resultList){
            System.out.println(Arrays.toString(arr));
        }

        session.close();
        factory.close();
    }
}
