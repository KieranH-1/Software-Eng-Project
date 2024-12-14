package src;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ComputeEngine engine = new ComputeEngineImpl();
        DataStore data = new DataStoreImpl();
        ComputationCoordinator coordinator = new CoordinatorImpl(data, engine);

        try {
            System.out.print("Please specify a file you would like to use as your input: ");
            String inputPath = sc.nextLine();
            File inputFile = new File(inputPath);
            if (!inputFile.exists() || !inputFile.isFile()) {
                System.out.println("Error: Input file does not exist or is not a valid file.");
                return;
            }

            System.out.print("Enter an output file: ");
            String outputPath = sc.nextLine();
            File outputFile = new File(outputPath);

            FileInputConfig input = new FileInputConfig(inputPath);
            FileOutputConfig output = new FileOutputConfig(outputPath);
            ComputeRequest request = new ComputeRequest(input, output);

            long start = System.currentTimeMillis();
            
            ComputeResult result = coordinator.compute(request);
            long end = System.currentTimeMillis();
            long totalTime = end - start;
            System.out.println("Computation Result: " + result.getStatus());
            System.out.println("Done in " + totalTime + " milliseconds.");

        } catch (Exception e) {
            System.out.println("An error occurred during computation: ");
            e.printStackTrace();
        } finally {
            coordinator.close();
            sc.close();
        }

    }

}
