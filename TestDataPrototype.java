import static org.junit.jupiter.api.Assertions.fail;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;


public class TestDataPrototype
{
	List<Integer> intList = Arrays.asList(1, 2, 3); 
	List<String> stringList = new ArrayList<String>();
	
	@Test
	public void testPrototype() {
		// test case
		DataPrototype testPrototype = new DataPrototype(get.intList(0), "one", intList, storage, readWrite);
		
		// test readInput, doesn't return something I can test;
		readInput = readWrite.readFrom(intList);
		
		// test writeOutput;
		checkWriteOutput("one", stringList);
		
		
	}

	private void checkWriteOutput(String convertedUserInput, Source userSource) {
		boolean hasFailed = true;
		writeOutput = readWrite.writeTo(convertedUserInput, userSource);
		if(System.out.println(stringList.get(0)).equals("one")) {
			hasFailed = false;
		}
		System.out.println("Write Output has Failed: " + hasFailed);
	}

	
}
