package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        Session session = sessionFactory.openSession();

        Animal animal = new Animal();
        animal.setName("Vasya");
        animal.setAge(5);
        animal.setTail(true);

        session.beginTransaction();
        session.persist(animal);
        session.getTransaction().commit();
        session.close();
    }
}