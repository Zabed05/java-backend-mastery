package com.zabed;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    static void main(String[] args) {

//        Student s1 = new Student();

//        s1.setId(6);
//        s1.setName("Rittik");
//        s1.setEmail("rittik@hibernate.com");


        Configuration config = new Configuration();
        config.addAnnotatedClass(com.zabed.Student.class);
        config.configure();

        SessionFactory factory = config.buildSessionFactory();

        Session session = factory.openSession();

        //-----------Storing Data-------------//

//        Transaction transaction = session.beginTransaction(); // Transaction (only need when we are saving, updating and deleting)

        // Now we are working on fetching the data so we dont use persist, instead of this we use session.get() or session.find()
//        session.persist(s1);
//        transaction.commit();

        //--------------Fetching or Retrieve Data-------------//

//        Student student = session.byId(Student.class).getReference(2); // Lazy Fetching

//        Student student = session.find(Student.class, 1); // Eager fetching

        Student student = session.get(Student.class, 1); // Eager fetching
        System.out.println(student);


        //------------------Updating Data---------------//
        Student s1 = new Student();

        s1.setId(6);
        s1.setName("Rittik");
        s1.setEmail("rittik@hibernate_updated.com"); // updated gmail

        Transaction transaction = session.beginTransaction();

        session.merge(s1); // use merge when we want to update.....But if the provided id's row is not present, then it will create this
        transaction.commit();


        //-------------------Delete Data-----------------//
        // Now for deleting we have to fetch the data first then pass it to the "session.remove()"

        Student s2 = session.find(Student.class, 5);

        session.remove(s2);
        transaction.commit();

        session.close();
        factory.close();
    }
}
