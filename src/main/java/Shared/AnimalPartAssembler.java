package Shared;

import animals.AnimalMessage;
import animals.AnimalPartMessage;
import animals.ProductMessage;

import java.util.ArrayList;
import java.util.List;

public class AnimalPartAssembler {
    public static AnimalPart fromMessageToAnimalPart(AnimalPartMessage animalPartToAssemble){
        AnimalPart animalPart = new AnimalPart(
                AnimalAssembler.fromMessageToAnimal(animalPartToAssemble.getAnimalIComeFrom()),
                animalPartToAssemble.getWeight(),
                animalPartToAssemble.getTypeOfPart()
        );

        animalPart.setId(animalPartToAssemble.getId());
        return animalPart;
    }

    public static AnimalPartMessage fromAnimalPartToMessage(AnimalPart animalPart){

        AnimalPartMessage animalPartMessage = AnimalPartMessage.newBuilder()
                .setId(animalPart.getId())
                .setWeight(animalPart.getWeight())
                .setAnimalIComeFrom(AnimalAssembler.fromAnimalToMessage(animalPart.getAnimalIComeFrom()))
                .setTypeOfPart(animalPart.getTypeOfPart())
                .build();

        return animalPartMessage;
    }
}
