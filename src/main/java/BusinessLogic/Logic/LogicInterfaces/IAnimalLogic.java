package BusinessLogic.Logic.LogicInterfaces;

import Shared.Animal;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Indexed;

import java.util.List;

public interface IAnimalLogic {
    public Animal create(Animal animal);
    public Animal getById(int id);

    public List<Animal> getAnimalsInvolved(int ProductId);

    public List<Animal> getAllAnimals();

    public List<Animal> getAnimalsByParameter(Animal animalParameters);
}
