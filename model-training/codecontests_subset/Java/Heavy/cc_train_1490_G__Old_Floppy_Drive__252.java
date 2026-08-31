import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.TreeMap;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Spandan Mishra
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        GOldFloppyDrive solver = new GOldFloppyDrive();
        solver.solve(1, in, out);
        out.close();
    }

    static class GOldFloppyDrive {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.readInt();
            StringBuilder sb = new StringBuilder();
            while (t-- > 0) {
                int n = in.readInt(), m = in.readInt();
                int[] a = new int[n], q = new int[m];
                for (int i = 0; i < n; i++)
                    a[i] = in.readInt();

                TreeMap<Long, Long> map = new TreeMap<>();
                long sec = 0, ps = 0, prev = 0;
                for (int i = 0; i < n; i++) {
                    ps += a[i];
                    if (ps > prev) {
                        prev = ps;
                        map.put(ps, sec);
                    }
                    sec++;
                }


//            System.out.println("MAP --> " + map + "\nps = " + ps);

                for (int i = 0; i < m; i++) {
                    q[i] = in.readInt();
                    if (!map.isEmpty() && q[i] <= map.lastKey()) {
                        sb.append(map.ceilingEntry((long) q[i]).getValue() + " ");
                        continue;
                    }
                    if (ps <= 0) {
                        sb.append("-1 ");
                        continue;
                    }
                    long k = (q[i] - map.lastKey() + ps - 1) / ps;
                    Long h0 = map.ceilingKey(q[i] - k * ps);
                    sb.append(k * n + map.get(h0) + " ");
                }
                sb.append("\n");
            }

            System.out.print(sb);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new RuntimeException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

