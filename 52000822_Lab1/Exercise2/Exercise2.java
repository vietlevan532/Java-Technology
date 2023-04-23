import vn.edu.tdtu.*;

public class Exercise2 {

    public static void main(String[] args) {
        int a[] = {2, 8, 6, 4};
        int b[] = {3, 9, 7, 5};
        int c[] = ArrayHandler.merge(a, b);
        ArrayOutput.print(c);
        ArrayHandler.sort(c);
        ArrayOutput.print(c);
        ArrayOutput.write(c, "output.txt");
    }

}