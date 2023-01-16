package BusinessLogic.GrpcClient;

import Shared.Dtos.AnimalPartCreationDto;
import Shared.Model.Animal;
import Shared.Model.AnimalPart;
import Shared.Model.Product;
import Shared.Model.Tray;

import java.util.List;

public interface GrpcClientInterface {

    List<Animal> involvedAnimals(int id);
    List<Product> productsInvolvedIn(int id);
    Animal getAnimalById(int id);
    Product getProductById(int id);
    Animal createAnimal(Animal animal);
    Product createProduct(Product product);
    List<Product> getAllProducts();
    List<Animal> getAllAnimals();
    List<Animal> getAnimalsByParameter(Animal animal);
    AnimalPart createAnimalPart(AnimalPartCreationDto animalPart);
    Tray getTrayById(int trayIComeFromId);

}
