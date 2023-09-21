package org.cascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.map.Answer;
import org.map.Question;

import java.util.List;

public class CascadeExample {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        // SessionFactory is a interface factory for providing session
        // type of connection , is a thread safe,
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Question q1=new Question();
        q1.setQuestionId(567);
        q1.setQuestion("WHat is Cascading...??");

        Answer answer = new Answer(12, "In Hibernate it is important");
        Answer answer1 = new Answer(123, "second");
        Answer answer2 = new Answer(124, "third");

        q1.setAnswers(List.of(answer,answer1,answer2));
        Transaction beginTransaction = session.beginTransaction();
        session.save(q1);

        beginTransaction.commit();
        session.close();
        factory.close();
    }
}
