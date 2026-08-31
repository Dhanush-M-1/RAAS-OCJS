import java.io.BufferedReader;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.copyOf;
import static java.util.Arrays.fill;
import static java.util.Arrays.sort;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;

public class Main {
    FastScanner in;
    PrintWriter out;

    private void solve() throws IOException {
        long a = in.nextLong(), b = in.nextLong(), c = in.nextLong();

        if (a == 0) {
            if (b == 0)
                out.println(c == 0 ? -1 : 0);
            else
                out.println(1 + "\n" + (double) -c / b);
        } else {
            long d = b * b - 4 * a * c;
            if (d < 0)
                out.println(0);
            else if (d == 0)
                out.println(1 + "\n" + (double) -b / (2 * a));
            else {
                double x1 = ((double) -b - sqrt(d)) / (2 * a),
                        x2 = ((double) -b + sqrt(d)) / (2 * a);
                out.println(2 + "\n" + min(x1, x2) + "\n" + max(x1, x2));
            }
        }
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
            return Double.parseDouble(next().replace(',', '.'));
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
