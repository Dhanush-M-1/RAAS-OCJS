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
        DEhabAndAnotherAnotherXorProblem solver = new DEhabAndAnotherAnotherXorProblem();
        solver.solve(1, in, out);
        out.close();
    }

    static class DEhabAndAnotherAnotherXorProblem {
        int[] a;
        int[] b;
        int tl = 0;

        public int query(int pos, int aaa, int bbb, ScanReader in, PrintWriter out) {
            tl++;
            long aa = 0, bb = 0;
            a[pos] = aaa;
            b[pos] = bbb;
            for (int i = 0; i <= pos; i++) {
                aa |= (a[i] << (29 - i));
                bb |= (b[i] << (29 - i));
            }
            a[pos] = 0;
            b[pos] = 0;
            out.println("? " + aa + " " + bb);
            out.flush();
            return in.scanInt();
        }

        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            a = new int[32];
            b = new int[32];
            boolean flag = false;
            int eq = 0;
            for (int i = 0; i < 30; i++) {
                if (!flag) eq = query(i, 0, 0, in, out);
                flag = false;
                if (eq == 1) {
                    int qq = query(i, 1, 1, in, out);
                    if (qq == 1) {
                        int q1 = query(i, 1, 0, in, out);
                        flag = true;
                        if (q1 == 1) a[i] = b[i] = 0;
                        else a[i] = b[i] = 1;
                    } else if (qq == -1) {
                        a[i] = 1;
                        b[i] = 0;
                    } else {
                        throw new RuntimeException("NO");
                    }
                } else if (eq == -1) {
                    int qq = query(i, 1, 1, in, out);
                    if (qq == -1) {
                        int q1 = query(i, 0, 1, in, out);
                        flag = true;
                        if (q1 == -1) a[i] = b[i] = 0;
                        else a[i] = b[i] = 1;
                    } else if (qq == 1) {
                        a[i] = 0;
                        b[i] = 1;
                    } else {
                        throw new RuntimeException("NO");
                    }
                } else {
                    int q1 = query(i, 1, 0, in, out);
                    flag = true;
                    if (q1 == 1) a[i] = b[i] = 0;
                    else a[i] = b[i] = 1;
                }
            }
            int ansa = 0, ansb = 0;
            for (int i = 0; i < 30; i++) {
                ansa |= (a[i] << (29 - i));
                ansb |= (b[i] << (29 - i));
            }
            if (tl > 62) throw new RuntimeException("NO");

            out.println("! " + ansa + " " + ansb);
            out.flush();
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

