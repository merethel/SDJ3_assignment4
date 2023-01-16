package BusinessLogic.Logic.LogicImplementations;

import BusinessLogic.GrpcClient.GrpcClient;
import BusinessLogic.GrpcClient.GrpcClientInterface;
import BusinessLogic.Logic.LogicInterfaces.IAnimalLogic;
import Shared.Model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalLogic implements IAnimalLogic {

    @Autowired
    private GrpcClientInterface client;

    public AnimalLogic(GrpcClientInterface client) {
        this.client = client;
    }

    @Override
    public Animal create(Animal animal) {
        Animal animalToReturn = client.createAnimal(animal);
        return animalToReturn;
    }

    @Override
    public Animal getById(int id) {
        Animal animalToReturn = client.getAnimalById(id);
        return animalToReturn;
    }

    @Override
    public List<Animal> getAnimalsInvolved(int productId) {
        List<Animal> animalToReturn = client.involvedAnimals(productId);
        return animalToReturn;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return client.getAllAnimals();
    }

    @Override
    public List<Animal> getAnimalsByParameter(Animal animalParameters) {


        return client.getAnimalsByParameter(animalParameters);
    }

}
