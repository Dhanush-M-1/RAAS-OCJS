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
 * @author Anand Iyer
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public static long dist(long x1, long x2, long y1, long y2) {
            return (x1 - y1) * (x1 - y1) + (x2 - y2) * (x2 - y2);
        }

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            long ax = in.nextLong();
            long ay = in.nextLong();
            long bx = in.nextLong();
            long by = in.nextLong();
            long cx = in.nextLong();
            long cy = in.nextLong();
            if ((double) (ay - by) / (ax - bx) == (double) (ay - cy) / (ax - cx)) {
                out.println("No");
            } else {
                if (dist(ax, ay, bx, by) == dist(bx, by, cx, cy)) {
                    out.println("Yes");
                } else {
                    out.println("No");
                }
            }
        }

    }

    static class FastScanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public FastScanner(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

