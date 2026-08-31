import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.nextInt();
            double[] a = new double[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            double l = -1e15;
            double r = +1e15;
            for (int step = 0; step < 200; step++) {
                double m1 = l + 0.33 * (r - l);
                double m2 = l + 0.66 * (r - l);
                if (f(a, m1) > f(a, m2)) {
                    l = m1;
                } else {
                    r = m2;
                }
            }
            out.printf("%.10f\n", f(a, 0.5 * (l + r)));
        }

        private double f(double[] a, double x) {
            double s = 0;
            double min = 0;
            double max = 0;
            for (double y : a) {
                s += y - x;
                min = Math.min(s, min);
                max = Math.max(s, max);
            }
            return max - min;
        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

