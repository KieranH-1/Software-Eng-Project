package src; 

public interface WriteResult {
	WriteResultStatus getStatus();
	
	public static enum WriteResultStatus {
		SUCCESS,
		FAILURE;
	}

	static Object newBuilder() {
		// TODO Auto-generated method stub
		return null;
	}
}
