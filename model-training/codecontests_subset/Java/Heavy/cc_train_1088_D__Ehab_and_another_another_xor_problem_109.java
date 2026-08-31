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
 * @author llamaoo7
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DEhabAndAnotherAnotherXorProblem solver = new DEhabAndAnotherAnotherXorProblem();
        solver.solve(1, in, out);
        out.close();
    }

    static class DEhabAndAnotherAnotherXorProblem {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int a = 0;
            int b = 0;
            int ra;
            int rb;
            int cur;
            out.println("? 0 0");
            out.flush();
            boolean prev = in.nextInt() == 1;
            int n = 30;
            for (int i = 0; i < n; i++) {
                cur = (1 << (n - i - 1));
                out.println("? " + (a ^ cur) + " " + b);
                out.flush();
                ra = in.nextInt();
                if (ra == -2) return;
                out.println("? " + a + " " + (b ^ cur));
                out.flush();
                rb = in.nextInt();
                if (rb == -2) return;
                if (ra == rb) {
                    if (prev) a |= cur;
                    else b |= cur;
                    prev = ra == 1;
                } else {
                    if (rb == 1) {
                        a |= cur;
                        b |= cur;
                    }
                }
            }
            out.println("! " + a + " " + b);
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

