
public interface ReadWrite {
	
	// will have implementation to read and write to/from specified filed
	ReadInputResponse readFrom(Source source);
	WriteOutputResponse writeTo(String input, Source source);
}
