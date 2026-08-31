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
 * @author Abhas Jain
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long a = 0, b = 0;
            long g = 0;
            out.println("? " + a + " " + b);
            out.flush();
            g = in.nl();
            long curr;
            for (long pos = 29; pos >= 0; --pos) {
                out.println("? " + (a + (1L << pos)) + " " + (b + (1L << pos)));
                out.flush();
                curr = in.nl();
                if (curr == g) {
                    out.println("? " + (a + (1 << pos)) + " " + b);
                    out.flush();
                    long c = in.nl();
                    if (c == -1L) {
                        a += (1L << pos);
                        b += (1L << pos);
                    }
                } else {
                    if (g == 1L && curr == -1L) {
                        a += (1 << pos);
                    } else b += (1 << pos);
                    out.println("? " + a + " " + b);
                    out.flush();
                    g = in.nl();
                }
            }
            out.println("! " + a + " " + b);
            out.flush();
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

        public long nl() {
            return Long.parseLong(next());
        }

    }
}

