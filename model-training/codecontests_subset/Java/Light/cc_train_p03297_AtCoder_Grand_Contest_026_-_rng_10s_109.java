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
 * @author kessido
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        BRng10s solver = new BRng10s();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class BRng10s {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long a = in.NextLong();
            long b = in.NextLong();
            long c = in.NextLong();
            long d = in.NextLong();
            String YES = "Yes";
            String NO = "No";
            boolean can = true;
            if (a < b) {
                can = false;
            } else if (d < b) {
                can = false;
            } else {
                d %= b;
                if (c + 1 < b) {
                    a %= b;
                    if (a >= c + 1) can = false;
                    else {
                        if (d != 0) {
                            a += ((b - 1 - a) / d) * d;
                            if (a >= c + 1) can = false;
                            else {
                                long x = MathExtensions.gcd(b, d);
                                a += ((b - 1 - a) / x) * x;
                                if (a >= c + 1) can = false;
                            }
                        }
                    }
                }
            }
            if (can) {
                out.println(YES);
            } else out.println(NO);
        }

    }

    static class MathExtensions {
        public static long gcd(final long a, final long b) {
            if (a == 0)
                return b;
            return gcd(b % a, a);
        }

    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine(), " \t\n\r\f,");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long NextLong() {
            return Long.parseLong(next());
        }

    }
}

