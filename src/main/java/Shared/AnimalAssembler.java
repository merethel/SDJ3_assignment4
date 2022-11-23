package Shared;

import animals.AnimalMessage;
import animals.ProductMessage;

import java.util.ArrayList;
import java.util.List;

public class AnimalAssembler {

    public static Animal fromMessageToAnimal(AnimalMessage animalToAssemble){
        Animal animal = new Animal(
                animalToAssemble.getWeight(),
                animalToAssemble.getDate(),
                animalToAssemble.getOrigin()
        );

        animal.setRegistrationNumber(animalToAssemble.getId());
        return animal;
    }

    public static AnimalMessage fromAnimalToMessage(Animal animal){
        List<ProductMessage> productList = new ArrayList<>();

        AnimalMessage animalMessage = AnimalMessage.newBuilder()
                .setId(animal.getRegistrationNumber())
                .setWeight(animal.getWeight())
                .setOrigin(animal.getOrigin())
                .setDate(animal.getDate())
                .build();

        return animalMessage;
    }
}
