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
        EPostLamps solver = new EPostLamps();
        solver.solve(1, in, out);
        out.close();
    }

    static class EPostLamps {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            int m = in.scanInt();
            int k = in.scanInt();
            boolean[] done = new boolean[n];
            for (int i = 0; i < m; i++) done[in.scanInt()] = true;
            int maximum = 0;
            int continuous = 0;
            for (int i = 0; i < n; i++) {
                if (done[i]) continuous++;
                else continuous = 0;
                maximum = Math.max(continuous, maximum);
            }
            int[] power = new int[k + 1];
            for (int i = 1; i <= k; i++) {
                power[i] = in.scanInt();
            }
            if (maximum + 1 > k || done[0]) {
                out.println(-1);
                return;
            }
            int[] free = new int[n];
            int next = n + 1;
            for (int i = n - 1; i >= 0; i--) {
                if (!done[i]) next = i;
                free[i] = next;
            }
            long ans = Long.MAX_VALUE;
            for (int i = maximum + 1; i <= k; i++) {
                int step = 0;
                int from = n - 1;
                while (from >= 0) {
                    step++;
                    int which = Math.max(0, from - i + 1);
                    if (!done[which]) {
                        from = which - 1;
                    } else {
                        from = free[which] - 1;
                    }
                }
                ans = Math.min(ans, (long) step * power[i]);
            }
            out.println(ans);

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

