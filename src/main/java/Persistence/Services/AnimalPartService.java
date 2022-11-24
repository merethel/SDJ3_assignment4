package Persistence.Services;

import Persistence.Daos.DaoInterfaces.IAnimalPartDao;
import Shared.Assemblers.AnimalAssembler;
import Shared.Assemblers.AnimalPartAssembler;
import Shared.Model.AnimalPart;
import animals.AnimalMessage;
import animals.AnimalPartCreationDtoMessage;
import animals.AnimalPartHandlerGrpc;
import animals.AnimalPartMessage;
import io.grpc.stub.StreamObserver;

public class AnimalPartService extends AnimalPartHandlerGrpc.AnimalPartHandlerImplBase {

    private final IAnimalPartDao animalPartDao;

    public AnimalPartService(IAnimalPartDao animalPartDao) {
        this.animalPartDao = animalPartDao;
    }

    @Override
    public void createAnimalPart(AnimalPartCreationDtoMessage request, StreamObserver<AnimalPartMessage> responseObserver) {
        AnimalPart animalPart = animalPartDao.create(AnimalPartAssembler.fromMessageToAnimalPartCreationDto(request));
        AnimalPartMessage reply = AnimalPartAssembler.fromAnimalPartToMessage(animalPart);
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
