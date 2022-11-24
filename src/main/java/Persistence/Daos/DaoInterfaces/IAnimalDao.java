package Persistence.Daos.DaoInterfaces;

import Shared.Model.Animal;

import java.util.List;

public interface IAnimalDao {
    public Animal create(Animal animal);
    public Animal getById(int animalId);

    public List<Animal> getAllAnimals();

    public List<Animal> getAnimalsByParameters(Animal animalParameters);


}
