package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cascade;
import org.hibernate.cfg.Configuration;

import java.util.Collection;
import java.util.Collections;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("PersonCSMultiple", 25);

            person.addItem(new Item("ItemCS1"));
            person.addItem(new Item("ItemCS2"));
            person.addItem(new Item("ItemCS3"));

            session.save(person);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
