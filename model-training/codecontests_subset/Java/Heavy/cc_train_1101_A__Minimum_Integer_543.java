import java.io.*;
import java.util.*;
public class NewMain {
    public static double prev(double x) {
        if (x == Math.floor(x)) {
            return x - 1;
        }
        return Math.floor(x);
    }
    public static double next(double x) {
        if (x == Math.ceil(x)) {
            return x + 1;
        }
        return Math.ceil(x);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            double l = in.nextDouble();
            double r = in.nextDouble();
            double d = in.nextDouble();
            double a = l / d;
            double b = r / d;
            double prev = prev(a);
            double next = next(b);
            double res1 = d;
            double res2 = next * d;
            if (res1 < 1 || res1 >= l) {
                System.out.println((int)res2);
            } else {
                System.out.println((int)res1);
            }
        }
    }
}