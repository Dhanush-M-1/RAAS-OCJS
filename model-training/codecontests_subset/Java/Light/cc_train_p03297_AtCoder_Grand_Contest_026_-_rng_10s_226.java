import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.InputMismatchException;
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
        BRng10s solver = new BRng10s();
        solver.solve(1, in, out);
        out.close();
    }

    static class BRng10s {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                long a = in.nextLong();
                long b = in.nextLong();
                long c = in.nextLong();
                long d = in.nextLong();

                if (a < b || b > d) {
                    out.println("No");
                    continue;
                }

                if (c >= b) {
                    out.println("Yes");
                    continue;
                }

                long gcdBD = Euclid.gcd(b, d);
                long sub = a - ((a - b) / gcdBD + 1) * gcdBD;

                out.println(c < sub && sub < b ? "No" : "Yes");
            }
        }

    }

    static class Euclid {
        public static long gcd(long a, long b) {
            return a == 0 ? b : gcd(b % a, a);
        }

    }

    static class InputReader {
        private BufferedReader br;
        private StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
            st = new StringTokenizer("");
        }

        public String nextString() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine(), " ");
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextString());
        }

        public long nextLong() {
            return Long.parseLong(nextString());
        }

    }
}

