
public class PrototypeCompute {
	public void prototypeComputer(ReaderWriter readerWriter, Computer computer) {
		//initialize program
		InitializeResponse initalizeResponse = readerWriter.initialize(new InitializeRequest());
		
		//read input number and delimiters
		ComputerInputResponse computerInputResponse = readerWriter.readInput(new ComputerInputRequest());
		
		//compute output
		InputNumber inputNumber = computerInputResponse.getInputNumber();
		ComputeResponse computeResponse = computer.computeOutput(inputNumber);
		
		//get output and write down output number
		Delimiter inputOutputDelim = computerInputResponse.getInputOutputDelim();
		Delimiter outputInputDelim = computerInputResponse.getOutputInputDelim();
		ComputerOutputResponse computerOutputResponse = readerWriter.writeOutput(computeResponse.getOutput(), inputOutputDelim, outputInputDelim);		
	}
}
