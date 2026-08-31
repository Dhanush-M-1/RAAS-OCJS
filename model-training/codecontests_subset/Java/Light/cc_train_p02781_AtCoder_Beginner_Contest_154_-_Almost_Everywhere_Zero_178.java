import java.util.Scanner;

public class Main implements Runnable {

    private static int MOD = 1_000_000_007;

    public static void main(String[] args) {
        // Run with 32MB stack
        Thread thread = new Thread(null, new Main(), "", 32 * 1024 * 1024);
        thread.start();
    }

    @Override
    public void run() {
        final Scanner scanner = new Scanner(System.in);
        solve(scanner);
    }

    static void solve(Scanner scanner) {
        String N = scanner.next();
        int K = Integer.parseInt(scanner.next());

        int[][][] dp = new int[N.length() + 1][K + 2][2];
        // 0 digit, 0 non-0, same
        dp[0][0][0] = 1;

        for (int i = 0; i < N.length(); i++) {
            int c = N.charAt(i) - '0';
            for (int j = 0; j <= K; j++) {
                if (c == 0) {
                    dp[i + 1][j][0] += dp[i][j][0];
                } else {
                    dp[i + 1][j + 1][0] += dp[i][j][0];
                    dp[i + 1][j + 1][1] += (c - 1) * dp[i][j][0];
                    dp[i + 1][j][1] += dp[i][j][0];
                }
                dp[i + 1][j][1] += dp[i][j][1];
                dp[i + 1][j + 1][1] += 9 * dp[i][j][1];
            }
        }

        System.out.println(dp[N.length()][K][0] + dp[N.length()][K][1]);

    }
}

