import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PlainTextWriter implements TextWriter{

    @Override
    public void writer(String PlainTextWriter, String PdfTextWriter) {
        PrintWriter printW = null;
        try {
            printW = new PrintWriter(new FileWriter(PlainTextWriter));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert printW != null;
        printW.print(PdfTextWriter);
        printW.close();
    }

    @Override
    public void input(String text) {
        System.out.println("Inputting plain text: " + text);
    }

    @Override
    public void save(String fileName) {
        System.out.println("Saving plain text to file: " + fileName);
    }
}
