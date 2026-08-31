import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
/**
 * @author Don Li
 */
public class NewYearBookReading {
    void solve() {
        int n = in.nextInt(), m = in.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) w[i] = in.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = in.nextInt() - 1;
 
        long ans = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            Queue<Integer> qu = new LinkedList<>();
            for (int j = m - 1; j >= 0; j--) if (b[j] == i) qu.offer(j);
            int start = m - 1;
            while (!qu.isEmpty()) {
                int t = qu.poll();
                Arrays.fill(used, false);
                for (int k = start; k > t; k--) {
                    if (!used[b[k]]) {
                        used[b[k]] = true;
                        ans += w[i];
                    }
                }
                start = t - 1;
            }
        }
 
        out.println(ans);
    }
 
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new NewYearBookReading().solve();
        out.close();
    }
 
    static FastScanner in;
    static PrintWriter out;
 
    static class FastScanner {
        BufferedReader in;
        StringTokenizer st;
 
        public FastScanner(BufferedReader in) {
            this.in = in;
        }
 
        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
 
        public long nextLong() {
            return Long.parseLong(nextToken());
        }
 
        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
