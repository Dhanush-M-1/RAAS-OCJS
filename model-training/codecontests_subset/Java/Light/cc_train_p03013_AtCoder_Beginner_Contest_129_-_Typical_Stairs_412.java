import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[] a = new boolean[N];

        for (int i = 0; i < M; i++) {
            int n = sc.nextInt();
            a[n] = true;
        }

        int[] dp = new int[N+1];
        int b = 1000000007;
        for (int i = N; i >= 0; i--) {
            if (i == N) {
                dp[i] = 1;
                continue;
            }
            if (a[i]) {
                dp[i] = 0;
                continue;
            }
            if (i+2 > N) {
                dp[i] = dp[i+1]%b;
                continue;
            }
            dp[i] = (dp[i+1] + dp[i+2])%b;
        }
        System.out.println(dp[0]);
    }
}