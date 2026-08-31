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
 * @author Yogesh Kumar a.k.a DREAMPLAY
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
        boolean collinear(long x1, long y1, long x2, long y2, long x3, long y3) {
//        System.out.println("Hi");
            if (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2) == 0) {
                return true;
            } else {
                return false;
            }
        }

        long dist(long x1, long y1, long x2, long y2) {
            return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long x1, x2, x3, y1, y2, y3;
            x1 = in.nextInt();
            y1 = in.nextInt();
            x2 = in.nextInt();
            y2 = in.nextInt();
            x3 = in.nextInt();
            y3 = in.nextInt();
            if (collinear(x1, y1, x2, y2, x3, y3) || collinear(x1, y1, x3, y3, x2, y2) || collinear(x2, y2, x1, y1, x3, y3)) {
                out.print("No");
            } else {
                if (dist(x1, y1, x2, y2) != dist(x2, y2, x3, y3)) {
                    out.print("No");
                } else {
                    out.print("Yes");
                }
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

