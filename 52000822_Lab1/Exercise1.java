public class Exercise1 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Invalid expression");
            return;
        }
        double val1, val2, res;
        val1 = Double.valueOf(args[0]);
        val2 = Double.valueOf(args[2]);
        switch (args[1]) {
            case "+":
                res = val1 + val2;
                System.out.println(res);
                break;
            case "-":
                res = val1 - val2;
                System.out.println(res);
                break;
            case "x":
                res = val1 * val2;
                System.out.println(res);
                break;
            case "/":
                res = val1 / val2;
                System.out.println(res);
                break;
            case "^":
                res = Math.pow(val1, val2);
                System.out.println(res);
                break;
            default:
                break;
        }
    }
}