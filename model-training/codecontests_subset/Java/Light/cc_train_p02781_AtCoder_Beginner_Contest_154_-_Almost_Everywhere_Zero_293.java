import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int length = chars.length;
        int[] arr = new int[length + 1];
        for (int i = 0; i < length; i++) {
            arr[i + 1] = chars[i] - '0';
        }
        int kk = Integer.parseInt(br.readLine());
        long[][][] dp = new long[length + 1][2][5];
        dp[0][1][0] = 1;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][0][j] += dp[i - 1][0][j];
                for (int k = 1; k < 10; k++) {
                    dp[i][0][j + 1] += dp[i - 1][0][j];
                }
                if (arr[i] == 0) {
                    dp[i][1][j] += dp[i - 1][1][j];
                } else {
                    dp[i][0][j] += dp[i - 1][1][j];
                    for (int k = 1; k < arr[i]; k++) {
                        dp[i][0][j + 1] += dp[i - 1][1][j];
                    }
                    dp[i][1][j + 1] += dp[i - 1][1][j];
                }
            }
        }
        long count = dp[length][0][kk] + dp[length][1][kk];
        System.out.println(count);
    }
}
