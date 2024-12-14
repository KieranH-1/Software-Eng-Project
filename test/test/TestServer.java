package test;


import java.nio.ByteBuffer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import src.Request;
import src.Server;


public class TestServer {

	@Test
	public void testAdding() {
		Server server = new Server();
		
		Request request = new Request(2, 3);
		
		// TODO: send the request to the server

		ByteBuffer requestBuffer = ByteBuffer.allocate(8);
		requestBuffer.putInt(request.getValue1());
		requestBuffer.putInt(request.getValue2());
		byte[] requestData = requestBuffer.array();
		

		// TODO: check that the call was successful

		byte[] responseData = server.addValues(requestData);

		// TODO: save the result into 'result'

		ByteBuffer responseBuffer = ByteBuffer.wrap(responseData);
		int result = responseBuffer.getInt();
		int statusCode = responseBuffer.getInt();
		
		Assert.assertEquals(5, result);
	}
}
