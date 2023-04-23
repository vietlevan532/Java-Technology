import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"TextEditor", "TextWriter"})
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        TextEditor editor = context.getBean(TextEditor.class);
        editor.input("Ze Zan Ziet xin chaoooo!!!");
        editor.save("output.txt");
    }
}