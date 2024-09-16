
public interface ReaderWriter {

   InitializeResponse initialize(InitializeRequest initializeRequest);

   InputNumberResponse readInput(InputRequest inputRequest);

   OutputNumberResponse writeOutput(OutputNumber output, Delimiter inputOutputDelim, Delimiter outputInputDelim);

}
