package com.example.example_grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class StartServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = ServerBuilder.forPort(5003)
                .addService(new ExampleServiceImpl())
                .build();
        
        server.start();
        server.awaitTermination();
    }
}
