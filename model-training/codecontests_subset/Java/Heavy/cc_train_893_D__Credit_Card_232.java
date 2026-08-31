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
        d893 solver = new d893();
        solver.solve(1, in, out);
        out.close();
    }

    static class d893 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int d = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            long[] balance = new long[n];
            balance[0] = a[0];
            for (int i = 1; i < n; i++) {
                balance[i] = balance[i - 1] + a[i];
            }
            long[] balanceMax = new long[n];
            balanceMax[n - 1] = balance[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                balanceMax[i] = Math.max(balance[i], balanceMax[i + 1]);
            }
            int ans = 0;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (balance[i] + sum > d) {
                    out.println(-1);
                    return;
                }
                if (a[i] == 0 && balance[i] + sum < 0) {
                    long maxBal = sum + balanceMax[i];
                    long add = d - maxBal;
                    if (balance[i] + sum + add < 0) {
                        out.println(-1);
                        return;
                    }
                    sum += add;
                    ans++;
                }
            }
            out.println(ans);
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer stt;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public String next() {
            while (stt == null || !stt.hasMoreTokens()) {
                stt = new StringTokenizer(nextLine());
            }
            return stt.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

