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
 *
 * @author Artem Gilmudinov
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Reader in = new Reader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        int[] a;
        int n;

        public void solve(int testNumber, Reader in, PrintWriter out) {
            n = in.ni();
            a = new int[n];
            Helper.fillIntArray(in, a);
            double left, right, mid1, mid2, res1, res2;
            left = -1e5;
            right = 1e5;
            res1 = res2 = 0;
            for (int i = 0; i < 100; i++) {
                mid1 = left + (right - left) / 3;
                mid2 = right - (right - left) / 3;
                res1 = check(mid1);
                res2 = check(mid2);
                if (res1 >= res2) {
                    left = mid1;
                } else {
                    right = mid2;
                }
            }
            out.println(String.format("%.12f", res1));
        }

        public double check(double x) {
            double prevMin, prevMax;
            prevMin = prevMax = a[0] - x;
            double min = prevMin;
            double max = prevMax;
            for (int i = 1; i < n; i++) {
                prevMin = Math.min(prevMin + a[i] - x, a[i] - x);
                prevMax = Math.max(prevMax + a[i] - x, a[i] - x);
                min = Math.min(min, prevMin);
                max = Math.max(max, prevMax);
            }
            return Math.max(Math.abs(min), Math.abs(max));
        }

    }

    static class Helper {
        public static void fillIntArray(Reader in, int[] a) {
            for (int i = 0; i < a.length; i++) {
                a[i] = in.ni();
            }
        }

    }

    static class Reader {
        private BufferedReader in;
        private StringTokenizer st = new StringTokenizer("");
        private String delim = " ";

        public Reader(InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(rl());
            }
            return st.nextToken(delim);
        }

        public String rl() {
            try {
                return in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int ni() {
            return Integer.parseInt(next());
        }

    }
}

