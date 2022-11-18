package BusinessLogic.GrpcClient;

import java.util.Scanner;

public class StartClient {
    public static void main(String[] args) {
        GrpcClient client = new GrpcClient();

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Getting animals involved in a product from a product ID");
        System.out.println("Write a Product id that exists in the database");

        System.out.println(client.involvedAnimals(keyboard.nextInt()));

        System.out.println("------------------------------------------------");

        System.out.println("Getting products that an animal is involved in from an animal ID");
        System.out.println("Write an animal id that exists in the database");

        System.out.println(client.productsInvolvedIn(keyboard.nextInt()));
    }
}
