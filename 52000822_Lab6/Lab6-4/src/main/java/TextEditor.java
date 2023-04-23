import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TextEditor {
    @Autowired
    @Qualifier("pdfWriter")
    private TextWriter textWriter;

    private String text;

    public void input(String text) {
        this.text = text;
    }

    public void save(String fileName) {
        try {
            textWriter.write(fileName, this.text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
