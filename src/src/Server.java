package src;
public class Server {

	public int addValues(byte[] data) {
		// TODO: set 'request' to a value read from 'data'
		byte[] request = data;
		
		int result = request.length + request.length;
		
		// TODO: write the result and a success code to a byte array, and return that
		return result;
	}
}
