
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @Description:
 * @Author: quanrui.li
 * @Date: 2021/3/20
 */
public class D {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new D().run(in, out);
        out.close();
    }

    void run(FastScanner in, PrintWriter out) {
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            long[] dp = new long[n+1];
            int[] tag = new int[n+1];
            long[] score = new long[n+1];
            for (int i = 1; i <= n; i++) {
                tag[i] = in.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                score[i] = in.nextLong();
            }
            long max = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i-1; j > 0; j--) {
                    if (tag[i]!=tag[j]) {
                        long temp = dp[i];
                        long abs = Math.abs(score[i] - score[j]);
                        dp[i]=Math.max(dp[i],abs+dp[j]);
                        dp[j]=Math.max(dp[j],abs+temp);
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                max = Math.max(max, dp[i]);
            }
            out.println(max);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = null;
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
