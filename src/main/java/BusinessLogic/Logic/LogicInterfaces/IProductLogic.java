package BusinessLogic.Logic.LogicInterfaces;

import Shared.Animal;
import Shared.Product;

import java.util.List;

public interface IProductLogic {
    public Product create(Product product);
    public Product getById(int id);

    public List<Product> getProductsInvolved(int animalId);

    public List<Product> getAllProducts();
}
