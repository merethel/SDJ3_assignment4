package Persistence.Daos.DaoInterfaces;

import Shared.Dtos.AnimalPartCreationDto;
import Shared.Model.AnimalPart;

public interface IAnimalPartDao {
    public AnimalPart create(AnimalPartCreationDto animalPart);
    public AnimalPart getById(int id);
}
