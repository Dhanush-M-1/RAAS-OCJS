import java.util.Scanner;

public class Equation {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        calculate(SCANNER.nextDouble(),SCANNER.nextDouble(),SCANNER.nextDouble());
    }


    private static void calculate(double a, double b, double c) {
        if (a == 0 && b == 0 && c == 0) {
            System.out.println("-1");
            return;
        }

        if (a == 0 && b == 0) {
            System.out.println("0");
            return;
        }

        if (a == 0) {
            System.out.printf("1\n%.10f\n", -c / b);
            return;
        }

        double d = (b * b) - (4 * a * c);

        if (d > 0) {
            double x1 = (-b - Math.sqrt(d)) / (a * 2), x2 = (-b + Math.sqrt(d)) / (a * 2);
            System.out.printf("2\n%.10f\n%.10f\n", Math.min(x1, x2), Math.max(x1, x2));
        } else if (d == 0) {
            System.out.printf("1\n%.10f\n", -b / (2 * a));
        } else {
            System.out.println("0");
        }
    }
}
