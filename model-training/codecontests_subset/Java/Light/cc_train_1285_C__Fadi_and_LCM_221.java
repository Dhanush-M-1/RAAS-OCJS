

import java.util.Scanner;

/**
 * Created by liwj
 * date:2019/9/21
 * comment:cf
 */
public class CodeForces {

    private static boolean isPrime(long x) {
        if (x <= 3) return true;
        for (long i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    private static long gcd(long m, long n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }

    public static void main(String[] args) throws Exception {

        Scanner cin = new Scanner(System.in);
        long x = cin.nextLong();

        if (isPrime(x)) {
            System.out.println("1 " + x);
        } else {
            long ansa = 1;
            long ansb = x;
            for (long i = 1; i * i <= x; i++) {
                if (x % i == 0) {
                    long a = i;
                    long b = x / a;
                    long gcd = gcd(b, a);
                    if (b < ansb && (gcd == 1)) {
                        ansa = a;
                        ansb = b;
                    }
                }
            }
            System.out.println(ansa + " " + ansb);
        }
    }
}