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
 * @author koneko096
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        GOldFloppyDrive solver = new GOldFloppyDrive();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class GOldFloppyDrive {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt(), m = in.nextInt();
            long[] P = new long[n];
            for (int i = 0; i < n; i++) {
                P[i] = in.nextInt();
            }
            for (int i = 1; i < n; i++) {
                P[i] += P[i - 1];
            }
            assert (m > 0);
            assert (n > 0);
            long S = P[n - 1];
            for (int i = 1; i < n; i++) {
                P[i] = Math.max(P[i], P[i - 1]);
            }

            do {
                m--;
                long x = in.nextInt();
                if (S <= 0 && P[n - 1] < x) {
                    out.print("-1 ");
                    continue;
                }
                long d = (S > 0) ? Math.max((x - P[n - 1] + S - 1), 0) / S : 0;
                long ans = d * n;
                x -= d * S;
                ans += lowerBound(P, n, x);
                out.print(ans);
                out.print(' ');
            } while (m > 0);
            out.println();
        }

        private int lowerBound(long[] array, int length, long value) {
            int low = 0;
            int high = length;
            while (low < high) {
                final int mid = (low + high) / 2;
                //checks if the value is less than middle element of the array
                if (value <= array[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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

