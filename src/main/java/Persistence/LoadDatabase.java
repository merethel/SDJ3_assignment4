package Persistence;

import Shared.Model.Animal;
import Shared.Model.AnimalPart;
import Shared.Model.Product;
import Shared.Model.Tray;
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

        AnimalPart animalPart1_1 = new AnimalPart(animal1, 10, "Tunge");
        AnimalPart animalPart1_2 = new AnimalPart(animal1, 50, "Hjerte");
        AnimalPart animalPart1_3 = new AnimalPart(animal1, 20, "Bacon");

        AnimalPart animalPart2_1 = new AnimalPart(animal2, 10, "Tunge");
        AnimalPart animalPart2_2 = new AnimalPart(animal2, 50, "Hjerte");
        AnimalPart animalPart2_3 = new AnimalPart(animal2, 20, "Bacon");


        AnimalPart animalPart3_1 = new AnimalPart(animal3, 10, "Tunge");
        AnimalPart animalPart3_2 = new AnimalPart(animal3, 50, "Hjerte");
        AnimalPart animalPart3_3 = new AnimalPart(animal3, 20, "Bacon");

        ArrayList<AnimalPart> animalPartList1 = new ArrayList<>();
        animalPartList1.add(animalPart1_1);
        animalPartList1.add(animalPart2_1);
        animalPartList1.add(animalPart3_1);

        ArrayList<AnimalPart> animalPartList2 = new ArrayList<>();
        animalPartList2.add(animalPart1_2);
        animalPartList2.add(animalPart2_2);
        animalPartList2.add(animalPart3_2);

        ArrayList<AnimalPart> animalPartList3 = new ArrayList<>();
        animalPartList3.add(animalPart1_3);
        animalPartList3.add(animalPart2_3);
        animalPartList3.add(animalPart3_3);

        Tray tray1 = new Tray("Tunge", 100, animalPartList1);
        Tray tray2 = new Tray("Hjerte", 100, animalPartList2);
        Tray tray3 = new Tray("Bacon", 100, animalPartList3);



        Product product1 = new Product("September", new ArrayList<>(
                Arrays.asList(animalPart1_1,animalPart1_2,animalPart1_3)
        ));

        Product product2 = new Product("Oktober", new ArrayList<>(
                Arrays.asList(animalPart1_1,animalPart2_3,animalPart2_1)
        ));

        Product product3 = new Product("November", new ArrayList<>(
                Arrays.asList(animalPart2_1,animalPart3_2,animalPart3_3)
        ));

        Product product4 = new Product("December", new ArrayList<>(
                Arrays.asList(animalPart3_1,animalPart1_3,animalPart2_2)
        ));

        Product product5 = new Product("Januar", new ArrayList<>(
                Arrays.asList(animalPart3_2,animalPart2_1,animalPart1_2)
        ));

        Product product6 = new Product("Februar", new ArrayList<>(
                Arrays.asList(animalPart2_3,animalPart1_2,animalPart3_3)
        ));

        Product product7 = new Product("Marts", new ArrayList<>(
                Arrays.asList(animalPart3_3,animalPart2_3,animalPart1_1)
        ));

        session.beginTransaction();
        session.save(animal1);
        session.save(animal2);
        session.save(animal3);


        session.save(product1);
        session.save(product2);
        session.save(product3);
        session.save(product4);
        session.save(product5);
        session.save(product6);
        session.save(product7);


        session.save(animalPart1_1);
        session.save(animalPart1_2);
        session.save(animalPart1_3);
        session.save(animalPart2_1);
        session.save(animalPart2_2);
        session.save(animalPart2_3);
        session.save(animalPart3_1);
        session.save(animalPart3_2);
        session.save(animalPart3_3);

        session.save(tray1);
        session.save(tray2);
        session.save(tray3);

        session.getTransaction().commit();

        session.close();
    }
}
