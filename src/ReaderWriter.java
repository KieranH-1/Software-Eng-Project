
public interface ReaderWriter {

	InitializeResponse initialize(InitializeRequest initializeRequest);

	ComputerInputResponse readInput(ComputerInputRequest computerInputRequest);

	ComputerOutputResponse writeOutput(OutputNumber output, Delimiter inputOutputDelim, Delimiter outputInputDelim);

}
