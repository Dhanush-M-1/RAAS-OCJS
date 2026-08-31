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
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public long dist(Point a, Point b) {
            long xdiff = a.x - b.x;
            long ydiff = a.y - b.y;
            return xdiff * xdiff + ydiff * ydiff;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            Point[] pts = new Point[3];
            for (int i = 0; i < 3; ++i) {
                pts[i] = new Point(in.nextInt(), in.nextInt());
            }
            long distAB = dist(pts[0], pts[1]);
            long distBC = dist(pts[1], pts[2]);
            if (distAB == distBC && !line(pts)) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }

        long gcd(long a, long b) {
            if (a < 0 ^ b < 0) {
                return -(b == 0 ? Math.abs(a) : gcd(Math.abs(b), Math.abs(a) % Math.abs(b)));
            } else {
                return b == 0 ? a : gcd(b, a % b);
            }
        }

        private boolean line(Point[] pts) {
            Point a = pts[0], b = pts[1], c = pts[2];
            if (a.x == b.x && b.x == c.x) return true;
            long xslope1 = a.x - b.x;
            long yslope1 = a.y - b.y;
            long gcd1 = gcd(xslope1, yslope1);

            long xslope2 = a.x - c.x;
            long yslope2 = a.y - c.y;
            long gcd2 = gcd(xslope2, yslope2);

            return xslope1 / gcd1 == xslope2 / gcd2 &&
                    yslope1 / gcd1 == yslope2 / gcd2;
        }

        class Point {
            long x;
            long y;

            Point(long xx, long yy) {
                x = xx;
                y = yy;
            }

        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

