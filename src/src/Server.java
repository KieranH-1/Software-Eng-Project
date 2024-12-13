package src;

import java.nio.ByteBuffer;

public class Server {

	public byte[] addValues(byte[] data) {
		// TODO: set 'request' to a value read from 'data'

		ByteBuffer buffer = ByteBuffer.wrap(data);
		int value1 = buffer.getInt();
		int value2 = buffer.getInt();

		Request request = new Request(value1, value2);
		
		int result = request.getValue1() + request.getValue2();
		
		// TODO: write the result and a success code to a byte array, and return that
		ByteBuffer responseBuffer = ByteBuffer.allocate(8);
		responseBuffer.putInt(result);
		responseBuffer.putInt(0);

		return responseBuffer.array();
	}
}
