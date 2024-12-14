package src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.protobuf.services.ProtoReflectionService;

public class ComputeServiceServer {
	Server server;
	
	private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50051; // Boilerplate TODO: Consider changing the port (only one server per port)
        
        ComputeEngine computeEngine = new ComputeEngineImpl();
        DataStore dataStore = new DataStoreImpl();
        
        server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
            .addService(new ComputeServiceImpl(dataStore, computeEngine)) // Boilerplate TODO: Change name of class
            .addService(ProtoReflectionService.newInstance())
            .build()
            .start();
        System.out.println("Server started on port " + port);
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type 1 to enter a file, type 2 to enter a list of integers:");
        int choice = keyboard.nextInt();
        
        int inputNum = 0;
        List<Integer> inputs = new ArrayList<Integer>();
        if(choice == 1) {
        	System.out.println("Enter the name of the file:");
        	String inputFileName = keyboard.next();
        	
        	
        } else if(choice == 2) {
        	System.out.println("Enter the list of integers (enter '-1' when done):");
        	while(inputNum != -1) {
        		inputNum = keyboard.nextInt();
        		if(inputNum != -1) {
        			inputs.add(inputNum);
        		}
        	}    	
        } else {
        	System.out.println("Incorrect input, terminating program.");
        	server = null;
        }
        
        keyboard.close();
        
        
        Runtime.getRuntime().addShutdownHook(new Thread() {
          @Override
          public void run() {
        	
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            try {
                if (server != null) {
                  server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
                }
            } catch (InterruptedException e) {
              e.printStackTrace(System.err);
            }
            System.err.println("*** server shut down");
          }
        });
      }

      /**
       * Await termination on the main thread since the grpc library uses daemon threads.
       */
      private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
          server.awaitTermination();
        }
      }

      public static void main(String[] args) throws Exception {
          ComputeServiceServer server = new ComputeServiceServer(); // Boilerplate TODO: Change name of class
          server.start();
          server.blockUntilShutdown();
      }
}
