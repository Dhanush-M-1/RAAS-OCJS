import java.util.Scanner;

public class LCMChallenge146 {
    public static long gcd(long n, long l) {
        return (l == 0) ? n : gcd(l, n % l);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long ans = 1;
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2) {
            System.out.println(2);
            return;
        }
        if ((n & 1) == 0) {
            if (n % 3 == 0)
                n = n - 1;
            ans *= n;
            ans *= n - 1;
            long mul = 1;
            for (int i = (int) (n - 2); i >= (n - 2) / 2; i--) {
                // if(mul<)
                mul = Math.max(mul,
                        Math.min(i / gcd((n - 1), i), i / gcd(n, i)));

            }
            ans *= mul;
            // if (gcd(n, n - 3) == 0)
            // ans *= n - 3;
            // else
            // ans *= (n - 2) / gcd(n, n - 2);
        } else {
            ans *= n;
            ans *= n - 1;
            ans *= n - 2;
        }
        System.out.println(ans);
    }

}
