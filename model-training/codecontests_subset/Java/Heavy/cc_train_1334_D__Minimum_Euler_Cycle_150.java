import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DMinimumEulerCycle solver = new DMinimumEulerCycle();
        solver.solve(1, in, out);
        out.close();
    }

    static class DMinimumEulerCycle {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int t = in.scanInt();
            loop:
            while (t-- > 0) {
                int n = in.scanInt();
                long l = in.scanLong();
                long r = in.scanLong();
                long m = r - l + 1;
                long last = (long) n * (n - 1) + 1;
                if (m == 1 && l == r && r == last) {
                    out.println(1);
                    continue loop;
                }


                int arr[] = new int[n + 1];
                long pre[] = new long[n + 1];
                arr[1] = (n - 1) * 2;
                for (int i = 2; i <= n; i++) arr[i] = arr[i - 1] - 2;
                for (int i = 1; i <= n; i++) pre[i] = arr[i] + pre[i - 1];
                int a = 0;
                for (int i = 1; i <= n - 1; i++) if (pre[i] < l) a = i;
                a++;
                long next = l - pre[a - 1];
                long b = a + ((next / 2) + (next % 2));
                int turn = (int) (l % 2);

                for (int i = 0; i < m; i++) {
                    if (i == m - 1 && r == last) {
                        out.print(1);
                        break;
                    }
                    if (turn == 1) {
                        out.print(a + " ");
                    } else {
                        out.print(b + " ");
                        b++;
                        if (b == (n + 1)) {
                            a++;
                            b = a + 1;
                        }
                    }
                    turn ^= 1;
                }

                out.println();

                // 1 2 1 3 2 3
//            1 2 1 3 1 4 1 5 2 3 2 4 2 5 3 4 3 5 4 5

            }
        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int INDEX;
        private BufferedInputStream in;
        private int TOTAL;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (INDEX >= TOTAL) {
                INDEX = 0;
                try {
                    TOTAL = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TOTAL <= 0) return -1;
            }
            return buf[INDEX++];
        }

        public int scanInt() {
            int I = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    I *= 10;
                    I += n - '0';
                    n = scan();
                }
            }
            return neg * I;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

        public long scanLong() {
            long I = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    I *= 10;
                    I += n - '0';
                    n = scan();
                }
            }
            return neg * I;
        }

    }
}

