//package codeforces;

import java.util.Scanner;

/**
 * Created by nitin.s on 02/04/16.
 */
public class LCMChallenge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long res = 0;
        for(long a = Math.max(1, n - 10); a <= n; ++a) {
            for(long b = a; b <= n; ++b) {
                for(long c = b; c <= n; ++c) {
                    long lcm = a / gcd(a, b) * b;
                    lcm = lcm / gcd(lcm, c) * c;
                    res = Math.max(res, lcm);
                }
            }
        }
        System.out.println(res);
    }

    private static long gcd(long a, long b) {
        while(b > 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
