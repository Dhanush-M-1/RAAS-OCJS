
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }
    public void solve() {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String N = scan.next();
        int len = N.length();
        int K = scan.nextInt();
        long[][] dp = new long[len][4];
        // K == 1
        for (int i = len-1; 0 <= i; i--) {
            dp[i][1] = 9;
        }
        // K == 2
        for (int i = len - 2; 0 <= i; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][2] += dp[i + 1][1] * 9;
            }
        }
        // K == 3
        for (int i = len - 3; 0 <= i; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][3] += dp[j][2] * 9;
            }
        }
        char[] digits = N.toCharArray();
        int[] d = new int[len];
        for (int i = 0; i < len; i++) {
            d[i] = (int) (digits[i] - '0');
        }
        long ans = 0;
        // len-1桁目までの合計をansに追加する
        for (int i = 1; i < len; i++) {
            ans += dp[i][K];
        }
        // len桁の数字の計算を行う
        int non_zero_count = 0;
        for (int i = 0; i < len; i++) {
            if (0 == d[i]) {
                continue;
            }
            if (1 < d[i]) {
                if (i < len - 1) {
                    // len-i-1桁目(0-index)が1より大きい場合はansに(d[i]-1)*dp[i - 1][K]を追加
                    // 1-d-1まで
                    long s = 0;
                    for (int j = i + 1; j < len; j++) {
                        s += dp[j][K - non_zero_count - 1];
                    }
                    ans += (d[i] - 1) * s;
                }
            }
            // 0
            if (i != 0 && i < len - 1) {
                long s = 0;
                for (int j = i + 1; j < len; j++) {
                    s += dp[j][K - non_zero_count];
                }
                ans += s;
            }
            if (d[i] != 0) {
                non_zero_count += 1;
            }
            if (non_zero_count == K) {
                ans += d[i];
                break;
            }
        }
        System.out.println(ans);
    }
}
