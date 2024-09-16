
public interface ReaderWriter {

	InitializeResponse initialize(InitializeRequest initializeRequest);

	InputResponse readInput(InputRequest inputRequest);

	OutputResponse writeOutput(OutputNumber output, Delimiter inputOutputDelim, Delimiter outputInputDelim);

}
