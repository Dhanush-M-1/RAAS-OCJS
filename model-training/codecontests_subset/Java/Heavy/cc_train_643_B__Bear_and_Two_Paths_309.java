import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class BearTwoPaths {
    void solve() {
        int n = in.nextInt(), k = in.nextInt();
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt(), d = in.nextInt();

        if (n == 4 || k < n + 1) {
            out.println(-1);
            return;
        }

        boolean[] used = new boolean[n + 1];
        used[a] = used[b] = used[c] = used[d] = true;

        List<Integer> list = new ArrayList<>(n - 4);
        for (int i = 1; i <= n; i++) if (!used[i]) list.add(i);

        for (int i = 0; i < n; i++) {
            if (i > 0) out.print(' ');
            if (i == 0) out.print(a);
            else if (i == 1) out.print(c);
            else if (i == n - 2) out.print(d);
            else if (i == n - 1) out.print(b);
            else out.print(list.get(i - 2));
        }
        out.println();

        for (int i = 0; i < n; i++) {
            if (i > 0) out.print(' ');
            if (i == 0) out.print(c);
            else if (i == 1) out.print(a);
            else if (i == n - 2) out.print(b);
            else if (i == n - 1) out.print(d);
            else out.print(list.get(i - 2));
        }
        out.println();
    }

    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new BearTwoPaths().solve();
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
