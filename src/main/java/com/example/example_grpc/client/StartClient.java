package com.example.example_grpc.client;

import com.example.example_grpc.server.ExampleServiceImpl;
import example.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class StartClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5003)
                .usePlaintext()
                .build();

        // blocking stub because client waits for response (synchronous)
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

        HelloRequest helloRequest = HelloRequest.newBuilder()
                .setName("Onufry")
                .build();

        HelloResponse helloResponse = stub.sayHello(helloRequest);
        System.out.println("Received response: " + helloResponse.getMessage());

        StringsInput stringsInput = StringsInput.newBuilder()
                .setString1("ddd")
                .setString2("eee")
                .build();

        CombinedStringResponse stringResponse = stub.combineStrings(stringsInput);
        System.out.println("Received response: " + stringResponse.getCombinedString());
    }
}
