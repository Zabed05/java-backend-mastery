package com.zabed;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    static void main(String[] args) {
        Student s1 = new Student();
        s1.setId(6);
        s1.setName("Rittik");
        s1.setEmail("rittik@hibernate.com");

        // Hey Hibernate save this s1 object in my database

        // We need to create a session

        Configuration config = new Configuration();
        config.addAnnotatedClass(com.zabed.Student.class);
        config.configure();

        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(s1); // instead of save() we use persist() as after Hibernate 6 version its a standard of JPA

        transaction.commit();

        session.close();
        factory.close();
    }
}
