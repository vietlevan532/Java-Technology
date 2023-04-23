import java.io.IOException;

public interface TextWriter {
    void writer(String PlainTextWriter, String PdfTextWriter) throws IOException;
    void input(String text);
    void save(String fileName);
}
