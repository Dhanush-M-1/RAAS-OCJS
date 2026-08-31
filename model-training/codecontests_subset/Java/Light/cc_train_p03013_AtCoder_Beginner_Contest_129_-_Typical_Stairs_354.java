import java.util.Scanner;

class Main {
    static final long mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        for (int i = 1; i < m; i++) {
            if (a[i] - a[i - 1] == 1) {
                System.out.println(0);
                return;
            }
        }
        long dp[] = new long[n + 2];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n + 2; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        if (m == 0) {
            System.out.println(dp[n + 1]);
            return;
        }
        long ans = 1;
        ans *= dp[a[0]];
        for (int i = 1; i < m; i++) {
            ans *= dp[a[i] - a[i - 1] - 1];
            ans %= mod;
        }
        ans *= dp[n - a[m - 1]];
        ans %= mod;
        System.out.println(ans);
    }
}
