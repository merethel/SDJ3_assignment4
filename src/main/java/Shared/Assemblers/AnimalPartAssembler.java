package Shared.Assemblers;

import Shared.Dtos.AnimalPartCreationDto;
import Shared.Model.AnimalPart;
import animals.AnimalPartCreationDtoMessage;
import animals.AnimalPartMessage;

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

    public static AnimalPartCreationDtoMessage fromAnimalPartCreationDtoToMessage(AnimalPartCreationDto animalPart){

        AnimalPartCreationDtoMessage animalPartCreationDtoMessage = AnimalPartCreationDtoMessage.newBuilder()
                .setTypeOfPart(animalPart.getTypeOfPart())
                .setAnimalIComeFromId(animalPart.getAnimalIComeFromId())
                .setWeight(animalPart.getWeight())
                .setTrayIComeFromId(animalPart.getTrayIComeFromId())
                .build();

        return animalPartCreationDtoMessage;
    }

    public static AnimalPartCreationDto fromMessageToAnimalPartCreationDto(AnimalPartCreationDtoMessage dtoMessage)
    {
        AnimalPartCreationDto animalPartCreationDto = new AnimalPartCreationDto(
                dtoMessage.getAnimalIComeFromId(),
                dtoMessage.getTrayIComeFromId(),
                dtoMessage.getWeight(),
                dtoMessage.getTypeOfPart()
        );
        return animalPartCreationDto;
    }

    public static AnimalPartMessage fromAnimalPartToMessage(AnimalPart animalPart)
    {
        AnimalPartMessage animalPartMessage = AnimalPartMessage.newBuilder()
                .setTypeOfPart(animalPart.getTypeOfPart())
                .setAnimalIComeFrom(AnimalAssembler.fromAnimalToMessage(animalPart.getAnimalIComeFrom()))
                .setId(animalPart.getId())
                .setTrayIComeFrom(TrayAssembler.fromTrayToMessage(animalPart.getTrayIComeFrom()))
                .build();
        return animalPartMessage;
    }
}
