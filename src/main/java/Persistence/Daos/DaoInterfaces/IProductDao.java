package Persistence.Daos.DaoInterfaces;

import Shared.Product;

import java.util.List;

public interface IProductDao {
    public Product create(Product product);
    public Product getById(int productId);

    public List<Product> getAllProducts();
}
