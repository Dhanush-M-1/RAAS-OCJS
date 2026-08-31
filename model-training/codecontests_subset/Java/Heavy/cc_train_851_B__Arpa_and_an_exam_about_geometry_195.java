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
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int[] A = new int[]{in.nextInt(), in.nextInt()};
            int[] B = new int[]{in.nextInt(), in.nextInt()};
            int[] C = new int[]{in.nextInt(), in.nextInt()};

            if (!collinear(A, B, C) && dist(A, B) == dist(B, C)) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }

        private boolean collinear(int[] a, int[] b, int[] c) {
            //rownanie prostej : (y-y1)(x2-x1) - (y2-y1)(x-x1)==0
            return 1L * (c[1] - a[1]) * (b[0] - a[0]) - 1L * (b[1] - a[1]) * (c[0] - a[0]) == 0;
        }

        private long dist(int[] a, int[] b) {
            long dx = a[0] - b[0];
            long dy = a[1] - b[1];
            return dx * dx + dy * dy;
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

