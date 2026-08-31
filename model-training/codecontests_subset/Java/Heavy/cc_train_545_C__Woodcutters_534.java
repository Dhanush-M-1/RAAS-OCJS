//package codeforces;

import java.util.Scanner;

/**
 * Created by nitin.s on 30/05/15.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x = new int[n];
        int[] h = new int[n];
        for(int i = 0; i < n; ++i) {
            x[i] = in.nextInt();
            h[i] = in.nextInt();
        }

        if(n <= 2) {
            System.out.println(n);
            return;
        }
        int I = -9999999;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = x[0] + h[0] < x[1] ? 1 : I;
        for(int i = 1; i < n; ++i) {
            dp[i][0] = I;
            dp[i][1] = I;
            if(x[i - 1] < x[i] - h[i]) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][0] + 1);
            }
            if(x[i - 1] + h[i - 1] < x[i] - h[i]) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + 1);
            }
            dp[i][0] = Math.max(dp[i][0], dp[i-1][0]);
            dp[i][0] = Math.max(dp[i][0], dp[i-1][1]);
            if(i == n - 1 || x[i] + h[i] < x[i + 1]) {
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + 1);
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][1] + 1);
            }
        }
        System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));

    }
}
