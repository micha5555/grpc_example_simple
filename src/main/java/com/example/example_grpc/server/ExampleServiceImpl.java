package com.example.example_grpc.server;

import example.*;
import io.grpc.stub.StreamObserver;

public class ExampleServiceImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String name = request.getName();
        String message = "Hello, " + name + "!";
        HelloResponse response = HelloResponse.newBuilder()
                .setMessage(message)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void combineStrings(StringsInput input, StreamObserver<CombinedStringResponse> responseObserver) {
        String string1 = input.getString1();
        String string2 = input.getString2();
        String combined = string1 + string2;
        CombinedStringResponse response = CombinedStringResponse.newBuilder()
                .setCombinedString(combined)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}