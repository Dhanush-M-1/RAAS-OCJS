import java.util.Scanner;

public class C146A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long ans = 0;
        if (n <= 6) {
            if (n == 1)
                ans = 1;
            if (n == 2)
                ans = 2;
            if (n == 3)
                ans = 6;
            if (n == 4)
                ans = 12;
            if (n == 5)
                ans = 60;
            if (n == 6)
                ans = 60;
        } else {
            if (n % 2 == 1)
                ans = n * (n - 1) * (n - 2);
            else {
                ans = n * (n - 1);
                for (long j = n - 2; j >= 1; --j) {
                    if (gcd(n, j) == 1 && gcd(n - 1, j) == 1) {
                        ans *= j;
                        break;
                    }
                }
                ans = Math.max(ans, (n -1) * (n -2) * (n - 3));
            }
        }
        System.out.println(ans);
    }

    private static long gcd(long a, long b) {
        return (a == 0) ? b : gcd(b % a, a);
    }
}
