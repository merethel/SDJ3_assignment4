package BusinessLogic.GrpcClient;

import Shared.Animal;
import Shared.AnimalAssembler;
import Shared.Product;
import Shared.ProductAssembler;
import animals.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class GrpcClient {

    ManagedChannel managedChannel;
    AnimalHandlerGrpc.AnimalHandlerBlockingStub animalStub;
    ProductHandlerGrpc.ProductHandlerBlockingStub productStub;

    public GrpcClient() {
        animalStub = getAnimalStub();
        productStub = getProductStub();
    }
    public List<Animal> involvedAnimals(int id){

        List<Animal> listToReturn = new ArrayList<>();



        RequestAnimalsByProductId request = RequestAnimalsByProductId.newBuilder().setId(id).build();
        AnimalReply reply = animalStub.getAnimalsInvolved(request);
        managedChannel.shutdown();

        for (AnimalMessage message:
                reply.getAnimalsList()) {
            listToReturn.add(AnimalAssembler.fromMessageToAnimal(message));
        }

        return listToReturn;
    }

    public List<Product> productsInvolvedIn(int id){

        List<Product> listToReturn = new ArrayList<>();

        RequestProductsByAnimalId request = RequestProductsByAnimalId.newBuilder().setId(id).build();
        ProductReply reply = productStub.getProductsInvolved(request);
        managedChannel.shutdown();

        for (ProductMessage message: reply.getProductsList()) {
            listToReturn.add(ProductAssembler.fromMessageToProduct(message));
        }

        return listToReturn;
    }

    public Animal getAnimalById(int id)
    {
        AnimalMessage reply = animalStub.getAnimalById(IntRequest.newBuilder().setInt(id).build());
        Animal animalToReturn = AnimalAssembler.fromMessageToAnimal(reply);
        return animalToReturn;
    }

    public Product getProductById(int id)
    {
        ProductMessage reply = productStub.getProductById(IntRequest.newBuilder().setInt(id).build());
        Product productToReturn = ProductAssembler.fromMessageToProduct(reply);
        return productToReturn;
    }

    public Animal createAnimal(Animal animal)
    {
        AnimalMessage reply = animalStub.createAnimal(AnimalAssembler.fromAnimalToMessage(animal));
        Animal animalToReturn = AnimalAssembler.fromMessageToAnimal(reply);
        return animalToReturn;
    }

    public Product createProduct(Product product)
    {
        ProductMessage reply = productStub.createProduct(ProductAssembler.fromProductToMessage(product));
        Product productToReturn = ProductAssembler.fromMessageToProduct(reply);
        return productToReturn;
    }

    public List<Product> getAllProducts()
    {
        List<Product> productList = new ArrayList<>();
        ProductReply reply = productStub.getAllProducts(IntRequest.newBuilder().getDefaultInstanceForType());

        for (ProductMessage message: reply.getProductsList()
             ) {
            productList.add(ProductAssembler.fromMessageToProduct(message));
        }
        return productList;
    }

    public List<Animal> getAllAnimals()
    {
        List<Animal> animalList = new ArrayList<>();
        AnimalReply reply = animalStub.getAllAnimals(IntRequest.newBuilder().getDefaultInstanceForType());

        for (AnimalMessage message: reply.getAnimalsList()
             ) {
            animalList.add(AnimalAssembler.fromMessageToAnimal(message));
        }
        return animalList;
    }

    public List<Animal> getAnimalsByParameter(Animal animal)
    {
        AnimalMessage.Builder builder = AnimalMessage.newBuilder();

        if (animal.getOrigin() != null)
            builder.setOrigin(animal.getOrigin());
        if (animal.getDate() != null)
            builder.setDate(animal.getDate());

        AnimalMessage animalParameters = builder.build();

        List<Animal> animalList = new ArrayList<>();
        AnimalReply reply = animalStub.getAllAnimalsByParameter(animalParameters);

        for (AnimalMessage message: reply.getAnimalsList()
        ) {
            animalList.add(AnimalAssembler.fromMessageToAnimal(message));
        }
        return animalList;
    }













    private AnimalHandlerGrpc.AnimalHandlerBlockingStub getAnimalStub() {
        managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext().build();

        return AnimalHandlerGrpc
                .newBlockingStub(managedChannel);
    }
    private ProductHandlerGrpc.ProductHandlerBlockingStub getProductStub() {
        managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext().build();

        return ProductHandlerGrpc
                .newBlockingStub(managedChannel);
    }


}
