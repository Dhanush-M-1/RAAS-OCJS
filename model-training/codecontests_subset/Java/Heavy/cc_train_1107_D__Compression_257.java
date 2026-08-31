import java.io.BufferedReader;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.util.Arrays.copyOf;
import static java.util.Arrays.fill;
import static java.util.Arrays.sort;
import static java.util.Collections.reverse;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.comparingLong;

public class Main {
    FastScanner in;
    PrintWriter out;

    private void solve() throws IOException {
        int n = in.nextInt();
        boolean[][] c = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            char[] s = in.next().toCharArray();
            for (int j = 0; j < s.length; j++) {
                c[i][j * 4] = (Integer.parseInt(s[j] + "", 16) & 8) > 0;
                c[i][j * 4 + 1] = (Integer.parseInt(s[j] + "", 16) & 4) > 0;
                c[i][j * 4 + 2] = (Integer.parseInt(s[j] + "", 16) & 2) > 0;
                c[i][j * 4 + 3] = (Integer.parseInt(s[j] + "", 16) & 1) > 0;
            }
        }

        int[][] sum = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                sum[i + 1][j + 1] = (c[i][j] ? 1 : 0) + sum[i][j + 1] + sum[i + 1][j] - sum[i][j];

        int cnt;
        boolean ok;
        for (int x = n; x > 1; x--) {
            if (n % x == 0) {
                ok = true;
                for (int i = x; i <= n; i += x) {
                    for (int j = x; j <= n; j += x) {
                        cnt = sum[i][j] - sum[i - x][j] - sum[i][j - x] + sum[i - x][j - x];
                        if (cnt != 0 && cnt != x * x)
                            ok = false;
                    }
                }
                if (ok) {
                    out.println(x);
                    return;
                }
            }
        }

        out.println(1);
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
        in = new FastScanner(System.in); // new FastScanner(new FileInputStream(".in"));
        out = new PrintWriter(System.out); // new PrintWriter(new FileOutputStream(".out"));

        solve();

        out.flush();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}