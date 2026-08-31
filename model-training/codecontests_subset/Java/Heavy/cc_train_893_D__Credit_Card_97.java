import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Arrays.copyOf;
import static java.util.Arrays.fill;
import static java.util.Arrays.sort;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.shuffle;
import static java.util.Collections.sort;

public class Main {
    private FastScanner in;
    private PrintWriter out;

    private void solve() throws IOException {
        int n = in.nextInt();
        long d = in.nextLong();
        long[] a = new long[n];
        ArrayList<Integer> zero = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
            if (a[i] == 0)
                zero.add(i);
        }
        long[] v = new long[n];
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            v[i] = (i > 0 ? v[i - 1] : 0) + a[i];
            max = max(max, v[i]);
        }
        if (max > d) {
            out.println(-1);
            return;
        }

        long min = Long.MAX_VALUE;
        for (int i : zero)
            min = min(min, v[i]);

        long ans = 0;
        if (min < 0) {

            long[] maxAdd = new long[zero.size()];

            for (int i = 0; i < maxAdd.length; i++) {
                long cur = Long.MAX_VALUE;
                for (int j = zero.get(i); j < (i + 1 < zero.size() ? zero.get(i + 1) : n); j++) {
                    cur = min(cur, d - v[j]);
                }
                maxAdd[i] = cur;
            }

            for (int i = maxAdd.length - 2; i >= 0; i--)
                maxAdd[i] = min(maxAdd[i], maxAdd[i + 1]);

            long[] need = new long[zero.size()];
            for (int i = 0; i < zero.size(); i++)
                need[i] = max(0, -v[zero.get(i)]);

            for (int i = 1; i < need.length; i++) {
                need[i] = max(need[i], need[i - 1]);
            }

            boolean ok = true;
            for (int i = 0; i < zero.size(); i++) {
                ok &= maxAdd[i] >= need[i];
            }

            if (!ok) {
                out.println(-1);
                return;
            }

            long add = 0;
            for (int i = 0; i < zero.size(); i++) {
                if (need[i] > 0 && add < need[i]) {
                    add = maxAdd[i];
                    ans++;
                }
            }
        }
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
        in = new FastScanner(System.in);
        // in = new FastScanner(new FileInputStream(".in"));
        out = new PrintWriter(System.out);
        // out = new PrintWriter(new FileOutputStream(".out"));

        solve();

        out.flush();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}