
import java.util.Scanner;

public class C {
    public static long lcm(long x, long y) {
        return x * y / gcd(x, y);
    }

    public static long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        if (n <= 2)
            System.out.println(n);
        else if (n % 2 == 1)
            System.out.println(n * (n - 1) * (n - 2));
        else {
            long max = (n - 1) * (n - 2) * (n - 3);
            long temp = n * (n - 1);
            for (long i = n - 2; i > 0; i--)
                max = Math.max(max, lcm(temp, i));
            System.out.println(max);
        }
    }
}
