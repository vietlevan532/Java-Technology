import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PdfTextWriter implements TextWriter{

    @Override
    public void writer(String PlainTextWriter, String PdfTextWriter) {
        PrintWriter printW = null;
        try {
            printW = new PrintWriter(new FileWriter(PlainTextWriter));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert printW != null;
        printW.println("Printing PDF format: ");
        printW.print(PdfTextWriter);
        printW.close();
    }

    @Override
    public void input(String text) {
        System.out.println("Inputting PDF text: " + text);
    }

    @Override
    public void save(String fileName) {
        System.out.println("Saving PDF text to file: " + fileName);
    }
}
