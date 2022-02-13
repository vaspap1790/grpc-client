import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.grpc.User;
import org.example.grpc.userServiceGrpc;

public class GRPCClient {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();

        //Stub from proto file
        userServiceGrpc.userServiceBlockingStub userServiceBlockingStub = userServiceGrpc.newBlockingStub(channel);

        User.LoginRequest request = User.LoginRequest.newBuilder().setUsername("Hello").setPassword("Hello").build();

        User.APIResponse response = userServiceBlockingStub.login(request);

        System.out.println(response.getResponseMessage());

    }

}
