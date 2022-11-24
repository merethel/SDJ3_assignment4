package BusinessLogic.Logic.LogicInterfaces;

import Shared.Dtos.AnimalPartCreationDto;
import Shared.Model.AnimalPart;

public interface IAnimalPartLogic {
    public AnimalPart create(AnimalPartCreationDto animalPart);
    public AnimalPart getById(int id);
}
