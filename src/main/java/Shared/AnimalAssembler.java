package Shared;

import animals.AnimalMessage;
public class AnimalAssembler {

    public static Animal fromMessageToAnimal(AnimalMessage animalToAssemble){
        Animal animal = new Animal(
                animalToAssemble.getWeight(),
                animalToAssemble.getDate(),
                animalToAssemble.getOrigin()
        );
        return animal;
    }

    public static AnimalMessage fromAnimalToMessage(Animal animal){
        AnimalMessage message = AnimalMessage.newBuilder()
                .setId(animal.getRegistrationNumber())
                .setWeight(animal.getWeight())
                .setOrigin(animal.getOrigin())
                .setDate(animal.getDate())
                .build();

        return message;
    }
}
