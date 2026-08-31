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
 * @author Jaynil
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CAddOne solver = new CAddOne();
        solver.solve(1, in, out);
        out.close();
    }

    static class CAddOne {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int max = 2 * 100000 + 100;
//        max = 20;
            long mod = 1_000_000_007;
            long d[] = new long[max];
            d[0] = 1;
            d[10] = 1;
            for (int i = 1; i < max; i++) {
                if (d[i] > 0) {
                    if (i + 9 < max) {
                        d[i + 9] += d[i];
                        d[i + 9] %= mod;
                    }
                    if (i + 10 < max) {
                        d[i + 10] += d[i];
                        d[i + 10] %= mod;
                    }

                }
                d[i] += d[i - 1];
                d[i] %= mod;
            }
//        System.out.println(Arrays.toString(d));
            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();
                int m = in.nextInt();
                long ans = 0;
                while (n > 0) {
                    int temp = n % 10;
                    n /= 10;
                    ans += d[m + temp];
                    ans %= mod;
                }
                out.println(ans);
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

