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
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        FastScanner in;
        PrintWriter out;
        boolean stress = false;
        final int realA = 123;
        final int realB = 456;

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            this.in = in;
            this.out = out;

            final int BITS = 30;
            int[] ans = new int[4];
            int a = 0;
            int b = 0;
            ans[0] = send(a, b);
            for (int i = BITS - 1; i >= 0; i--) {
                ans[1] = send(a, b | (1 << i));
                ans[2] = send(a | (1 << i), b);

                if (ans[1] == ans[2]) {
                    ans[3] = -ans[0];
                } else {
                    ans[3] = ans[0];
                }
                int cnt = 0;
                for (int bitA = 0; bitA < 2; bitA++) {
                    for (int bitB = 0; bitB < 2; bitB++) {
                        boolean ok = true;
                        for (int mask = 0; mask < 4; mask++) {
                            int xorredA = bitA ^ (mask / 2);
                            int xorredB = bitB ^ (mask % 2);
                            if (xorredA != xorredB && Integer.signum(xorredA - xorredB) != ans[mask]) {
                                ok = false;
                            }
                        }
                        if (ok) {
                            ++cnt;
                            a |= bitA << i;
                            b |= bitB << i;
                            ans[0] = ans[2 * bitA + bitB];
                        }
                    }
                }
                if (cnt != 1) {
                    throw new AssertionError();
                }
            }
            sendAns(a, b);
        }

        private int send(int c, int d) {
            if (stress) {
                return Integer.signum((realA ^ c) - (realB ^ d));
            }
            out.println("? " + c + " " + d);
            out.flush();
            return in.nextInt();
        }

        private void sendAns(int a, int b) {
            out.println("! " + a + " " + b);
            out.flush();
        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

