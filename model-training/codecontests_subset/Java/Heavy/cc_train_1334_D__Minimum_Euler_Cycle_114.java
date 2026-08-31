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
 *
 * @author Itwazonce
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        scan in = new scan(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        minimumeulercycle solver = new minimumeulercycle();
        solver.solve(1, in, out);
        out.close();
    }

    static class minimumeulercycle {
        public void solve(int testNumber, scan in, PrintWriter out) {
            int t = in.scanInt();
            while (t-- > 0) {
                long n = in.scanLong();
                long l = in.scanLong();
                long r = in.scanLong();
                int len = (int) (r - l + 1);
                long ans[] = new long[len];
                int k = 0;
                long total = 0;
                for (long i = 1; k < len && i <= n; i++) {
                    total = 2 * (i * n - (i * (i + 1)) / 2);
                    if (l <= total) {
                        total -= 2 * (n - i);
                        for (long j = i + 1; k < ans.length && j <= n; j++) {
                            total++;
                            if (l <= total && total <= r) {
                                ans[k++] = i;
                            }
                            total++;
                            if (l <= total && total <= r) {
                                ans[k++] = j;
                            }
                        }
                    }

                }


                for (int i = 0; i < ans.length; i++) {
                    if (ans[i] == 0)
                        ans[i] = 1;
                    out.print(ans[i] + " ");
                }
                out.println();
            }
        }

    }

    static class scan {
        private byte[] buf = new byte[4 * 1024];
        private int index;
        private BufferedInputStream in;
        private int total;

        public scan(InputStream inputStream) {
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
                if (total <= 0)
                    return -1;
            }
            return buf[index++];
        }

        public int scanInt() {
            int integer = 0;
            int n = scan();
            while (isWhiteSpace(n))
                n = scan();
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
//            else throw new InputMismatchException();
            }
            return neg * integer;
        }

        public long scanLong() {
            long lon = 0;
            int n = scan();
            while (isWhiteSpace(n))
                n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n) && n != '.') {
                if (n >= '0' && n <= '9') {
                    lon *= 10;
                    lon += n - '0';
                    n = scan();
                }
//            else throw new InputMismatchException();
            }
            return lon * neg;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
                return true;
            return false;
        }

    }
}

