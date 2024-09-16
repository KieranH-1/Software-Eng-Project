public class Prototype {
    public void prototype(NumberConverter converter) {

        // specify source for input

        InputResponse inputResponse = converter.input(new InputRequest());


        // delimiter characters: use ',' if they don't specify

        DelimiterResponse delimiterResponse = converter.setDelimiter();

        // determine output destination

        OutputResponse outputResponse = converter.output(new OutputRequest());

     }
}