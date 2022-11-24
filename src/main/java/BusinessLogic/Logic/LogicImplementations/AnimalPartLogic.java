package BusinessLogic.Logic.LogicImplementations;

import BusinessLogic.GrpcClient.GrpcClient;
import BusinessLogic.Logic.LogicInterfaces.IAnimalPartLogic;
import Shared.Dtos.AnimalPartCreationDto;
import Shared.Model.AnimalPart;
import org.springframework.stereotype.Component;

@Component
public class AnimalPartLogic implements IAnimalPartLogic {

    private GrpcClient client;

    public AnimalPartLogic(GrpcClient client) {
        this.client = client;
    }


    @Override
    public AnimalPart create(AnimalPartCreationDto animalPart) {
        return client.createAnimalPart(animalPart);
    }

    @Override
    public AnimalPart getById(int id) {
        return null;
    }
}
