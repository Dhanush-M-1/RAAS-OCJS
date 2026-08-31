import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AddOne {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [][] dp = new int[2_00_001][10];
        int MOD = 1_000_000_007;
        for (int i = 0; i < 10; i++)
            dp[0][i] = 1;
        for (int i = 1; i < 2_00_001; i++) {
            for (int j = 0; j < 9; j++) {
                dp[i][j] = dp[i-1][j+1];
            }
            dp[i][9] = (dp[i-1][0] + dp[i-1][1])%MOD;
        }
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            String [] inp = buffer.readLine().split(" ");
            char [] num = inp[0].toCharArray();
            int steps = Integer.parseInt(inp[1]);
            long ans = 0;
            for (char ch : num) {
                ans += dp[steps][ch-'0'];
                ans %= MOD;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
