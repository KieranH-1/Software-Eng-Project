package src;

import com.google.rpc.context.AttributeContext.Response;

public class Request {

	private static final Response DEFAULT_INSTANCE = null;
	private final int value1;
	private final int value2;
	
	public Request(int value1, int value2) {
		this.value1 = value1;
		this.value2 = value2;
	}

	public int getValue1() {
		return value1;
	}

	public int getValue2() {
		return value2;
	}
	
	public static com.google.rpc.context.AttributeContext.Response getDefaultInstance() {
	      return DEFAULT_INSTANCE;
	    }
}
