import java.util.*;

public class A {

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

        int n = sc.nextInt();

        if (n == 1 || n == 2) {
            System.out.println(n);
            return;
        }

        if (n % 2 != 0) {
            System.out.println((lcm(n - 2, lcm(n - 1, n))));
            return;
        }

        long ans = lcm(n - 3, lcm(n - 2, n - 1));

        ans = Math.max(ans, lcm(n - 3, lcm(n - 1, n)));

        sb.append(ans).append("\n");

        System.out.print(sb);
    }
}