package src;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ComputeEngine engine = new ComputeEngineImpl();
        DataStore data = new DataStoreImpl();
        ComputationCoordinator coordinator = new CoordinatorImpl(data, engine);

        System.out.print("Please specify a file you would like to use as your input: ");
        String inputPath = sc.nextLine();
        
        System.out.print("Do the same for an output file: ");
        String outputPath = sc.nextLine();

        FileInputConfig input = new FileInputConfig(inputPath);
        FileOutputConfig output = new FileOutputConfig(outputPath);
        ComputeRequest request = new ComputeRequest(input, output);
        coordinator.compute(request);

        ComputeResult result = coordinator.compute(request);
        System.out.println(result.getStatus());



    }

}
