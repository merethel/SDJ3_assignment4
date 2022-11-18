package BusinessLogic.Logic.LogicImplementations;

import BusinessLogic.GrpcClient.GrpcClient;
import BusinessLogic.Logic.LogicInterfaces.IProductLogic;
import Shared.Animal;
import Shared.Product;

import java.util.List;

public class ProductLogic implements IProductLogic {

    private GrpcClient client;

    public ProductLogic(GrpcClient client) {
        this.client = client;
    }

    @Override
    public Product create(Product product) {
        return client.createProduct(product);
    }

    @Override
    public Product getById(int id) {
        return client.getProductById(id);
    }

    @Override
    public List<Product> getProductsInvolved(int animalId) {
        return client.productsInvolvedIn(animalId);
    }

    @Override
    public List<Product> getAllProducts() {
        return client.getAllProducts();
    }
}
