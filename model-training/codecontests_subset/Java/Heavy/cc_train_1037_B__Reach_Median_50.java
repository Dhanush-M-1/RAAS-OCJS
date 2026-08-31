import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author nirav
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scan in = new Scan(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        BReachMedian solver = new BReachMedian();
        solver.solve(1, in, out);
        out.close();
    }

    static class BReachMedian {
        public void solve(int testNumber, Scan in, PrintWriter out) {
            int n = in.scanInt();
            long s = in.scanLong();
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.scanLong();
            }
            int k = n / 2;
            Arrays.sort(a);
            long ans = 0;
            for (int i = 0; i < k; i++) {
                if (a[i] > s) {
                    ans += (a[i] - s);
                }
            }
            ans += Math.abs(a[k] - s);
            for (int i = k + 1; i < n; i++) {
                if (a[i] < s) {
                    ans += (s - a[i]);
                }
            }
            out.println(ans);
        }

    }

    static class Scan {
        private byte[] buf = new byte[4 * 1024];
        private int INDEX;
        private BufferedInputStream in;
        private int TOTAL;

        public Scan(InputStream inputStream) {
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

