import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TediousLee {
    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] Args) {
        FastReader fr = new FastReader();
        int t;
        int x;
        long MOD = 1000000007L;
        int LIM = 2000001;
        t = fr.nextInt();
        long[] dp = new long[LIM + 1];
        dp[0] = dp[1] = dp[2] = 0;
        dp[3] = 4L;
        dp[4] = 4L;
        for(int i = 5; i <= LIM; i++) {
            dp[i] = dp[i - 1] + (2L * dp[i - 2]) + ((i % 3 == 0) ? 4: 0);
            dp[i] %= MOD;
        }
        while((t--) > 0){
            x = fr.nextInt();
            System.out.println(dp[x]);
        }
    }
}
