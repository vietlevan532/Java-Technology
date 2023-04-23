import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TextEditor {

    @Qualifier("plainTextWriter")
    @Autowired
    private TextWriter plainTextWriter;

    @Qualifier("pdfTextWriter")
    @Autowired
    private TextWriter pdfTextWriter;


    public void input(String text, String type) {
        if (type.equals("plain")) {
            plainTextWriter.input(text);
        } else if (type.equals("pdf")) {
            pdfTextWriter.input(text);
        }
    }

    public void save(String fileName, String type) {
        if (type.equals("plain")) {
            plainTextWriter.save(fileName);
        } else if (type.equals("pdf")) {
            pdfTextWriter.save(fileName);
        }
    }
}
