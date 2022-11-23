package Persistence.Daos.DaoInterfaces;

import Shared.AnimalPart;

public interface IAnimalPartDao {
    public AnimalPart create(AnimalPart animalPart);
    public AnimalPart getById(int id);
}
