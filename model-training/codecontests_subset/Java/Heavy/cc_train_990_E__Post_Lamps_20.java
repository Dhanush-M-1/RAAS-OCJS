import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyScan in = new MyScan(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, MyScan in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            boolean[] blocked = new boolean[n];
            for (int f = 0; f < m; f++) {
                blocked[in.nextInt()] = true;
            }
            int[] prices = in.na(k);
            if (blocked[0]) {
                out.println(-1);
                return;
            }

            int[] prev = new int[n];

            for (int s = 1; s < n; s++) {
                if (blocked[s]) {
                    prev[s] = prev[s - 1];
                } else {
                    prev[s] = s;
                }
            }

            long best = Long.MAX_VALUE;

            for (int s = 1; s <= k; s++) {
                int pos = 0;
                long price = prices[s - 1];
                while (pos + s < n) {
                    if (prev[pos + s] == pos) {
                        price = Long.MAX_VALUE;
                        break;
                    }
                    pos = prev[pos + s];
                    price += prices[s - 1];
                }


                best = Math.min(best, price);
            }


            if (best == Long.MAX_VALUE) {
                out.println(-1);
            } else {
                out.println(best);
            }

        }

    }

    static class MyScan {
        private final InputStream in;
        private byte[] inbuf = new byte[1024];
        public int lenbuf = 0;
        public int ptrbuf = 0;

        public MyScan(InputStream in) {
            this.in = in;
        }

        private int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = in.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        public int[] na(int n) {
            int[] k = new int[n];
            for (int i = 0; i < n; i++) {
                k[i] = nextInt();
            }
            return k;
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

    }
}

