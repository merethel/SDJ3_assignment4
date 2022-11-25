package BusinessLogic.Logic.LogicImplementations;

import BusinessLogic.GrpcClient.GrpcClient;
import BusinessLogic.Logic.LogicInterfaces.IProductLogic;
import Shared.Model.Product;
import Shared.Model.Tray;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductLogic implements IProductLogic {

    private GrpcClient client;

    public ProductLogic(GrpcClient client) {
        this.client = client;
    }

    @Override
    public Product create(Product product) {
        return client.createProduct(product);
    }
}
