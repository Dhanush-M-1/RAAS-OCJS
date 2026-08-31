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
 * @author Allen Li
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
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            TaskB.Point a = new TaskB.Point(in.nextInt(), in.nextInt());
            TaskB.Point b = new TaskB.Point(in.nextInt(), in.nextInt());
            TaskB.Point c = new TaskB.Point(in.nextInt(), in.nextInt());
            TaskB.Point d = b.subtract(a);
            TaskB.Point e = c.subtract(b);
            if (d.crossProduct(e) == 0)
                out.println("No");
            else
                out.println(d.magnitude2() == e.magnitude2() ? "Yes" : "No");
        }

        public static final class Point {
            long x;
            long y;

            public Point(long x, long y) {
                this.x = x;
                this.y = y;
            }

            public TaskB.Point subtract(TaskB.Point point) {
                return new TaskB.Point(x - point.x, y - point.y);
            }

            public long magnitude2() {
                return x * x + y * y;
            }

            public long crossProduct(TaskB.Point point) {
                return point.x * y - point.y * x;
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

