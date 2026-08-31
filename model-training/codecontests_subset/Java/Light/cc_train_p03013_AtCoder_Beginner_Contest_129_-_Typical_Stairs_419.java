import java.util.*;
public class Main {
    static final long mod = (long) (1e9 + 7);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] oks = new boolean[n + 1];
        Arrays.fill(oks, true);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            oks[a] = false;
        }
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int now = 0; now < n; now++) {
            for (int next = now + 1; next <= Math.min(n, now + 2); next++) {
                if (oks[next]) {
                    dp[next] += dp[now];
                    dp[next] %= mod;
                }
            }
        }
        System.out.println(dp[n]);
        sc.close();
    }
}