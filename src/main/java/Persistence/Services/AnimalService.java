package Persistence.Services;

import Persistence.Daos.DaoInterfaces.IAnimalDao;
import Persistence.Daos.DaoInterfaces.IProductDao;
import Shared.Animal;
import Shared.AnimalAssembler;
import Shared.Product;
import Shared.ProductAssembler;
import animals.*;
import io.grpc.stub.StreamObserver;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class AnimalService extends AnimalHandlerGrpc.AnimalHandlerImplBase {

    private final IProductDao productDao;
    private final IAnimalDao animalDao;
    public AnimalService(IProductDao productDao, IAnimalDao animalDao) {
        this.productDao = productDao;
        this.animalDao = animalDao;
    }

    @Override
    public void getAnimalsInvolved(RequestAnimalsByProductId id, StreamObserver<AnimalReply> responseObserver) {
        List<AnimalMessage> animals = new ArrayList<>();

        Product product = productDao.getById(id.getId());

        for (Animal animal : product.getAnimals()) {
            animals.add(AnimalAssembler.fromAnimalToMessage(animal));
        }

        AnimalReply reply = AnimalReply.newBuilder().addAllAnimals(animals).build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getAnimalById(IntRequest request, StreamObserver<AnimalMessage> responseObserver) {
        Animal animal = animalDao.getById(request.getInt());
        AnimalMessage reply = AnimalAssembler.fromAnimalToMessage(animal);
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void createAnimal(AnimalMessage request, StreamObserver<AnimalMessage> responseObserver) {
        Animal animal = animalDao.create(AnimalAssembler.fromMessageToAnimal(request));
        AnimalMessage reply = AnimalAssembler.fromAnimalToMessage(animal);
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllAnimals(IntRequest request, StreamObserver<AnimalReply> responseObserver) {
        List<Animal> animalList = animalDao.getAllAnimals();
        AnimalReply reply = null;
        for (Animal animal: animalList
             ) {
            reply = AnimalReply.newBuilder().addAnimals(AnimalAssembler.fromAnimalToMessage(animal)).build();
        }

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
