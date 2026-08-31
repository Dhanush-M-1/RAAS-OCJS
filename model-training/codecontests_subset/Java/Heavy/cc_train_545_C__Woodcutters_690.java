
import java.util.Scanner;

public class CF545C {
    
    public static long max(long a, long b, long c) {
        return Math.max(a, Math.max(b, c));
    }
    
    public static void main(String[] args) {
        int n,i=1,j,k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long[] x = new long[n];
        long[] h = new long[n];
        for (j=0;j<n;j++) {
            x[j] = sc.nextInt();
            h[j] = sc.nextInt();
        }
        long[] dp = new long[n];
        dp[0] = 1;
        for (j=1;j<n;j++) {
            if (dp[j-1] == 0 && x[j-1] + h[j-1] < x[j] - h[j]) {
                dp[j] = dp[j-1] = 1;
                i += 2;
            } else if (dp[j-1] == 0 && x[j-1] + h[j-1] < x[j]) {
                dp[j-1] = 1;
                i++;
            } else if (x[j] - h[j] > x[j-1]) {
                dp[j] = 1;
                i++;
            }
        }
/*
        for (j=0;j<n;j++) {
            System.out.printf(dp[j] + " ");
        }
        System.out.printf("");
        */
        System.out.println(dp[n-1] == 0?i+1:i);
    }
}
