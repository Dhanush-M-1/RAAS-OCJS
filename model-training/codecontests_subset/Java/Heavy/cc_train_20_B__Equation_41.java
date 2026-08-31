import java.util.Scanner;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            double r = Math.pow(b, 2);
            double f = 4 * a;
            f = f * c;
            double h = r - f;
            if (a == 0 && b == 0 && c == 0) {
                System.out.println(-1);
            } else if (h < 0 || (a == 0 && b == 0)) {
                System.out.println(0);
            } else if (a == 0) {
                double x = (double) -c / b;
                System.out.println(1);
                System.out.printf("%.10f", x);
            } else if (h == 0) {
                double x = (double) -b / (2 * a);
                System.out.println(1);
                System.out.printf("%.10f", x);
            } else {
                double t = Math.sqrt(h);
                double n = 2 * a;
                double x1 = (double) (-b + t);
                x1 = x1 / n;
                double y1 = (double) (-b - t);
                y1=y1/n;
                double x = Math.min(x1, y1);
                double y = Math.max(x1, y1);
                System.out.println(2);
                System.out.printf("%.10f", x);
                System.out.println();
                System.out.printf("%.10f", y);
            }
        }
    }
}
