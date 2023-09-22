package org.CriteriaExample;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Criteria {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        // Create an EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("YourPersistenceUnit");

        // Create an EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Get a CriteriaBuilder
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // Create a CriteriaQuery for the Student entity
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);

        // Specify the root entity (Student)
        Root<Student> root = criteriaQuery.from(Student.class);

        // Build your query using the criteria API (e.g., add predicates, projections, etc.)
        // criteriaQuery.select(...); // Add select expressions if needed
        // criteriaQuery.where(...);  // Add conditions if needed

        // Execute the query
        // List<Student> resultList = entityManager.createQuery(criteriaQuery).getResultList();

        // Close the EntityManager and EntityManagerFactory when done
        entityManager.close();
        entityManagerFactory.close();
        session.close();
    }
}
