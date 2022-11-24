package Persistence.Services;

import Persistence.Daos.DaoImplementations.TrayDao;
import Shared.Assemblers.AnimalAssembler;
import Shared.Assemblers.TrayAssembler;
import Shared.Model.Animal;
import Shared.Model.Tray;
import animals.AnimalMessage;
import animals.IntRequest;
import animals.TrayHandlerGrpc;
import animals.TrayMessage;
import io.grpc.stub.StreamObserver;

public class TrayService extends TrayHandlerGrpc.TrayHandlerImplBase {

    private TrayDao trayDao;

    public TrayService(TrayDao trayDao) {
        this.trayDao = trayDao;
    }

    @Override
    public void getTrayById(IntRequest request, StreamObserver<TrayMessage> responseObserver) {
        Tray tray = trayDao.getById(request.getInt());
        TrayMessage reply = TrayAssembler.fromTrayToMessage(tray);
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
