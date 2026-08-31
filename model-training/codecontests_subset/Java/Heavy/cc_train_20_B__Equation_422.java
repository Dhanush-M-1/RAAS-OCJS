import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        new B().solve();
    }

    public void solve() {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        if (a == 0) {
            if (b == 0 && c == 0) {
                System.out.println(-1);
                return;
            }
            if (b == 0 && c != 0) {
                System.out.println(0);
                return;
            }
            
            System.out.println(1);
            System.out.printf("%.10f\n", (double) -1.0d * c / b);
            return;
        }

        double r = 1.0d * b * b - 4.0d * a * c;
        if (r < 0) {
            System.out.println(0);
            return;
        } else if (r == 0) {
            System.out.println(1);
            System.out.printf("%.10f\n", -b*1.0d/a/2.0d);
            return;
        } else {
            r = Math.sqrt(r);
            double x1 = 1.0d * (-b - r) / 2.0d / a;
            double x2 = 1.0d * (-b + r) / 2.0d / a;
            System.out.println(2);
            System.out.printf("%.10f\n", Math.min(x1, x2));
            System.out.printf("%.10f\n", Math.max(x1, x2));
        }
    }
}