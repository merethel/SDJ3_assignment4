package BusinessLogic.GrpcClient;

import animals.AnimalHandlerGrpc;
import animals.AnimalPartHandlerGrpc;
import animals.ProductHandlerGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcHandler {
    private static ManagedChannel managedChannel;

    public static AnimalHandlerGrpc.AnimalHandlerBlockingStub getAnimalStub() {
        managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext().build();

        return AnimalHandlerGrpc
                .newBlockingStub(managedChannel);
    }
    public static ProductHandlerGrpc.ProductHandlerBlockingStub getProductStub() {
        managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext().build();

        return ProductHandlerGrpc
                .newBlockingStub(managedChannel);
    }

    public static AnimalPartHandlerGrpc.AnimalPartHandlerBlockingStub getAnimalPartStub() {
        managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext().build();

        return AnimalPartHandlerGrpc
                .newBlockingStub(managedChannel);
    }
}
