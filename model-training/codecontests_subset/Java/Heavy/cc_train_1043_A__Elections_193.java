import java.io.*;
import java.util.*;

/**
 * @author gamezovladislav
 */

public class TaskA {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Solve solve = new Solve(in, out);
        solve.solve();
        out.close();
    }

    private static class Solve {

        private final InputReader in;
        private final PrintWriter out;

        public Solve(InputReader in, PrintWriter out) {
            this.in = in;
            this.out = out;
        }

        public void solve() {
            int n = in.nextInt();
            int s = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                max = StrictMath.max(max, x);
                s += x;
            }
            int y = max * n - s;
            while (y <= s) {
                max++;
                y += n;
            }
            out.print(max);
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
