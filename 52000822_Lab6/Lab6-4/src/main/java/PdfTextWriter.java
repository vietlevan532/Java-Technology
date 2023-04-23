import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Component("pdfWriter")
public class PdfTextWriter implements TextWriter {

    public void write(String fileName, String text) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert printWriter != null;
        printWriter.println("Printing pdf format: ");
        printWriter.print(text);
        printWriter.close();
    }

}