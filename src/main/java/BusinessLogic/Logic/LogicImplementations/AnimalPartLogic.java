package BusinessLogic.Logic.LogicImplementations;

import BusinessLogic.GrpcClient.GrpcClient;
import BusinessLogic.Logic.LogicInterfaces.IAnimalPartLogic;
import BusinessLogic.WebAPI.Exceptions.IncorrectTrayException;
import BusinessLogic.WebAPI.Exceptions.MaximumWeightException;
import Shared.Dtos.AnimalPartCreationDto;
import Shared.Model.AnimalPart;
import Shared.Model.Tray;
import org.springframework.stereotype.Component;

@Component
public class AnimalPartLogic implements IAnimalPartLogic {

    private GrpcClient client;


    public AnimalPartLogic(GrpcClient client) {
        this.client = client;
    }


    @Override
    public AnimalPart create(AnimalPartCreationDto animalPart) {
        Tray tray = client.getTrayById(animalPart.getTrayIComeFromId());
        if (!animalPart.getTypeOfPart().equals(tray)){
            throw new IncorrectTrayException(animalPart.getTrayIComeFromId());
        }

        int weight = 0;
        for (AnimalPart part: tray.getParts()) {
            weight += part.getWeight();
        }

        if (tray.getMaxWeight()<weight+animalPart.getWeight()){
            throw new MaximumWeightException(tray.getMaxWeight());
        }

        return client.createAnimalPart(animalPart);
    }
}
