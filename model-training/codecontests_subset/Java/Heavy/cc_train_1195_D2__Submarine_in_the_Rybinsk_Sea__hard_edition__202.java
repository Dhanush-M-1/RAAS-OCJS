import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * @author khokharnikunj8
 */

public class Main {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                new Main().solve();
            }
        }, "1", 1 << 26).start();
    }

    void solve() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        D2SubmarineInTheRybinskSeaHardEdition solver = new D2SubmarineInTheRybinskSeaHardEdition();
        solver.solve(1, in, out);
        out.close();
    }

    static class D2SubmarineInTheRybinskSeaHardEdition {
        long mod = 998244353;

        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            int[] ar = new int[n];
            long ans = 0;
            for (int i = 0; i < n; i++) ar[i] = in.scanInt();
            long[] digit = new long[12];
            for (int i = 0; i < n; i++) {
                digit[String.valueOf(ar[i]).length()]++;
            }

            for (int i = 0; i < n; i++) {
                int num = ar[i];
                long self = 1;
                while (num > 0) {
                    int dig = num % 10;
                    long temp = 10;
                    for (int j = 1; j < 12; j++) {
                        ans = (ans + (((digit[j] * dig % mod) * (Math.min(temp, self) % mod) % mod) * self % mod) % mod) % mod;
                        ans = (ans + (((digit[j] * dig % mod) * (Math.min(temp, self * 10) % mod) % mod) * self % mod) % mod) % mod;
                        temp = (temp * 10);
                    }
                    num /= 10;
                    self = (self * 10);
                }
            }
            if (ans % mod < 0) throw new RuntimeException();
            out.println(ans % mod);
        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int index;
        private BufferedInputStream in;
        private int total;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (index >= total) {
                index = 0;
                try {
                    total = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (total <= 0) return -1;
            }
            return buf[index++];
        }

        public int scanInt() {
            int integer = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                }
            }
            return neg * integer;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

    }
}

