import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TextEditor textEditor = context.getBean(TextEditor.class);

        textEditor.input("Hello, World!", ".txt");
        textEditor.save("output.txt", ".txt");
    }
}
