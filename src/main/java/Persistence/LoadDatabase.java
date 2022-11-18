package Persistence;

import Shared.Animal;
import Shared.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class LoadDatabase {
    public static void initDatabase(SessionFactory sessionFactory) {


        //Session - Temporary connection to database. fx handles transactions.
        Session session = sessionFactory.openSession();

        Animal animal1 = new Animal(44, "Januar", "Norskerland");
        Animal animal2 = new Animal(12, "Februar", "Svenskerland");
        Animal animal3 = new Animal(23, "Marts", "Danskerland");
        Animal animal4 = new Animal(153, "April", "Tyskerland");
        Animal animal5 = new Animal(4, "Maj", "Englænderland");
        Animal animal6 = new Animal(165, "Juni", "Hollænderland");
        Animal animal7 = new Animal(74, "Juli", "Polakland");
        Animal animal8 = new Animal(1, "August", "Franskerland");


        Product product1 = new Product("September", new ArrayList<>(
                Arrays.asList(animal1,animal2,animal3)
        ));

        Product product2 = new Product("Oktober", new ArrayList<>(
                Arrays.asList(animal4,animal5,animal6)
        ));

        Product product3 = new Product("November", new ArrayList<>(
                Arrays.asList(animal7,animal8,animal1)
        ));

        Product product4 = new Product("December", new ArrayList<>(
                Arrays.asList(animal2,animal4,animal6)
        ));

        Product product5 = new Product("Januar", new ArrayList<>(
                Arrays.asList(animal1,animal4,animal5)
        ));

        Product product6 = new Product("Februar", new ArrayList<>(
                Arrays.asList(animal3,animal5,animal7)
        ));

        Product product7 = new Product("Marts", new ArrayList<>(
                Arrays.asList(animal3,animal6,animal8)
        ));

        session.beginTransaction();
        session.save(animal1);
        session.save(animal2);
        session.save(animal3);
        session.save(animal4);
        session.save(animal5);
        session.save(animal6);
        session.save(animal7);
        session.save(animal8);

        session.save(product1);
        session.save(product2);
        session.save(product3);
        session.save(product4);
        session.save(product5);
        session.save(product6);
        session.save(product7);

        session.getTransaction().commit();
        session.close();
    }
}
