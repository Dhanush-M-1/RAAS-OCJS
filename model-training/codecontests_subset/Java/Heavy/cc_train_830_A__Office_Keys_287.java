//package albert.codeforces.officekeys830a;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int p = scanner.nextInt();
        int[] people = new int[n];
        for (int i = 0; i < n; i++) {
            people[i] = scanner.nextInt();
        }
        int[] keys = new int[k];
        for (int i = 0; i < k; i++) {
            keys[i] = scanner.nextInt();
        }
        Arrays.sort(people);
        Arrays.sort(keys);
        long[] dp = new long[k];

        long best = Long.MAX_VALUE;
        ;
        for (int i = 0; i <= k - n; i++) {
            best = Math.min(best, calc(keys[i], people[0], p));
            dp[i] = best;
        }
        for (int i = 1; i < n; i++) {
            long[] newdp = new long[k];
            best = Long.MAX_VALUE;
            for (int j = i; j <= k - n + i; j++) {
                best = Math.min(best, Math.max(dp[j - 1], calc(keys[j], people[i], p)));
                newdp[j] = best;
            }
            dp = newdp;
        }
        System.out.println(dp[k - 1]);
    }

    private static long calc(long keyCoord, long pCoord, long T) {
        return Math.abs(keyCoord - pCoord) + Math.abs(keyCoord - T);
    }
}
