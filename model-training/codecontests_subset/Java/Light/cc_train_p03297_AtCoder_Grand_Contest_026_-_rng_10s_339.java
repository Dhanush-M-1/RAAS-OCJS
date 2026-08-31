import java.util.Scanner;

class B {
    static final String YES = "Yes";
    static final String NO = "No";

    static long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public static void main(String... args) {
        final Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            final long A = sc.nextLong();
            final long B = sc.nextLong();
            final long C = sc.nextLong();
            final long D = sc.nextLong();
            if (B > D) {
                System.out.println(NO);
                continue;
            }
            final long aa = A - Math.max(A - C + B - 1, B) / B * B;
            if (aa < 0) {
                System.out.println(NO);
                continue;
            }
            final long gcd = gcd(D, B);
            System.out.println((C - aa + gcd) / gcd * gcd + aa >= B ? YES : NO);
        }
    }
}
public class Main {
    public static void main(String...args) {
        B.main();
    }
}
