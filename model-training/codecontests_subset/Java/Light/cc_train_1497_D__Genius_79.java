import java.io.*;
import java.util.*;
public class D {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            long[] tag = new long[n];
            long[] s = new long[n];
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < n; j++) {
                tag[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < n; j++) {
                s[j] = Integer.parseInt(st.nextToken());
            }
            long[] dp = new long[n];
            for (int j = 1; j < n; j++) {
                for (int k = j-1; k >= 0; k--) {
                    if (tag[k]==tag[j]) continue;
                    long temp = dp[k];
                    long abs = Math.abs(s[k] - s[j]);
                    dp[k] = Math.max(dp[k], dp[j]+ abs);
                    dp[j] = Math.max(dp[j], temp+ abs);
                }
            }
            long max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[j]);
            }
            System.out.println(max);

        }
    }
}
