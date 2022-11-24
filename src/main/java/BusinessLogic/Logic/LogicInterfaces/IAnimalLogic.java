package BusinessLogic.Logic.LogicInterfaces;

import Shared.Model.Animal;

import java.util.List;

public interface IAnimalLogic {
    public Animal create(Animal animal);
    public Animal getById(int id);

    public List<Animal> getAnimalsInvolved(int ProductId);

    public List<Animal> getAllAnimals();

    public List<Animal> getAnimalsByParameter(Animal animalParameters);
}
