package Persistence.Services;

import Persistence.Daos.DaoImplementations.AnimalDao;
import Persistence.Daos.DaoImplementations.ProductDao;
import Shared.Animal;
import Shared.Product;
import Shared.ProductAssembler;
import animals.*;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class ProductService extends ProductHandlerGrpc.ProductHandlerImplBase {

    private final ProductDao productDao;
    private final AnimalDao animalDao;

    public ProductService(ProductDao productDao, AnimalDao animalDao) {
        this.productDao = productDao;
        this.animalDao = animalDao;
    }

    @Override
    public void getProductsInvolved(RequestProductsByAnimalId request, StreamObserver<ProductReply> responseObserver) {
        List<ProductMessage> products = new ArrayList<>();

        Animal animal = animalDao.getById(request.getId());

        for (Product product : animal.getProducts()) {
            products.add(ProductAssembler.fromProductToMessage(product));
        }

        ProductReply reply = ProductReply.newBuilder().addAllProducts(products).build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getProductById(IntRequest request, StreamObserver<ProductMessage> responseObserver) {
        Product product = productDao.getById(request.getInt());
        ProductMessage reply = ProductAssembler.fromProductToMessage(product);
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void createProduct(ProductMessage request, StreamObserver<ProductMessage> responseObserver) {
        Product product = productDao.create(ProductAssembler.fromMessageToProduct(request));
        ProductMessage reply = ProductAssembler.fromProductToMessage(product);
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllProducts(IntRequest request, StreamObserver<ProductReply> responseObserver) {
        List<Product> productList = productDao.getAllProducts();
        ProductReply reply = null;
        ProductReply.Builder builder = ProductReply.newBuilder();
        for (Product product: productList
             ) {
            reply = builder.addProducts(ProductAssembler.fromProductToMessage(product)).build();
        }
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
