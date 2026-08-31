import java.util.*;

public class Main {

    void run() {
        Scanner sc = new Scanner(System.in);

        int MOD =  1000000007;
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] aArr = new boolean[n + 100];
        int[] dp = new int[n + 100];

        for (int i = 0; i < m; i++) {
            aArr[sc.nextInt()] = true;
        }

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            if (!aArr[i + 1]) dp[i + 1] = (dp[i + 1] + dp[i]) % MOD;
            if (!aArr[i + 2]) dp[i + 2] = (dp[i + 2] + dp[i]) % MOD;
        }

//        for (int i = 0; i < n; i++) {
//            debug("i: " + dp[i]);
//        }
//
        System.out.println(dp[n]);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
