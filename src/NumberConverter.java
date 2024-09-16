public interface NumberConverter {

    InputResponse input(InputRequest request);

    DelimiterResponse setDelimiter();

    OutputResponse output(OutputRequest request);


}

