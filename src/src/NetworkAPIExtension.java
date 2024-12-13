package src;

import src.ComputeServiceGrpc.ComputeServiceImplBase;

public class NetworkAPIExtension extends ComputeServiceImplBase{
	
	private CoordinatorImpl coordinator;

	public NetworkAPIExtension(){
		this.coordinator = new CoordinatorImpl(new DataStoreImpl(), new ComputeEngineImpl());		
	}

	public void performComputation(Request request, StreamObserver<Response>) {
		Response request;
		
		try {
			Result result = coordinator.beginComputation(new Request(
					request.getInputFileName(),
					request.getDelimiter()
					));
			userinput.UserInput.ComputeResultStatus status;

			if (result.getStatus() == ComputeResultStatus.SUCCESS) {
				status = userinput.UserInput.ComputeResultStatus.SUCCESS;
			} else if (result.getStatus() == ComputeResultStatus.INVALID_REQUEST) {
				status = userinput.UserInput.ComputeResultStatus.INVALID_REQUEST;
			} else {
				status = userinput.UserInput.ComputeResultStatus.FAILURE;
			}

			response = ComputationResponse.newBuilder()
					.setResult(status)
					.build();
		} catch (Exception e) {
			System.err.println("Error processing request: " + e.getMessage());
			response = Response.newBuilder()
					.setErrorMessage("Computation failed: " + e.getMessage())
					.build();
		}

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	/*
public void performComputation(src.NetworkAPI.InputRequest request,
		io.grpc.stub.StreamObserver<src.NetworkAPI.InputResponse> responseObserver) {
	     //replace w actual implementation
		//io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPerformComputationMethod(), responseObserver);
		//request.coordinator
	
		
	}*/
	

}
