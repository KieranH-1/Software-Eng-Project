package src;

import src.ComputeServiceGrpc.ComputeServiceImplBase;

public class NetworkAPIExtension extends ComputeServiceImplBase{
// 
	public void performComputation(src.NetworkAPI.InputRequest request,
	        io.grpc.stub.StreamObserver<src.NetworkAPI.InputResponse> responseObserver) {
	     //replace w actual implementation
		//io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPerformComputationMethod(), responseObserver);
	    }
}
