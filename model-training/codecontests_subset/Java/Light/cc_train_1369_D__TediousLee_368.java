import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Task4 {

    public static void main(String[] args) throws IOException {
        new Task4().solve();
    }

    private void solve() throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(f.readLine());
        int upTo = 2000001;
        int mod = 1000000007;
        long[] dp2 = new long[upTo];
        dp2[3] = 4;
        boolean[] isTaken = new boolean[upTo];
        isTaken[3] = true;
        for (int i = 4; i < upTo; i++) {
            if (isTaken[i - 1] || isTaken[i - 2]) {
                dp2[i] = dp2[i - 1] + dp2[i - 2] * 2;
            } else {
                dp2[i] = 4 + dp2[i - 2] * 2 + dp2[i - 1];
                isTaken[i] = true;
            }
            dp2[i] %= mod;
        }


        for (int t1 = 0; t1 < t; t1++) {
            int n = Integer.parseInt(f.readLine());
            out.println(dp2[n]);
        }


        /*
        for (int i = 2; i < 60; i++) {
            System.out.println((dp[0][2][i] > dp[1][2][i]) + " " + i);
        } */
        out.close();
    }
}
