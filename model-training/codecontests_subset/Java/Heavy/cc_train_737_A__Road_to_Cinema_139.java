import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.lang.Math.min;
import static java.util.Collections.sort;

public class Main {
    private FastScanner in;
    private PrintWriter out;

    private void solve() throws IOException {
        int n = in.nextInt(), k = in.nextInt();
        long s = in.nextLong(), t = in.nextLong();

        if (t < s) {
            out.println(-1);
            return;
        }

        long[] c = new long[n], v = new long[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextLong();
            v[i] = in.nextLong();
        }

        ArrayList<Long> g = new ArrayList<>(k);
        g.add((long) 0);
        for (int i = 0; i < k; i++)
            g.add(in.nextLong());
        g.add(s);
        sort(g);
        k++;
        for (int i = 0; i < k; i++)
            g.set(i, g.get(i + 1) - g.get(i));
        g.remove(k);
        sort(g, Collections.reverseOrder());

        int i = 0;
        long sum = 0, x = min(t - s, s);
        for (; i < k; i++) {
            sum += g.get(i);
            if (sum >= x + g.get(i) * (long) (i + 1))
                break;
        }
        if (i < k)
            sum -= g.get(i);

        long ans = -1;
        long V = (i > 0 ? ((sum - x + i - 1) / (long) i) : g.get(0)) + g.get(0);
        for (int j = 0; j < n; j++)
            if (v[j] >= V)
                ans = ans == -1 ? c[j] : min(ans, c[j]);
        out.println(ans);
    }

    class FastScanner {
        StringTokenizer st;
        BufferedReader br;

        FastScanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        boolean hasNext() throws IOException {
            return br.ready() || (st != null && st.hasMoreTokens());
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        boolean hasNextLine() throws IOException {
            return br.ready();
        }

    }

    private void run() throws IOException {
        in = new FastScanner(System.in); // in = new FastScanner(new FileInputStream(".in"));
        out = new PrintWriter(System.out); // out = new PrintWriter(new FileOutputStream(".out"));

        solve();

        out.flush();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}