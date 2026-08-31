import java.util.*;

public class B {

    static long gcd(long a, long b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        long n = sc.nextLong();

        long sqrt = (long) Math.sqrt(n);

        long min = Long.MAX_VALUE;

        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0 && lcm(i, n / i) == n) {
                if (Math.max(i, n / i) < min) {
                    min = Math.max(i, n / i);
                }
            }
        }

        sb.append(min + " " + n / min);

        System.out.print(sb);
    }
}
