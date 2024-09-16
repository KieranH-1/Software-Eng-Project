public class PrototypeCompute {
   public void prototypeComputer(ReaderWriter readerWriter, Computer computer) {
      //initialize program
      InitializeResponse initalizeResponse = readerWriter.initialize(new InitializeRequest());
      //read input number and delimiters
      InputResponse inputResponse = readerWriter.readInput(new InputRequest());

      //compute output
      InputNumber inputNumber = inputResponse.getInputNumber();
      ComputeResponse computeResponse = computer.computeOutput(inputNumber);

      //get output and write down output number
      Delimiter inputOutputDelim = inputResponse.getInputOutputDelim();
      Delimiter outputInputDelim = inputResponse.getOutputInputDelim();
      OutputResponse outputResponse = readerWriter.writeOutput(computeResponse.getOutput(), inputOutputDelim, outputInputDelim);
      }
}
