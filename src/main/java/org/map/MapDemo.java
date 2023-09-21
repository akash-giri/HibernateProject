package org.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MapDemo {
    public static void main(String[] args) {

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        // SessionFactory is a interface factory for providing session
        // type of connection , is a thread safe,
        SessionFactory factory = cfg.buildSessionFactory();

        //creating question
        Question q1=new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is java??");

        Answer answer=new Answer();
        answer.setAnswerId(343);
        answer.setAnswer("Java is programming language");
        answer.setQuestion(q1);

        Answer answer1=new Answer();
        answer1.setAnswerId(344);
        answer1.setAnswer("With the help of java we can create softwares ");
        answer1.setQuestion(q1);
        q1.setAnswers(List.of(answer,answer1));

        Session session1 = factory.openSession();
        Transaction beginTransaction = session1.beginTransaction();
        session1.save(q1);
        session1.save(answer);
        session1.save(answer1);


        Question question = (Question) session1.get(Question.class, 1212);
        System.out.println(question.getQuestionId());
        System.out.println(question.getQuestion());
        //Lazy loading by default
        System.out.println(question.getAnswers().size());

//        System.out.println(question.getAnswer().getAnswer());

        beginTransaction.commit();
        session1.close();
        factory.close();
    }
}
