package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.ComputationCoordinator;
import src.ComputeEngineImpl;
import src.CoordinatorImpl;
import src.DataStoreImpl;

public class TestMultiUser {
	
	// TODO 1: change the type of this variable to the name you're using for your
	// User <-> ComputeEngine API
	private ComputationCoordinator coordinator;
	
	@BeforeEach
	public void initializeComputeEngine() {
		//TODO 2: create an instance of your coordinator component; this is the component
		// that the user will make requests to
		// Store it in the 'coordinator' instance variable
		coordinator = new CoordinatorImpl(new DataStoreImpl(), new ComputeEngineImpl());
	}

	@Test
	public void compareMultiAndSingleThreaded() throws Exception {
		int numberThreads = 4;
		List<TestUser> testUsers = new ArrayList<>();
		for (int i = 0; i < numberThreads; i++) {
			testUsers.add(new TestUser(coordinator));
		}
		
		// Run single threaded
		String singleThreadFilePrefix = "test" + File.separatorChar + "testMultiUser.compareMultiAndSingleThreaded.test.singleThreadOut.tmp";
		for (int i = 0; i < numberThreads; i++) {
			File singleThreadedOut = 
					new File(singleThreadFilePrefix + i);
			singleThreadedOut.createNewFile();
			singleThreadedOut.deleteOnExit();
			testUsers.get(i).run(singleThreadedOut.getCanonicalPath());
		}
		
		// Run multi threaded
		ExecutorService threadPool = Executors.newCachedThreadPool();
		List<Future<?>> results = new ArrayList<>();
		String multiThreadFilePrefix = "test" + File.separatorChar + "testMultiUser.compareMultiAndSingleThreaded.test.multiThreadOut.tmp";
		for (int i = 0; i < numberThreads; i++) {
			File multiThreadedOut = 
					new File(multiThreadFilePrefix + i);
			multiThreadedOut.createNewFile();
			multiThreadedOut.deleteOnExit();
			String multiThreadOutputPath = multiThreadedOut.getCanonicalPath();
			TestUser testUser = testUsers.get(i);
			results.add(threadPool.submit(() -> testUser.run(multiThreadOutputPath)));
		}
		
		results.forEach(future -> {
			try {
				future.get();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
		
		
		// Check that the output is the same for multi-threaded and single-threaded
		List<String> singleThreaded = loadAllOutput(singleThreadFilePrefix, numberThreads);
		List<String> multiThreaded = loadAllOutput(multiThreadFilePrefix, numberThreads);
		Assert.assertEquals(singleThreaded, multiThreaded);
	}

	private List<String> loadAllOutput(String prefix, int numberThreads) throws IOException {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < numberThreads; i++) {
			File multiThreadedOut = 
					new File(prefix + i);
			result.addAll(Files.readAllLines(multiThreadedOut.toPath()));
		}
		return result;
	}
}
