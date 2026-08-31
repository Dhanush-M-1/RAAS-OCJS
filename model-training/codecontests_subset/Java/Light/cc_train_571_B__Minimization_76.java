import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class d317d2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int m = n % k, d = k - m, q = n / k;
        int[] a = new int[n];
        while (n-- > 0) {
            a[n] = in.nextInt();
        }
        in.close();
        Arrays.sort(a);
        long[][] dp = new long[m + 1][d + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= d; i++) {
            dp[0][i] = dp[0][i - 1] + a[q * i - 1] - a[q * (i - 1)];
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + a[(q + 1) * i - 1] - a[(q + 1) * (i - 1)];
            for (int j = 1; j <= d; j++) {
                dp[i][j] = Math.min(dp[i][j - 1] + a[q * j + (q + 1) * i - 1]
                        - a[q * (j - 1) + (q + 1) * i], dp[i - 1][j]
                        + a[q * j + (q + 1) * i - 1]
                        - a[q * j + (q + 1) * (i - 1)]);
            }
        }
        System.out.println(dp[m][d]);
    }
}
