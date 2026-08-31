import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean a[] = new boolean[n+10];
        for (int i = 0; i < m; i++) {
            a[sc.nextInt()] = true;
        }
        final long MOD = 1000000007L;
        long dp[] = new long[n+10];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if(a[i]) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i-1];
                if(i> 1) dp[i] += dp[i-2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[n]);
    }
}
