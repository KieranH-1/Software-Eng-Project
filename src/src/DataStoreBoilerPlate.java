package src;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;

public class DataStoreBoilerPlate {
	private io.grpc.Server server;

    private void start() throws IOException {
      /* The port on which the server should run */
      int port = 26026; // Boilerplate TODO: Consider changing the port (only one server per port)
      
      server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
          //.addService(new DataStoreImpl())
          .addService(NetworkAPI.newInstance())
          .build()
          .start();
      System.out.println("Server started on port " + port);
      
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
    	DataStoreBoilerPlate server = new DataStoreBoilerPlate();
        server.start();
        server.blockUntilShutdown();
    }


}
