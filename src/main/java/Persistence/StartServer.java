package Persistence;

import Persistence.Daos.DaoImplementations.AnimalDao;
import Persistence.Daos.DaoImplementations.ProductDao;
import Persistence.Services.AnimalService;
import Persistence.Services.ProductService;
import Shared.Model.Animal;
import Shared.Model.AnimalPart;
import Shared.Model.Product;
import Shared.Model.Tray;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class StartServer {
    public static void main(String[] args) throws Exception {

        Scanner keyboard = new Scanner(System.in);


        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        System.out.println("Please input your password to your local postgreSQL Database");
        configuration.setProperty("hibernate.connection.password", keyboard.nextLine());
        configuration.addAnnotatedClass(Animal.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(AnimalPart.class);
        configuration.addAnnotatedClass(Tray.class);


        //Session factory - Creates temporary connections to the database (aka sessions)

        SessionFactory sessionFactory = configuration.buildSessionFactory();


        ProductDao productDao = new ProductDao(sessionFactory);
        AnimalDao animalDao = new AnimalDao(sessionFactory);

        //IMPORTANT, run this line only to populate the datebase.
        LoadDatabase.initDatabase(sessionFactory);

        Server server = ServerBuilder.forPort(9090).addService(new AnimalService(productDao, animalDao)).addService(new ProductService(productDao,animalDao)).build();
        server.start();
        server.awaitTermination();
    }
}
