import java.util.Scanner;

public class LcmChallenge {

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b)  * b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long max = -1;
        for (int i = Math.max(1, n-100); i <= n; i++) {
            for (int j = i; j <= n; j++) {
                for (int k = j; k <= n; k++) {
                    max = Math.max(max, lcm(i, lcm(j, k)));
                }
            }
        }
        System.out.println(max);
    }
}
